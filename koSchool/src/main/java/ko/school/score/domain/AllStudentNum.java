package ko.school.score.domain;

import java.io.Serializable;

public class AllStudentNum implements Serializable {
	private String subjectId;
	private int allStudentNum;
	
	public AllStudentNum(){}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public int getAllStudentNum() {
		return allStudentNum;
	}

	public void setAllStudentNum(int allStudentNum) {
		this.allStudentNum = allStudentNum;
	}
	
	
	
	
}
