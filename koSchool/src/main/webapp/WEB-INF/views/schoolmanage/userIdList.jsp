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
<style type="text/css">
	.headings {
		background: rgba(52, 73, 94, 0.94);
		color: white;
	}
	
	tbody tr:hover td {
		background: rgba(38, 185, 154, 0.07);
		border-top: 1px solid rgba(38, 185, 154, 0.11);
		border-bottom: 1px solid rgba(38, 185, 154, 0.11);
	}
	
	tbody tr.selected {
		background: rgba(38, 185, 154, 0.16);
	}
	
	tbody tr.selected td {
		border-top: 1px solid rgba(38, 185, 154, 0.40);
		border-bottom: 1px solid rgba(38, 185, 154, 0.40);
	}
</style>
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
									<table class="datatable table table-striped">
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

									<br>
									<br>
									<a href="/schoolAdminInsertUserIdForm" class="pull-right"><button
											class="btn btn-default">사용자 ID등록</button></a><br>
									<br> <br><br>
									
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
