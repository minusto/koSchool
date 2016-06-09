package ko.school.board.persistence;

import java.util.List;
import java.util.Map;

import ko.school.board.domain.ClassBoardVO;

public interface ClassBoardDAO {
	public void insertClassBoard(ClassBoardVO classBoardVO)throws Exception; //학급게시판 입력
	public List<ClassBoardVO> teacherClassBoardList(ClassBoardVO classBoardVO)throws Exception; //선생님학급게시판리스트 
	public List<ClassBoardVO> studentClassBoardList(ClassBoardVO classBoardVO)throws Exception; //학생학급게시판리스트
	public String teacherClass(Map<String, Object> paramMap) throws Exception;	//teacherClass (학년, 반) 구하기
}
