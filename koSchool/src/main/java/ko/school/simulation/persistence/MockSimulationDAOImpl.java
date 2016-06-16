package ko.school.simulation.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.simulation.domain.EntranceInfoVO;
import ko.school.simulation.domain.HopeUniversityVO;
import ko.school.simulation.domain.MajorVO;
import ko.school.simulation.domain.MockSimulationDTO;
import ko.school.simulation.domain.SATScoreVO;
import ko.school.simulation.domain.UniversityVO;

@Repository
public class MockSimulationDAOImpl implements MockSimulationDAO {
	@Inject
	private SqlSession session;
	
	private static String namespace = "ko.school.mapper.MockSimulationMapper";
	
	//액터 ==> 학생, 학부모, 교사 / 작업 내용 : 수시가 아닌 모든 입시정보의 EntranceInfo, University, Major 내용 / 작성자 : 구혜인
	@Override
	public List<MockSimulationDTO> selectAllMockUniversityList() throws Exception {
		return session.selectList(namespace + ".selectAllMockUniversityList");
	}
	
	//액터 ==> 학생, 학부모, 교사 / 작업 내용 : 학생의 아이디로 입력되어있는 희망 대학을 반환 / 작성자 : 구혜인
	@Override
	public HopeUniversityVO selectExistHopeUniversity(String memberId) throws Exception {
		return session.selectOne(namespace + ".selectExistHopeUniversity", memberId);
	}
	
	//액터 ==> 학생 / 작업 내용 : EntranceInfo에 있는 대학교 리스트 중 수시가 아닌 info 조회 / 작성자 : 구혜인
	@Override
	public List<UniversityVO> selectUniversityList() throws Exception {
		return session.selectList(namespace + ".selectUniversityList");
	}
	
	//액터 ==> 학생 / 작업 내용 : EntranceInfo에 있는 대학교에 해당하는 학과 조회 / 작성자 : 구혜인
	@Override
	public List<MajorVO> selectMajorList(String universityId) throws Exception {
		return session.selectList(namespace + ".selectMajorList", universityId);
	}
	
	//액터 ==> 학생 / 작업 내용 : 학생이 선택한 희망 대학 학과를 가지고 EntranceInfo에 있는 최신 정보 조회 / 작성자 : 구혜인
	@Override
	public EntranceInfoVO selectEIforHopeUniversity(Map<String, String> map) throws Exception {
		return session.selectOne(namespace + ".selectEIforHopeUniversity", map);
	}
	
	//액터 ==> 학생 / 작업 내용 : 학생이 선택한 희망 대학 학과를 가지고 hopuUniversity에 입력 / 작성자 : 구혜인
	@Override
	public void insertHopeUniversity(HopeUniversityVO hopeUniversityVo) throws Exception {
		session.insert(namespace + ".insertHopeUniversity", hopeUniversityVo);
	}
	
	//희망대학 출력
	//액터 ==> 학생, 학부모, 교사 / 작업 내용 : 학생이 최근 본 모의고사의 표준점수 총합을 구하기 / 작성자 : 구혜인
	@Override
	public Integer selectStandardScoreSum(String memberId) throws Exception {
		return session.selectOne(namespace + ".selectStandardScoreSum", memberId);
	}
	
	//액터 ==> 학생, 학부모, 교사 / 작업 내용 : 대학교 아이디로 이름을 반환 / 작성자 : 구혜인
	@Override
	public String selctUniversityName(String universityId) throws Exception {
		return session.selectOne(namespace + ".selctUniversityName", universityId);
	}
	
	//액터 ==> 학생, 학부모, 교사 / 작업 내용 : 학과 아이디로 이름을 반환 / 작성자 : 구혜인
	@Override
	public String selectMajorName(String majorId) throws Exception {
		return session.selectOne(namespace + ".selectMajorName", majorId);
	}
	
	//액터 ==> 학생, 학부모, 교사 / 작업 내용 : satScore테이블의 주키로 해당하는 로우 반환 / 작성자 : 구혜인
	@Override
	public SATScoreVO selectSATScore(HopeUniversityVO hopeUniversityVo) throws Exception {
		return session.selectOne(namespace + ".selectSATScore", hopeUniversityVo);
	}
	
	//추천대학
	//액터 ==> 학생, 학부모, 교사 / 작업 내용 : 모의고사 점수로 추천대학 후보 리스트 반환 (major, university, entranceInto, satScore) / 작성자 : 구혜인
	@Override
	public List<MockSimulationDTO> recommandUniversityListByMock(HopeUniversityVO hopeUniversityVo) throws Exception {
		return session.selectList(namespace + ".recommandUniversityListByMock", hopeUniversityVo);
	}
	
	//액터 ==> 학생, 학부모, 교사 / 작업 내용 : 희망대학 커트라인으로 추천대학 후보 리스트 반환 (major, university, entranceInto, satScore) / 작성자 : 구혜인
	@Override
	public List<MockSimulationDTO> recommandUniversityListByHope(HopeUniversityVO hopeUniversityVo) throws Exception {
		return session.selectList(namespace + ".recommandUniversityListByHope", hopeUniversityVo);
	}
		
	
}


