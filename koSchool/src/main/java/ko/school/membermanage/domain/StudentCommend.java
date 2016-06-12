package ko.school.membermanage.domain;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class StudentCommend {
	@NotEmpty(message="반드시 아이디를 입력하세요.")
	@Pattern(regexp="[0-9a-zA-z가-힣]*",message="특수문자 금지")
	private String memberId;
	
	@NotEmpty(message="반드시 이름을 입력하세요.")
	@Pattern(regexp="[가-힣]*",message="한글만 입력하세요.")
	private String memberName;
	
	private String memberBirthday;
	
	@NotEmpty(message="반드시 주소를 입력하세요.")
	private String memberAddress;
	
	@NotEmpty(message="반드시 전화번호를 입력하세요.")
	@Pattern(regexp="^01(?:0|1|[6-9])-([0-9]{3,4})-([0-9]{4}$)",message="전화번호 형식에 맞게 입력하세요.")
	private String memberTel;
	
	@NotEmpty(message="반드시 이메일을 입력하세요.")
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message="이메일 형식에 맞게 입력하세요.")
	private String memberEmail;
	
	@NotEmpty(message="입력하실 내용이 없다면 '없음'을 입력해주세요.")
	private String memberNote;
	
	private String schoolId;
	
	@NotEmpty(message="반드시 학번을 입력하세요.")
	@Pattern(regexp="[0-9]*",message="숫자만 입력하세요.")
	private String studentCode;
	
	private int studentGrade;
	
	private int studentClass;
	
	private int studentNum;
	
	@NotEmpty(message="반드시 성별 입력하세요.")
	private String studentGender;
	
	@NotEmpty(message="반드시 학과를 입력하세요.")
	private String studentMajor;
	
	private String studentPicture;
	
	private MultipartFile file;

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

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	

}
