<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/resources/full/fullcalendar.css">
<link rel="stylesheet" media='print' href="/resources/full/fullcalendar.print.css">
	

	

<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
}

#abcabc {
	width: 100px;
	height: 100px;
	background-color: yellow;
}

#dddd {
	width: 100px;
	height: 100px;
	background-color: red;
}
</style>


<title>빈칸</title>

</head>

<body class="flat-blue">
	<ul class="list-unstyled list-inline" style="display: none;">
		<li id="liStudent" data-toggle="modal" data-target="#modalSuccess">
			<a href="#" class="loginSelectA"> <img id="loginSelectStudent"
				alt="학생로그인" src="/resources/img/LoginSelectStudent.png"
				style="size: 100px">
		</a>
		</li>
	</ul>

	<div class="modal fade modal-success" id="modalSuccess" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="margin-top: 120px;">
			<div class="modal-content">
				<div class="modal-header" style="background-color: #43a4d8">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" id="closeDetail">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">상세일정</h4>
				</div>
				<div class="modal-body row">
					<div class="col-md-8 col-md-offset-2">

						<form action="/detailScheduleUpdate" method="post">
							<!-- logic/memberCheck.jsp -->

							<input type="hidden" name="scheduleId" id="scheduleId">
							<div class="col-md-12">
								<label for="form_pword">일정명</label> <input type="text"
									id="scheduleTitle" name="scheduleTitle" class="form-control"
									required="required" disabled="disabled">
							</div>
							<br>
							<div class="col-md-12">
								<label for="form_pword">시작일</label> <input type="date"
									id="scheduleStartDate" name="scheduleStartDate" class="form-control"
									required="required" disabled="disabled">
							</div>
							<div class="col-md-12">
								<label for="form_pword">종료일</label> <input type="date"
									id="scheduleEndDate" name="scheduleEndDate" class="form-control"
									required="required" disabled="disabled">
							</div>

							<div class="col-md-12">
								<label for="form_contents">내용</label>
								<textarea name="scheduleDetail" class="form-control" id="scheduleDetail"
									placeholder="내용을 입력해주세요" rows="10" required="required"
									disabled="disabled">
									</textarea>
							</div>


							<div class="login-button text-center">
								<input type="button" class="btn btn-primary" value="수정"
									id="scheduleMod"> <input type="button"
									class="btn btn-primary" value="삭제" id="scheduleDel"> <input
									type="button" class="btn btn-primary" value="취소"
									id="scheduleModCencle" style="display: none;">
									 <input	type="submit" class="btn btn-primary" value="확인"
									id="scheduleSubmit" style="display: none;">
									 <input	type="button" class="btn btn-primary" value="닫기"
									id="detailClose">

							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>




	<div class="app-container">
		<div class="row content-container">

 			<c:if test="${grade eq 'schoolAdmin' }">
				<jsp:include page="../common/schoolAdminMenu.jsp" />
			</c:if>
			<c:if test="${grade eq 'student' }">
				<jsp:include page="../common/studentMenu.jsp" />
			</c:if>
			
			<c:if test="${grade eq 'teacher' }">
				<jsp:include page="../common/teacherMenu.jsp" />
			</c:if>
			<c:if test="${grade eq 'parent' }">
				<jsp:include page="../common/studentMenu.jsp" />
			</c:if>
			


			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body">
					<div id='calendar'></div>
				</div>
			</div>

		</div>
	</div>

	<c:choose>
		<c:when test="${grade eq 'schoolAdmin' }">
			<script src='/resources/js/schoolAdminSchedule.js'></script>
		</c:when>
		<c:otherwise>
 			<script src='/resources/js/userSchedule.js'></script> 
		</c:otherwise>
	</c:choose>

          
	<script src='/resources/full/moment.min.js'></script>
	<!-- <script src="/resources/lib/js/jquery.min.js"></script> -->
	<script src="/resources/full/fullcalendar.min.js"></script>
	
</body>

</html>
​
