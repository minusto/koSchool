package ko.school.common.domain;



public class RegistManageVO  {

	private int registNum;
	private String schoolAdminId;
	private String memberId;
	private String memberGrade;

	public int getRegistNum() {
		return registNum;
	}

	public void setRegistNum(int registNum) {
		this.registNum = registNum;
	}

	public String getSchoolAdminId() {
		return schoolAdminId;
	}

	public void setSchoolAdminId(String schoolAdminId) {
		this.schoolAdminId = schoolAdminId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getmemberGrade() {
		return memberGrade;
	}

	public void setmemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
}
