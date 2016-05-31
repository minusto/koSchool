package ko.school.schoolmanage.service;

import ko.school.schoolmanage.domain.SchoolRegistVO;
import ko.school.schoolmanage.domain.SchoolVO;

public interface SchoolService {
	public void insertSchoolService(SchoolVO schoolVo, SchoolRegistVO schoolRegistVo) throws Exception; //액터 ==> 학교관리자 / 작업 내용 : 학교 등록, 학교 정보 입력 / 작성자 : 구혜인
	
	public SchoolVO detailSchoolService(String schoolAdminId) throws Exception; //액터 ==> 학교관리자 / 작업 내용 : 학교 관리자 아이디로 학교 정보 조회 / 작성자 : 구혜인
	
	public void schoolUpdateService(SchoolVO schoolVo) throws Exception; //액터 ==> 학교관리자 / 작업 내용 : 학교 정보 수정 / 작성자 : 구혜인
}
