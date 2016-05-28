package ko.school.common.domain;

import java.io.Serializable;

public class ParentVO implements Serializable {

	private String parentId;
	private String familyRelation;
	private String parentName;
	private String parentPassword;
	private String memberId;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getFamilyRelation() {
		return familyRelation;
	}

	public void setFamilyRelation(String familyRelation) {
		this.familyRelation = familyRelation;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentPassword() {
		return parentPassword;
	}

	public void setParentPassword(String parentPassword) {
		this.parentPassword = parentPassword;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
