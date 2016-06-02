package ko.school.schoolmanage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
import ko.school.schoolmanage.persistence.SchoolManageDAOImpl;

@Service
public class SchoolManageServiceImpl implements SchoolManageService{
	
	@Inject
	private SchoolManageDAOImpl dao;
	
	@Override
	public void insertSchoolAdmin(SchoolAdminVO saVo,SchoolAdminRegistVO sarVo)throws Exception{
		dao.insertSchoolAdmin(saVo);
		dao.insertSchoolAdminRegist(sarVo);
		
	}
	
	@Override
	public List<SchoolAdminListVO> schoolAdminList()throws Exception{
		return dao.schoolAdminList();
	}

	@Override
	public SchoolAdminDetailVO schoolAdminDetail(String id) throws Exception {
		return dao.schoolAdminDetail(id);
	}

	@Override
	public void updateSchoolAdmin(SchoolAdminVO saVo, SchoolAdminRegistVO sarVo) throws Exception {
		dao.updateSchoolAdmin(saVo);
		dao.updateSchoolAdminRegist(sarVo);
		
	}

	@Override
	public List<SchoolVO> schoolList() throws Exception {
		return dao.schoolList();
	}

	@Override
	public List<SubjectVO> subjectList() throws Exception {
		return dao.subjectList();
	}


	@Override
	public void insertTeacher(MemberVO mVO, TeacherVO tVO) throws Exception {
		dao.insertMemberTeacher(mVO);
		dao.insertTeacher(tVO);
		
	}

	@Override
	public void insertTeacherGrade(RegistManageVO rVO) throws Exception {
		dao.insertTeacherGrade(rVO);
		
	}

	@Override
	public List<TeacherDetailVO> teacherList(String id) throws Exception {
		
		return dao.teacherList(id);
	}

	@Override
	public TeacherDetailVO detailTeacher(String memberId) throws Exception {
		return dao.detailTeacher(memberId);
	}

	@Override
	public void updateMember(MemberVO member) throws Exception {
		dao.updateMember(member);	
	}

	@Override
	public void updateTeacher(TeacherVO teacherVO) throws Exception {
		dao.updateTeacher(teacherVO);
	}
	
	@Override
	public void deleteTeacher1(String memberId) {
		dao.deleteTeacher1(memberId);
	}

	@Override
	public void deleteTeacher2(String memberId) {
		dao.deleteTeacher2(memberId);	
	}
		

		

}
