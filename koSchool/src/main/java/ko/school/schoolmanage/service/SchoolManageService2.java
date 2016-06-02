package ko.school.schoolmanage.service;

import java.util.List;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.RegistManageVO;
import ko.school.common.domain.StudentVO;
import ko.school.schoolmanage.domain.SchoolRegistVO;

public interface SchoolManageService2 {
	public int insertRegistManage(RegistManageVO registManage)throws Exception;//사용자 등급등록
	public int insertMemberId(MemberVO member)throws Exception;//사용자 iD등록
	public int insertStudentIdManage(StudentVO student)throws Exception;//학생아이디 등록+나머지 null;
	public SchoolRegistVO schoolRegistSchoolIdService(String id)throws Exception; // 학교아이디,관리자아이디 세션
	public List<RegistManageVO> userList(String id); //유저리스트
	
}
