package ko.school.message.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.message.domain.SchoolNewsLetterSignVO;
import ko.school.message.domain.SchoolNewsLetterVO;
import ko.school.message.persistence.SchoolNewsLetterDAO;

@Service
public class SchoolNewsLetterServiceImpl implements SchoolNewsLetterService{
	@Inject
	private SchoolNewsLetterDAO dao;
	
	
	@Override
	public void schoolNewsLetterInsert(SchoolNewsLetterVO schoolNews) {
			dao.schoolNewsLetterInsert(schoolNews);
	}
	@Override
	public List<SchoolNewsLetterVO> schoolNewsLetterList(SchoolNewsLetterVO schoolNews) {
		return dao.schoolNewsLetterList(schoolNews);
	}
	@Override
	public List<ParentVO> teacherParentList(SchoolNewsLetterVO schoolNews) {
		return dao.teacherParentList(schoolNews);
	}
	@Override
	public void schoolNewsLetterSignInsert(SchoolNewsLetterSignVO sign) {
		dao.schoolNewsLetterSignInsert(sign);
	}
	@Override
	public String teacherMemberId(ParentVO member) {
		return dao.teacherMemberId(member);
	}
	@Override
	public String memberGradeByMemberId(ParentVO member) {
		return dao.memberGradeByMemberId(member);
	}
	@Override
	public SchoolNewsLetterVO schoolNewsLetterDetail(int schoolNewsLetterNum) {	
		return dao.schoolNewsLetterDetail(schoolNewsLetterNum);
	}
	@Override
	public void schoolNewsLetterSignUpdate(SchoolNewsLetterSignVO schoolNewsLetterSignVO) {
		dao.schoolNewsLetterSignUpdate(schoolNewsLetterSignVO);
	}
	@Override
	public List<SchoolNewsLetterSignVO> schoolNewsLetterSignList(SchoolNewsLetterSignVO schoolNewsLetterSignVO) {
		return dao.schoolNewsLetterSignList(schoolNewsLetterSignVO);
	}

}
