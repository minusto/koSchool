package ko.school.score.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
