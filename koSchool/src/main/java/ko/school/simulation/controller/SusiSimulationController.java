package ko.school.simulation.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
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
	public String susiSimulation(HttpSession session)throws Exception {
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
		SusiRatingDTO[] dto = new SusiRatingDTO[6];
		if(studentGrade == 1){
			// 1학년 1학기 
			dto[0] = service.grade1Semester1(studentGrade, id);
			// 1학년 2학기
			dto[1] = service.grade1Semester2(studentGrade, id);
		}else if(studentGrade == 2){
			// 1학년 1학기 
			dto[0] = service.grade1Semester1(studentGrade, id);
			// 1학년 2학기
			dto[1] = service.grade1Semester2(studentGrade, id);
			// 2학년 1학기 
			dto[2] = service.grade2Semester1(studentGrade, id);
			// 2학년 2학기
			dto[3] = service.grade2Semester2(studentGrade, id);
		}else if(studentGrade == 3){
			// 1학년 1학기 
			dto[0] = service.grade1Semester1(studentGrade, id);
			// 1학년 2학기
			dto[1] = service.grade1Semester2(studentGrade, id);
			// 2학년 1학기 
			dto[2] = service.grade2Semester1(studentGrade, id);
			// 2학년 2학기
			dto[3] = service.grade2Semester2(studentGrade, id);
			// 3학년 1학기 
			dto[4] = service.grade3Semester1(studentGrade, id);
			// 3학년 2학기
			dto[5] = service.grade3Semester2(studentGrade, id);
		}
		
		return "/simulation/susiSimulation";
	}
	
	
}
