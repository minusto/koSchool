package ko.school.simulation.persistence;

import java.util.List;

import ko.school.simulation.domain.EntranceInfoVO;
import ko.school.simulation.domain.ExtraPointVO;
import ko.school.simulation.domain.MajorVO;
import ko.school.simulation.domain.ReflectionRatePerSATAreaVO;
import ko.school.simulation.domain.ReflectionRateVO;
import ko.school.simulation.domain.SATScoreVO;
import ko.school.simulation.domain.UniversityVO;

public interface UniversityDAO {

	public List<UniversityVO> universityList();

	public List<MajorVO> majorList();

	public void insertReflectionRate(ReflectionRateVO reflectRateVO);

	public void insertExtraPoint(ExtraPointVO extraPointVO);

	public void insertEntranceInfo(EntranceInfoVO entranceInfoVO);

	public void insertReflectionRatePerSATArea(ReflectionRatePerSATAreaVO rrp);

	public void insertSATScore(SATScoreVO satScoreVO);

	public List<ExtraPointVO> extraPointList();

	public List<ReflectionRatePerSATAreaVO> reflectionRatePerSATAreaList();

	public List<ReflectionRateVO> reflectionRateList();

}
