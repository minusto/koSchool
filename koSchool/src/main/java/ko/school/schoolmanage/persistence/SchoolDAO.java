package ko.school.schoolmanage.persistence;

import ko.school.schoolmanage.domain.SchoolRegistVO;
import ko.school.schoolmanage.domain.SchoolVO;

public interface SchoolDAO {
	public void insertSchool(SchoolVO schoolVo) throws Exception; //액터 ==> 학교관리자 / 작업 내용 : 학교 등록 - 학교 정보 입력 / 작성자 : 구혜인
	
	public void insertSchoolRegister(SchoolRegistVO schoolRegistVo) throws Exception; //액터 ==> 학교관리자 / 작업 내용 : 학교 등록 / 작성자 : 구혜인
	
	public SchoolRegistVO schoolRegistSchoolId(String schoolAdminId) throws Exception; //액터 ==> 학교관리자 / 작업 내용 : 학교 정보 조회 - 학교 관리자 id로 학교 등록 정보 조회 / 작성자 : 구혜인
	
	public SchoolVO schoolDetail(String schoolId) throws Exception; //액터 ==> 학교관리자 / 작업 내용 : 학교 정보 조회 / 작성자 : 구혜인
	
	public void schoolUpdate(SchoolVO schoolVo) throws Exception; //액터 ==> 학교관리자 / 작업 내용 : 학교 정보 수정 / 작성자 : 구혜인
}
