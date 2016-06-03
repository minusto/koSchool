package ko.school.common.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.common.domain.LoginCommand;
import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.SchoolAdminVO;
import ko.school.common.domain.StudentVO;
import ko.school.common.domain.SystemAdminVO;
import ko.school.common.domain.TeacherVO;
import ko.school.common.persistence.LoginDao;

@Service
public class LoginServiceImpl implements LoginService{

	@Inject
	private LoginDao loginDao;
	
	//액터 ==> 학생,교사  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
	@Override
	public MemberVO memberCheckService(LoginCommand loginCommand) {
		return loginDao.memberCheck(loginCommand);
	}

	//액터 ==> 학부모  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
	@Override
	public ParentVO parentCheckService(String memberId) {
		return loginDao.parentCheck(memberId);
	}

	//액터 ==> 학교관리자  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
	@Override
	public SchoolAdminVO schoolAdminCheckService(LoginCommand loginCommand) {
		return loginDao.schoolAdminCheck(loginCommand);
	}

	//액터 ==> 시스템관리자  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
	@Override
	public SystemAdminVO systemAdminCheckService(LoginCommand loginCommand) {
		return loginDao.systemAdminCheck(loginCommand);
	}
	//액터 ==> 학생  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
	@Override
	public StudentVO studentCheckService(String memberId) {
		return loginDao.studentCheck(memberId);
	}
	//액터 ==> 교사  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
	@Override
	public TeacherVO teacherCheckService(String memberId) {
		return loginDao.teacherCheck(memberId);
	}

}
