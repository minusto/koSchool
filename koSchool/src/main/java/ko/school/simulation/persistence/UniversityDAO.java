package ko.school.simulation.persistence;

import java.util.List;
import java.util.Map;

import ko.school.simulation.domain.EntranceInfoVO;
import ko.school.simulation.domain.ExtraPointVO;
import ko.school.simulation.domain.MajorVO;
import ko.school.simulation.domain.MockTestMaxStandardScore;
import ko.school.simulation.domain.ReflectionRatePerSATAreaVO;
import ko.school.simulation.domain.ReflectionRateVO;
import ko.school.simulation.domain.ResearchSubjectMaxScore;
import ko.school.simulation.domain.SATScoreVO;
import ko.school.simulation.domain.StudentMockScoreDetail;
import ko.school.simulation.domain.UniversitySATDetail;
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

	public List<MajorVO> universityMajorList(String universityId);
	
	public UniversitySATDetail universitySATDetail(Map<String, String> map);

	public StudentMockScoreDetail studentMockScoreDetail(Map<String, String> map);
	
	public MockTestMaxStandardScore mockTestMaxStandardScore(Map<String, String> map);
	
	public ResearchSubjectMaxScore researchSubjectMaxScore(Map<String, String> map);
}
