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
	
	@Override
	public MemberVO memberCheck(LoginCommand loginCommand) {
		return session.selectOne(namespace+".memberCheck",loginCommand);
	}

	@Override
	public ParentVO parentCheck(LoginCommand loginCommand) {
		return session.selectOne(namespace+".parentCheck", loginCommand);
	}

	@Override
	public SchoolAdminVO schoolAdminCheck(LoginCommand loginCommand) {
		return session.selectOne(namespace+".schoolAdminCheck", loginCommand);
	}

	@Override
	public SystemAdminVO systemAdminCheck(LoginCommand loginCommand) {
		return session.selectOne(namespace+".systemAdminCheck", loginCommand);
	}

}
