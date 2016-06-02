package ko.school.message.domain;

public class MessageVO {
	private int messageNum;
	private String senderMemberId;
	private String receiverMemberId;
	private String messageContent;
	private String messageReceiveDate;
	private String messageReadCheck;
	
	
	public int getMessageNum() {
		return messageNum;
	}

	public void setMessageNum(int messageNum) {
		this.messageNum = messageNum;
	}

	public String getMessageReadCheck() {
		return messageReadCheck;
	}

	public void setMessageReadCheck(String messageReadCheck) {
		this.messageReadCheck = messageReadCheck;
	}

	public String getSenderMemberId() {
		return senderMemberId;
	}

	public void setSenderMemberId(String senderMemberId) {
		this.senderMemberId = senderMemberId;
	}

	public String getReceiverMemberId() {
		return receiverMemberId;
	}

	public void setReceiverMemberId(String receiverMemberId) {
		this.receiverMemberId = receiverMemberId;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageReceiveDate() {
		return messageReceiveDate;
	}

	public void setMessageReceiveDate(String messageReceiveDate) {
		this.messageReceiveDate = messageReceiveDate;
	}

	@Override
	public String toString() {
		return "MessageVO [senderMemberId=" + senderMemberId + ", receiverMemberId=" + receiverMemberId
				+ ", messageContent=" + messageContent + ", messageReceiveDate=" + messageReceiveDate + "]";
	}
	
	

}
