package ko.school.simulation.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ko.school.common.domain.ParentVO;
import ko.school.common.domain.StudentVO;
import ko.school.simulation.domain.SusiRatingDTO;
import ko.school.simulation.service.SusiSimulationService;

@Controller
public class SusiSimulationController {
	@Inject
	private SusiSimulationService service;
	
	@RequestMapping(value="/susiSimulation", method=RequestMethod.GET)
	public String susiSimulation(HttpSession session, Model model)throws Exception {
		String grade = (String) session.getAttribute("grade");
		String id = null;
		int studentGrade = 0;
		if(grade.equals("teacher")){
			//학생의 id
			id = (String) session.getAttribute("id");
			//학생객체 구해서 학년 구하기
			StudentVO studentVO = service.studentCheck(id);
			studentGrade = studentVO.getStudentGrade();
			
		}else if(grade.equals("student")){
			StudentVO studentVO = (StudentVO) session.getAttribute("student");
			id = studentVO.getMemberId();
			//학년 구하기
			studentGrade = studentVO.getStudentGrade();
		}else if(grade.equals("parent")){
			ParentVO parentVO = (ParentVO) session.getAttribute("parent");
			id = parentVO.getStudentMemberId();
			//학생객체 구해서 학년 구하기
			StudentVO studentVO = service.studentCheck(id);
			studentGrade = studentVO.getStudentGrade();
		}
		SusiRatingDTO[] dto = new SusiRatingDTO[3];
		if(studentGrade == 1){
			// 1학년 1,2학기 
			dto[0] = service.grade1(studentGrade, id);
		}else if(studentGrade == 2){
			// 1학년 1,2학기 
			dto[0] = service.grade1(studentGrade, id);
			// 2학년 1,2학기 
			dto[1] = service.grade2(studentGrade, id);
		}else if(studentGrade == 3){
			// 1학년 1,2학기 
			dto[0] = service.grade1(studentGrade, id);
			// 2학년 1,2학기 
			dto[1] = service.grade2(studentGrade, id);
			// 3학년 1,2학기 
			dto[2] = service.grade3(studentGrade, id);
		}
		//1학년 전체교과 평균등급
		model.addAttribute("first",dto[0]);
		//2학년 전체교과 평균등급
		model.addAttribute("second",dto[1]);
		//3학년 전체교과 평균등급
		model.addAttribute("third",dto[2]);
		return "/simulation/susiSimulation";
	}
	
	
}
