package ko.school.simulation.persistence;

import java.util.List;
import java.util.Map;

import ko.school.common.domain.StudentVO;
import ko.school.score.domain.AllRankingScoreList;
import ko.school.score.domain.AllStudentNum;
import ko.school.score.domain.Subject;
import ko.school.simulation.domain.SusiDetailDTO;
import ko.school.simulation.domain.SusiInfoVO;
import ko.school.simulation.domain.SusiSubjectDTO;
import ko.school.simulation.domain.UniversityVO;

public interface SusiSimulationDAO {
	
	
	public StudentVO studentCheck(String id)throws Exception; // 학생 객체 불러오기
	public List<AllRankingScoreList> allRankingScoreList(Map<String, Object> map)throws Exception;  //전체 과목별 등수
	public List<AllStudentNum> allStudentNum(Map<String, Object> map)throws Exception; //전체 과목별 전체명수 
	public List<SusiSubjectDTO> susiSubject(Map<String, Object> map)throws Exception; //해당 학생의 과목아이디와 교과
	public List<UniversityVO> univerSityChartList()throws Exception; //차트에서 대학교 리스트 불러오기

	public List<SusiInfoVO> susiInfoList(Map<String, String> map)throws Exception; //수시 대학교 정보 목록
	public Subject selectSubject(String id)throws Exception;//과목
	
	public List<SusiInfoVO> selectLocationList(Map<String, String> map)throws Exception; //선택지역 대학교 정보 목록
	public List<SusiInfoVO> selectLocationList2(Map<String, String> map)throws Exception; //선택지역, 계열 대학교 정보 목록

	public List<SusiInfoVO> searchUniName(Map<String, String> map)throws Exception; //대학명검색 
	public SusiInfoVO susiUniversityDetail(Map<String, String> map)throws Exception;// 학과 세부정보
	public SusiDetailDTO susiDetailDTO(Map<String, String> map)throws Exception;// 반영비율정보
	public List<SusiInfoVO> susiRecomList(Map<String, String> map)throws Exception; //수시 대학교 정보 목록
}
