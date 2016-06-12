package ko.school.simulation.service;

import java.util.List;

import ko.school.simulation.domain.EntranceInfoVO;
import ko.school.simulation.domain.ExtraPointVO;
import ko.school.simulation.domain.MajorVO;
import ko.school.simulation.domain.ReflectionRatePerSATAreaVO;
import ko.school.simulation.domain.ReflectionRateVO;
import ko.school.simulation.domain.SATScoreVO;
import ko.school.simulation.domain.UniversityVO;

public interface UniversityService {

	public List<UniversityVO> universityListService();

	public List<MajorVO> majorListService();

	public void insertReflectionRate(ReflectionRateVO reflectRateVO);

	public void insertExtraPoint(ExtraPointVO extraPointVO);

	public void insertEntranceInfo(EntranceInfoVO entranceInfoVO);

	public void insertReflectionRatePerSATArea(ReflectionRatePerSATAreaVO rrp);

	public void insertSATScore(SATScoreVO satScoreVO);

	public List<ExtraPointVO> extraPointList();

	public List<ReflectionRatePerSATAreaVO> reflectionRatePerSATAreaList();

	public List<ReflectionRateVO> reflectionRateList();

	public List<MajorVO> universityMajorList(String universityId);
}
