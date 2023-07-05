/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2023-06-07 05:52:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.noticeboard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class fnqNoticeboardList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\t/* 그리드 헤더 색상 */\r\n");
      out.write("\t.ag-theme-alpine {\r\n");
      out.write("\t\t--ag-header-background-color: #484c7f;\r\n");
      out.write("\t\t--ag-header-foreground-color: #ffffff;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t/* 그리드 내용 가운데 정렬 */\r\n");
      out.write("\t.ag-row .ag-cell {\r\n");
      out.write("/* \t\tdisplay: flex; */\r\n");
      out.write("/* \t\tjustify-content: center; */\r\n");
      out.write("/* \t\talign-items: center; */\r\n");
      out.write("\t\t/* \t\talign-content: center; */\r\n");
      out.write("\t}\r\n");
      out.write("\t.ag-header-cell-text {\r\n");
      out.write("\t\tmargin-left: 50px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#quickFilter {\r\n");
      out.write("\t\twidth: 25%;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<!-- ===================================================================================================================================== -->\r\n");
      out.write("<!-- 제목 & 추가버튼 -->\r\n");
      out.write("<div class=\"card-header py-3 no-bg bg-transparent d-flex align-items-center px-0 justify-content-between border-bottom flex-wrap\">\r\n");
      out.write("\t<h3 class=\"fw-bold mb-0\">F&Q게시판</h3>\r\n");
      out.write("\t<security:authorize access=\"hasRole('ADMIN')\">\r\n");
      out.write("\t<div class=\"col-auto d-flex w-sm-100\">\r\n");
      out.write("\t\t<button type=\"button\" class=\"btn btn-dark btn-set-task w-sm-100\" onclick=\"inModalOpen()\">\r\n");
      out.write("\t\t\t<i class=\"icofont-plus-circle me-2 fs-6\"></i> 글작성\r\n");
      out.write("\t\t</button>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</security:authorize>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- ===================================================================================================================================== -->\r\n");
      out.write("<!-- 상세조회 모달 -->\r\n");
      out.write("<div class=\"modal\" id=\"selectModal\" >\r\n");
      out.write("\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t<div class=\"modal-content card mb-3\" id=\"selectContent\">\r\n");
      out.write("\t\t\t<div class=\"card-header py-3 d-flex justify-content-between bg-transparent border-bottom-0\">\r\n");
      out.write("\t\t\t\t<h6 class=\"myModal-title mb-0 fw-bold \"></h6>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t<div class=\"row g-3 align-items-center\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>게시글번호</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"rnum\" name=\"rnum\" class=\"form-control\" readonly>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" id=\"noticeBoardWriteId\" name=\"noticeBoardWriteId\" class=\"form-control\" readonly>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>분류</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"category\" name=\"category\" class=\"form-control\" readonly>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>작성자</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"noticeBoardWriter\" name=\"noticeBoardWriter\" class=\"form-control\" readonly>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>작성일자</label>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" id=\"noticeBoardWriteDate\" name=\"noticeBoardWriteDate\" class=\"form-control\" readonly>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>내용</label><br>\r\n");
      out.write("\t\t\t\t\t\t\t<textarea id=\"noticeBoardContent\" name=\"noticeBoardContent\" class=\"form-control\" rows=\"5\" cols=\"30\" readonly></textarea>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-secondary\" onclick=\"modalClose()\">닫기</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- ===================================================================================================================================== -->\r\n");
      out.write("<!-- 등록 모달 -->\r\n");
      out.write("<form id=\"insertForm\" novalidate enctype=\"multipart/form-data\" method=\"post\"> <!-- novalidate -->\r\n");
      out.write("\t<div class=\"modal\" id=\"insertModal\" >\r\n");
      out.write("\t\t<div class=\"modal-dialog\">\r\n");
      out.write("\t\t\t<div class=\"modal-content card mb-3\" id=\"insertContent\">\r\n");
      out.write("\t\t\t\t<div class=\"card-header py-3 d-flex justify-content-between bg-transparent border-bottom-0\">\r\n");
      out.write("\t\t\t\t\t<h6 class=\"mb-0 fw-bold \">글등록</h6>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t<security:csrfMetaTags/>\r\n");
      out.write("\t\t\t\t\t<div class=\"row g-3 align-items-center\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"form-label\">제목</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"text\" name=\"noticeBoardTitle\" class=\"form-control\" required>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"form-label\">분류 [공지 / FNQ]</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<select id=\"category\" name=\"category\" class=\"form-control\" required>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"공지\">공지</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"FNQ\" selected>FNQ</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"form-label\">내용</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<textarea class=\"form-control\" name=\"noticeBoardContent\" rows=\"5\" cols=\"30\" required></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"form-label\">첨부파일</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"file\" name=\"files\" multiple=\"multiple\" class=\"form-control\" >\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">등록</button>\r\n");
      out.write("\t\t\t\t\t\t<button type=\"button\" class=\"btn btn-secondary\" onclick=\"inModalClose()\">닫기</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<!-- ===================================================================================================================================== -->\r\n");
      out.write("<!-- 검색창 -->\r\n");
      out.write("<input type=\"text\" class=\"form-control\"  oninput=\"onQuickFilterChanged()\"  id=\"quickFilter\"   placeholder=\"검색...\"/>\r\n");
      out.write("<br>\r\n");
      out.write("\t\r\n");
      out.write("<!-- ===================================================================================================================================== -->\r\n");
      out.write("<!-- ag그리드 크기 -->\r\n");
      out.write("<div id=\"fnqGrid\" style=\"height: 500px; width: 100%;\" class=\"ag-theme-alpine\"></div>\r\n");
      out.write("\t\r\n");
      out.write("<!-- ===================================================================================================================================== -->\t\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//검색\r\n");
      out.write("\tfunction onQuickFilterChanged() {\r\n");
      out.write("\t\tgridOptions.api.setQuickFilter(document.getElementById('quickFilter').value);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("    // 모달 열기 / 닫기\r\n");
      out.write("\t// 조회\r\n");
      out.write("\tconst myModal = document.querySelector(\"#selectModal\");\r\n");
      out.write("\tlet files = document.getElementById('files');\r\n");
      out.write("\tconst add = (a,b) => a + b;\r\n");
      out.write("\r\n");
      out.write("\tconst noticeBoard = {\r\n");
      out.write("\t\tnoticeBoardWriteId : '',\r\n");
      out.write("\t}\r\n");
      out.write("\tconst modalOpen = () => {\r\n");
      out.write("\t\tmyModal.style.display = \"block\";    // 보이게\r\n");
      out.write("\r\n");
      out.write("\t\theaders['Content-Type'] = 'application/json'\r\n");
      out.write("\t\theaders['accept'] = 'application/json'\r\n");
      out.write("\t\tconsole.log(\"JSON.stringify(noticeBoard) = \",JSON.stringify(noticeBoard))\r\n");
      out.write("\t\taxios.get(`/ourmine/noticeBoard/noticeBoardSelect/${noticeBoard.noticeBoardWriteId}`, {headers:headers})\r\n");
      out.write("\t\t\t\t.then(resp => {\r\n");
      out.write("\t\t\t\t\tfiles.innerHTML = '';\r\n");
      out.write("\t\t\t\t\tlet data = resp.data;\r\n");
      out.write("\t\t\t\t\tconsole.log(data);\r\n");
      out.write("\t\t\t\t\tfiles.innerHTML += data.files.map(item => item.original !== null ?  `<a href=\"/ourmine/uploadAAA/${item.uuid}\" download=\"${item.original}\">${item.original}<a><br>` : `<a></a>`).join('');\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\tconst modalClose = () => {\r\n");
      out.write("\t\tmyModal.style.display = \"none\";    // 안보이게\r\n");
      out.write("\t\tfgetData();\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t// 등록\r\n");
      out.write("\tconst inModal = document.querySelector(\"#insertModal\");\r\n");
      out.write("\tconst inModalClose = () => {\r\n");
      out.write("\t\tinModal.style.display = \"none\";    // 안보이게\r\n");
      out.write("    }\r\n");
      out.write("\tconst inModalOpen = () => {\r\n");
      out.write("\t\t$('#insertForm')[0].reset();\r\n");
      out.write("\t\tinModal.style.display = \"block\";    // 보이게\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("//\t<!-- ===================================================================================================================================== -->\r\n");
      out.write("\t// 그리드\r\n");
      out.write("\tconst gridDiv = document.querySelector(\"#fnqGrid\");\r\n");
      out.write("\r\n");
      out.write("    const fgetData = () => {   // 데이터 가져오는 비동기처리 \r\n");
      out.write("        // gridOptions.api. 대부분의 유용한 메소드가 여기에 있다\r\n");
      out.write("        const xhr = new XMLHttpRequest();\r\n");
      out.write("        xhr.open(\"get\",\"/ourmine/noticeBoard/fnqNoticeBoardListJson\", true);\r\n");
      out.write("        xhr.onreadystatechange = () => {\r\n");
      out.write("            if (xhr.readyState == 4 && xhr.status == 200) {\r\n");
      out.write("                console.log(\"responseText : \", xhr.responseText);\r\n");
      out.write("                gridOptions.rowData = JSON.parse(xhr.responseText);\r\n");
      out.write("\t\t\t\t\tdocument.getElementById('fnqGrid').innerHTML=\"\";\r\n");
      out.write("\t\t\t\tnew agGrid.Grid(gridDiv, gridOptions);\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        xhr.send();\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    const columnDefs = [\r\n");
      out.write("        { field: \"rnum\", headerName: \"번호\", cellStyle: {textAlign: 'center'}, maxWidth: 150 },\r\n");
      out.write("        { field: \"category\", headerName: \"분류\", cellStyle: {textAlign: 'center'}, maxWidth: 150 },\r\n");
      out.write("        { field: \"noticeBoardTitle\", headerName: \"제목\", cellStyle: {textAlign: 'left'}, maxWidth: 200 },\r\n");
      out.write("        { field: \"noticeBoardWriter\", headerName: \"작성자\", cellStyle: {textAlign: 'center'}, maxWidth: 180 },\r\n");
      out.write("        { field: \"noticeBoardContent\", headerName: \"내용\", cellStyle: {textAlign: 'left'}, minWidth: 300 },\r\n");
      out.write("        { field: \"noticeBoardWriteDate\", headerName: \"작성일자\", cellStyle: {textAlign: 'center'}, maxWidth: 180 }\r\n");
      out.write("    ];\r\n");
      out.write("    \r\n");
      out.write("    // let the grid know which columns and what data to use\r\n");
      out.write("    const gridOptions = {\r\n");
      out.write("        defaultColDef: {    // 일일이 컬럼에 정의하지 않고 한번에 기본 옵션 설정!\r\n");
      out.write("            sortable: true,\r\n");
      out.write("            filter: true,\r\n");
      out.write("            resizable: true,\r\n");
      out.write("            editable: false\r\n");
      out.write("        },\r\n");
      out.write("\t\tcolumnDefs: columnDefs,\r\n");
      out.write("        pagination: true,\r\n");
      out.write("        paginationAutoPageSize: true,\r\n");
      out.write("        onGridReady: function (event) {\t\t// 열 자동 조절 기능\r\n");
      out.write("            event.api.sizeColumnsToFit();\r\n");
      out.write("        },\r\n");
      out.write("        rowSelection: 'single',\r\n");
      out.write("        onCellClicked: params => { // example event handler\r\n");
      out.write("        \tconsole.log(\"클릭\", params.data);\r\n");
      out.write("\t\t\tnoticeBoard.noticeBoardWriteId = params.data.noticeBoardWriteId;\r\n");
      out.write("\t\t\tconsole.log(\"noticeBoard.noticeBoardWriteId = params.data.noticeBoardWriteId = \", noticeBoard.noticeBoardWriteId);\r\n");
      out.write("            \r\n");
      out.write("            let noticeBoardVO = params.data;\r\n");
      out.write("            $(\".myModal-title\").html(noticeBoardVO.noticeBoardTitle);\r\n");
      out.write("            $(\"#noticeBoardWriteId\").val(noticeBoardVO.noticeBoardWriteId);\r\n");
      out.write("            $(\"#rnum\").val(noticeBoardVO.rnum);\r\n");
      out.write("    \t\t$(\"#category\").val(noticeBoardVO.category);\r\n");
      out.write("            $(\"#noticeBoardWriter\").val(noticeBoardVO.noticeBoardWriter);\r\n");
      out.write("            $(\"#noticeBoardWriteDate\").val(noticeBoardVO.noticeBoardWriteDate);\r\n");
      out.write("            $(\"#noticeBoardContent\").html(noticeBoardVO.noticeBoardContent);\r\n");
      out.write("            $(\".files\").val(noticeBoardVO.files);\r\n");
      out.write("\t\t\t\r\n");
      out.write("            modalOpen();\t// 보이게\r\n");
      out.write("            \r\n");
      out.write("        }\r\n");
      out.write("    };\r\n");
      out.write("\r\n");
      out.write("//     fgetData(); // 게시판 전체조회 ajax 바로 실행\r\n");
      out.write("    \r\n");
      out.write("    // setup the grid after the page has finished loading\r\n");
      out.write("    document.addEventListener('DOMContentLoaded', () => {\r\n");
      out.write("    \tfgetData(); // 가독성을 위해성 , 나중에 꺼내기\r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("//\t<!-- ===================================================================================================================================== -->\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t// 글 등록\r\n");
      out.write("\t\t$('#insertForm').submit(function(e) {\r\n");
      out.write("\t        e.preventDefault();\r\n");
      out.write("\t\t\tconsole.log(\"폼체크 : \", $('#insertForm')[0]);\r\n");
      out.write("\r\n");
      out.write("\t\t\tlet jForm = $('#insertForm').serialize();\r\n");
      out.write("\t\t\tconsole.log(\"값: \",jForm, headers);\r\n");
      out.write("\r\n");
      out.write("\t\t\tlet formData = new FormData($('#insertForm')[0]);\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype: 'POST',\r\n");
      out.write("\t\t\t\turl: '/ourmine/noticeBoard/noticeBoardForm',\r\n");
      out.write("\t\t\t\tdata: formData,\r\n");
      out.write("\t\t\t\tcontentType: false,\t// 파일 추가 시 필수. 'application/json'사용 불가\r\n");
      out.write("\t\t\t\tprocessData: false,\t// 파일 추가 시 필수\r\n");
      out.write("\t\t\t\tcache: false,\t// 파일 추가 시 선택사항\r\n");
      out.write("\t\t\t\tbeforeSend:function(xhr){\t// headers에 contentType='application/json'포함되어 있어 따로 적어줘야 함\r\n");
      out.write("\t\t\t\t\txhr.setRequestHeader(headerName, headerValue);\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess: function(res) {\r\n");
      out.write("\t\t\t\t\tconsole.log(\"확인 : \", res);\r\n");
      out.write("\t\t\t\t\t$('#insertModal').hide();\r\n");
      out.write("\t\t\t\t\t$('#insertForm')[0].reset();\r\n");
      out.write("\t\t\t\t\tfgetData();\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror: function(xhr, status, error) {\r\n");
      out.write("\t\t\t\t\talert('게시글 등록에 실패하였습니다.');\r\n");
      out.write("\t\t\t        console.log(\"error: \" + error);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
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
