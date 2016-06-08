package ko.school.membermanage.persistence;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.SchoolAdminVO;
import ko.school.common.domain.TeacherVO;

public interface ProfileDAO {
	public String getTeacherPic(MemberVO mVO)throws Exception;
	
	public void updateMemberTeacher(MemberVO mVO)throws Exception;
	
	public void updateTeacher(TeacherVO tVO)throws Exception;
	
	public void schoolAdminUpdate(SchoolAdminVO saVO)throws Exception;
	
	public void updateStudentPword(MemberVO mVO)throws Exception;
	
	

}
