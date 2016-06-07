package ko.school.score.domain;

public class NesinSaveForm {
	private String memberIdS; 
	private String subjectId;
	private int nesinYear;
	private String subjectGrade;
	private String[] arrSubjectId;

	
	public String getSubjectGrade() {
		return subjectGrade;
	}

	public void setSubjectGrade(String subjectGrade) {
		this.subjectGrade = subjectGrade;
	}

	public String getMemberIdS() {
		return memberIdS;
	}

	public void setMemberIdS(String memberIdS) {
		this.memberIdS = memberIdS;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public int getNesinYear() {
		return nesinYear;
	}

	public void setNesinYear(int nesinYear) {
		this.nesinYear = nesinYear;
	}

	public String[] getArrSubjectId() {
		return arrSubjectId;
	}

	public void setArrSubjectId(String[] arrSubjectId) {
		this.arrSubjectId = arrSubjectId;
	}
	
	
	
	
}
