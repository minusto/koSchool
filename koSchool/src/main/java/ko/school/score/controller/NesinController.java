package ko.school.score.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.StudentVO;
import ko.school.common.domain.TeacherVO;
import ko.school.membermanage.domain.StudentDetail;
import ko.school.membermanage.domain.StudentList;
import ko.school.score.domain.AllRankingScoreList;
import ko.school.score.domain.AllStudentNum;
import ko.school.score.domain.AllSubjectScoreList;
import ko.school.score.domain.NesinSaveForm;
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
		model.addAttribute("list2", list2);
		model.addAttribute("path", "학생 관리 > 내신 성적 입력");
		return "/score/nesin/teacherInsertScoreForm";
	}
	//내신 성적 입력
	@RequestMapping(value = "/subjectScore", method = RequestMethod.POST)
	public String subjectScore(SubjectScore subjectscore, HttpSession session, Model model)throws Exception{
		service.insertSubjectScore(subjectscore);
		TeacherVO teacher = (TeacherVO)session.getAttribute("teacher");
		model.addAttribute("teacher",teacher);
		MemberVO member = (MemberVO)session.getAttribute("member");
		String schoolId = member.getSchoolId();
		List<StudentList> list2 = service.studentList(schoolId);
		model.addAttribute("list2",list2);
		return "/score/nesin/teacherInsertScoreForm";
	}
	//내신 성적 폼 조회 (교사)
		@RequestMapping(value = "/studentListScore", method = RequestMethod.GET)
		public String studentListScore(@RequestParam("id") String id, Model model, HttpSession session)throws Exception{
			//학생의 id
			session.setAttribute("id",id);
			StudentDetail student = service.selectStudentDetail(id);
			model.addAttribute("student",student);
			return "/score/nesin/studentListScore";
		}
		//내신 성적 폼 조회 (학생, 학부모)
		@RequestMapping(value = "/studentListScore2", method = RequestMethod.GET)
		public String studentListScore2(Model model, HttpSession session)throws Exception{
			String grade = (String) session.getAttribute("grade");
			String id = null;
			if(grade.equals("student")){
				StudentVO studentVO = (StudentVO) session.getAttribute("student");
				id = studentVO.getMemberId();
			}else if(grade.equals("parent")){
				ParentVO parentVO = (ParentVO) session.getAttribute("parent");
				id = parentVO.getStudentMemberId();
			}
			StudentDetail student = service.selectStudentDetail(id);
			model.addAttribute("id",id);
			model.addAttribute("student",student);
			model.addAttribute(grade);
			return "/score/nesin/studentListScore";
		}
		//내신 성적 조회
		@RequestMapping(value = "/listScore", method = RequestMethod.GET)
		public String listScore(@RequestParam("semester") int semester,
				@RequestParam("subjectGrade") int subjectGrade, Model model, HttpSession session)throws Exception{
			String grade = (String) session.getAttribute("grade");
			String id = null;
			int studentGrade = 0;
			int nesinYear = 0;
			if(grade.equals("teacher")){
				//학생의 id
				id = (String) session.getAttribute("id");
				//학생객체 구해서 학년 구하기
				StudentVO studentVO = service.studentCheck(id);
				studentGrade = studentVO.getStudentGrade();
				
			}else if(grade.equals("student")){
				StudentVO studentVO = (StudentVO) session.getAttribute("student");
				id = studentVO.getMemberId();
				//학년 구하기
				studentGrade = studentVO.getStudentGrade();
			}else if(grade.equals("parent")){
				ParentVO parentVO = (ParentVO) session.getAttribute("parent");
				id = parentVO.getStudentMemberId();
				//학생객체 구해서 학년 구하기
				StudentVO studentVO = service.studentCheck(id);
				studentGrade = studentVO.getStudentGrade();
			}
			//구한 학년을 가지고 년도 계산
			if(studentGrade == 1){
				if(subjectGrade == 1){
					nesinYear = 2016;
				}
			}else if(studentGrade == 2){
				if(subjectGrade == 1){
					nesinYear = 2015;
				}else if(subjectGrade == 2){
					nesinYear = 2016;
				}
			}else if(studentGrade == 3){
				if(subjectGrade == 1){
					nesinYear = 2014;
				}else if(subjectGrade == 2){
					nesinYear = 2015;
				}else if(subjectGrade == 3){
					nesinYear = 2016;
				}
			}
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("semester", semester);
			map.put("nesinYear", nesinYear);
			StudentDetail student = service.selectStudentDetail(id);
			model.addAttribute("student",student);
			model.addAttribute("id",id);
			model.addAttribute("subjectGrade", subjectGrade);
			model.addAttribute("semester",semester);
			List<AllSubjectScoreList> list = service.allSubjectScoreList(map);
			List<AllRankingScoreList> list2 = service.allRankingScoreList(map);
			List<AllStudentNum> list3 = service.allStudentNum(map);
			model.addAttribute("list",list);
			model.addAttribute("list2",list2);
			model.addAttribute("list3",list3);
			return "/score/nesin/studentListScore";
		}
		
		//내신 입력 테이블 저장
		@RequestMapping(value = "/saveForm", method = RequestMethod.POST)
		public String saveForm(NesinSaveForm nesinSaveForm, HttpSession session, Model model)throws Exception{
			String subjectGrade = nesinSaveForm.getSubjectGrade();
			service.deleteSaveForm(subjectGrade);
			service.insertSaveForm(nesinSaveForm);
			MemberVO member = (MemberVO)session.getAttribute("member");
			String schoolId = member.getSchoolId();
			List<StudentList> list2 = service.studentList(schoolId);
			model.addAttribute("list2",list2);
			return "/score/nesin/teacherInsertScoreForm";
		}
		
	
}
