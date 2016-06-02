<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

<head>
<title>빈칸</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<jsp:include page="../common/systemAdminMenu.jsp"/>
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
								<div class="card-body table-responsive">
									<!-- Table -->
									<table class=" table table-striped">
										<thead>
											<tr class="headings">
												<th>관리자ID</th>
												<th>전화번호</th>
												<th>삭제신청여부</th>
												<th>등록일</th>
												<th>만료일</th>
											</tr>
										</thead>
										<c:forEach items="${list }" var="SchoolAdminListVO" >
											
										<tbody>
											<tr>
												<td><a href="/schoolAdminDetail?id=${SchoolAdminListVO.schoolAdminId }">${SchoolAdminListVO.schoolAdminId }</a></td>
												<td>${SchoolAdminListVO.schoolAdminTel }</td>
												<td>${SchoolAdminListVO.deleteRequest }</td>
												<td>
												<fmt:formatDate value="${SchoolAdminListVO.schoolRegistDate }" pattern="yyyy-MM-dd"/>
												</td>
												<td>
												<fmt:formatDate value="${SchoolAdminListVO.schoolEndDate }" pattern="yyyy-MM-dd"/>
												</td>
											</tr>
										</tbody> 
										</c:forEach>
									</table>
 									
									<!--페이지 -->
									
									
 									
 									<a href="#" class="pull-right" ><button class="btn btn-default" onclick="location.href='/schoolmanage/systemInsertSchoolAdminForm'">학교관리자 등록</button></a><br><br>
 									<br><br>
									
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	<script type="text/javascript">
	var result = '${msg}';
    
    if(result == 'SUCCESS'){
    	alert("등록 되었습니다.");
    }
	</script>
</body>

</html>
​
