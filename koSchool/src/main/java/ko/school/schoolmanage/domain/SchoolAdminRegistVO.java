package ko.school.schoolmanage.domain;


import java.sql.Timestamp;

public class SchoolAdminRegistVO {

	private String systemAdminId;
	private String schoolAdminId;
	private Timestamp schoolRegistDate;
	private String schoolEndDate;

	public SchoolAdminRegistVO(){}

	public SchoolAdminRegistVO(String systemAdminId, String schoolAdminId, Timestamp schoolRegistDate,
			String schoolEndDate) {
		super();
		this.systemAdminId = systemAdminId;
		this.schoolAdminId = schoolAdminId;
		this.schoolRegistDate = schoolRegistDate;
		this.schoolEndDate = schoolEndDate;
	}

	public String getSystemAdminId() {
		return systemAdminId;
	}

	public void setSystemAdminId(String systemAdminId) {
		this.systemAdminId = systemAdminId;
	}

	public String getSchoolAdminId() {
		return schoolAdminId;
	}

	public void setSchoolAdminId(String schoolAdminId) {
		this.schoolAdminId = schoolAdminId;
	}

	public Timestamp getSchoolRegistDate() {
		return schoolRegistDate;
	}

	public void setSchoolRegistDate(Timestamp schoolRegistDate) {
		this.schoolRegistDate = schoolRegistDate;
	}

	public String getSchoolEndDate() {
		return schoolEndDate;
	}

	public void setSchoolEndDate(String schoolEndDate) {
		this.schoolEndDate = schoolEndDate;
	}
	
	
}
