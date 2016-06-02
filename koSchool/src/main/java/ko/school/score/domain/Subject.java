package ko.school.score.domain;

import java.io.Serializable;

public class Subject implements Serializable {

	private String subjectId;
	private int subjectUnit;
	private String subjectName;
	private String subjectType;
	private int subjectGrade;

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

	public int getSubjectGrade() {
		return subjectGrade;
	}

	public void setSubjectGrade(int subjectGrade) {
		this.subjectGrade = subjectGrade;
	}

}
