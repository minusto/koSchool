<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%
	request.setCharacterEncoding("UTF-8");
	String login = request.getParameter("login");
	request.setAttribute("login", login);
	String logout = request.getParameter("logout");
	request.setAttribute("logout", logout);
	if (session != null) {
		if (session.getAttribute("grade") != null) {
			String grade = (String) session.getAttribute("grade");
			if (grade.equals("학교관리자")) {
				response.sendRedirect("schoolAdminMain.jsp");
			} else if (grade.equals("교사")) {
				response.sendRedirect("teacherMain.jsp");
			} else if (grade.equals("학생")) {
				response.sendRedirect("studentMain.jsp");
			} else if (grade.equals("학부모")) {
				response.sendRedirect("parentMain.jsp");
			}
		}
	}
%>
 --%>
 <!DOCTYPE html>
<html>

<head>

<title>메인페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900'
	rel='stylesheet' type='text/css'>
<!-- CSS Libs -->
<link rel="stylesheet" type="text/css" href="/resources/lib/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/resources/lib/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/animate.min.css">
<link rel="stylesheet" type="text/css"
	href="/resources/lib/css/bootstrap-switch.min.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/checkbox3.min.css">
<link rel="stylesheet" type="text/css"
	href="/resources/lib/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="/resources/lib/css/dataTables.bootstrap.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/select2.min.css">
<!-- CSS App -->
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/css/themes/flat-blue.css">
<link rel="stylesheet" type="text/css" href="/resources/css/ghi.css">

</head>

<body class="flat-blue">
<input type="hidden" id="result" value="${result }">
	<%-- <input type="hidden" id="loginCheck" value="${login}"> --%>
	<input type="hidden" id="logout" value="${logout}">
	<div class="app-container">
		<br><br>
		<div id="mainPictureDiv" class="mainPicture">
			<a> <img class="img-responsive hidden-xs" alt="MainPicture"
				src="/resources/img/MainPicture.png">
			</a>
		</div>
		<br>
		<div id="loginSelectStudentDiv" class="loginSelectDiv">
			<ul class="list-unstyled list-inline">
				<li id="liStudent" data-toggle="modal" data-target="#modalSuccess">
					<a href="#" class="loginSelectA"> <img id="loginSelectStudent"
						alt="학생로그인" src="/resources/img/LoginSelectStudent.png">
				</a>
				</li>
				<li id="liTeacher" data-toggle="modal" data-target="#modalInfo">
					<a href="#" class="loginSelectA"> <img id="loginSelectTeacher"
						alt="교사로그인" src="/resources/img/LoginSelectTeacher.png">
				</a>
				</li>
				<li id="liParent" data-toggle="modal" data-target="#modalWarning">
					<a href="#" class="loginSelectA"> <img id="loginSelectParent"
						alt="학부모로그인" src="/resources/img/LoginSelectParent.png">
				</a>
				</li>
				<li id="liManager" data-toggle="modal" data-target="#modalDanger">
					<a href="#" class="loginSelectA"> <img id="loginSelectManager"
						alt="관리자로그인" src="/resources/img/LoginSelectManager.png">
				</a>
				</li>
			</ul>
		</div>
		<div id="mainFooter" class="row">
			<div class="footerImg col-md-3">

			</div>
			<div class="footerNav col-md-5 col-xs-8" align="center">
				<ul style="padding: 0px">
					<li><a href="#">시스템소개</a></li>
					<li><a href="#">저작권</a></li>
					<li><a href="#">교육청</a></li>
					<li><a href="#">시·도교육청 상담센터 안내</a></li>
					<li><a href="#">Contact Us</a></li>
				</ul>
				<address>Copyright (c) YG Family. All Rights Reserved</address>
			</div>
			<div class="wrapper" id="syslogin" >
				<span class="pull-right"><a id="sysLoginA"
					data-toggle="modal" data-target="#modalPrimary"
					style="color: #e5e5e9">시스템 로그인</a></span> 
			</div>
		</div>
	</div>
	<!-- LOGIN FORM MODAL START -->

	<!-- 학생 로그인 Modal -->
	<div class="modal fade modal-success" id="modalSuccess" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="margin-top: 120px;">
			<div class="modal-content">
				<div class="modal-header" style="background-color: #43a4d8">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">학생 로그인</h4>
				</div>
				<div class="modal-body row">
					<div class="col-md-8 col-md-offset-2">
						<form action="/" method="post"><!-- logic/memberCheck.jsp -->
						<input type="hidden" name="grade" value="student">
							<div class="control">
								<input type="text" class="form-control" placeholder="아이디를 입력하세요"
									size="25" style="margin-top: 10px" name="id" />
							</div>
							<div class="control">
								<input type="password" class="form-control"
									placeholder="비밀번호를 입력하세요" style="margin-top: 10px" name="password" />
							</div>
							<div class="lostPass">
								<br> <a>비밀번호 찾기</a>
							</div>
							<div class="login-button text-center">
								<input type="submit" class="btn btn-primary" value="Login">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--교사 로그인 Modal -->
	<div class="modal fade modal-info" id="modalInfo" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="margin-top: 120px;">
			<div class="modal-content">
				<div class="modal-header" style="background-color: #eb7a38">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">교사 로그인</h4>
				</div>
				<div class="modal-body row">
					<div class="col-md-8 col-md-offset-2">
						<form action="/" method="post">
						<input type="hidden" name="grade" value="teacher">
							<div class="control">
								<input type="text" class="form-control" placeholder="아이디를 입력하세요"
									size="25" style="margin-top: 10px" name="id" />
							</div>
							<div class="control">
								<input type="password" class="form-control"
									placeholder="비밀번호를 입력하세요" style="margin-top: 10px" name="password" />
							</div>
							<div class="lostPass">
								<br> <a>비밀번호 찾기</a>
							</div>
							<div class="login-button text-center">
								<input type="submit" class="btn btn-primary" value="Login">
							</div> 
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 학부모 로그인 Modal -->
	<div class="modal fade modal-warning" id="modalWarning" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="margin-top: 120px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">학부모 로그인</h4>
				</div>
				<div class="modal-body row">
					<div class="col-md-8 col-md-offset-2">
						<form action="/" method="post">
							<input type="hidden" name="grade" value="parent">
							<div class="control">
								<input type="text" class="form-control" placeholder="아이디를 입력하세요"
									size="25" style="margin-top: 10px" name="id" />
							</div>
							<div class="control">
								<input type="password" class="form-control"
									placeholder="비밀번호를 입력하세요" style="margin-top: 10px" name="password" />
							</div>
							<div class="lostPass">
								<br> <a>비밀번호 찾기</a>
							</div>
							<div class="login-button text-center">
								<input type="submit" class="btn btn-primary" value="Login">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 관리자 로그인 Modal -->
	<div class="modal fade modal-danger" id="modalDanger" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="margin-top: 120px;">
			<div class="modal-content">
				<div class="modal-header" style="background-color: #1dafa2">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">관리자 로그인</h4>
				</div>
				<div class="modal-body row">
					<div class="col-md-8 col-md-offset-2">
						<form action="/" method="post">
						<input type="hidden" name="grade" value="schoolAdmin">
							<div class="control">
								<input type="text" class="form-control" placeholder="아이디를 입력하세요"
									size="25" style="margin-top: 10px" name="id" />
							</div>
							<div class="control">
								<input type="password" class="form-control"
									placeholder="비밀번호를 입력하세요" style="margin-top: 10px" name="password" />
							</div>
							<div class="lostPass">
								<br> <a>비밀번호 찾기</a>
							</div>
							<div class="login-button text-center">
								<input type="submit" class="btn btn-primary" value="Login">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



	<!-- 시스템관리자 로그인 Modal -->
	<div class="modal fade modal-primary" id="modalPrimary" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="margin-top: 120px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">시스템관리자 로그인</h4>
				</div>
				<div class="modal-body row">
					<div class="col-md-8 col-md-offset-2">
						<form action="/" method="post">
						<input type="hidden" name="grade" value="systemAdmin">
							<div class="control">
								<input type="text" class="form-control" placeholder="아이디를 입력하세요"
									size="25" style="margin-top: 10px" name="id" />
							</div>
							<div class="control">
								<input type="password" class="form-control"
									placeholder="비밀번호를 입력하세요" style="margin-top: 10px" name="password" />
							</div>

							<div class="login-button text-center">
								<input type="submit" class="btn btn-primary" value="Login">
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>


	<!-- MODAL END -->

	<script type="text/javascript" src="/resources/lib/js/jquery.min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/bootstrap-switch.min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/jquery.matchHeight-min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/dataTables.bootstrap.min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/select2.full.min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/ace/ace.js"></script>
	<script type="text/javascript" src="/resources/lib/js/ace/mode-html.js"></script>
	<script type="text/javascript" src="/resources/lib/js/ace/theme-github.js"></script>
	<!-- Javascript -->
	<script type="text/javascript" src="/resources/js/app.js"></script>
	<script type="text/javascript" src="/resources/js/index.js"></script>
	 <script type="text/javascript">
		$(window.onload = function() {
			var loginCheck = $("#result").attr('value');
			if (loginCheck == "fail") {
				alert("아이디 및 비밀번호를 확인하세요");
			}
			var logout = $("#logout").attr('value');
			if (logout == "success") {
				alert("로그아웃 완료");
			}
		})
	</script> 
</body>

</html>
​
