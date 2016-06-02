<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	
<!DOCTYPE html>
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
			<!-- 메인 컨텐츠  -->
			<div class="container-fluid">
				<div class="side-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">공지사항</div>
									</div>
								</div>
				
								<div class="card-body table-responsive">
									<!-- Table -->
									<table class="datatable table table-striped ">
										<thead>
											<tr class="headings">
												<th>번호</th>
												<th>제목</th>
												<th>날짜</th>
												<th>조회수</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="noticeBoard" items="${noticeBoardList }">
												<tr>
													<td>${noticeBoard.noticeBoardNum }</td>
													<td><a href="/noticeBoardDetail?noticeBoardNum=${noticeBoard.noticeBoardNum }">${noticeBoard.noticeBoardTitle }</a></td>
													<td>
														<fmt:formatDate value="${noticeBoard.noticeBoardDate }" pattern="yyyy-MM-dd" />
													</td>
													<td>${noticeBoard.noticeBoardHitcount }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
				
									<!--페이지 -->
									<%-- <c:set var="grade" value="${grade }" />
				
									<c:choose>
										<c:when test="${grade eq '학생'}">
											<c:if test="${listModel.startPage > 5}">
												<a
													href="studentNoticeBoardList.jsp?pageNum=${listModel.startPage - 5}">[이전]</a>
											</c:if>
				
											<c:forEach var="pageNo" begin="${listModel.startPage}"
												end="${listModel.endPage}">
												<c:if test="${listModel.requestPage == pageNo}">
													<b>
												</c:if>
												<a href="studentNoticeBoardList.jsp?pageNum=${pageNo}">[${pageNo}]</a>
												<c:if test="${listModel.requestPage == pageNo}">
													</b>
												</c:if>
											</c:forEach>
				
											<c:if test="${listModel.endPage < listModel.totalPageCount}">
												<a
													href="studentNoticeBoardList.jsp?pageNum=${listModel.startPage + 5}">[다음]</a>
											</c:if>
				
										</c:when>
				
										<c:when test="${grade eq '교사'}">
											<c:if test="${listModel.startPage > 5}">
												<a
													href="teacherNoticeBoardList.jsp?pageNum=${listModel.startPage - 5}">[이전]</a>
											</c:if>
				
											<c:forEach var="pageNo" begin="${listModel.startPage}"
												end="${listModel.endPage}">
												<c:if test="${listModel.requestPage == pageNo}">
													<b>
												</c:if>
												<a href="teacherNoticeBoardList.jsp?pageNum=${pageNo}">[${pageNo}]</a>
												<c:if test="${listModel.requestPage == pageNo}">
													</b>
												</c:if>
											</c:forEach>
				
											<c:if test="${listModel.endPage < listModel.totalPageCount}">
												<a
													href="teacherNoticeBoardList.jsp?pageNum=${listModel.startPage + 5}">[다음]</a>
											</c:if>
										</c:when>
				
										<c:when test="${grade eq '학부모'}">
											<c:if test="${listModel.startPage > 5}">
												<a
													href="parentNoticeBoardList.jsp?pageNum=${listModel.startPage - 5}">[이전]</a>
											</c:if>
				
											<c:forEach var="pageNo" begin="${listModel.startPage}"
												end="${listModel.endPage}">
												<c:if test="${listModel.requestPage == pageNo}">
													<b>
												</c:if>
												<a href="parentNoticeBoardList.jsp?pageNum=${pageNo}">[${pageNo}]</a>
												<c:if test="${listModel.requestPage == pageNo}">
													</b>
												</c:if>
											</c:forEach>
				
											<c:if test="${listModel.endPage < listModel.totalPageCount}">
												<a
													href="parentNoticeBoardList.jsp?pageNum=${listModel.startPage + 5}">[다음]</a>
											</c:if>
										</c:when>
				
										<c:otherwise>
											<c:if test="${listModel.startPage > 5}">
												<a
													href="schoolAdminNoticeBoardList.jsp?pageNum=${listModel.startPage - 5}">[이전]</a>
											</c:if>
				
											<c:forEach var="pageNo" begin="${listModel.startPage}"
												end="${listModel.endPage}">
												<c:if test="${listModel.requestPage == pageNo}">
													<b>
												</c:if>
												<a href="schoolAdminNoticeBoardList.jsp?pageNum=${pageNo}">[${pageNo}]</a>
												<c:if test="${listModel.requestPage == pageNo}">
													</b>
												</c:if>
											</c:forEach>
				
											<c:if test="${listModel.endPage < listModel.totalPageCount}">
												<a
													href="schoolAdminNoticeBoardList.jsp?pageNum=${listModel.startPage + 5}">[다음]</a>
											</c:if>
				
										</c:otherwise>
									</c:choose> --%>
				
				
									<!-- 검색 -->
									<!-- <form action="" method="post" class="pull-right">
										<input type="checkbox" id="checkbox-1" name="area"
											value="noticeBoardTitle"> <label> 제목</label> <input
											type="checkbox" id="checkbox-1" name="area" value="schoolAdminId">
										<label> 작성자</label> <input class="btn btn-default" type="text"
											name="searchKey" size="10"> <input type="hidden"
											name="temp" value="temp"> <input class="btn btn-default"
											type="submit" value="검색">
										<button class="btn btn-default"
											onclick="javascript :location.replace()">검색초기화</button>
									</form> -->
				
								</div>
							</div>
						</div>
					</div>
					<c:if test="${grade eq 'schoolAdmin'}">
						<button type="button" class="btn btn-primary" onclick="location.href='/insertNoticeBoardForm'">등록</button>
					</c:if>
				</div>
			</div>
		</div>
	</div>

</body>
</html>