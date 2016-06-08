package ko.school.score.domain;

public class MockAvgScore{
	//작성자 :이재승 == 모든과목 평균
	
	private String mockId;
	private double avg;
	
	public MockAvgScore(){}
	
	public MockAvgScore(String mockId, double avg) {
		super();
		this.mockId = mockId;
		this.avg = avg;
	}
	public String getMockId() {
		return mockId;
	}
	public void setMockId(String mockId) {
		this.mockId = mockId;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
}
