package ko.school.common.domain;

import java.io.Serializable;

public class SchoolAdminVO implements Serializable {

	private String schoolAdminId;
	private String schoolAdminPassword;
	private String schoolAdminName;
	private String schoolAdminTel;
	private String deleteRequest;

	public String getSchoolAdminId() {
		return schoolAdminId;
	}

	public void setSchoolAdminId(String schoolAdminId) {
		this.schoolAdminId = schoolAdminId;
	}

	public String getSchoolAdminPassword() {
		return schoolAdminPassword;
	}

	public void setSchoolAdminPassword(String schoolAdminPassword) {
		this.schoolAdminPassword = schoolAdminPassword;
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

}
