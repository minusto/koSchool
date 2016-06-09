package ko.school.simulation.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MockSimulationDAOImpl implements MockSimulationDAO {
	@Inject
	private SqlSession session;
	
	private static String namespace = "ko.school.mapper.MockSimulationMapper";
	
	
	
}
