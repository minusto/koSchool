<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>빈칸</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
		
		<jsp:include page="./systemAdminMenu.jsp"/>

			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body">
					<div class="card">
						<div class="card-body ">

							<div class="col-sm-3">
								<div class="pricing-table green">
								<a href="/systemInsertSchoolAdminForm">
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
								<a href="/schoolAdminList">
									<div class="pt-header">
										<div class="plan-pricing">
											<div class="pricing">학교관리자 목록</div>
											<div class="pricing-type"></div>
										</div>
									</div>
								</div>
							</div>
								<div class="col-sm-3">
								<div class="pricing-table blue">
								<a href="/universityManage">
									<div class="pt-header">
										<div class="plan-pricing">
											<div class="pricing">대학교 관리</div>
											<div class="pricing-type"></div>
										</div>
									</div>
								</div>
							</div>
							
							<div class="clear-both"></div>
						</div>
					</div>
				</div>

			
</body>

</html>
​
