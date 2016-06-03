package ko.school.score.domain;

public class SecondLanguageScoreVO {
	private String mockId;
    private String memberId;
    private int secondLanguageOriginalScore;
    private int secondLanguageStandardScore;
    private double secondLanguagePercentile;
    
    public SecondLanguageScoreVO() {}
    
	@Override
	public String toString() {
		return "SecondLanguageScoreVO [mockId=" + mockId + ", memberId=" + memberId + ", secondLanguageOriginalScore="
				+ secondLanguageOriginalScore + ", secondLanguageStandardScore=" + secondLanguageStandardScore
				+ ", secondLanguagePercentile=" + secondLanguagePercentile + "]";
	}

	public String getMockId() {
		return mockId;
	}
	public void setMockId(String mockId) {
		this.mockId = mockId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getSecondLanguageOriginalScore() {
		return secondLanguageOriginalScore;
	}
	public void setSecondLanguageOriginalScore(int secondLanguageOriginalScore) {
		this.secondLanguageOriginalScore = secondLanguageOriginalScore;
	}
	public int getSecondLanguageStandardScore() {
		return secondLanguageStandardScore;
	}
	public void setSecondLanguageStandardScore(int secondLanguageStandardScore) {
		this.secondLanguageStandardScore = secondLanguageStandardScore;
	}
	public double getSecondLanguagePercentile() {
		return secondLanguagePercentile;
	}
	public void setSecondLanguagePercentile(double secondLanguagePercentile) {
		this.secondLanguagePercentile = secondLanguagePercentile;
	}
	
    
}
