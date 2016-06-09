package ko.school.simulation.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.simulation.persistence.MockSimulationDAO;

@Service
public class MockSimulationServiceImpl implements MockSimulationService {
	@Inject
	private MockSimulationDAO dao;
	
	
	
}
