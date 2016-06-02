package ko.school.message.service;

import java.util.List;

import ko.school.message.domain.MessageVO;

public interface MessageService {
	public int countMessageService(String memberId);

	public int notReadMessageService(String memberId);
	
	
	
	public void sendMessageSevice(MessageVO message);	
	public List<MessageVO> listSendMessageService(String memberId);
	public List<MessageVO> listReceiveMessageService(String memberId);
	public MessageVO sendMessageReadService(int messageNum);
	public void changeReadCheckService(int messageNum);
}
