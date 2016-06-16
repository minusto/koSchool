package ko.school.simulation.domain;

public class MockSimulationDTO {
	//University
	private String universityId;
	private String universityName;
	private String campusName;
	private String universityLocal;
	private String universityURL;
	private String universityMark;
	
	//Major
	private String majorId;
	private String majorName;
	private String kind;
	private String college;
	
	//ReflectionRate
	private String reflectionRateId;
	private double satReflectionRate;
	private double schoolReportReflectionRate;
	private double practiceReflectionRate;
	private double interviewReflectionRate;
	private double essayReflectionRate;
	private double aptitudeReflectionRate;
	private double etcReflectionRate;
	private String etcContent;
	private int modelSum;
	
	//ExtraPoint
	private String extraPointId;
	private double koreanExtraRate;
	private double mathBTypeExtraRate;
	private double socialResearchExtraRate;
	private double scienceResearchExtraRate;
	
	//ReflectionRatePerSATArea
	private String satReflectionRateId;
	private double koreanReflectionRate;
	private double mathBTypeReflectionRate;
	private double mathATypeReflectionRate;
	private double englishReflectionRate;
	private double socialReflectionRate;
	private double scienceReflectionRate;
	private String selectCombination;
	private int researchSubjectNum;
	
	//EntranceInfo
	//private String majorId;
	//private String universityId;
	private int entranceYear;
	private String recruitSeparate;
	private String hangooksaReflectionPlan;
	private int recruitNum;
	private String recruitModelType;
	//private String reflectionRateId;
	private String schoolReportReflectionRateId;
	//private String satReflectionRateId;
	//private String extraPointId;
	
	//SATScore
	//private String majorId;
	//private String universityId;
	//private int entranceYear;
	//private String recruitSeparate;
	private double standardScoreCutline;
	private double totalPercentile;
	private String satScoreUseIndex;
	private double convertScoreMax;
	private double convertStandardScoreCutline;
	
	
	public String getUniversityId() {
		return universityId;
	}
	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}
	public String getUniversityName() {
		return universityName;
	}
	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public String getCampusName() {
		return campusName;
	}
	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
	public String getUniversityLocal() {
		return universityLocal;
	}
	public void setUniversityLocal(String universityLocal) {
		this.universityLocal = universityLocal;
	}
	public String getUniversityURL() {
		return universityURL;
	}
	public void setUniversityURL(String universityURL) {
		this.universityURL = universityURL;
	}
	public String getUniversityMark() {
		return universityMark;
	}
	public void setUniversityMark(String universityMark) {
		this.universityMark = universityMark;
	}
	public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
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
	public String getReflectionRateId() {
		return reflectionRateId;
	}
	public void setReflectionRateId(String reflectionRateId) {
		this.reflectionRateId = reflectionRateId;
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
	public String getExtraPointId() {
		return extraPointId;
	}
	public void setExtraPointId(String extraPointId) {
		this.extraPointId = extraPointId;
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
	public String getSatReflectionRateId() {
		return satReflectionRateId;
	}
	public void setSatReflectionRateId(String satReflectionRateId) {
		this.satReflectionRateId = satReflectionRateId;
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
	public String getSchoolReportReflectionRateId() {
		return schoolReportReflectionRateId;
	}
	public void setSchoolReportReflectionRateId(String schoolReportReflectionRateId) {
		this.schoolReportReflectionRateId = schoolReportReflectionRateId;
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
	
}
