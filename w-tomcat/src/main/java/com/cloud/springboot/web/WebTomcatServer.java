package com.cloud.springboot.web;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;

import java.io.File;

import static com.cloud.springboot.utils.ThreadUtil.getThreadName;

/**
 * @Auther: wjx
 * @Date: 2020/10/26 19:43
 * @Description:
 * 访问方式：
 *  rest请求：http://localhost:8888/hello
 *  请求indx.html  http://localhost:8888/index.html
 *  请求index并跳转到指定页面，http://localhost:8888/index.jsp
 */
public class WebTomcatServer {
    private static int PORT = 8888;

    private static String CONTEXT_PATH = "/wtomcat";

    public static String WEB_APP_PATH = "src/main";

    private static String RESOURCES_PATH = "target/classes";

    private static String WEB_INF_CLASSES_PATH = "/WEB-INF/classes";

    public static void start()throws Exception{
        start(PORT);
    }
    public static void start(int port) throws Exception {
        System.out.println(getThreadName()+"开始启动tomcat。。。。");

        //创建服务
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);

        //读取项目路径，加载静态资源,注意配置视图解析器的时候前缀
        StandardContext webApp = (StandardContext)tomcat.addWebapp(CONTEXT_PATH, new File(WEB_APP_PATH).getAbsolutePath());
        //Tomcat设置自动检测和加载变化了的类
        webApp.setReloadable(false);

        //读取class文件位置
        File webInfoClasses = new File(RESOURCES_PATH);
        //创建webroot
        WebResourceRoot resource  = new StandardRoot(webApp);
        //tomcat读取class文件执行（创建虚拟的文件目录）
        resource.addPreResources(new DirResourceSet(resource,WEB_INF_CLASSES_PATH, webInfoClasses.getAbsolutePath(), "/"));




        tomcat.start();
        System.out.println(getThreadName()+"tomcat成功。。。。");
        tomcat.getServer().await();
    }

}
