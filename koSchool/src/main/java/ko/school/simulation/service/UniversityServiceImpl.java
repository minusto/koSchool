package ko.school.simulation.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
import ko.school.simulation.persistence.UniversityDAO;

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
	
	@Override
	public List<MajorVO> universityMajorList(String universityId) {
		return dao.universityMajorList(universityId);
	}
	
	//대학 정시 DETAIL
	@Override
	public UniversitySATDetail universitySATDetail(Map<String, String> map) {
		return dao.universitySATDetail(map);
	}
	//학생이본 가장 최근의 모의고사 모든 정보 가져오기
	@Override
	public StudentMockScoreDetail studentMockScoreDetail(Map<String, String> map) {
		return dao.studentMockScoreDetail(map);
	}
	//모의고사 과목별 최고 표준점수 가져오기
	@Override
	public MockTestMaxStandardScore mockTestMaxStandardScore(Map<String, String> map) {
		return dao.mockTestMaxStandardScore(map);
	}
	//모의고사 탐구영역 최고 표준점수 가져오기
	@Override
	public ResearchSubjectMaxScore researchSubjectMaxScore(Map<String, String> map) {
		return dao.researchSubjectMaxScore(map);
	}
}
