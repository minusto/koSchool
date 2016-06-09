package ko.school.board.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.board.domain.ClassBoardVO;

@Repository
public class ClassBoardDAOImpl implements ClassBoardDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "ko.school.mapper.classBoardMapper";

	@Override
	public void insertClassBoard(ClassBoardVO classBoardVO) throws Exception {
		 session.insert(namespace + ".insertClassBoard", classBoardVO);
	}

	@Override
	public List<ClassBoardVO> teacherClassBoardList(ClassBoardVO classBoardVO) throws Exception {
		return session.selectList(namespace + ".teacherClassBoardList", classBoardVO);
	}

	@Override
	public List<ClassBoardVO> studentClassBoardList(ClassBoardVO classBoardVO) throws Exception {
		return session.selectList(namespace + ".studentClassBoardList" , classBoardVO);
	}

	@Override
	public String teacherClass(Map<String, Object> paramMap) throws Exception {
		return session.selectOne(namespace + ".teacherClass" , paramMap);
	}

	@Override
	public ClassBoardVO classBoardDetailService(int classBoardNum) {
		return session.selectOne(namespace + ".classBoardDetail" , classBoardNum);
	}

	@Override
	public void classBoardUpdate(ClassBoardVO classBoardVO) throws Exception {
		session.update(namespace + ".classBoardUpdate" , classBoardVO);	
	}

	@Override
	public void classBoardDelete(int classBoardNum) throws Exception {
		session.delete(namespace + ".classBoardDelete" , classBoardNum);
	}
}
