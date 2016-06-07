package ko.school.message.domain;

public class SchoolNewsLetterSignVO {
	
	private int schoolNewsLetterNum;
	private String memberId;
	private String sign;
	
	private String memberName;			//컬럼 X
	
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getSchoolNewsLetterNum() {
		return schoolNewsLetterNum;
	}
	public void setSchoolNewsLetterNum(int schoolNewsLetterNum) {
		this.schoolNewsLetterNum = schoolNewsLetterNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	
	
}
