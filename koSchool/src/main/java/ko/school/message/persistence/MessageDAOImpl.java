package ko.school.message.persistence;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

}
