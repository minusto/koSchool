package ko.school.schoolmanage.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.RegistManageVO;
import ko.school.common.domain.StudentVO;
import ko.school.schoolmanage.domain.SchoolRegistVO;


@Repository
public class SchoolManageDAOImol2 implements SchoolMangeDAO2 {
	
	@Inject
	private SqlSession sqlsession;
	private static String namespace = "ko.school.mappers.schoolmanageTwoMapper";

	@Override
	public int insertRegistManage(RegistManageVO registManage) throws Exception {
		return sqlsession.insert(namespace + ".insertRegistManage" , registManage);
	}

	@Override
	public int insertMemberId(MemberVO member) throws Exception {
		return sqlsession.insert(namespace + ".insertMemberId",member);
	}

	@Override
	public int insertStudentIdManage(StudentVO student)throws Exception {
		return sqlsession.insert(namespace + ".insertStudentIdManage" , student);
	}


	@Override
	public SchoolRegistVO schoolRegistSchoolIdService(String id) throws Exception {
		return sqlsession.selectOne(namespace + ".schoolRegistSchoolId" , id);
	}

	@Override
	public List<RegistManageVO> userList(String id) {
		return sqlsession.selectList(namespace + ".userList" , id);
	}

	@Override
	public int insertParentIdManage(ParentVO parent) throws Exception {
		return sqlsession.insert(namespace + ".insertParentIdManage" , parent);
	}

}
