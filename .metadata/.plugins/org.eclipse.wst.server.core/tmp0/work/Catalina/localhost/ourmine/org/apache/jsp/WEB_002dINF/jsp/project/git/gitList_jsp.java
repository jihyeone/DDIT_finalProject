/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2023-06-11 08:36:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.project.git;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class gitList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/E:/A_TeachingMaterial/05_JSP_Spring/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ourmine/WEB-INF/lib/spring-security-taglibs-5.7.8.jar!/META-INF/security.tld", Long.valueOf(1681713972000L));
    _jspx_dependants.put("/WEB-INF/lib/spring-security-taglibs-5.7.8.jar", Long.valueOf(1683020361417L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsecurity_005fauthentication_0026_005fvar_005fproperty_005fnobody;

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
    _005fjspx_005ftagPool_005fsecurity_005fauthentication_0026_005fvar_005fproperty_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fsecurity_005fauthentication_0026_005fvar_005fproperty_005fnobody.release();
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/apexcharts\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/gitgraph.js/1.11.4/gitgraph.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\t.grid-container {\r\n");
      out.write("\t\tdisplay: grid;\r\n");
      out.write("/* \t\tgrid-template-columns: 1fr 380px; */\r\n");
      out.write("\t\tgrid-gap: 50px;\r\n");
      out.write("\t\tgrid-template-areas:\r\n");
      out.write("\t\t\t\"main main main right\"\r\n");
      out.write("\t\t\t\"left left bottom right\"\r\n");
      out.write("            \"left left bottom right\";\r\n");
      out.write("        justify-content: center;\r\n");
      out.write("        align-items: stretch;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.grid-main {\r\n");
      out.write("\t\tgrid-area: main;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.grid-right {\r\n");
      out.write("\t\tgrid-area: right;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.grid-left-bottom {\r\n");
      out.write("\t\tgrid-area: left;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t.grid-main-bottom {\r\n");
      out.write("\t\tgrid-area: bottom;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t#overlay {\r\n");
      out.write("\t\tposition: fixed; /* Fixed position */\r\n");
      out.write("\t\tz-index: 9999; /* Sit on top */\r\n");
      out.write("\t\tleft: 0;\r\n");
      out.write("\t\ttop: 0;\r\n");
      out.write("\t\twidth: 100%; /* Full width */\r\n");
      out.write("\t\theight: 100%; /* Full height */\r\n");
      out.write("\t\toverflow: auto; /* Enable scroll if needed */\r\n");
      out.write("\t\tbackground-color: rgba(0,0,0,0.5); /* Black w/ opacity */\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tconst autoToken = () => {\r\n");
      out.write("\t\tvar tokenInput = document.getElementById(\"userInput\");\r\n");
      out.write("\t\ttokenInput.value = \"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\";\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div id=\"loading\" style=\"display: none\">\r\n");
      out.write("<div class=\"grid-container\">\r\n");
      out.write("\t<div class=\"grid-main mt-3\">\r\n");
      out.write("\t\t<canvas id=\"gitGraph\">\r\n");
      out.write("\r\n");
      out.write("\t   </canvas>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"card card-chat border-right border-top-0 border-bottom-0 w450 grid-right mt-3\">\r\n");
      out.write("\t\t<div class=\"px-4 py-3 py-md-4\">\r\n");
      out.write("\t\t\t<div class=\"input-group mb-3\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"form-control mb-1\" placeholder=\"Search...\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"nav nav-pills justify-content-between text-center\" role=\"tablist\">\r\n");
      out.write("\t\t\t\t<a class=\"flex-fill rounded border-0 nav-link active\"\r\n");
      out.write("\t\t\t\t\tdata-bs-toggle=\"tab\" href=\"#chat-recent\" role=\"tab\"\r\n");
      out.write("\t\t\t\t\taria-selected=\"true\">커밋 히스토리</a>\r\n");
      out.write("\t\t\t\t<a class=\"flex-fill rounded border-0 nav-link\" data-bs-toggle=\"tab\"\r\n");
      out.write("\t\t\t\t\thref=\"#chat-groups\" role=\"tab\" aria-selected=\"false\">프로젝트 깃허브</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"tab-content border-top\">\r\n");
      out.write("\t\t\t<div class=\"tab-pane fade show active\" id=\"chat-recent\" role=\"tabpanel\">\r\n");
      out.write("\t\t\t\t<ul class=\"list-unstyled list-group list-group-custom list-group-flush mb-0 gitMemberCommit\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"tab-pane fade\" id=\"chat-groups\" role=\"tabpanel\">\r\n");
      out.write("\t\t\t\t<ul class=\"list-unstyled list-group list-group-custom list-group-flush mb-0 gitHub-addr\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"tab-pane fade\" id=\"chat-contact\" role=\"tabpanel\">\r\n");
      out.write("\t\t\t\t<ul class=\"list-unstyled list-group list-group-custom list-group-flush mb-0\">\r\n");
      out.write("\t\t\t\t\t<li class=\"list-group-item px-md-4 py-3 py-md-4\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"javascript:void(0);\" class=\"d-flex\">\r\n");
      out.write("\t\t\t\t\t\t<img class=\"avatar rounded-circle\"  width=\"200\" height=\"200\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/xs/마스코트_투명.png\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"flex-fill ms-3 text-truncate\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"d-flex justify-content-between mb-0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<h6 class=\"mb-0\">Hannah Gill</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"text-muted\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-heart-o pl-2 text-danger\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"fa fa-trash pl-2 text-danger\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"text-muted\">hannahgill@my-Task.com</span>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"col-lg-12 flex-column grid-left-bottom\">\r\n");
      out.write("\t\t<div class=\"row g-3\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t<div class=\"card\">\r\n");
      out.write("\t\t\t\t\t<div class=\"card-header py-3 d-flex justify-content-between bg-transparent border-bottom-0\">\r\n");
      out.write("\t\t\t\t\t\t<h6 class=\"mb-0 fw-bold \">브랜치 현황</h6>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"row g-2 row-deck\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-6 col-sm-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"card\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"card-body \">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"icofont-checked fs-3\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h6 class=\"mt-3 mb-0 fw-bold small-14\">커밋 갯수</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"text-muted commitCount\">400</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-6 col-sm-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"card\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"card-body \">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"icofont-usb fs-3\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h6 class=\"mt-3 mb-0 fw-bold small-14\">병합 횟수</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"text-muted merged\">17</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-6 col-sm-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"card\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"card-body \">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"icofont-crown-king fs-3\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h6 class=\"mt-3 mb-0 fw-bold small-14\">커밋왕</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"text-muted commitKing\">06</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-md-6 col-sm-6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"card\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"card-body \">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"icofont-architecture-alt fs-3\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h6 class=\"mt-3 mb-0 fw-bold small-14\">현재 에러 브랜치</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span class=\"text-muted errorBranch\">14</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"card grid-main-bottom\">\r\n");
      out.write("\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t<h6 class=\"mb-3 fw-bold \">언어</h6>\r\n");
      out.write("\t\t\t\t\t<div class=\"d-flex justify-content-end text-center\">\r\n");
      out.write("\t\t\t\t\t\t<div id=\"incomeanalytics11\" class=\"p-3\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("<!-- The Modal -->\r\n");
      out.write("<div class=\"modal fade\" id=\"staticBackdropLive\" data-backdrop=\"static\" data-keyboard=\"false\" tabindex=\"-1\" aria-labelledby=\"staticBackdropLiveLabel\" aria-hidden=\"true\">\r\n");
      out.write("\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t<h5 class=\"modal-title\" id=\"staticBackdropLiveLabel\">토큰을 입력해주세요</h5>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t<input id=\"userInput\" type=\"text\" class=\"form-control mb-1\" placeholder=\"Search...\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("                <button type=\"button\" class=\"btn\" style=\"color:gray;\" onclick=\"autoToken()\">자동완성</button>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-secondary\" data-bs-dismiss=\"modal\">닫기</button>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" id=\"submitButton\">전송</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"loadingImage\" style=\"display: none; position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%); z-index: 999999;\">\r\n");
      out.write("\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/Github.gif\" alt=\"Loading...\" />\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"overlay\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_security_005fauthentication_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<input id=\"projectIdHidden\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${projectId }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("<input id=\"companyIdHidden\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${companyId }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t  let gitMemberCommit = document.querySelector('.gitMemberCommit');\r\n");
      out.write("  let projectIdHidden = document.querySelector('#projectIdHidden');\r\n");
      out.write("  let companyIdHidden = document.querySelector('#companyIdHidden');\r\n");
      out.write("\t  let commitCount = document.querySelector('.commitCount');\r\n");
      out.write("\t  let merged = document.querySelector('.merged');\r\n");
      out.write("\t  let commitKing = document.querySelector('.commitKing');\r\n");
      out.write("\t  let errorBranch = document.querySelector('.errorBranch');\r\n");
      out.write("\t  let gitHubAddr = document.querySelector('.gitHub-addr');\r\n");
      out.write("\t  let userInput = document.querySelector('#userInput');\r\n");
      out.write("  let projectIdHiddenValue = projectIdHidden.value;\r\n");
      out.write("  let companyIdHiddenValue = companyIdHidden.value;\r\n");
      out.write("\r\n");
      out.write("\t let loading  = document.querySelector('#loading');\r\n");
      out.write("\r\n");
      out.write("  headers['Content-Type'] = 'application/json'\r\n");
      out.write("  headers['accept'] = 'application/json'\r\n");
      out.write("\r\n");
      out.write("\t  $(document).ready(function() {\r\n");
      out.write("\t\t  $('#staticBackdropLive').on('hide.bs.modal', function () {\r\n");
      out.write("\t\t\t  let loadingImage = document.getElementById('loadingImage');\r\n");
      out.write("\t\t\t  let overlay = document.getElementById('overlay');\r\n");
      out.write("\t\t\t  loadingImage.style.display = \"none\";\r\n");
      out.write("\t\t\t  overlay.style.display = \"none\";\r\n");
      out.write("\t\t  });\r\n");
      out.write("\t  });\r\n");
      out.write("\r\n");
      out.write("\t  document.addEventListener(\"DOMContentLoaded\", function() {\r\n");
      out.write("\t\t  let myModal = document.getElementById('staticBackdropLive')\r\n");
      out.write("\t\t  let modal = new bootstrap.Modal(myModal, {\r\n");
      out.write("\t\t\t  keyboard: false\r\n");
      out.write("\t\t  });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t  modal.show();\r\n");
      out.write("\r\n");
      out.write("\t\t  document.getElementById('submitButton').addEventListener('click', function() {\r\n");
      out.write("\t\t\t  modal.hide();\r\n");
      out.write("\t\t\t  let loadingImage = document.getElementById('loadingImage');\r\n");
      out.write("\t\t\t  let overlay = document.getElementById('overlay');\r\n");
      out.write("\t\t\t  loadingImage.style.display = \"block\";\r\n");
      out.write("\t\t\t  overlay.style.display = \"block\";\r\n");
      out.write("\t\t\t  setTimeout(function() {\r\n");
      out.write("\t\t\t\t  loadingImage.style.display = \"none\";\r\n");
      out.write("\t\t\t\t  overlay.style.display = \"none\";\r\n");
      out.write("\t\t\t\t  loading.style.display = 'block';\r\n");
      out.write("\t\t\t\t  promiseControl();\r\n");
      out.write("\t\t\t  }, 4000);\r\n");
      out.write("\t\t  });\r\n");
      out.write("\t  });\r\n");
      out.write("\r\n");
      out.write("async function branch(){\r\n");
      out.write("await \taxios.get(`/ourmine/company/${companyIdHiddenValue}/project/${projectIdHiddenValue}/git/gitListJson`, {headers : headers})\r\n");
      out.write("\t\t\t.then(resp => {\r\n");
      out.write("\t\t\t\tlet data = resp.data;\r\n");
      out.write("\t\t\t\tconsole.log(\"git data :\", data);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t// 사용자 정의 템플릿 생성\r\n");
      out.write("\t\t\t\tlet myTemplateConfig = {\r\n");
      out.write("\t\t\t\t\tcolors: [\"#979797\", \"#008fb5\", \"#f1c109\"], // 브랜치 색상 설정\r\n");
      out.write("\t\t\t\t\tbranch: {\r\n");
      out.write("\t\t\t\t\t\tlineWidth: 10,\r\n");
      out.write("\t\t\t\t\t\tspacingX: 20,\r\n");
      out.write("\t\t\t\t\t\tmergeStyle: \"bezier\",\r\n");
      out.write("\t\t\t\t\t\tshowLabel: true,  // 레이블 표시 설정\r\n");
      out.write("\t\t\t\t\t\tlabel: {\r\n");
      out.write("\t\t\t\t\t\t\tcolor: \"blue\",\r\n");
      out.write("\t\t\t\t\t\t\tstrokeColor: \"black\",\r\n");
      out.write("\t\t\t\t\t\t\tstrokeWidth: 2,\r\n");
      out.write("\t\t\t\t\t\t\tfontSize: \"10pt\",\r\n");
      out.write("\t\t\t\t\t\t\tfontFamily: \"Courier New\"  // 레이블 폰트 변경\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tcommit: {\r\n");
      out.write("\t\t\t\t\t\tspacingY: -20,\r\n");
      out.write("\t\t\t\t\t\tdot: {\r\n");
      out.write("\t\t\t\t\t\t\tsize: 12,\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\tmessage: {\r\n");
      out.write("\t\t\t\t\t\t\tdisplayAuthor: false,\r\n");
      out.write("\t\t\t\t\t\t\tdisplayBranch: false,\r\n");
      out.write("\t\t\t\t\t\t\tdisplayHash: false,\r\n");
      out.write("\t\t\t\t\t\t\tfont: \"normal 12pt Arial\",\r\n");
      out.write("\t\t\t\t\t\t\tcolor: \"black\",\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t};\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tlet myTemplate = new GitGraph.Template(myTemplateConfig);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t// GitGraph 인스턴스 생성 시 사용자 정의 템플릿 적용\r\n");
      out.write("\t\t\t\tlet gitgraph = new GitGraph({template: myTemplate, mode: \"compact\", orientation: \"horizontal\", elementId: \"gitGraph\"});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t// main 브랜치 생성\r\n");
      out.write("\t\t\t\tlet main = gitgraph.branch(\"main\");\r\n");
      out.write("\r\n");
      out.write("// data를 시간 순으로 정렬\r\n");
      out.write("\t\t\t\tdata.sort((a, b) => new Date(a.commitDate) - new Date(b.commitDate));\r\n");
      out.write("\r\n");
      out.write("// 브랜치를 담을 객체\r\n");
      out.write("\t\t\t\tlet branches = {};\r\n");
      out.write("\r\n");
      out.write("// data 순회하면서 브랜치와 커밋 생성\r\n");
      out.write("\t\t\t\tdata.forEach((commitData, index) => {\r\n");
      out.write("\t\t\t\t\tlet branchName = commitData.branchName;\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t// BRANCH_FROM에 해당하는 브랜치를 parentBranch로 설정\r\n");
      out.write("\t\t\t\t\tlet parentBranch = branches[commitData.branchFrom];\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t// 브랜치가 존재하지 않으면 생성\r\n");
      out.write("\t\t\t\t\tif (!branches[branchName]) {\r\n");
      out.write("\t\t\t\t\t\t// 부모 브랜치가 있으면 해당 브랜치에서 새 브랜치 생성\r\n");
      out.write("\t\t\t\t\t\tif (parentBranch) {\r\n");
      out.write("\t\t\t\t\t\t\tbranches[branchName] = parentBranch.branch(branchName);\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\tbranches[branchName] = gitgraph.branch(branchName);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t// 해당 브랜치에 커밋\r\n");
      out.write("\t\t\t\t\tbranches[branchName].commit({\r\n");
      out.write("\t\t\t\t\t\tmessage: `Commit by ${commitData.memberName} at ${commitData.commitMessage} : ${commitData.commitDate} `,\r\n");
      out.write("\t\t\t\t\t\tdetailId: commitData.gitId,  // optional, adds hyperlinks to commits\r\n");
      out.write("\t\t\t\t\t\tauthor: commitData.memberName,  // optional, specify the author of the commit\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t// IS_MERGED 값이 1이면 해당 브랜치를 MERGE_BRANCH_NAME으로 병합\r\n");
      out.write("\t\t\t\t\tif (commitData.isMerged == 1) {\r\n");
      out.write("\t\t\t\t\t\tlet mergeBranch = branches[commitData.mergeBranchName];\r\n");
      out.write("\t\t\t\t\t\tif (mergeBranch) {\r\n");
      out.write("\t\t\t\t\t\t\tmergeBranch.merge(branches[branchName], `Merge ${commitData.memberName}'s work into ${commitData.mergeBranchName}`);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t\tgitHubAddr.innerHTML = memberGitHubAddr(data);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("async function memberCommitData(){\r\n");
      out.write(" await \taxios.get(`/ourmine/company/${companyIdHiddenValue}/project/${projectIdHiddenValue}/git/gitMemberCommitSelect`, {headers : headers})\r\n");
      out.write("\t\t\t.then(resp => {\r\n");
      out.write("\t\t\t\tlet data = resp.data;\r\n");
      out.write("\t\t\t\t\tgitMemberCommit.innerHTML = createListMember(data)\r\n");
      out.write("\t\t\t})\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("async function branchStatus(){\r\n");
      out.write("\tawait axios.get(`/ourmine/company/${companyIdHiddenValue}/project/${projectIdHiddenValue}/git/gitCommitCount`, {headers : headers})\r\n");
      out.write("\t\t\t.then(resp => {\r\n");
      out.write("\t\t\t\tlet data = resp.data;\r\n");
      out.write("\t\t\t\tconsole.log(\"branchStatus =\", data)\r\n");
      out.write("\t\t\t\tcommitCount.innerHTML = data.reduce((sum, git) => sum + git.commitCount,0);\r\n");
      out.write("\t\t\t\tmerged.innerHTML = data[0].isMerged;\r\n");
      out.write("\t\t\t\tcommitKing.innerHTML =  data.reduce((maxId, obj) => (maxId.value > obj.value ? maxId : obj.memberName), data[0].memberName);\r\n");
      out.write("\t\t\t\terrorBranch.innerHTML = data[0].errorBranch;\r\n");
      out.write("\t\t\t})\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\t  function createListMember(item) {\r\n");
      out.write("\t\t  let content = '';\r\n");
      out.write("\t\t item.map(user => {\r\n");
      out.write("\t\t\t let image = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/lg/마스코트_투명.png';\r\n");
      out.write("\t\t\t content +=   `<li class=\"list-group-item px-md-4 py-3 py-md-4\">\r\n");
      out.write("\t\t\t\t<a href=\"javascript:void(0);\" class=\"d-flex\">\r\n");
      out.write("\t\t\t\t\t<img class=\"avatar rounded-circle\" src=\"${user.imageContents !== null ? user.imageContents : image}\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t<div class=\"flex-fill ms-3 text-truncate\">\r\n");
      out.write("\t\t\t\t\t\t<h6 class=\"d-flex justify-content-between mb-0\"><span>${user.memberName}</span> <small class=\"msg-time\">${user.commitDate}</small></h6>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"text-muted\">${user.commitMessage}</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</a>\r\n");
      out.write("\t\t\t</li>`;\r\n");
      out.write("\t\t })\r\n");
      out.write("\t\t  return content;\r\n");
      out.write("\t  }\r\n");
      out.write("\r\n");
      out.write("\t  function memberGitHubAddr(item){\r\n");
      out.write("\t  \t\tlet content = '';\r\n");
      out.write("\t\t  let uniqueMembers = item.filter((member, index, self) =>\r\n");
      out.write("\t\t\t\t\t\t  index === self.findIndex((m) => (\r\n");
      out.write("\t\t\t\t\t\t\t\t  m.gitHub === member.gitHub\r\n");
      out.write("\t\t\t\t\t\t  ))\r\n");
      out.write("\t\t  );\r\n");
      out.write("\t\t  console.log(\"uniqueMembers = \", uniqueMembers)\r\n");
      out.write("\t\t  uniqueMembers.map(user => {\r\n");
      out.write("\t\t\t  content += `<a href=\"https://github.com/JJaeHwan/finalProject.git\" target=\"_blank\" rel=\"noopener noreferrer\">\r\n");
      out.write("                    <li class=\"list-group-item px-md-4 py-3 py-md-4 \">\r\n");
      out.write("                        <div style=\"display: flex; align-items: center;\">\r\n");
      out.write("                            <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/깃허브.png\" style=\"margin-right: 10px;\">\r\n");
      out.write("                            <div>ourmine</div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </a>`\r\n");
      out.write("\t\t  })\r\n");
      out.write("\r\n");
      out.write("\t\t  return content;\r\n");
      out.write("\t  }\r\n");
      out.write("\r\n");
      out.write("\t  function promiseControl(){\r\n");
      out.write("\t\t  Promise.all([branch(), memberCommitData(), branchStatus(),drawChart()])\r\n");
      out.write("\t\t\t\t  .then(() => {\r\n");
      out.write("\t\t\t\t\t  console.log('All tasks finished successfully.');\r\n");
      out.write("\t\t\t\t  })\r\n");
      out.write("\t\t\t\t  .catch((error) => {\r\n");
      out.write("\t\t\t\t\t  console.error('An error occurred:', error);\r\n");
      out.write("\t\t\t\t  });\r\n");
      out.write("\t  }\r\n");
      out.write("\r\n");
      out.write("\t  function drawChart() {\r\n");
      out.write("\t\t  return new Promise((resolve, reject) => {\r\n");
      out.write("\t\t\t  $(document).ready(function() {\r\n");
      out.write("\t\t\t\t  try {\r\n");
      out.write("\t\t\t\t\t  let colors = ['var(--chart-color1)', 'var(--chart-color2)', 'var(--chart-color3)',  'var(--chart-color5)'];\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t  let options = {\r\n");
      out.write("\t\t\t\t\t\t  align: 'center',\r\n");
      out.write("\t\t\t\t\t\t  series: [1500, 1200, 1100, 1000],\r\n");
      out.write("\t\t\t\t\t\t  responsive: [{\r\n");
      out.write("\t\t\t\t\t\t\t  breakpoint: 420,\r\n");
      out.write("\t\t\t\t\t\t\t  options: {\r\n");
      out.write("\t\t\t\t\t\t\t\t  chart: {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  width: 200,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  align: 'center',\r\n");
      out.write("\t\t\t\t\t\t\t\t  },\r\n");
      out.write("\t\t\t\t\t\t\t\t  legend: {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  position: 'bottom',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  markers: {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  fillColors:'var(--chart-color1)'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  },\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  labels: {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  colors: colors\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  },\r\n");
      out.write("\t\t\t\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t\t  }],\r\n");
      out.write("\t\t\t\t\t\t  chart: {\r\n");
      out.write("\t\t\t\t\t\t\t  height: 336,\r\n");
      out.write("\t\t\t\t\t\t\t  type: 'polarArea',\r\n");
      out.write("\t\t\t\t\t\t\t  toolbar: {\r\n");
      out.write("\t\t\t\t\t\t\t\t  show: false,\r\n");
      out.write("\t\t\t\t\t\t\t  },\r\n");
      out.write("\t\t\t\t\t\t  },\r\n");
      out.write("\t\t\t\t\t\t  labels: ['JavaScript', 'Java', 'Css',  'HTML' ],\r\n");
      out.write("\t\t\t\t\t\t  fill: {\r\n");
      out.write("\t\t\t\t\t\t\t  opacity: 1,\r\n");
      out.write("\t\t\t\t\t\t\t  colors: colors\r\n");
      out.write("\t\t\t\t\t\t  },\r\n");
      out.write("\t\t\t\t\t\t  stroke: {\r\n");
      out.write("\t\t\t\t\t\t\t  width: 1,\r\n");
      out.write("\t\t\t\t\t\t\t  colors: undefined\r\n");
      out.write("\t\t\t\t\t\t  },\r\n");
      out.write("\t\t\t\t\t\t  yaxis: {\r\n");
      out.write("\t\t\t\t\t\t\t  show: false\r\n");
      out.write("\t\t\t\t\t\t  },\r\n");
      out.write("\t\t\t\t\t\t  legend: {\r\n");
      out.write("\t\t\t\t\t\t\t  position: 'bottom',\r\n");
      out.write("\t\t\t\t\t\t\t  horizontalAlign: 'center',\r\n");
      out.write("\t\t\t\t\t\t\t  labels: {\r\n");
      out.write("\t\t\t\t\t\t\t\t  colors: colors\r\n");
      out.write("\t\t\t\t\t\t\t  },\r\n");
      out.write("\t\t\t\t\t\t  },\r\n");
      out.write("\t\t\t\t\t\t  plotOptions: {\r\n");
      out.write("\t\t\t\t\t\t\t  polarArea: {\r\n");
      out.write("\t\t\t\t\t\t\t\t  rings: {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t  strokeWidth: 0\r\n");
      out.write("\t\t\t\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t\t  },\r\n");
      out.write("\t\t\t\t\t\t  theme: {\r\n");
      out.write("\t\t\t\t\t\t\t  monochrome: {\r\n");
      out.write("\t\t\t\t\t\t\t\t  enabled: true,\r\n");
      out.write("\t\t\t\t\t\t\t\t  shadeTo: 'light',\r\n");
      out.write("\t\t\t\t\t\t\t\t  shadeIntensity: 0.6\r\n");
      out.write("\t\t\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t\t  }\r\n");
      out.write("\t\t\t\t\t  };\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t  let chart = new ApexCharts(document.querySelector(\"#incomeanalytics11\"), options);\r\n");
      out.write("\t\t\t\t\t  chart.render();\r\n");
      out.write("\t\t\t\t  } catch(e) {\r\n");
      out.write("\t\t\t\t\t  reject(e);\r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t  });\r\n");
      out.write("\t\t  });\r\n");
      out.write("\t  }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  </script>\r\n");
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

  private boolean _jspx_meth_security_005fauthentication_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  security:authentication
    org.springframework.security.taglibs.authz.AuthenticationTag _jspx_th_security_005fauthentication_005f0 = (org.springframework.security.taglibs.authz.AuthenticationTag) _005fjspx_005ftagPool_005fsecurity_005fauthentication_0026_005fvar_005fproperty_005fnobody.get(org.springframework.security.taglibs.authz.AuthenticationTag.class);
    boolean _jspx_th_security_005fauthentication_005f0_reused = false;
    try {
      _jspx_th_security_005fauthentication_005f0.setPageContext(_jspx_page_context);
      _jspx_th_security_005fauthentication_005f0.setParent(null);
      // /WEB-INF/jsp/project/git/gitList.jsp(213,0) name = property type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_security_005fauthentication_005f0.setProperty("principal");
      // /WEB-INF/jsp/project/git/gitList.jsp(213,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_security_005fauthentication_005f0.setVar("principal");
      int _jspx_eval_security_005fauthentication_005f0 = _jspx_th_security_005fauthentication_005f0.doStartTag();
      if (_jspx_th_security_005fauthentication_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fsecurity_005fauthentication_0026_005fvar_005fproperty_005fnobody.reuse(_jspx_th_security_005fauthentication_005f0);
      _jspx_th_security_005fauthentication_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_security_005fauthentication_005f0, _jsp_getInstanceManager(), _jspx_th_security_005fauthentication_005f0_reused);
    }
    return false;
  }
}
