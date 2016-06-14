package ko.school.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ko.school.simulation.domain.MockTestMaxStandardScore;
import ko.school.simulation.domain.ResearchSubjectMaxScore;
import ko.school.simulation.domain.StudentMockScoreDetail;
import ko.school.simulation.domain.UniversitySATDetail;
import ko.school.simulation.service.UniversityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class SATSimulTest {
	@Inject
	private UniversityService universityService;
	
	@Test
	public void firstTest(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("universityId", "bbb");
		map.put("majorId", "major038");
		
		UniversitySATDetail satDetail=universityService.universitySATDetail(map);
		System.out.println(satDetail.toString());
		
		map.put("studentId", "ST_01");
		StudentMockScoreDetail smsd=universityService.studentMockScoreDetail(map);
		System.out.println(smsd.toString());

		map.put("mockId", "mock024");
		MockTestMaxStandardScore maxScore=universityService.mockTestMaxStandardScore(map);
		
		double myConvertingScore = 0; // 내 변환점수가 들어갈 변수
		String wjatnwlvy = satDetail.getSatScoreUseIndex(); // 삭제
		switch (wjatnwlvy) {// 학과정보가 다 담겨있는 큰~객체에서 수능점수산출활용지표를 get메소드로 불러와서 쓰면 됨
		case "단순합계":
			// 메소드호출(파라미터에 최신점수 객체 들어감)
			myConvertingScore = simpleSum(smsd);
			break;

		case "표준점수":
			// 메소드호출(파라미터에 내 최신점수 객체 들어감)
			myConvertingScore = universitySum(smsd,satDetail,maxScore);
			break;

		case "변환표준점수":
			// 메소드호출(파라미터에 내 최신점수 객체 들어감)
			myConvertingScore = universityConvertSum(smsd,satDetail,maxScore);
			break;
		
		case "백분위":
			myConvertingScore = universityPercentileSum(smsd,satDetail,maxScore);
			break;
		}
		// 학과의 산출법으로 계산한 내점수와 학과의 커트라인을 비교
		// if(내 변환점수 > 학과커트라인){} .. else if(내 변환점수 < 학과커트라인){}

	}



	// 1.단수합산 메소드
	public double simpleSum(StudentMockScoreDetail smsd) {
		// return 국어표준점수 + 영어표준점수 + 수리표준점수 + 탐구표준점수
		double result=smsd.getLanguageStandardScore()+smsd.getEnglishStandardScore()+smsd.getMathStandardScore()+smsd.getResearchSubjectStandardScore1()+smsd.getResearchSubjectStandardScore2();
		return result;
	}
	// 2.대학별 과목비율에 따른 표준점수합
	public double universitySum(StudentMockScoreDetail smsd, UniversitySATDetail satDetail, MockTestMaxStandardScore maxScore) {
		List<Double> mainList=new ArrayList<>();

		double korStandard=0;
		double matStandard=0;
		double engStandard=0;
		double research1Standard=0;
		double research2Standard=0;

		String whgkq = "국영수 택2 탐2"; // 삭제
		double result = 0;
		switch (whgkq) { // 학과정보가 다 담겨있는 큰~객체에서 선택조합 get
		case "국영수탐2":
			System.out.println("국영수탐2");
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
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}
			
			result=korStandard+matStandard+engStandard+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			break;

		case "국영수탐1":
			System.out.println("국영수탐1");
			
			korStandard=calculation(smsd.getLanguageStandardScore(),satDetail.getKoreanReflectionRate()/100,satDetail.getConvertScoreMax(),200);

			if(smsd.getMathType().equals("수리 가")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);				
			}
			
			engStandard=calculation(smsd.getEnglishStandardScore(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}
			
			result=korStandard+matStandard+engStandard+research1Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			break;

		case "국영수 택2 탐2":
			System.out.println("국영수 택2 탐2");
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
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}
						
			mainList.add(matStandard);
			mainList.add(korStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);

			result+=mainList.get(2)+mainList.get(1)+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			break;
		
			
		case "국영수 택2 탐1":
			System.out.println("국영수 택2 탐1");
			korStandard=calculation(smsd.getLanguageStandardScore(),satDetail.getKoreanReflectionRate()/100,satDetail.getConvertScoreMax(),200);

			if(smsd.getMathType().equals("수리 가")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);				
			}
			
			engStandard=calculation(smsd.getEnglishStandardScore(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
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
			break;
			

		case "국영수 택1 탐2":
			System.out.println("국영수 택1 탐2");
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
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}
			
			mainList.add(matStandard);
			mainList.add(korStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);
		
			result+=mainList.get(2)+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			break;
			
		
		case "국영수 택1 탐1":
			System.out.println("국영수 택1 탐1");
			
			korStandard=calculation(smsd.getLanguageStandardScore(),satDetail.getKoreanReflectionRate()/100,satDetail.getConvertScoreMax(),200);

			if(smsd.getMathType().equals("수리 가")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard=calculation(smsd.getMathStandardScore(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 200);				
			}
			
			engStandard=calculation(smsd.getEnglishStandardScore(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 200);
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
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
			break;
		}
		System.out.println(result);
		return result;
	}



	// 3.변환표준점수
	public double universityConvertSum(StudentMockScoreDetail smsd, UniversitySATDetail satDetail, MockTestMaxStandardScore maxScore) {
		List<Double> mainList=new ArrayList<>();
		Map<String, String> map=new HashMap<String, String>();
		System.out.println("변환표준점수--------------");
		ResearchSubjectMaxScore research=null;
		double korStandard=0;
		double matStandard=0;
		double engStandard=0;
		double research1Standard=0;
		double research2Standard=0;
		String whgkq = "국영수탐2";//국영수 택2 탐2, 국영수탐1, 국영수 택2 탐1,국영수 택1 탐2,국영수 택1 탐1
		double result = 0;
		switch (whgkq) {
		case "국영수탐2":
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
			
			research=universityService.researchSubjectMaxScore(map);
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
			}
		
			result+=korStandard+matStandard+engStandard+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			break;

		case "국영수탐1":
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
			research=universityService.researchSubjectMaxScore(map);
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}

			result+=korStandard+matStandard+engStandard+research1Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			break;

		case "국영수 택2 탐2":
			System.out.println("국영수 택2 탐2");
			
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
			research=universityService.researchSubjectMaxScore(map);
		
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
			}

			mainList.add(matStandard);
			mainList.add(korStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);
				
			result+=mainList.get(2)+mainList.get(1)+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			break;
		
		case "국영수 택2 탐1":
		System.out.println("국영수 택2 탐1");
			
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
			research=universityService.researchSubjectMaxScore(map);
					
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
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
			break;
			
		case "국영수 택1 탐2":
			System.out.println("국영수 택1 탐2");
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
			
			research=universityService.researchSubjectMaxScore(map);
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
				System.out.println("사탐");
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
				System.out.println("과탐");
			}
			
			mainList.add(matStandard);
			mainList.add(korStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);

			result+=mainList.get(2)+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);	
			
			break;
		case "국영수 택1 탐1":
			System.out.println("국영수 택1 탐1");
			
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
			research=universityService.researchSubjectMaxScore(map);
		
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectStandardScore1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject1MaxScore());
				research2Standard=calculation(smsd.getResearchSubjectStandardScore2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), research.getResearchSubject2MaxScore());
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
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
				
			break;
		}
		System.out.println(result);
		return result;
	}

	//표준점수 + 변환표준점수 계산 메소드
	private double calculation(int score, double rate, double convertScoreMax, int standardMaxScore) {
		double result=((score*rate)*convertScoreMax)/standardMaxScore;
		return result;
	}
	
	
/*	// 점수 계산 메소드(파라미터 4개 필요)
	public double calculation() {
		// return 나의점수 * 비율(소수) * 환산점수총점 / 표준점수의 최고점
		return 0;
	}*/
	
	// 4. 백분위 합산 
	private double universityPercentileSum(StudentMockScoreDetail smsd, UniversitySATDetail satDetail, MockTestMaxStandardScore maxScore) {
		List<Double> mainList=new ArrayList<>();

		double korStandard=0;
		double matStandard=0;
		double engStandard=0;
		double research1Standard=0;
		double research2Standard=0;
		String whgkq = "국영수 택1 탐1"; // 삭제 //국영수탐2 ,국영수탐1
		double result = 0;
		switch (whgkq) { // 학과정보가 다 담겨있는 큰~객체에서 선택조합 get
			
		case "국영수탐2":
			System.out.println("백분위 국영수탐2");
			korStandard=calculation(smsd.getLanguagePercentile(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			engStandard=calculation(smsd.getEnglishpercentile(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 100);

			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100); 		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			}
			
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}
			
			result=korStandard+matStandard+engStandard+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			break;
			
		case "국영수탐1":
			System.out.println("백분위 국영수탐1");
			korStandard=calculation(smsd.getLanguagePercentile(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			engStandard=calculation(smsd.getEnglishpercentile(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 100);

			if(smsd.getMathType().equals("수리 가")){
				System.out.println("수리 가형");
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100); 		
			}else if(smsd.getMathType().equals("수리 나")){
				System.out.println("수리 나형");
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			}
			
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getScienceReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}
			
			result=korStandard+matStandard+engStandard+research1Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			break;
	
		case "국영수 택2 탐2":
			System.out.println("백분위 국영수 택2 탐2");
			korStandard=calculation(smsd.getLanguagePercentile(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			engStandard=calculation(smsd.getEnglishpercentile(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 100);

			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100); 		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			}
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}
			mainList.add(korStandard);
			mainList.add(matStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);
			
			result=mainList.get(2)+mainList.get(1)+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			break;
			
		case "국영수 택2 탐1":
			System.out.println("백분위 국영수 택2 탐1");
			korStandard=calculation(smsd.getLanguagePercentile(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			engStandard=calculation(smsd.getEnglishpercentile(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 100);

			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100); 		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			}
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
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
			break;
			
		case "국영수 택1 탐2":
			System.out.println("백분위 국영수 택1 탐2");
			korStandard=calculation(smsd.getLanguagePercentile(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			engStandard=calculation(smsd.getEnglishpercentile(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 100);

			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100); 		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			}
			
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getSocialReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getScienceReflectionRate()/100)/2, satDetail.getConvertScoreMax(), 100);
			}
			mainList.add(korStandard);
			mainList.add(matStandard);
			mainList.add(engStandard);
			
			Collections.sort(mainList);
			
			result=mainList.get(2)+research1Standard+research2Standard;
			result=socreList(korStandard, matStandard, engStandard, research1Standard, research2Standard, result);
			break;
			
		case "국영수 택1 탐1":
			System.out.println("백분위 국영수 택1 탐1");
			korStandard=calculation(smsd.getLanguagePercentile(), satDetail.getKoreanReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			engStandard=calculation(smsd.getEnglishpercentile(), satDetail.getEnglishReflectionRate()/100, satDetail.getConvertScoreMax(), 100);

			if(smsd.getMathType().equals("수리 가")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathBTypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100); 		
			}else if(smsd.getMathType().equals("수리 나")){
				matStandard = calculation(smsd.getMathpercentile(), satDetail.getMathATypeReflectionRate()/100, satDetail.getConvertScoreMax(), 100);
			}
			
			
			if(smsd.getResearchSubjectId1().substring(0,2).equals("SO")){
				//A ==> 사회탐구
				research1Standard=calculation(smsd.getResearchSubjectPercentile1(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				research2Standard=calculation(smsd.getResearchSubjectPercentile2(), (satDetail.getSocialReflectionRate()/100), satDetail.getConvertScoreMax(), 100);
				if(research1Standard<research2Standard){
					research1Standard=research2Standard;
				}
			}else if(smsd.getResearchSubjectId1().substring(0,2).equals("SC")){
				//B ==> 과학탐구
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
			break;
		}
		System.out.println(result);
		return result;
	}
	
	//백분위 합산 메소드
	//나의 점수 / 해당 과목 반영비율/ 변환점수만점 / 백분위최대치
	private double calculation(double score, double rate, double convertScoreMax, int standardMaxScore) {
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