package ko.school.schoolmanage.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class TeacherDetailVO {
	private String memberId;
	private String memberName;
	private String memberBirthday;
	private String memberAddress;
	private String memberTel;
	private String memberNote;
	private String memberEmail;
	private int teacherClass;
	private String teacherPicture;
	private String teacherPosition;
	private String subjectId;
	
	public TeacherDetailVO(){}
	
	public TeacherDetailVO(String memberId, String memberName, String memberBirthday, String memberAddress,
			String memberTel, String memberNote, String memberEmail, int teacherClass, String teacherPicture,
			String teacherPosition, String subjectId) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberBirthday = memberBirthday;
		this.memberAddress = memberAddress;
		this.memberTel = memberTel;
		this.memberNote = memberNote;
		this.memberEmail = memberEmail;
		this.teacherClass = teacherClass;
		this.teacherPicture = teacherPicture;
		this.teacherPosition = teacherPosition;
		this.subjectId = subjectId;
	}
	
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
	public String getMemberNote() {
		return memberNote;
	}
	public void setMemberNote(String memberNote) {
		this.memberNote = memberNote;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public int getTeacherClass() {
		return teacherClass;
	}
	public void setTeacherClass(int teacherClass) {
		this.teacherClass = teacherClass;
	}
	public String getTeacherPicture() {
		return teacherPicture;
	}
	public void setTeacherPicture(String teacherPicture) {
		this.teacherPicture = teacherPicture;
	}
	public String getTeacherPosition() {
		return teacherPosition;
	}
	public void setTeacherPosition(String teacherPosition) {
		this.teacherPosition = teacherPosition;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

}
