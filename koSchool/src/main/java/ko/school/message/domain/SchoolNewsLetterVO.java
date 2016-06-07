package ko.school.message.domain;

public class SchoolNewsLetterVO {
	
	private int schoolNewsLetterNum;
	private String memberId;
	private String teacherSignCheck;
	private String parentSignCheck;
	private String title;
	private String content;
	
	public int getSchoolNewsLetterNum() {
		return schoolNewsLetterNum;
	}
	public void setSchoolNewsLetterNum(int schoolNewsLetterNum) {
		this.schoolNewsLetterNum = schoolNewsLetterNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getTeacherSignCheck() {
		return teacherSignCheck;
	}
	public void setTeacherSignCheck(String teacherSignCheck) {
		this.teacherSignCheck = teacherSignCheck;
	}
	public String getParentSignCheck() {
		return parentSignCheck;
	}
	public void setParentSignCheck(String parentSignCheck) {
		this.parentSignCheck = parentSignCheck;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
