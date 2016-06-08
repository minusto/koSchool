package ko.school.schoolmanage.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

@Repository
public class SchoolManageDAOImpl implements SchoolManageDAO{
	
	@Inject
	private SqlSession session;
	
	private static String namespace
    ="ko.school.mapper.ShcoolmanageMapper";
	
	@Override
	public void insertSchoolAdmin(SchoolAdminVO vo)throws Exception{
		session.insert(namespace+".insertSchoolAdmin",vo);
	}
	
	@Override
	public void insertSchoolAdminRegist(SchoolAdminRegistVO vo)throws Exception{
		session.insert(namespace+".insertSchoolAdminRegist",vo);
	}
	
	@Override
	public List<SchoolAdminListVO> schoolAdminList()throws Exception{
		return session.selectList(namespace+".schoolAdminList");
	}

	@Override
	public SchoolAdminDetailVO schoolAdminDetail(String id) throws Exception {
		return session.selectOne(namespace+".schoolAdminDetail",id);
	}

	@Override
	public void updateSchoolAdmin(SchoolAdminVO vo) throws Exception {
		session.update(namespace+".updateSchoolAdmin",vo);
		
	}

	@Override
	public void updateSchoolAdminRegist(SchoolAdminRegistVO vo) throws Exception {
		session.update(namespace+".updateSchoolAdminRegist",vo);
		
	}

	@Override
	public List<SchoolVO> schoolList() throws Exception {
		return session.selectList(namespace+".schoolList");
	}

	@Override
	public List<SubjectVO> subjectList() throws Exception {
		return session.selectList(namespace+".subjectList");
	}

	@Override
	public void insertMemberTeacher(MemberVO mVO) throws Exception {
		session.insert(namespace+".insertMemberTeacher",mVO);
		
	}

	@Override
	public void insertTeacher(TeacherVO tVO) throws Exception {
		session.insert(namespace+".insertTeacher",tVO);
		
	}

	@Override
	public void insertTeacherGrade(RegistManageVO rVO) throws Exception {
		session.insert(namespace+".insertTeacherGrade",rVO);
		
	}

	@Override
	public List<TeacherDetailVO> teacherList(String id) throws Exception {
		
		return session.selectList(namespace+".teacherList",id);
	}

	@Override
	public TeacherDetailVO detailTeacher(String memberId) throws Exception {		
		return session.selectOne(namespace + ".detailTeacher" , memberId);
	}

	@Override
	public void updateMember(MemberVO member) throws Exception {
		System.out.println("=== dao start");
		System.out.println("=== memberName :: " + member.getMemberName());
		System.out.println("=== memberBirthday :: " + member.getMemberBirthday());
		System.out.println("=== memberTel :: " + member.getMemberTel());
		System.out.println("=== memberEmail :: " + member.getMemberEmail());
		System.out.println("=== memberId :: " + member.getMemberId());
		session.update(namespace + ".updateMember" , member);
		System.out.println("=== dao end");
	}

	@Override
	public void updateTeacher(TeacherVO teacherVO) throws Exception {
		session.update(namespace + ".updateTeacher" , teacherVO);
	}
	
	public void deleteTeacher1(String memberId) {
		session.delete(namespace + ".deleteTeacher1" , memberId);
	}

	public void deleteTeacher2(String memberId) {
		session.delete(namespace + ".deleteTeacher2" , memberId);
	}
	
	//액터 : 학교관리자 / 작업 : 교사등록폼에서 학교 관리자의 학교 ID를 박아주기. 학교관리자의 ID로 학교 ID 불러오기 / 작성자 : 구혜인
	@Override
	public String selectSchoolIdBySchoolAdminID(String schoolAdminId) throws Exception {
		return session.selectOne(namespace + ".selectSchoolIdBySchoolAdminID", schoolAdminId);
	}
	
	


}
