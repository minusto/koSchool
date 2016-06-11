package ko.school.simulation.service;

import ko.school.common.domain.StudentVO;
import ko.school.simulation.domain.SusiRatingDTO;

public interface SusiSimulationService {

	public StudentVO studentCheck(String id)throws Exception; // 학생 객체 불러오기

	public SusiRatingDTO grade1(int studentGrade, String id) throws Exception; //1학년 1,2학기 과목 등급
	public SusiRatingDTO grade2(int studentGrade, String id) throws Exception; //2학년 1,2학기 과목 등급
	public SusiRatingDTO grade3(int studentGrade, String id) throws Exception; //3학년 1,2학기 과목 등급
	
	
	
	
	
}
