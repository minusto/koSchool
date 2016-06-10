package ko.school.board.service;

import java.util.List;
import java.util.Map;

import ko.school.board.domain.ClassBoardVO;
import ko.school.board.domain.NoticeBoardVO;

public interface ClassBoardService {
	public void insertClassBoard(ClassBoardVO classBoardVO)throws Exception;
	public List<ClassBoardVO> teacherClassBoardList(ClassBoardVO classBoardVO)throws Exception;
	public List<ClassBoardVO> studentClassBoardList(ClassBoardVO classBoardVO)throws Exception;
	public String teacherClass(Map<String, Object> paramMap) throws Exception;
	public ClassBoardVO classBoardDetailService(int classBoardNum)throws Exception;
	public void classBoardUpdate(ClassBoardVO classBoardVO)throws Exception;
	public void classBoardDelete(int classBoardNum)throws Exception;
	public void classBoardHitcountService(int classBoardNum)throws Exception;
}
