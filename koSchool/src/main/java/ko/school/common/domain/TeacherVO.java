package ko.school.common.domain;



import org.springframework.web.multipart.MultipartFile;

public class TeacherVO {

	private String memberId;
	private int teacherClass;
	private String teacherPicture;
	private String teacherPosition;
	private String subjectId;
	private MultipartFile file;
	

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

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
