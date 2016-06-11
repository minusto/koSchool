package ko.school.simulation.domain;

public class SchoolReportVO {
	private String schoolReportReflectionRateId;
	private double grade1ReflectionRate;
	private double grade2ReflectionRate;
	private double grade3ReflectionRate;
	private double subjectReflectionRate;
	private String reflectionSubjects;
	private String pointPerGradeId;
	
	
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
	public double getSubjectReflectionRate() {
		return subjectReflectionRate;
	}
	public void setSubjectReflectionRate(double subjectReflectionRate) {
		this.subjectReflectionRate = subjectReflectionRate;
	}
	public String getReflectionSubjects() {
		return reflectionSubjects;
	}
	public void setReflectionSubjects(String reflectionSubjects) {
		this.reflectionSubjects = reflectionSubjects;
	}
	public String getPointPerGradeId() {
		return pointPerGradeId;
	}
	public void setPointPerGradeId(String pointPerGradeId) {
		this.pointPerGradeId = pointPerGradeId;
	}
	
}
