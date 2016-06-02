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
			<jsp:include page="../common/schoolAdminMenu.jsp"/>
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">학교 목록</div>
									</div>
								</div>
								<div class="col-sm-2"></div>
								<div class="card-body table-responsive col-sm-8">
									<!-- Table -->
									<table class="table table-striped">
										<tr height="30">
											<th width="150">학교아이디</th>
											<td width="150">123123</td>
										</tr>
										
										<tr height="30">
											<th width="150">학교이름</th>
											<td width="150">11</td>
										</tr>
										<tr height="30">
											<th width="150">주소</th>
											<td width="150">서울시 가산</td>
										</tr>
										<tr height="30">
											<th width="150">작성일</th>
											<td width="150"> 02-444-4444</td>
										</tr>
									</table>
									<a href="#" class="pull-right" ><button type="button" class="btn btn-primary">정보수정</button></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--         컨텐츠 끝 -->
			
		</div>

</body>

</html>
​
