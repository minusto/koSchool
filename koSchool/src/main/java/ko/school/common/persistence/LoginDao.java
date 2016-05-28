package ko.school.common.persistence;

import ko.school.common.domain.LoginCommand;
import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.SchoolAdminVO;
import ko.school.common.domain.SystemAdminVO;

public interface LoginDao {

	MemberVO memberCheck(LoginCommand loginCommand);

	ParentVO parentCheck(LoginCommand loginCommand);

	SchoolAdminVO schoolAdminCheck(LoginCommand loginCommand);

	SystemAdminVO systemAdminCheck(LoginCommand loginCommand);

}
