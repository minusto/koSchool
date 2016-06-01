
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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

<!-- 제주고딕체 -->
<link rel="stylesheet" href="//fonts.googleapis.com/earlyaccess/jejugothic.css" />
<!-- 폰트추가 -->
<style type="text/css">
body {
	font-family: 'Jeju Gothic', sans-serif;
}
</style>

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

<script type="text/javascript">

		$(function() {
		notReadMessage();
		
		setInterval(function() {
			notReadMessage()
		}, 3000);
		
		//미확인메세지 가져오는 ajax 함수 / 작성자 : 박종현
		function notReadMessage() {
				$.ajax({
					url : "notReadMessage",
					dataType : 'json',
					success : function(data) {
						$("#messageCount").html("&nbsp;" +data.countNotReadMessage);
						$("#notReadMessage").html(data.countNotReadMessage);
						if(data.countNotReadMessage == 0){
							$("#newMessage").html("새로운 메세지가 없습니다.");
						}else{                              
							$("#newMessage").html("미확인 메세지가 존재합니다.");
						}
					}
				});
			}
			
		})
	</script>
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
					class="fa fa-comments-o"  id="messageCount"></i>&nbsp;</a>
				<ul class="dropdown-menu animated fadeInDown">
					<li class="title">새 쪽지 <span class="badge pull-right" id="notReadMessage"></span>
					</li>
					<li class="message"><button id="newMessage" data-target="#messageModal" data-toggle="modal" class="btn-success">새 메세지가 없습니다.</button>
					</li>
				</ul></li>

			<li class="dropdown profile"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-expanded="false">${member.memberName }<span
					class="caret"></span></a>
				<ul class="dropdown-menu animated fadeInDown">
					<c:if test="${teacher.teacherPicture!=null }">
						<c:set var="head" value="${fn:substring(teacher.teacherPicture,0,fn:length(teacher.teacherPicture)-4) }"></c:set>
						<c:set var="pattern" value="${fn:substringAfter(teacher.teacherPicture,head) }"></c:set>
						<li class="profile-img"><img src="upload/${ head}_resize${pattern}"class="profile-img"></li>
					</c:if>
<%-- 							<li class="profile-img"><img src="upload/${teacher.teacherPicture}"class="profile-img"></li> --%>
					<li>
						<div class="profile-info">
							<h4 class="username">${member.memberName }</h4>
							<p>${member.memberEmail }</p>
							<div class="btn-group margin-bottom-2x" role="group">
								<button type="button" class="btn btn-default">
									<i class="fa fa-user"></i> Profile
								</button>
								<button type="button" class="btn btn-default"
									onclick="location.href='logout'">
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
				<a class="navbar-brand" href="teacherMain">
					<div class="icon fa fa-book"></div>
					<div class="title">학사관리</div>
				</a>
				<button type="button"
					class="navbar-expand-toggle pull-right visible-xs">
					<i class="fa fa-times icon"></i>
				</button>
			</div>
			<ul class="nav navbar-nav">
				<!-- 
                            <li class="active">
                                <a href="blank.jsp">
                                    <span class="icon fa fa-tachometer"></span><span class="title">Dashboard</span>
                                </a>
                            </li> 
                            -->
				<li class="panel panel-default dropdown"><a
					data-toggle="collapse" href="#dropdown-element"> <span
						class="icon fa fa-desktop"></span><span class="title">학생 관리</span>
				</a> <!-- Dropdown level 1 -->
					<div id="dropdown-element" class="panel-collapse collapse">
						<div class="panel-body">
							<ul class="nav navbar-nav">
								<li><a href="teacherInsertStudentForm">학생 정보 입력</a></li>
								<li><a href="teacherListStudent">학생 정보 열람</a></li>
								<li><a href="teacherInsertScoreForm.jsp">내신 성적 입력</a></li>
								<li><a href="teacherInsertMockScoreForm.jsp">모의고사 성적 입력</a>
								</li>
							</ul>
						</div>
					</div></li>
				<li class="panel panel-default dropdown"><a
					data-toggle="collapse" href="#dropdown-table"> <span
						class="icon fa fa-table"></span><span class="title">학부모 관리</span>
				</a> <!-- Dropdown level 1 -->
					<div id="dropdown-table" class="panel-collapse collapse">
						<div class="panel-body">
							<ul class="nav navbar-nav">
								<li><a href="teacherInsertParentForm">학부모 정보 입력</a></li>
								<li><a href="teacherListParent">학부모 정보 열람</a></li>
							</ul>
						</div>
					</div></li>
				<li class="panel panel-default dropdown"><a
					data-toggle="collapse" href="#dropdown-form"> <span
						class="icon fa fa-file-text-o"></span><span class="title">가정통신문</span>
				</a> <!-- Dropdown level 1 -->
					<div id="dropdown-form" class="panel-collapse collapse">
						<div class="panel-body">
							<ul class="nav navbar-nav">
								<li><a href="teacherInsertNoticeParentForm.jsp">가정통신문
										발송</a></li>
								<li><a href="teacherListNoticeParent.jsp">가정통신문 조회</a></li>
							</ul>
						</div>
					</div></li>
				<!-- Dropdown-->
				<li class="panel panel-default dropdown"><a
					data-toggle="collapse" href="#component-example"> <span
						class="icon fa fa-commenting-o"></span><span class="title">소통공간</span>
				</a> <!-- Dropdown level 1 -->
					<div id="component-example" class="panel-collapse collapse">
						<div class="panel-body">
							<ul class="nav navbar-nav">
								<li><a href="teacherNoticeBoardList.jsp">교내 공지사항</a></li>
								<li><a href="teacherClassBoardList.jsp">학급 게시판</a></li>
								<li><a href="scheduleList.jsp">일정</a></li>
							</ul>
						</div>
					</div></li>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</nav>
</div>
​
