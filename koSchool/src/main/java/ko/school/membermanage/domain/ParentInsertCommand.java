package ko.school.membermanage.domain;

public class ParentInsertCommand {
	private String memberId;
	private String memberName;
	private String familyRelation;
	private String studentMemberId;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getFamilyRelation() {
		return familyRelation;
	}
	public void setFamilyRelation(String familyRelation) {
		this.familyRelation = familyRelation;
	}
	public String getStudentMemberId() {
		return studentMemberId;
	}
	public void setStudentMemberId(String studentMemberId) {
		this.studentMemberId = studentMemberId;
	}
	
	
}
