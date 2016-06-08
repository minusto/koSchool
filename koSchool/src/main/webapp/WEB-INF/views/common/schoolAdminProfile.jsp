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
    		$('#correctionOk').on('click','#correction',function(){
    			$('input[id=inputPassword3]').attr("readonly",false);
    			$('input[id=password]').attr("readonly",false);
    			$('#correction').css("display","none");
    			$('#commitGo').css("display","inline");
    			$('#cancelGo').css("display","inline");
    			$(".pCheck").css("display","inline");
    			
    		})
    		$('#correctionOk').on('click','#cancelGo',function(){
    			$('input[id=inputPassword3]').attr("readonly",true);
    			$('input[id=password]').attr("readonly",true);
    			$('#commitGo').css("display","none");
    			$('#cancelGo').css("display","none");
    			$('#correction').css("display","inline");
    			$('#del').css("display","inline");
    			$(".pCheck").css("display","none");
    		})
    		$(".pCheck").css("display","none");
    		
    	
    		
    		$('#correctionOk').on('click','#commitGo',function(){
    			var password =document.getElementById('password');
        		var passwordCheck = document.getElementById('pCheck');
    			 if (password.value=="" || password.value == null) {
    				 alert('비밀번호를 입력하세요');
    				return false;
    			}
    			
    			if (passwordCheck.value==" " || passwordCheck.value == null) {
        			alert('비밀번호 체크을 입력하세요'+passwordCheck);
        			return false;
        		} 
    			
    			if (password.value != passwordCheck.value){
    				alert("비밀번호와 비밀번호 확인란이 다릅니다.");
    				return false;
    			}else{
    				alert("수정 되었습니다.")
    			}
    		})
    	

    	})
    </script>
</head>
<style type="text/css">
	.card_wan{
		background-color: #FFF;
  		border-radius: 1px;
  		overflow: hidden;
  		position: relative;
  		width: 800px;
  		height: 800px;
	}
	
</style>
<body class="flat-blue">
    <div class="app-container">
        <div class="row content-container">
            <jsp:include page="schoolAdminMenu.jsp"/>
            <!-- 메인 컨텐츠 -->
            <div class="container-fluid">
                <div class="side-body padding-top">
                	<div class="row">
                        <div class="col-xs-12">
                            <div class="card">
                                <div class="card-header">
                                    <div class="card-title">
                                        <div class="title">${schoolAdmin.schoolAdminName}   정보</div>
                                    </div>
                                    <div class="pull-right card-action">
                                        <div class="btn-group" role="group" aria-label="...">
                                        </div>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="row no-margin col-xs-12">
                                    	<div class="col-md-1 ">
                                        </div>
       
                                        <div class="col-md-4 col-xs-12">
                                        </div>
                                    </div>
                                    <form class="form-inline" action="updateSchoolAdminProfile" method="post" >
                                    		
	
	                                                <div class="col-xs-12">
	                                                <br><br>
	                                                </div>
                                    		<div class="form-inline">
                                    			<div class="col-md-4"></div>
												<div class="col-md-5 col-xs-12" >
													<input type="hidden" name="schoolAdminId" value="${schoolAdmin.schoolAdminId}"> 
                                        			<label for="inputPassword3" class="control-label col-lg-2">이름</label>
                                                	<input type="text" class="form-control" id="inputPassword3" value="${schoolAdmin.schoolAdminName}" name="schoolAdminName" readonly="readonly">
                                          	 		<br><br><br>
                                        			<label for="inputPassword3" class="control-label col-lg-2">주소</label>
                                               	 	<input type="text" class="form-control" id="inputPassword3" value="${schoolAdmin.schoolAdminTel}" name="schoolAdminTel" readonly="readonly">
                                           		 	<br><br><br>
                                           		 	<label for="inputPassword3" class="control-label col-lg-2 pCheck">비밀번호</label>
                                                    <input type="password" class="form-control pCheck" id="password" name="schoolAdminPassword" readonly="readonly">
                                                    <br><br><br>
                                           		 	<label for="inputPassword3" class="control-label col-lg-2 pCheck">비밀번호체크</label>
                                                    <input type="password" class="form-control pCheck" id="pCheck" >
                                        		</div>
												

                                    	</div>
                                        <div class="col-xs-12">
                                        <br><br>
                                        <div class="col-xs-12"></div>
                                         <div class="col-md-3 col-xs-12"></div>
                                            <div class="col-md-3 col-xs-12">
                                                <button type="button" class="btn btn-default" onclick="location.href='/'">메인으로</button>
                                            </div>
                                            <div class="col-md-1 col-xs-12">
                                           
                                            </div>
                                            <div class="col-md-3 col-xs-12" id="correctionOk">
                                            	<!--수정 Button-->
                                                <input type="button" class="btn btn-primary btn-primary" id="correction" value="수정">
                                        		<!-- 수정 완료 -->
                                        		<input type="submit" class="btn btn-primary btn-primary" id="commitGo" style="display:none" value="완료">
                                        		<!--수정 취소  -->
                                        		<input type="button" class="btn btn-primary btn-primary" id="cancelGo" style="display:none" value="취소">

                                            </div>
                                        </div>
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
​