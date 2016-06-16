package ko.school.simulation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.StudentVO;
import ko.school.simulation.domain.SusiDetailDTO;
import ko.school.simulation.domain.SusiInfoVO;
import ko.school.simulation.domain.SusiRatingDTO;
import ko.school.simulation.domain.SusiTableDTO;
import ko.school.simulation.domain.UniversityVO;
import ko.school.simulation.service.SusiSimulationService;

@Controller
public class SusiSimulationController {
	@Inject
	private SusiSimulationService service;

	@RequestMapping(value = "/susiSimulation", method = RequestMethod.GET)
	public String susiSimulation(HttpSession session, Model model) throws Exception {
		model.addAttribute("path", "진학시뮬레이션 > 수시시뮬레이션");
		MemberVO member = (MemberVO)session.getAttribute("member");
		model.addAttribute("studentName", member.getMemberName());
		String grade = (String) session.getAttribute("grade");
		String id = null;
		int studentGrade = 0;
		String sMajor = null;
		double[] gradeReflectionRate = new double[3];
		if (grade.equals("teacher")) {
			// 학생의 id
			id = (String) session.getAttribute("id");
			// 학생객체 구해서 학년 구하기
			StudentVO studentVO = service.studentCheck(id);
			studentGrade = studentVO.getStudentGrade();
			sMajor = studentVO.getStudentMajor();

		} else if (grade.equals("student")) {
			StudentVO studentVO = (StudentVO) session.getAttribute("student");
			id = studentVO.getMemberId();
			// 학년 구하기
			studentGrade = studentVO.getStudentGrade();
			sMajor = studentVO.getStudentMajor();
		} else if (grade.equals("parent")) {
			ParentVO parentVO = (ParentVO) session.getAttribute("parent");
			id = parentVO.getStudentMemberId();
			// 학생객체 구해서 학년 구하기
			StudentVO studentVO = service.studentCheck(id);
			studentGrade = studentVO.getStudentGrade();
			sMajor = studentVO.getStudentMajor();
		}
		
		SusiRatingDTO[] dto = new SusiRatingDTO[3];
		if (studentGrade == 1) {
			// 1학년 1,2학기
			dto[0] = service.grade1(studentGrade, id);
		} else if (studentGrade == 2) {
			// 1학년 1,2학기
			dto[0] = service.grade1(studentGrade, id);
			// 2학년 1,2학기
			dto[1] = service.grade2(studentGrade, id);
		} else if (studentGrade == 3) {
			// 1학년 1,2학기
			dto[0] = service.grade1(studentGrade, id);
			// 2학년 1,2학기
			dto[1] = service.grade2(studentGrade, id);
			// 3학년 1,2학기
			dto[2] = service.grade3(studentGrade, id);
		}
		// 1학년 전체교과 평균등급
		model.addAttribute("first", dto[0]);
		// 2학년 전체교과 평균등급
		model.addAttribute("second", dto[1]);
		// 3학년 전체교과 평균등급
		model.addAttribute("third", dto[2]);

		session.setAttribute("first", dto[0]);
		session.setAttribute("second", dto[1]);
		session.setAttribute("third", dto[2]);
		// 차트에서 대학리스트 불러오기
		List<UniversityVO> list = service.univerSityChartList();
		model.addAttribute("list", list);
		
		// 학생부 총 평균등급
		double resultAver = 0.0;
		String reflectionSubjects = null;
		if(sMajor.equals("문과")){
			reflectionSubjects = "국영수사";
		}else if(sMajor.equals("이과")){
			reflectionSubjects = "국영수과";
		}
		resultAver = service.getResultAver(dto[0], dto[1]	, dto[2],
		gradeReflectionRate, reflectionSubjects);
		
		resultAver = Math.round(resultAver*100)/100.0;
		
		model.addAttribute("resultAver",resultAver);

		return "/simulation/susiSimulation";
	}

	@RequestMapping(value = "/susiUniversityDetail", method = RequestMethod.GET)
	public String universityDetail(@RequestParam("uniName") String uniName, 
			@RequestParam("major") String major, Model model) throws Exception {
		String ss = "수시";
		Map<String, String> map = new HashMap<String, String>();
		map.put("susi", ss);
		map.put("uniName", uniName);
		map.put("major", major);
		SusiInfoVO susiInfoVO= service.susiUniversityDetail(map);
		model.addAttribute("susiInfoVO", susiInfoVO);
		
		//반영비율
		SusiDetailDTO susiDetailDTO = service.susiDetailDTO(map);
		model.addAttribute("susiDetailDTO", susiDetailDTO);
		return "/simulation/susiUniversityDetail";
	}

}
