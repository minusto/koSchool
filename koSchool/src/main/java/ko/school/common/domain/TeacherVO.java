package ko.school.common.domain;

public class TeacherVO{

	private String memberId;
	private int teacherClass;
	private String teacherPicture;
	private String teacherPosition;
	private String subjectId;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
