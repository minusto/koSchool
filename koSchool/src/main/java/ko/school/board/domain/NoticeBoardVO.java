package ko.school.board.domain;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class NoticeBoardVO {
	private Integer noticeBoardNum;
	private String noticeBoardTitle;
	private Date noticeBoardDate;
	private Integer noticeBoardHitcount;
	private String noticeBoardFileName;
	private String noticeBoardContent;
	private String noticeBoardWriter;
	private String schoolAdminId;
	
	private MultipartFile file;
	
	public Integer getNoticeBoardNum() {
		return noticeBoardNum;
	}
	public void setNoticeBoardNum(Integer noticeBoardNum) {
		this.noticeBoardNum = noticeBoardNum;
	}
	public String getNoticeBoardTitle() {
		return noticeBoardTitle;
	}
	public void setNoticeBoardTitle(String noticeBoardTitle) {
		this.noticeBoardTitle = noticeBoardTitle;
	}
	public Date getNoticeBoardDate() {
		return noticeBoardDate;
	}
	public void setNoticeBoardDate(Date noticeBoardDate) {
		this.noticeBoardDate = noticeBoardDate;
	}
	public Integer getNoticeBoardHitcount() {
		return noticeBoardHitcount;
	}
	public void setNoticeBoardHitcount(Integer noticeBoardHitcount) {
		this.noticeBoardHitcount = noticeBoardHitcount;
	}
	public String getNoticeBoardFileName() {
		return noticeBoardFileName;
	}
	public void setNoticeBoardFileName(String noticeBoardFileName) {
		this.noticeBoardFileName = noticeBoardFileName;
	}
	public String getNoticeBoardContent() {
		return noticeBoardContent;
	}
	public void setNoticeBoardContent(String noticeBoardContent) {
		this.noticeBoardContent = noticeBoardContent;
	}
	public String getNoticeBoardWriter() {
		return noticeBoardWriter;
	}
	public void setNoticeBoardWriter(String noticeBoardWriter) {
		this.noticeBoardWriter = noticeBoardWriter;
	}
	public String getSchoolAdminId() {
		return schoolAdminId;
	}
	public void setSchoolAdminId(String schoolAdminId) {
		this.schoolAdminId = schoolAdminId;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
