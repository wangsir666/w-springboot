/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.16
 * Generated at: 2020-10-27 02:45:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.webapp.WEB_002dINF.page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>主页面</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css\">\r\n");
      out.write("    <script src=\"https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.bootcdn.net/ajax/libs/bootstrap-table/1.17.1/bootstrap-table.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<table class=\"table\">\r\n");
      out.write("    <thead>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th style=\"width:10%\">序号</th>\r\n");
      out.write("        <th style=\"width:90%\">内容</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("    <tbody>\r\n");
      out.write("    <tr class=\"active\">\r\n");
      out.write("        <td>1</td>\r\n");
      out.write("        <td><a href=\"https://blog.csdn.net/m0_37892044/article/details/106643842\">深入SpringIOC原理解析，带你实现一个SpringIOC框架</a></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr class=\"success\">\r\n");
      out.write("        <td>2</td>\r\n");
      out.write("        <td><a href=\"https://blog.csdn.net/m0_37892044/article/details/106976372\">深入SpringMVC原理解析，带你实现一个SpringMVC框架</a></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr  class=\"warning\">\r\n");
      out.write("        <td>3</td>\r\n");
      out.write("        <td><a href=\"https://blog.csdn.net/m0_37892044/article/details/107239656\">深入数据库连接池原理解析，带你实现一个连接池框架</a></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr  class=\"danger\">\r\n");
      out.write("        <td>4</td>\r\n");
      out.write("        <td><a href=\"https://blog.csdn.net/m0_37892044/article/details/107314371\">深入MyBatis原理解析，带你实现一个MyBatis框架</a></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr  class=\"success\">\r\n");
      out.write("        <td>5</td>\r\n");
      out.write("        <td><a href=\"https://blog.csdn.net/m0_37892044/article/details/103915284\">使用SpringToolSuite快速构建一个SpringBoot项目</a></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr  class=\"active\">\r\n");
      out.write("        <td>6</td>\r\n");
      out.write("        <td><a href=\"https://blog.csdn.net/m0_37892044/article/details/107576920\">深入SpringBoot启动原理</a></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr  class=\"active\">\r\n");
      out.write("        <td>7</td>\r\n");
      out.write("        <td><a href=\"https://blog.csdn.net/m0_37892044/article/details/107887911\">SpringBoot使用Atomikos实现分布式事务管理</a></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr  class=\"success\">\r\n");
      out.write("        <td>8</td>\r\n");
      out.write("        <td><a href=\"\">深入SpringBoot核心原理，带你实现一个SpringBoot框架</a></td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    </tbody>\r\n");
      out.write("</table>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}