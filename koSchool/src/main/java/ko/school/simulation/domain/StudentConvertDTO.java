package ko.school.simulation.domain;

public class StudentConvertDTO {
	private String mathType;
	private String researchType;
	private String research1Name;
	private String research2Name;
	
	private double korConverScore;
	private double matConverScore;
	private double engConverScore;
	private double research1ConverScore;
	private double research2ConverScore;
	private double totalConverScore;
	
	
	@Override
	public String toString() {
		return "StudentConvertDTO [mathType=" + mathType + ", researchType=" + researchType + ", research1Name="
				+ research1Name + ", research2Name=" + research2Name + ", korConverScore=" + korConverScore
				+ ", matConverScore=" + matConverScore + ", engConverScore=" + engConverScore
				+ ", research1ConverScore=" + research1ConverScore + ", research2ConverScore=" + research2ConverScore
				+ ", totalConverScore=" + totalConverScore + "]";
	}
	public String getMathType() {
		return mathType;
	}
	public void setMathType(String mathType) {
		this.mathType = mathType;
	}
	public String getResearchType() {
		return researchType;
	}
	public void setResearchType(String researchType) {
		this.researchType = researchType;
	}
	public String getResearch1Name() {
		return research1Name;
	}
	public void setResearch1Name(String research1Name) {
		this.research1Name = research1Name;
	}
	public String getResearch2Name() {
		return research2Name;
	}
	public void setResearch2Name(String research2Name) {
		this.research2Name = research2Name;
	}
	public double getKorConverScore() {
		return korConverScore;
	}
	public void setKorConverScore(double korConverScore) {
		this.korConverScore = korConverScore;
	}
	public double getMatConverScore() {
		return matConverScore;
	}
	public void setMatConverScore(double matConverScore) {
		this.matConverScore = matConverScore;
	}
	public double getEngConverScore() {
		return engConverScore;
	}
	public void setEngConverScore(double engConverScore) {
		this.engConverScore = engConverScore;
	}
	public double getResearch1ConverScore() {
		return research1ConverScore;
	}
	public void setResearch1ConverScore(double research1ConverScore) {
		this.research1ConverScore = research1ConverScore;
	}
	public double getResearch2ConverScore() {
		return research2ConverScore;
	}
	public void setResearch2ConverScore(double research2ConverScore) {
		this.research2ConverScore = research2ConverScore;
	}
	public double getTotalConverScore() {
		return totalConverScore;
	}
	public void setTotalConverScore(double totalConverScore) {
		this.totalConverScore = totalConverScore;
	}
	
	
}
