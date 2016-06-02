package ko.school.membermanage.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.TeacherVO;
import ko.school.membermanage.persistence.ProfileDAO;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	
	@Inject
	private ProfileDAO dao;

	@Override
	public String getTeacherPic(MemberVO mVO) throws Exception {
		return dao.getTeacherPic(mVO);
	}

	@Override
	public void updateTeacher(MemberVO mVO, TeacherVO tVO) throws Exception {
		dao.updateMemberTeacher(mVO);
		dao.updateTeacher(tVO);
		
	}
	
	

}
