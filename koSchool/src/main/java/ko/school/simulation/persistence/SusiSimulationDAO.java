package ko.school.simulation.persistence;

import java.util.List;
import java.util.Map;

import ko.school.common.domain.StudentVO;
import ko.school.score.domain.AllRankingScoreList;
import ko.school.score.domain.AllStudentNum;
import ko.school.simulation.domain.SusiSubjectDTO;

public interface SusiSimulationDAO {
	
	
	public StudentVO studentCheck(String id)throws Exception; // 학생 객체 불러오기
	public List<AllRankingScoreList> allRankingScoreList(Map<String, Object> map)throws Exception;  //전체 과목별 등수
	public List<AllStudentNum> allStudentNum(Map<String, Object> map)throws Exception; //전체 과목별 전체명수 
	public List<SusiSubjectDTO> susiSubject(Map<String, Object> map)throws Exception; //해당 학생의 과목아이디와 교과
}
