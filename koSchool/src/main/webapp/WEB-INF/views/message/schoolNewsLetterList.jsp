<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	
<!DOCTYPE html>
<%
	request.setAttribute("path", "가정통신문 > 가정통신문 조회");
%>
<html>
<head>
    <title>빈칸</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <style type="text/css">
   	 #newsLetterTbody tr:hover td {
		background: rgba(38, 185, 154, 0.07);
		border-top: 1px solid rgba(38, 185, 154, 0.11);
		border-bottom: 1px solid rgba(38, 185, 154, 0.11);
		}
    </style>
</head>

<body class="flat-blue">
    <div class="app-container">
        <div class="row content-container">
            <jsp:include page="../common/teacherMenu.jsp"/>
            <!-- 메인 컨텐츠 -->
            <div class="container-fluid">
				<div class="side-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">가정통신문 목록</div>
									</div>
								</div>
								<div class="col-lg-1"></div>
								<div class="card-body table-responsive col-lg-10">
									<!-- Table -->
									<table class="table table-striped">
										<thead>
											<tr class="headings">
												<th>글번호</th>
												<th>제목</th>
											</tr>
										</thead>
										<tbody id="newsLetterTbody">
											<c:forEach var="list" items="${list}">
												<tr>
												<td>${list.schoolNewsLetterNum}</td>
												<td><a href="schoolNewsLetterDetail?schoolNewsLetterNum=${list.schoolNewsLetterNum}">${list.title}</a></td>			
												</tr>
											</c:forEach>
										</tbody> 
									</table>
									<!--페이지 -->
									<a href="schoolNewsLetter" class="pull-right" ><button class="btn btn-default">가정통신문 발송</button></a><br><br>
 									<br><br>
									<!-- 검색 -->
									<form action="" method="post" class="pull-right">
										<input type="checkbox" id="checkbox-1"name="area" value="b_title"> 
										<label> 학부모 이름</label>
										<input type="checkbox" id="checkbox-1"name="area" value="b_name"> 
										<label> 학생 이름</label>
										<input class="btn btn-default" type="text" name="searchKey" size="10"> 
										<input type="hidden" name="temp" value="temp" >
										<input class="btn btn-default" type="submit" value="검색">
									</form>
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