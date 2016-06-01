package ko.school.schoolmanage.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ko.school.common.domain.SchoolAdminVO;
import ko.school.schoolmanage.domain.SchoolRegistVO;
import ko.school.schoolmanage.domain.SchoolVO;
import ko.school.schoolmanage.service.SchoolService;

@Controller
public class SchoolController {
	@Inject
	private SchoolService service;
	
	//액터 ==> 학교관리자 / 작업 내용 : 학교 등록 - 학교 정보 입력 폼으로 들어왔을 경우 / 작성자 : 구혜인
	@RequestMapping(value="/insertSchoolForm", method=RequestMethod.GET)
	public String insertForm(Model model, HttpServletRequest request) throws Exception {
		boolean isSchool = false;
		HttpSession session = request.getSession();
		SchoolAdminVO schoolAdminVo = (SchoolAdminVO)session.getAttribute("schoolAdmin");
		SchoolVO schoolVo = new SchoolVO();
		schoolVo = service.detailSchoolService(schoolAdminVo.getSchoolAdminId());
		if(schoolVo != null) {
			isSchool = true;
		}
		model.addAttribute("isSchool", isSchool);
		return "/schoolmanage/insertSchoolForm"; 
	}

	//액터 ==> 학교관리자 / 작업 내용 : 학교 등록, 학교 정보 입력 / 작성자 : 구혜인
	@RequestMapping(value="/insertSchoolForm", method=RequestMethod.POST)
	public String insertForm(SchoolVO schoolVo, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		SchoolAdminVO schoolAdminVo = (SchoolAdminVO)session.getAttribute("schoolAdmin");
		
		SchoolRegistVO schoolRegistVo = new SchoolRegistVO();
		schoolRegistVo.setSchoolAdminId(schoolAdminVo.getSchoolAdminId());
		schoolRegistVo.setSchoolId(schoolVo.getSchoolId());
		
		service.insertSchoolService(schoolVo, schoolRegistVo);
		return "redirect:/schoolAdminMain";
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 학교 관리자 아이디로 학교 정보 조회 / 작성자 : 구혜인
	@RequestMapping("/schoolDetail")
	public String schoolDetail(Model model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		SchoolAdminVO schoolAdminVo = (SchoolAdminVO)session.getAttribute("schoolAdmin");
		
		SchoolVO school = service.detailSchoolService(schoolAdminVo.getSchoolAdminId());
		model.addAttribute("school", school);
		return "/schoolmanage/schoolDetail";
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 학교 정보 수정 폼으로 접속 - 학교 관리자 아이디로 학교 정보 조회 / 작성자 : 구혜인
	@RequestMapping(value="/schoolUpdate", method=RequestMethod.GET)
	public String schoolUpdate(Model model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		SchoolAdminVO schoolAdminVo = (SchoolAdminVO)session.getAttribute("schoolAdmin");
		
		SchoolVO school = service.detailSchoolService(schoolAdminVo.getSchoolAdminId());
		model.addAttribute("school", school);
		return "/schoolmanage/schoolUpdate";
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 학교 정보 수정 / 작성자 : 구혜인
	@RequestMapping(value="/schoolUpdate", method=RequestMethod.POST)
	public String schoolUpdate(SchoolVO schoolVo, HttpServletRequest request, Model model) throws Exception {
		service.schoolUpdateService(schoolVo);
		
		HttpSession session = request.getSession();
		SchoolAdminVO schoolAdminVo = (SchoolAdminVO)session.getAttribute("schoolAdmin");
		
		SchoolVO school = service.detailSchoolService(schoolAdminVo.getSchoolAdminId());
		model.addAttribute("school", school);
		
		return "redirect:/schoolDetail";
	}
	
	
}








