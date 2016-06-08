<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setAttribute("path", "가정통신문 > 가정통신문 발송");
%>
<html>
<head>
    <title>빈칸</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<div id="signature"></div>
<body class="flat-blue">

		<input type="text" name="memberId" value="${memberId}">
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
											<div class="title">가정통신문 발송</div>
										</div>
									</div>
									<div class="col-lg-1"></div>
									<div class="card-body table-responsive col-lg-10">
										<!-- Table -->
											<form id="frm" method="post" action="/message/schoolNewsLetter">
										<table class="table table-striped">
											<thead>
												<tr class="headings">
													<th></th>
													<th style="text-align: center">가정통신문</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<tr>
												 <td colspan="3" align="center"><input placeholder="가정통신문 제목" name="title"/></td>
												</tr>
												<tr>
												 <td colspan="3" align="center"><textarea cols="150"  rows="25" placeholder="가정통신문 내용" name="content"></textarea></td>
												</tr>
												<tr>
													<td align="center"><a href="javascript:$('#frm').submit();" ><button class="btn btn-default">가정통신문 발송</button></a></td>
													
												</tr>
											</tbody> 	
										</table>
										</form>
										<button onclick="location.href='/'" class="btn btn-default">메인으로</button>
										<button onclick="location.href='/message/schoolNewsLetterList'" class="btn btn-default">목록보기</button>											
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