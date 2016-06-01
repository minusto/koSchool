
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>

<head>
<title>빈칸</title>
<meta name="viewport" content="width=device-width, initial-scale=1">


<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">교사 목록</div>
									</div>
								</div>
								<div class="col-lg-1"></div>
								<div class="card-body table-responsive col-lg-10">
									<!-- Table -->
									<table class="table table-striped">
										<thead>
											<tr class="headings" height="30">
												<th>이름</th>
												<th>생년월일</th>
												<th>전화번호</th>
												<th>이메일</th>
												<th>담당학급</th>
												<th>담당과목</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="teacher" items="${list}">
												<tr>
													<td><a
														href="teacherListDetail.jsp?memberId=${teacher.memberId}">${teacher.memberName}</a></td>
													<td>${(teacher.memberBirthday).substring(0, 10)}</td>
													<td>${teacher.memberTel}</td>
													<td>${teacher.memberEmail}</td>
													<td>${teacher.teacherClass}</td>
													<td>${teacher.subjectId}</td>
												</tr>
											</c:forEach>
										</tbody>


									</table>
									<!--페이지 -->


									<a href="/schoolmanage/schoolAdminInsertTeacherForm" class="pull-right"><button
											class="btn btn-default">등록</button></a><br>
									<br> <br>
									<br>
						
									
									<br>
									<br>
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
