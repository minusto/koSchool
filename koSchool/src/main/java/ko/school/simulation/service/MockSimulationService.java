package ko.school.simulation.service;

import java.util.List;

import ko.school.simulation.domain.MockSimulationDTO;

public interface MockSimulationService {
	public List<MockSimulationDTO> selectAllMockUniversityListService() throws Exception; //액터 ==> 학생, 학부모, 교사 / 작업 내용 : 수시가 아닌 모든 입시정보의 EntranceInfo, University, Major 내용 / 작성자 : 구혜인
	
	
	
}
