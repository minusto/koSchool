package ko.school.simulation.domain;

public class HopeUniversityVO {
	private String memberId;
	private String majorId;
	private String universityId;
	private int entranceYear;
	private String recruitSeparate;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
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
	
}
