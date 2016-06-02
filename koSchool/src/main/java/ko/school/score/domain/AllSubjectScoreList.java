package ko.school.score.domain;

import java.io.Serializable;

public class AllSubjectScoreList implements Serializable {
	private String subjectId;
	private String subjectType;
	private String subjectName;
	private String subjectUnit;
	private String memberId;
	private double subjectTotal;
	private double subjectAvg;
	private int semester;
	private int subjectGrade;
	
	public AllSubjectScoreList(){}

	public int getSubjectGrade() {
		return subjectGrade;
	}

	public void setSubjectGrade(int subjectGrade) {
		this.subjectGrade = subjectGrade;
	}


	public String getSubjectUnit() {
		return subjectUnit;
	}



	public void setSubjectUnit(String subjectUnit) {
		this.subjectUnit = subjectUnit;
	}



	public int getSemester() {
		return semester;
	}



	public void setSemester(int semester) {
		this.semester = semester;
	}



	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
	

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public double getSubjectTotal() {
		return subjectTotal;
	}

	public void setSubjectTotal(double subjectTotal) {
		this.subjectTotal = subjectTotal;
	}

	public double getSubjectAvg() {
		return subjectAvg;
	}

	public void setSubjectAvg(double subjectAvg) {
		this.subjectAvg = subjectAvg;
	}

	
	
}
