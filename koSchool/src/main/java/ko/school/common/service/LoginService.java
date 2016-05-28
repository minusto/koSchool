package ko.school.common.service;

import ko.school.common.domain.LoginCommand;
import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.SchoolAdminVO;
import ko.school.common.domain.SystemAdminVO;

public interface LoginService {
	public MemberVO memberCheckService(LoginCommand loginCommand);
	public ParentVO parentCheckService(LoginCommand loginCommand);
	public SchoolAdminVO schoolAdminCheckService(LoginCommand loginCommand);
	public SystemAdminVO systemAdminCheckService(LoginCommand loginCommand);
}
