package ko.school.score.persistence;

import java.util.List;
import java.util.Map;

import ko.school.membermanage.domain.StudentDetail;
import ko.school.schoolmanage.domain.TeacherDetailVO;
import ko.school.score.domain.MockTestVO;
import ko.school.score.domain.MockTypeVO;
import ko.school.score.domain.ResearchSubjectScoreVO;
import ko.school.score.domain.ResearchSubjectVO;
import ko.school.score.domain.SecondLanguageScoreVO;
import ko.school.score.domain.SecondLanguageVO;

public interface MockScoreDAO {
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 교사의 반 학생 리스트 불러오기 / 작성자 : 구혜인
	public List<StudentDetail> studentListInTeacherClass(Map<String, String> map) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 탐구 과목 리스트 불러오기 / 작성자 : 구혜인
	public List<ResearchSubjectVO> researchSubjectList() throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 제2외국어 과목 리스트 불러오기 / 작성자 : 구혜인
	public List<SecondLanguageVO> secondLanguageList() throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 모의고사 아이디 가져오기 / 작성자 : 구혜인
	public String selectMockId(MockTypeVO mockTypeVo) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 탐구 과목 아이디 가져오기 / 작성자 : 구혜인
	public String selectResearchSubjectId(String researchSubjectName) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 제2외국어 과목 아이디 가져오기 / 작성자 : 구혜인
	public String selectSecondLanguageId(String LanguageSubjectName) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 입력되었던 모의고사인지 확인 / 작성자 : 구혜인
	public MockTestVO checkMockTestInsertedScore(MockTestVO mockTestVo) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - MockTest - 1학년 / 작성자 : 구혜인
	public void insertMockTestScoreGrade1(MockTestVO mockTestVo) throws Exception;

	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - MockTest - 2학년 / 작성자 : 구혜인
	public void insertMockTestScoreGrade2(MockTestVO mockTestVo) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - MockTest - 3학년 / 작성자 : 구혜인
	public void insertMockTestScoreGrade3(MockTestVO mockTestVo) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - SecondLanguage / 작성자 : 구혜인
	public void insertSecondLanguageScore(SecondLanguageScoreVO secondLanguageScoreVo) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - ResearchSubject / 작성자 : 구혜인
	public void insertResearchSubjectScore(ResearchSubjectScoreVO researchSubjectScoreVo) throws Exception;
	
	
	
}
