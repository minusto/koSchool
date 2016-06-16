package ko.school.simulation.service;

import java.util.List;
import java.util.Map;

import ko.school.common.domain.StudentVO;
import ko.school.simulation.domain.SusiDetailDTO;
import ko.school.simulation.domain.SusiInfoVO;
import ko.school.simulation.domain.SusiRatingDTO;
import ko.school.simulation.domain.UniversityVO;

public interface SusiSimulationService {

	public StudentVO studentCheck(String id)throws Exception; // 학생 객체 불러오기

	public SusiRatingDTO grade1(int studentGrade, String id) throws Exception; //1학년 1,2학기 과목 등급
	public SusiRatingDTO grade2(int studentGrade, String id) throws Exception; //2학년 1,2학기 과목 등급
	public SusiRatingDTO grade3(int studentGrade, String id) throws Exception; //3학년 1,2학기 과목 등급

	public List<UniversityVO> univerSityChartList() throws Exception; // 차트에 대학교 리스트 불러오기 
	
	public List<SusiInfoVO> susiInfoList(Map<String, String> map)throws Exception; //수시 대학교 정보 목록

	public String getLocation(String universityLocal)throws Exception; //지역이름 구하기

	public double getResultScore(String uniName, double[] pointPerGrade, SusiRatingDTO first,
			SusiRatingDTO second, SusiRatingDTO third, double[] gradeReflectionRate, String reflectionSubjects)throws Exception; //수시 진단 결과
	
	public List<SusiInfoVO> selectLocationList(Map<String, String> map)throws Exception; //선택지역 대학교 정보 목록

	public double getResultAver(SusiRatingDTO first, SusiRatingDTO second, SusiRatingDTO third,
			double[] gradeReflectionRate, String reflectionSubjects); // 수시 평균 등급

	public List<SusiInfoVO> selectLocationList2(Map<String, String> map)throws Exception; //선택지역, 계열 대학교 정보 목록

	public List<SusiInfoVO> searchUniName(Map<String, String> map)throws Exception; //대학명검색 

	public SusiInfoVO susiUniversityDetail(Map<String, String> map)throws Exception;// 학과 세부정보
	public SusiDetailDTO susiDetailDTO(Map<String, String> map)throws Exception;// 반영비율정보
	
	public List<SusiInfoVO> susiRecomList(Map<String, String> map)throws Exception;//수시 추천대학
	
	
}
