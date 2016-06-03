package ko.school.score.domain;

public class MockTypeVO {
	private String mockId;
    private int mockYear;
    private int mockMonth;
    private int mockGrade;
    
    public MockTypeVO() {}
    
	@Override
	public String toString() {
		return "MockTypeVO [mockId=" + mockId + ", mockYear=" + mockYear + ", mockMonth=" + mockMonth + ", mockGrade="
				+ mockGrade + "]";
	}

	public String getMockId() {
		return mockId;
	}
	public void setMockId(String mockId) {
		this.mockId = mockId;
	}
	public int getMockYear() {
		return mockYear;
	}
	public void setMockYear(int mockYear) {
		this.mockYear = mockYear;
	}
	public int getMockMonth() {
		return mockMonth;
	}
	public void setMockMonth(int mockMonth) {
		this.mockMonth = mockMonth;
	}
	public int getMockGrade() {
		return mockGrade;
	}
	public void setMockGrade(int mockGrade) {
		this.mockGrade = mockGrade;
	}
    
}
