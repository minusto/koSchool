package ko.school.simulation.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.simulation.domain.ChooseDetailCommand;
import ko.school.simulation.domain.EntranceInfoVO;
import ko.school.simulation.domain.ExtraPointVO;
import ko.school.simulation.domain.MajorVO;
import ko.school.simulation.domain.MockTestMaxStandardScore;
import ko.school.simulation.domain.ReflectionRatePerSATAreaVO;
import ko.school.simulation.domain.ReflectionRateVO;
import ko.school.simulation.domain.ResearchSubjectMaxScore;
import ko.school.simulation.domain.SATScoreGrade;
import ko.school.simulation.domain.SATScoreVO;
import ko.school.simulation.domain.StudentConvertDTO;
import ko.school.simulation.domain.StudentMockScoreDetail;
import ko.school.simulation.domain.UniversitySATDetail;
import ko.school.simulation.domain.UniversitySATInfoDTO;
import ko.school.simulation.domain.UniversityVO;
import ko.school.simulation.persistence.UniversityDAO;

@Service
public class UniversityServiceImpl implements UniversityService {
	@Inject
	private UniversityDAO dao;

	public List<UniversityVO> universityListService() {
		return dao.universityList();
	}

	@Override
	public List<MajorVO> majorListService() {
		return dao.majorList();
	}

	@Override
	public void insertReflectionRate(ReflectionRateVO reflectRateVO) {
		dao.insertReflectionRate(reflectRateVO);
	}

	@Override
	public void insertExtraPoint(ExtraPointVO extraPointVO) {
		dao.insertExtraPoint(extraPointVO);
	}

	@Override
	public void insertEntranceInfo(EntranceInfoVO entranceInfoVO) {
		dao.insertEntranceInfo(entranceInfoVO);
	}

	@Override
	public void insertReflectionRatePerSATArea(ReflectionRatePerSATAreaVO rrp) {
		dao.insertReflectionRatePerSATArea(rrp);
	}

	@Override
	public void insertSATScore(SATScoreVO satScoreVO) {
		dao.insertSATScore(satScoreVO);
	}

	@Override
	public List<ExtraPointVO> extraPointList() {
		return dao.extraPointList();
	}

	@Override
	public List<ReflectionRatePerSATAreaVO> reflectionRatePerSATAreaList() {
		return dao.reflectionRatePerSATAreaList();
	}

	@Override
	public List<ReflectionRateVO> reflectionRateList() {
		return dao.reflectionRateList();
	}
	
	@Override
	public List<MajorVO> universityMajorList(String universityId) {
		return dao.universityMajorList(universityId);
	}
	
	//대학 정시 DETAIL
	@Override
	public UniversitySATDetail universitySATDetail(Map<String, String> map) {
		return dao.universitySATDetail(map);
	}
	//학생이본 가장 최근의 모의고사 모든 정보 가져오기
	@Override
	public StudentMockScoreDetail studentMockScoreDetail(Map<String, String> map) {
		return dao.studentMockScoreDetail(map);
	}
	//모의고사 과목별 최고 표준점수 가져오기
	@Override
	public MockTestMaxStandardScore mockTestMaxStandardScore(Map<String, String> map) {
		return dao.mockTestMaxStandardScore(map);
	}
	//모의고사 탐구영역 최고 표준점수 가져오기
	@Override
	public ResearchSubjectMaxScore researchSubjectMaxScore(Map<String, String> map) {
		return dao.researchSubjectMaxScore(map);
	}

	//선택한 대학교명, 학과명, 모집구분(수시,가군,나군,다군) 뽑아오기
	@Override
	public UniversitySATInfoDTO universitySATInfo(ChooseDetailCommand chooseDetail) {
		return dao.universitySATInfo(chooseDetail);
	}
	
	//-------------------------------------------------------------
	//자기 점수에 맞는 등급을 뿌려줌
	public SATScoreGrade satScoreGrade(ChooseDetailCommand chooseDetail){
		Map<String, String> map = new HashMap<String, String>();
		map.put("universityId", chooseDetail.getUniversityId());
		map.put("majorId", chooseDetail.getMajorId());
		map.put("recruitSeparate", chooseDetail.getRecruitSeparate());
		map.put("studentId", chooseDetail.getMemberId());
		SATScoreGrade satScoreGrade=new SATScoreGrade();
		
		StudentMockScoreDetail smsd=dao.studentMockScoreDetail(map);
		
		satScoreGrade.setKorGrade(gradeCalculate(smsd.getLanguagePercentile()));
		satScoreGrade.setMatGrade(gradeCalculate(smsd.getMathpercentile()));
		satScoreGrade.setEngGrade(gradeCalculate(smsd.getEnglishpercentile()));
		satScoreGrade.setResearch1Grade(gradeCalculate(smsd.getResearchSubjectPercentile1()));
		satScoreGrade.setResearch2Grade(gradeCalculate(smsd.getResearchSubjectPercentile2()));
		satScoreGrade.setKoreaHistoryGrade(gradeCalculate(smsd.getKoreaHistoryPercentile()));
		satScoreGrade.setSecondLanguageGrade(gradeCalculate(smsd.getSecondLanguagePercentile()));
		
		
		return satScoreGrade;
	}
	
	//등급계산 메소드
	public int gradeCalculate(double score){
		int result=0;
		
		if(score>=96){
			result=1;
		}else if(score>=89&&score<96){
			result=2;
		}else if(score>=77&&score<89){
			result=3;
		}else if(score>=60&&score<77){
			result=4;
		}else if(score>=40&&score<60){
			result=5;
		}else if(score>=23&&score<40){
			result=6;
		}else if(score>=11&&score<23){
			result=7;
		}else if(score>=4&&score<11){
			result=8;
		}else if(score>=0.1&&score<4){
			result=9;
		}else{
			result=0;
		}
		return result;
	}
	
	/*
	언+수+외+탐(2)
	언+수+외+탐(1)
	언+수+외[택2]+탐(2)
	언+수+외[택2]+탐(1)
	언+수+외[택1]+탐(2)
	언+수+외[택1]+탐(1)
	*/
	
	//---------------------------시뮬레이션  연산-------------------------
	public StudentConvertDTO simulationCalculation(ChooseDetailCommand chooseDetail){
		Map<String, String> map = new HashMap<String, String>();
		map.put("universityId", chooseDetail.getUniversityId());
		map.put("majorId", chooseDetail.getMajorId());
		map.put("recruitSeparate", chooseDetail.getRecruitSeparate());
		map.put("studentId", chooseDetail.getMemberId());
		map.put("mockId", dao.recentMockId(chooseDetail.getMemberId()));

		UniversitySATDetail satDetail=dao.universitySATDetail(map);
		
		StudentMockScoreDetail smsd=dao.studentMockScoreDetail(map);
		
		MockTestMaxStandardScore maxScore=dao.mockTestMaxStandardScore(map);
		
		//대학 입시요강과 비교한 연산결과가 담기는 객체
		StudentConvertDTO studentConvert=new StudentConvertDTO();
		String scoreUseIndex = satDetail.getSatScoreUseIndex();
		switch (scoreUseIndex) {
		// 메소드호출(파라미터에 최신점수 객체를 던짐)
		case "단순합계":
			studentConvert = simpleSum(smsd,studentConvert);
			break;
		case "표준점수":
			studentConvert = universitySum(smsd,satDetail,maxScore,studentConvert);
			break;
		case "변환표준점수":
			studentConvert = universityConvertSum(smsd,satDetail,maxScore,studentConvert);
			break;
		case "백분위":
			studentConvert = universityPercentileSum(smsd,satDetail,maxScore,studentConvert);
			break;
		}
		return studentConvert;
	}



	// 1.단수합산 메소드
	public StudentConvertDTO simpleSum(StudentMockScoreDetail smsd, StudentConvertDTO studentConvert) {
		// return 국어표준점수 + 영어표준점수 + 수리표준점수 + 탐구표준점수
		double result=smsd.getLanguageStandardScore()+smsd.getEnglishStandardScore()+smsd.getMathStandardScore()+smsd.getResearchSubjectStandardScore1()+smsd.getResearchSubjectStandardScore2();
		studentConvert.setMathType(smsd.getMathType());
		if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
			//A ==> 사회탐구
			studentConvert.setResearchType("사회탐구");			
		}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
			//B ==> 과학탐구
			studentConvert.setResearchType("과학탐구");			
		}
		studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
		studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));

		studentConvert.setKorConverScore(smsd.getLanguageStandardScore());
		studentConvert.setMatConverScore(smsd.getMathStandardScore());
		studentConvert.setEngConverScore(smsd.getEnglishStandardScore());
		studentConvert.setResearch1ConverScore(smsd.getResearchSubjectStandardScore1());
		studentConvert.setResearch2ConverScore(smsd.getResearchSubjectStandardScore2());
		studentConvert.setTotalConverScore(result);
		
		return studentConvert;
	}
	// 2.대학별 과목비율에 따른 표준점수합
	public StudentConvertDTO universitySum(StudentMockScoreDetail smsd, UniversitySATDetail satDetail, MockTestMaxStandardScore maxScore, StudentConvertDTO studentConvert) {
		List<Double> mainList=new ArrayList<>();

		double korStandard=0;
		double matStandard=0;
		double engStandard=0;
		double research1Standard=0;
		double research2Standard=0;

		String whgkq = satDetail.getSelectCombination(); // 삭제
		double result = 0;
		switch (whgkq) { // 학과정보가 다 담겨있는 큰~객체에서 선택조합 get
		case "언+수+외+탐(2)":
			korStandard=calculation(smsd.getLanguageStandardScore(),satDetail.getKoreanReflectionRate()/100,satDetail.getConvertScoreMax(),200);

			if(smsd.getMathType().equals("수리 가")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);				
			}
			
			engStandard=calculation(smsd.getEnglishStandardScore(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				studentConvert.setResearchType("사회탐구");	
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				studentConvert.setResearchType("과학탐구");	
			}
			
			result=korStandard+matStandard+engStandard+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);

			studentConvert.setMathType(smsd.getMathType());			
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setKorConverScore(korStandard);
			studentConvert.setMatConverScore(matStandard);
			studentConvert.setEngConverScore(engStandard);
			studentConvert.setResearch1ConverScore(research1Standard);
			studentConvert.setResearch2ConverScore(research2Standard);
			studentConvert.setTotalConverScore(result);
			
			break;

		case "언+수+외+탐(1)":
			korStandard=calculation(smsd.getLanguageStandardScore(),satDetail.getKoreanReflectionRate()/100,satDetail.getConvertScoreMax(),200);

			if(smsd.getMathType().equals("수리 가")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);				
			}
			
			engStandard=calculation(smsd.getEnglishStandardScore(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				studentConvert.setResearchType("사회탐구");	
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				studentConvert.setResearchType("과학탐구");	
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}
			
			result=korStandard+matStandard+engStandard+research1Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			
			studentConvert.setMathType(smsd.getMathType());
			
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setKorConverScore(korStandard);
			studentConvert.setMatConverScore(matStandard);
			studentConvert.setEngConverScore(engStandard);
			studentConvert.setResearch1ConverScore(research1Standard);
			studentConvert.setTotalConverScore(result);
			
			break;

		case "언+수+외[택2]+탐(2)":
			korStandard=calculation(smsd.getLanguageStandardScore(),satDetail.getKoreanReflectionRate()/100,satDetail.getConvertScoreMax(),200);

			if(smsd.getMathType().equals("수리 가")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);				
			}
			
			engStandard=calculation(smsd.getEnglishStandardScore(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				studentConvert.setResearchType("사회탐구");
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				studentConvert.setResearchType("과학탐구");
			}

			
			mainList.add(matStandard);
			mainList.add(korStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);
		

			result+=mainList.get(2)+mainList.get(1)+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			
			for(int i=1;i<mainList.size();i++){
				if(mainList.get(i)==korStandard){
					studentConvert.setKorConverScore(korStandard);
				}else if(mainList.get(i)==matStandard){
					studentConvert.setMatConverScore(matStandard);
				}else if(mainList.get(i)==engStandard){
					studentConvert.setEngConverScore(engStandard);
				}
			}
			studentConvert.setMathType(smsd.getMathType());
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setResearch1ConverScore(research1Standard);
			studentConvert.setResearch2ConverScore(research2Standard);
			studentConvert.setTotalConverScore(result);
			
			break;
		
			
		case "언+수+외[택2]+탐(1)":
			korStandard=calculation(smsd.getLanguageStandardScore(),satDetail.getKoreanReflectionRate()/100,satDetail.getConvertScoreMax(),200);

			if(smsd.getMathType().equals("수리 가")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);				
			}
			
			engStandard=calculation(smsd.getEnglishStandardScore(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				studentConvert.setResearchType("사회탐구");
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				studentConvert.setResearchType("과학탐구");
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}
			
			mainList.add(matStandard);
			mainList.add(korStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);

			result+=mainList.get(2)+mainList.get(1)+research1Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
		
			for(int i=1;i<mainList.size();i++){
				if(mainList.get(i)==korStandard){
					studentConvert.setKorConverScore(korStandard);
				}else if(mainList.get(i)==matStandard){
					studentConvert.setMatConverScore(matStandard);
				}else if(mainList.get(i)==engStandard){
					studentConvert.setEngConverScore(engStandard);
				}
			}
			studentConvert.setMathType(smsd.getMathType());
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setResearch1ConverScore(research1Standard);
			
			studentConvert.setTotalConverScore(result);
			
			
			break;
			

		case "언+수+외[택1]+탐(2)":
			korStandard=calculation(smsd.getLanguageStandardScore(),satDetail.getKoreanReflectionRate()/100,satDetail.getConvertScoreMax(),200);

			if(smsd.getMathType().equals("수리 가")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);				
			}
			
			engStandard=calculation(smsd.getEnglishStandardScore(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				studentConvert.setResearchType("사회탐구");
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				studentConvert.setResearchType("과학탐구");
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}
			
			mainList.add(matStandard);
			mainList.add(korStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);
		
			result+=mainList.get(2)+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			
			for(int i=2;i<mainList.size();i++){
				if(mainList.get(i)==korStandard){
					studentConvert.setKorConverScore(korStandard);
				}else if(mainList.get(i)==matStandard){
					studentConvert.setMatConverScore(matStandard);
				}else if(mainList.get(i)==engStandard){
					studentConvert.setEngConverScore(engStandard);
				}
			}
			studentConvert.setMathType(smsd.getMathType());
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setResearch1ConverScore(research1Standard);
			studentConvert.setResearch2ConverScore(research2Standard);			
			studentConvert.setTotalConverScore(result);
			
			
			
			
			break;
			
		
		case "언+수+외[택1]+탐(1)":
			korStandard=calculation(smsd.getLanguageStandardScore(),satDetail.getKoreanReflectionRate()/100,satDetail.getConvertScoreMax(),200);

			if(smsd.getMathType().equals("수리 가")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);				
			}
			
			engStandard=calculation(smsd.getEnglishStandardScore(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				studentConvert.setResearchType("사회탐구");
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				studentConvert.setResearchType("과학탐구");
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}
	
			mainList.add(matStandard);
			mainList.add(korStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);
			
			result+=mainList.get(2)+research1Standard;

			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			
			for(int i=2;i<mainList.size();i++){
				if(mainList.get(i)==korStandard){
					studentConvert.setKorConverScore(korStandard);
				}else if(mainList.get(i)==matStandard){
					studentConvert.setMatConverScore(matStandard);
				}else if(mainList.get(i)==engStandard){
					studentConvert.setEngConverScore(engStandard);
				}
			}
			studentConvert.setMathType(smsd.getMathType());
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setResearch1ConverScore(research1Standard);		
			studentConvert.setTotalConverScore(result);
			
			
			
			
			break;
		}
		return studentConvert;
	}



	// 3.변환표준점수
	public StudentConvertDTO universityConvertSum(StudentMockScoreDetail smsd, UniversitySATDetail satDetail, MockTestMaxStandardScore maxScore, StudentConvertDTO studentConvert) {
		List<Double> mainList=new ArrayList<>();
		Map<String, String> map=new HashMap<String, String>();
		ResearchSubjectMaxScore research=null;
		double korStandard=0;
		double matStandard=0;
		double engStandard=0;
		double research1Standard=0;
		double research2Standard=0;
		String whgkq = satDetail.getSelectCombination();//언+수+외[택2]+탐(2), 언+수+외+탐(1), 언+수+외[택2]+탐(1),언+수+외[택1]+탐(2),언+수+외[택1]+탐(1)
		double result = 0;
		switch (whgkq) {
		case "언+수+외+탐(2)":
			korStandard = calculation(smsd.getLanguageStandardScore(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getKoreanMaxScore());
			
			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathStandardScore(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getMathBTypeMaxScore());		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathStandardScore(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getMathATypeMaxScore());
			}
			
			engStandard=calculation(smsd.getEnglishStandardScore(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getEnglishMaxScore());
	
			map.put("research1", smsd.getResearchSubjectId1()+"maxscore");
			map.put("research2", smsd.getResearchSubjectId2()+"maxscore");
			map.put("mockId", "mock024");
			
			research=dao.researchSubjectMaxScore(map);
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				studentConvert.setResearchType("사회탐구");	
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				studentConvert.setResearchType("과학탐구");	
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
			}
		
			result+=korStandard+matStandard+engStandard+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			
			studentConvert.setMathType(smsd.getMathType());
			
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setKorConverScore(korStandard);
			studentConvert.setMatConverScore(matStandard);
			studentConvert.setEngConverScore(engStandard);
			studentConvert.setResearch1ConverScore(research1Standard);
			studentConvert.setResearch2ConverScore(research2Standard);
			studentConvert.setTotalConverScore(result);

			
			
			break;

		case "언+수+외+탐(1)":
			korStandard = calculation(smsd.getLanguageStandardScore(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getKoreanMaxScore());
			
			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathStandardScore(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getMathBTypeMaxScore());		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathStandardScore(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getMathATypeMaxScore());
			}
			
			engStandard=calculation(smsd.getEnglishStandardScore(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getEnglishMaxScore());
			
			map.put("research1", smsd.getResearchSubjectId1()+"maxscore");
			map.put("research2", smsd.getResearchSubjectId2()+"maxscore");
			map.put("mockId", "mock024");
			research=dao.researchSubjectMaxScore(map);
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				studentConvert.setResearchType("사회탐구");	
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				studentConvert.setResearchType("과학탐구");	
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}

			result+=korStandard+matStandard+engStandard+research1Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			
			studentConvert.setMathType(smsd.getMathType());
			
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setKorConverScore(korStandard);
			studentConvert.setMatConverScore(matStandard);
			studentConvert.setEngConverScore(engStandard);
			studentConvert.setResearch1ConverScore(research1Standard);
			studentConvert.setTotalConverScore(result);

			
			
			break;

		case "언+수+외[택2]+탐(2)":

			korStandard = calculation(smsd.getLanguageStandardScore(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getKoreanMaxScore());
			
			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathStandardScore(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getMathBTypeMaxScore());		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathStandardScore(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getMathATypeMaxScore());
			}
			
			engStandard=calculation(smsd.getEnglishStandardScore(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getEnglishMaxScore());
	
			map.put("research1", smsd.getResearchSubjectId1()+"maxscore");
			map.put("research2", smsd.getResearchSubjectId2()+"maxscore");
			map.put("mockId", "mock024");
			research=dao.researchSubjectMaxScore(map);
		
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				studentConvert.setResearchType("사회탐구");	
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				studentConvert.setResearchType("과학탐구");	
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
			}

			mainList.add(matStandard);
			mainList.add(korStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);
				
			result+=mainList.get(2)+mainList.get(1)+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			
			
			for(int i=1;i<mainList.size();i++){
				if(mainList.get(i)==korStandard){
					studentConvert.setKorConverScore(korStandard);
				}else if(mainList.get(i)==matStandard){
					studentConvert.setMatConverScore(matStandard);
				}else if(mainList.get(i)==engStandard){
					studentConvert.setEngConverScore(engStandard);
				}
			}
			studentConvert.setMathType(smsd.getMathType());
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setResearch1ConverScore(research1Standard);		
			studentConvert.setResearch2ConverScore(research2Standard);		
			studentConvert.setTotalConverScore(result);
			
			break;
		
		case "언+수+외[택2]+탐(1)":
			
			korStandard = calculation(smsd.getLanguageStandardScore(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getKoreanMaxScore());
			
			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathStandardScore(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getMathBTypeMaxScore());		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathStandardScore(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getMathATypeMaxScore());
			}
			
			engStandard=calculation(smsd.getEnglishStandardScore(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getEnglishMaxScore());
			
			map.put("research1", smsd.getResearchSubjectId1()+"maxscore");
			map.put("research2", smsd.getResearchSubjectId2()+"maxscore");
			map.put("mockId", "mock024");
			research=dao.researchSubjectMaxScore(map);
					
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				studentConvert.setResearchType("사회탐구");	
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				studentConvert.setResearchType("과학탐구");	
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}

			mainList.add(matStandard);
			mainList.add(korStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);
				
			result+=mainList.get(2)+mainList.get(1)+research1Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			
			for(int i=1;i<mainList.size();i++){
				if(mainList.get(i)==korStandard){
					studentConvert.setKorConverScore(korStandard);
				}else if(mainList.get(i)==matStandard){
					studentConvert.setMatConverScore(matStandard);
				}else if(mainList.get(i)==engStandard){
					studentConvert.setEngConverScore(engStandard);
				}
			}
			studentConvert.setMathType(smsd.getMathType());
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setResearch1ConverScore(research1Standard);		
			studentConvert.setTotalConverScore(result);
			
			break;
			
		case "언+수+외[택1]+탐(2)":

			korStandard = calculation(smsd.getLanguageStandardScore(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getKoreanMaxScore());
			
			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathStandardScore(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getMathBTypeMaxScore());		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathStandardScore(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getMathATypeMaxScore());
			}
			
			engStandard=calculation(smsd.getEnglishStandardScore(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getEnglishMaxScore());

			map.put("research1", smsd.getResearchSubjectId1()+"maxscore");
			map.put("research2", smsd.getResearchSubjectId2()+"maxscore");
			map.put("mockId", "mock024");
			
			research=dao.researchSubjectMaxScore(map);
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
				studentConvert.setResearchType("사회탐구");	
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
				studentConvert.setResearchType("과학탐구");	
			}
			
			mainList.add(matStandard);
			mainList.add(korStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);

			result+=mainList.get(2)+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);	
			
			for(int i=2;i<mainList.size();i++){
				if(mainList.get(i)==korStandard){
					studentConvert.setKorConverScore(korStandard);
				}else if(mainList.get(i)==matStandard){
					studentConvert.setMatConverScore(matStandard);
				}else if(mainList.get(i)==engStandard){
					studentConvert.setEngConverScore(engStandard);
				}
			}
			studentConvert.setMathType(smsd.getMathType());
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setResearch1ConverScore(research1Standard);		
			studentConvert.setResearch2ConverScore(research2Standard);		
			studentConvert.setTotalConverScore(result);
			
			break;
		case "언+수+외[택1]+탐(1)":
			
			korStandard = calculation(smsd.getLanguageStandardScore(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getKoreanMaxScore());
			
			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathStandardScore(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getMathBTypeMaxScore());		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathStandardScore(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getMathATypeMaxScore());
			}
			
			engStandard=calculation(smsd.getEnglishStandardScore(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), maxScore.getEnglishMaxScore());

			map.put("research1", smsd.getResearchSubjectId1()+"maxscore");
			map.put("research2", smsd.getResearchSubjectId2()+"maxscore");
			map.put("mockId", "mock024");
			research=dao.researchSubjectMaxScore(map);
		
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				studentConvert.setResearchType("사회탐구");	
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				studentConvert.setResearchType("과학탐구");	
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}
			
			mainList.add(matStandard);
			mainList.add(korStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);
			
			result+=mainList.get(2)+research1Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);	
				
			
			for(int i=2;i<mainList.size();i++){
				if(mainList.get(i)==korStandard){
					studentConvert.setKorConverScore(korStandard);
				}else if(mainList.get(i)==matStandard){
					studentConvert.setMatConverScore(matStandard);
				}else if(mainList.get(i)==engStandard){
					studentConvert.setEngConverScore(engStandard);
				}
			}
			studentConvert.setMathType(smsd.getMathType());
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setResearch1ConverScore(research1Standard);		
			studentConvert.setTotalConverScore(result);
			
			
			
			
			break;
		}
		return studentConvert;
	}

/*	//표준점수 + 변환표준점수 계산 메소드
	private double calculation(int score, double rate, double convertScoreMax, int standardMaxScore) {
		double result=((score*rate)*convertScoreMax)/standardMaxScore;
		return result;
	}*/
	
	
/*	// 점수 계산 메소드(파라미터 4개 필요)
	public double calculation() {
		// return 나의점수 * 비율(소수) * 환산점수총점 / 표준점수의 최고점
		return 0;
	}*/
	
	// 4. 백분위 합산 
	private StudentConvertDTO universityPercentileSum(StudentMockScoreDetail smsd, UniversitySATDetail satDetail, MockTestMaxStandardScore maxScore, StudentConvertDTO studentConvert) {
		List<Double> mainList=new ArrayList<>();

		double korStandard=0;
		double matStandard=0;
		double engStandard=0;
		double research1Standard=0;
		double research2Standard=0;
		String whgkq = satDetail.getSelectCombination(); // 삭제 //언+수+외+탐(2) ,언+수+외+탐(1)
		double result = 0;
		switch (whgkq) { // 학과정보가 다 담겨있는 큰~객체에서 선택조합 get
			
		case "언+수+외+탐(2)":
			korStandard=calculation(smsd.getLanguagePercentile(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			engStandard=calculation(smsd.getEnglishpercentile(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 100);

			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100); 		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			}
			
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				studentConvert.setResearchType("사회탐구");	
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				studentConvert.setResearchType("과학탐구");	
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}
			
			result=korStandard+matStandard+engStandard+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			
			
			studentConvert.setMathType(smsd.getMathType());
			
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setKorConverScore(korStandard);
			studentConvert.setMatConverScore(matStandard);
			studentConvert.setEngConverScore(engStandard);
			studentConvert.setResearch1ConverScore(research1Standard);
			studentConvert.setResearch2ConverScore(research2Standard);
			studentConvert.setTotalConverScore(result);

			
			
			break;
			
		case "언+수+외+탐(1)":
			korStandard=calculation(smsd.getLanguagePercentile(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			engStandard=calculation(smsd.getEnglishpercentile(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 100);

			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100); 		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			}
			
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				studentConvert.setResearchType("사회탐구");	
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				studentConvert.setResearchType("과학탐구");	
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}
			
			result=korStandard+matStandard+engStandard+research1Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			
			
			studentConvert.setMathType(smsd.getMathType());
			
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setKorConverScore(korStandard);
			studentConvert.setMatConverScore(matStandard);
			studentConvert.setEngConverScore(engStandard);
			studentConvert.setResearch1ConverScore(research1Standard);
			studentConvert.setTotalConverScore(result);

			
			
			
			break;
	
		case "언+수+외[택2]+탐(2)":

			korStandard=calculation(smsd.getLanguagePercentile(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			engStandard=calculation(smsd.getEnglishpercentile(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 100);

			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100); 		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			}
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				studentConvert.setResearchType("사회탐구");	
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				studentConvert.setResearchType("과학탐구");	
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}
			mainList.add(korStandard);
			mainList.add(matStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);
			
			result=mainList.get(2)+mainList.get(1)+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			
			for(int i=1;i<mainList.size();i++){
				if(mainList.get(i)==korStandard){
					studentConvert.setKorConverScore(korStandard);
				}else if(mainList.get(i)==matStandard){
					studentConvert.setMatConverScore(matStandard);
				}else if(mainList.get(i)==engStandard){
					studentConvert.setEngConverScore(engStandard);
				}
			}
			studentConvert.setMathType(smsd.getMathType());
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setResearch1ConverScore(research1Standard);		
			studentConvert.setResearch2ConverScore(research2Standard);		
			studentConvert.setTotalConverScore(result);
			
			
			
			break;
			
		case "언+수+외[택2]+탐(1)":

			korStandard=calculation(smsd.getLanguagePercentile(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			engStandard=calculation(smsd.getEnglishpercentile(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 100);

			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100); 		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			}
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				studentConvert.setResearchType("사회탐구");	
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				studentConvert.setResearchType("과학탐구");	
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}
			mainList.add(korStandard);
			mainList.add(matStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);
			
			result=mainList.get(2)+mainList.get(1)+research1Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			
			for(int i=1;i<mainList.size();i++){
				if(mainList.get(i)==korStandard){
					studentConvert.setKorConverScore(korStandard);
				}else if(mainList.get(i)==matStandard){
					studentConvert.setMatConverScore(matStandard);
				}else if(mainList.get(i)==engStandard){
					studentConvert.setEngConverScore(engStandard);
				}
			}
			studentConvert.setMathType(smsd.getMathType());
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setResearch1ConverScore(research1Standard);			
			studentConvert.setTotalConverScore(result);
			
			
			break;
			
		case "언+수+외[택1]+탐(2)":

			korStandard=calculation(smsd.getLanguagePercentile(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			engStandard=calculation(smsd.getEnglishpercentile(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 100);

			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100); 		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			}
			
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				studentConvert.setResearchType("사회탐구");	
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				studentConvert.setResearchType("과학탐구");	
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}
			mainList.add(korStandard);
			mainList.add(matStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);
			
			result=mainList.get(2)+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			
			for(int i=2;i<mainList.size();i++){
				if(mainList.get(i)==korStandard){
					studentConvert.setKorConverScore(korStandard);
				}else if(mainList.get(i)==matStandard){
					studentConvert.setMatConverScore(matStandard);
				}else if(mainList.get(i)==engStandard){
					studentConvert.setEngConverScore(engStandard);
				}
			}
			studentConvert.setMathType(smsd.getMathType());
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setResearch1ConverScore(research1Standard);		
			studentConvert.setResearch2ConverScore(research2Standard);		
			studentConvert.setTotalConverScore(result);
			
			
			
			break;
			
		case "언+수+외[택1]+탐(1)":

			korStandard=calculation(smsd.getLanguagePercentile(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			engStandard=calculation(smsd.getEnglishpercentile(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 100);

			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100); 		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			}
			
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				studentConvert.setResearchType("사회탐구");	
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				studentConvert.setResearchType("과학탐구");	
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}
			mainList.add(korStandard);
			mainList.add(matStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);
			
			result=mainList.get(2)+research1Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			
			for(int i=2;i<mainList.size();i++){
				if(mainList.get(i)==korStandard){
					studentConvert.setKorConverScore(korStandard);
				}else if(mainList.get(i)==matStandard){
					studentConvert.setMatConverScore(matStandard);
				}else if(mainList.get(i)==engStandard){
					studentConvert.setEngConverScore(engStandard);
				}
			}
			studentConvert.setMathType(smsd.getMathType());
			studentConvert.setResearch1Name(dao.researchSubjectName(smsd.getResearchSubjectId1()));
			studentConvert.setResearch2Name(dao.researchSubjectName(smsd.getResearchSubjectId2()));
			studentConvert.setResearch1ConverScore(research1Standard);			
			studentConvert.setTotalConverScore(result);
			
			break;
		}
		return studentConvert;
	}
	
	
	//나의 점수, 해당 과목 반영비율, 변환점수만점, score의 만점
	//백분위 합산 메소드
	private double calculation(double score, double rate, double convertScoreMax, int standardMaxScore) {
		double result=((score*rate)*convertScoreMax)/standardMaxScore;
		return result;
	}
	
	//표준점수 + 변환표준점수 계산 메소드
	private double calculation(int score, double rate, double convertScoreMax, int standardMaxScore) {
		double result=((score*rate)*convertScoreMax)/standardMaxScore;
		return result;
	}
	
	
	//영역별 최종값중 0이 있으면 환산불가
	private double socreList(double korStandard,double matStandard,double engStandard,double research1Standard,double research2Standard,double result){
		List<Double> scoreList=new ArrayList<>();
		scoreList.add(korStandard);
		scoreList.add(matStandard);
		scoreList.add(engStandard);
		scoreList.add(research1Standard);
		scoreList.add(research2Standard);
		for(int i = 0;i<scoreList.size();i++){
			if(scoreList.get(i)==0){
				result=0;
				break;
			}
		}
		return result;
	}




}
