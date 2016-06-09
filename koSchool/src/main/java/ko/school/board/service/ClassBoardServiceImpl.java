package ko.school.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.board.domain.ClassBoardVO;
import ko.school.board.persistence.ClassBoardDAO;

@Service
public class ClassBoardServiceImpl implements ClassBoardService {

	@Inject
	private ClassBoardDAO dao;
	
	
	@Override
	public void insertClassBoard(ClassBoardVO classBoardVO) throws Exception {
		dao.insertClassBoard(classBoardVO);
	}

	@Override
	public List<ClassBoardVO> teacherClassBoardList(ClassBoardVO classBoardVO) throws Exception {
		return dao.teacherClassBoardList(classBoardVO);
		
	}

	@Override
	public List<ClassBoardVO> studentClassBoardList(ClassBoardVO classBoardVO) throws Exception {
		return dao.studentClassBoardList(classBoardVO);
	}

	@Override
	public String teacherClass(Map<String, Object> paramMap) throws Exception {
		return dao.teacherClass(paramMap);
	}
}
