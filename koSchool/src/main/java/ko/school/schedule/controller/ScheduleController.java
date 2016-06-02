package ko.school.schedule.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.SchoolAdminVO;
import ko.school.schedule.domain.ScheduleVO;
import ko.school.schedule.service.ScheduleService;

@Controller
public class ScheduleController {
	
	@Inject
	ScheduleService service;
	
	
	//JSP 이동
	@RequestMapping(value="/scheduleList", method=RequestMethod.GET)
	public String scheduleList(){
		return "/schedule/scheduleList";
	}
	
	
	//일정 등록
	@RequestMapping(value="/scheduleList", method=RequestMethod.POST)
	public ResponseEntity<String> scheduleInsert(@RequestBody ScheduleVO scheduleVO,HttpServletRequest request){
		HttpSession session=request.getSession();
		SchoolAdminVO vo=(SchoolAdminVO)session.getAttribute("schoolAdmin");
		String schoolAdminId=vo.getSchoolAdminId();
		scheduleVO.setSchoolAdminId(schoolAdminId);
		service.insertScheduleService(scheduleVO);
		ResponseEntity<String> entity=null;
		try {
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	

	
	//캘린더에서 이벤트 이동시 자동 업데이트
	@RequestMapping(value="/updateSchedule",method=RequestMethod.POST)
	public ResponseEntity<String> updateSchedule(@RequestBody ScheduleVO scheduleVO){
		System.out.println("/updateSchedule 호출합니다");
		service.updateScheduleService(scheduleVO);
		System.out.println("/updateScheduleService 실행 후 ");
		
		ResponseEntity<String> entity=null;
		try {
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
		
	}
	
	
	//DB에서 일정호출
	@ResponseBody
	@RequestMapping(value="/getSchedule")
	public List<ScheduleVO> getSchedule(HttpServletRequest request){
		System.out.println("쫌되라!!!!!!!!!!!!!!!!!!!!!!!");
		HttpSession session=request.getSession();
		String grade=(String)session.getAttribute("grade");
		String schoolAdminId=null;
		if(grade.equals("schoolAdmin")){
			SchoolAdminVO vo=(SchoolAdminVO)session.getAttribute("schoolAdmin");
			schoolAdminId=vo.getSchoolAdminId();
		}else if(grade.equals("student")||grade.equals("teacher")){
			MemberVO memberVO=(MemberVO)session.getAttribute("member");
			System.out.println("getSchedule 호출!!!학생일 경우");
			System.out.println(memberVO.getMemberId());
			System.out.println("-------------------------------");
			System.out.println(schoolAdminId);
			schoolAdminId=service.getSchoolAdminIdService(memberVO);
		}
		List<ScheduleVO> list=service.getScheduleService(schoolAdminId);
		System.out.println("되라쫌ㅉ떠ㅃ쨔떠ㅑㅂㅈ거ㅐㅑㅈ버래ㅑㅈㄷ러ㅐㅑ저랴ㅐㅂ저ㅑㅐㅂㅈㄷㄹ");
		return list;
	}
	
	
	//일정 상세정보 및 날짜 수정
	@RequestMapping(value="/detailScheduleUpdate")
	public String detailScheduleUpdate(ScheduleVO scheduleVO){
		service.detailScheduleUpdateService(scheduleVO);
		return "/schedule/scheduleList";
	}
	
	
	//일정삭제
	@RequestMapping(value="/deleteSchedule")
	public String deleteSchedule(@RequestParam("id") String id,@RequestParam("title") String title){
		ScheduleVO scheduleVO=new ScheduleVO();
		scheduleVO.setScheduleId(id);
		scheduleVO.setScheduleTitle(title);
		service.deleteScheduleService(scheduleVO);
		return "/schedule/scheduleList";
	}
	
}

