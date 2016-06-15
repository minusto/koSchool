package ko.school.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ko.school.score.domain.SubjectScore;
import ko.school.score.persistence.NesinDao;
import ko.school.simulation.domain.SusiInfoVO;
import ko.school.simulation.domain.SusiRatingDTO;
import ko.school.simulation.domain.SusiTableDTO;
import ko.school.simulation.service.SusiSimulationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class susiTableTest {
	private static Logger logger = LoggerFactory.getLogger(susiTableTest.class);
	
	@Inject
	private NesinDao dao;
	
	@Inject
	private SusiSimulationService service;
	
	@RequestMapping("/susiSimulationTable")
	public List<SusiTableDTO> susiSimulationTable(@RequestParam("uniName") String uniName,HttpSession session, Model model)throws Exception{
		String ss = "수시";
		Map<String, String> map = new HashMap<String, String>();
		List<SusiTableDTO> resultList = null;
		
		map.put("susi", ss);
		map.put("uniName", uniName);
		List<SusiInfoVO> list = service.susiInfoList(map);
		//지역명, 대학명, 학과, 전형유형, 계열 모집인원, 평균등급, 수시 진단결과, 최저학력기준
		String location=null;
		double resultScore = 0.0;
		double pointPerGrade[] = new double[9];
		double gradeReflectionRate[] = new double[3];
		String reflectionSubjects = null;
		SusiRatingDTO first = (SusiRatingDTO)session.getAttribute("first");
		SusiRatingDTO second = (SusiRatingDTO)session.getAttribute("second");
		SusiRatingDTO third = (SusiRatingDTO)session.getAttribute("third");
		for(int i=0; i<list.size(); i++){
			//지역명
			location = service.getLocation(list.get(i).getUniversityLocal());
			resultList.get(i).setLocation(location);
			resultList.get(i).setUniversity(list.get(i).getUniversityName());
			resultList.get(i).setMajor(list.get(i).getMajorName());
			resultList.get(i).setRecruitModelType(list.get(i).getRecruitModelType());
			resultList.get(i).setRecruitNum(list.get(i).getRecruitNum());
			resultList.get(i).setAverScore(list.get(i).getAverScore());
			
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
			resultList.get(i).setResultScore(resultScore);
		}
		
		
		return resultList;
	}
}
