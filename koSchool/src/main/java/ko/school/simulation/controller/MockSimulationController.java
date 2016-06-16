package ko.school.simulation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.simulation.domain.ChooseDetailCommand;
import ko.school.simulation.domain.HopeUniversityVO;
import ko.school.simulation.domain.MockSimulationDTO;
import ko.school.simulation.domain.SATScoreGrade;
import ko.school.simulation.domain.StudentConvertDTO;
import ko.school.simulation.domain.StudentMockScoreDetail;
import ko.school.simulation.domain.UniversityMajorVO;
import ko.school.simulation.domain.UniversitySATDetail;
import ko.school.simulation.domain.UniversitySATInfoDTO;
import ko.school.simulation.domain.UniversityVO;
import ko.school.simulation.service.MockSimulationService;
import ko.school.simulation.service.UniversityService;

@Controller
public class MockSimulationController {
	@Inject
	private MockSimulationService service;
	
	@Inject
	private UniversityService universityService;
	
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
		
		//학생의 희망대학을 뽑아냄
		HopeUniversityVO hopeUniversityVo = new HopeUniversityVO();
		hopeUniversityVo = service.selectExistHopeUniversityService(studentId);

		model.addAttribute("hopeUniversity", hopeUniversityVo); //희망대학 유무에 따라 뷰도 갈리기 때문에 무조건 보내줌
		
		if(hopeUniversityVo == null) { //희망대학이 없을 경우 memberId만 넣어서 쓸 수 있도록
			hopeUniversityVo = new HopeUniversityVO();
			hopeUniversityVo.setMemberId(studentId);
		}
		
		if(hopeUniversityVo.getUniversityId() != null) {
			//희망대학 부분에 출력할 내용
			MockSimulationDTO mockSimulationDTO = service.hopeUniversityPrintService(hopeUniversityVo);
			model.addAttribute("hopeUniversity", mockSimulationDTO);
		} else { //희망대학이 없는 경우
			if(grade.equals("student")) { //학생일 경우만 입력진행 -> 입학정보가 있는 대학교 목록
				List<UniversityVO> universityList = service.selectUniversityListService();
				model.addAttribute("universityList", universityList);
			}
		}
		
		model.addAttribute("ControllerStudentId", hopeUniversityVo.getMemberId());
		
		//최근 본 모의고사의 언수외탐 표준점수 총합
		Integer standardScoreSum = service.selectStandardScoreSumService(studentId);
		if(standardScoreSum != null) { //모의고사 점수 유무에 따라서 뷰가 갈리기 때문에 무조건 보내줌
			model.addAttribute("standardScoreSum", standardScoreSum);
		} else { //모의고사 점수가 입력되어있지 않은 경우
			model.addAttribute("standardScoreSum", 0);
		}
		//추천대학
		List<MockSimulationDTO> recommandList = service.recommandUniversityListService(hopeUniversityVo);
		model.addAttribute("recommandList", recommandList);

		//모든 정시 대학교 리스트
		List<MockSimulationDTO> allMockEntranceInfoList = service.selectAllMockUniversityListService();		
		model.addAttribute("allMockList", allMockEntranceInfoList);
		return "/simulation/mockSimulation";
	}
	
	//희망대학 입력
	@RequestMapping(value="InsertHopeUniversity", method=RequestMethod.POST)
	public String InsertHopeUniversity(UniversityMajorVO universityMajorVo, HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		MemberVO memberVo = (MemberVO) session.getAttribute("member");
		String memberId = memberVo.getMemberId();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberId", memberId);
		map.put("universityId", universityMajorVo.getUniversityId());
		map.put("majorId", universityMajorVo.getMajorId());
		
		//맵을 가지고 entranceInfo에서 정보를 가져와 희망대학을 입력. 만든 희망대학 객체를 뷰로 보냄
		service.insertHopeUniversityService(map);
		
		return "redirect:/mockSimulation";
	}
	
	
	
	//-------------------------Detail 연산--------------------------
	@RequestMapping(value="/universityDetail", method=RequestMethod.POST)
	public String universityDetail(ChooseDetailCommand chooseDetail,Model model) throws Exception {
		StudentConvertDTO studentConvertDto=universityService.simulationCalculation(chooseDetail);
		UniversitySATInfoDTO universitySATInfo=universityService.universitySATInfo(chooseDetail);
		//선택한 학교의 모집구분에 따른 모든 정보 가져오기
		Map<String, String> map=new HashMap<String, String>();
		map.put("universityId", chooseDetail.getUniversityId());
		map.put("majorId", chooseDetail.getMajorId());
		map.put("recruitSeparate", chooseDetail.getRecruitSeparate());
		UniversitySATDetail universitySatDetail=universityService.universitySATDetail(map);
		map.put("studentId", chooseDetail.getMemberId());
		StudentMockScoreDetail smsd=universityService.studentMockScoreDetail(map);
		
		//모의고사 등급
		SATScoreGrade satScoreGrade=universityService.satScoreGrade(chooseDetail);
		model.addAttribute("satScoreGrade", satScoreGrade);
		
		//학생이 본 가장 최신 모의고사의 모든정보
		model.addAttribute("smsd", smsd);
		
		//선택한 학교의 모집구분에 따른 모든 정보 가져오기
		model.addAttribute("universitySatDetail", universitySatDetail);
		
		//학생의 점수와 학교연산법에 맞는 연산 결과
		model.addAttribute("studentConvertDto", studentConvertDto);
		
		//선택한 대학교명, 학과명, 모집구분(수시,가군,나군,다군) 뽑아오기
		model.addAttribute("universitySATInfo", universitySATInfo);

		return "/simulation/universityDetail";
		
	}
	
}
