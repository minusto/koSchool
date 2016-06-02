package ko.school.message.persistence;

import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.message.domain.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {

	
	@Inject
	private SqlSession session;
	
	private static String namespace = "ko.school.mapper.MessageCountMapper";
	
	@Override
	public int countMessage(String memberId) {
		return session.selectOne(namespace+".countMessage", memberId);
	}

	@Override
	public int notReadMessage(String memberId) {
		return session.selectOne(namespace + ".notReadMessage", memberId);
	}

	@Override
	public void sendMessage(MessageVO message) {
		session.insert(namespace + ".sendMessage", message);
	}

	@Override
	public List<MessageVO> listSendMessage(String memberId) {
		return session.selectList(namespace+ ".listSendMessage", memberId);
	}
	
	@Override
	public List<MessageVO> listReceiveMessage(String memberId) {
		return session.selectList(namespace+ ".listReceiveMessage", memberId);
	}

	@Override
	public MessageVO sendMessageRead(int messageNum) {
		return session.selectOne(namespace + ".sendMessageRead", messageNum);
	}

	@Override
	public void changeReadCheck(int messageNum) {
		session.update(namespace + ".changeReadCheck", messageNum);
		
	}


}
