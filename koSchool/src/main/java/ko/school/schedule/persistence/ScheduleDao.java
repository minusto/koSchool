package ko.school.schedule.persistence;

import java.util.List;

import ko.school.common.domain.MemberVO;
import ko.school.schedule.domain.ScheduleVO;

public interface ScheduleDao {

	public void insertSchedule(ScheduleVO scheduleVO);

	public List<ScheduleVO> getSchedule(String schoolAdminId);

	public void updateSchedule(ScheduleVO scheduleVO);

	public void detailScheduleUpdate(ScheduleVO scheduleVO);

	public void deleteSchedule(ScheduleVO scheduleVO);
	
	public String getSchoolAdminId(MemberVO memberVO);
}
