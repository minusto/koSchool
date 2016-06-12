package ko.school.simulation.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.simulation.domain.MockSimulationDTO;

@Repository
public class MockSimulationDAOImpl implements MockSimulationDAO {
	@Inject
	private SqlSession session;
	
	private static String namespace = "ko.school.mapper.MockSimulationMapper";
	
	//액터 ==> 학생, 학부모, 교사 / 작업 내용 : 수시가 아닌 모든 입시정보의 EntranceInfo, University, Major 내용 / 작성자 : 구혜인
	@Override
	public List<MockSimulationDTO> selectAllMockUniversityList() throws Exception {
		return session.selectList(namespace + ".selectAllMockUniversityList");
	}
	
}
