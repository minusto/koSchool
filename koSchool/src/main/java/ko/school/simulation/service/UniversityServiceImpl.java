package ko.school.simulation.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.simulation.domain.EntranceInfoVO;
import ko.school.simulation.domain.ExtraPointVO;
import ko.school.simulation.domain.MajorVO;
import ko.school.simulation.domain.ReflectionRatePerSATAreaVO;
import ko.school.simulation.domain.ReflectionRateVO;
import ko.school.simulation.domain.SATScoreVO;
import ko.school.simulation.domain.UniversityVO;
import ko.school.simulation.persistence.UniversityDAO;
import ko.school.simulation.persistence.UniversityDAOImpl;

@Service
public class UniversityServiceImpl implements UniversityService {
	@Inject
	private UniversityDAO dao;

	public List<UniversityVO> universityListService() {
		return dao.universityList();
	}

	@Override
	public List<MajorVO> majorListService() {
		return dao.majorList();
	}

	@Override
	public void insertReflectionRate(ReflectionRateVO reflectRateVO) {
		dao.insertReflectionRate(reflectRateVO);
	}

	@Override
	public void insertExtraPoint(ExtraPointVO extraPointVO) {
		dao.insertExtraPoint(extraPointVO);
	}

	@Override
	public void insertEntranceInfo(EntranceInfoVO entranceInfoVO) {
		dao.insertEntranceInfo(entranceInfoVO);
	}

	@Override
	public void insertReflectionRatePerSATArea(ReflectionRatePerSATAreaVO rrp) {
		dao.insertReflectionRatePerSATArea(rrp);
	}

	@Override
	public void insertSATScore(SATScoreVO satScoreVO) {
		dao.insertSATScore(satScoreVO);
	}

	@Override
	public List<ExtraPointVO> extraPointList() {
		return dao.extraPointList();
	}

	@Override
	public List<ReflectionRatePerSATAreaVO> reflectionRatePerSATAreaList() {
		return dao.reflectionRatePerSATAreaList();
	}

	@Override
	public List<ReflectionRateVO> reflectionRateList() {
		return dao.reflectionRateList();
	}
	
	
}
