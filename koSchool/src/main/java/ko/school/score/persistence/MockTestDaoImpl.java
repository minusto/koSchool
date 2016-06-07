package ko.school.score.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.membermanage.domain.StudentDetail;
import ko.school.score.domain.LanguageRankList;
import ko.school.score.domain.MockAvgScore;
import ko.school.score.domain.MockResearchScoreDetailList;
import ko.school.score.domain.MockScoreDetailList;
import ko.school.score.domain.MockTestVO;
import ko.school.score.domain.MockTypeVO;
import ko.school.score.domain.ResearchSubjectScoreVO;
import ko.school.score.domain.ResearchSubjectVO;

@Repository
public class MockTestDaoImpl implements MockTestDao {
	//작성자 : 이재승 == 모의고사 성적조회 
	@Inject
	private SqlSession session;
	
	private static String namespace="ko.school.mapper.MockTestMapper";

	@Override
	public StudentDetail selectStudentDetail(String m_id) {
		return session.selectOne(namespace+".selectStudentDetail", m_id);
	}

	@Override
	public List<MockTypeVO> studentMockTestList(String id) {
		return session.selectList(namespace+".studentMockTestList", id);
	}

	@Override
	public List<MockTestVO> selectMyKorScore(String id) {
		return session.selectList(namespace+".selectMyKorScore", id);
	}

	@Override
	public List<MockAvgScore> selectMockKorAvgScore(String id) {
		return session.selectList(namespace+".selectMockKorAvgScore", id);
	}

	@Override
	public List<ResearchSubjectVO> selectResearchSubjectList() {
		return session.selectList(namespace+".selectResearchSubjectList");
	}

	@Override
	public List<MockResearchScoreDetailList> studentMockResearchSocreList(String id) {
		return session.selectList(namespace+".studentMockResearchSocreList",id);
	}

	@Override
	public List<MockScoreDetailList> studentMockScorePlusSecondLangList(String id) {
		return session.selectList(namespace+".studentMockScorePlusSecondLangList", id);
	}

	@Override
	public List<ResearchSubjectScoreVO> koreaHistroyScoreList(String id) {
		return session.selectList(namespace+".koreaHistroyScoreList", id);
	}

	
	//언어 표준점수를 가지고 학교석차리스트 불러옴
	@Override
	public List<LanguageRankList> languageRankList(HashMap<String, Object> map) {

		return session.selectList(namespace+".languageRankList",map);
	}
	
	//수리 표점가지고 학교석차리스르 구하기
	@Override
	public List<LanguageRankList> mathRankList(HashMap<String, Object> map) {
		return session.selectList(namespace+".mathRankList",map);
	}

	@Override
	public List<LanguageRankList> englishRankList(HashMap<String, Object> map) {
		return session.selectList(namespace+".englishRankList",map);
	}

	@Override
	public List<LanguageRankList> researchSubjectRankList(HashMap<String, Object> map) {
		return session.selectList(namespace+".researchSubjectRankList",map);
	}

	@Override
	public List<LanguageRankList> secondLanguageRankList(HashMap<String, Object> map) {
		return session.selectList(namespace+".secondLanguageRankList",map);
	}

	@Override
	public List<LanguageRankList> koreaHistorySubjectRankList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".koreaHistorySubjectRankList",map);
	}

	//과목별 학급석차 구하기 START
	//언어영역 학급석차
	@Override
	public List<LanguageRankList> languageClassRankList(HashMap<String, Object> map) {
		return session.selectList(namespace+".languageClassRankList",map);
	}
	
	//수리영역 학급석차
	@Override
	public List<LanguageRankList> mathClassRankList(HashMap<String, Object> map) {
		return session.selectList(namespace+".mathClassRankList",map);
	}

	//외국어영역 학급석차
	@Override
	public List<LanguageRankList> englishClassRankList(HashMap<String, Object> map) {
		return session.selectList(namespace+".englishClassRankList",map);
	}

	
	//탐구영역  학급석차
	@Override
	public List<LanguageRankList> researchSubjectClassRankList(HashMap<String, Object> map) {
		return session.selectList(namespace+".researchSubjectClassRankList",map);
	}
	
	//제2외국어 학급석차
	@Override
	public List<LanguageRankList> secondLanguageClassRankList(HashMap<String, Object> map) {
		return session.selectList(namespace+".secondLanguageClassRankList",map);
	}

	//한국사 학급석차
	@Override
	public List<LanguageRankList> koreaHistorySubjectClassRankList(HashMap<String, Object> map) {
		return session.selectList(namespace+".koreaHistorySubjectClassRankList",map);
	}

	//모의고사 CHART 영역----------
	@Override
	public List<MockTestVO> selectMyMathScore(String studentId) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectMyMathScore",studentId);
	}

	@Override
	public List<MockAvgScore> selectMockMathAvgScore(String studentId) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectMockMathAvgScore",studentId);
	}

	@Override
	public List<MockTestVO> selectMyEngScore(String studentId) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectMyEngScore",studentId);
	}

	@Override
	public List<MockAvgScore> selectMockEngAvgScore(String studentId) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".selectMockEngAvgScore",studentId);
	}
	

	
}
