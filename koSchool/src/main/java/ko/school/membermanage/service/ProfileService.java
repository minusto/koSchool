package ko.school.membermanage.service;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.SchoolAdminVO;
import ko.school.common.domain.TeacherVO;

public interface ProfileService {
	public String getTeacherPic(MemberVO mVO)throws Exception;

	public void updateTeacher(MemberVO mVO, TeacherVO tVO)throws Exception;

	public void schoolAdminUpdate(SchoolAdminVO saVO)throws Exception;
	
	public void updateStudentPword(MemberVO mVO) throws Exception;
}
