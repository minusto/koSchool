package ko.school.message.persistence;

import java.util.List;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.message.domain.SchoolNewsLetterSignVO;
import ko.school.message.domain.SchoolNewsLetterVO;

public interface SchoolNewsLetterDAO {
	public void schoolNewsLetterInsert(SchoolNewsLetterVO schoolNews);// 가정통신문 발송
	public List<SchoolNewsLetterVO> schoolNewsLetterList(SchoolNewsLetterVO schoolNews); //가정통신문 list
	public List<ParentVO> teacherParentList(SchoolNewsLetterVO schoolNews); //가정통신문(교사) 학부모 서명 list 
	public void schoolNewsLetterSignInsert(SchoolNewsLetterSignVO sign); //
	public String teacherMemberId(ParentVO member);
	public String memberGradeByMemberId(ParentVO member);//학부모등급구하기
	public SchoolNewsLetterVO schoolNewsLetterDetail(int schoolNewsLetterNum);//학부모 가정통신문 디테일
	public void schoolNewsLetterSignUpdate(SchoolNewsLetterSignVO schoolNewsLetterSignVO);
	public List<SchoolNewsLetterSignVO> schoolNewsLetterSignList(SchoolNewsLetterSignVO schoolNewsLetterSignVO);
}
