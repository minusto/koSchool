package ko.school.message.persistence;

import java.util.List;

import ko.school.message.domain.MessageVO;

public interface MessageDAO {
	public int countMessage(String memberId);
	
	public int notReadMessage(String memberId);
	
	
	
	
	
	public void sendMessage(MessageVO message);
	
	public List<MessageVO> listSendMessage(String memberId);
	public List<MessageVO> listReceiveMessage(String memberId);
	public MessageVO sendMessageRead(int messageNum);
	public void changeReadCheck(int messageNum);
	
}
