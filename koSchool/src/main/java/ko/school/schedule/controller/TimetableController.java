package ko.school.schedule.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import ko.school.common.domain.ParentVO;
import ko.school.common.domain.StudentVO;
import ko.school.common.domain.TeacherVO;
import ko.school.common.service.LoginService;
import ko.school.schedule.domain.TimetableVO;
import ko.school.schedule.service.TimetableService;


@Controller
public class TimetableController {
	@Inject
	private TimetableService service;
	@Inject
	private LoginService loginService;
	
	@RequestMapping(value = "/timetable", method = RequestMethod.GET)
	public String timetable() {
		return "membermanage/teacher/teacherTimetable";
	}
	
	@RequestMapping(value = "/studentTimetable", method = RequestMethod.GET)
	public String studentTimetable() {
		return "common/studentTimetable";
		
	}
	
	@ResponseBody
	@RequestMapping(value="/studentTimetableview",method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> studentTimetableview(HttpServletRequest request)throws Exception{
			HttpSession session = request.getSession();
			ParentVO pVO = (ParentVO)session.getAttribute("parent");
			StudentVO sVO = (StudentVO)session.getAttribute("student");
			
			if(sVO!=null){
				String data = service.getStudentTimetable(sVO);
				if(data==null){
					data="empty";
					
				}
				return new  ResponseEntity<>(data,HttpStatus.OK);
			}else{
				System.out.println("학부모");
				StudentVO stVO = loginService.studentCheckService(pVO.getStudentMemberId());			
				String data = service.getStudentTimetable(stVO);
				if(data==null){
					data="empty";
					
				}
				return new  ResponseEntity<>(data,HttpStatus.OK);
			}
		
			
	
	
}

	
		@ResponseBody
		@RequestMapping(value="/timetable",method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
		public ResponseEntity<String> timetable(HttpServletRequest request,@RequestParam("timedata")String timedata)throws Exception{
				HttpSession session = request.getSession();
				TeacherVO tVO = (TeacherVO)session.getAttribute("teacher");
				
				TimetableVO timeVO = new TimetableVO();
				
				timeVO.setMemberId(tVO.getMemberId());
				timeVO.setTimetable(timedata);
				timeVO.setTeacherclass(tVO.getTeacherClass()); //뭐이상한 오류나서 그냥 초기화함
				
				String gc = String.valueOf(timeVO.getTeacherclass());
				int teachergrade = Integer.parseInt(gc.substring(0,1));
				int teacherclass = Integer.parseInt(gc.substring(1,3));
			
				
				timeVO.setTeachergrade(teachergrade);
				timeVO.setTeacherclass(teacherclass);
				service.deleteTimetable(timeVO);
				service.timetable(timeVO);
			

		
				return new  ResponseEntity<>("성공",HttpStatus.OK);
		
	}
		
		@ResponseBody
		@RequestMapping(value="/timetableview",method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
		public ResponseEntity<String> timetableview(HttpServletRequest request)throws Exception{
				HttpSession session = request.getSession();
				TeacherVO tVO = (TeacherVO)session.getAttribute("teacher");
				TimetableVO timeVO = new TimetableVO();
				
				timeVO.setMemberId(tVO.getMemberId());
				
				String data = service.getTimetable(timeVO);
				if(data==null){
					data="empty";
				}
				return new  ResponseEntity<>(data,HttpStatus.OK);
		
		
	}
		
		@ResponseBody
		@RequestMapping(value="/deleteTimetable",method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
		public ResponseEntity<String> deleteTimetable(HttpServletRequest request)throws Exception{
			HttpSession session = request.getSession();
			TeacherVO tVO = (TeacherVO)session.getAttribute("teacher");
			TimetableVO timeVO = new TimetableVO();
			timeVO.setMemberId(tVO.getMemberId());
			timeVO.setTeacherclass(tVO.getTeacherClass());
			
			String gc = String.valueOf(timeVO.getTeacherclass());
			int teachergrade = Integer.parseInt(gc.substring(0,1));
			int teacherclass = Integer.parseInt(gc.substring(1,3));
		
			
			timeVO.setTeachergrade(teachergrade);
			timeVO.setTeacherclass(teacherclass);
			service.deleteTimetable(timeVO);	
	
			return new  ResponseEntity<>("삭제",HttpStatus.OK);
		
	}
		
	
}








