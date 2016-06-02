package ko.school.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.board.domain.NoticeBoardVO;
import ko.school.board.persistence.NoticeBoardDAO;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {

	@Inject
	private NoticeBoardDAO dao;
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 등록  / 작성자 : 구혜인
	@Override
	public void insertNoticeBoardService(NoticeBoardVO noticeBoardVo) throws Exception {
		dao.insertNoticeBoard(noticeBoardVo);
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 리스트 조회 / 작성자 : 구혜인
	@Override
	public List<NoticeBoardVO> noticeBoardListService(String schoolAdminId) throws Exception {
		return dao.noticeBoardList(schoolAdminId);
	}

	//액터 ==> Member / 작업 내용 : 공지사항 리스트 조회 - Member의 schoolId로 schoolAdminId를 가져오기. / 작성자 : 구혜인
	@Override
	public String schoolAdminIdBySchoolIdService(String schoolId) throws Exception {
		return dao.schoolAdminIdBySchoolId(schoolId);
	}

	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 세부 보기  / 작성자 : 구혜인
	@Override
	public NoticeBoardVO noticeBoardDetailService(int noticeBoardNum) throws Exception {
		return dao.noticeBoardDetail(noticeBoardNum);
	}

	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 세부 보기 - 조회수 증가 / 작성자 : 구혜인
	@Override
	public void addNoticeBoardHitcountService(int noticeBoardNum) throws Exception {
		dao.addNoticeBoardHitcount(noticeBoardNum);
	}

	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 수정 / 작성자 : 구혜인
	@Override
	public void updateNoticBoardService(NoticeBoardVO noticeBoardVo) throws Exception {
		dao.updateNoticBoard(noticeBoardVo);
	}

	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 삭제 / 작성자 : 구혜인
	@Override
	public void deleteNoticeBoardService(int noticeBoardNum) throws Exception {
		dao.deleteNoticeBoard(noticeBoardNum);
	}




	
	
}
