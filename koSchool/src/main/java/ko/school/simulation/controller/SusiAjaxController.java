package ko.school.simulation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	
	@RequestMapping("/susiSimulationTable")
	public List<SusiTableDTO> susiSimulationTable(@RequestParam("uniName") String uniName,HttpSession session, Model model)throws Exception{
		String ss = "수시";
		Map<String, String> map = new HashMap<String, String>();
		
		List<SusiTableDTO> resultList = new ArrayList<SusiTableDTO>();
		map.put("susi", ss);
		map.put("uniName", uniName);
		List<SusiInfoVO> list = service.susiInfoList(map);
		//지역명, 대학명, 학과, 전형유형, 계열 모집인원, 평균등급, 수시 진단결과, 최저학력기준
		String location = null;
		double resultScore = 0.0;
		double pointPerGrade[] = new double[9];
		double gradeReflectionRate[] = new double[3];
		String reflectionSubjects = null;
		SusiRatingDTO first = (SusiRatingDTO)session.getAttribute("first");
		SusiRatingDTO second = (SusiRatingDTO)session.getAttribute("second");
		SusiRatingDTO third = (SusiRatingDTO)session.getAttribute("third");
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
			susiTable.setResultScore(resultScore);
			resultList.add(susiTable);
		}
		
		
		return resultList;
	}
	

	
}
