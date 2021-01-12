package com.magic.ioc.utils;

import com.magic.ioc.service.UserService;
import com.magic.test.A;

import java.io.File;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @auther: wjx
 * @Date: 2020/10/31 17:34
 * @Description: 注解帮助类
 */
public class IocUtil {
    public static void main(String[] args) {
//        String dir = System.getProperty("user.dir");
//        List<String> allClass = getAllClass(new File("src/main").getAbsolutePath());

//        List<String> allClass = getAllClass(System.getProperty("user.dir"));
//        allClass.forEach((s) -> {
//            System.out.println(s);
//        });
//        System.out.println(getAllImplClass(UserService.class));
        System.out.println(getAllImplClass(A.class));
    }

    /**
     * @author wjx
     * @Description 获取接口的所有实现类 -该项目只获取当前项目的实现类
     * 获取当前项目下以及依赖改项目的接口实现类 https://www.cnblogs.com/wangzhen-fly/p/11002814.html
     * @Date 2020-10-31 17:38:26
     */
    public static List<Class> getAllImplClass(Class clazz) {
        List<Class> list = new ArrayList<>();
        // 判断是否是一个接口
        if (clazz.isInterface()) {
            try {
                List<Class> allClass = getAllClass(getAllLoaderClassName(clazz.getPackage().getName()));
                /**
                 * 循环判断路径下的所有类是否实现了指定的接口 并且排除接口类自己
                 */
                for (int i = 0; i < allClass.size(); i++) {
                    /**
                     * 判断是不是同一个接口
                     */
                    // isAssignableFrom:判定此 Class 对象所表示的类或接口与指定的 Class
                    // 参数所表示的类或接口是否相同，或是否是其超类或超接口
                    if (clazz.isAssignableFrom(allClass.get(i))) {
                        if (!clazz.equals(allClass.get(i))) {
                            // 自身并不加进去
                            list.add(allClass.get(i));
                        }
                    }
                }
            } catch (Exception e) {
//                log.error("出现异常{}",e.getMessage());
                throw new RuntimeException("出现异常" + e.getMessage());
            }
        }
//        log.info("class list size :"+list.size());
        return list;
    }

    public static List<Class> getAllClass(List<String> classNameList) {
        List<Class> result = new ArrayList<>();
        try {
            for (String className : classNameList) {
                result.add(Class.forName(className));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * @author wjx
     * @Description 通过ClassLoader 自动获取当前运行的上下文
     * classLoader.getResource 获得的 资源目录 是个URL对象，如何转换成JarFile对象?
     * JarURLConnection jarURLConnection = (JarURLConnection)url.openConnection();
     * JarFile jarFile = jarURLConnection.getJarFile();
     * @Date 2020-10-31 20:32:12
     */
    public static List<String> getAllLoaderClassName(String packageName) {
        List<String> fileNames = null;
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        String packagePath = packageName.replace(".", "/");
        URL url = loader.getResource(packagePath);
        if (url != null) {
            String type = url.getProtocol();
            if (type.equals("file")) {
                String fileSearchPath = url.getPath();
                fileSearchPath = fileSearchPath.substring(0, fileSearchPath.indexOf("/classes"));
                fileNames = getAllClassNameInPath(fileSearchPath);
            } else if (type.equals("jar")) {
                try {
                    JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                    JarFile jarFile = jarURLConnection.getJarFile();
                    fileNames = getAllClassNameInJarFile(jarFile);
                } catch (java.io.IOException e) {
                    throw new RuntimeException("open Package URL failed：" + e.getMessage());
                }

            } else {
                throw new RuntimeException("file system not support! cannot load MsgProcessor！");
            }
        }
        return fileNames;
    }

    /**
     * @author wjx
     * @Description 获取jar包下的所有的类的全路径
     * @Date 2020-10-31 20:08:38
     */
    public static List<String> getAllClassNameInJarFile(JarFile jarFile) {
        List<String> result = new ArrayList<>();
        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry jarEntry = entries.nextElement();
            String entryName = jarEntry.getName();
            if (entryName.endsWith(".class")) {
                result.add(entryName.replace("/", ".").substring(0, entryName.lastIndexOf(".")));
            }
        }
        return result;
    }

    /**
     * @return 返回的list不会为null，可能为空
     * @author wjx
     * @Description 获取path目录及子目录下的所有类的全路径
     * @Date 2020-10-31 19:07:33
     */
    public static List<String> getAllClassNameInPath(String path) {
        List<String> result = new ArrayList<>();
        //当前目录下的所有文件&文件夹
        File[] childs = new File(path).listFiles();
        if(childs==null){
            return result;
        }
        //遍历所有文件&文件夹
        for (File child : childs) {
            String cPath = child.getPath();
            if (child.isDirectory()) {
                //遍历文件夹
                result.addAll(getAllClassNameInPath(cPath));
            } else {
                //添加当前目录下的所有文件
                if (cPath.endsWith(".class")) {
                    cPath = cPath.substring(cPath.indexOf("\\classes") + 9, cPath.lastIndexOf("."))
                            .replace("\\", ".");
                    result.add(cPath);
                }
            }
        }
        return result;
    }

}
