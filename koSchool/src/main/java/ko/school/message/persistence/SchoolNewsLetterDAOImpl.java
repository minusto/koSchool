package ko.school.message.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.message.domain.SchoolNewsLetterSignVO;
import ko.school.message.domain.SchoolNewsLetterVO;

@Repository
public class SchoolNewsLetterDAOImpl implements SchoolNewsLetterDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "ko.school.mapper.schoolNewsLetterMapper";

	@Override
	public void schoolNewsLetterInsert(SchoolNewsLetterVO schoolNews) {
		session.insert(namespace+".schoolNewsLetterInsert", schoolNews);
		
	}
	@Override
	public List<SchoolNewsLetterVO> schoolNewsLetterList(SchoolNewsLetterVO schoolNews) {
		return session.selectList(namespace + ".schoolNewsLetterList", schoolNews);
	}
	@Override
	public List<ParentVO> teacherParentList(SchoolNewsLetterVO schoolNews) {
		
		return session.selectList(namespace + ".teacherParentList" , schoolNews);
	}
	@Override
	public void schoolNewsLetterSignInsert(SchoolNewsLetterSignVO sign) {
			session.insert(namespace + ".schoolNewsLetterSignInsert" , sign);
	}
	@Override
	public String teacherMemberId(ParentVO member) {
		return session.selectOne(namespace + ".teacherMemberId" , member);
	}
	@Override
	public String memberGradeByMemberId(ParentVO member) {
		return session.selectOne(namespace + ".memberGradeByMemberId" , member);
	}
	@Override
	public SchoolNewsLetterVO schoolNewsLetterDetail(int schoolNewsLetterNum) {
		return session.selectOne(namespace + ".schoolNewsLetterDetail" , schoolNewsLetterNum);
	}
	@Override
	public void schoolNewsLetterSignUpdate(SchoolNewsLetterSignVO schoolNewsLetterSignVO) {
		session.update(namespace + ".schoolNewsLetterSignUpdate" , schoolNewsLetterSignVO);
	}
	@Override
	public List<SchoolNewsLetterSignVO> schoolNewsLetterSignList(SchoolNewsLetterSignVO schoolNewsLetterSignVO) {
		return session.selectList(namespace + ".schoolNewsLetterSignList" , schoolNewsLetterSignVO);
	}
}