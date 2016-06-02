<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<%
	int i = 1;
%>
<html>

<head>
<!-- CSS -->
<style type="text/css">
.jbFixed {
	position: fixed;
	top: 70px;
}
</style>
<!-- jQuery-->
<script src="/resources/js/jquery.js" type="text/javascript"></script>
<script src="/resources/js/createTable.js" type="text/javascript"></script>
</head>
<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<jsp:include page="../../common/teacherMenu.jsp" />
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">내신 성적 입력</div>
									</div>
								</div>
								<div class="card-body table-responsive col-xs-9">
									<!-- Table -->
									<form action="subjectScore" method="post">
										<table class="table table-striped">
											<thead>
												<tr class="headings">
													<th rowspan="2">학년</th>
													<th rowspan="2">교과</th>
													<th rowspan="2">과목</th>
													<th colspan="4">
														<select id="selectTerm">
															<option value="default" selected>학기선택</option>
															<option value="1">1학기</option>
															<option value="2">2학기</option>
														</select>
													</th>
												</tr>
												<tr>
													<th>단위수</th>
													<th>중간고사</th>
													<th>기말고사</th>
													<th>수행평가</th>
													<th>삭제</th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									<!--페이지 -->
									<div class="col-md-11">
										<div class="col-sm-4">
											<input id="addSubject" type="button" class="btn btn-default" value="과목추가">
										</div>
										<div class="col-sm-7"></div>
									</div>
									<div class="col-md-1">
										<input type="text" name="semester">
										<input type="hidden" name="memberId">
										<input type="submit" class="btn btn-default" value="완료">
									</div>
									</form>
								</div>
								

								<div class="card-body table-responsive col-xs-3">
									<div id="jbMenu"
										style="width: 320px; height: 400px; overflow: auto;">
										<h4>학생 명단</h4>
										<table class="table table-hover"
											style="border: 1px solid #bcbcbc">
											<thead>
												<tr class="headings">
													<th>번호</th>
													<th>학생ID</th>
													<th>이름</th>
													<th>생년월일</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="student" items="${list2 }">
													<tr id="clickTr">
														<td><%=i++%></td>
														<td id="clickStu" style="cursor: pointer">${student.memberId }</td>
														<td>${student.memberName }</td>
														<td><fmt:formatDate
																value="${student.memberBirthday }" pattern="yyyy-MM-dd" /></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
​
