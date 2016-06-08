<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<title>모의고사 점수확인 페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <script type="text/javascript" src="js/jquery.js"></script> -->

</head>

<body class="flat-blue">
   <div class="app-container">
        <div class="row content-container">
        	<c:if test="${grade eq 'schoolAdmin' }">
				<jsp:include page="../../common/schoolAdminMenu.jsp" />
			</c:if>
			<c:if test="${grade eq 'student' }">
				<jsp:include page="../../common/studentMenu.jsp" />
			</c:if>

			<c:if test="${grade eq 'teacher' }">
				<jsp:include page="../../common/teacherMenu.jsp" />
			</c:if>
			<c:if test="${grade eq 'parent' }">
				<jsp:include page="../../common/studentMenu.jsp" />
			</c:if>
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body padding-top">
					<jsp:include page="listMockTestScore.jsp"/>
				</div>
			</div>
		</div>
	</div>
</body>

</html>