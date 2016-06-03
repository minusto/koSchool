<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">

#receiveMessageTable, #sendMessageTable {	
	overflow: hidden;
	text-overflow: ellipsis;	
	white-space: nowrap;
	table-layout: fixed;
}	
.contentTd {
	overflow: hidden;
	text-overflow: ellipsis;	
	white-space: nowrap;
	} 

</style>

<script type="text/javascript">
	$(function() {
		listSendMessage();
		listReceiveMessage();
		
		setInterval(function() {
			listSendMessage();
			listReceiveMessage()
		}, 3000);
		
		//모든 발신메세지 가져오는 ajax 함수 / 작성자 박종현
		function listSendMessage() {
			$.ajax({
				url : "listSendMessage",
				dataType : 'json',
				success : function(data) {
					$('#sendMessageTbody').html("");
					$.each(data, function(index, sendMessage){
						$('#sendMessageTbody').append('<tr class="contentTd">');
						$('#sendMessageTbody').append('<td class="contentTd">' + sendMessage.receiverMemberId + '</td>');			
						$('#sendMessageTbody').append('<td class="contentTd"><a id="sendMessageRead" data-target="#sendMessageDetail"  class="contentTd" data-toggle="modal" name="' + sendMessage.messageNum+'">' + sendMessage.messageContent + '</a></td>');	
						$('#sendMessageTbody').append('<td class="contentTd">' +(sendMessage.messageReceiveDate).substr(0,16) + '</td>');
						$('#sendMessageTbody').append('<td class="contentTd">' + sendMessage.messageReadCheck + '</td>');
						$('#sendMessageTbody').append('</tr>');
					});
				}
			});
		}//ajax 함수 끝		
		
		//모든 수신메세지 가져오는 ajax 함수 / 작성자 박종현
		function listReceiveMessage() {
			$.ajax({
				url : "listReceiveMessage",
				dataType : 'json',
				success : function(data) {
					$('#receiveMessageTbody').html("");
					$.each(data, function(index, sendMessage){
						$('#receiveMessageTbody').append('<tr class="contentTd">');
						$('#receiveMessageTbody').append('<td class="contentTd">' + sendMessage.senderMemberId + '</td>');
						$('#receiveMessageTbody').append('<td class="contentTd"><a id="receiveMessageRead" data-target="#receiveMessageDetail" class="contentTd" data-toggle="modal" name="' + sendMessage.messageNum+'">' + sendMessage.messageContent + '</a></td>');
						$('#receiveMessageTbody').append('<td class="contentTd">' + (sendMessage.messageReceiveDate).substr(0,16) + '</td>');
						$('#receiveMessageTbody').append('<td class="contentTd">' + sendMessage.messageReadCheck + '</td>');
						$('#receiveMessageTbody').append('</tr>');
					});
					
				}
			});
		}//ajax 함수 끝	
		
		//메시지 발송버튼 클릭이벤트 / 작성자 박종현
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
		
		//보낸 메시지 내용 클릭시 이벤트 -> 디테일보기 / 작성자 박종현
		$(document).on('click','#sendMessageRead', function(){
			$('#sendMessageDetailTbody').html("");
			$.ajax({
				url : "sendMessageRead?messageNum=" + $(this).attr("name") ,
				dataType : 'json',
				success : function(data) {
						$('#sendMessageDetailTbody').append('<tr><td>받는 사람</td><td>시간</td><td>확인여부</td></tr><tr><td>' + data.receiverMemberId + '</td><td>' + (data.messageReceiveDate).substr(0,16) +'</td><td>'
								+ data.messageReadCheck+'</td></tr><tr><td colspan="3">쪽지내용</td></tr><tr><td colspan="3">' + data.messageContent +'<td></tr>');
				}
			});//ajax end
		}); //보낸 메시지 내용클릭 이벤트 end
		
		//받은 메시지 내용 클릭시 이벤트 -> 디테일보기(확인여부 변경 포함) / 작성자 박종현
		$(document).on('click','#receiveMessageRead', function(){
			$('#receiveMessageDetailTbody').html("");
			$.ajax({
				url : "receiveMessageRead?messageNum=" + $(this).attr("name") ,
				dataType : 'json',
				success : function(data) {			
						$('#receiveMessageDetailTbody').append('<tr><td>보낸 사람</td><td>시간</td><td>확인여부</td></tr><tr><td>' + data.senderMemberId + '</td><td>' + (data.messageReceiveDate).substr(0,16) +'</td><td>'
								+ data.messageReadCheck+'</td></tr><tr><td colspan="3">쪽지내용</td></tr><tr><td colspan="3">' + data.messageContent +'<td></tr>');
				}
			});//ajax end
		}); //받은 메시지 내용클릭 이벤트 end
		
		
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
								<table id="receiveMessageTable" class="table table-striped">
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
								<table id="sendMessageTable" class="table table-striped">
									<tr>
										<td>보낸 사람</td>
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

<!-- 보낸쪽지 디테일보기 Modal -->
<div id="sendMessageDetail" class="modal fade modal-success"
	aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
	tabindex="-1" style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" aria-label="Close" data-dismiss="modal"
					type="button">
					<span aria-hidden="true">×</span>
				</button>
				<h4 id="myModalLabel" class="modal-title">쪽지 세부보기</h4>
			</div><!--  model head end -->
			<div class="modal-body">
				<table class="table table-striped" id="sendMessageDetailTbody"> 
					
				</table>
			</div>
		</div>
	</div>
</div>

<!-- 받은쪽지 디테일보기 Modal -->
<div id="receiveMessageDetail" class="modal fade modal-success"
	aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
	tabindex="-1" style="display: none;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" aria-label="Close" data-dismiss="modal"
					type="button">
					<span aria-hidden="true">×</span>
				</button>
				<h4 id="myModalLabel" class="modal-title">쪽지 세부보기</h4>
			</div><!--  model head end -->
			<div class="modal-body">
				<table class="table table-striped" id="receiveMessageDetailTbody"> 
					
				</table>
			</div>
		</div>
	</div>
</div>

</html>