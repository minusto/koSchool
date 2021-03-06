<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>

<head>
    <title>빈칸</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<style type="text/css">
  canvas{
   border:blue dotted 1px;
   cursor: crosshair;
  }
  #clr div{
   cursor: pointer;
   width:20px;
   height:20px;
   float: left;
  }
 </style>
 <script type="text/javascript">
  var draw = false;
  var preX, preY;
  var ctx;
  var num = 0;
  window.onload = function(){
   var canvas = document.getElementById("can");
   ctx = canvas.getContext("2d");
   ctx.strokeStyle = "black";

   // 선 그리기 작업 ----------------------------------
   //canvas.onmousedown = func1; 같은 뜻이다
   canvas.addEventListener("mousedown", func1, false);
   canvas.addEventListener("mouseup", func2, false);
   canvas.addEventListener("mousemove", func3, false);

   //선 색상 팔레트에서 선택하기 ----------------------
   //var pals = document.getElementsByName("pal")[0];
   //alert(pals.length);
   document.getElementsByName("pal")[0].onclick = function(){
    funcColor(0);
   }
   document.getElementsByName("pal")[1].onclick = function(){
    funcColor(1);
   }
   document.getElementsByName("pal")[2].onclick = function(){
    funcColor(2);
   }
   document.getElementsByName("pal")[3].onclick = function(){
    funcColor(3);
   }
   //화면 초기화
   document.getElementById("clear").onclick = function(){
    //alert("clear");
    ctx.fillStyle = "white";
    ctx.fillRect(0, 0, canvas.width, canvas.height);
   }
   //별도 보관
   document.getElementById("save").onclick = function(){
    var pic = "<img src ='" +  canvas.toDataURL() + "'>"

    //alert("save");
    //alert(canvas.toDataURL());
    //document.getElementsById("result").appendChild("~");
    document.getElementById("result").innerHTML = pic;
    //<img src="canvas.toDataURL()">

   }
   //지우개
   document.getElementById("eraser").onclick = function(){
    //alert("eraser");
    ctx.strokeStyle = "white";
   }
   //굵기 변경
   document.getElementById("sun").onchange = Su;
          
  }
  function func1(event){
   //console.log(event.offsetX, " ", event.offsetY);
   draw = true;
   preX = event.offsetX;  //page는 브라우저 좌표 기준 , offset는 캔버스 좌표 기준
   preY =event.offsetY;
  }
  function func2(event){
   draw = false;
  }
  function func3(event){
   if(draw == true){
    //console.log(event.offsetX, " ", event.offsetY);
    ctx.lineWidth = num;
    ctx.beginPath();
    ctx.moveTo(preX, preY); //해당 좌표로 이동
    ctx.lineTo(event.offsetX, event.offsetY);
    ctx.stroke(); //선이 그려짐
    preX = event.offsetX;
    preY = event.offsetY; // 이전 값을 다시 준다. 자유곡선
    ctx.closePath();
   } 
  }
  function funcColor(i){
   //alert("good");
   ctx.strokeStyle = document.getElementsByName("pal")[i].getAttribute("value");
  }
  function Su(){
   num=LW.sun.options[LW.sun.selectedIndex].value;
  }

 </script>

	<script type="text/javascript">
		function saveSign() {
			var canvas = document.getElementById("can");
			
			//var html = "<img src='" + canvas.toDataURL() + "' />";
			//$("#test").html(html);
			
			$("input[name='sign']").val(canvas.toDataURL());
			$("#frm").submit();
		}
	</script>
	
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
										<div class="title">가정통신문 상세조회</div>
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
											 <td colspan="3" align="center">${detail.title}</td>
											</tr>
											
											<tr>
												<td colspan="3" align="center">${detail.content}</td>
											</tr>
											
											<tr>	
												<td align="center" colspan="3">학부모  서명확인란</td>	
											</tr>
		
											<!-- 선생님일 경우 -->
									<c:if test="${grade eq 'teacher'}">
										<c:forEach var="list" items="${signList}">
											<tr>
												<td>${list.memberName}</td>
												<td>${list.memberId}</td>
												<c:choose>
													<c:when test="${!empty list.sign }">
														<td><img height="30"  src="${list.sign}" /></td>
													</c:when>
													<c:when test="${empty list.sign }">
														<td>싸인요망</td>
													</c:when>
												</c:choose>
											</tr>	
										</c:forEach>
									</c:if>
										</tbody> 
									</table>
									
										<!-- 학부모일 경우 -->
										<c:if test="${grade eq 'parent'}">
											<canvas id="can" width="100" height="100"></canvas>
											<input id="sign" type="button" value="서명전송" onclick="saveSign();">
										</c:if>
									</div>
									
									<!-- 학부모일 경우 -->
									<c:if test="${grade eq 'parent'}">
										<form id="frm" action="schoolNewsLetterSignUpdate" method="post">
											<input type="hidden" name="schoolNewsLetterNum" value="${param.schoolNewsLetterNum}" />
											<input type="hidden" name="sign" value="" />
										</form>
									</c:if>
									
									<br />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>