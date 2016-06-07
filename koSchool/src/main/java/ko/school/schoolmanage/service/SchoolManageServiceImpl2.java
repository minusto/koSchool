package ko.school.schoolmanage.service;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.RegistManageVO;
import ko.school.common.domain.StudentVO;
import ko.school.schoolmanage.domain.SchoolRegistVO;
import ko.school.schoolmanage.persistence.SchoolMangeDAO2;


@Service
public class SchoolManageServiceImpl2 implements SchoolManageService2 {

	@Inject
	private SchoolMangeDAO2 dao;

	@Override
	public int insertRegistManage(RegistManageVO registManage) throws Exception {
		return dao.insertRegistManage(registManage);
	}

	@Override
	public int insertMemberId(MemberVO member) throws Exception {
		return dao.insertMemberId(member);
	}
	@Override
	public int insertStudentIdManage(StudentVO student)throws Exception {
		return dao.insertStudentIdManage(student);
	}

	@Override
	public SchoolRegistVO schoolRegistSchoolIdService(String id) throws Exception {
		return dao.schoolRegistSchoolIdService(id);
	}

	@Override
	public List<RegistManageVO> userList(String id) {
		return dao.userList(id);
	}

	@Override
	public int insertParentIdManage(ParentVO parent) throws Exception {
		return dao.insertParentIdManage(parent);
	}
	
}
