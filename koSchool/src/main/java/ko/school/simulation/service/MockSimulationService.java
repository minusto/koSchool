package ko.school.simulation.service;

import java.util.List;
import java.util.Map;

import ko.school.simulation.domain.HopeUniversityVO;
import ko.school.simulation.domain.MajorVO;
import ko.school.simulation.domain.MockSimulationDTO;
import ko.school.simulation.domain.UniversityVO;

public interface MockSimulationService {
	public List<MockSimulationDTO> selectAllMockUniversityListService() throws Exception; //액터 ==> 학생, 학부모, 교사 / 작업 내용 : 수시가 아닌 모든 입시정보의 EntranceInfo, University, Major 내용 / 작성자 : 구혜인
	
	public HopeUniversityVO selectExistHopeUniversityService(String memberId) throws Exception; //액터 ==> 학생, 학부모, 교사 / 작업 내용 : 학생의 아이디로 입력되어있는 희망 대학을 반환 / 작성자 : 구혜인
	
	public List<UniversityVO> selectUniversityListService() throws Exception; //액터 ==> 학생 / 작업 내용 : EntranceInfo에 있는 대학교 리스트 중 수시가 아닌 info 조회 / 작성자 : 구혜인

	public List<MajorVO> selectMajorListService(String universityId) throws Exception; //액터 ==> 학생 / 작업 내용 : EntranceInfo에 있는 대학교에 해당하는 학과 조회 / 작성자 : 구혜인

	public HopeUniversityVO insertHopeUniversityService(Map<String, String> map) throws Exception; //액터 ==> 학생 / 작업 내용 : 학생이 선택한 희망 대학 학과를 가지고 EntranceInfo에서 조회하여 HopeUniversity에 입력 / 작성자 : 구혜인
	
	//희망대학 출력
	public Integer selectStandardScoreSumService(String memberId) throws Exception; //액터 ==> 학생, 학부모, 교사 / 작업 내용 : 학생이 최근 본 모의고사의 표준점수 총합을 구하기 / 작성자 : 구혜인
	
	public MockSimulationDTO hopeUniversityPrintService(HopeUniversityVO hopeUniversityVo) throws Exception; //액터 ==> 학생, 학부모, 교사 / 작업 내용 : 희망대학에 대한 부분을 출력하기 위한 데이터를 가져간다 / 작성자 : 구혜인
	
	//추천대학
	public List<MockSimulationDTO> recommandUniversityListService(HopeUniversityVO hopeUniversityVo) throws Exception; //액터 ==> 학생, 학부모, 교사 / 작업 내용 : 추천대학 후보 리스트 반환 / 작성자 : 구혜인
	
}
