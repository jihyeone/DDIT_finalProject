/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2023-05-26 07:16:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Member_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("  <div class=\"row align-items-center\">\r\n");
      out.write("    <div class=\"border-0 mb-4\">\r\n");
      out.write("        <div class=\"card-header p-0 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap\">\r\n");
      out.write("            <h3 class=\"fw-bold py-3 mb-0\">직원 관리</h3>\r\n");
      out.write("            <div class=\"d-flex py-2 project-tab flex-wrap w-sm-100\">\r\n");
      out.write("                <ul class=\"nav nav-tabs tab-body-header rounded ms-3 prtab-set w-sm-100\" role=\"tablist\">\r\n");
      out.write("                    <li class=\"nav-item\"><a id=\"allList\" class=\"nav-link active\" data-bs-toggle=\"tab\" href=\"#All-list\" role=\"tab\">All</a></li>\r\n");
      out.write("                    <li class=\"nav-item\"><a id=\"startedList\" class=\"nav-link\" data-bs-toggle=\"tab\" href=\"#Started-list\" role=\"tab\">PL/PM</a></li>\r\n");
      out.write("                    <li class=\"nav-item\"><a id=\"completedList\" class=\"nav-link\" data-bs-toggle=\"tab\" href=\"#Completed-list\" role=\"tab\">EMPLOYEES</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\t<div id=\"memberDiv\" class=\"row row-cols-2\">\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write(" \r\n");
      out.write("<script>\r\n");
      out.write("\tconst add = (a,b) => a + b;\r\n");
      out.write("\tlet memberDiv = document.querySelector('#memberDiv');\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function memberList(){\r\n");
      out.write("\tfetch(\"/ourmine/member/memberList\",{\r\n");
      out.write("\t\tmethod : \"GET\",\r\n");
      out.write("\t\theaders: {\r\n");
      out.write("\t\t\t'accept': 'application/json',\r\n");
      out.write("\t\t},\r\n");
      out.write("\t}).then(resp => resp.json())\r\n");
      out.write("\t\t.then(data => {\r\n");
      out.write("\t\t\tconsole.log(data);\r\n");
      out.write("\t\t\tmemberDiv.innerHTML += data.map(item => `\r\n");
      out.write("    <div class=\"col\">\r\n");
      out.write("        <div class=\"card teacher-card\">\r\n");
      out.write("            <div class=\"card-body d-flex\">\r\n");
      out.write("                <div class=\"profile-av pe-xl-4 pe-md-2 pe-sm-4 pe-4 text-center w220\">\r\n");
      out.write("                ${item.imageContents !==null ? `<img src=\"${item.imageContents}\" alt=\"\" class=\"avatar xl rounded-circle img-thumbnail shadow-sm\">` : `<img src=\"assets/images/lg/avatar3.jpg\" alt=\"\" class=\"avatar xl rounded-circle img-thumbnail shadow-sm\">`}\r\n");
      out.write("                    <div class=\"about-info d-flex align-items-center mt-3 justify-content-center\">\r\n");
      out.write("                        <div class=\"followers me-2\">\r\n");
      out.write("                            <i class=\"icofont-tasks color-careys-pink fs-4\"></i>\r\n");
      out.write("                            <span class=\"\">04</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"star me-2\">\r\n");
      out.write("                            <i class=\"icofont-star text-warning fs-4\"></i>\r\n");
      out.write("                            <span class=\"\">4.5</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"own-video\">\r\n");
      out.write("                            <i class=\"icofont-data color-light-orange fs-4\"></i>\r\n");
      out.write("                            <span class=\"\">04</span>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"teacher-info border-start ps-xl-4 ps-md-3 ps-sm-4 ps-4 w-100\">\r\n");
      out.write("                    <h6  class=\"mb-0 mt-2  fw-bold d-block fs-6\">${item.memberName}</h6>\r\n");
      out.write("                    <span class=\"light-info-bg py-1 px-2 rounded-1 d-inline-block fw-bold small-11 mb-0 mt-1\">${item.memberGrade}</span><br>\r\n");
      out.write("                    <span class=\"light-info-bg py-1 px-2 rounded-1 d-inline-block fw-bold small-11 mb-0 mt-1\">${item.companyName} : ${item.departmentName}</span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    `).reduce(add);\r\n");
      out.write("\t\t})\r\n");
      out.write("}\r\n");
      out.write("memberList();\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>");
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
