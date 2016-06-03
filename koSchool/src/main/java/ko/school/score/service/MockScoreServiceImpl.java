package ko.school.score.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.membermanage.domain.StudentDetail;
import ko.school.schoolmanage.domain.TeacherDetailVO;
import ko.school.score.domain.MockTestVO;
import ko.school.score.domain.MockTypeVO;
import ko.school.score.domain.ResearchSubjectPackage;
import ko.school.score.domain.ResearchSubjectScoreVO;
import ko.school.score.domain.ResearchSubjectVO;
import ko.school.score.domain.SecondLanguageScoreVO;
import ko.school.score.domain.SecondLanguageVO;
import ko.school.score.persistence.MockScoreDAO;

@Service
public class MockScoreServiceImpl implements MockScoreService {
	
	@Inject
	private MockScoreDAO dao;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 교사의 반 학생 리스트 불러오기 / 작성자 : 구혜인
	@Override
	public List<StudentDetail> studentListInTeacherClassService(TeacherDetailVO teacherDetailVo) throws Exception {
		return dao.studentListInTeacherClass(teacherDetailVo);
	}

	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 탐구 과목 리스트 불러오기 / 작성자 : 구혜인
	@Override
	public List<ResearchSubjectVO> researchSubjectListService() throws Exception {
		return dao.researchSubjectList();
	}

	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 제2외국어 과목 리스트 불러오기 / 작성자 : 구혜인
	@Override
	public List<SecondLanguageVO> secondLanguageListService() throws Exception {
		return dao.secondLanguageList();
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 모의고사 아이디 가져오기 / 작성자 : 구혜인
	@Override
	public String selectMockIdService(MockTypeVO mockTypeVo) throws Exception {
		return dao.selectMockId(mockTypeVo);
	}

	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 탐구 과목 아이디 가져오기 / 작성자 : 구혜인
	@Override
	public String selectResearchSubjectIdService(String researchSubjectName) throws Exception {
		return dao.selectResearchSubjectId(researchSubjectName);
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 제2외국어 과목 아이디 가져오기 / 작성자 : 구혜인
	@Override
	public String selectSecondLanguageIdService(String LanguageSubjectName) throws Exception {
		return dao.selectSecondLanguageId(LanguageSubjectName);
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 입력되었던 모의고사인지 확인 / 작성자 : 구혜인
	@Override
	public MockTestVO checkMockTestInsertedScoreService(MockTestVO mockTestVo) throws Exception {
		return dao.checkMockTestInsertedScore(mockTestVo);
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - MockTest - 1학년 / 작성자 : 구혜인
	@Override
	public void insertMockTestScoreGrade1Service(MockTestVO mockTestVo) throws Exception {
		dao.insertMockTestScoreGrade1(mockTestVo);
	}

	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - MockTest - 2학년 / 작성자 : 구혜인
	@Override
	public void insertMockTestScoreGrade2Service(MockTestVO mockTestVo) throws Exception {
		dao.insertMockTestScoreGrade2(mockTestVo);
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - MockTest - 3학년 / 작성자 : 구혜인
	@Override
	public void insertMockTestScoreGrade3Service(MockTestVO mockTestVo) throws Exception {
		dao.insertMockTestScoreGrade3(mockTestVo);
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - SecondLanguage / 작성자 : 구혜인
	@Override
	public void insertSecondLanguageScoreService(SecondLanguageScoreVO secondLanguageScoreVo) throws Exception {
		dao.insertSecondLanguageScore(secondLanguageScoreVo);
	}

	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - ResearchSubject / 작성자 : 구혜인
	@Override
	public void insertResearchSubjectScoreService(ResearchSubjectPackage researchSubjectPackage,
			MockTestVO mockTestVo) throws Exception {
		String mockId = mockTestVo.getMockId();
		String memberId = mockTestVo.getMemberId();
		
		ResearchSubjectScoreVO rScore0 = null;
		ResearchSubjectScoreVO rScore1 = new ResearchSubjectScoreVO();
		ResearchSubjectScoreVO rScore2 = new ResearchSubjectScoreVO();
		
		String researchId1 = dao.selectResearchSubjectId(researchSubjectPackage.getResearchSubjectName1());
		String researchId2 = dao.selectResearchSubjectId(researchSubjectPackage.getResearchSubjectName2());
		
		rScore1.setMockId(mockId); //탐구 객체에 각각 내용을 집어넣기
		rScore1.setMemberId(memberId);
		rScore1.setResearchSubjectId(researchId1);
		rScore1.setResearchSubjectOriginalScore(researchSubjectPackage.getResearchSubjectOriginalScore1());
		rScore1.setResearchSubjectStandardScore(researchSubjectPackage.getResearchSubjectStandardScore1());
		rScore1.setResearchSubjectPercentile(researchSubjectPackage.getResearchSubjectPercentile1());
		
		rScore2.setMockId(mockId);
		rScore2.setMemberId(memberId);
		rScore2.setResearchSubjectId(researchId2);
		rScore2.setResearchSubjectOriginalScore(researchSubjectPackage.getResearchSubjectOriginalScore2());
		rScore2.setResearchSubjectStandardScore(researchSubjectPackage.getResearchSubjectStandardScore2());
		rScore2.setResearchSubjectPercentile(researchSubjectPackage.getResearchSubjectPercentile2());
		
		dao.insertResearchSubjectScore(rScore1);
		dao.insertResearchSubjectScore(rScore2);
		
		if(researchSubjectPackage.getResearchSubjectOriginalScore0() > 0) {
			rScore0 = new ResearchSubjectScoreVO();
			String researchId0 = dao.selectResearchSubjectId(researchSubjectPackage.getResearchSubjectName0());
			rScore0.setMockId(mockId);
			rScore0.setMemberId(memberId);
			rScore0.setResearchSubjectId(researchId0);
			rScore0.setResearchSubjectOriginalScore(researchSubjectPackage.getResearchSubjectOriginalScore0());
			rScore0.setResearchSubjectStandardScore(researchSubjectPackage.getResearchSubjectStandardScore0());
			rScore0.setResearchSubjectPercentile(researchSubjectPackage.getResearchSubjectPercentile0());
			
			dao.insertResearchSubjectScore(rScore0);
		}
	}

	
	
	
	
	
	
}
