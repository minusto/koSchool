<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>빈칸</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- jQuery-->
    <script src="/resources/js/jquery.js" type="text/javascript"></script>
    <script type="text/javascript">
		$(function(){
			$('#upform').css('display','none');
			
			$('#upup').click(function(){
				$('#upform').css('display','inline');
				$('#upup').css('display','none');
			})
		
	$(document).on('click','#sub',function(){
		  if ($('input[name=memberPassword]').val()=="" || $('input[name=memberPassword]').val() == null) {
			 alert('비밀번호를 입력하세요');
			return false;
		}
    			if ($('input[name=memberPassword]').val()!=$('input[name=pCheck]').val()){
    				alert("비밀번호와 비밀번호 확인란 이 다릅니다.");
    				return false;
    			}else{
    				alert("수정 되었습니다.")
    			} 
	})
		})
	</script>
</head>

<body class="flat-blue">
	<div class="app-container">
		<div class="row content-container">
			<jsp:include page="studentMenu.jsp" />
			<!-- 메인 컨텐츠 -->
			<div class="container-fluid">
				<div class="side-body">
					<div class="row">
						<div class="col-xs-12">
							<div class="card">
								<div class="card-header">
									<div class="card-title">
										<div class="title">${member.memberName }프로필</div>
									</div>
								</div>

								<div class="col-sm-2"></div>
								<div class="card-body table-responsive col-sm-8">
					
									<div class="col-md-12">
										<br> <br> <br>


									</div>

									<!-- Table -->
									<table class="table table-striped">
										<tr height="30">
											<th width="150">이름</th>
											<td width="150">${member.memberName}</td>
										</tr>

										<tr height="30">
											<th width="150">생년월일</th>
											<td width="150">${(member.memberBirthday).substring(0, 10)}</td>
										</tr>
										<tr height="30">
											<th width="150">주소</th>
											<td width="150">${member.memberAddress}</td>
										</tr>
										<tr height="30">
											<th width="150">전화번호</th>
											<td width="150">${member.memberTel}</td>
										</tr>
										<tr height="30">
											<th width="150">이메일</th>
											<td width="150">${member.memberEmail}</td>
										</tr>
									
										<tr height="30">
											<th width="350">relation</th>
											<td width="350" colspan="3">${parent.familyRelation}</td>

										</tr>
									</table>
									<div id="upform" class="col-md-5">
									<form action="/upParentProfile" method="post">
										<div class="form-group">
                                            <label class="col-sm-12 control-label">비밀번호</label>
                                            <div class="col-sm-12">
                                                <input id="password "type="password" class="form-control" name="memberPassword" >
                                            </div>
                                        </div>
                                        
										<div class="form-group">
                                            <label class="col-sm-12 control-label">비밀번호 체크</label>
                                            <div class="col-sm-12">
                                               <input name="pCheck" type="password" class="form-control " >
                                            </div>
                                        </div>
                                            <div class="col-md-12">
                                            <br>
                                            </div>
                                        <div class="form-group col-md-6">
                                                <input id="sub" type="submit" class="form-control " value="수정">
                                            </div>
                                            
									</form>
									</div>
									<div class="col-md-12"></div>
									<a href="/" class="pull-right"><button
											type="button" class="btn btn-primary">돌아가기</button></a>
											<button type="button" class="btn btn-primary" id="upup">비밀번호 수정</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--         컨텐츠 끝 -->

		</div>
</body>

</html>
​
