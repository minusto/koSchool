package ko.school.score.domain;

public class MockScoreDetailList {
	//작성자 : 이재승 == 모의고사 테이블 성적 뽑기
	
	private String mockId;
	private String memberId;
	private String languageType;
	private int languageOriginalScore;
	private int languageStandardScore;
	private double languagePercentile;
	private String mathType;
	private int mathOriginalScore;
	private int mathStandardScore;
	private double mathpercentile;
	private int englishOriginalScore;
	private int englishStandardScore;
	private double englishpercentile;
	private String languageSubjectName;
	private String languageId;
	private int secondLanguageOriginalScore;
	private int secondLanguageStandardScore;
	private double secondLanguagePercentile;
	
	
	public MockScoreDetailList(){}


	public MockScoreDetailList(String mockId, String memberId, String languageType, int languageOriginalScore,
			int languageStandardScore, double languagePercentile, String mathType, int mathOriginalScore,
			int mathStandardScore, double mathpercentile, int englishOriginalScore, int englishStandardScore,
			double englishpercentile, String languageSubjectName, String languageId, int secondLanguageOriginalScore,
			int secondLanguageStandardScore, double secondLanguagePercentile) {
		super();
		this.mockId = mockId;
		this.memberId = memberId;
		this.languageType = languageType;
		this.languageOriginalScore = languageOriginalScore;
		this.languageStandardScore = languageStandardScore;
		this.languagePercentile = languagePercentile;
		this.mathType = mathType;
		this.mathOriginalScore = mathOriginalScore;
		this.mathStandardScore = mathStandardScore;
		this.mathpercentile = mathpercentile;
		this.englishOriginalScore = englishOriginalScore;
		this.englishStandardScore = englishStandardScore;
		this.englishpercentile = englishpercentile;
		this.languageSubjectName = languageSubjectName;
		this.languageId = languageId;
		this.secondLanguageOriginalScore = secondLanguageOriginalScore;
		this.secondLanguageStandardScore = secondLanguageStandardScore;
		this.secondLanguagePercentile = secondLanguagePercentile;
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


	public String getLanguageType() {
		return languageType;
	}


	public void setLanguageType(String languageType) {
		this.languageType = languageType;
	}


	public int getLanguageOriginalScore() {
		return languageOriginalScore;
	}


	public void setLanguageOriginalScore(int languageOriginalScore) {
		this.languageOriginalScore = languageOriginalScore;
	}


	public int getLanguageStandardScore() {
		return languageStandardScore;
	}


	public void setLanguageStandardScore(int languageStandardScore) {
		this.languageStandardScore = languageStandardScore;
	}


	public double getLanguagePercentile() {
		return languagePercentile;
	}


	public void setLanguagePercentile(double languagePercentile) {
		this.languagePercentile = languagePercentile;
	}


	public String getMathType() {
		return mathType;
	}


	public void setMathType(String mathType) {
		this.mathType = mathType;
	}


	public int getMathOriginalScore() {
		return mathOriginalScore;
	}


	public void setMathOriginalScore(int mathOriginalScore) {
		this.mathOriginalScore = mathOriginalScore;
	}


	public int getMathStandardScore() {
		return mathStandardScore;
	}


	public void setMathStandardScore(int mathStandardScore) {
		this.mathStandardScore = mathStandardScore;
	}


	public double getMathpercentile() {
		return mathpercentile;
	}


	public void setMathpercentile(double mathpercentile) {
		this.mathpercentile = mathpercentile;
	}


	public int getEnglishOriginalScore() {
		return englishOriginalScore;
	}


	public void setEnglishOriginalScore(int englishOriginalScore) {
		this.englishOriginalScore = englishOriginalScore;
	}


	public int getEnglishStandardScore() {
		return englishStandardScore;
	}


	public void setEnglishStandardScore(int englishStandardScore) {
		this.englishStandardScore = englishStandardScore;
	}


	public double getEnglishpercentile() {
		return englishpercentile;
	}


	public void setEnglishpercentile(double englishpercentile) {
		this.englishpercentile = englishpercentile;
	}


	public String getLanguageSubjectName() {
		return languageSubjectName;
	}


	public void setLanguageSubjectName(String languageSubjectName) {
		this.languageSubjectName = languageSubjectName;
	}


	public String getLanguageId() {
		return languageId;
	}


	public void setLanguageId(String languageId) {
		this.languageId = languageId;
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
