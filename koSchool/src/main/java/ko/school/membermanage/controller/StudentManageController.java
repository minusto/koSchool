package ko.school.membermanage.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.StudentVO;
import ko.school.membermanage.domain.ParentList;
import ko.school.membermanage.domain.ParentNullList;
import ko.school.membermanage.domain.StudentDetail;
import ko.school.membermanage.domain.StudentList;
import ko.school.membermanage.service.StudentManageService;

@Controller
public class StudentManageController {
	@Inject
	private StudentManageService service;
	
	//학생 정보 입력 폼
	@RequestMapping(value="/teacherInsertStudentForm",  method= RequestMethod.GET)
	public String teacherInsertStudentForm(Model model, HttpSession session)throws Exception{
		System.out.println("enter.....");
		MemberVO member = (MemberVO)session.getAttribute("member");
		String id = member.getSchoolId();
		List<MemberVO> list=  service.sameSchoolStudentNullList(id);
		model.addAttribute("list",list);
		model.addAttribute("path", "학생 관리 > 학생 정보 입력");
		return "/membermanage/teacher/teacherInsertStudentForm";
	}
	//학생 정보 입력
	@RequestMapping(value="/insertStudent", method=RequestMethod.POST)
	public String insertStudent(MemberVO member, StudentVO student)throws Exception{
		service.updateMember(member);
		service.updateStudent(student);
		return "/membermanage/teacher/teacherInsertStudentForm";
	}
	//학생 조회
	@RequestMapping(value="/teacherListStudent", method=RequestMethod.GET)
	public String teacherListStudent(Model model,HttpSession session)throws Exception{
		MemberVO member = (MemberVO)session.getAttribute("member");
		String schoolId = member.getSchoolId();
		List<StudentList> list = service.studentList(schoolId);
		model.addAttribute("list",list);
		model.addAttribute("path", "학생 관리 > 학생 정보 열람");
		return "/membermanage/teacher/teacherListStudent";
	}
	//학생 세부 정보
	@RequestMapping(value="/teacherListStudentDetail", method=RequestMethod.GET)
	public String teacherListStudentDetail(@RequestParam String m_id, Model model)throws Exception{
		System.out.println(m_id);
		StudentDetail student = service.selectStudentDetail(m_id);
		model.addAttribute("student",student);
		model.addAttribute("path", "학생관리 > 학생 정보 열람 > Detail" );
		return "/membermanage/teacher/teacherListStudentDetail";
	}
	//학생 정보 수정
	@RequestMapping(value="/correctionStudent", method=RequestMethod.POST)
	public String correctionStudent(MemberVO member, StudentVO student, Model model)throws Exception{
		System.out.println(member.toString());
		System.out.println(student.toString());
		service.updateMember(member);
		service.updateStudent(student);
		String m_id = student.getMemberId();
		model.addAttribute("m_id", m_id);
		return "redirect:teacherListStudentDetail";
	}
	//학생 정보 삭제
	@RequestMapping(value="/deleteStudent", method=RequestMethod.GET)
	public String deleteStudent(@RequestParam String m_id)throws Exception{
		service.deleteStudent(m_id);
		service.deleteStudent2(m_id);
		return "redirect:teacherListStudent";
	}
	//학부모 입력 폼
	@RequestMapping(value="/teacherInsertParentForm", method=RequestMethod.GET)
	public String teacherInsertParentForm(Model model, HttpSession session)throws Exception{
		List<ParentNullList> list = service.parentNullList();
		model.addAttribute("list",list);
		MemberVO member = (MemberVO)session.getAttribute("member");
		String schoolId = member.getSchoolId();
		List<StudentList> list2 = service.studentList(schoolId);
		model.addAttribute("list2",list2);
		model.addAttribute("path", "학부모 관리 > 학부모 정보 입력");
		return "/membermanage/teacher/teacherInsertParentForm";
	}
	//학부모 입력
	@RequestMapping(value="/teacherInsertParentForm", method=RequestMethod.POST)
	public String insertParent(ParentVO parent)throws Exception{
		service.insertParent(parent);
		return "/membermanage/teacher/teacherInsertParentForm";
	}
	//학부모 조회
	@RequestMapping(value="/teacherListParent", method=RequestMethod.GET)
	public String teacherListParent(Model model)throws Exception{
		List<ParentList> list = service.parentList();
		model.addAttribute("list",list);
		model.addAttribute("path", "학부모 관리 > 학부모 정보 열람");
		return "/membermanage/teacher/teacherListParent";
	}
	
	
	
	
}
