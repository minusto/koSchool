package ko.school.message.service;

import java.util.List;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.message.domain.SchoolNewsLetterSignVO;
import ko.school.message.domain.SchoolNewsLetterVO;

public interface SchoolNewsLetterService {
	public void schoolNewsLetterInsert(SchoolNewsLetterVO schoolNews);// 가정통신문 발송
	public List<SchoolNewsLetterVO> schoolNewsLetterList(SchoolNewsLetterVO schoolNews); //가정통신문 list
	
	public List<ParentVO> teacherParentList(SchoolNewsLetterVO schoolNews); //가정통신문 부모별 list
	public void schoolNewsLetterSignInsert(SchoolNewsLetterSignVO sign); // 가정통신문 부모별 insert
	public String teacherMemberId(ParentVO member);
	public String memberGradeByMemberId(ParentVO member);// 학부모등급구하기
	public SchoolNewsLetterVO schoolNewsLetterDetail(int schoolNewsLetterNum); //학부모 가정통신문 디테일
	public void schoolNewsLetterSignUpdate(SchoolNewsLetterSignVO schoolNewsLetterSignVO);
	public List<SchoolNewsLetterSignVO> schoolNewsLetterSignList(SchoolNewsLetterSignVO schoolNewsLetterSignVO);
}
