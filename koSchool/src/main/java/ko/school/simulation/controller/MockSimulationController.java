package ko.school.simulation.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.simulation.domain.HopeUniversityVO;
import ko.school.simulation.domain.MockSimulationDTO;
import ko.school.simulation.domain.UniversityVO;
import ko.school.simulation.service.MockSimulationService;

@Controller
public class MockSimulationController {
	@Inject
	private MockSimulationService service;
	
	@RequestMapping(value="/mockSimulation", method=RequestMethod.GET)
	public String mockSimulation(HttpServletRequest request, Model model) throws Exception {
		//접속 시 학생의 아이디를 뽑아냄
		HttpSession session = request.getSession();
		String grade = (String)session.getAttribute("grade");
		String studentId = null;
		
		if(grade.equals("student")) {
			MemberVO memberVo = (MemberVO)session.getAttribute("member");
			studentId = memberVo.getMemberId();
		} else if(grade.equals("parent")) {
			ParentVO parentVo = (ParentVO)session.getAttribute("parent");
			studentId = parentVo.getStudentMemberId();
		} else {
			studentId = request.getParameter("studentId");
		}
		
		HopeUniversityVO hopeUniversityVo = new HopeUniversityVO();
		hopeUniversityVo = service.selectExistHopeUniversityService(studentId);
		
		model.addAttribute("hopeUniversity", hopeUniversityVo);
		//
		
		//모든 정시 대학교 리스트
		List<MockSimulationDTO> allMockEntranceInfoList = service.selectAllMockUniversityListService();		
		model.addAttribute("allMockList", allMockEntranceInfoList);
		//
		
		if(hopeUniversityVo == null) {
			//희망대학이 없는 경우 -> 입학정보가 있는 대학교 리스트
			List<UniversityVO> universityList = service.selectUniversityListService();
			model.addAttribute("universityList", universityList);
			//
		} else {
			//희망대학이 있는 경우 -> 최근 본 모의고사의 언수외탐 표준점수 총합을 구함
			Integer standardScoreSum = service.selectStandardScoreSumService(studentId);
			if(standardScoreSum != null) {
				model.addAttribute("standardScoreSum", standardScoreSum);
			} else {
				model.addAttribute("standardScoreSum", 0);
			}
			//
			
			//희망대학 부분에 출력할 내용을 뽑아서 보냄
			MockSimulationDTO mockSimulationDTO = service.hopeUniversityPrintService(hopeUniversityVo);
			model.addAttribute("hopeUniversity", mockSimulationDTO);
			//
		}
		
		return "/simulation/mockSimulation";
	}
	

	
	@RequestMapping(value="/universityDetail", method=RequestMethod.GET)
	public String universityDetail() throws Exception {
		
		return "/simulation/universityDetail";
	}
	
	
}
