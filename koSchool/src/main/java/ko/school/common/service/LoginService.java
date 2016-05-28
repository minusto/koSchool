package ko.school.common.service;

import ko.school.common.domain.LoginCommand;
import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.SchoolAdminVO;
import ko.school.common.domain.SystemAdminVO;

public interface LoginService {
	public MemberVO memberCheckService(LoginCommand loginCommand);//액터 ==> 학생,교사  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
	public ParentVO parentCheckService(LoginCommand loginCommand);//액터 ==> 학부모  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
	public SchoolAdminVO schoolAdminCheckService(LoginCommand loginCommand);//액터 ==> 학교관리자  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
	public SystemAdminVO systemAdminCheckService(LoginCommand loginCommand);//액터 ==> 시스템관리자  / 작업내용 : 로그인정보와 일치시 객체리턴 / 작성자 : 이재승
}








