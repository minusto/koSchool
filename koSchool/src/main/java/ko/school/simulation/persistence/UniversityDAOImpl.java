package ko.school.simulation.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.simulation.domain.EntranceInfoVO;
import ko.school.simulation.domain.ExtraPointVO;
import ko.school.simulation.domain.MajorVO;
import ko.school.simulation.domain.ReflectionRatePerSATAreaVO;
import ko.school.simulation.domain.ReflectionRateVO;
import ko.school.simulation.domain.SATScoreVO;
import ko.school.simulation.domain.UniversityVO;

@Repository
public class UniversityDAOImpl implements UniversityDAO {
	@Inject
	private SqlSession session;
	
	private static String namespace = "ko.school.mapper.UniversityMapper";

	public List<UniversityVO> universityList() {
		return session.selectList(namespace+".universityList");
	}

	@Override
	public List<MajorVO> majorList() {
		return session.selectList(namespace+".majorList");
	}

	@Override
	public void insertReflectionRate(ReflectionRateVO reflectRateVO) {
		session.insert(namespace+".insertReflectionRate",reflectRateVO);
	}

	@Override
	public void insertExtraPoint(ExtraPointVO extraPointVO) {
		session.insert(namespace+".insertExtraPoint",extraPointVO);
	}

	@Override
	public void insertEntranceInfo(EntranceInfoVO entranceInfoVO) {
		session.insert(namespace+".insertEntranceInfo",entranceInfoVO);
	}

	@Override
	public void insertReflectionRatePerSATArea(ReflectionRatePerSATAreaVO rrp) {
		session.insert(namespace+".insertReflectionRatePerSATArea",rrp);
	}

	@Override
	public void insertSATScore(SATScoreVO satScoreVO) {
		session.insert(namespace+".insertSATScore",satScoreVO);
	}

	@Override
	public List<ExtraPointVO> extraPointList() {
		return session.selectList(namespace+".extraPointList");
	}

	@Override
	public List<ReflectionRatePerSATAreaVO> reflectionRatePerSATAreaList() {
		return session.selectList(namespace+".reflectionRatePerSATAreaList");
	}

	@Override
	public List<ReflectionRateVO> reflectionRateList() {
		return session.selectList(namespace+".reflectionRateList");
	}
}
