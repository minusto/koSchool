package ko.school.membermanage.service;

import java.util.List;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.StudentVO;
import ko.school.membermanage.domain.ParentInsertCommand;
import ko.school.membermanage.domain.ParentList;
import ko.school.membermanage.domain.ParentNullList;
import ko.school.membermanage.domain.StudentCommend;
import ko.school.membermanage.domain.StudentDetail;
import ko.school.membermanage.domain.StudentList;



public interface StudentManageService {
	public void updateMember(StudentCommend commend)throws Exception; //교사 ==> 학생정보 입력
	public void updateStudent(StudentCommend commend)throws Exception; //교사 ==> 학생정보 입력 
	
	
	public List<MemberVO> sameSchoolStudentNullList(String id)throws Exception; //교사 ==> 학생 정보 NULL LIST
	public List<StudentList> studentList(String schoolId)throws Exception; //학생목록출력
	public StudentDetail selectStudentDetail(String m_id)throws Exception; //교사 ==> 학생 세부 열람
	public void deleteStudent(String m_id)throws Exception; //교사 ==> 학생 내용 삭제
	public void deleteStudent2(String m_id)throws Exception; //교사 ==> 학생 내용 삭제
	public List<ParentNullList> parentNullList()throws Exception;//액터  : 교사 ==> 학부모 정보 NULL LIST
	public void insertParent(ParentInsertCommand command)throws Exception; //학부모 정보 입력
	public List<ParentList> parentList()throws Exception; ///액터: 교사 => 학부모리스트 출력
	
	public String getStudentPic(StudentCommend commend)throws Exception;
	public void parentUpdateMember(MemberVO member);
}
