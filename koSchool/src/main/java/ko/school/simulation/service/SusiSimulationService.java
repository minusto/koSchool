package ko.school.simulation.service;

import java.util.List;
import java.util.Map;

import ko.school.common.domain.StudentVO;
import ko.school.simulation.domain.SusiInfoVO;
import ko.school.simulation.domain.SusiRatingDTO;
import ko.school.simulation.domain.UniversityVO;

public interface SusiSimulationService {

	public StudentVO studentCheck(String id)throws Exception; // 학생 객체 불러오기

	public SusiRatingDTO grade1(int studentGrade, String id) throws Exception; //1학년 1,2학기 과목 등급
	public SusiRatingDTO grade2(int studentGrade, String id) throws Exception; //2학년 1,2학기 과목 등급
	public SusiRatingDTO grade3(int studentGrade, String id) throws Exception; //3학년 1,2학기 과목 등급

	/*public List<UniversityVO> univerSityChartList() throws Exception; // 차트에 대학교 리스트 불러오기 
*/	
	public List<SusiInfoVO> susiInfoList(Map<String, String> map)throws Exception; //수시 대학교 정보 목록

	public String getLocation(String universityLocal)throws Exception; //지역이름 구하기

	public double getResultScore(String uniName, double[] pointPerGrade, SusiRatingDTO first,
			SusiRatingDTO second, SusiRatingDTO third, double[] gradeReflectionRate, String reflectionSubjects)throws Exception; //수시 진단 결과
	
	
	
}
