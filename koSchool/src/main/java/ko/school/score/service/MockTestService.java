package ko.school.score.service;

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

public interface MockTestService {
	//작성자 : 이재승 == 모의고사 성적조회 
	public StudentDetail selectStudentDetailService(String m_id);
	public List<MockTypeVO> studentMockTestListService(String id);
	public List<MockTestVO> selectMyKorScoreService(String id);
	public List<MockAvgScore> selectMockKorAvgScoreService(String id);
	public List<ResearchSubjectVO> selectResearchSubjectListService();
	public List<MockResearchScoreDetailList> studentMockResearchSocreListService(String id);
	public List<MockScoreDetailList> studentMockScorePlusSecondLangListService(String id);
	public List<ResearchSubjectScoreVO> koreaHistroyScoreListService(String id);
	public List<LanguageRankList> languageRankListService(HashMap<String, Object> map);
	public List<LanguageRankList> mathRankListService(HashMap<String, Object> map);
	public List<LanguageRankList> englishRankListService(HashMap<String, Object> map);
	public List<LanguageRankList> researchSubjectRankListService(HashMap<String, Object> map);
	public List<LanguageRankList> secondLanguageRankListService(HashMap<String, Object> map);
	public List<LanguageRankList> koreaHistorySubjectRankListService(HashMap<String, Object> map);
	public List<LanguageRankList> languageClassRankListService(HashMap<String, Object> map);
	public List<LanguageRankList> mathClassRankListService(HashMap<String, Object> map);
	public List<LanguageRankList> englishClassRankListService(HashMap<String, Object> map);
	public List<LanguageRankList> researchSubjectClassRankListService(HashMap<String, Object> map);
	public List<LanguageRankList> secondLanguageClassRankListService(HashMap<String, Object> map);
	public List<LanguageRankList> koreaHistorySubjectClassRankListService(HashMap<String, Object> map);
	public List<MockTestVO> selectMyMathScoreService(String studentId);
	public List<MockAvgScore> selectMockMathAvgScoreService(String studentId);
	public List<MockTestVO> selectMyEngScoreService(String studentId);
	public List<MockAvgScore> selectMockEngAvgScoreService(String studentId);
	
}
