<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
td {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>

<script type="text/javascript">
	$(function() {
		listSendMessage();
		listReceiveMessage();
		
		//모든 발신메세지 가져오는 ajax 함수
		function listSendMessage() {
			$.ajax({
				url : "listSendMessage",
				dataType : 'json',
				success : function(data) {
					$.each(data, function(index, sendMessage){
						$('#sendMessageTbody').append('<tr>');
						$('#sendMessageTbody').append('<td>' + sendMessage.receiverMemberId + '</td>');
						$('#sendMessageTbody').append('<td>' + sendMessage.messageContent + '</td>');						
						$('#sendMessageTbody').append('<td>' +(sendMessage.messageReceiveDate).substr(0,16) + '</td>');
						$('#sendMessageTbody').append('<td>' + sendMessage.messageReadCheck + '</td>');
						$('#sendMessageTbody').append('</tr>');
					});
				}
			});
		}//ajax 끝
		
		//모든 수신메세지 가져오는 ajax 함수
		function listReceiveMessage() {
			$.ajax({
				url : "listReceiveMessage",
				dataType : 'json',
				success : function(data) {
					$.each(data, function(index, sendMessage){
						$('#receiveMessageTbody').append('<tr>');
						$('#receiveMessageTbody').append('<td>' + sendMessage.senderMemberId + '</td>');
						$('#receiveMessageTbody').append('<td>' + sendMessage.messageContent + '</td>');
						$('#receiveMessageTbody').append('<td>' + (sendMessage.messageReceiveDate).substr(0,16) + '</td>');
						$('#receiveMessageTbody').append('<td>' + sendMessage.messageReadCheck + '</td>');
						$('#receiveMessageTbody').append('</tr>');
					});
				}
			});//ajax 끝
		}
		
		$('#messageSend').on('click',function(){
			var receiverMemberId = $('#receiverMemberId').val();
			var messageContent = $('#messageContent').val();
			
			$.ajax({
				type:'post',
				url : "sendMessage",
				headers : { "Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"},
				dataType : 'text',
				data: JSON.stringify({
					receiverMemberId : receiverMemberId,
					messageContent : messageContent
				}),
				success : function(result) {
					if(result == "SUCCESS"){
						alert("메시지가 발송되었습니다");
					}else{
						alert("메시지 전송 실패");
					}
					$('#receiverMemberId').val('');
					$('#messageContent').val('');
				}
			});
			
		});//발송 click이벤트 end
		
	})
</script>


</head>

<div id="messageModal" class="modal fade modal-success"
	aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
	tabindex="-1" style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" aria-label="Close" data-dismiss="modal"
					type="button">
					<span aria-hidden="true">×</span>
				</button>
				<h4 id="myModalLabel" class="modal-title">쪽지</h4>
			</div>
			<!--  model head end -->
			<div class="modal-body row">
				<!-- size up -->
				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab1" data-toggle="tab">받은
								쪽지함</a></li>
						<li><a href="#tab2" data-toggle="tab">보낸 쪽지함</a></li>
						<li><a href="#tab3" data-toggle="tab">쪽지 보내기</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tab1">
						<div id="receiveMessageDiv">
								<table class="table table-striped" >
									<tr>
										<td>받는 사람</td>
										<td>내용</td>
										<td>시간</td>
										<td>확인여부</td>
									</tr>								
								<tbody id="receiveMessageTbody"></tbody>
								</table>
							</div>
						</div><!-- 받은쪽지함 내용들 -->
						
						<div class="tab-pane" id="tab2">
							<div id="sendMessageDiv">
								<table class="table table-striped">
									<tr>
										<td>받는 사람</td>
										<td>내용</td>
										<td>시간</td>
										<td>확인여부</td>
									</tr>
									<tbody id="sendMessageTbody"></tbody>
								</table>
							</div>
						</div><!-- 보낸쪽지함 내용들 -->
						<div class="tab-pane" id="tab3">
							<div class="col-md-8 col-md-offset-2" style="text-align: left">
								<label>받는 사람</label></li>
								<input type="text" id="receiverMemberId" name="receiverMemberId"
										placeholder="아이디" class="form-control">								
								
								<label>내 용</label>
								<textarea rows="8" cols="5" id="messageContent" name="messageContent" class="form-control" placeholder="메세지"></textarea>
								<br>						
								<input type="button" id="messageSend" value="발송">
							</div>
						</div>
						<!-- tab3 end -->
					</div>
					<!-- tab content end -->
				</div>
				<!-- modal tabbable end -->
			</div>
			<!-- modal-body end -->
		</div>
		<!-- modal-content end -->
	</div>
</div>

</html>