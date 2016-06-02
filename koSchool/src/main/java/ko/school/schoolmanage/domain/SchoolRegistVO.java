package ko.school.schoolmanage.domain;

import java.io.Serializable;

public class SchoolRegistVO implements Serializable {
	private String schoolId;
	private String schoolAdminId;
	
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolAdminId() {
		return schoolAdminId;
	}
	public void setSchoolAdminId(String schoolAdminId) {
		this.schoolAdminId = schoolAdminId;
	}
}
