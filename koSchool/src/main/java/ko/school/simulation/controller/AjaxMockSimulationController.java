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
	
}
