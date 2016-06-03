package ko.school.common.domain;

public class ParentVO{

	private String memberId;
	private String familyRelation;
	private String parentName;
	private String studentMemberId;

	
	@Override
	public String toString() {
		return "ParentVO [memberId=" + memberId + ", familyRelation=" + familyRelation + ", parentName=" + parentName
				+ ", studentMemberId=" + studentMemberId + "]";
	}

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

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	

}
