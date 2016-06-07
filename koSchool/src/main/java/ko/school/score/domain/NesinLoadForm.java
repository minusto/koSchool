package ko.school.score.domain;

import java.io.Serializable;

public class NesinLoadForm implements Serializable{
	private String memberId;
	private String subjectId;
	private int subjectUnit;
	private String subjectName;
	private String subjectType;
	private String subjectGrade;
	private int nesinYear;
	
	
	
	public int getNesinYear() {
		return nesinYear;
	}
	public void setNesinYear(int nesinYear) {
		this.nesinYear = nesinYear;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public int getSubjectUnit() {
		return subjectUnit;
	}
	public void setSubjectUnit(int subjectUnit) {
		this.subjectUnit = subjectUnit;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}
	public String getSubjectGrade() {
		return subjectGrade;
	}
	public void setSubjectGrade(String subjectGrade) {
		this.subjectGrade = subjectGrade;
	}

	
	
}
