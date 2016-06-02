package ko.school.board.service;

import java.util.List;

import ko.school.board.domain.NoticeBoardVO;

public interface NoticeBoardService {
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 등록  / 작성자 : 구혜인
	public void insertNoticeBoardService(NoticeBoardVO noticeBoardVo) throws Exception;
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 리스트 조회 / 작성자 : 구혜인
	public List<NoticeBoardVO> noticeBoardListService(String SchoolAdminId) throws Exception;
	
	//액터 ==> Member / 작업 내용 : 공지사항 리스트 조회 - Member의 schoolId로 schoolAdminId를 가져오기. / 작성자 : 구혜인
	public String schoolAdminIdBySchoolIdService(String schoolId) throws Exception;

	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 세부 보기  / 작성자 : 구혜인
	public NoticeBoardVO noticeBoardDetailService(int noticeBoardNum) throws Exception;
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 세부 보기 - 조회수 증가 / 작성자 : 구혜인
	public void addNoticeBoardHitcountService(int noticeBoardNum) throws Exception;
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 수정 / 작성자 : 구혜인
	public void updateNoticBoardService(NoticeBoardVO noticeBoardVo) throws Exception;

	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 삭제 / 작성자 : 구혜인
	public void deleteNoticeBoardService(int noticeBoardNum) throws Exception;
	
	
}
