<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<title>빈칸</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
	tbody th {
		background: rgba(38, 185, 154, 0.11);
		color: black;
	}
</style>
<script src="/resources/js/jquery.js" type="text/javascript"></script>
<script>
	$(function() {
		$('#updateButton').click(function() {
			location.href="/classBoardUpdate?classBoardNum=${classBoardDetail.classBoardNum }";
		})
		
		$('#deleteOk').click(function(){
			location.href="/classBoardDelete?classBoardNum=${classBoardDetail.classBoardNum }";
		})
	});
</script>
</head>

<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
		<c:choose>
			<c:when test="${grade eq 'schoolAdmin' }">
				<jsp:include page="../common/schoolAdminMenu.jsp" />
			</c:when>
			<c:when test="${grade eq 'student' || grade eq 'parent' }">
				<jsp:include page="../common/studentMenu.jsp" />
			</c:when>
			<c:when test="${grade eq 'teacher' }">
				<jsp:include page="../common/teacherMenu.jsp" />
			</c:when>
			<c:otherwise>
				<jsp:include page="../common/systemAdminMenu.jsp" />
			</c:otherwise>
		</c:choose>
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">공지사항 상세보기</div>
									</div>
								</div>
								<div class="card-body table-responsive col-lg-8">
									<!-- Table -->
									<table class="table table-bordered">
										<tr height="30">
											<th width="150">글번호</th>
											<td width="150">${classBoardDetail.classBoardNum}</td>
											<th width="150">조회수</th>
											<td width="150">${classBoardDetail.classBoardHitcount}</td>
										</tr>
										<tr height="30">
											<th width="150">작성자</th>
											<td width="150">${classBoardDetail.memberId}</td>
											<th width="150">작성일</th>
											<td width="150"><fmt:formatDate
													value="${classBoardDetail.classBoardDate}" pattern="yyyy-MM-dd" /></td>
										</tr>
										<tr height="30">
											<th width="150">제목</th>
											<td colspan="3">${classBoardDetail.classBoardTitle }</td>
										</tr>
										<tr height="30">
											<th width="150">파일</th>
											<%-- <td colspan="3"><a
												href="/DownloadView?fileName=${classBoardDetail.classBoardFileName}">${classBoardDetail.classBoardFileName}</a>
											</td> --%>
										</tr>
										<tr height="150">
											<td colspan="4">${classBoardDetail.classBoardContent}</td>
										</tr>
									</table>
									<a href="/classBoardList"><button class="btn btn-primary">목록보기</button></a>
									<%-- <c:if test="${member eq '${classBoardDetail.memberId}'"> --%>
										<button class="btn btn-info" id="updateButton">수정</button>
										<!--삭제 Button trigger modal -->
	                                    <input type="button" class="btn btn-warning" data-toggle="modal" data-target="#deleteModal" id="deleteButton" value="삭제">
										<!--삭제 알림 Modal -->
	                               		<div class="modal fade modal-primary" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	                                   		<div class="modal-dialog">
	                                       		<div class="modal-content">
	                                           		<div class="modal-header">
	                                               		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                                               		<h4 class="modal-title" id="myModalLabel">알림창</h4>
	                                           		</div>
	                                           		<div class="modal-body">
	                                               		정말 삭제하시겠습니까?
	                                               	</div>
	                                           		<div class="modal-footer">
	                                               		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	                                               		<button type="button" class="btn btn-primary" id="deleteOk">OK</button>
	                                           		</div>
	                                       		</div>
	                                   		</div>
	                               		</div>
									<%-- </c:if> --%>
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
