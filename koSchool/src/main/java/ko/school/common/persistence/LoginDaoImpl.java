package ko.school.common.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.common.domain.LoginCommand;
import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.SchoolAdminVO;
import ko.school.common.domain.SystemAdminVO;

@Repository
public class LoginDaoImpl implements LoginDao{

	@Inject
	private SqlSession session;
	
	private static String namespace = "ko.school.mapper.LoginMapper";
	
	//액터 ==> 학생,교사  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
	@Override
	public MemberVO memberCheck(LoginCommand loginCommand) {
		return session.selectOne(namespace+".memberCheck",loginCommand);
	}
	//액터 ==> 학부모  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
	@Override
	public ParentVO parentCheck(LoginCommand loginCommand) {
		return session.selectOne(namespace+".parentCheck", loginCommand);
	}
	//액터 ==> 학교관리자  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
	@Override
	public SchoolAdminVO schoolAdminCheck(LoginCommand loginCommand) {
		return session.selectOne(namespace+".schoolAdminCheck", loginCommand);
	}
	//액터 ==> 시스템관리자  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
	@Override
	public SystemAdminVO systemAdminCheck(LoginCommand loginCommand) {
		return session.selectOne(namespace+".systemAdminCheck", loginCommand);
	}

}
