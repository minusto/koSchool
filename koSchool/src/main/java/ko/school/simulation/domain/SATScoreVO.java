package ko.school.simulation.domain;

public class SATScoreVO {
	private String majorId;
	private String universityId;
	private int entranceYear;
	private String recruitSeparate;
	private double standardScoreCutline;
	private double totalPercentile;
	private String satScoreUseIndex;
	private double convertScoreMax;
	private double convertStandardScoreCutline;
	
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
	public double getStandardScoreCutline() {
		return standardScoreCutline;
	}
	public void setStandardScoreCutline(double standardScoreCutline) {
		this.standardScoreCutline = standardScoreCutline;
	}
	public double getTotalPercentile() {
		return totalPercentile;
	}
	public void setTotalPercentile(double totalPercentile) {
		this.totalPercentile = totalPercentile;
	}
	public String getSatScoreUseIndex() {
		return satScoreUseIndex;
	}
	public void setSatScoreUseIndex(String satScoreUseIndex) {
		this.satScoreUseIndex = satScoreUseIndex;
	}
	public double getConvertScoreMax() {
		return convertScoreMax;
	}
	public void setConvertScoreMax(double convertScoreMax) {
		this.convertScoreMax = convertScoreMax;
	}
	public double getConvertStandardScoreCutline() {
		return convertStandardScoreCutline;
	}
	public void setConvertStandardScoreCutline(double convertStandardScoreCutline) {
		this.convertStandardScoreCutline = convertStandardScoreCutline;
	}
	
}
