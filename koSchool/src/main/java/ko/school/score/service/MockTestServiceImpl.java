package ko.school.score.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.membermanage.domain.StudentDetail;
import ko.school.score.domain.LanguageRankList;
import ko.school.score.domain.MockAvgScore;
import ko.school.score.domain.MockResearchScoreDetailList;
import ko.school.score.domain.MockScoreDetailList;
import ko.school.score.domain.MockTestVO;
import ko.school.score.domain.MockTypeVO;
import ko.school.score.domain.ResearchSubjectScoreVO;
import ko.school.score.domain.ResearchSubjectVO;
import ko.school.score.persistence.MockTestDao;

@Service
public class MockTestServiceImpl implements MockTestService {
	//작성자 : 이재승 == 모의고사 성적조회 
	@Inject
	private MockTestDao dao;

	@Override
	public StudentDetail selectStudentDetailService(String m_id) {
		return dao.selectStudentDetail(m_id);
	}

	// ---------------------성적조회
	@Override
	public List<MockTypeVO> studentMockTestListService(String id) {
		return dao.studentMockTestList(id);
	}
	@Override
	public List<MockTestVO> selectMyKorScoreService(String id) {
		return dao.selectMyKorScore(id);
	}
	@Override
	public List<MockAvgScore> selectMockKorAvgScoreService(String id) {
		return dao.selectMockKorAvgScore(id);
	}
	// ----------------------------성적조회

	// 교사 => 학생 모의고사 점수 입력 - 탐구 과목 리스트 가져오기
	@Override
	public List<ResearchSubjectVO> selectResearchSubjectListService() {
		return dao.selectResearchSubjectList();
	}
	@Override
	public List<MockResearchScoreDetailList> studentMockResearchSocreListService(String id) {
		return dao.studentMockResearchSocreList(id);
	}

	// 학생에 따라 탐구과목을 제외한 나머지 과목 점수 리스트
	@Override
	public List<MockScoreDetailList> studentMockScorePlusSecondLangListService(String id) {
		return dao.studentMockScorePlusSecondLangList(id);
	}

	// 학생에 따라 한국사 점수리스트
	@Override
	public List<ResearchSubjectScoreVO> koreaHistroyScoreListService(String id) {
		return dao.koreaHistroyScoreList(id);
	}

	
	//언어 학교석차 구하기
	@Override
	public List<LanguageRankList> languageRankListService(HashMap<String, Object> map) {
		return dao.languageRankList(map);
	}
	//수리 학교석차 구하기
	@Override
	public List<LanguageRankList> mathRankListService(HashMap<String, Object> map) {
		return dao.mathRankList(map);
	}

	//외국어 학교석차 구하기
	@Override
	public List<LanguageRankList> englishRankListService(HashMap<String, Object> map) {
		return dao.englishRankList(map);
	}

	//탐구영역 학교석차 구하기
	@Override
	public List<LanguageRankList> researchSubjectRankListService(HashMap<String, Object> map) {
		return dao.researchSubjectRankList(map);
	}

	@Override
	public List<LanguageRankList> secondLanguageRankListService(HashMap<String, Object> map) {
		return dao.secondLanguageRankList(map);
	}

	@Override
	public List<LanguageRankList> koreaHistorySubjectRankListService(HashMap<String, Object> map) {
		return dao.koreaHistorySubjectRankList(map);
	}
	
	
	//학급석차구하기 START

	@Override
	public List<LanguageRankList> languageClassRankListService(HashMap<String, Object> map) {
		return dao.languageClassRankList(map);
	}

	@Override
	public List<LanguageRankList> mathClassRankListService(HashMap<String, Object> map) {
		return dao.mathClassRankList(map);
	}

	@Override
	public List<LanguageRankList> englishClassRankListService(HashMap<String, Object> map) {
		return dao.englishClassRankList(map);
	}

	@Override
	public List<LanguageRankList> researchSubjectClassRankListService(HashMap<String, Object> map) {
		return dao.researchSubjectClassRankList(map);
	}

	@Override
	public List<LanguageRankList> secondLanguageClassRankListService(HashMap<String, Object> map) {
		return dao.secondLanguageClassRankList(map);
	}

	@Override
	public List<LanguageRankList> koreaHistorySubjectClassRankListService(HashMap<String, Object> map) {
		return dao.koreaHistorySubjectClassRankList(map);
	}

	//------------------CHART 영역-------------------------
	@Override
	public List<MockTestVO> selectMyMathScoreService(String studentId) {
		// TODO Auto-generated method stub
		return dao.selectMyMathScore(studentId);
	}

	@Override
	public List<MockAvgScore> selectMockMathAvgScoreService(String studentId) {
		// TODO Auto-generated method stub
		return dao.selectMockMathAvgScore(studentId);
	}

	@Override
	public List<MockTestVO> selectMyEngScoreService(String studentId) {
		// TODO Auto-generated method stub
		return dao.selectMyEngScore(studentId);
	}

	//학생이 치룬 모든 모의고사의 영어 평균점수 LIST
	@Override
	public List<MockAvgScore> selectMockEngAvgScoreService(String studentId) {
		// TODO Auto-generated method stub
		return dao.selectMockEngAvgScore(studentId);
	}
}
