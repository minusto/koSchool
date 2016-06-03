package ko.school.score.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.membermanage.domain.StudentDetail;
import ko.school.schoolmanage.domain.TeacherDetailVO;
import ko.school.score.domain.MockTestVO;
import ko.school.score.domain.MockTypeVO;
import ko.school.score.domain.ResearchSubjectScoreVO;
import ko.school.score.domain.ResearchSubjectVO;
import ko.school.score.domain.SecondLanguageScoreVO;
import ko.school.score.domain.SecondLanguageVO;

@Repository
public class MockScoreDAOImpl implements MockScoreDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "ko.school.mapper.MockScoreMapper";

	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 교사의 반 학생 리스트 불러오기 / 작성자 : 구혜인
	@Override
	public List<StudentDetail> studentListInTeacherClass(TeacherDetailVO teacherDetailVo) throws Exception {
		return session.selectList(namespace + ".studentListInTeacherClass", teacherDetailVo);
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 탐구 과목 리스트 불러오기 / 작성자 : 구혜인
	@Override
	public List<ResearchSubjectVO> researchSubjectList() throws Exception {
		return session.selectList(namespace + ".researchSubjectList");
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 제2외국어 과목 리스트 불러오기 / 작성자 : 구혜인
	@Override
	public List<SecondLanguageVO> secondLanguageList() throws Exception {
		return session.selectList(namespace + ".secondLanguageList");
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 모의고사 아이디 가져오기 / 작성자 : 구혜인
	@Override
	public String selectMockId(MockTypeVO mockTypeVo) throws Exception {
		return session.selectOne(namespace + ".selectMockId", mockTypeVo);
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 탐구 과목 아이디 가져오기 / 작성자 : 구혜인
	@Override
	public String selectResearchSubjectId(String researchSubjectName) throws Exception {
		return session.selectOne(namespace + ".selectResearchSubjectId", researchSubjectName);
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 제2외국어 과목 아이디 가져오기 / 작성자 : 구혜인
	@Override
	public String selectSecondLanguageId(String LanguageSubjectName) throws Exception {
		return session.selectOne(namespace + ".selectSecondLanguageId", LanguageSubjectName);
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 - 입력되었던 모의고사인지 확인 / 작성자 : 구혜인
	@Override
	public MockTestVO checkMockTestInsertedScore(MockTestVO mockTestVo) throws Exception {
		return session.selectOne(namespace + ".checkMockTestInsertedScore", mockTestVo);
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - MockTest - 1학년 / 작성자 : 구혜인
	@Override
	public void insertMockTestScoreGrade1(MockTestVO mockTestVo) throws Exception {
		session.insert(namespace + ".insertMockTestScoreGrade1", mockTestVo);
	}

	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - MockTest - 2학년 / 작성자 : 구혜인
	@Override
	public void insertMockTestScoreGrade2(MockTestVO mockTestVo) throws Exception {
		session.insert(namespace + ".insertMockTestScoreGrade2", mockTestVo);
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - MockTest - 3학년 / 작성자 : 구혜인
	@Override
	public void insertMockTestScoreGrade3(MockTestVO mockTestVo) throws Exception {
		session.insert(namespace + ".insertMockTestScoreGrade3", mockTestVo);
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - SecondLanguage / 작성자 : 구혜인
	@Override
	public void insertSecondLanguageScore(SecondLanguageScoreVO secondLanguageScoreVo) throws Exception {
		session.insert(namespace + ".insertSecondLanguageScore", secondLanguageScoreVo);
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 등록 - ResearchSubject / 작성자 : 구혜인
	@Override
	public void insertResearchSubjectScore(ResearchSubjectScoreVO researchSubjectScoreVo) throws Exception {
		session.insert(namespace + ".insertResearchSubjectScore", researchSubjectScoreVo);
	}


	
}
