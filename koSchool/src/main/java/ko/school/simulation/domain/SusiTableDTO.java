package ko.school.simulation.domain;

public class SusiTableDTO {
	private String location; //지역명
	private String university; //대학명
	private String major; //학과
	private String recruitModelType; // 전형유형
	private String kind; // 계열
	private int recruitNum; //모집인원
	private double averScore; // 지원가능 주요교과 평균등급
	private double resultScore; // 수시 진단결과
	private String lowScoreStandard; // 최저학력기준
	private String sfMessage; //합격여부;
	
	@Override
	public String toString() {
		return "SusiTableDTO [location=" + location + ", university=" + university + ", major=" + major
				+ ", recruitModelType=" + recruitModelType + ", kind=" + kind + ", recruitNum=" + recruitNum
				+ ", averScore=" + averScore + ", resultScore=" + resultScore + ", lowScoreStandard=" + lowScoreStandard
				+ ", sfMessage=" + sfMessage + "]";
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getSfMessage() {
		return sfMessage;
	}
	public void setSfMessage(String sfMessage) {
		this.sfMessage = sfMessage;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getRecruitModelType() {
		return recruitModelType;
	}
	public void setRecruitModelType(String recruitModelType) {
		this.recruitModelType = recruitModelType;
	}
	public int getRecruitNum() {
		return recruitNum;
	}
	public void setRecruitNum(int recruitNum) {
		this.recruitNum = recruitNum;
	}
	public double getAverScore() {
		return averScore;
	}
	public void setAverScore(double averScore) {
		this.averScore = averScore;
	}
	public double getResultScore() {
		return resultScore;
	}
	public void setResultScore(double resultScore) {
		this.resultScore = resultScore;
	}
	public String getLowScoreStandard() {
		return lowScoreStandard;
	}
	public void setLowScoreStandard(String lowScoreStandard) {
		this.lowScoreStandard = lowScoreStandard;
	}
	
	

}
