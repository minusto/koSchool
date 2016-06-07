package ko.school.score.domain;

public class MockResearchScoreDetailList{
	//작성자 : 이재승 == 탐구과목 성적 뽑기
	
	private String memberId;
	private String mockId;
	private String researchSubjectId1;
	private int researchSubjectOriginalScore1;
	private int researchSubjectStandardScore1;
	private double researchSubjectPercentile1;
	private String researchSubjectId2;
	private int researchSubjectOriginalScore2;
	private int researchSubjectStandardScore2;
	private double researchSubjectPercentile2;
	
	public MockResearchScoreDetailList(){}

	public MockResearchScoreDetailList(String memberId, String mockId, String researchSubjectId1,
			int researchSubjectOriginalScore1, int researchSubjectStandardScore1, double researchSubjectPercentile1,
			String researchSubjectId2, int researchSubjectOriginalScore2, int researchSubjectStandardScore2,
			double researchSubjectPercentile2) {
		super();
		this.memberId = memberId;
		this.mockId = mockId;
		this.researchSubjectId1 = researchSubjectId1;
		this.researchSubjectOriginalScore1 = researchSubjectOriginalScore1;
		this.researchSubjectStandardScore1 = researchSubjectStandardScore1;
		this.researchSubjectPercentile1 = researchSubjectPercentile1;
		this.researchSubjectId2 = researchSubjectId2;
		this.researchSubjectOriginalScore2 = researchSubjectOriginalScore2;
		this.researchSubjectStandardScore2 = researchSubjectStandardScore2;
		this.researchSubjectPercentile2 = researchSubjectPercentile2;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMockId() {
		return mockId;
	}

	public void setMockId(String mockId) {
		this.mockId = mockId;
	}

	public String getResearchSubjectId1() {
		return researchSubjectId1;
	}

	public void setResearchSubjectId1(String researchSubjectId1) {
		this.researchSubjectId1 = researchSubjectId1;
	}

	public int getResearchSubjectOriginalScore1() {
		return researchSubjectOriginalScore1;
	}

	public void setResearchSubjectOriginalScore1(int researchSubjectOriginalScore1) {
		this.researchSubjectOriginalScore1 = researchSubjectOriginalScore1;
	}

	public int getResearchSubjectStandardScore1() {
		return researchSubjectStandardScore1;
	}

	public void setResearchSubjectStandardScore1(int researchSubjectStandardScore1) {
		this.researchSubjectStandardScore1 = researchSubjectStandardScore1;
	}

	public double getResearchSubjectPercentile1() {
		return researchSubjectPercentile1;
	}

	public void setResearchSubjectPercentile1(double researchSubjectPercentile1) {
		this.researchSubjectPercentile1 = researchSubjectPercentile1;
	}

	public String getResearchSubjectId2() {
		return researchSubjectId2;
	}

	public void setResearchSubjectId2(String researchSubjectId2) {
		this.researchSubjectId2 = researchSubjectId2;
	}

	public int getResearchSubjectOriginalScore2() {
		return researchSubjectOriginalScore2;
	}

	public void setResearchSubjectOriginalScore2(int researchSubjectOriginalScore2) {
		this.researchSubjectOriginalScore2 = researchSubjectOriginalScore2;
	}

	public int getResearchSubjectStandardScore2() {
		return researchSubjectStandardScore2;
	}

	public void setResearchSubjectStandardScore2(int researchSubjectStandardScore2) {
		this.researchSubjectStandardScore2 = researchSubjectStandardScore2;
	}

	public double getResearchSubjectPercentile2() {
		return researchSubjectPercentile2;
	}

	public void setResearchSubjectPercentile2(double researchSubjectPercentile2) {
		this.researchSubjectPercentile2 = researchSubjectPercentile2;
	}

	
	

}
