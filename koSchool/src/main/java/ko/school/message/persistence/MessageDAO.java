package ko.school.message.persistence;

public interface MessageDAO {
	public int countMessage(String memberId);
	
	public int notReadMessage(String memberId);
}
