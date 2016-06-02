package ko.school.schedule.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.common.domain.MemberVO;
import ko.school.schedule.domain.ScheduleVO;
import ko.school.schedule.persistence.ScheduleDao;

@Service
public class SchelduleServiceImpl implements ScheduleService {
	
	@Inject
	private ScheduleDao scheduleDao;

	@Override
	public void insertScheduleService(ScheduleVO scheduleVO) {
		scheduleDao.insertSchedule(scheduleVO);
	}

	@Override
	public List<ScheduleVO> getScheduleService(String schoolAdminId) {
		return scheduleDao.getSchedule(schoolAdminId);
	}

	@Override
	public void updateScheduleService(ScheduleVO scheduleVO) {
		scheduleDao.updateSchedule(scheduleVO);
		
	}

	@Override
	public void detailScheduleUpdateService(ScheduleVO scheduleVO) {
		scheduleDao.detailScheduleUpdate(scheduleVO);
	}

	@Override
	public void deleteScheduleService(ScheduleVO scheduleVO) {
		scheduleDao.deleteSchedule(scheduleVO);
	}

	@Override
	public String getSchoolAdminIdService(MemberVO memberVO) {
		return scheduleDao.getSchoolAdminId(memberVO);
	}
	
	
	
}
