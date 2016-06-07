package ko.school.score.persistence;

import java.util.HashMap;
import java.util.List;

import ko.school.membermanage.domain.StudentDetail;
import ko.school.score.domain.LanguageRankList;
import ko.school.score.domain.MockAvgScore;
import ko.school.score.domain.MockResearchScoreDetailList;
import ko.school.score.domain.MockScoreDetailList;
import ko.school.score.domain.MockTestVO;
import ko.school.score.domain.MockTypeVO;
import ko.school.score.domain.ResearchSubjectScoreVO;
import ko.school.score.domain.ResearchSubjectVO;

public interface MockTestDao {
	//작성자 : 이재승 == 모의고사 성적조회 
	public StudentDetail selectStudentDetail(String m_id);
	public List<MockTypeVO> studentMockTestList(String id);
	public List<MockTestVO> selectMyKorScore(String id);
	public List<MockAvgScore> selectMockKorAvgScore(String id);
	public List<ResearchSubjectVO> selectResearchSubjectList();
	public List<MockResearchScoreDetailList> studentMockResearchSocreList(String id);
	public List<MockScoreDetailList> studentMockScorePlusSecondLangList(String id);
	public List<ResearchSubjectScoreVO> koreaHistroyScoreList(String id);
	public List<LanguageRankList> languageRankList(HashMap<String, Object> map);
	public List<LanguageRankList> mathRankList(HashMap<String, Object> map);
	public List<LanguageRankList> englishRankList(HashMap<String, Object> map);
	public List<LanguageRankList> researchSubjectRankList(HashMap<String, Object> map);
	public List<LanguageRankList> secondLanguageRankList(HashMap<String, Object> map);
	public List<LanguageRankList> koreaHistorySubjectRankList(HashMap<String, Object> map);
	public List<LanguageRankList> languageClassRankList(HashMap<String, Object> map);
	public List<LanguageRankList> mathClassRankList(HashMap<String, Object> map);
	public List<LanguageRankList> englishClassRankList(HashMap<String, Object> map);
	public List<LanguageRankList> researchSubjectClassRankList(HashMap<String, Object> map);
	public List<LanguageRankList> secondLanguageClassRankList(HashMap<String, Object> map);
	public List<LanguageRankList> koreaHistorySubjectClassRankList(HashMap<String, Object> map);
	public List<MockTestVO> selectMyMathScore(String studentId);
	public List<MockAvgScore> selectMockMathAvgScore(String studentId);
	public List<MockTestVO> selectMyEngScore(String studentId);
	public List<MockAvgScore> selectMockEngAvgScore(String studentId);
	

}
