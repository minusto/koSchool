<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<jsp:include page="teacherMenu.jsp" />
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">${member.memberName } 프로필</div>
									</div>
								</div>

								<div class="col-sm-2"></div>
								<div class="card-body table-responsive col-sm-8">
									<div class="col-sm-1" align="center">
										<c:if test="${teacher.teacherPicture!=null }">
											<c:set var="head"
												value="${fn:substring(teacher.teacherPicture,0,fn:length(teacher.teacherPicture)-4) }"></c:set>
											<c:set var="pattern"
												value="${fn:substringAfter(teacher.teacherPicture,head) }"></c:set>
											<img src="upload/${ head}_resize${pattern}">
										</c:if>
									</div>
									<div class="col-md-12">
										<br>
										<br>
										<br>


									</div>

									<!-- Table -->
									<table class="table table-striped">
										<tr height="30">
											<th width="150">이름</th>
											<td width="150">${member.memberName}</td>
										</tr>

										<tr height="30">
											<th width="150">생년월일</th>
											<td width="150">${(member.memberBirthday).substring(0, 10)}</td>
										</tr>
										<tr height="30">
											<th width="150">주소</th>
											<td width="150">${member.memberAddress}</td>
										</tr>
										<tr height="30">
											<th width="150">전화번호</th>
											<td width="150">${member.memberTel}</td>
										</tr>
										<tr height="30">
											<th width="150">이메일</th>
											<td width="150">${member.memberEmail}</td>
										</tr>
										<tr height="30">
											<th width="150">담당학급</th>
											<td width="150">${teacher.teacherClass}</td>
										</tr>
										<tr height="30">
											<th width="150">담당과목</th>
											<td width="150">${teacher.subjectId}</td>
										</tr>
										<tr height="30">
											<th width="150">직책</th>
											<td width="150">${teacher.teacherPosition}</td>
										</tr>
									</table>
									<a href="/teacherProfileUpdate" class="pull-right"><button
											type="button" class="btn btn-primary">정보수정</button></a>
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
