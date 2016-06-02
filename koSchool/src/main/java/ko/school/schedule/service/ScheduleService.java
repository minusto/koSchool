package ko.school.schedule.service;

import java.util.List;

import ko.school.common.domain.MemberVO;
import ko.school.schedule.domain.ScheduleVO;

public interface ScheduleService {
	public void insertScheduleService(ScheduleVO scheduleVO);

	public List<ScheduleVO> getScheduleService(String schoolAdminId);

	public void updateScheduleService(ScheduleVO scheduleVO);

	public void detailScheduleUpdateService(ScheduleVO scheduleVO);

	public void deleteScheduleService(ScheduleVO scheduleVO);
	
	public String getSchoolAdminIdService(MemberVO memberVO);
	
}
