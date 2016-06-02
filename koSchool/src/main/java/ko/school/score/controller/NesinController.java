package ko.school.score.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ko.school.common.domain.MemberVO;
import ko.school.membermanage.domain.StudentDetail;
import ko.school.membermanage.domain.StudentList;
import ko.school.score.domain.AllRankingScoreList;
import ko.school.score.domain.AllStudentNum;
import ko.school.score.domain.AllSubjectScoreList;
import ko.school.score.domain.SubjectScore;
import ko.school.score.service.NesinService;

@Controller
public class NesinController {
	@Inject
	private NesinService service;
	// 학생 성적 입력
	
	@RequestMapping(value = "/teacherInsertScoreForm", method = RequestMethod.GET)
	public String teacherInsertScoreForm(Model model, HttpSession session) throws Exception {
		MemberVO member = (MemberVO)session.getAttribute("member");
		String schoolId = member.getSchoolId();
		List<StudentList> list2 = service.studentList(schoolId);
		model.addAttribute("list2",list2);
		model.addAttribute("path", "학생 관리 > 내신 성적 입력");
		return "/score/nesin/teacherInsertScoreForm";
	}
	//내신 성적 입력
	@RequestMapping(value = "/subjectScore", method = RequestMethod.POST)
	public String subjectScore(SubjectScore subjectscore)throws Exception{
		service.insertSubjectScore(subjectscore);
		return "/score/nesin/teacherInsertScoreForm";
	}
	//내신 성적 조회
	@RequestMapping(value = "/studentListScore", method = RequestMethod.GET)
	public String studentListScore(@RequestParam("id") String id, Model model, HttpSession session)throws Exception{
		session.setAttribute("id", id);
		StudentDetail student = service.selectStudentDetail(id);
		model.addAttribute("student",student);
		return "/score/nesin/studentListScore";
	}
	@RequestMapping(value = "/listScore", method = RequestMethod.GET)
	public String listScore(@RequestParam("semester") int semester,
			@RequestParam("subjectGrade") int subjectGrade, Model model, HttpSession session)throws Exception{
		String id = (String) session.getAttribute("id");
		model.addAttribute("id",id);
		model.addAttribute("subjectGrade", subjectGrade);
		List<AllSubjectScoreList> list = service.allSubjectScoreList(semester);
		List<AllRankingScoreList> list2 = service.allRankingScoreList(semester);
		List<AllStudentNum> list3 = service.allStudentNum(semester);
		model.addAttribute("list",list);
		model.addAttribute("list2",list2);
		model.addAttribute("list3",list3);
		return "/score/nesin/studentListScore";
	}
	
}
