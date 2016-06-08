package ko.school.schoolmanage.persistence;

import java.util.List;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.RegistManageVO;
import ko.school.common.domain.SchoolAdminVO;
import ko.school.common.domain.TeacherVO;
import ko.school.schoolmanage.domain.SchoolAdminDetailVO;
import ko.school.schoolmanage.domain.SchoolAdminListVO;
import ko.school.schoolmanage.domain.SchoolAdminRegistVO;
import ko.school.schoolmanage.domain.SchoolVO;
import ko.school.schoolmanage.domain.SubjectVO;
import ko.school.schoolmanage.domain.TeacherDetailVO;

public interface SchoolManageDAO {
	public void insertSchoolAdmin(SchoolAdminVO vo)throws Exception;
	
	public void insertSchoolAdminRegist(SchoolAdminRegistVO vo)throws Exception;
	
	public List<SchoolAdminListVO> schoolAdminList()throws Exception;
	
	public SchoolAdminDetailVO schoolAdminDetail(String id)throws Exception;
	
	public void updateSchoolAdmin(SchoolAdminVO vo)throws Exception;
	
	public void updateSchoolAdminRegist(SchoolAdminRegistVO vo)throws Exception;
	
	public List<SchoolVO> schoolList()throws Exception;
	
	public List<SubjectVO> subjectList()throws Exception;
	
	public void insertMemberTeacher(MemberVO mVO)throws Exception;
	
	public void insertTeacher(TeacherVO tVO)throws Exception;
	
	public void insertTeacherGrade(RegistManageVO rVO)throws Exception;
	
	public List<TeacherDetailVO> teacherList(String id)throws Exception;
	
	public TeacherDetailVO detailTeacher(String memberId)throws Exception; 
	
	public void updateMember(MemberVO member)throws Exception;
	public void updateTeacher(TeacherVO teacherVO)throws Exception;
	
	public void deleteTeacher1(String memberId)throws Exception;
	public void deleteTeacher2(String memberId)throws Exception;
	
	public String selectSchoolIdBySchoolAdminID(String schoolAdminId) throws Exception; //액터 : 학교관리자 / 작업 : 교사등록폼에서 학교 관리자의 학교 ID를 박아주기. 학교관리자의 ID로 학교 ID 불러오기 / 작성자 : 구혜인

}
