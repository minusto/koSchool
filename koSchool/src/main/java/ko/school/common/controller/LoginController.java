package ko.school.common.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ko.school.common.domain.LoginCommand;
import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.SchoolAdminVO;
import ko.school.common.domain.StudentVO;
import ko.school.common.domain.SystemAdminVO;
import ko.school.common.domain.TeacherVO;
import ko.school.common.service.LoginService;

@Controller
public class LoginController {
	
	@Inject
	private LoginService service;
	
	
	//액터 ==> 모든사용자  / 작업내용 : 메인페이지 로그인 처리 / 작성자 : 이재승
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String memberCheck(LoginCommand loginCommand,Model model	,RedirectAttributes redirect)throws Exception{
		String grade=loginCommand.getGrade();
		if(grade.equals("student")||grade.equals("teacher")){
			MemberVO memberVO=service.memberCheckService(loginCommand);
			if(memberVO!=null){
				model.addAttribute("member", memberVO);
				if(grade.equals("student")){
					StudentVO studentVO=service.studentCheckService(memberVO.getMemberId());
					if(studentVO!=null){
						model.addAttribute("grade", "student");
						return "/common/studentMain";
					}
				}else if(grade.equals("teacher")){
					TeacherVO teacherVO=service.teacherCheckService(memberVO.getMemberId());
					if(teacherVO!=null){
						model.addAttribute("grade", "teacher");
						return "/common/teacherMain";
					}
				}
			}
			redirect.addFlashAttribute("result", "fail");
			return "redirect:/";
		}else if(grade.equals("parent")){
			ParentVO parentVO=service.parentCheckService(loginCommand);
			if(parentVO!=null){
				model.addAttribute("grade", "parent");
				model.addAttribute("parent", parentVO);
				return "/common/parentMain";
			}
			redirect.addFlashAttribute("result", "fail");
			return "redirect:/";
		}else if(grade.equals("schoolAdmin")){
			SchoolAdminVO schoolAdminVO=service.schoolAdminCheckService(loginCommand);
			if(schoolAdminVO!=null){
				model.addAttribute("grade", "schoolAdmin");
				model.addAttribute("schoolAdmin", schoolAdminVO);
				return "/common/schoolAdminMain";
			}
			redirect.addFlashAttribute("result", "fail");
			return "redirect:/";
		}else{
			SystemAdminVO systemAdminVO=service.systemAdminCheckService(loginCommand);
			if(systemAdminVO!=null){
				model.addAttribute("grade", "systemAdmin");
				model.addAttribute("systemAdmin", systemAdminVO);
				return "/common/systemAdminMain";
			}
			redirect.addFlashAttribute("result", "fail");
			return "redirect:/";
		}
	}
	
	//액터 ==> 모든사용자  / 작업내용 : 메인페이지 로그아웃 처리 / 작성자 : 이재승
	@RequestMapping("/logout")
	public String logout(RedirectAttributes redirect,HttpSession session){
		session.invalidate();
		redirect.addFlashAttribute("logout", "success");
		return "redirect:/";
	}
	
	
	//액터 ==> 학생  / 작업내용 : 메인페이지 접근시 인터셉터 prehandle 메소드에 의해 액터에 맞는 메인으로 보내줌 / 작성자 : 이재승
	@RequestMapping("/studentMain")
	public String studentMain(){
		return "/common/studentMain";
	}
	//액터 ==> 교사  / 작업내용 : 메인페이지 접근시 인터셉터 prehandle 메소드에 의해 액터에 맞는 메인으로 보내줌 / 작성자 : 이재승
	@RequestMapping("/teacherMain")
	public String teachertMain(){
		return "/common/teacherMain";
	}
	//액터 ==> 학부모  / 작업내용 : 메인페이지 접근시 인터셉터 prehandle 메소드에 의해 액터에 맞는 메인으로 보내줌 / 작성자 : 이재승
	@RequestMapping("/parentMain")
	public String parentMain(){
		return "/common/parentMain";
	}
	//액터 ==> 학교관리자  / 작업내용 : 메인페이지 접근시 인터셉터 prehandle 메소드에 의해 액터에 맞는 메인으로 보내줌 / 작성자 : 이재승
	@RequestMapping("/schoolAdminMain")
	public String schoolAdminMain(){
		return "/common/schoolAdminMain";
	}
	//액터 ==> 시스템관리자  / 작업내용 : 메인페이지 접근시 인터셉터 prehandle 메소드에 의해 액터에 맞는 메인으로 보내줌 / 작성자 : 이재승
	@RequestMapping("/systemAdminMain")
	public String systemAdminMain(){
		return "/common/systemAdminMain";
	}
	
}
