/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2023-06-07 11:01:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminMemberList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<style>\r\n");
      out.write("    .pagination {\r\n");
      out.write("        display: flex;\r\n");
      out.write("        justify-content: center;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("<!-- 설렉트박스 -->\r\n");
      out.write("<div class=\"d-flex justify-content-end\">\r\n");
      out.write("    <div class=\"dropdown\">\r\n");
      out.write("        <button class=\"btn btn-primary dropdown-toggle companySelect\" type=\"button\" id=\"dropdownMenuButton\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("            전체\r\n");
      out.write("        </button>\r\n");
      out.write("        <ul class=\"dropdown-menu border-0 shadow p-3 companyList\">\r\n");
      out.write("\r\n");
      out.write("        </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"row clearfix\">\r\n");
      out.write("    <div class=\"col-md-12\">\r\n");
      out.write("        <div class=\"card border-0 mb-4 no-bg\">\r\n");
      out.write("            <div class=\"card-header py-3 px-0 d-flex align-items-center  justify-content-between border-bottom\">\r\n");
      out.write("                <h3 class=\" fw-bold flex-fill mb-0\">직원 관리</h3>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div><!-- Row End -->\r\n");
      out.write("\r\n");
      out.write("<div id=\"memberList\" class=\"row g-3 row-cols-1 row-cols-sm-1 row-cols-md-1 row-cols-lg-2 row-cols-xl-2 row-cols-xxl-2 row-deck py-1 pb-4\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<nav aria-label=\"Page navigation example\">\r\n");
      out.write("    <ul class=\"pagination\">\r\n");
      out.write("        <li class=\"page-item\" id=\"previousPage\"><a class=\"page-link\" href=\"#\">Previous</a></li>\r\n");
      out.write("        <li class=\"page-item\" style=\"display: flex\" id=\"pageContainer\"><a class=\"page-link\" href=\"#\">1</a></li>\r\n");
      out.write("        <li class=\"page-item\" id=\"nextPage\"><a class=\"page-link\" href=\"#\">Next</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\theaders['accept'] = 'application/json';\r\n");
      out.write("\theaders['Content-Type'] = 'application/json';\r\n");
      out.write("\tlet companyList = document.querySelector('.companyList');\r\n");
      out.write("\tlet memberList = document.querySelector('#memberList');\r\n");
      out.write("\tlet companySelect = document.querySelector('.companySelect');\r\n");
      out.write("\tlet selectedCompanyId = 0;\r\n");
      out.write(" async   function adminCompanyList(){\r\n");
      out.write("\tawait \taxios.get('/ourmine/member/adminCompanyList',{headers:headers})\r\n");
      out.write("            .then(resp => {\r\n");
      out.write("\t\t\t\tlet data = resp.data;\r\n");
      out.write("\t            console.log(\"companyList = \",data)\r\n");
      out.write("                companyList.innerHTML+= `<li><button class=\"dropdown-item py-2 rounded companyListItem\" href=\"#\">전체</button></li>`\r\n");
      out.write("                data.map(item => {\r\n");
      out.write("\t\t\t\t\tcompanyList.innerHTML += `<li><button data-company=${item.companyId} class=\"dropdown-item py-2 rounded companyListItem\" href=\"#\">${item.companyName}</button></li>`\r\n");
      out.write("                })\r\n");
      out.write("            })\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\tlet currentPageIndex = 0; // 페이지 번호 배열의 시작 인덱스를 표시\r\n");
      out.write("\tlet pageSize = 6; // 한 페이지에 표시되는 데이터의 개수\r\n");
      out.write("\tlet displayPageCount = 5; // 한 번에 표시되는 페이지 번호의 개수\r\n");
      out.write("\tlet pagesArray = []; // 페이지 번호 배열을 전역 변수로 선언\r\n");
      out.write("\r\n");
      out.write("\tasync function adminCompanyMemberList(){\r\n");
      out.write("\t\tawait axios.get('/ourmine/member/adminCompanyMemberList', {headers: headers})\r\n");
      out.write("\t\t\t.then(resp => {\r\n");
      out.write("\t\t\t\tlet data = resp.data;\r\n");
      out.write("\t\t\t\tconsole.log(\"adminCompanyMemberList = \", data)\r\n");
      out.write("\t\t\t\tlet totalItems = data[0].totalData; // 총 데이터 개수\r\n");
      out.write("\t\t\t\tlet totalPages = Math.ceil(totalItems / pageSize); // 총 페이지 개수\r\n");
      out.write("\t\t\t\tpagesArray = Array.from({length: totalPages}, (_, i) => i + 1); // 페이지 번호 배열 생성\r\n");
      out.write("\t\t\t\tmemberList.innerHTML += createMemberCards(data);\r\n");
      out.write("\t\t\t\tdisplayPages();\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction displayPages() {\r\n");
      out.write("\t\t// 시작 인덱스부터 표시할 페이지 개수만큼의 페이지 번호를 가져옴\r\n");
      out.write("\t\tlet pagesToDisplay = pagesArray.slice(currentPageIndex, currentPageIndex + displayPageCount);\r\n");
      out.write("\t\tdocument.querySelector('#previousPage').style.visibility = (currentPageIndex > 0) ? 'visible' : 'hidden';\r\n");
      out.write("\t\tdocument.querySelector('#nextPage').style.visibility = (currentPageIndex + displayPageCount < pagesArray.length) ? 'visible' : 'hidden';\r\n");
      out.write("\t\tdocument.querySelector('#pageContainer').innerHTML = pagesToDisplay\r\n");
      out.write("\t\t\t.map(pageNumber => `<a href=\"#\" data-page=\"${pageNumber}\" class=\"page-link pageItems\">${pageNumber}</a>`)\r\n");
      out.write("\t\t\t.join('');\r\n");
      out.write("\t\tsetPageItemsEvent(); // 페이지 아이템들에 이벤트 리스너 설정\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tdocument.querySelector('#nextPage').addEventListener('click', () => {\r\n");
      out.write("\t\tcurrentPageIndex += displayPageCount; // 페이지 번호 배열의 시작 인덱스를 변경\r\n");
      out.write("\t\tdisplayPages(); // 다음 페이지 번호들을 표시\r\n");
      out.write("\t\tsetPageItemsEvent(); // 페이지 아이템들에 이벤트 리스너 설정\r\n");
      out.write("\t    // 버튼 그룹\r\n");
      out.write("\t\tfetchDataForPage(pagesArray[currentPageIndex]);\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tdocument.querySelector('#previousPage').addEventListener('click', () => {\r\n");
      out.write("\t\tcurrentPageIndex -= displayPageCount; // 페이지 번호 배열의 시작 인덱스를 변경\r\n");
      out.write("\t\tif(currentPageIndex < 0) { // 시작 인덱스가 0보다 작아지는 것을 방지\r\n");
      out.write("\t\t\tcurrentPageIndex = 0;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tdisplayPages(); // 이전 페이지 번호들을 표시\r\n");
      out.write("\t\tsetPageItemsEvent(); // 페이지 아이템들에 이벤트 리스너 설정\r\n");
      out.write("\t\t// 버튼 그룹\r\n");
      out.write("\t\tfetchDataForPage(pagesArray[currentPageIndex + displayPageCount - 1]);\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\tfunction setPageItemsEvent() {\r\n");
      out.write("\t\tlet pageItems = document.querySelectorAll('.pageItems');\r\n");
      out.write("\t\tconsole.log(\"pageItems = \", pageItems);\r\n");
      out.write("\t\tpageItems.forEach(item => {\r\n");
      out.write("\t\t\titem.addEventListener('click', (e) => {\r\n");
      out.write("\t\t\t\tlet {page} = e.target.dataset;\r\n");
      out.write("\t\t\t\tconsole.log(\"page = \", page)\r\n");
      out.write("\t\t\t\tfetchDataForCompany(selectedCompanyId, page);\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction fetchDataForPage(pageNumber) {\r\n");
      out.write("\t\tfetchDataForCompany(selectedCompanyId, pageNumber); // 선택된 회사의 특정 페이지 데이터 가져오기\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction companyListMember(){\r\n");
      out.write("\t\tlet companyListItem = document.querySelectorAll('.companyListItem');\r\n");
      out.write("\t\tcompanyListItem.forEach(item => {\r\n");
      out.write("\t\t\titem.addEventListener('click', (e) => {\r\n");
      out.write("\t\t\t\tcompanySelect.innerHTML =  e.target.innerHTML\r\n");
      out.write("\t\t\t\tselectedCompanyId = e.target.dataset.company;\r\n");
      out.write("\t\t\t\tconsole.log(\"selectedCompanyId = \", selectedCompanyId);\r\n");
      out.write("\t\t\t\tcurrentPageIndex = 0; // 페이지 번호 배열의 시작 인덱스를 0으로 재설정\r\n");
      out.write("\t\t\t\tfetchDataForCompany(selectedCompanyId, 1); // 첫 페이지의 회사 데이터 가져오기\r\n");
      out.write("            })\r\n");
      out.write("        })\r\n");
      out.write("    }\r\n");
      out.write("\tfunction fetchDataForCompany(companyId, pageNumber) {\r\n");
      out.write("\t\taxios.get('/ourmine/member/adminCompanyMemberList',{\r\n");
      out.write("\t\t\tparams : {\r\n");
      out.write("\t\t\t\tcompanyId,\r\n");
      out.write("\t\t\t\tpage: pageNumber,\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t},{headers:headers})\r\n");
      out.write("\t\t\t.then(resp => {\r\n");
      out.write("\t\t\t\tlet data = resp.data;\r\n");
      out.write("\t\t\t\tmemberList.innerHTML = createMemberCards(data);\r\n");
      out.write("\t\t\t\t// 총 데이터 개수를 기반으로 페이지 수 다시 계산\r\n");
      out.write("\t\t\t\tlet totalItems = data[0].totalData;\r\n");
      out.write("\t\t\t\tlet totalPages = Math.ceil(totalItems / pageSize);\r\n");
      out.write("\t\t\t\tpagesArray = Array.from({length: totalPages}, (_, i) => i + 1);\r\n");
      out.write("\t\t\t\t// 페이지네이션 업데이트\r\n");
      out.write("\t\t\t\tdisplayPages();\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t// 첫 페이지 로딩시 이벤트 핸들러 설정\r\n");
      out.write("\tadminCompanyList().then(adminCompanyMemberList).then(setPageItemsEvent).then(companyListMember)\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    // 회원 html 그려주는 메소드\r\n");
      out.write("\tfunction createMemberCards(data) {\r\n");
      out.write("\t\tlet content = '';\r\n");
      out.write("\t\tdata.map(item => {\r\n");
      out.write("\t\t\tcontent += `\r\n");
      out.write("            <div class=\"col\">\r\n");
      out.write("                <div class=\"card teacher-card\">\r\n");
      out.write("                    <div class=\"card-body  d-flex\">\r\n");
      out.write("                        <div class=\"profile-av pe-xl-4 pe-md-2 pe-sm-4 pe-4 text-center w220\">\r\n");
      out.write("                            <img width=\"200\" height=\"200\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/images/lg/마스코트_투명.png\" alt=\"\" class=\"avatar xl rounded-circle img-thumbnail shadow-sm\">\r\n");
      out.write("                            <div class=\"about-info d-flex align-items-center mt-1 justify-content-center flex-column\">\r\n");
      out.write("                                <h6 class=\"mb-0 fw-bold d-block fs-6 mt-2\">${item.companyName}</h6>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"teacher-info border-start ps-xl-4 ps-md-3 ps-sm-4 ps-4 w-100\">\r\n");
      out.write("                            <h6  class=\"mb-0 mt-2  fw-bold d-block fs-6\">${item.memberName}</h6>\r\n");
      out.write("                            <span class=\"py-1 fw-bold small-11 mb-0 mt-1 text-muted\">${item.memberGrade}</span>\r\n");
      out.write("                            <div class=\"video-setting-icon mt-3 pt-3 border-top\">\r\n");
      out.write("                                <p>이메일: ${item.memberEmail}</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"d-flex flex-wrap align-items-center ct-btn-set\">\r\n");
      out.write("                               <!-- <a href=\"chat.html\" class=\"btn btn-dark btn-sm mt-1 me-1\"><i class=\"icofont-ui-text-chat me-2 fs-6\"></i>${item.subscribeEndDate}</a>\r\n");
      out.write("                                <a href=\"profile.html\" class=\"btn btn-dark btn-sm mt-1\"><i class=\"icofont-invisible me-2 fs-6\"></i>D-${item.subDay}</a>-->\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        `;\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\treturn content;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
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
