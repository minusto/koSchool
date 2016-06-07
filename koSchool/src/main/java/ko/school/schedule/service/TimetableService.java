package ko.school.schedule.service;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.StudentVO;
import ko.school.common.domain.TeacherVO;
import ko.school.schedule.domain.TimetableVO;

public interface TimetableService {
	
	public void timetable(TimetableVO timeVO)throws Exception;

	public String getTimetable(TimetableVO timeVO)throws Exception;
	
	public void deleteTimetable(TimetableVO timeVO) throws Exception;
	
	public String getStudentTimetable(StudentVO sVO)throws Exception;
	
}
