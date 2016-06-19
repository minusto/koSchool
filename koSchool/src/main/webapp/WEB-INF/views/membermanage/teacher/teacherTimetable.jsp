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
				
				$(document).on('click','.del',function() {			
		  	 		$.ajax({      
		  		        type:"POST",  
		  		        url:"/deleteTimetable",      
		  		        success:function(data){   
		  		        	if(data=="삭제")
		  		            alert("삭제 완료");   
		  		        	
		  		        	 $(".timeview").empty();
		  		        	 $(".timeview").append(content);
		  		        },    
		  		        error:function(){  
		  		            alert("실패");  
		  		        }  
		  		    });  
		  		})

			$(document).ready(function() {
				$.ajax({
					  url: '/timetableview',
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
		
    
	name="";
   		 $(document).on('click','.cell',function() {
    	
    	var name;
        do {
            name=prompt("과목입력");
        }
        while(name.length < 1);
        
        $(this).text(name);
    	
    	
    }); 
   		 	 		 
    
});
   $(function(){
  		$(document).on('click','.save',function() {
  		  var timedata = $(".timeview").html();
  			//alert(timedata); 			
  	 		$.ajax({      
  		        type:"POST",  
  		        url:"/timetable",      
  		        data: {timedata:timedata}, 
  		        success:function(data){   
  		        	if(data=="성공")
  		            alert("입력 완료");     
  		        },    
  		      error:function(request,status,error){
			        alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			       }
  		    });  
  		})
  		
  		
   })


    </script>
    
<style type="text/css">
	#timemod{
	display: none;
	}
	#buttonDiv {
		text-align: center;
	}
	.timeTableButton {
		margin : 10px;
		width : 80px;
		height : 40px;
	}
</style>

<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<jsp:include page="../../common/teacherMenu.jsp" />
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
								<div class="card-body table-responsive col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2">
									<div class="timeview">

			
									</div>
								</div>
								<div class="col-sm-1 col-md-2"></div>
								<div id="buttonDiv" class="col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2">
									<button class="save btn btn-primary timeTableButton">저장</button>
									<button class="del btn  timeTableButton">삭제</button>
									<br><br><br>
								</div>
								<div class="col-md-12">
									<br><br><br>
								</div>
								<div class="col-md-2" ></div>
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
