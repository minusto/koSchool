package ko.school.score.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ko.school.common.domain.TeacherVO;
import ko.school.score.domain.NesinLoadForm;
import ko.school.score.domain.NesinSaveForm;
import ko.school.score.domain.Subject;
import ko.school.score.service.NesinService;

@RestController
public class JsonController {
	
	@Inject
	private NesinService service;
	
	@RequestMapping("/subject_ajax")
	public List<Subject> subject_ajax()throws Exception{
		List<Subject> list = service.subjectList();
		return list;
	}
	@RequestMapping("/subject2_ajax")
	public Subject subject2_ajax(@RequestParam("s_name") String s_name)throws Exception{
		Subject subject = service.selectSubject(s_name);
		return subject;
	}
	//내신 입력 테이블 불러오기
	@RequestMapping("/loadForm_ajax")
	public List<NesinLoadForm> loadForm_ajax(@RequestParam("studentGrade") String studentGrade,
			@RequestParam("check") String check, HttpSession session)throws Exception{
		System.out.println(studentGrade);
		System.out.println(check);
		TeacherVO teacher = (TeacherVO)session.getAttribute("teacher");
		String memberId = teacher.getMemberId();
		Map<String, String> map = new HashMap<String, String>();
		List<NesinLoadForm> list = null;
		//1학년 과목
		if(check.equals("first")){
			map.put("grade", "1");
			map.put("id", memberId);
			list = service.loadSaveForm(map);
			System.out.println(list.get(1).getSubjectName());
			if(studentGrade.equals("1")){
				for(int i=0; i<list.size(); i++){
					list.get(i).setNesinYear(2016);
				}
			}else if(studentGrade.equals("2")){
				for(int i=0; i<list.size(); i++){
					list.get(i).setNesinYear(2015);
				}
			}else if(studentGrade.equals("3")){
				for(int i=0; i<list.size(); i++){
					list.get(i).setNesinYear(2014);
				}
			}
		//2학년 과목
		}else if(check.equals("second")){
			map.put("grade", "2");
			map.put("id", memberId);
			list = service.loadSaveForm(map);
			if(studentGrade.equals("2")){
				for(int i=0; i<list.size(); i++){
					list.get(i).setNesinYear(2016);
				}
			}else if(studentGrade.equals("3")){
				for(int i=0; i<list.size(); i++){
					list.get(i).setNesinYear(2015);
				}
			}
		//3학년 과목
		}else if(check.equals("third")){
			map.put("grade", "3");
			map.put("id", memberId);
			list = service.loadSaveForm(map);
			if(studentGrade.equals("3")){
				for(int i=0; i<list.size(); i++){
					list.get(i).setNesinYear(2016);
				}
			}
		}
		return list;
	}
}
