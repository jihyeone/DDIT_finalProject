<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="${cPath}/resources/js/sweetalert2/sweetalert2.min.css">

<style>
    /* CSS */
    #simple-tree-sidebar {
        transform: translateX(100%);
        transition: transform 0.5s ease-out;
    }

    #simple-tree-sidebar.visible {
        transform: translateX(0);
    }

    #simple-tree-sidebar {
        position: fixed;
        right: 0;
        top: 0;
        height: 100%;
        width: 300px;
        overflow-y: auto;
        background: white;
        border-left: 1px solid #ccc;
        transform: translateX(100%);
        transition: transform 0.3s ease-out;
    }

    #simple-tree-sidebar.visible {
        transform: translateX(0);
    }

    .folder {
        border: 1px solid #000;
        margin: 10px;
        padding: 10px;
    }

    .folder-toggle {
        cursor: pointer;
        font-weight: bold;
    }

    .folder-details {
        display: none; /* 초기에는 감춰져 있습니다. */
    }

    .folder.open .folder-details {
        display: block; /* folder가 open 클래스를 가지면 보입니다. */
    }

    .orgchartBtn:hover {
        cursor: pointer;
    }

    @keyframes pulse {
        0% {
            background-color: #fff; /* 시작색 */
        }
        50% {
            background-color: orange; /* 중간색 */
        }
        100% {
            background-color: #fff; /* 종료색 */
        }
    }

    .orange {
        border-radius: 50%;  /* 동그랗게 만들기 */
        overflow: hidden;  /* 내부의 모든 요소도 동그랗게 만들기 */
    }
/*      .modal{
	 	position: fixed;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
		background: rgba(0, 0, 0, 0.8);
	} */

	#hmList{
		list-style-type: none;
		padding-left: 0rem

	}

	.swal2-container {
		z-index: 9999999999999;
	}
    .myToastContainer {
        position: fixed;
        top: 1rem;
        right: 1rem;
        z-index: 9999;
    }

    .myToast {
        display: none; /* initially hidden */
        position: fixed;
        top: 2%; /* adjust as per requirement */
        right: 30%; /* adjust as per requirement */
        min-width: 200px;
        max-width: 350px;
        background-color: white;
        box-shadow: 0 0.25rem 0.75rem rgba(0, 0, 0, .1);
        color: black;
        z-index: 1050;
    }

    .myToast.show {
        display: block; /* displayed when .show class added */
    }

    .myToast-header {
        display: flex;
        align-items: center;
        padding: 0.5rem 1rem;
        color: black;
        background-color: rgba(0, 0, 0, .03);
        border-bottom: 1px solid rgba(0, 0, 0, .05);
    }

    .myToast-body {
        padding: 0.5rem 1rem;
        color: black;
    }

    .myToast-btn-close {
        background: none;
        border: none;
        cursor: pointer;
        padding: 0;
        float: right;
        font-size: 1.5rem;
        font-weight: 700;
        line-height: 1;
        color: black;
        text-shadow: 0 1px 0 #fff;
        opacity: .5;
    }


</style>

<security:authentication property="principal" var="principal"/>

<c:set var="companyId" value="${principal.realUser.companyId}" />
<c:choose>
   <c:when test="${companyId eq 0 }">
      <script>
          const companyId1 = undefined;
          console.log("companyId1 =",companyId1)
       </script>
   </c:when>
   <c:otherwise>
      <script>
         const companyId1 = ${companyId};
         console.log("companyId1 =",companyId1)
      </script>
   </c:otherwise>
</c:choose>

<!-- Body: Header -->
<!-- <div class="container-xxl"> -->

    <!-- header rightbar icon -->
    <div class="h-right d-flex align-items-center mr-5 mr-lg-0 order-1">
        <div class="d-flex">

            <!-- 채팅 -->
            <a class="nav-link collapsed" href="/ourmine/company/${companyId}/chat/chat" title="Chat">
                <i class="icofont-chat fs-4"></i>
            </a>

            <!-- 조직도 --><!-- text-primary : 글자색 -->
            <a type="a" href="/ourmine/company/${companyId}/orgchart/orgchartList" class="nav-link collapsed orgchartBtn" title="Organization chart">
                <i class="icofont-company fs-4"></i>
            </a>

			<!-- 알림(종) 아이콘 -->
			<div class="dropdown notifications zindex-popover">
				<a class="nav-link dropdown-toggle pulse" href="#" role="button" data-bs-toggle="dropdown">
					<i class="icofont-alarm fs-4 orange"></i>
					<span class="pulse-ring"></span>
				</a>
				<div id="notification-icon">
					<span class="badge" id="notification-badge"></span>
				</div>
				<div id="NotificationsDiv" class="dropdown-menu rounded-lg shadow border-0 dropdown-animation dropdown-menu-sm-end p-0 m-0">
					<div class="card border-0 w380">
						<div class="card-header border-0 p-3">
							<h5 class="mb-0 font-weight-light d-flex justify-content-between alarmCount">

							</h5>
						</div>

						<!-- 알림 내용 -->
						<div class="tab-content card-body">
							<div class="tab-pane fade show active">
								<ul class="list-unstyled list mb-0">
									<li class="py-2 mb-1 border-bottom alarmList">

									</li>
								</ul>
							</div>
						</div>
						<a class="card-footer text-center border-top-0" href="#"> View all notifications</a>
					</div>
				</div>
			</div>

        </div>


        <!-- 프로필 -->
        <!-- Manager -->
        <security:authorize access="hasRole('MANAGER')">
        <security:authentication property="principal" var="authMember"/>
        <div class="dropdown user-profile ml-2 ml-sm-3 d-flex align-items-center zindex-popover">
            <div class="u-info me-2">
                <p class="mb-0 text-end line-height-sm "><span class="font-weight-bold"><security:authentication property="principal.realUser.memberName"/></span></p>
	<%--             <security:authentication property="principal.authorities"/> --%>
				
               <small style="color: orange;">
                <c:set var="companyName" value="${principal.realUser.companyName }"/>
               <c:choose>
	               <c:when test="${not empty companyName}">
		               <security:authentication property="principal.realUser.companyName"/>,
	               </c:when>
	               <c:otherwise>
	                  회사정보가 없습니다.
	               </c:otherwise>
               </c:choose>
                                <security:authentication property="principal.realUser.memberGrade"/></small>
            </div>
            <a class="nav-link dropdown-toggle pulse p-0 memberImage" href="#" role="button" data-bs-toggle="dropdown" data-bs-display="static">

            </a>

            <div class="dropdown-menu rounded-lg shadow border-0 dropdown-animation dropdown-menu-end p-0 m-0">
                <div class="card border-0 w280">
                    <div class="card-body pb-0">
                        <div class="d-flex py-1">
                        <span class="memberImage2"></span>
                            <%-- <img class="avatar rounded-circle" src="${cPath}/resources/mytask/documentation/assets/images/profile_av.png" alt="profile"> --%>
                            <div class="flex-fill ms-3">
                                <p class="mb-0"><span class="font-weight-bold"><security:authentication property="principal.realUser.memberName"/></span></p>
                                <small class="">${authMember.username}</small>
                                <!-- 구독 정보 -->
                                <br>
							   <security:authorize access="hasRole('MANAGER')">
								   <small>
									    남은 구독 일자 :
									    <security:authentication property="principal.realUser.subscribeDate"/>
									    일

									    <a class="ms-link active" href="/ourmine/subscribe/itemList.do">
									    <br>
									    <i class="icofont-pay"></i><span> 결제하기</span></a>
								   </small>
							    </security:authorize>
                            </div>
                        </div>

                        <div><hr class="dropdown-divider border-dark"></div>
                    </div>
                     <div class="list-group m-2 ">
                    	<ul id="hmList">
	                        <li><a href="/ourmine/project/projectList" class="list-group-item list-group-item-action border-0 "><i class="icofont-home fs-5 me-3"></i>프로젝트</a></li>
	                        <li><a href="/ourmine/member/memberList" class="list-group-item list-group-item-action border-0 "><i class="icofont-tasks fs-5 me-3"></i>직원관리</a></li>
	<!--                         <a href="/ourmine/member/memberView" class="list-group-item list-group-item-action border-0 "><i class="icofont-user-alt-3 fs-5 me-3"></i>MyPage</a> -->
	                        <li data-bs-toggle="modal" data-bs-target="#detailProfile"><a href="#"  class="list-group-item list-group-item-action border-0 "><i class="icofont-user-alt-3 fs-5 me-3"></i>내 프로필</a></li>
	                        <li><a href="" class="list-group-item list-group-item-action border-0 "><i class="icofont-users-alt-5 fs-5 me-3"></i>회사 인원 추가하기</a></li>
		                  		<form id="logoutForm" action="${cPath}/logout" method="post">
		                        	<security:csrfInput/>
		                        </form>
	                        <li><a href="javascript:$('#logoutForm').submit();" class="list-group-item list-group-item-action border-0 "><i class="icofont-logout fs-6 me-3"></i>로그아웃</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        </security:authorize>

        <!-- Member -->
        <security:authorize access="hasRole('MEMBER')">
	<%--         <security:authorize access="isAuthenticated()"> --%>
        <security:authentication property="principal" var="authMember"/>
        <div class="dropdown user-profile ml-2 ml-sm-3 d-flex align-items-center zindex-popover">
            <div class="u-info me-2">
                <p class="mb-0 text-end line-height-sm "><span class="font-weight-bold"><security:authentication property="principal.realUser.memberName"/></span></p>
	<%--             <security:authentication property="principal.authorities"/> --%>
               <small style="color: orange;">

               <!-- 회사정보 유무 확인 후 메뉴 출력 -->
               <c:set var="companyName" value="${principal.realUser.companyName }"/>
               <c:choose>
	               <c:when test="${not empty companyName}">
		               <security:authentication property="principal.realUser.companyName"/>,
	               </c:when>
	               <c:otherwise>
	                  회사정보가 없습니다.
	               </c:otherwise>
               </c:choose>
		       <security:authentication property="principal.realUser.memberGrade"/>
               </small>
            </div>
            <a class="nav-link dropdown-toggle pulse p-0 memberImage" href="#" role="button" data-bs-toggle="dropdown" data-bs-display="static">

            </a>

            <div class="dropdown-menu rounded-lg shadow border-0 dropdown-animation dropdown-menu-end p-0 m-0">
                <div class="card border-0 w280">
                    <div class="card-body pb-0">
                        <div class="d-flex py-1">
                            <span class="memberImage2"></span>
                           <%-- <img class="avatar rounded-circle" src="${cPath}/resources/mytask/documentation/assets/images/profile_av.png" alt="profile">--%>
                            <div class="flex-fill ms-3">
                                <p class="mb-0"><span class="font-weight-bold"><security:authentication property="principal.realUser.memberName"/></span></p>
                                <small class="">${authMember.username}</small>
                            </div>
                        </div>

                        <div><hr class="dropdown-divider border-dark"></div>
                    </div>
                    <div class="list-group m-2 ">
                    	<ul id="hmList">
	                        <li><a href="projects.html" class="list-group-item list-group-item-action border-0 "><i class="icofont-home fs-6 me-3"></i>프로젝트</a></li>
	                        <li><a href="/task.html" class="list-group-item list-group-item-action border-0 "><i class="icofont-tasks fs-5 me-3"></i>작업</a></li>
	                        <li data-bs-toggle="modal" data-bs-target="#detailProfile"><a href="#" class="list-group-item list-group-item-action border-0 "><i class="icofont-user-alt-3 fs-5 me-3"></i>내 프로필</a></li>
	                       <!--  <a href="/ourmine/member/memberView" class="list-group-item list-group-item-action border-0 "><i class="icofont-user-alt-3 fs-5 me-3"></i>MyPage</a> -->
		               			<c:if test="${empty companyName}">
			                        <li><a href="/ourmine/company/companyListJoin" class="list-group-item list-group-item-action border-0 "><i class="icofont-contact-add fs-5 me-3"></i>회사 가입하기</a></li>
		               			</c:if>
	                        <form id="logoutForm" action="${cPath}/logout" method="post">
	                        	<security:csrfInput/>
	                        </form>
	                        <li><a href="javascript:$('#logoutForm').submit();" class="list-group-item list-group-item-action border-0 "><i class="icofont-logout fs-6 me-3"></i>로그아웃</a></li>
	<!--                         <a href="ui-elements/auth-signin.html" class="list-group-item list-group-item-action border-0 "><i class="icofont-logout fs-6 me-3"></i>로그아웃</a> -->
						</ul>
                    </div>
                </div>
            </div>
        </div>


        </security:authorize>
        <!-- 프로필 끝 -->

	</div>
<!-- </div> -->
           <!-- 상세모달 -->

                <div class="modal" id="modifyModal" style="display: none" >
                    <div class="modal-dialog">
                        <div class="modal-content card mb-3">
                            <div class="card-body">
                                <div class="row g-3 align-items-center">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>내용</label>
                                            <textarea id="alarmTitle" name="noticeBoardTitle" class="myModal-title form-control"></textarea>
                                        </div>
                                    </div>

                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>보낸이</label>
                                            <input type="text" id="alarmWriter" name="noticeBoardWriter" class="form-control" readonly>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>작성일자</label>
                                            <input type="text" id="alarmDate" name="noticeBoardWriteDate" class="form-control" readonly>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary ararmekerl" data-bs-dismiss="modal">닫기</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

<!-- 조직도 트리 형태 -->
    <div id="simple-tree-sidebar" class="sidebar px-4 py-4 py-md-5 me-0">


    </div>

    <!-- menu toggler -->
    <button class="navbar-toggler p-0 border-0 menu-toggle order-3" type="button" data-bs-toggle="collapse" data-bs-target="#mainHeader">
        <span class="fa fa-bars"></span>
    </button>

    <!-- 메인 검색창 -->
    <div class="order-0 col-lg-4 col-md-4 col-sm-12 col-12 mb-3 mb-md-0 ">
        <div class="input-group flex-nowrap input-group-lg">
<!--             <button type="button" class="input-group-text" id="addon-wrapping"><i class="fa fa-search"></i></button> -->
            <input type="hidden" class="form-control" placeholder="Search" aria-label="search" aria-describedby="addon-wrapping">
<!--             <button type="button" class="input-group-text add-member-top" id="addon-wrappingone" data-bs-toggle="modal" data-bs-target="#addUser"><i class="fa fa-plus"></i></button> -->
        </div>
    </div>




<!-- ======================= 마이페이지 상세조회 모달  =============================================-->
<div class="modal fade" id="detailProfile" tabindex="-1" aria-labelledby="detailModalCenterTitle" style="display: none;" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="detailModalCenterTitle">내 프로필</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body" id="myPage">

            </div>
            <div class="modal-footer">
				<button type="button" class="btn btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#editProfile"><i class="icofont-edit text-success"></i> 수정</button>
                <button type="button" class="btn btn-outline-secondary" data-bs-toggle="modal" data-bs-target="#deleteProfile"><i class="icofont-ui-delete text-danger"></i> 삭제</button>
            </div>
        </div>
    </div>
</div>

<!-- ======================= 마이페이지 수정 모달  =============================================-->
<form id="sub" enctype="multipart/form-data" method="post" action="/ourmine/member/memberUpdate">
	<div class="modal fade" id="editProfile" tabindex="-1" aria-hidden="true">

	    <div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">

	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title  fw-bold" id="editProfileLabel">내 프로필 수정</h5>
	                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	            </div>

	            <div class="modal-body" id="modiMpModalbody">

	            </div>
	        </div>
	    </div>
	</div>
</form>

<!-- ======================= 마이페이지  삭제모달  =============================================-->
<div id="Page" >
  	<form class="mpDelForm" onsubmit="deleteSubmit(event)" enctype="multipart/form-data">
	   	<div class="modal fade deleteModal" id="deleteProfile" tabindex="-1" aria-hidden="true">

			<div class="modal-dialog modal-dialog-centered modal-md modal-dialog-scrollable">
				<div class="modal-content">
					<div id="project-id" class="form-label"></div>
					<div class="modal-header">
						<h5 class="modal-title  fw-bold" id="deleteProfileLabel">본인 확인을 위해 비밀번호를 입력해주세요!</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body justify-content-center flex-column d-flex">
						<input name="memberPassword" type="password" class="form-control nameInput memberPass" id="exampleFormControlInput78" value="" onchange="passChange(event)">
						<p class="mt-4 fs-5 text-center passTag"></p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary deleteCancel" data-bs-dismiss="modal" onclick="handleCancel()">Cancel</button>
						<button type="submit" id="delBtn" class="btn btn-danger color-fff">Delete</button>
					</div>
				</div>
			</div>
	   	</div>
	</form>
</div>

<div id="myToast" class="myToast" role="alert" aria-live="assertive" aria-atomic="true">
    <div class="myToast-header">
        <img src="${cPath}/resources/images/lg/마스코트_투명.png" class="avatar sm rounded me-1" alt="" />
        <strong class="me-auto">Bootstrap</strong>
        <small class="text-muted">just now</small>
        <button type="button" class="myToast-btn-close" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <div class="myToast-body">
        Hello, world! This is a toast message.
    </div>
</div>

<script type="text/javascript">

headers['Content-Type'] = 'application/json'
headers['accept'] = 'application/json'
let meAuto = document.querySelector('.me-auto');
let myToastBody = document.querySelector('.myToast-body');
let textMuted = document.querySelector('.text-muted');

let orgchartBtn = document.querySelector('.orgchartBtn');
const sidebar = document.getElementById("simple-tree-sidebar");
let memberImage = document.querySelector('.memberImage');
let memberImage2 = document.querySelector('.memberImage2');
let alarmForm = document.querySelector('#alarmForm');
let alarmTitle = document.querySelector('#alarmTitle');
let alarmWriter = document.querySelector('#alarmWriter');
let alarmDate = document.querySelector('#alarmDate');
let alarmContent = document.querySelector('#alarmContent');
let ararmekerl = document.querySelector('.ararmekerl');

async function memberImageList(){
await axios.get('/ourmine/member/memberViewJson',{headers:headers})
		.then(resp => {
			let data = resp.data;
			console.log('data = ',data)
			memberImage.innerHTML = '';
			memberImage2.innerHTML = '';
			let array = []
			array.push(data);
			array.map(item => {
				if(item.imageContents === null){
					console.log('이미지없음')
                    memberImage.innerHTML +=  `<img class="avatar lg rounded-circle img-thumbnail" src="${cPath}/resources/mytask/documentation/assets/images/profile_av.png" alt="profile">`
					memberImage2.innerHTML += `<img class="avatar lg rounded-circle img-thumbnail" src="${cPath}/resources/mytask/documentation/assets/images/profile_av.png" alt="profile">`
				}else{
					console.log('이미지있음')
					memberImage.innerHTML +=  `<img class="avatar lg rounded-circle img-thumbnail" src="\${item.imageContents}" alt="profile">`
					memberImage2.innerHTML += `<img class="avatar lg rounded-circle img-thumbnail" src="\${item.imageContents}" alt="profile">`
				}
			})
		})
}
memberImageList();
// Toast 메시지를 생성하는 함수
// 토스트를 표시하는 함수
function showToast() {
	let toast = document.getElementById("myToast");

	// 토스트 보이기
	toast.style.display = "block";

	// 약간의 딜레이 후 .show 클래스 추가
	setTimeout(function() {
		toast.classList.add("show");
	}, 200);

	// 토스트 닫기 버튼 이벤트 리스너
	let closeButton = document.querySelector('.myToast-btn-close');
	closeButton.addEventListener('click', function() {
		toast.style.display = 'none';
	});
	// 일정 시간(5초) 후 토스트 숨기기
	setTimeout(function() {
		toast.style.display = 'none';
	}, 5000);
}



let alarmList = document.querySelector('.alarmList');
let alarmCount = document.querySelector('.alarmCount');



async function alarmListMember(){
	await axios.get('/ourmine/alarm/alarmList',{headers: headers})
		.then(resp => {
			let data = resp.data;
			console.log("알림 리스트", data)
			let html = '';
			let count = '';
			count += `<span>알림</span>`
			count += `<span>\${data[0]?.alarmCount || 0}</span>`
			data.forEach((item, index) => {

				$(".useMemberRoom").each(function() {
					$(this).find("#chatNewBedge").css("display", "block");

				});

				html += `  <a href="javascript:void(0);" class="d-flex" id="item\${index}">
                        <div class="flex-fill ms-2">
                            <p class="d-flex justify-content-between mb-0 ">
                                <span class="font-weight-bold">\${item.alarmSender}</span>
                                <small>\${item.alarmDate}</small>
                            </p>
                            <span class="">\${item.alarmContent}<span class="badge bg-success">\${item.review}<span></span>
                        </div>
                    </a>`
			});



			alarmList.innerHTML = html;
			alarmCount.innerHTML = count;


			data.forEach((item, index) => {
				// 각 아이템에 클릭 이벤트 리스너를 추가
				document.getElementById(`item\${index}`).addEventListener('click', () => modelView(item));
			});
			chatListArea.html('');
			chatGroupListArea.html('');
			selectChatList();
			selectGroupChatList();

		})
}
		alarmListMember();
		headers['accept'] = 'application/json';
		headers['Content-Type'] = 'application/json'



		// 웹소켓 서버에 연결
		let socket = new WebSocket('ws://192.168.36.2/ourmine/aws/echo');

		// 연결이 열리면 서버에 메시지를 보낼 수 있습니다.
		socket.onopen = function(event) {

		};

		// 서버로부터 메시지를 받으면 이 함수가 호출됩니다.
		let orange = document.querySelector('.orange');

		orange.addEventListener('click', function() {
			this.style.animation = '';
		});

		function modelView(item){
			console.log("modelView Item, ",item);
			alarmTitle.value = item.alarmContent;
			alarmDate.value = item.alarmDate;
			alarmWriter.value = item.alarmSender;
			let modalElement = document.getElementById('modifyModal');
			modalElement.style.display = 'block';
			axios.post('/ourmine/alarm/alarmUpdate',item,{headers:headers})
                .then(resp => {
					let data = resp.data;
	                console.log('업데이트성공여부', data);
	                alarmListMember();
                })
		}
ararmekerl.addEventListener('click', () => {
	let modalElement = document.getElementById('modifyModal');
	modalElement.style.display = 'none';
})




        let myUserId = '85'
		socket.onmessage = function(e) {
			let receivedData = JSON.parse(e.data);
			console.log("receivedData = ", receivedData)
			let message = JSON.parse(receivedData.message);
			if (message.userId === myUserId) {
				return;
			}

			let now = new Date();
			// 날짜 정보를 가져옴
			let date = now.getDate(); // 일
			let month = now.getMonth() + 1; // 월 (0부터 시작하므로 +1을 해줌)
			let year = now.getFullYear(); // 연도

			// 시간 정보를 가져옴
			let hours = now.getHours(); // 시
			let minutes = now.getMinutes(); // 분

			// 한자리 숫자 앞에 0을 붙임
			if (date < 10) {date = "0" + date}
			if (month < 10) {month = "0" + month}
			if (hours < 10) {hours = "0" + hours}
			if (minutes < 10) {minutes = "0" + minutes}

			// 원하는 형식으로 날짜와 시간을 결합함
			let dateString = year + "-" + month + "-" + date; // YYYY-MM-DD 형식
			let timeString = hours + ":" + minutes; // HH:MM 형식

			meAuto.innerHTML = message.sander;
			myToastBody.innerHTML = message.message;
			textMuted.innerHTML = dateString + " " + timeString; // 날짜와 시간을 표시
			showToast();
			alarmListMember();
			orange.style.animation = "pulse 1s infinite";
		};
		// 연결이 닫히거나 에러가 발생하면 이 함수가 호출됩니다.
		socket.onerror = function(error) {
			console.log('WebSocket Error: ', error);
		};

		socket.onclose = function(event) {
			console.log('WebSocket connection closed: ', event.code);
		};

 // =============================================================================
let memberPass =  document.querySelector('.memberPass');
let delForm = document.querySelector('.delForm');
let deleteCancel =  document.querySelector('.deleteCancel')
let passTag = document.querySelector('.passTag');



console.log(memberPass);
console.log(deleteCancel);

const member = {
	memberPassword : ''
}
const handleCancel = () => {
	memberPass.value =  '';
	passTag.innerHTML = '';
	deleteCancel.click();
}

const passChange = (e) => {
	const {name,value} = e.target;
	add1(name,value)
}

const add1 = (name,value) => {
	member[name] = value;
	console.log(member)
}


	headers['Content-Type'] = 'application/json'
    headers['accept'] = 'application/json'
        const deleteSubmit = (e) => {
            e.preventDefault();
            fetch('/ourmine/member/memberDelete',{
                method : 'POST',
                headers : headers,
                body: JSON.stringify(member)
            }).then(resp => resp.json())
                .then(data => {
                	console.log(passTag);
                    if(data === -1){
           			 passTag.innerHTML = '비밀번호가 맞지 않습니다.';
           			 passTag.style.display = 'block';
           			 passTag.style.color = 'red';
       		 }else{
       					deleteCancel.click();
						memberPass.value =  '';
						passTag.innerHTML = '';
					}
    })

}

 let myPage = document.querySelector('#myPage');
 let modiMpModalbody = document.querySelector('#modiMpModalbody');
 const myMember = {
		 memberEmail : '',
		 memberTel : '',
		 memberPassword : '',
		 memberPasswordResult : '',
 }

async function myPageLoad() {
	await fetch('/ourmine/member/memberViewJson', {
		method: 'GET',
		headers: {
			'accept': 'application/json',
		}
	}).then(resp => resp.json())
			.then(data => {
				console.log("회원정보", data);
				myMember.memberEmail = data.memberEmail;
				myMember.memberTel = data.memberTel;
				myMember.memberPassword = data.memberPassword;
				console.log(myMember);
				myPage.innerHTML +=
					`
					 <div class="card-body d-flex teacher-fulldeatil">
                             <div class="profile-teacher pe-xl-4 pe-md-2 pe-sm-4 pe-4 text-center w220">
                                 <a href="#">
                          <!-- 회원이미지 쓸곳 -->   <img src="\${data.imageContents !== null ? data.imageContents : '/ourmine/resources/mytask/documentation/assets/images/profile_av.png'}" alt="" class="avatar xl rounded-circle img-thumbnail shadow-sm">
                                 </a>
                                 <div class="about-info d-flex align-items-center mt-3 justify-content-center flex-column">
                                     <h6 class="mb-0 fw-bold d-block " style="font-size: 20px;">\${data.memberName}</h6>
                                     <span class="text-muted " style="font-size: 18px;">\${data.memberGrade}</span>
                                 </div>
                             </div>
                             <div class="teacher-info border-start ps-xl-4 ps-md-4 ps-sm-4 ps-4 w-100">

                                 <h6  class="mb-0 mt-2  fw-bold d-block " style="font-size: 20px;">\${data.companyName === null ? '등록된 회사가 없습니다.' : '회사명 : ' + data.companyName}</h6>

                                 <span class="py-1 fw-bold mb-0 mt-1 text-muted" style="font-size: 14px;"><span>CEO : </span>\${data.companyCeo === null ? '등록된 회사가 없습니다.' : data.companyCeo}</span>
                                 <hr>
                                 <div class="row g-2 pt-2">
                                     <div >
                                         <div class="d-flex align-items-center" >
                                             <i class="icofont-ui-touch-phone" style="font-size: 18px;"></i>
                                             <span class="ms-2 " style="font-size: 18px;">\${data.memberTel}</span>
                                         </div>
                                     </div>
                                     <hr>
                                     <div>
                                         <div class="d-flex align-items-center">
                                             <i class="icofont-email" style="font-size: 18px;"></i>
                                             <span class="ms-2 " style="font-size: 18px;">\${data.memberEmail}</span>
                                         </div>
                                     </div>
									<hr>

                                 </div>
                             </div>
                         </div>


					`

			})

}
 async function modiMyPageLoad() {
		await fetch('/ourmine/member/memberViewJson', {
			method: 'GET',
			headers: {
				'accept': 'application/json',
			}

		}).then(resp => resp.json())
				.then(data => {
					console.log("회원정보", data);
					myMember.memberEmail = data.memberEmail;
					myMember.memberTel = data.memberTel;
					myMember.memberPassword = data.memberPassword;
					console.log(myMember);
					modiMpModalbody.innerHTML +=
					`

                        <div class="mb-3"  style="font-size:14px;">
					 		<i class="icofont-user"></i> <label for="exampleFormControlInput78" class="form-label">이름</label>
                            <input name="memberName" type="text" class="form-control nameInput" id="exampleFormControlInput78" value="\${data.memberName}" readonly>
                        </div>


                            <div class="mb-3" style="font-size:14px;">
                                <i class="icofont-email" ></i> <label for="exampleFormControlInput78" class="form-label">이메일</label>
                                <input name="memberEmail" type="text" class="form-control mailInput" id="exampleFormControlInput78" value="\${data.memberEmail}" >
                                <span id="mail"></span>
                            </div>


                            <div class="mb-3" style="font-size:14px;">
                                <i class="icofont-mobile-phone" ></i> <label for="exampleFormControlInput78" class="form-label">전화번호</label>
                                <input  name="memberTel" type="text" class="form-control telInput" id="exampleFormControlInput78" value="\${data.memberTel}" >
                                <input  name="memberId" type="hidden" class="form-control IdInput" id="exampleFormControlInput78" value="\${data.memberId}" >
                                <span id="tel"></span>
                            </div>

                			 <div class="mb-3" style="font-size:14px;">
                			    <i class="icofont-image" ></i> <label for="exampleFormControlInput78" class="form-label">내 이미지</label>
                                <input  name="file" type="file" class="form-control telInput" id="exampleFormControlInput78" value="\${data.memberTel}" >
                            </div>

                            <div class="mb-3"  style="font-size:14px;">
                                <i class="icofont-check" ></i> <label for="exampleFormControlInput78" class="form-label">비밀번호 확인</label>
                                <input  name="memberPassword" type="password" class="form-control passInput" id="exampleFormControlInput78" value="" >
                                <span id="pass"></span>
                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary clo" data-bs-dismiss="modal">취소</button>
                                <button type="submit" class="btn btn-primary">완료</button>
                            </div>

					`;


				})

 }


 async function MyPageJs() {
	 let regex = new RegExp("([!#-'*+/-9=?A-Z^-~-]+(\.[!#-'*+/-9=?A-Z^-~-]+)*|\"\(\[\]!#-[^-~ \t]|(\\[\t -~]))+\")@([!#-'*+/-9=?A-Z^-~-]+(\.[!#-'*+/-9=?A-Z^-~-]+)*|\[[\t -Z^-~]*])"); // 이메일 정규식
	 let reg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/; // 비밀번호 정규식
	 let regPone = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/; // 전화번호 정규식
	 let mailInput = document.querySelector('.mailInput');
	 let telInput = document.querySelector('.telInput');
	 let passInput = document.querySelector('.passInput');
	 let IdInput = document.querySelector('.IdInput');
	 let nameInput = document.querySelector('.nameInput');
	 let clo = document.querySelector('.clo');
	 let pass = document.querySelector('#pass');
	 let mail = document.querySelector('#mail');
	 let tel = document.querySelector('#tel');
	 let sub = document.querySelector('#sub');
	 let formData = new FormData();
	 let fileField = document.querySelector("input[type='file']");

	 let myMember = {
		 memberId: '',
		 memberEmail: '',
		 memberName: '',
		 memberTel: '',
		 memberPassword: '',
	 }

	 const mailValue = mailInput.value;
	 const telValue = telInput.value;
	 let isEmail = true;
	 let isTel = true;
	 let isPassword = true;

	 clo.addEventListener('click', () => {
		 pass.innerHTML = '';
		 passInput.value = '';
		 tel.innerHTML = '';
		 mail.innerHTML = '';
		 mailInput.value = mailValue;
		 console.log("mailInputvalue", mailInput.value);
		 telInput.value = telValue;
	 })


	 mailInput.addEventListener('change', (e) => {
		 const {name, value} = e.target;
		 console.log(name, value);
		 add1(name, value);
	 })
	 telInput.addEventListener('change', (e) => {
		 const {name, value} = e.target;
		 console.log(name, value);
		 add1(name, value);
	 })
	 passInput.addEventListener('change', (e) => {
		 const {name, value} = e.target;
		 console.log(name, value);
		 add1(name, value);
	 })

	 const add1 = (name, value) => {
		 myMember[name] = value;
		 myMember["memberId"] = IdInput.value;
		 myMember["memberName"] = nameInput.value;
		 console.log(myMember.memberId)
	 }




	 sub.addEventListener('submit', (e) => {
		 console.log("e => ", e);
		 e.preventDefault();
		 console.log('여기까지오니')
		 e.preventDefault();

		 if (mailInput.value === '') {
			 mail.innerHTML = '';
			 mail.innerHTML = '이메일을 입력해주세요';
			 mail.style.color = 'red';
			 isEmail = false;
		 } else {
			 isEmail = true;
			 mail.innerHTML = '';
		 }
		 if (telInput.value === '') {
			 tel.innerHTML = '';
			 tel.innerHTML = '전화번호를 입력해주세요';
			 tel.style.color = 'red';
			 isTel = false;
		 } else {
			 isTel = true;
			 tel.innerHTML = '';
		 }
		 if (passInput.value === '') {
			 pass.innerHTML = '';
			 pass.innerHTML = '비밀번호를 입력해주세요';
			 pass.style.color = 'red'
			 isPassword = false;
		 } else {
			 isPassword = true;
			 pass.innerHTML = '';
		 }


		 if (isTel && isEmail && isPassword) {

			 if (fileField.files[0] != undefined) {
				 formData.set("file", fileField.files[0]);
			 }
			 formData.set("memberId", IdInput.value);
			 formData.set("memberEmail", mailInput.value);
			 formData.set("memberName", nameInput.value);
			 formData.set("memberTel", telInput.value);
			 formData.set("memberPassword", passInput.value);
			 console.log(formData);
			 headers['accept'] = 'application/json';
			 headers['Content-Type'] = 'multipart/form-data';
			 let page = $('#myPage');

			 e.preventDefault();
			 Swal.fire({
					icon: 'success',
					title:'수정완료',
					showConfirmButton: false,
					timer: 1000
				});

		 	return axios.post('/ourmine/member/memberUpdate', formData, {headers: headers})
					 .then( (resp) => {
						 let data = resp.data;
						 if (data === -1) {
							 pass.innerHTML = '비밀번호가 일치하지 않습니다.';
							 pass.style.color = 'red';
							 return false;
						 } else {
							 pass.innerHTML = '';
							 passInput.value = '';
						 }

						 if (data > 0) {
							 console.log('성공:', data);
							 clo.click();
							 page.empty();
							 memberImageList();
							  myPageLoad();
							 passInput.value = '';
						 } else {
							 pass.innerHTML = '';
							 passInput.value = '';
						 }
						 document.getElementById('modiMpModalbody').innerHTML="";
		 				 modiMyPageLoad().then(MyPageJs);
					 })
					 .catch((error) => {
						 console.error("memberUpdate : ", error);
					 });
		 }
	 })
 }
myPageLoad()
modiMyPageLoad().then(MyPageJs)

setTimeout(() => {
	alarmListMember();
}, 1000);




    </script>



