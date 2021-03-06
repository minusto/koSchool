package ko.school.simulation.domain;

public class UniversityVO {
	private String universityId;
	private String universityName;
	private String campusName;
	private String universityLocal;
	private String universityURL;
	private String universityMark;
	
	private double minAverscore;
	private double maxAverscore;
	
	public double getMinAverscore() {
		return minAverscore;
	}
	public void setMinAverscore(double minAverscore) {
		this.minAverscore = minAverscore;
	}
	public double getMaxAverscore() {
		return maxAverscore;
	}
	public void setMaxAverscore(double maxAverscore) {
		this.maxAverscore = maxAverscore;
	}
	public String getUniversityId() {
		return universityId;
	}
	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getCampusName() {
		return campusName;
	}
	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
	public String getUniversityLocal() {
		return universityLocal;
	}
	public void setUniversityLocal(String universityLocal) {
		this.universityLocal = universityLocal;
	}
	public String getUniversityURL() {
		return universityURL;
	}
	public void setUniversityURL(String universityURL) {
		this.universityURL = universityURL;
	}
	public String getUniversityMark() {
		return universityMark;
	}
	public void setUniversityMark(String universityMark) {
		this.universityMark = universityMark;
	}
	
}
