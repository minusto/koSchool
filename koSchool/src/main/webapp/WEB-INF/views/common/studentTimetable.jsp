<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>학교 시간표</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<!-- jQuery-->
    <script src="/resources/js/jquery.js" type="text/javascript"></script>
    <script type="text/javascript">
    $(function() {
    	
    	var  content = '<table class=" table table-striped" cellspacing="5" align="center" width="550" height="600" border="1" bordercolor="DDDDDD">';
				content += '<thead><tr align="center"><th  width="50"></td> <td>월</td> <td>화</td> <td>수</td> <td>목</td> <td>금</td></tr>';
				content += '<thead><tr id="tr" align="center"> <td>1</td>  <td class="cell"></td>  <td class="cell"></td>  <td class="cell"></td> <td class="cell"></td> <td class="cell"></td></tr>';
				content += '<thead><tr id="tr" align="center"> <td>2</td>  <td class="cell"></td>  <td class="cell"></td>  <td class="cell"></td> <td class="cell"></td> <td class="cell"></td></tr>';
				content += '<thead><tr id="tr" align="center"> <td>3</td>  <td class="cell"></td>  <td class="cell"></td>  <td class="cell"></td> <td class="cell"></td> <td class="cell"></td></tr>';
				content += '<thead><tr id="tr" align="center"> <td>4</td>  <td class="cell"></td>  <td class="cell"></td>  <td class="cell"></td> <td class="cell"></td> <td class="cell"></td></tr>';
				content += '<thead><tr id="tr" align="center"> <td>5</td>  <td class="cell"></td>  <td class="cell"></td>  <td class="cell"></td> <td class="cell"></td> <td class="cell"></td></tr>';
				content += '<thead><tr id="tr" align="center"> <td>6</td>  <td class="cell"></td>  <td class="cell"></td>  <td class="cell"></td> <td class="cell"></td> <td class="cell"></td></tr>';
				content += '<thead><tr id="tr" align="center"> <td>7</td>  <td class="cell"></td>  <td class="cell"></td>  <td class="cell"></td> <td class="cell"></td> <td class="cell"></td></tr>';
				content+='</table>';
								
			$(document).ready(function() {
				$.ajax({
					  url: '/studentTimetableview',
					  type: 'POST',
					  success: function(data){
						  if(data!=null&&data!="empty"){
							  $(".timeview").append(data);
						  }else if(data=="empty"){
							  $(".timeview").append(content);
						  }
					  },
					  error:function(request,status,error){
					        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					       }
					  
					});
				});
		
    
   		 	 		 
    
});

    </script>
    
    <style type="text/css">

	#timemod{
	display: none;
	}
</style>

<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<jsp:include page="studentMenu.jsp"/>
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">학교 시간표</div>
									</div>
								</div>
								<div></div>
								<div class="col-sm-2" ></div>
								<div class="card-body table-responsive col-sm-8">

									<div class="timeview">

			
									</div>
									
						
									</div>
									<div class="col-md-3"></div>
									<div class="col-md-9">
									</div>
									<div class="col-md-12">
									<br><br><br>
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
