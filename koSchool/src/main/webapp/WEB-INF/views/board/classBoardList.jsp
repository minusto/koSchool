<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>빈칸</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
  
    <!-- jQuery-->
    <script src="/resources/js/jquery.js" type="text/javascript"></script>
    <script type="text/javascript">
    $(function(){
    	$('tbody').on('click','tr',function(){
    		var memberId = $(this).find('#memberId').html();
    		location.href="teacherListStudentDetail?m_id="+memberId; 
    	})
    })
	</script>
	<style type="text/css">
   	 tbody tr:hover td {
		background: rgba(38, 185, 154, 0.07);
		border-top: 1px solid rgba(38, 185, 154, 0.11);
		border-bottom: 1px solid rgba(38, 185, 154, 0.11);
		}
    </style>
</head>


<body class="flat-blue">
    <div class="app-container">
        <div class="row content-container">
            <jsp:include page="../common/studentMenu.jsp"/>
            <!-- 메인 컨텐츠 -->
           <div class="container-fluid">
				<div class="side-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">학생 목록</div>
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
												<th>내용</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="list" items="${list}">
												<tr>
												    <td>${list.classBoardNum}</td>
													<td>${list.classBoardTitle}</td>
													<td>${list.classBoardContent}</td>	
												</tr>
											</c:forEach>
										</tbody> 
									</table>
									<!--페이지 -->
									<form action="/board/insertClassBoard" method="get">
									<a href="insertClassBoard" class="pull-right" ><button class="btn btn-default" type="submit">등록</button></a><br><br>
 									</form>
 									<br><br>
									<!-- 검색 -->
									<form action="" method="post" class="pull-right">
										<input type="checkbox" id="checkbox-1"name="area" value="b_title"> 
										<label> 사용자ID</label>
										<input type="checkbox" id="checkbox-1"name="area" value="b_name"> 
										<label>이름</label>
										<input class="btn btn-default" type="text" name="searchKey" size="10"> 
										<input type="hidden" name="temp" value="temp" >
										<input class="btn btn-default" type="submit" value="검색">
								</form><br><br>
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