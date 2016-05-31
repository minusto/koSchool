package ko.school.membermanage.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.StudentVO;
import ko.school.membermanage.domain.ParentList;
import ko.school.membermanage.domain.ParentNullList;
import ko.school.membermanage.domain.StudentDetail;
import ko.school.membermanage.domain.StudentList;


@Repository
public class StudentManageDaoImpl implements StudentManageDao {

	@Inject
	private SqlSession session;
	
	private static String namespace="ko.school.mapper.MemberManageMapper";
	
	@Override
	public void updateMember(MemberVO member) throws Exception {
		session.update(namespace+".updateMember",member);
	}

	@Override
	public void updateStudent(StudentVO student) throws Exception {
		session.update(namespace+".updateStudent",student);
	}

	@Override
	public List<MemberVO> sameSchoolStudentNullList(String id) throws Exception {
		return session.selectList(namespace+".sameSchoolStudentNullList",id);
	}

	@Override
	public List<StudentList> studentList(String schoolId) throws Exception {
		return session.selectList(namespace+".studentList",schoolId);
	}

	@Override
	public StudentDetail selectStudentDetail(String m_id) throws Exception {
		return session.selectOne(namespace+".selectStudentDetail",m_id);
	}

	@Override
	public void deleteStudent(String m_id)throws Exception{
		session.update(namespace+".deleteStudent",m_id);
		
	}

	@Override
	public void deleteStudent2(String m_id)throws Exception{
		session.update(namespace+".deleteStudent2",m_id);
		
	}

	@Override
	public List<ParentNullList> parentNullList() throws Exception {
		return session.selectList(namespace+".parentNullList");
	}

	@Override
	public void insertParent(ParentVO parent)throws Exception{
		session.insert(namespace+".insertParent",parent);
	}

	@Override
	public List<ParentList> parentList() throws Exception {
		return session.selectList(namespace+".parentList");
	}


}
