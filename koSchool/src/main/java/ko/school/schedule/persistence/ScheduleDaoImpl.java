package ko.school.schedule.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.common.domain.MemberVO;
import ko.school.schedule.domain.ScheduleVO;

@Repository
public class ScheduleDaoImpl implements ScheduleDao {


	@Inject
	SqlSession session;
	
	private static String namespace = "ko.school.mapper.ScheduleMapper";
	
	@Override
	public void insertSchedule(ScheduleVO scheduleVO) {
		session.insert(namespace+".insertSchedule", scheduleVO);

	}

	@Override
	public List<ScheduleVO> getSchedule(String schoolAdminId) {
		List<ScheduleVO> list=session.selectList(namespace+".getSchedule",schoolAdminId);
		return list;
	}

	@Override
	public void updateSchedule(ScheduleVO scheduleVO) {
		session.update(namespace+".updateSchedule", scheduleVO);
	}

	@Override
	public void detailScheduleUpdate(ScheduleVO scheduleVO) {
		session.update(namespace+".detailScheduleUpdate", scheduleVO);
	}

	@Override
	public void deleteSchedule(ScheduleVO scheduleVO) {
		session.delete(namespace+".deleteSchedule", scheduleVO);
	}

	@Override
	public String getSchoolAdminId(MemberVO memberVO) {
		return session.selectOne(namespace+".getSchoolAdminId",memberVO);
	}

}
