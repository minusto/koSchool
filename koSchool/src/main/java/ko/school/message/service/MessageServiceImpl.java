package ko.school.message.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.message.domain.MessageVO;
import ko.school.message.persistence.MessageDAO;

@Service
public class MessageServiceImpl implements MessageService {

	@Inject
	private MessageDAO dao;
	
	@Override
	public int countMessageService(String memberId) {
		return dao.countMessage(memberId);
	}

	@Override
	public int notReadMessageService(String memberId) {
		return dao.notReadMessage(memberId);
	}

	@Override
	public void sendMessageSevice(MessageVO message) {
		dao.sendMessage(message);		
	}

	@Override
	public List<MessageVO> listSendMessageService(String memberId) {
		return dao.listSendMessage(memberId);
	}

	@Override
	public List<MessageVO> listReceiveMessageService(String memberId) {
		return dao.listReceiveMessage(memberId);
	}

	@Override
	public MessageVO sendMessageReadService(int messageNum) {
		return dao.sendMessageRead(messageNum);
	}

	@Override
	public void changeReadCheckService(int messageNum) {
		dao.changeReadCheck(messageNum);
		
	}

}
