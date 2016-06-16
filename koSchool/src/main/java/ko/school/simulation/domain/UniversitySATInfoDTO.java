package ko.school.simulation.domain;

public class UniversitySATInfoDTO {
	private String universityName;
	private String majorName;
	private String kind;
	private String recruitSeparate;
	private String universityURL;
	private String universityMark;
	
	
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getUniversityMark() {
		return universityMark;
	}
	public void setUniversityMark(String universityMark) {
		this.universityMark = universityMark;
	}
	public String getUniversityURL() {
		return universityURL;
	}
	public void setUniversityURL(String universityURL) {
		this.universityURL = universityURL;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getRecruitSeparate() {
		return recruitSeparate;
	}
	public void setRecruitSeparate(String recruitSeparate) {
		this.recruitSeparate = recruitSeparate;
	}
	
	
}
