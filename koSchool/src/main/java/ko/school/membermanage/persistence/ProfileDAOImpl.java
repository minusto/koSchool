package ko.school.membermanage.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.TeacherVO;

@Repository
public class ProfileDAOImpl implements ProfileDAO {
	@Inject
	private SqlSession session;
	
	private static String namespace
	="ko.school.mapper.ProfileMapper";
	
	@Override
	public String getTeacherPic(MemberVO mVO) throws Exception {
		
		return session.selectOne(namespace+".getTeacherPic",mVO);
	}

	@Override
	public void updateMemberTeacher(MemberVO mVO) throws Exception {
		session.update(namespace+".updateMemberTeacher",mVO);
		
	}

	@Override
	public void updateTeacher(TeacherVO tVO) throws Exception {
		session.update(namespace+".updateTeacher",tVO);
		
	}
	
	

}
