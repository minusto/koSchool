package ko.school.board.domain;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class ClassBoardVO {
	private int classBoardNum;
	private String classBoardTitle;
	private String classBoardContent;
	private String classBoardWriter;
	private Date classBoardDate;
	private String classBoardPassword;
	private int classBoardHitcount;
	private String classBoardFileName;
	private int classBoardRef;
	private int classBoardStep;
	private int classBoardLevel;
	private String memberId;
	private String teacherClass;
	
	private MultipartFile file;
	
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getTeacherClass() {
		return teacherClass;
	}
	public void setTeacherClass(String teacherClass) {
		this.teacherClass = teacherClass;
	}
	public int getClassBoardNum() {
		return classBoardNum;
	}
	public void setClassBoardNum(int classBoardNum) {
		this.classBoardNum = classBoardNum;
	}
	public String getClassBoardTitle() {
		return classBoardTitle;
	}
	public void setClassBoardTitle(String classBoardTitle) {
		this.classBoardTitle = classBoardTitle;
	}
	public String getClassBoardContent() {
		return classBoardContent;
	}
	public void setClassBoardContent(String classBoardContent) {
		this.classBoardContent = classBoardContent;
	}
	public String getClassBoardWriter() {
		return classBoardWriter;
	}
	public void setClassBoardWriter(String classBoardWriter) {
		this.classBoardWriter = classBoardWriter;
	}
	public Date getClassBoardDate() {
		return classBoardDate;
	}
	public void setClassBoardDate(Date classBoardDate) {
		this.classBoardDate = classBoardDate;
	}
	public String getClassBoardPassword() {
		return classBoardPassword;
	}
	public void setClassBoardPassword(String classBoardPassword) {
		this.classBoardPassword = classBoardPassword;
	}
	public int getClassBoardHitcount() {
		return classBoardHitcount;
	}
	public void setClassBoardHitcount(int classBoardHitcount) {
		this.classBoardHitcount = classBoardHitcount;
	}
	public String getClassBoardFilename() {
		return classBoardFileName;
	}
	public void setClassBoardFilename(String classBoardFilename) {
		this.classBoardFileName = classBoardFilename;
	}
	public int getClassBoardRef() {
		return classBoardRef;
	}
	public void setClassBoardRef(int classBoardRef) {
		this.classBoardRef = classBoardRef;
	}
	public int getClassBoardStep() {
		return classBoardStep;
	}
	public void setClassBoardStep(int classBoardStep) {
		this.classBoardStep = classBoardStep;
	}
	public int getClassBoardLevel() {
		return classBoardLevel;
	}
	public void setClassBoardLevel(int classBoardLevel) {
		this.classBoardLevel = classBoardLevel;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	
}
