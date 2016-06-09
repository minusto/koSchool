package ko.school.simulation.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ko.school.simulation.service.MockSimulationService;

@Controller
public class MockSimulationController {
	@Inject
	private MockSimulationService service;
	
	@RequestMapping(value="/mockSimulation", method=RequestMethod.GET)
	public String mockSimulation() {
		
		return "/simulation/mockSimulation";
	}
	
	
	
	@RequestMapping(value="/universityDetail", method=RequestMethod.GET)
	public String universityDetail() {
		
		return "/simulation/universityDetail";
	}
	
	
}
