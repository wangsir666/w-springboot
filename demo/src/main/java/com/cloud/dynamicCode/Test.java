package com.cloud.dynamicCode;

import jdk.nashorn.internal.ir.CallNode;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import javax.tools.JavaCompiler;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @auther: wjx
 * @Date: 2020/12/7 13:58
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws Exception{
        //使用jdk自带的rt.jar中的javax.tools包提供的编译器
//        test1();
        //使用Runtime执行javac命令
//        test2();
//        test3();
//        test4();
//        test5();
        test_ok();
    }

    //下面是需要动态编译的代码
//    import com.cloud.dynamicCode.Person;
//    /**
//     * @auther: wjx
//     * @Date: 2020/12/7 14:04
//     * @Description:
//     */
//    public class PersonTest {
//
//        public static void main(String[] args) {
//            Person person = new Person(1L,"aaa");
//            person.swim();
//        }
//    }

    private static void test_ok() throws Exception{
        String code=
                "package com.cloud.dynamicCode;" +
                "import com.cloud.dynamicCode.Person;\n" +
                "public class PersonTest {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        Person person = new Person(1L,\"bbb\");\n" +
                "        person.swim();\n" +
                "    }\n" +
                "}\n";
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, Locale.CHINA, Charset.defaultCharset());
        String className =
                "com.cloud.dynamicCode."+
                "PersonTest";
        JavaFileObject obj = new CharSequenceJavaFileObject(className, code);
        Set<JavaFileObject> fileObjects = Collections.singleton(obj);
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, fileObjects);
        Boolean compileResult = task.call();
        if(compileResult){
            System.out.println("compile success...");
//            ClassLoader classLoader = ToolProvider.getSystemToolClassLoader();
            ClassLoader classLoader = Test.class.getClassLoader();
            Class<?> personTest = classLoader.loadClass(className);
            Method mainMethod = personTest.getMethod("main", new Class[]{String[].class});
            mainMethod.invoke(null, new Object[]{null});
        }

    }

    public static String inputCode = "public class UserFuck" +
            " { public static void test(){System.out.println(\"Hello444\");}}";
    private static void test5() throws Exception{
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, Locale.CHINA, StandardCharsets.UTF_8);
        // dynamic/generation is the based folder for generated code package
        File file = new File("com/cloud");
        if (file.exists() && file.isFile()) {
            throw new IllegalStateException("package folder is a file");
        } else if (!file.exists()) {
            boolean flag = file.mkdirs();
            if (!flag) {
                throw new IllegalStateException("create package's folder failure.");
            }
        }
        // can cache value, and if exists .class, ignore
//        String className = parseClassName(inputCode);
//        String className = "com.cloud.dynamicCode.UserFuck";
        String className = "UserFuck";
        StringSourceJavaObject sourceObject = new StringSourceJavaObject(className, Test.inputCode);
        List<StringSourceJavaObject> objects = Collections.singletonList(sourceObject);
        // define output dir
        List<String> options = Arrays.asList("-d", "./");
        JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, options, null, objects);
        Boolean compilerResult = task.call();
        if (compilerResult) {
            System.out.println("compile success");
            ClassLoader classLoader = Test.class.getClassLoader();
            // this throws ClassNotFoundException
            Class<?> userFuck = classLoader.loadClass(className);
            Method test = userFuck.getMethod("test");
            test.invoke(userFuck.newInstance());
        }
    }
    static String parseClassName(String inputCode) {
        Pattern packagePattern = Pattern.compile("package\\s+(\\S+);\\s*");
        Matcher packageMatcher = packagePattern.matcher(inputCode);
        if (!packageMatcher.find()) {
            throw new IllegalArgumentException("input code is invalid.");
        }
        String packageName = packageMatcher.group(1);
        System.out.println("package: " + packageName);
        Pattern classSimpleNamePatter = Pattern.compile("public\\s+class\\s+(\\w+)\\s+\\{");
        Matcher classSimpleNameMatcher = classSimpleNamePatter.matcher(inputCode);
        if (!classSimpleNameMatcher.find()) {
            throw new IllegalArgumentException("input code is invalid.");
        }
        String classSimpleName = classSimpleNameMatcher.group(1);
        System.out.println("className: " + classSimpleName);
        return packageName + "." + classSimpleName;
    }

    static class StringSourceJavaObject extends SimpleJavaFileObject {

        private final String sourceCode;

        public StringSourceJavaObject(String className, String sourceCode) {
            // DynamicCodeGen.UserFuck . to /
            super(URI.create("string:///" + className.replace(".", "/") + Kind.SOURCE.extension), Kind.SOURCE);
            this.sourceCode = sourceCode;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) {
            return this.sourceCode;
        }
    }

    private static void test4() throws Exception{
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manager = compiler.getStandardFileManager(null, Locale.CHINA, StandardCharsets.UTF_8);

        String className = "Hello";
        String code ="public class Hello { public void sayHello(){System.out.println(\"####\");}}";

//        String className = "com.cloud.dynamicCode.PersonMain";
//        String code="package com.cloud.dynamicCode;" +
//                "import com.cloud.dynamicCode.Person;\n" +
//                "public class PersonMain {\n" +
//                "\n" +
//                "    public static void main(String[] args) {\n" +
//                "        Person person = new Person(1L,\"bbb\");\n" +
//                "        person.swim();\n" +
//                "    }\n" +
//                "}\n";
        JavaFileObject obj = new CharSequenceJavaFileObject(className, code);
        List<JavaFileObject> javaFileObjects = Collections.singletonList(obj);
        JavaCompiler.CompilationTask compilerTask = compiler.getTask(null, manager, null, null, null, javaFileObjects);
//        List<String> options = Arrays.asList("-d", "./");
//        JavaCompiler.CompilationTask compilerTask = compiler.getTask(null, manager, null, options, null, javaFileObjects);
        Boolean compilerResult = compilerTask.call();
        if (compilerResult) {
            System.out.println("compile success");
            ClassLoader classLoader = Test.class.getClassLoader();
            Class<?> hello = classLoader.loadClass(className);
            Method sayHello = hello.getMethod("sayHello");
            sayHello.invoke(hello.newInstance());
        }




    }

    private static void test3() throws Exception {
        DynamicEngine dynamicEngine = DynamicEngine.getInstance();
        String className = "Hello";
        String javaCode = "public class Hello { public void sayHello(){System.out.println(\"####\");}}";
        for(int i=0;i<10;i++){
            String str = javaCode.replace("####", "hello world"+i);
            Object obj = dynamicEngine.compiler(className,str);
            obj.getClass().getMethod("sayHello").invoke(obj);
        }

    }

    private static void test2() {
        String javaAbsolutePath = "D:/test/PersonMain.java";
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("javac -classpath D:/test/ " + javaAbsolutePath);

            InputStream inputStream = process.getInputStream();
            inputStream = new FileInputStream("D:/test/PersonMain.class");
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            byte[] buffer = new byte[1024];
            int length = 0;
            while((length=bis.read(buffer))!=-1){
                System.out.println(new String(buffer, 0, length));
            }


            //编译在当前文件夹下生成.class文件
//            InputStream errorStream = process.getErrorStream();
//            InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            String line = null;
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//            int exitVal = process.waitFor();
//            System.out.println("Process exitValue: " + exitVal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test1() {
        String javaAbsolutePath = "D:/test/Person.java";
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, "-encoding", "UTF-8", "-classpath", javaAbsolutePath, javaAbsolutePath);
    }
}
