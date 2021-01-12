package com.cloud.springboot.web;

import com.cloud.springboot.servlet.AppCoreServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;


import static com.cloud.springboot.utils.ThreadUtil.getThreadName;

/**
 * @Auther: wjx
 * @Date: 2020/10/26 15:53
 * @Description:
 */
public class WTomcatServer {
    private static int PORT = 9999;
    private static String CONTEXT_PATH = "/wtomcat";
    private static String SERVLET_NAME = "index";
    private static String MAPPING = "/index";
    public static void startApp() throws LifecycleException{
        startApp(PORT);
    }
    public static void startApp(int port) throws LifecycleException {
        System.out.println(getThreadName()+"开始启动tomcat....");
        //创建tomcat
        Tomcat server = new Tomcat();
        server.setPort(port);
        server.getHost().setAutoDeploy(false);

        //创建一个web应用
        StandardContext app = new StandardContext();
        //设置上下文地址
        app.setPath(CONTEXT_PATH);
        //添加监听
        app.addLifecycleListener(new Tomcat.FixContextListener());

        //将应用添加到容器中
        server.getHost().addChild(app);
        server.addServlet(CONTEXT_PATH, SERVLET_NAME, new AppCoreServlet());
        //添加mapping到servlet的映射，在addServlet之后
//        app.addServletMappingDecoded(MAPPING, SERVLET_NAME);
        app.addServletMappingDecoded("", SERVLET_NAME);
        //启动容器
        server.start();
        System.out.println(getThreadName()+"tomcat启动成功....");
        //开启异步服务，接收请求
        server.getServer().await();
    }

}
