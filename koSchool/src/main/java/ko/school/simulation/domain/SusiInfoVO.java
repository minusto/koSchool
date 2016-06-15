package ko.school.simulation.domain;

public class SusiInfoVO {
	private String majorId; 
	private String universityId;
	private String recruitSeparate;
	private String recruitModelType;
	private int recruitNum;
	private String reflectionRateId; 
	private String schoolReportReflectionRateId;
	private double grade1ReflectionRate; 
	private double grade2ReflectionRate; 
	private double grade3ReflectionRate; 
	private String reflectionSubjects; 
	private String pointperGradeId;
	private double pointPerGrade1;
	private double pointPerGrade2;
	private double pointPerGrade3; 
	private double pointPerGrade4;
	private double pointPerGrade5; 
	private double pointPerGrade6;
	private double pointPerGrade7; 
	private double pointPerGrade8; 
	private double pointPerGrade9;
	private double averScore; 
	private String majorName;
	private String kind;
	private String college;
	private String universityName; 
	private String universityLocal;
	
	
	@Override
	public String toString() {
		return "SusiInfoVO [majorId=" + majorId + ", universityId=" + universityId + ", recruitSeparate="
				+ recruitSeparate + ", recruitModelType=" + recruitModelType + ", recruitNum=" + recruitNum
				+ ", reflectionRateId=" + reflectionRateId + ", schoolReportReflectionRateId="
				+ schoolReportReflectionRateId + ", grade1ReflectionRate=" + grade1ReflectionRate
				+ ", grade2ReflectionRate=" + grade2ReflectionRate + ", grade3ReflectionRate=" + grade3ReflectionRate
				+ ", reflectionSubjects=" + reflectionSubjects + ", pointperGradeId=" + pointperGradeId
				+ ", pointPerGrade1=" + pointPerGrade1 + ", pointPerGrade2=" + pointPerGrade2 + ", pointPerGrade3="
				+ pointPerGrade3 + ", pointPerGrade4=" + pointPerGrade4 + ", pointPerGrade5=" + pointPerGrade5
				+ ", pointPerGrade6=" + pointPerGrade6 + ", pointPerGrade7=" + pointPerGrade7 + ", pointPerGrade8="
				+ pointPerGrade8 + ", pointPerGrade9=" + pointPerGrade9 + ", averScore=" + averScore + ", majorName="
				+ majorName + ", kind=" + kind + ", college=" + college + ", universityName=" + universityName
				+ ", universityLocal=" + universityLocal + "]";
	}
	
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	public String getUniversityId() {
		return universityId;
	}
	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}
	public String getRecruitSeparate() {
		return recruitSeparate;
	}
	public void setRecruitSeparate(String recruitSeparate) {
		this.recruitSeparate = recruitSeparate;
	}
	public String getRecruitModelType() {
		return recruitModelType;
	}
	public void setRecruitModelType(String recruitModelType) {
		this.recruitModelType = recruitModelType;
	}
	public int getRecruitNum() {
		return recruitNum;
	}
	public void setRecruitNum(int recruitNum) {
		this.recruitNum = recruitNum;
	}
	public String getReflectionRateId() {
		return reflectionRateId;
	}
	public void setReflectionRateId(String reflectionRateId) {
		this.reflectionRateId = reflectionRateId;
	}
	public String getSchoolReportReflectionRateId() {
		return schoolReportReflectionRateId;
	}
	public void setSchoolReportReflectionRateId(String schoolReportReflectionRateId) {
		this.schoolReportReflectionRateId = schoolReportReflectionRateId;
	}
	public double getGrade1ReflectionRate() {
		return grade1ReflectionRate;
	}
	public void setGrade1ReflectionRate(double grade1ReflectionRate) {
		this.grade1ReflectionRate = grade1ReflectionRate;
	}
	public double getGrade2ReflectionRate() {
		return grade2ReflectionRate;
	}
	public void setGrade2ReflectionRate(double grade2ReflectionRate) {
		this.grade2ReflectionRate = grade2ReflectionRate;
	}
	public double getGrade3ReflectionRate() {
		return grade3ReflectionRate;
	}
	public void setGrade3ReflectionRate(double grade3ReflectionRate) {
		this.grade3ReflectionRate = grade3ReflectionRate;
	}
	public String getReflectionSubjects() {
		return reflectionSubjects;
	}
	public void setReflectionSubjects(String reflectionSubjects) {
		this.reflectionSubjects = reflectionSubjects;
	}
	public String getPointperGradeId() {
		return pointperGradeId;
	}
	public void setPointperGradeId(String pointperGradeId) {
		this.pointperGradeId = pointperGradeId;
	}
	public double getPointPerGrade1() {
		return pointPerGrade1;
	}
	public void setPointPerGrade1(double pointPerGrade1) {
		this.pointPerGrade1 = pointPerGrade1;
	}
	public double getPointPerGrade2() {
		return pointPerGrade2;
	}
	public void setPointPerGrade2(double pointPerGrade2) {
		this.pointPerGrade2 = pointPerGrade2;
	}
	public double getPointPerGrade3() {
		return pointPerGrade3;
	}
	public void setPointPerGrade3(double pointPerGrade3) {
		this.pointPerGrade3 = pointPerGrade3;
	}
	public double getPointPerGrade4() {
		return pointPerGrade4;
	}
	public void setPointPerGrade4(double pointPerGrade4) {
		this.pointPerGrade4 = pointPerGrade4;
	}
	public double getPointPerGrade5() {
		return pointPerGrade5;
	}
	public void setPointPerGrade5(double pointPerGrade5) {
		this.pointPerGrade5 = pointPerGrade5;
	}
	public double getPointPerGrade6() {
		return pointPerGrade6;
	}
	public void setPointPerGrade6(double pointPerGrade6) {
		this.pointPerGrade6 = pointPerGrade6;
	}
	public double getPointPerGrade7() {
		return pointPerGrade7;
	}
	public void setPointPerGrade7(double pointPerGrade7) {
		this.pointPerGrade7 = pointPerGrade7;
	}
	public double getPointPerGrade8() {
		return pointPerGrade8;
	}
	public void setPointPerGrade8(double pointPerGrade8) {
		this.pointPerGrade8 = pointPerGrade8;
	}
	public double getPointPerGrade9() {
		return pointPerGrade9;
	}
	public void setPointPerGrade9(double pointPerGrade9) {
		this.pointPerGrade9 = pointPerGrade9;
	}
	public double getAverScore() {
		return averScore;
	}
	public void setAverScore(double averScore) {
		this.averScore = averScore;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getUniversityLocal() {
		return universityLocal;
	}
	public void setUniversityLocal(String universityLocal) {
		this.universityLocal = universityLocal;
	}
	
	
}
