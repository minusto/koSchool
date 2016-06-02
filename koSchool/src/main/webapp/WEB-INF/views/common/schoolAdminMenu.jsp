<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
<!-- Fonts -->
<link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>
<!-- CSS Libs -->
<link rel="stylesheet" type="text/css" href="/resources/lib/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/animate.min.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/bootstrap-switch.min.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/checkbox3.min.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/dataTables.bootstrap.css">
<link rel="stylesheet" type="text/css" href="/resources/lib/css/select2.min.css">
<!-- CSS App --> 
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="/resources/css/themes/flat-blue.css">

	<!-- Javascript Libs -->
	<script type="text/javascript" src="/resources/lib/js/jquery.min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/resources/lib/js/Chart.min.js"></script>
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

</head>

			<nav class="navbar navbar-default navbar-fixed-top navbar-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-expand-toggle">
							<i class="fa fa-bars icon"></i>
						</button>
						<ol class="breadcrumb navbar-breadcrumb">
							<li class="active">${path }</li>
						</ol>
						<button type="button"
							class="navbar-right-expand-toggle pull-right visible-xs">
							<i class="fa fa-th icon"></i>
						</button>
					</div>
					<ul class="nav navbar-nav navbar-right">
						<button type="button"
							class="navbar-right-expand-toggle pull-right visible-xs">
							<i class="fa fa-times icon"></i>
						</button>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-expanded="false"><i
					class="fa fa-comments-o"></i></a>
				<ul class="dropdown-menu animated fadeInDown">
					<li class="title">채팅 <span class="badge pull-right"></span>
					</li>
					<li class="message"><a href="http://localhost:50000">채팅하기</a>
					</li>
				</ul></li>

						<li class="dropdown profile"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-expanded="false">${schoolAdmin.schoolAdminName }<span class="caret"></span></a>
							<ul class="dropdown-menu animated fadeInDown">
								<li class="profile-img"><img
									src="/resources/img/profile/picjumbo.com_HNCK4153_resize.jpg"
									class="profile-img"></li>
								<li>
									<div class="profile-info">
                                        <h4 class="username">${schoolAdmin.schoolAdminName }</h4>
                                        <p>${schoolAdmin.schoolAdminTel }</p>
										<div class="btn-group margin-bottom-2x" role="group">
											<button type="button" class="btn btn-default">
												<i class="fa fa-user"></i> Profile
											</button>
											<button type="button" class="btn btn-default" onclick="location.href='logout'">
												<i class="fa fa-sign-out"></i> Logout
											</button>
										</div>
									</div>
								</li>
							</ul></li>
					</ul>
				</div>
			</nav>
			<div class="side-menu sidebar-inverse">
				<nav class="navbar navbar-default" role="navigation">
					<div class="side-menu-container">
						<div class="navbar-header">
							<a class="navbar-brand" href="#">
								<div class="icon fa fa-book"></div>
								<div class="title" onclick="location.href='schoolAdminMain.jsp'">학사관리</div>
							</a>
							<button type="button"
								class="navbar-expand-toggle pull-right visible-xs">
								<i class="fa fa-times icon"></i>
							</button>
						</div>
						<ul class="nav navbar-nav">  
							<li class="panel panel-default dropdown"><a
								data-toggle="collapse" href="#dropdown-element"> <span
									class="icon fa fa-university"></span><span class="title">학교관리</span>
							</a> <!-- Dropdown level 1 -->
								<div id="dropdown-element" class="panel-collapse collapse">
									<div class="panel-body">
										<ul class="nav navbar-nav">
											<li><a href="/insertSchoolForm">학교등록</a></li>
											<li><a href="/schoolDetail">학교 정보 조회</a></li>
											<li><a href="/schoolmanage/schoolAdminInsertUserIdForm">사용자 ID 등록</a></li>
											<li><a href="/schoolmanage/userIdList">사용자 ID 목록</a></li>
										</ul>
									</div>
								</div></li> 
								
							<li class="panel panel-default dropdown"><a
								data-toggle="collapse" href="#dropdown-table"> <span
									class="icon fa fa-table"></span><span class="title">교사관리</span>
							</a> <!-- Dropdown level 1 -->
								<div id="dropdown-table" class="panel-collapse collapse">
									<div class="panel-body">
										<ul class="nav navbar-nav">
											<li><a href="/schoolmanage/schoolAdminInsertTeacherForm">교사 등록</a></li>
											<li><a href="/schoolmanage/schoolAdminTeacherList">교사 목록</a></li>
										</ul>
									</div>
								</div></li>
								
							<li class="panel panel-default dropdown"><a
								data-toggle="collapse" href="#dropdown-form"> <span
									class="icon fa fa-file-text-o"></span><span class="title">게시판관리</span>
							</a> <!-- Dropdown level 1 -->
								<div id="dropdown-form" class="panel-collapse collapse">
									<div class="panel-body">
										<ul class="nav navbar-nav">
											<li><a href="/noticeBoardList">공지사항</a></li>
											<li><a href="scheduleList.jsp">학사일정</a></li>
											<li><a href=schoolAdminClassBoardList.jsp>학급게시판</a></li>
										</ul>
									</div>
								</div></li>
						</ul>
					</div>
				</nav>
			</div>
