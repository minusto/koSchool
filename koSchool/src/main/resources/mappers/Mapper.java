package mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import kosta.model.AdminList;
import kosta.model.AllEntranceInfo;
import kosta.model.AllRankingScoreList;
import kosta.model.AllStudentNum;
import kosta.model.AllSubjectScoreList;
import kosta.model.CreateTable;
import kosta.model.Cutline;
import kosta.model.EntranceInfo;
import kosta.model.ExistStudentList;
import kosta.model.HopeUniversity;
import kosta.model.Major;
import kosta.model.Member;
import kosta.model.MemberCheck;
import kosta.model.MockKorAvgScore;
import kosta.model.MockResearchScoreDetailList;
import kosta.model.MockScoreDetailList;
import kosta.model.MockTest;
import kosta.model.MockType;
import kosta.model.NoticeBoard;
import kosta.model.Parent;
import kosta.model.ParentList;
import kosta.model.ParentNullList;
import kosta.model.RecommendInfo;
import kosta.model.RegistManage;
import kosta.model.ResearchSubject;
import kosta.model.ResearchSubjectScore;
import kosta.model.School;
import kosta.model.SchoolAdmin;
import kosta.model.SchoolAdminDetail;
import kosta.model.SchoolAdminRegist;
import kosta.model.SchoolRegist;
import kosta.model.Search;
import kosta.model.SecondLanguage;
import kosta.model.SecondLanguageScore;
import kosta.model.Student;
import kosta.model.StudentDetail;
import kosta.model.StudentList;
import kosta.model.StudentNullList;
import kosta.model.Subject;
import kosta.model.SubjectScore;
import kosta.model.SystemAdmin;
import kosta.model.Teacher;
import kosta.model.TeacherDetail;
import kosta.model.University;

public interface Mapper  {
	public int insertSchoolAdmin(SchoolAdmin schoolAdmin); //액터 : 시스템관리자 ==> 학교관리자 등록
	public int insertSchoolAdminRegist(SchoolAdminRegist schoolAdminRegist);
	public int insertParent(Parent parent);
	public List<StudentList> studentList(String schoolId); //학생목록출력
	public List<AdminList> adminList(); //액터 : 시스템관리자 ==> 학교관리자리스트 출력	
	public List<ParentList> parentList(); ///액터: 교사 => 학부모리스트 출력
	public int insertSchool(School school); //액터 : 교내관리자 => 학교등록
	public SchoolAdminDetail schoolAdminDetail(String id); //액터 : 시스템관리자 =>학교관리자 상세보기
	public List<TeacherDetail> listTeacher(String id); // 액터 : 교내관리자 =>교사리스트
	public TeacherDetail detailTeacher(String memberId); // 액터 : 교내관리자 =>교사리스트=>상세보기
	public int insertMember(Member member);// 액터 : 교내관리자 =>교사등록
	public int insertTeacher(Teacher teacher);
	public MemberCheck memberCheck(String id); // 액터 : 모든사용자 => 로그인정보 확인
	public Member memberDetail(String id); //액터 : 모든사용자 => 유저정보확인
	public int userModPassowrd(Member member); //액터 : 모든사용자 => 비밀번호 변경
	public int updateMember(Member member); //교사 ==> 학생 입력 및 수정
	public int updateStudent(Student student); //교사 ==> 학생 입력 및 수정
	public List<StudentNullList> studentNullList(); //교사 ==> 학생 정보 NULL LIST
	public StudentDetail selectStudentDetail(String m_id); //교사 ==> 학생 세부 열람
	public int deleteStudent(String m_id); //교사 ==> 학생 내용 삭제
	public int deleteStudent2(String m_id); //교사 ==> 학생 내용 삭제
	public List<ExistStudentList> selectExistStudent(String id); //교사 ==> 학생 모의고사 점수 입력 - 정보가 입력된 학생 리스트 가져오기
	public List<ResearchSubject> selectResearchSubjectList(); //교사 => 학생 모의고사 점수 입력 - 탐구 과목 리스트 가져오기
	public List<SecondLanguage> selectSecondLanguageSubjectList(); //교사 => 학생 모의고사 점수 입력 - 제2외국어 과목 리스트 가져오기
	public String selectMockId(MockType mockType); //교사 ==> 학생 모의고사 점수 입력 - 모의고사 아이디 가져오기
	public String selectResearchId(String researchName); //교사 ==> 학생 모의고사 점수 입력 - 탐구과목 아이디 가져오기
	public String selectSecondLanguageId(String languageName); //교사 => 학생 모의고사 점수 입력 - 제2외국어 아이디 가져오기
	public int insertMockTest1Grade(MockTest mocckTest); //교사 ==> 학생 모의고사 점수 입력 - 모의고사 점수 넣기 - 1학년
	public int insertMockTest2Grade(MockTest mockTest); //교사 ==> 학생 모의고사 점수 입력 - 모의고사 점수 넣기 - 2학년
	public int insertMockTest3Grade(MockTest mockTest); //교사 ==> 학생 모의고사 점수 입력 - 모의고사 점수 넣기 - 3학년
	public int insertResearchScore(ResearchSubjectScore researchScore); //교사 ==> 학생 모의고사 점수 입력 - 탐구 점수 넣기
	public int insertSecondLangScore(SecondLanguageScore secondLanguageScore); //교사 ==> 학생 모의고사 점수 입력 - 제2외국어 점수 넣기 - 2학년, 3학년만
	public MockTest checkMockTestInsertedScore(MockTest mockTest);//교사 ==> 학생 모의고사 점수 입력 - 입력된 모의고사였는지 검사
	public HopeUniversity selectHopeUniversity(String memberId); //진학시뮬레이션 - 학생의 아이디로 입력되어있는 희망 대학을 반환
	public List<University> selectUniversityList(); //진학시뮬레이션 - 대학교 리스트 조회
	public List<Major> selectMajorList(String universityName); //진학시뮬레이션 - 학과 리스트 조회
	public String selectUniversityId(String universityName); //진학시뮬레이션 - 대학교 이름으로 아이디 가져오기
	public String selectMajorId(String majorName); //진학시뮬레이션 - 대학교 이름으로 아이디 가져오기
	public int selectEntranceInfoYear(EntranceInfo entranceInfo); //진학시뮬레이션 - 대학교 학과의 가장 최신 입시요강 연도 가져오기
	public int insertHopeUniversity(HopeUniversity hopeUniversity); //진학시뮬레이션 - 희망대학 입력하기
	public String selctUniversityName(String universityId); //진학시뮬레이션 - 대학교 아이디로 이름 가져오기
	public String selectMajorName(String majorId); //진학시뮬레이션 - 학과 아이디로 이름 가져오기
	public List<AllEntranceInfo> selectAllEntranceInfo(); //진학시뮬레이션 - 모든 대학교 학과 입시정보 리스트 출력
	public int insertNoticeBoard(NoticeBoard noticeBoard); //관지라-> 공지사항 등록
	public Integer noticeBoardNum(); //공지사항 글번호
	public int noticeCountBoard(Search search); //페이징 처리 공지사항글번호
	public List<NoticeBoard> noticeBoardList(RowBounds row, Search search); //공지사항 목록
	public int addHitcount(int noticeBoardNum); //공지사항조회수
	public NoticeBoard noticeBoardDetail(int noticeBoardNum); //공지사항 상세
	public School schoolDetail(String id); //학교정보조회
	public SchoolAdmin schoolAdminInfoDetail(String id);//액터  : 시스템 ==>학교관리자테이블 정보조회
	public Parent parentInfoDetail(String id);//액터  : 시스템 ==>학부모테이블 정보조회
	public SystemAdmin systemAdminInfoDetail(String id);//액터  : 시스템 ==>시스템관리자테이블 정보조회
	public int parentModPassword(Parent parent);//액터  : 학부모 ==>최초로그인 비밀번호 변경
	public int schoolAdminModPassword(SchoolAdmin schoolAdmin);//액터  : 학교관리자 ==>최초로그인 비밀번호 변경
	public int insertSchoolRegist(SchoolRegist schoolRegist);//액터 학교관리자 ==> 학교등록
	public List<ParentNullList> parentNullList();//액터  : 교사 ==> 학부모 정보 NULL LIST
	public List<Subject> subjectList(); // 과목정보조회
	public List<School> schoolList(); // 학교정보조회
	public int insertRegistManage(RegistManage registManage);//사용자 등급등록
	public int insertMemberId(Member member);//사용자 iD등록
	public int insertStudentIdManage(Student student);//학생아이디 등록+나머지 null;
	public int insertParentId(String parent); //학부모 아이디 등록
	public List<RegistManage> userList(String id); //유저리스트
	public int insertTeacherGrade(RegistManage registManage);// 교사등급 등록
	public SchoolRegist schoolRegistSchoolId(String id);
	public RegistManage getSchoolAdminId(String id);
	public List<Member> sameSchoolStudentNullList(String id); //액터 :교사 ==> 학생정보입력시 자신과 같은 학교의 학생만 보여줌
	public Teacher teacherImage(String id);//교사 사진 추출
	public Student studentImage(String id); //학생사진 추출
	public EntranceInfo mocktestCutline(Cutline cutline);//희망대학 정시커트라인
	public List<Map<String, Object>> mockTestSum(String id);//자기 모의고사 점수 합계
	//---------모의고사 성적조회
	public List<MockType> studentMockTestList(String id);
	public List<MockTest> studentMockTestScoreList();
	public List<ResearchSubjectScore> koreaHistroyScoreList(String id);
	public List<MockScoreDetailList> studentMockScorePlusSecondLangList(String id);
	public List<MockResearchScoreDetailList> studentMockResearchSocreList(String id);
	public List<MockTest> selectMyKorScore(String id);
	public List<MockKorAvgScore> selectMockKorAvgScore(String id);
	//---------모의고사 성적조회
	public List<RecommendInfo> recommendUniversity(int total);//희망대학
	public Subject selectSubject(String s_name); //과목 선택 (내신성적입력)
	public int insertSubjectScore(SubjectScore subjectscore); //내신성적입력
	public Integer createTableNum(); //내신성적 테이블 로우 넘버
	public int createTable(CreateTable createTable);//내신성적 테이블 생성
	public List<CreateTable> createTableList();//내신성적 테이블 리스트
	public List<AllSubjectScoreList> allSubjectScoreList(int semester); //전체과목별 내신점수리스트
	public List<AllRankingScoreList> allRankingScoreList(int semester);  //전체 과목별 등수
	public List<AllStudentNum> allStudentNum(int semeter); //전체 과목별 전체명수 

}
