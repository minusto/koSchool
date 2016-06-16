package ko.school.simulation.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.simulation.domain.ChooseDetailCommand;
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
import ko.school.simulation.domain.UniversitySATInfoDTO;
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
	
	@Override
	public List<MajorVO> universityMajorList(String universityId) {
		return session.selectList(namespace+".universityMajorList",universityId);
	}
	
	//대학 정시 DETAIL
	@Override
	public UniversitySATDetail universitySATDetail(Map<String, String> map) {
		return session.selectOne(namespace+".universitySATDetail", map);
	}
	
	//학생이본 가장 최근의 모의고사 모든 정보 가져오기
	@Override
	public StudentMockScoreDetail studentMockScoreDetail(Map<String, String> map) {
		return session.selectOne(namespace+".studentMockScoreDetail", map);
	}
	//모의고사 과목별 최고 표준점수 가져오기
	@Override
	public MockTestMaxStandardScore mockTestMaxStandardScore(Map<String, String> map) {
		return session.selectOne(namespace+".mockTestMaxStandardScore", map);
	}
	//모의고사 탐구영역 최고 표준점수 가져오기
	@Override
	public ResearchSubjectMaxScore researchSubjectMaxScore(Map<String, String> map) {
		return session.selectOne(namespace+".researchSubjectMaxScore", map);
	}		
	
	@Override
	public String recentMockId(String studentId) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".recentMockId", studentId);
	}

	@Override
	public String researchSubjectName(String researchSubjectId) {
		return session.selectOne(namespace+".researchSubjectName", researchSubjectId);
	}
	//선택한 대학교명, 학과명, 모집구분(수시,가군,나군,다군) 뽑아오기
	@Override
	public UniversitySATInfoDTO universitySATInfo(ChooseDetailCommand chooseDetail) {
		return session.selectOne(namespace+".universitySATInfo", chooseDetail);
	}				
}
