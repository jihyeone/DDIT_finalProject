<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
body {
  font-family: Roboto, sans-serif;
}


</style>
<script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
<c:set var="projectWholeCount" value="${projectWholeCount }"/>
<c:set var="projectStatusIncomplete" value="${projectStatusIncomplete }"/>
<c:set var="projectStatusComplete" value="${projectStatusComplete }"/>
<c:set var="projectWorkPriorityCount" value="${projectWorkPriorityCount }"/>
<c:set var="projectWorkPriorityEmergency" value="${projectWorkPriorityEmergency }"/>
<c:set var="projectWorkPriorityHigh" value="${projectWorkPriorityHigh }"/>
<c:set var="projectWorkPriorityNormal" value="${projectWorkPriorityNormal }"/>
<c:set var="projectWorkPriorityLow" value="${projectWorkPriorityLow }"/>
<c:set var="projectWorkStatusCount" value="${projectWorkStatusCount }"/>
<c:set var="projectWorkStatusRequest" value="${projectWorkStatusRequest }"/>
<c:set var="projectWorkStatusProceed" value="${projectWorkStatusProceed }"/>
<c:set var="projectWorkStatusFeedback" value="${projectWorkStatusFeedback }"/>
<c:set var="projectWorkStatusPostpone" value="${projectWorkStatusPostpone }"/>
<c:set var="projectWorkStatusComplete" value="${projectWorkStatusComplete }"/>
<c:set var="projectWorkIssueStatusCount" value="${projectWorkIssueStatusCount }"/>
<c:set var="projectWorkIssueStatusEmergency" value="${projectWorkIssueStatusEmergency }"/>
<c:set var="projectWorkIssueStatusNormal" value="${projectWorkIssueStatusNormal }"/>
<c:set var="projectWorkIssueStatusLow" value="${projectWorkIssueStatusLow }"/>

 <div class="col-xl-12 col-lg-12 col-md-12">
    <div class="row gx-3 row-cols-1 row-cols-sm-1 row-cols-md-1 row-cols-lg-3 row-cols-xl-3 row-cols-xxl-3">
        <div class="col">
            <div class="card mb-3">
                <div class="card-header d-flex justify-content-between align-items-center bg-transparent border-bottom-0">
                    <h6 class="m-0 fw-bold">전체 프로젝트 진행도</h6>
                </div>
                <div class="card-body">
					<div id= "projectChart">
					</div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card mb-3">
                <div class="card-header d-flex justify-content-between align-items-center bg-transparent border-bottom-0">
                    <h6 class="m-0 fw-bold">우선순위 별 전체 일감</h6>
                </div>
                <div class="card-body">
                    <div id="projectWorkByPriority"></div>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card mb-3">
                <div class="card-header d-flex justify-content-between align-items-center bg-transparent border-bottom-0">
                    <h6 class="m-0 fw-bold">상태 별 전체 일감</h6>
                </div>
                <div class="card-body">
                    <div id="projectWorkByStatus"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="btn-group" role="group" aria-label="Basic example">
    <c:forEach var="projectList" items="${projectList}" varStatus="loop">
        <button type="button" class="btn btn-primary" value="${projectList.PROJECT_ID}" onclick="getIssueList(this)">${projectList.PROJECT_NAME}</button>
    </c:forEach>
</div>

<div class="row">
    <div class="col-md-6">
        <div class="card mb-3">
            <div class="card-header d-flex justify-content-between align-items-center bg-transparent border-bottom-0">
                <h6 class="m-0 fw-bold">이슈 카테고리 별 분포도</h6>
            </div>
            <div class="card-body">
                <div id="chart" style="width: 80%; height: 60%;"></div>
            </div>
        </div>
    </div>
    <div class="col-md-6">
        <div class="card mb-3">
            <div class="card-header d-flex justify-content-between align-items-center bg-transparent border-bottom-0">
                <h6 class="m-0 fw-bold">프로젝트 별 이슈 리스트</h6>
            </div>
            <div class="card-body">
                <table class="table table-striped" style="width: 100%; height: 100%;">
                    <thead>
                        <tr>
                            <th scope="col">이슈</th>
                            <th scope="col">코멘트</th>
                        </tr>
                    </thead>
                    <tbody id="issueList">
                    <!-- 이슈 정보 출력 -->
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>




<script>
$(document).ready(function() {
    $(".btn-group .btn:first-child").trigger("click");
});
function getIssueList(button) {
    var projectId = button.value;
    console.log("Selected projectId:", projectId);

    // 선택한 projectId를 활용하여 원하는 동작 수행
    // 예를 들어, getProjectIssues(projectId) 함수 호출 등
    getProjectIssues(projectId);
    getProjectIssueCategory(projectId);
    
}

function getProjectIssues(projectId){
	 $.ajax({
	        url: "/ourmine/company/${companyId}/statistics/getProjectIssues",
	        type: "GET",
	        data: { projectId: projectId },
	        dataType: "json",
	        success: function(response) {
	        	var projectIssues = response;
	            var tbody = $("#issueList");
	            tbody.empty(); // 기존 내용 초기화

	            // 프로젝트 이슈 정보 출력
	            for (var i = 0; i < projectIssues.length; i++) {
	                var issue = projectIssues[i];
	                var issueContent = issue.issueContent;
	                var issueComment = issue.projectIssueComment;

	                var row = "<tr>" +
	                            "<td>" + issueContent + "</td>" +
	                            "<td>" + issueComment + "</td>" +
	                          "</tr>";
	                tbody.append(row);
	            }
	        },
	        error: function(xhr, status, error) {
	            console.error(error);
	        }
	    });
};

function getProjectIssueCategory(projectId) {
    $.ajax({
        url: "/ourmine/company/${companyId}/statistics/getProjectIssueCategory",
        type: "GET",
        data: { projectId: projectId },
        dataType: "json",
        success: function(response) {
            var chartData = response;

            // 차트 데이터 처리
            var categories = Object.keys(chartData).map(function(key) {
            if (key === "error") {
                return "에러";
            } else if (key === "modify") {
                return "수정";
            } else if (key === "event") {
                return "이벤트";
            }
            return key;
	        });
	        var data = Object.values(chartData);
		
            // Simple Pie Chart 생성
            var options = {
                series: data,
                labels: categories,
                chart: {
                    type: 'pie',
                },
                plotOptions: {
                    pie: {
                        size: '50%' // 파이의 크기 조절
                    }
                },
                responsive: [{
                    breakpoint: 480,
                    options: {
                        chart: {
                            width: 100,
                            height: 100
                        },
                        legend: {
                            position: 'bottom'
                        }
                    }
                }]
            };

            var chart = new ApexCharts(document.querySelector("#chart"), options);
            chart.render();
        },
        error: function(xhr, status, error) {
            console.error(error);
        }
    });
}





var projectWholeCount = ${projectWholeCount};
var projectStatusIncomplete = ${projectStatusIncomplete};
var projectStatusComplete = ${projectStatusComplete};

var projectWorkPriorityCount = ${projectWorkPriorityCount};
var projectWorkPriorityEmergency = ${projectWorkPriorityEmergency};
var projectWorkPriorityHigh = ${projectWorkPriorityHigh};
var projectWorkPriorityNormal = ${projectWorkPriorityNormal};
var projectWorkPriorityLow = ${projectWorkPriorityLow};

var projectWorkStatusRequest = ${projectWorkStatusRequest};
var projectWorkStatusProceed = ${projectWorkStatusProceed};
var projectWorkStatusFeedback = ${projectWorkStatusFeedback};
var projectWorkStatusPostpone = ${projectWorkStatusPostpone};
var projectWorkStatusComplete = ${projectWorkStatusComplete};

var incompletePercentage = (projectStatusIncomplete / projectWholeCount) * 100;
var completePercentage = (projectStatusComplete / projectWholeCount) * 100;

var workEmergencyPercentage = (projectWorkPriorityEmergency / projectWorkPriorityCount) * 100;
var workHighPercentage = (projectWorkPriorityHigh / projectWorkPriorityCount) * 100;
var workNormalPercentage = (projectWorkPriorityNormal / projectWorkPriorityCount) * 100;
var workLowPercentage = (projectWorkPriorityLow / projectWorkPriorityCount) * 100;

var workRequestPercentage = (projectWorkPriorityEmergency / projectWorkPriorityCount) * 100;
var workProceedPercentage = (projectWorkPriorityHigh / projectWorkPriorityCount) * 100;
var workFeedbackPercentage = (projectWorkPriorityNormal / projectWorkPriorityCount) * 100;
var workPostponePercentage = (projectWorkPriorityLow / projectWorkPriorityCount) * 100;
var workCompletePercentage = (projectWorkPriorityLow / projectWorkPriorityCount) * 100;



var options1 = {
  chart: {
    height: 280,
    type: "radialBar",
  },
  series: [incompletePercentage.toFixed(0), completePercentage.toFixed(0)],
  plotOptions: {
    radialBar: {
      dataLabels: {
    	show: true,
    	value : {
    		show: true,
    		formatter: function (val) {
                return val  + '%'
              }
    	},
    	
        total: {
          show: false,
          label: '전체'
        }
      }
    }
  },
  labels: ['진행중', '완료']
};
var chart1 = new ApexCharts(document.querySelector("#projectChart"), options1);
chart1.render();

var options2 = {
  chart: {
    height: 280,
    type: "radialBar",
  },
  series: [workEmergencyPercentage.toFixed(0), 
	  	workHighPercentage.toFixed(0), 
	  	workNormalPercentage.toFixed(0), 
	  	workLowPercentage.toFixed(0)],
  plotOptions: {
    radialBar: {
      dataLabels: {
    	show: true,
   	  	name: {
             show: true,
           },  
    	value : {
    		show: true,
    		fontSize: '14px',
    		formatter: function (val) {
                return val  + '%'
              }
    	},
    	
        total: {
          show: false,
          label: '전체'
          
        }
      }
    }
  },
  labels: ['긴급', '높음', '보통', '낮음']
};
var chart2 = new ApexCharts(document.querySelector("#projectWorkByPriority"), options2);
chart2.render();

var options3 = {
  chart: {
    height: 280,
    type: "radialBar",
  },
  series: [workRequestPercentage.toFixed(0), 
	  workProceedPercentage.toFixed(0), 
	  workFeedbackPercentage.toFixed(0), 
	  workPostponePercentage.toFixed(0),
	  workCompletePercentage.toFixed(0)],
  plotOptions: {
    radialBar: {
      dataLabels: {
    	show: true,
   	  	name: {
             show: true,
           },  
    	value : {
    		show: true,
    		fontSize: '14px',
    		formatter: function (val) {
                return val  + '%'
              }
    	},
    	
        total: {
          show: false,
          label: '전체'
          
        }
      }
    }
  },
  labels: ['요청', '진행', '피드백', '보류', '완료']
};
var chart3 = new ApexCharts(document.querySelector("#projectWorkByStatus"), options3);
chart3.render();


</script>

