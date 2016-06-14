package ko.school.simulation.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.common.domain.StudentVO;
import ko.school.score.domain.AllRankingScoreList;
import ko.school.score.domain.AllStudentNum;
import ko.school.simulation.domain.SusiSubjectDTO;
import ko.school.simulation.domain.UniversityVO;

@Repository
public class SusiSimulationDAOImpl implements SusiSimulationDAO {
	@Inject
	private SqlSession session;
	
	private static String namespace = "ko.school.mapper.SusiSimulationMapper";

	@Override
	public StudentVO studentCheck(String id) throws Exception {
		return session.selectOne(namespace+".studentCheck", id);
	}

	@Override
	public List<AllRankingScoreList> allRankingScoreList(Map<String, Object> map) throws Exception {
		return session.selectList(namespace+".allRankingScoreList", map);
	}

	@Override
	public List<AllStudentNum> allStudentNum(Map<String, Object> map) throws Exception {
		return session.selectList(namespace+".allStudentNum", map);
	}

	@Override
	public List<SusiSubjectDTO> susiSubject(Map<String, Object> map) throws Exception {
		return session.selectList(namespace+".susiSubject", map);
	}

	/*@Override
	public List<UniversityVO> univerSityChartList() throws Exception {
		return session.selectList(namespace + ".univerSityChartList");
	}*/
	
	
	
	
}
