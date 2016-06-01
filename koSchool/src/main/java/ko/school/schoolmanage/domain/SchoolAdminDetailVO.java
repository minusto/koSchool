package ko.school.schoolmanage.domain;

import java.sql.Timestamp;

public class SchoolAdminDetailVO  {
	private String schoolAdminId;
	private String schoolAdminName;
	private String schoolAdminTel;
	private String deleteRequest;
	private Timestamp schoolRegistDate;
	private Timestamp schoolEndDate;
	
	public SchoolAdminDetailVO(){}



	public SchoolAdminDetailVO(String schoolAdminId, String schoolAdminName, String schoolAdminTel,
			String deleteRequest, Timestamp schoolRegistDate, Timestamp schoolEndDate) {
		super();
		this.schoolAdminId = schoolAdminId;
		this.schoolAdminName = schoolAdminName;
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

	public String getSchoolAdminName() {
		return schoolAdminName;
	}

	public void setSchoolAdminName(String schoolAdminName) {
		this.schoolAdminName = schoolAdminName;
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
