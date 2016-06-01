package ko.school.schoolmanage.domain;

import java.sql.Timestamp;

public class SchoolAdminListVO {
	private String schoolAdminId;
	private String schoolAdminTel;
	private String deleteRequest;
	private Timestamp schoolRegistDate;
	private Timestamp schoolEndDate;
	
	public SchoolAdminListVO(){}
	
	public SchoolAdminListVO(String schoolAdminId, String schoolAdminTel, String deleteRequest, Timestamp schoolRegistDate,
			Timestamp schoolEndDate) {
		super();
		this.schoolAdminId = schoolAdminId;
		this.schoolAdminTel = schoolAdminTel;
		this.deleteRequest = deleteRequest;
		this.schoolRegistDate = schoolRegistDate;
		this.schoolEndDate = schoolEndDate;
	}
	public String getSchoolAdminId() {
		return schoolAdminId;
	}
	public void setSchoolAdminId(String schoolAdminId) {
		this.schoolAdminId = schoolAdminId;
	}
	public String getSchoolAdminTel() {
		return schoolAdminTel;
	}
	public void setSchoolAdminTel(String schoolAdminTel) {
		this.schoolAdminTel = schoolAdminTel;
	}
	public String getDeleteRequest() {
		return deleteRequest;
	}
	public void setDeleteRequest(String deleteRequest) {
		this.deleteRequest = deleteRequest;
	}
	public Timestamp getSchoolRegistDate() {
		return schoolRegistDate;
	}
	public void setSchoolRegistDate(Timestamp schoolRegistDate) {
		this.schoolRegistDate = schoolRegistDate;
	}
	public Timestamp getSchoolEndDate() {
		return schoolEndDate;
	}
	public void setSchoolEndDate(Timestamp schoolEndDate) {
		this.schoolEndDate = schoolEndDate;
	}
	
}

