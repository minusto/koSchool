package ko.school.membermanage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.StudentVO;
import ko.school.membermanage.domain.ParentInsertCommand;
import ko.school.membermanage.domain.ParentList;
import ko.school.membermanage.domain.ParentNullList;
import ko.school.membermanage.domain.StudentDetail;
import ko.school.membermanage.domain.StudentList;
import ko.school.membermanage.persistence.StudentManageDao;

@Service
public class StudentManageServiceImpl implements StudentManageService{
	@Inject
	private StudentManageDao dao;
	
	@Override
	public void updateMember(MemberVO member) throws Exception {
		dao.updateMember(member);
	}

	@Override
	public void updateStudent(StudentVO student) throws Exception {
		dao.updateStudent(student);
	}
	


	@Override
	public List<MemberVO> sameSchoolStudentNullList(String id) throws Exception {
		return dao.sameSchoolStudentNullList(id);
	}

	@Override
	public List<StudentList> studentList(String schoolId) throws Exception {
		return dao.studentList(schoolId);
	}

	@Override
	public StudentDetail selectStudentDetail(String m_id) throws Exception {
		return dao.selectStudentDetail(m_id);
	}

	@Override
	public void deleteStudent(String m_id)throws Exception {
		dao.deleteStudent(m_id);
		
	}

	@Override
	public void deleteStudent2(String m_id)throws Exception {
		dao.deleteStudent2(m_id);
		
	}

	@Override
	public List<ParentNullList> parentNullList() throws Exception {
		return dao.parentNullList();
	}

	@Override
	public void insertParent(ParentInsertCommand command)throws Exception {
		dao.insertParent(command);
	}

	@Override
	public List<ParentList> parentList() throws Exception {
		return dao.parentList();
	}

	@Override
	public String getStudentPic(MemberVO member) throws Exception {
		return dao.getStudentPic(member);
	}

	@Override
	public void parentUpdateMember(MemberVO member) {
		dao.parentUpdateMember(member);
	}
	
	

	
}
