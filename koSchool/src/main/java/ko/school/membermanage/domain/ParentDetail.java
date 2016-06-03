package ko.school.membermanage.domain;

import java.sql.Timestamp;

public class ParentDetail {
	private String memberId;
	private String memberName;
	private String memberBirthday;
	private String memberAddress;
	private String memberTel;
	private String memberEmail;
	private String memberNote;
	private String schoolId;
	private String studentMemberId;
	private String familyRelation;
	private String parentName;
	
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
	public String getMemberBirthday() {
		return memberBirthday;
	}
	public void setMemberBirthday(String memberBirthday) {
		this.memberBirthday = memberBirthday;
	}
	public String getMemberAddress() {
		return memberAddress;
	}
	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberNote() {
		return memberNote;
	}
	public void setMemberNote(String memberNote) {
		this.memberNote = memberNote;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
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
