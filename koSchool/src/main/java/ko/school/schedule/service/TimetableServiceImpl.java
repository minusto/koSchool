package ko.school.schedule.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.StudentVO;
import ko.school.common.domain.TeacherVO;
import ko.school.schedule.domain.TimetableVO;
import ko.school.schedule.persistence.TimetableDAO;

@Service
public class TimetableServiceImpl implements TimetableService {
	
	
	@Inject
	private TimetableDAO dao;

	

	@Override
	public void timetable(TimetableVO timeVO) throws Exception {
		dao.timetable(timeVO);
		
	}

	@Override
	public String getTimetable(TimetableVO timeVO) throws Exception {
		return dao.getTimetable(timeVO);
	}

	@Override
	public void deleteTimetable(TimetableVO timeVO) throws Exception {
		dao.deleteTimetable(timeVO);
		
	}

	@Override
	public String getStudentTimetable(StudentVO sVO) throws Exception {
	
		return dao.getStudentTimetable(sVO);
	}
	
	
	
	
	
	
	
	
	
	

}
