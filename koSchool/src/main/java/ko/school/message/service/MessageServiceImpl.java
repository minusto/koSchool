package ko.school.message.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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

}
