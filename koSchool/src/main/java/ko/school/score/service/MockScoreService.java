package ko.school.score.service;

import java.util.List;

import ko.school.membermanage.domain.StudentDetail;
import ko.school.schoolmanage.domain.TeacherDetailVO;
import ko.school.score.domain.MockTestVO;
import ko.school.score.domain.MockTypeVO;
import ko.school.score.domain.ResearchSubjectPackage;
import ko.school.score.domain.ResearchSubjectVO;
import ko.school.score.domain.SecondLanguageScoreVO;
import ko.school.score.domain.SecondLanguageVO;

public interface MockScoreService {
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 교사의 반 학생 리스트 불러오기 / 작성자 : 구혜인
	public List<StudentDetail> studentListInTeacherClassService(TeacherDetailVO teacherDetailVo) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 탐구 과목 리스트 불러오기 / 작성자 : 구혜인
	public List<ResearchSubjectVO> researchSubjectListService() throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 제2외국어 과목 리스트 불러오기 / 작성자 : 구혜인
	public List<SecondLanguageVO> secondLanguageListService() throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 모의고사 아이디 가져오기 / 작성자 : 구혜인
	public String selectMockIdService(MockTypeVO mockTypeVo) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 탐구 과목 아이디 가져오기 / 작성자 : 구혜인
	public String selectResearchSubjectIdService(String researchSubjectName) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 제2외국어 과목 아이디 가져오기 / 작성자 : 구혜인
	public String selectSecondLanguageIdService(String LanguageSubjectName) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 입력되었던 모의고사인지 확인 / 작성자 : 구혜인
	public MockTestVO checkMockTestInsertedScoreService(MockTestVO mockTestVo) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - MockTest - 1학년 / 작성자 : 구혜인
	public void insertMockTestScoreGrade1Service(MockTestVO mockTestVo) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - MockTest - 2학년 / 작성자 : 구혜인
	public void insertMockTestScoreGrade2Service(MockTestVO mockTestVo) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - MockTest - 3학년 / 작성자 : 구혜인
	public void insertMockTestScoreGrade3Service(MockTestVO mockTestVo) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - SecondLanguage / 작성자 : 구혜인
	public void insertSecondLanguageScoreService(SecondLanguageScoreVO secondLanguageScoreVo) throws Exception;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - ResearchSubject / 작성자 : 구혜인
	public void insertResearchSubjectScoreService(ResearchSubjectPackage researchSubjectPackage, MockTestVO mockTestVo) throws Exception;
	
}
