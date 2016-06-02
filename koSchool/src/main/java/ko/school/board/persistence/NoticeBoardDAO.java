package ko.school.board.persistence;

import java.util.List;

import ko.school.board.domain.NoticeBoardVO;

public interface NoticeBoardDAO {
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 등록  / 작성자 : 구혜인
	public void insertNoticeBoard(NoticeBoardVO noticeBoardVo) throws Exception;
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 리스트 조회 / 작성자 : 구혜인
	public List<NoticeBoardVO> noticeBoardList(String schoolAdminId) throws Exception;
	
	//액터 ==> Member / 작업 내용 : 공지사항 리스트 조회 - Member의 schoolId로 schoolAdminId를 가져오기. / 작성자 : 구혜인
	public String schoolAdminIdBySchoolId(String schoolId) throws Exception;
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 세부 보기  / 작성자 : 구혜인
	public NoticeBoardVO noticeBoardDetail(int noticeBoardNum) throws Exception;
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 세부 보기 - 조회수 증가 / 작성자 : 구혜인
	public void addNoticeBoardHitcount(int noticeBoardNum) throws Exception;
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 수정 / 작성자 : 구혜인
	public void updateNoticBoard(NoticeBoardVO noticeBoardVo) throws Exception;

	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 삭제 / 작성자 : 구혜인
	public void deleteNoticeBoard(int noticeBoardNum) throws Exception;
	

}
