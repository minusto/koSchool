package ko.school.common.domain;

public class ParentVO{

	private String memberId;
	private String familyRelation;
	private String studentMemberId;


	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getStudentMemberId() {
		return studentMemberId;
	}

	public void setStudentMemberId(String studentMemberId) {
		this.studentMemberId = studentMemberId;
	}

	public String getFamilyRelation() {
		return familyRelation;
	}

	public void setFamilyRelation(String familyRelation) {
		this.familyRelation = familyRelation;
	}


}
