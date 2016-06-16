package ko.school.simulation.service;

import java.util.List;
import java.util.Map;

import ko.school.simulation.domain.ChooseDetailCommand;
import ko.school.simulation.domain.EntranceInfoVO;
import ko.school.simulation.domain.ExtraPointVO;
import ko.school.simulation.domain.MajorVO;
import ko.school.simulation.domain.MockTestMaxStandardScore;
import ko.school.simulation.domain.ReflectionRatePerSATAreaVO;
import ko.school.simulation.domain.ReflectionRateVO;
import ko.school.simulation.domain.ResearchSubjectMaxScore;
import ko.school.simulation.domain.SATScoreGrade;
import ko.school.simulation.domain.SATScoreVO;
import ko.school.simulation.domain.StudentConvertDTO;
import ko.school.simulation.domain.StudentMockScoreDetail;
import ko.school.simulation.domain.UniversitySATDetail;
import ko.school.simulation.domain.UniversitySATInfoDTO;
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
	
	public UniversitySATDetail universitySATDetail(Map<String, String> map);

	public StudentMockScoreDetail studentMockScoreDetail(Map<String, String> map);
	
	public MockTestMaxStandardScore mockTestMaxStandardScore(Map<String, String> map);
	
	public ResearchSubjectMaxScore researchSubjectMaxScore(Map<String, String> map);
	
	//시뮬레이션
	public StudentConvertDTO simulationCalculation(ChooseDetailCommand chooseDetail);

	public UniversitySATInfoDTO universitySATInfo(ChooseDetailCommand chooseDetail);
	
	//등급 뽑기
	public SATScoreGrade satScoreGrade(ChooseDetailCommand chooseDetail);

}
