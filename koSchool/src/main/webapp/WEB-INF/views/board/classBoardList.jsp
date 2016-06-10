<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
            <jsp:include page="../common/studentMenu.jsp"/>
            <!-- 메인 컨텐츠 -->
           <div class="container-fluid">
				<div class="side-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">학급게시판 목록</div>
									</div>
								</div>
									<div class="card-body table-responsive">
									<!-- Table -->
									<table class="datatable table table-striped">
										<thead>
											<tr class="headings">
												<th>글번호</th>
												<th>제목</th>
												<th>내용</th>
												<th>조회수</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="list" items="${list}">
												<tr>
												    <td>${list.classBoardNum}</td>
													<td><a href="classBoardDetail?classBoardNum=${list.classBoardNum}">${list.classBoardTitle}</a></td>
													<td>${fn:substring(list.classBoardContent,0,5)}</td>
													<td>${list.classBoardHitcount }</td>	
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