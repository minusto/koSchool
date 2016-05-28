<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setAttribute("path", "Main");
%>
<!DOCTYPE html>
<html>

<head>
<title>빈칸</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
</head>

<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
		
		<jsp:include page="systemAdminMenu.jsp"/>

			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body">
					<div class="card">
						<div class="card-body ">

							<div class="col-sm-3">
								<div class="pricing-table green">
								<a href="systemInsertSchoolAdminForm.jsp">
									<div class="pt-header">
										<div class="plan-pricing">
											<div class="pricing">학교관리자 등록</div>
											<div class="pricing-type"></div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-3">
								<div class="pricing-table blue">
								<a href="schoolAdminList.jsp">
									<div class="pt-header">
										<div class="plan-pricing">
											<div class="pricing">학교관리자 목록</div>
											<div class="pricing-type"></div>
										</div>
									</div>
								</div>
							</div>
							
							<div class="clear-both"></div>
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
</body>

</html>
​
