package ko.school.board.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.board.domain.NoticeBoardVO;

@Repository
public class NoticeBoardDAOImpl implements NoticeBoardDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "ko.school.mapper.NoticeBoardMapper";
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 등록  / 작성자 : 구혜인
	@Override
	public void insertNoticeBoard(NoticeBoardVO noticeBoardVo) throws Exception {
		session.insert(namespace + ".insertNoticeBoard", noticeBoardVo);
	}

	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 리스트 조회 / 작성자 : 구혜인
	@Override
	public List<NoticeBoardVO> noticeBoardList(String schoolAdminId) throws Exception {
		return session.selectList(namespace + ".listNoticeBoard", schoolAdminId);
	}

	//액터 ==> Member / 작업 내용 : 공지사항 리스트 조회 - Member의 schoolId로 schoolAdminId를 가져오기. / 작성자 : 구혜인
	@Override
	public String schoolAdminIdBySchoolId(String schoolId) throws Exception {
		return session.selectOne(namespace + ".schoolAdminIdBySchoolId", schoolId);
	}

	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 세부 보기  / 작성자 : 구혜인
	@Override
	public NoticeBoardVO noticeBoardDetail(int noticeBoardNum) throws Exception {
		return session.selectOne(namespace + ".noticeBoardDetail", noticeBoardNum);
	}

	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 세부 보기 - 조회수 증가 / 작성자 : 구혜인
	@Override
	public void addNoticeBoardHitcount(int noticeBoardNum) throws Exception {
		session.update(namespace + ".addNoticeBoardHitcount", noticeBoardNum);
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 수정 / 작성자 : 구혜인
	@Override
	public void updateNoticBoard(NoticeBoardVO noticeBoardVo) throws Exception {
		session.insert(namespace + ".updateNoticBoard", noticeBoardVo);
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 삭제 / 작성자 : 구혜인
	public void deleteNoticeBoard(int noticeBoardNum) throws Exception {
		session.delete(namespace + ".deleteNoticeBoard", noticeBoardNum);
	}
	

	

	

}
