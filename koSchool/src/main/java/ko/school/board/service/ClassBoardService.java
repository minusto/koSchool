package ko.school.board.service;

import java.util.List;
import java.util.Map;

import ko.school.board.domain.ClassBoardVO;

public interface ClassBoardService {
	public void insertClassBoard(ClassBoardVO classBoardVO)throws Exception;
	public List<ClassBoardVO> teacherClassBoardList(ClassBoardVO classBoardVO)throws Exception;
	public List<ClassBoardVO> studentClassBoardList(ClassBoardVO classBoardVO)throws Exception;
	public String teacherClass(Map<String, Object> paramMap) throws Exception;
}
