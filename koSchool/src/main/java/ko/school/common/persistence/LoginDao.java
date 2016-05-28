package ko.school.common.persistence;

import ko.school.common.domain.LoginCommand;
import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.SchoolAdminVO;
import ko.school.common.domain.SystemAdminVO;

public interface LoginDao {
	
	MemberVO memberCheck(LoginCommand loginCommand);//액터 ==> 학생,교사  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
	ParentVO parentCheck(LoginCommand loginCommand);//액터 ==> 학부모  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
	SchoolAdminVO schoolAdminCheck(LoginCommand loginCommand);//액터 ==> 학교관리자  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
	SystemAdminVO systemAdminCheck(LoginCommand loginCommand);//액터 ==> 시스템관리자  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승

}
