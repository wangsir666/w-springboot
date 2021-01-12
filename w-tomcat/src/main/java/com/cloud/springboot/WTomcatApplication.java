package com.cloud.springboot;

//import com.cloud.springboot.servlet.AppCoreServlet;
//import com.cloud.springboot.web.WTomcatServer;
//import org.apache.catalina.LifecycleException;
//import org.apache.catalina.core.StandardContext;
//import org.apache.catalina.startup.Tomcat;

import com.cloud.springboot.web.WTomcatServer;
import com.cloud.springboot.web.WebTomcatServer;

import java.io.File;

import static com.cloud.springboot.web.WebTomcatServer.WEB_APP_PATH;

public class WTomcatApplication {
    public static void main(String[] args)throws Exception {
//        WTomcatServer.startApp(9999);
        WebTomcatServer.start(8888);
//        File file = new File(WEB_APP_PATH);
//        System.out.println(file.getAbsolutePath());

    }

//    private static int PORT = 8080;
//    private static String CONTEX_PATH = "/demosevlet";
//    private static String SERVLET_NAME = "index";
//    private static String MAPPING = "index";
//
//    public static void main(String[] args) throws LifecycleException, InterruptedException {
//        System.out.println("开始启动tomcat");
//        Tomcat tomcatServer = new Tomcat();
//        //设置tomcat端口
//        tomcatServer.setPort(PORT);
//        //此tomcat端口是否自动部署
//        tomcatServer.getHost().setAutoDeploy(false);
//        //创建一个web应用程序
//        StandardContext standardContex = new StandardContext();
//        //设置web应用程序的上下文地址
//        standardContex.setPath(CONTEX_PATH);
//        //添加web应用程序的监听
//        standardContex.addLifecycleListener(new Tomcat.FixContextListener());
//        //将web应用程序添加到服务器中
//        tomcatServer.getHost().addChild(standardContex);
//        //配置servelt和映射
//        tomcatServer.addServlet(CONTEX_PATH, SERVLET_NAME, new AppCoreServlet());
//        standardContex.addServletMappingDecoded("/"+MAPPING, SERVLET_NAME);
//        //启动tomcat
//        tomcatServer.start();
//        System.out.println("启动tomcat完毕");
//        //开启异步服务，接收请求
//        tomcatServer.getServer().await();
//    }
}
