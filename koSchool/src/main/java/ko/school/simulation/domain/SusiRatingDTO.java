package ko.school.simulation.domain;

public class SusiRatingDTO {
	private double kor;
	private int korUnit;
	private double eng;
	private int engUnit;
	private double math;
	private int mathUnit;
	private double sol;
	private int solUnit;
	private double sci;
	private int sciUnit;
	private double etc;
	private int etcUnit;
	
	
	@Override
	public String toString() {
		return "SusiRatingDTO [kor=" + kor + ", korUnit=" + korUnit + ", eng=" + eng + ", engUnit=" + engUnit
				+ ", math=" + math + ", mathUnit=" + mathUnit + ", sol=" + sol + ", solUnit=" + solUnit + ", sci=" + sci
				+ ", sciUnit=" + sciUnit + ", etc=" + etc + ", etcUnit=" + etcUnit + "]";
	}
	
	public double getKor() {
		return kor;
	}
	public void setKor(double kor) {
		this.kor = kor;
	}
	public int getKorUnit() {
		return korUnit;
	}
	public void setKorUnit(int korUnit) {
		this.korUnit = korUnit;
	}
	public double getEng() {
		return eng;
	}
	public void setEng(double eng) {
		this.eng = eng;
	}
	public int getEngUnit() {
		return engUnit;
	}
	public void setEngUnit(int engUnit) {
		this.engUnit = engUnit;
	}
	public double getMath() {
		return math;
	}
	public void setMath(double math) {
		this.math = math;
	}
	public int getMathUnit() {
		return mathUnit;
	}
	public void setMathUnit(int mathUnit) {
		this.mathUnit = mathUnit;
	}
	public double getSol() {
		return sol;
	}
	public void setSol(double sol) {
		this.sol = sol;
	}
	public int getSolUnit() {
		return solUnit;
	}
	public void setSolUnit(int solUnit) {
		this.solUnit = solUnit;
	}
	public double getSci() {
		return sci;
	}
	public void setSci(double sci) {
		this.sci = sci;
	}
	public int getSciUnit() {
		return sciUnit;
	}
	public void setSciUnit(int sciUnit) {
		this.sciUnit = sciUnit;
	}
	public double getEtc() {
		return etc;
	}
	public void setEtc(double etc) {
		this.etc = etc;
	}
	public int getEtcUnit() {
		return etcUnit;
	}
	public void setEtcUnit(int etcUnit) {
		this.etcUnit = etcUnit;
	}
	
}
