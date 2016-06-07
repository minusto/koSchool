package ko.school.schedule.persistence;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.StudentVO;
import ko.school.common.domain.TeacherVO;
import ko.school.schedule.domain.TimetableVO;


public interface TimetableDAO {

	public void timetable(TimetableVO timeVO)throws Exception;
	
	public String getTimetable(TimetableVO timeVO)throws Exception;
	
	public void deleteTimetable(TimetableVO timeVO)throws Exception;
	
	public String getStudentTimetable(StudentVO sVO)throws Exception;

}
