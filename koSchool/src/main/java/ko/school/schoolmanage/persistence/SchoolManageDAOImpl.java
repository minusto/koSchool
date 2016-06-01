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
	
	
	
	
	
	
	
	
	
	
	

}