package ko.school.simulation.domain;

public class UniversitySATDetail {
	//대학 학과별 입시정보 (Entrance)
	private String majorId;
	private String universityId;
	private int entranceYear;
	private String recruitSeparate;
	private String hangooksaReflectionPlan;
	private int recruitNum;
	private String recruitModelType;
	private String reflectionRateId;
	private String schoolReportReflectionRateId;
	private String satReflectionRateId;
	private String extraPointId;
	//반영비율 (ReflectionRate)
	private double satReflectionRate;
	private double schoolReportReflectionRate;
	private double practiceReflectionRate;
	private double interviewReflectionRate;
	private double essayReflectionRate;
	private double aptitudeReflectionRate;
	private double etcReflectionRate;
	private String etcContent;
	private int modelSum;
	//가산점 (ExtraPoint)
	private double koreanExtraRate;
	private double mathBTypeExtraRate;
	private double socialResearchExtraRate;
	private double scienceResearchExtraRate;
	//수능 영역별 반영비율 (ReflectionRatePerSATArea)
	private double koreanReflectionRate;
	private double mathBTypeReflectionRate;
	private double mathATypeReflectionRate;
	private double englishReflectionRate;
	private double socialReflectionRate;
	private double scienceReflectionRate;
	private String selectCombination;
	private int researchSubjectNum;
	//정시점수 (SAT Score)
	private double standardScoreCutline;
	private double totalPercentile;
	private String satScoreUseIndex;
	private double convertScoreMax;
	private double convertStandardScoreCutline;
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
	public int getEntranceYear() {
		return entranceYear;
	}
	public void setEntranceYear(int entranceYear) {
		this.entranceYear = entranceYear;
	}
	public String getRecruitSeparate() {
		return recruitSeparate;
	}
	public void setRecruitSeparate(String recruitSeparate) {
		this.recruitSeparate = recruitSeparate;
	}
	public String getHangooksaReflectionPlan() {
		return hangooksaReflectionPlan;
	}
	public void setHangooksaReflectionPlan(String hangooksaReflectionPlan) {
		this.hangooksaReflectionPlan = hangooksaReflectionPlan;
	}
	public int getRecruitNum() {
		return recruitNum;
	}
	public void setRecruitNum(int recruitNum) {
		this.recruitNum = recruitNum;
	}
	public String getRecruitModelType() {
		return recruitModelType;
	}
	public void setRecruitModelType(String recruitModelType) {
		this.recruitModelType = recruitModelType;
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
	public String getSatReflectionRateId() {
		return satReflectionRateId;
	}
	public void setSatReflectionRateId(String satReflectionRateId) {
		this.satReflectionRateId = satReflectionRateId;
	}
	public String getExtraPointId() {
		return extraPointId;
	}
	public void setExtraPointId(String extraPointId) {
		this.extraPointId = extraPointId;
	}
	public double getSatReflectionRate() {
		return satReflectionRate;
	}
	public void setSatReflectionRate(double satReflectionRate) {
		this.satReflectionRate = satReflectionRate;
	}
	public double getSchoolReportReflectionRate() {
		return schoolReportReflectionRate;
	}
	public void setSchoolReportReflectionRate(double schoolReportReflectionRate) {
		this.schoolReportReflectionRate = schoolReportReflectionRate;
	}
	public double getPracticeReflectionRate() {
		return practiceReflectionRate;
	}
	public void setPracticeReflectionRate(double practiceReflectionRate) {
		this.practiceReflectionRate = practiceReflectionRate;
	}
	public double getInterviewReflectionRate() {
		return interviewReflectionRate;
	}
	public void setInterviewReflectionRate(double interviewReflectionRate) {
		this.interviewReflectionRate = interviewReflectionRate;
	}
	public double getEssayReflectionRate() {
		return essayReflectionRate;
	}
	public void setEssayReflectionRate(double essayReflectionRate) {
		this.essayReflectionRate = essayReflectionRate;
	}
	public double getAptitudeReflectionRate() {
		return aptitudeReflectionRate;
	}
	public void setAptitudeReflectionRate(double aptitudeReflectionRate) {
		this.aptitudeReflectionRate = aptitudeReflectionRate;
	}
	public double getEtcReflectionRate() {
		return etcReflectionRate;
	}
	public void setEtcReflectionRate(double etcReflectionRate) {
		this.etcReflectionRate = etcReflectionRate;
	}
	public String getEtcContent() {
		return etcContent;
	}
	public void setEtcContent(String etcContent) {
		this.etcContent = etcContent;
	}
	public int getModelSum() {
		return modelSum;
	}
	public void setModelSum(int modelSum) {
		this.modelSum = modelSum;
	}
	public double getKoreanExtraRate() {
		return koreanExtraRate;
	}
	public void setKoreanExtraRate(double koreanExtraRate) {
		this.koreanExtraRate = koreanExtraRate;
	}
	public double getMathBTypeExtraRate() {
		return mathBTypeExtraRate;
	}
	public void setMathBTypeExtraRate(double mathBTypeExtraRate) {
		this.mathBTypeExtraRate = mathBTypeExtraRate;
	}
	public double getSocialResearchExtraRate() {
		return socialResearchExtraRate;
	}
	public void setSocialResearchExtraRate(double socialResearchExtraRate) {
		this.socialResearchExtraRate = socialResearchExtraRate;
	}
	public double getScienceResearchExtraRate() {
		return scienceResearchExtraRate;
	}
	public void setScienceResearchExtraRate(double scienceResearchExtraRate) {
		this.scienceResearchExtraRate = scienceResearchExtraRate;
	}
	public double getKoreanReflectionRate() {
		return koreanReflectionRate;
	}
	public void setKoreanReflectionRate(double koreanReflectionRate) {
		this.koreanReflectionRate = koreanReflectionRate;
	}
	public double getMathBTypeReflectionRate() {
		return mathBTypeReflectionRate;
	}
	public void setMathBTypeReflectionRate(double mathBTypeReflectionRate) {
		this.mathBTypeReflectionRate = mathBTypeReflectionRate;
	}
	public double getMathATypeReflectionRate() {
		return mathATypeReflectionRate;
	}
	public void setMathATypeReflectionRate(double mathATypeReflectionRate) {
		this.mathATypeReflectionRate = mathATypeReflectionRate;
	}
	public double getEnglishReflectionRate() {
		return englishReflectionRate;
	}
	public void setEnglishReflectionRate(double englishReflectionRate) {
		this.englishReflectionRate = englishReflectionRate;
	}
	public double getSocialReflectionRate() {
		return socialReflectionRate;
	}
	public void setSocialReflectionRate(double socialReflectionRate) {
		this.socialReflectionRate = socialReflectionRate;
	}
	public double getScienceReflectionRate() {
		return scienceReflectionRate;
	}
	public void setScienceReflectionRate(double scienceReflectionRate) {
		this.scienceReflectionRate = scienceReflectionRate;
	}
	public String getSelectCombination() {
		return selectCombination;
	}
	public void setSelectCombination(String selectCombination) {
		this.selectCombination = selectCombination;
	}
	public int getResearchSubjectNum() {
		return researchSubjectNum;
	}
	public void setResearchSubjectNum(int researchSubjectNum) {
		this.researchSubjectNum = researchSubjectNum;
	}
	public double getStandardScoreCutline() {
		return standardScoreCutline;
	}
	public void setStandardScoreCutline(double standardScoreCutline) {
		this.standardScoreCutline = standardScoreCutline;
	}
	public double getTotalPercentile() {
		return totalPercentile;
	}
	public void setTotalPercentile(double totalPercentile) {
		this.totalPercentile = totalPercentile;
	}
	public String getSatScoreUseIndex() {
		return satScoreUseIndex;
	}
	public void setSatScoreUseIndex(String satScoreUseIndex) {
		this.satScoreUseIndex = satScoreUseIndex;
	}
	public double getConvertScoreMax() {
		return convertScoreMax;
	}
	public void setConvertScoreMax(double convertScoreMax) {
		this.convertScoreMax = convertScoreMax;
	}
	public double getConvertStandardScoreCutline() {
		return convertStandardScoreCutline;
	}
	public void setConvertStandardScoreCutline(double convertStandardScoreCutline) {
		this.convertStandardScoreCutline = convertStandardScoreCutline;
	}
	
	@Override
	public String toString() {
		return "UniversitySATDetail [majorId=" + majorId + ", universityId=" + universityId + ", entranceYear="
				+ entranceYear + ", recruitSeparate=" + recruitSeparate + ", hangooksaReflectionPlan="
				+ hangooksaReflectionPlan + ", recruitNum=" + recruitNum + ", recruitModelType=" + recruitModelType
				+ ", reflectionRateId=" + reflectionRateId + ", schoolReportReflectionRateId="
				+ schoolReportReflectionRateId + ", satReflectionRateId=" + satReflectionRateId + ", extraPointId="
				+ extraPointId + ", satReflectionRate=" + satReflectionRate + ", schoolReportReflectionRate="
				+ schoolReportReflectionRate + ", practiceReflectionRate=" + practiceReflectionRate
				+ ", interviewReflectionRate=" + interviewReflectionRate + ", essayReflectionRate="
				+ essayReflectionRate + ", aptitudeReflectionRate=" + aptitudeReflectionRate + ", etcReflectionRate="
				+ etcReflectionRate + ", etcContent=" + etcContent + ", modelSum=" + modelSum + ", koreanExtraRate="
				+ koreanExtraRate + ", mathBTypeExtraRate=" + mathBTypeExtraRate + ", socialResearchExtraRate="
				+ socialResearchExtraRate + ", scienceResearchExtraRate=" + scienceResearchExtraRate
				+ ", koreanReflectionRate=" + koreanReflectionRate + ", mathBTypeReflectionRate="
				+ mathBTypeReflectionRate + ", mathATypeReflectionRate=" + mathATypeReflectionRate
				+ ", englishReflectionRate=" + englishReflectionRate + ", socialReflectionRate=" + socialReflectionRate
				+ ", scienceReflectionRate=" + scienceReflectionRate + ", selectCombination=" + selectCombination
				+ ", researchSubjectNum=" + researchSubjectNum + ", standardScoreCutline=" + standardScoreCutline
				+ ", totalPercentile=" + totalPercentile + ", satScoreUseIndex=" + satScoreUseIndex
				+ ", convertScoreMax=" + convertScoreMax + ", convertStandardScoreCutline="
				+ convertStandardScoreCutline + "]";
	}
	
}
