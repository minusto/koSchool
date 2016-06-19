package ko.school.simulation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ko.school.common.domain.StudentVO;
import ko.school.common.domain.TeacherVO;
import ko.school.score.domain.NesinLoadForm;
import ko.school.score.domain.NesinSaveForm;
import ko.school.score.domain.Subject;
import ko.school.score.service.NesinService;
import ko.school.simulation.domain.SusiInfoVO;
import ko.school.simulation.domain.SusiRatingDTO;
import ko.school.simulation.domain.SusiTableDTO;
import ko.school.simulation.service.SusiSimulationService;

@RestController
public class SusiAjaxController {

	@Inject
	private SusiSimulationService service;

	// 지역
	@RequestMapping("/selectLocation")
	public List<SusiTableDTO> selectLocation(@RequestParam("region") String region, HttpSession session, Model model)
			throws Exception {
		String ss = "수시";
		Map<String, String> map = new HashMap<String, String>();

		List<SusiTableDTO> resultList = new ArrayList<SusiTableDTO>();
		map.put("susi", ss);
		map.put("region", "%" + region + "%");
		List<SusiInfoVO> list = service.selectLocationList(map);
		// 지역명, 대학명, 학과, 전형유형, 계열 모집인원, 평균등급, 수시 진단결과, 최저학력기준
		String location = null;
		double resultScore = 0.0;
		double resultAver = 0.0;
		double pointPerGrade[] = new double[9];
		double gradeReflectionRate[] = new double[3];
		String reflectionSubjects = null;
		SusiRatingDTO first = (SusiRatingDTO) session.getAttribute("first");
		SusiRatingDTO second = (SusiRatingDTO) session.getAttribute("second");
		SusiRatingDTO third = (SusiRatingDTO) session.getAttribute("third");
		for (int i = 0; i < list.size(); i++) {
			SusiTableDTO susiTable = new SusiTableDTO();
			// 지역명
			location = service.getLocation(list.get(i).getUniversityLocal());
			susiTable.setLocation(location);
			susiTable.setUniversity(list.get(i).getUniversityName());
			susiTable.setMajor(list.get(i).getMajorName());
			susiTable.setRecruitModelType(list.get(i).getRecruitModelType());
			susiTable.setKind(list.get(i).getKind());
			susiTable.setRecruitNum(list.get(i).getRecruitNum());
			susiTable.setAverScore(list.get(i).getAverScore());
			// 수시 진단결과 계산
			// 수시 진단결과 계산: 배점
			pointPerGrade[0] = list.get(i).getPointPerGrade1();
			pointPerGrade[1] = list.get(i).getPointPerGrade2();
			pointPerGrade[2] = list.get(i).getPointPerGrade3();
			pointPerGrade[3] = list.get(i).getPointPerGrade4();
			pointPerGrade[4] = list.get(i).getPointPerGrade5();
			pointPerGrade[5] = list.get(i).getPointPerGrade6();
			pointPerGrade[6] = list.get(i).getPointPerGrade7();
			pointPerGrade[7] = list.get(i).getPointPerGrade8();
			pointPerGrade[8] = list.get(i).getPointPerGrade9();
			// 수시 진단결과 계산: 학년별 반영 비율
			gradeReflectionRate[0] = list.get(i).getGrade1ReflectionRate();
			gradeReflectionRate[1] = list.get(i).getGrade2ReflectionRate();
			gradeReflectionRate[2] = list.get(i).getGrade3ReflectionRate();
			// 수시 진단결과 계산: 반영 과목
			reflectionSubjects = list.get(i).getReflectionSubjects();
			// 수시 진단결과 계산 -> 대학명, 배점, 각 학년별 등급 및 단위수
			resultScore = service.getResultScore(list.get(i).getUniversityName(), pointPerGrade, first, second, third,
					gradeReflectionRate, reflectionSubjects);
			resultScore = resultScore*(list.get(i).getSchoolreportreflectionrate()/100.0);
			//소수 둘째 자리반올림
			resultScore=Math.round(resultScore*100)/100.0;
			susiTable.setResultScore(resultScore);
			// 지원 가능 여부
			
			resultAver = service.getResultAver(first, second, third,
			gradeReflectionRate, reflectionSubjects);
			
			if (resultAver <= (list.get(i).getAverScore() - 0.2)) { // 2.5일때
																	// 2.3이하면 안전
				susiTable.setSfMessage("합격안정");
			} else if ((resultAver > (list.get(i).getAverScore() - 0.2))
					&& (resultAver <= (list.get(i).getAverScore()))) {// 2.5일때
																		// 2.3초과
																		// 2.5이하
				susiTable.setSfMessage("합격가능");
			} else if ((resultAver > (list.get(i).getAverScore()))
					&& (resultAver <= (list.get(i).getAverScore() + 0.2))) {// 2.5일때
																			// 2.5초과
																			// 2.7이하
				susiTable.setSfMessage("소신지원");
			} else if ((resultAver > (list.get(i).getAverScore() + 0.2))
					&& (resultAver <= (list.get(i).getAverScore() + 0.35))) {// 2.5일때
																			// 2.7초과
																			// 2.85이하
				susiTable.setSfMessage("모험지원");
			} else if ((resultAver > (list.get(i).getAverScore() + 0.35))
					&& (resultAver <= (list.get(i).getAverScore() + 0.5))){// 2.5일때
																			// 2.85초과
																			// 3이하
				susiTable.setSfMessage("위험지원");
			} else{
				susiTable.setSfMessage("지원불가");
			}
			resultList.add(susiTable);
		}
		
		return resultList;
	}

	// 지역과 계열
	@RequestMapping("/selectLocation2")
	public List<SusiTableDTO> selectLocation2(@RequestParam("region") String region, @RequestParam("kind") String kind,
			HttpSession session, Model model) throws Exception {
		String ss = "수시";
		Map<String, String> map = new HashMap<String, String>();

		List<SusiTableDTO> resultList = new ArrayList<SusiTableDTO>();
		map.put("susi", ss);
		map.put("region", "%" + region + "%");
		map.put("kind", kind);
		List<SusiInfoVO> list = service.selectLocationList2(map);
		// 지역명, 대학명, 학과, 전형유형, 계열 모집인원, 평균등급, 수시 진단결과, 최저학력기준
		String location = null;
		double resultScore = 0.0;
		double resultAver = 0.0;
		double pointPerGrade[] = new double[9];
		double gradeReflectionRate[] = new double[3];
		String reflectionSubjects = null;
		SusiRatingDTO first = (SusiRatingDTO) session.getAttribute("first");
		SusiRatingDTO second = (SusiRatingDTO) session.getAttribute("second");
		SusiRatingDTO third = (SusiRatingDTO) session.getAttribute("third");
		for (int i = 0; i < list.size(); i++) {
			SusiTableDTO susiTable = new SusiTableDTO();
			// 지역명
			location = service.getLocation(list.get(i).getUniversityLocal());
			susiTable.setLocation(location);
			susiTable.setUniversity(list.get(i).getUniversityName());
			susiTable.setMajor(list.get(i).getMajorName());
			susiTable.setRecruitModelType(list.get(i).getRecruitModelType());
			susiTable.setKind(list.get(i).getKind());
			susiTable.setRecruitNum(list.get(i).getRecruitNum());
			susiTable.setAverScore(list.get(i).getAverScore());
			// 수시 진단결과 계산
			// 수시 진단결과 계산: 배점
			pointPerGrade[0] = list.get(i).getPointPerGrade1();
			pointPerGrade[1] = list.get(i).getPointPerGrade2();
			pointPerGrade[2] = list.get(i).getPointPerGrade3();
			pointPerGrade[3] = list.get(i).getPointPerGrade4();
			pointPerGrade[4] = list.get(i).getPointPerGrade5();
			pointPerGrade[5] = list.get(i).getPointPerGrade6();
			pointPerGrade[6] = list.get(i).getPointPerGrade7();
			pointPerGrade[7] = list.get(i).getPointPerGrade8();
			pointPerGrade[8] = list.get(i).getPointPerGrade9();
			// 수시 진단결과 계산: 학년별 반영 비율
			gradeReflectionRate[0] = list.get(i).getGrade1ReflectionRate();
			gradeReflectionRate[1] = list.get(i).getGrade2ReflectionRate();
			gradeReflectionRate[2] = list.get(i).getGrade3ReflectionRate();
			// 수시 진단결과 계산: 반영 과목
			reflectionSubjects = list.get(i).getReflectionSubjects();
			// 수시 진단결과 계산 -> 대학명, 배점, 각 학년별 등급 및 단위수
			resultScore = service.getResultScore(list.get(i).getUniversityName(), pointPerGrade, first, second, third,
					gradeReflectionRate, reflectionSubjects);
			resultScore = resultScore*(list.get(i).getSchoolreportreflectionrate()/100.0);
			//소수 둘째 자리반올림
			resultScore=Math.round(resultScore*100)/100.0;
			susiTable.setResultScore(resultScore);
			// 지원 가능 여부
			
			resultAver = service.getResultAver(first, second, third,
			gradeReflectionRate, reflectionSubjects);
			
			if (resultAver <= (list.get(i).getAverScore() - 0.2)) { // 2.5일때
																	// 2.3이하면 안전
				susiTable.setSfMessage("합격안정");
			} else if ((resultAver > (list.get(i).getAverScore() - 0.2))
					&& (resultAver <= (list.get(i).getAverScore()))) {// 2.5일때
																		// 2.3초과
																		// 2.5이하
				susiTable.setSfMessage("합격가능");
			} else if ((resultAver > (list.get(i).getAverScore()))
					&& (resultAver <= (list.get(i).getAverScore() + 0.2))) {// 2.5일때
																			// 2.5초과
																			// 2.7이하
				susiTable.setSfMessage("소신지원");
			} else if ((resultAver > (list.get(i).getAverScore() + 0.2))
					&& (resultAver <= (list.get(i).getAverScore() + 0.4))) {// 2.5일때
																			// 2.7초과
																			// 2.9이하
				susiTable.setSfMessage("모험지원");
			} else if (resultAver > (list.get(i).getAverScore() + 0.4)) {// 2.5일때
																			// 2.9보다
																			// 크면
				susiTable.setSfMessage("위험지원");
			}

			resultList.add(susiTable);
		}
		
		return resultList;
	}
	
	@RequestMapping("/selectLocation3")
	public List<SusiTableDTO> selectLocation3(@RequestParam("uniName") String uniName,
			HttpSession session, Model model) throws Exception {
		String ss = "수시";
		Map<String, String> map = new HashMap<String, String>();
		List<SusiTableDTO> resultList = new ArrayList<SusiTableDTO>();
		map.put("susi", ss);
		map.put("uniName", "%" + uniName + "%");
		List<SusiInfoVO> list = service.searchUniName(map);
		// 지역명, 대학명, 학과, 전형유형, 계열 모집인원, 평균등급, 수시 진단결과, 최저학력기준
		String location = null;
		double resultScore = 0.0;
		double resultAver = 0.0;
		double pointPerGrade[] = new double[9];
		double gradeReflectionRate[] = new double[3];
		String reflectionSubjects = null;
		SusiRatingDTO first = (SusiRatingDTO) session.getAttribute("first");
		SusiRatingDTO second = (SusiRatingDTO) session.getAttribute("second");
		SusiRatingDTO third = (SusiRatingDTO) session.getAttribute("third");
		for (int i = 0; i < list.size(); i++) {
			SusiTableDTO susiTable = new SusiTableDTO();
			// 지역명
			location = service.getLocation(list.get(i).getUniversityLocal());
			susiTable.setLocation(location);
			susiTable.setUniversity(list.get(i).getUniversityName());
			susiTable.setMajor(list.get(i).getMajorName());
			susiTable.setRecruitModelType(list.get(i).getRecruitModelType());
			susiTable.setKind(list.get(i).getKind());
			susiTable.setRecruitNum(list.get(i).getRecruitNum());
			susiTable.setAverScore(list.get(i).getAverScore());
			
			// 수시 진단결과 계산
			// 수시 진단결과 계산: 배점
			pointPerGrade[0] = list.get(i).getPointPerGrade1();
			pointPerGrade[1] = list.get(i).getPointPerGrade2();
			pointPerGrade[2] = list.get(i).getPointPerGrade3();
			pointPerGrade[3] = list.get(i).getPointPerGrade4();
			pointPerGrade[4] = list.get(i).getPointPerGrade5();
			pointPerGrade[5] = list.get(i).getPointPerGrade6();
			pointPerGrade[6] = list.get(i).getPointPerGrade7();
			pointPerGrade[7] = list.get(i).getPointPerGrade8();
			pointPerGrade[8] = list.get(i).getPointPerGrade9();
			// 수시 진단결과 계산: 학년별 반영 비율
			gradeReflectionRate[0] = list.get(i).getGrade1ReflectionRate();
			gradeReflectionRate[1] = list.get(i).getGrade2ReflectionRate();
			gradeReflectionRate[2] = list.get(i).getGrade3ReflectionRate();
			// 수시 진단결과 계산: 반영 과목
			reflectionSubjects = list.get(i).getReflectionSubjects();
			// 수시 진단결과 계산 -> 대학명, 배점, 각 학년별 등급 및 단위수
			resultScore = service.getResultScore(list.get(i).getUniversityName(), pointPerGrade, first, second, third,
					gradeReflectionRate, reflectionSubjects);
			//결과 * 학생부비율
			resultScore = resultScore*(list.get(i).getSchoolreportreflectionrate()/100.0);
			//소수 둘째 자리반올림
			resultScore=Math.round(resultScore*100)/100.0;
			susiTable.setResultScore(resultScore);
			
			// 지원 가능 여부
			
			resultAver = service.getResultAver(first, second, third,
			gradeReflectionRate, reflectionSubjects);
			 
			if (resultAver <= (list.get(i).getAverScore() - 0.2)) { // 2.5일때
																	// 2.3이하면 안전
				susiTable.setSfMessage("합격안정");
			} else if ((resultAver > (list.get(i).getAverScore() - 0.2))
					&& (resultAver <= (list.get(i).getAverScore()))) {// 2.5일때
																		// 2.3초과
																		// 2.5이하
				susiTable.setSfMessage("합격가능");
			} else if ((resultAver > (list.get(i).getAverScore()))
					&& (resultAver <= (list.get(i).getAverScore() + 0.2))) {// 2.5일때
																			// 2.5초과
																			// 2.7이하
				susiTable.setSfMessage("소신지원");
			} else if ((resultAver > (list.get(i).getAverScore() + 0.2))
					&& (resultAver <= (list.get(i).getAverScore() + 0.4))) {// 2.5일때
																			// 2.7초과
																			// 2.9이하
				susiTable.setSfMessage("모험지원");
			} else if (resultAver > (list.get(i).getAverScore() + 0.4)) {// 2.5일때
																			// 2.9보다
																			// 크면
				susiTable.setSfMessage("위험지원");
			}
			resultList.add(susiTable);
		}
		return resultList;
	}
	
	

	// 테스트용 수시 시뮬레이션
	/*
	 * @RequestMapping("/susiSimulationTable") public List<SusiTableDTO>
	 * susiSimulationTable(@RequestParam("uniName") String uniName, HttpSession
	 * session, Model model) throws Exception { String ss = "수시"; Map<String,
	 * String> map = new HashMap<String, String>();
	 * 
	 * List<SusiTableDTO> resultList = new ArrayList<SusiTableDTO>();
	 * map.put("susi", ss); map.put("uniName", uniName); List<SusiInfoVO> list =
	 * service.susiInfoList(map); // 지역명, 대학명, 학과, 전형유형, 계열 모집인원, 평균등급, 수시 진단결과,
	 * 최저학력기준 String location = null; double resultScore = 0.0; double
	 * pointPerGrade[] = new double[9]; double gradeReflectionRate[] = new
	 * double[3]; String reflectionSubjects = null; SusiRatingDTO first =
	 * (SusiRatingDTO) session.getAttribute("first"); SusiRatingDTO second =
	 * (SusiRatingDTO) session.getAttribute("second"); SusiRatingDTO third =
	 * (SusiRatingDTO) session.getAttribute("third"); for (int i = 0; i <
	 * list.size(); i++) { SusiTableDTO susiTable = new SusiTableDTO(); // 지역명
	 * location = service.getLocation(list.get(i).getUniversityLocal());
	 * susiTable.setLocation(location);
	 * susiTable.setUniversity(list.get(i).getUniversityName());
	 * susiTable.setMajor(list.get(i).getMajorName());
	 * susiTable.setRecruitModelType(list.get(i).getRecruitModelType());
	 * susiTable.setRecruitNum(list.get(i).getRecruitNum());
	 * susiTable.setAverScore(list.get(i).getAverScore()); // 수시 진단결과 계산 // 수시
	 * 진단결과 계산: 배점 pointPerGrade[0] = list.get(i).getPointPerGrade1();
	 * pointPerGrade[1] = list.get(i).getPointPerGrade2(); pointPerGrade[2] =
	 * list.get(i).getPointPerGrade3(); pointPerGrade[3] =
	 * list.get(i).getPointPerGrade4(); pointPerGrade[4] =
	 * list.get(i).getPointPerGrade5(); pointPerGrade[5] =
	 * list.get(i).getPointPerGrade6(); pointPerGrade[6] =
	 * list.get(i).getPointPerGrade7(); pointPerGrade[7] =
	 * list.get(i).getPointPerGrade8(); pointPerGrade[8] =
	 * list.get(i).getPointPerGrade9(); // 수시 진단결과 계산: 학년별 반영 비율
	 * gradeReflectionRate[0] = list.get(i).getGrade1ReflectionRate();
	 * gradeReflectionRate[1] = list.get(i).getGrade2ReflectionRate();
	 * gradeReflectionRate[2] = list.get(i).getGrade3ReflectionRate(); // 수시
	 * 진단결과 계산: 반영 과목 reflectionSubjects = list.get(i).getReflectionSubjects();
	 * // 수시 진단결과 계산 -> 대학명, 배점, 각 학년별 등급 및 단위수 resultScore =
	 * service.getResultScore(uniName, pointPerGrade, first, second, third,
	 * gradeReflectionRate, reflectionSubjects);
	 * susiTable.setResultScore(resultScore); resultList.add(susiTable); }
	 * 
	 * return resultList; }
	 */
	
	//추천대학리스트 
	@RequestMapping("/recommend")
	public List<SusiTableDTO> recommend(@RequestParam("uniName") String uniName,HttpSession session, Model model,HttpServletRequest request)throws Exception{
		session = request.getSession();
		
		StudentVO stVO =(StudentVO)session.getAttribute("student");		
		String stMajor = stVO.getStudentMajor();
	
		String mo ="인문계";
		String ja ="자연계";
		
		String ss = "수시";
		Map<String, String> map = new HashMap<String, String>();
		
		List<SusiTableDTO> resultList = new ArrayList<SusiTableDTO>();
		map.put("susi", ss);
		map.put("uniName", uniName);
		
		if(stMajor.equals("문과")){
			map.put("kind",mo);
		}else{
			map.put("kind",ja);
		}
		
		List<SusiInfoVO> sub = service.susiInfoList(map); //수시 국영수사인지 국영수과인지 불러옴
		
		String reflectionSub = sub.get(0).getReflectionSubjects();
		
		String location = null;
		double resultScore = 0.0;
		
		double pointPerGrade[] = new double[9];
		double gradeReflectionRate[] = new double[3];
		String reflectionSubjects = null;
		SusiRatingDTO first = (SusiRatingDTO)session.getAttribute("first");
		SusiRatingDTO second = (SusiRatingDTO)session.getAttribute("second");
		SusiRatingDTO third = (SusiRatingDTO)session.getAttribute("third");
		

		double resultGrade = service.getResultAver(first, second, third, gradeReflectionRate,  reflectionSub); //학생부 등급 구하는거
	   String tt = String.valueOf(resultGrade);
        map.put("averScore", tt.substring(0, 4));
		List<SusiInfoVO> list = service.susiRecomList(map); //수시 인문or 자연 자기 등급에 맞는 추천학과 출력
		for(int i=0; i<list.size(); i++){
			SusiTableDTO susiTable = new SusiTableDTO();
			//지역명
			location = service.getLocation(list.get(i).getUniversityLocal());
			susiTable.setLocation(location);
			susiTable.setUniversity(list.get(i).getUniversityName());
			susiTable.setMajor(list.get(i).getMajorName());
			susiTable.setRecruitModelType(list.get(i).getRecruitModelType());
			susiTable.setRecruitNum(list.get(i).getRecruitNum());
			susiTable.setAverScore(list.get(i).getAverScore());
			//수시 진단결과 계산
			//수시 진단결과 계산: 배점
			pointPerGrade[0] = list.get(i).getPointPerGrade1();
			pointPerGrade[1] = list.get(i).getPointPerGrade2();
			pointPerGrade[2] = list.get(i).getPointPerGrade3();
			pointPerGrade[3] = list.get(i).getPointPerGrade4();
			pointPerGrade[4] = list.get(i).getPointPerGrade5();
			pointPerGrade[5] = list.get(i).getPointPerGrade6();
			pointPerGrade[6] = list.get(i).getPointPerGrade7();
			pointPerGrade[7] = list.get(i).getPointPerGrade8();
			pointPerGrade[8] = list.get(i).getPointPerGrade9();
			//수시 진단결과 계산: 학년별 반영 비율
			gradeReflectionRate[0] = list.get(i).getGrade1ReflectionRate();
			gradeReflectionRate[1] = list.get(i).getGrade2ReflectionRate();
			gradeReflectionRate[2] = list.get(i).getGrade3ReflectionRate();
			// 수시 진단결과 계산: 반영 과목
			reflectionSubjects = list.get(i).getReflectionSubjects();
			//수시 진단결과 계산 -> 대학명, 배점, 각 학년별 등급 및 단위수
			resultScore = service.getResultScore(uniName,pointPerGrade,
					first, second, third,gradeReflectionRate, reflectionSubjects);
			resultScore=Math.round(resultScore*100)/100.0;
			susiTable.setResultScore(resultScore);
			resultList.add(susiTable);
		}

		return resultList;
	}

}
