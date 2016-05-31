package ko.school.membermanage.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class StudentDetail implements Serializable{
	private String memberId;
	private String memberName;
	private Timestamp memberBirthday;
	private String memberAddress;
	private String memberTel;
	private String memberEmail;
	private String memberNote;
	private String schoolId;
	private String studentCode;
	private int studentGrade;
	private int studentClass;
	private int studentNum;
	private String studentGender;
	private String studentMajor;
	private String studentPicture;
	
	public StudentDetail(){};
	
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
	
	public Timestamp getMemberBirthday() {
		return memberBirthday;
	}

	public void setMemberBirthday(Timestamp memberBirthday) {
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
	public String getStudentCode() {
		return studentCode;
	}
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}
	public int getStudentGrade() {
		return studentGrade;
	}
	public void setStudentGrade(int studentGrade) {
		this.studentGrade = studentGrade;
	}
	public int getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(int studentClass) {
		this.studentClass = studentClass;
	}
	public int getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	public String getStudentGender() {
		return studentGender;
	}
	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}
	public String getStudentMajor() {
		return studentMajor;
	}
	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}
	public String getStudentPicture() {
		return studentPicture;
	}
	public void setStudentPicture(String studentPicture) {
		this.studentPicture = studentPicture;
	}
	
	
	
	
}
