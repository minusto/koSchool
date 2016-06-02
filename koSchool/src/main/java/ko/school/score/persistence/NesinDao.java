package ko.school.score.persistence;


import java.util.List;

import ko.school.membermanage.domain.StudentDetail;
import ko.school.membermanage.domain.StudentList;
import ko.school.score.domain.AllRankingScoreList;
import ko.school.score.domain.AllStudentNum;
import ko.school.score.domain.AllSubjectScoreList;
import ko.school.score.domain.Subject;
import ko.school.score.domain.SubjectScore;

public interface NesinDao {
	public List<Subject> subjectList()throws Exception; // 과목정보조회
	public Subject selectSubject(String s_name)throws Exception; //과목 선택 (내신성적입력)
	public List<StudentList> studentList(String schoolId)throws Exception; //학생목록출력
	public void insertSubjectScore(SubjectScore subjectscore)throws Exception; //내신성적입력
	public List<AllSubjectScoreList> allSubjectScoreList(int semester)throws Exception; //전체과목별 내신점수리스트
	public List<AllRankingScoreList> allRankingScoreList(int semester)throws Exception;  //전체 과목별 등수
	public List<AllStudentNum> allStudentNum(int semester)throws Exception; //전체 과목별 전체명수 
	public StudentDetail selectStudentDetail(String id)throws Exception;//학생 정보 조회
}
