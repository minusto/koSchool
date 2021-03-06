package ko.school.simulation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.simulation.domain.EntranceInfoVO;
import ko.school.simulation.domain.HopeUniversityVO;
import ko.school.simulation.domain.MajorVO;
import ko.school.simulation.domain.MockSimulationDTO;
import ko.school.simulation.domain.SATScoreVO;
import ko.school.simulation.domain.UniversityVO;
import ko.school.simulation.persistence.MockSimulationDAO;

@Service
public class MockSimulationServiceImpl implements MockSimulationService {
	@Inject
	private MockSimulationDAO dao;
	
	//액터 ==> 학생, 학부모, 교사 / 작업 내용 : 수시가 아닌 모든 입시정보의 EntranceInfo, University, Major 내용 / 작성자 : 구혜인
	@Override
	public List<MockSimulationDTO> selectAllMockUniversityListService() throws Exception {
		return dao.selectAllMockUniversityList();
	}
	
	//액터 ==> 학생, 학부모, 교사 / 작업 내용 : 학생의 아이디로 입력되어있는 목표 대학을 반환 / 작성자 : 구혜인
	@Override
	public HopeUniversityVO selectExistHopeUniversityService(String memberId) throws Exception {
		return dao.selectExistHopeUniversity(memberId);
	}
	
	//액터 ==> 학생 / 작업 내용 : EntranceInfo에 있는 대학교 리스트 중 수시가 아닌 info 조회 / 작성자 : 구혜인
	@Override
	public List<UniversityVO> selectUniversityListService() throws Exception {
		return dao.selectUniversityList();
	}
	
	//액터 ==> 학생 / 작업 내용 : EntranceInfo에 있는 대학교에 해당하는 학과 조회 / 작성자 : 구혜인
	@Override
	public List<MajorVO> selectMajorListService(String universityId) throws Exception {
		return dao.selectMajorList(universityId);
	}
	
	//액터 ==> 학생 / 작업 내용 : 학생이 선택한 목표 대학 학과를 가지고 EntranceInfo에서 조회하여 HopeUniversity에 입력 / 작성자 : 구혜인
	@Override
	public HopeUniversityVO insertHopeUniversityService(Map<String, String> map) throws Exception {
		EntranceInfoVO entranceInfoVo = dao.selectEIforHopeUniversity(map);
		HopeUniversityVO hopeUniversityVo = new HopeUniversityVO();
		hopeUniversityVo.setMemberId(map.get("memberId"));
		hopeUniversityVo.setUniversityId(entranceInfoVo.getUniversityId());
		hopeUniversityVo.setMajorId(entranceInfoVo.getMajorId());
		hopeUniversityVo.setEntranceYear(entranceInfoVo.getEntranceYear());
		hopeUniversityVo.setRecruitSeparate(entranceInfoVo.getRecruitSeparate());
		
		dao.insertHopeUniversity(hopeUniversityVo);
		return hopeUniversityVo;
	}
	
	//목표대학 출력
	//액터 ==> 학생, 학부모, 교사 / 작업 내용 : 학생이 최근 본 모의고사의 표준점수 총합을 구하기 / 작성자 : 구혜인
	@Override
	public Integer selectStandardScoreSumService(String memberId) throws Exception {
		return dao.selectStandardScoreSum(memberId);
	}
	
	//액터 ==> 학생, 학부모, 교사 / 작업 내용 : 목표대학에 대한 부분을 출력하기 위한 데이터를 가져간다 / 작성자 : 구혜인
	@Override
	public MockSimulationDTO hopeUniversityPrintService(HopeUniversityVO hopeUniversityVo) throws Exception {
		MockSimulationDTO mockSimulationDTO = new MockSimulationDTO();
		mockSimulationDTO.setUniversityId(hopeUniversityVo.getUniversityId());
		mockSimulationDTO.setMajorId(hopeUniversityVo.getMajorId());
		mockSimulationDTO.setRecruitSeparate(hopeUniversityVo.getRecruitSeparate());
		mockSimulationDTO.setEntranceYear(hopeUniversityVo.getEntranceYear());

		mockSimulationDTO.setUniversityName(dao.selctUniversityName(hopeUniversityVo.getUniversityId()));
		mockSimulationDTO.setMajorName(dao.selectMajorName(hopeUniversityVo.getMajorId()));
		
		SATScoreVO satScoreVo = dao.selectSATScore(hopeUniversityVo);
		mockSimulationDTO.setStandardScoreCutline(satScoreVo.getStandardScoreCutline());
		return mockSimulationDTO;
	}
	
	
	//추천대학
	@Override
	public List<MockSimulationDTO> recommandUniversityListService(HopeUniversityVO hopeUniversityVo) throws Exception {
		List<MockSimulationDTO> recommandAllList = null;
		List<MockSimulationDTO> recommandList = new ArrayList<MockSimulationDTO>();
		
		Integer mockScore = dao.selectStandardScoreSum(hopeUniversityVo.getMemberId());
		if(mockScore != null) { //모의고사 점수가 있는 경우 모의고사 점수를 이용하여 대학 추천
			recommandAllList = dao.recommandUniversityListByMock(hopeUniversityVo);
		} else {
			if(hopeUniversityVo.getUniversityId() != null) { //모의고사 점수가 없는 경우 목표대학이 있을 때만 추천
				recommandAllList = dao.recommandUniversityListByHope(hopeUniversityVo);
			}
		}
		
		if(!recommandAllList.isEmpty()) { //제일 점수차가 적은 3개만 반환해줌
			recommandList.add(recommandAllList.get(0));
			System.out.println(recommandList.get(0).getUniversityName());
			if(recommandAllList.size() >= 2) {
				recommandList.add(recommandAllList.get(1));
			}
			if(recommandAllList.size() >= 3) {
				recommandList.add(recommandAllList.get(2));				
			}
		} else {
			recommandList = null;
			System.out.println("list is null");
		}
		
		return recommandList;
	}
	
	
}


