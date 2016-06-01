package ko.school.schoolmanage.domain;

import java.io.Serializable;

public class TeacherDetailVO {
	private String memberId;
	private String memberName;
	private String memberBirthday;
	private String memberTel;
	private String memberEmail;
	private int teacherClass;
	private String subjectId;
	
	public TeacherDetailVO(){}
		
	public TeacherDetailVO(String memberId, String memberName,
			String memberBirthday, String memberTel, String memberEmail,
			int teacherClass, String subjectId) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberBirthday = memberBirthday;
		this.memberTel = memberTel;
		this.memberEmail = memberEmail;
		this.teacherClass = teacherClass;
		this.subjectId = subjectId;
	}

	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberBirthday() {
		return memberBirthday;
	}
	public void setMemberBirthday(String memberBirthday) {
		this.memberBirthday = memberBirthday;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public int getTeacherClass() {
		return teacherClass;
	}
	public void setTeacherClass(int teacherClass) {
		this.teacherClass = teacherClass;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
	

}
