package ko.school.simulation.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.simulation.domain.MockSimulationDTO;
import ko.school.simulation.persistence.MockSimulationDAO;

@Service
public class MockSimulationServiceImpl implements MockSimulationService {
	@Inject
	private MockSimulationDAO dao;
	
	//액터 ==> 학생, 학부모, 교사 / 작업 내용 : 수시가 아닌 모든 입시정보의 EntranceInfo, University, Major 내용 / 작성자 : 구혜인
	@Override
	public List<MockSimulationDTO> selectAllMockUniversityListService() throws Exception {
		return dao.selectAllMockUniversityList();
	}
	
}
