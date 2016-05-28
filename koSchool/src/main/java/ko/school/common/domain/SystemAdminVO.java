package ko.school.common.domain;

import java.io.Serializable;

public class SystemAdminVO implements Serializable {

	private String systemAdminId;
	private String systemAdminPassword;

	public String getSystemAdminId() {
		return systemAdminId;
	}

	public void setSystemAdminId(String systemAdminId) {
		this.systemAdminId = systemAdminId;
	}

	public String getSystemAdminPassword() {
		return systemAdminPassword;
	}

	public void setSystemAdminPassword(String systemAdminPassword) {
		this.systemAdminPassword = systemAdminPassword;
	}
}
