package ko.school.schoolmanage.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.schoolmanage.domain.SchoolRegistVO;
import ko.school.schoolmanage.domain.SchoolVO;

@Repository
public class SchoolDAOImpl implements SchoolDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "ko.school.mapper.SchoolMapper";
	
	//액터 ==> 학교관리자 / 작업 내용 : 학교 등록 - 학교 정보 입력 / 작성자 : 구혜인
	@Override
	public void insertSchool(SchoolVO schoolVo) throws Exception {
		session.insert(namespace + ".insertSchool", schoolVo);
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 학교 등록 / 작성자 : 구혜인
	@Override
	public void insertSchoolRegister(SchoolRegistVO schoolRegistVo) throws Exception {
		session.insert(namespace + ".insertSchoolRegist", schoolRegistVo);
	}

	//액터 ==> 학교관리자 / 작업 내용 : 학교 정보 조회 - 학교 관리자 id로 학교 등록 정보 조회 / 작성자 : 구혜인
	@Override
	public SchoolRegistVO schoolRegistSchoolId(String schoolAdminId) throws Exception {
		return session.selectOne(namespace + ".schoolRegistSchoolId", schoolAdminId);
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 학교 정보 조회 - 학교 id로 학교 정보 조회 / 작성자 : 구혜인
	@Override
	public SchoolVO schoolDetail(String schoolId) throws Exception {
		return session.selectOne(namespace + ".schoolDetail", schoolId);
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 학교 정보 수정 / 작성자 : 구혜인
	@Override
	public void schoolUpdate(SchoolVO schoolVo) throws Exception {
		session.insert(namespace + ".schoolUpdate", schoolVo);
	}
	
	

	
}
