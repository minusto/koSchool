<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setAttribute("path", "가정통신문 > 가정통신문 발송");
%>
<html>
 
<head>
    <title>빈칸</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>
    <!-- CSS Libs -->
    <link rel="stylesheet" type="text/css" href="lib/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="lib/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="lib/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="lib/css/bootstrap-switch.min.css">
    <link rel="stylesheet" type="text/css" href="lib/css/checkbox3.min.css">
    <link rel="stylesheet" type="text/css" href="lib/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="lib/css/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="lib/css/select2.min.css">
    <!-- CSS App -->
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/themes/flat-blue.css">
    
                <!-- Javascript Libs -->
            <script type="text/javascript" src="lib/js/jquery.min.js"></script>
            <script type="text/javascript" src="lib/js/bootstrap.min.js"></script>
            <script type="text/javascript" src="lib/js/Chart.min.js"></script>
            <script type="text/javascript" src="lib/js/bootstrap-switch.min.js"></script>
            <script type="text/javascript" src="lib/js/jquery.matchHeight-min.js"></script>
            <script type="text/javascript" src="lib/js/jquery.dataTables.min.js"></script>
            <script type="text/javascript" src="lib/js/dataTables.bootstrap.min.js"></script>
            <script type="text/javascript" src="lib/js/select2.full.min.js"></script>
            <script type="text/javascript" src="lib/js/ace/ace.js"></script>
            <script type="text/javascript" src="lib/js/ace/mode-html.js"></script>
            <script type="text/javascript" src="lib/js/ace/theme-github.js"></script>
            <!-- Javascript -->
            <script type="text/javascript" src="js/app.js"></script>
            <script type="text/javascript" src="js/index.js"></script>
</head>

<script type="libsjSignature.min.js"></script>
<div id="signature"></div>
<body class="flat-blue">
	<form id="frm" method="post">
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
													<td></td>
												</tr>
												
												<tr>
													
													
									
												</tr>
												<tr>
													<td align="center"><a href="teacherMain.jsp" ><button class="btn btn-default">메인으로</button></a></td>
													<td align="center"><a href="javascript:$('#frm').submit();" ><button class="btn btn-default">가정통신문 발송</button></a></td>
													<td align="center"><a href="teacherListNoticeParent.jsp" ><button class="btn btn-default">목록보기</button></a></td>												
												</tr>
											</tbody> 
											
										</table>
										</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	    </div>
	</div>
</form>
</body>


</html>
​