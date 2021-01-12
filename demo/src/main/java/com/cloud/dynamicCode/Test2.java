package com.cloud.dynamicCode;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Locale;
import java.util.Set;

/**
 * @auther: wjx
 * @Date: 2020/12/7 20:23
 * @Description:
 */
public class Test2 {

    public static void main(String[] args) throws Exception {
        test1();
//        test2();
    }

    private static void test2() throws Exception{
        String code="package com.cloud.dynamicCode;" +
                "import com.cloud.dynamicCode.Person;\n" +
                "public class PersonMain {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        Person person = new Person(1L,\"bbb\");\n" +
                "        person.swim();\n" +
                "    }\n" +
                "}\n";
        String className = "com.cloud.dynamicCode.PersonMain";
        ClassLoader myClassLoader = new MyClassLoader(code);
        myClassLoader.loadClass(className);
    }

    private static void test1() throws Exception{
        String code="package com.cloud.dynamicCode;" +
                "import com.cloud.dynamicCode.Person;\n" +
                "public class PersonMain {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        Person person = new Person(1L,\"bbb\");\n" +
                "        person.swim();\n" +
                "    }\n" +
                "}\n";
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, Locale.CHINA, Charset.defaultCharset());
        String className = "com.cloud.dynamicCode.PersonMain";
        JavaFileObject obj = new CharSequenceJavaFileObject(className, code);
        Set<JavaFileObject> fileObjects = Collections.singleton(obj);
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, fileObjects);
        Boolean compileResult = task.call();
        if(compileResult){
            System.out.println("compile success...");
            ClassLoader classLoader = ToolProvider.getSystemToolClassLoader();
            Class<?> personMain = classLoader.loadClass(className);
            String[] ss = new String[]{};
            Method mainMethod = personMain.getMethod("main", new Class[]{String[].class});
            mainMethod.invoke(null, new Object[]{null});
        }

    }
    static class MyClassLoader extends ClassLoader{
        public MyClassLoader(String code){
            this.code=code;
        }
        private String code;

        public void setCode(String code) {
            this.code = code;

        }

        @Override
        public Class<?> loadClass(String className) throws ClassNotFoundException {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, Locale.CHINA, Charset.defaultCharset());
            JavaFileObject obj = new CharSequenceJavaFileObject(className, code);
            Set<JavaFileObject> fileObjects = Collections.singleton(obj);
            //编译并加载java代码
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, fileObjects);
            task.call();
            Class<?> aClass = findClass(className);
            try{
                Method mainMethod = aClass.getMethod("main", new Class[]{String[].class});
                mainMethod.invoke(null, new Object[]{null});
            }catch(Exception e){
                e.printStackTrace();
            }
            return aClass;
        }
    }
}
