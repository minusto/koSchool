package ko.school.common.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.common.domain.LoginCommand;
import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.SchoolAdminVO;
import ko.school.common.domain.SystemAdminVO;
import ko.school.common.persistence.LoginDao;

@Service
public class LoginServiceImpl implements LoginService{

	
	@Inject
	private LoginDao loginDao;
	
	//Member테이블 사용자(학생,교사) 로그인시 ID,PASSWORD 체크
	@Override
	public MemberVO memberCheckService(LoginCommand loginCommand) {
		return loginDao.memberCheck(loginCommand);
	}

	//parent테이블 사용자(학부모) 로그인시 ID,PASSWORD 체크
	@Override
	public ParentVO parentCheckService(LoginCommand loginCommand) {
		return loginDao.parentCheck(loginCommand);
	}

	//schoolAdmin 테이블 사용자(학교관리자) 로그인시 ID,PASSWORD 체크
	@Override
	public SchoolAdminVO schoolAdminCheckService(LoginCommand loginCommand) {
		return loginDao.schoolAdminCheck(loginCommand);
	}

	//systemAdmin 테이블 사용자(시스템관리자) 로그인시 ID,PASSWORD 체크
	@Override
	public SystemAdminVO systemAdminCheckService(LoginCommand loginCommand) {
		return loginDao.systemAdminCheck(loginCommand);
	}

}
