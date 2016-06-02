<%@page import="ko.school.membermanage.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%-- <%
	request.setAttribute("path", "학교관리>사용자 ID 목록");
	request.setCharacterEncoding("utf-8");

	List<RegistManage> list = service.userListService(id);
	request.setAttribute("list", list);
%> --%>


<html>

<head>
<title>빈칸</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900'
	rel='stylesheet' type='text/css'>
<!-- CSS Libs -->
<link rel="stylesheet" type="text/css" href="lib/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="lib/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="lib/css/animate.min.css">
<link rel="stylesheet" type="text/css"
	href="lib/css/bootstrap-switch.min.css">
<link rel="stylesheet" type="text/css" href="lib/css/checkbox3.min.css">
<link rel="stylesheet" type="text/css"
	href="lib/css/jquery.dataTables.min.css">
<link rel="stylesheet" type="text/css"
	href="lib/css/dataTables.bootstrap.css">
<link rel="stylesheet" type="text/css" href="lib/css/select2.min.css">
<!-- CSS App -->
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/themes/flat-blue.css">
</head>

<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<jsp:include page="../common/schoolAdminMenu.jsp" />
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">사용자 ID 목록</div>
									</div>
								</div>
								<div class="col-md-2"></div>
								<div class="card-body table-responsive col-md-8">
									<!-- Table -->
									<table class="table table-striped">
										<thead>
											<tr class="headings">
												<th>사용자 ID</th>
												<th>등급</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="list" items="${list}">
												<tr>
													<td><a href="#">${list.memberId}</a></td>
													<td>${list.memberGrade}</td>

												</tr>
											</c:forEach>

										</tbody>
									</table>

									<!--페이지 -->



									<a href="/schoolAdminInsertUserIdForm" class="pull-right"><button
											class="btn btn-default">사용자 ID등록</button></a><br>
									<br> <br>
									<br>
									<!-- 검색 -->
									<form action="" method="post" class="pull-right">
										<input type="checkbox" id="checkbox-1" name="area"
											value="b_title"> <label>아이디</label> <input
											type="checkbox" id="checkbox-1" name="area" value="b_name">
										<label>등급</label> <input class="btn btn-default" type="text"
											name="searchKey" size="10"> <input type="hidden"
											name="temp" value="temp"> <input
											class="btn btn-default" type="submit" value="검색">
									</form>
									<br>
									<br>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--         컨텐츠 끝 -->
			<footer class="app-footer">
				<div class="wrapper">
					<span class="pull-right">오른쪽쓸것 <a href="#"></a></span> 왼쪽
				</div>
			</footer>
		</div>

</body>

</html>
​
