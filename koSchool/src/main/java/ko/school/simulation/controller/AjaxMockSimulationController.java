package ko.school.simulation.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ko.school.common.domain.MemberVO;
import ko.school.simulation.domain.HopeUniversityVO;
import ko.school.simulation.domain.MajorVO;
import ko.school.simulation.domain.MockSimulationDTO;
import ko.school.simulation.domain.UniversityMajorVO;
import ko.school.simulation.service.MockSimulationService;

@RestController
public class AjaxMockSimulationController {
	
	@Inject
	private MockSimulationService service;
	
	//희망대학이 없을 경우 학교에 맞는 학과 리스트를 불러옴
	@RequestMapping("/ajaxMajorList")
	public List<MajorVO> ajaxMajorList(@RequestParam("uniId") String universityId) throws Exception {
		List<MajorVO> list = null;
		list = service.selectMajorListService(universityId);
		return list;
	}
	//희망대학 등록을 눌렀을 경우
	@RequestMapping(value="/ajaxInsertHopeUniversity", method=RequestMethod.GET)
	public MockSimulationDTO ajaxInsertHopeUniversity(UniversityMajorVO universityMajorVo, HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		MemberVO memberVo = (MemberVO) session.getAttribute("member");
		String memberId = memberVo.getMemberId();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("memberId", memberId);
		map.put("universityId", universityMajorVo.getUniversityId());
		map.put("majorId", universityMajorVo.getMajorId());
		
		//맵을 가지고 entranceInfo에서 정보를 가져와 희망대학을 입력. 만든 희망대학 객체를 뷰로 보냄
		HopeUniversityVO hopeUniversityVo = service.insertHopeUniversityService(map);
		model.addAttribute("hopeUniversity", hopeUniversityVo);
		
		
		//희망대학 부분에 출력할 내용을 뽑아서 보냄
		MockSimulationDTO mockSimulationDTO = service.hopeUniversityPrintService(hopeUniversityVo);
		model.addAttribute("hopeUniversity", mockSimulationDTO);
		
		//희망대학을 만들었으니 최근 본 모의고사의 언수외탐 표준점수 총합을 구해서 뷰로 보내줌
		Integer standardScoreSum = service.selectStandardScoreSumService(memberId);
		if(standardScoreSum != null) {//표준점수의 총합을 보내줘야 하는데 스크립트로 들어가야 하기 때문에 DTO에 넣어서 같이 보내주기로 함.
			model.addAttribute("standardScoreSum", standardScoreSum);
			mockSimulationDTO.setEntranceYear(standardScoreSum);
		} else {
			model.addAttribute("standardScoreSum", 0);
			mockSimulationDTO.setEntranceYear(0);
		}
		
		return mockSimulationDTO;
	}

	
	
	
}
