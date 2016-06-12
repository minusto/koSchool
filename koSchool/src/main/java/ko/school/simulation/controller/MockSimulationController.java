package ko.school.simulation.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ko.school.simulation.domain.MockSimulationDTO;
import ko.school.simulation.service.MockSimulationService;

@Controller
public class MockSimulationController {
	@Inject
	private MockSimulationService service;
	
	@RequestMapping(value="/mockSimulation", method=RequestMethod.GET)
	public String mockSimulation(Model model) throws Exception {
		List<MockSimulationDTO> allMockEntranceInfoList = service.selectAllMockUniversityListService();		
		model.addAttribute("allMockList", allMockEntranceInfoList);
		
		
		return "/simulation/mockSimulation";
	}
	

	
	@RequestMapping(value="/universityDetail", method=RequestMethod.GET)
	public String universityDetail() throws Exception {
		
		return "/simulation/universityDetail";
	}
	
	
}
