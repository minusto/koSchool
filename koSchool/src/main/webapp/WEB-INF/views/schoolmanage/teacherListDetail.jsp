
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%
	request.setCharacterEncoding("utf-8");
	String memberId =request.getParameter("memberId");
	TeacherDetail teacher = service.detailTeacher(memberId);
	Teacher teacher2 = service.teacherImageService(memberId );
	request.setAttribute("teacher", teacher);
	request.setAttribute("teacher2", teacher2);
%> --%>
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
										<div class="title">교사 정보</div>
									</div>
								</div>
								
								<div class="col-sm-2"></div>
								<div class="card-body table-responsive col-sm-8">
								<div class="col-sm-1" align="center" >
                                                <c:if test="${teacher2.teacherPicture!=null }">
													<c:set var="head" value="${fn:substring(teacher2.teacherPicture,0,fn:length(teacher2.teacherPicture)-4) }"></c:set>
													<c:set var="pattern" value="${fn:substringAfter(teacher2.teacherPicture,head) }"></c:set>
													<img src="upload/${ head}_resize${pattern}">
												</c:if>
                                     	</div>
                                     	<div>
                                     	</div>
                                     	<br><br>
									<!-- Table -->
									<table class="table table-striped">
										<tr height="30">
											<th width="150">이름</th>
											<td width="150">${teacher.memberName}</td>
										</tr>
										
										<tr height="30">
											<th width="150">생년월일</th>
										 	<td width="150">${fn:substring(teacher.memberBirthday, 0, 10)}</td>
										 	</tr>
										<tr height="30">
											<th width="150">전화번호</th>
											<td width="150">${teacher.memberTel}</td>
										</tr>
										<%-- <tr height="30">
											<th width="150">주소</th>
											<td width="150">${teacher.memberAddress}</td>
										</tr> --%>
										<tr height="30">
											<th width="150">이메일</th>
											<td width="150">${teacher.memberEmail}</td>
										</tr>
										<tr height="30">
											<th width="150">담당학급</th>
											<td width="150">${teacher.teacherClass}</td>
										</tr>
										<tr height="30">
											<th width="150">담당과목</th>
											<td width="150">${teacher.subjectId}</td>
										</tr>
									</table>
									<a href="/teacherUpdate?memberId=${teacher.memberId}" class="pull-right" ><button type="button" class="btn btn-primary">정보수정</button></a>
									<a href="/teacherDelete?memberId=${teacher.memberId}" class="pull-right" ><button type="button" class="btn btn-primary">삭제</button></a>
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
