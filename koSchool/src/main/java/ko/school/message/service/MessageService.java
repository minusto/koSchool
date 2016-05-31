package ko.school.message.service;

public interface MessageService {
	public int countMessageService(String memberId);

	public int notReadMessageService(String memberId);
}
