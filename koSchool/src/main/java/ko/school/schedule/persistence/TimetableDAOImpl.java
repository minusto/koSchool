package ko.school.schedule.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.StudentVO;
import ko.school.common.domain.TeacherVO;
import ko.school.schedule.domain.TimetableVO;

@Repository
public class TimetableDAOImpl implements TimetableDAO {
	@Inject
	private SqlSession session;
	
	private static String namespace
	="ko.school.mapper.TimetableMapper";
	

	@Override
	public void timetable(TimetableVO timeVO) throws Exception {
		session.insert(namespace+".inserttimetable",timeVO);
		
	}

	@Override
	public String getTimetable(TimetableVO timeVO) throws Exception {
		return session.selectOne(namespace+".getTimetable",timeVO);
	}

	@Override
	public void deleteTimetable(TimetableVO timeVO) throws Exception {
		 session.delete(namespace+".deleteTimetable",timeVO);
	}

	@Override
	public String getStudentTimetable(StudentVO sVO) throws Exception {
		return session.selectOne(namespace+".getStudentTimetable",sVO);
	}
	
	
	
	
	
	
	
	

}
