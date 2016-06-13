package ko.school.simulation.domain;

public class SusiScoreVO {
	private String majorId;
	private String universityId;
	private int entranceYear;
	private String recruitSeparate;
	private double averScore;
	
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	public String getUniversityId() {
		return universityId;
	}
	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}
	public int getEntranceYear() {
		return entranceYear;
	}
	public void setEntranceYear(int entranceYear) {
		this.entranceYear = entranceYear;
	}
	public String getRecruitSeparate() {
		return recruitSeparate;
	}
	public void setRecruitSeparate(String recruitSeparate) {
		this.recruitSeparate = recruitSeparate;
	}
	public double getAverScore() {
		return averScore;
	}
	public void setAverScore(double averScore) {
		this.averScore = averScore;
	}
	
}
