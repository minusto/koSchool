package ko.school.schoolmanage.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.RegistManageVO;
import ko.school.common.domain.SchoolAdminVO;
import ko.school.common.domain.StudentVO;
import ko.school.schoolmanage.domain.SchoolRegistVO;
import ko.school.schoolmanage.service.SchoolManageService2;


@Controller
public class SchoolManageController2 {

	@Inject
	private SchoolManageService2 service;
	
	
	@RequestMapping(value="/schoolAdminInsertUserIdForm", method=RequestMethod.GET)
	public String insertMemberIdGET()throws Exception{	
		return "/schoolmanage/schoolAdminInsertUserIdForm";
	}
	@RequestMapping(value="/schoolAdminInsertUserIdForm", method=RequestMethod.POST)
	public String insertMemberIdPOST(MemberVO member , RegistManageVO registManage,
			HttpSession session , StudentVO student , ParentVO parent)throws Exception{
			
			String grade = registManage.getmemberGrade();//라디오 선택버튼 값
			
			SchoolAdminVO schoolAdmin = (SchoolAdminVO)session.getAttribute("schoolAdmin");
			String id = schoolAdmin.getSchoolAdminId();
			SchoolRegistVO sr = service.schoolRegistSchoolIdService(id);
			member.setSchoolId(sr.getSchoolId());
			registManage.setSchoolAdminId(sr.getSchoolAdminId());
			
			//멤버 테이블 등급테이블 입력
			service.insertMemberId(member);
			service.insertRegistManage(registManage);
			
			if(grade.equals("학생")){
				System.out.println("학생");
				service.insertStudentIdManage(student);
			}else{
				System.out.println("부모");
				//service.insertParentId(parent);
			}
					
		return "/schoolmanage/schoolAdminInsertUserIdForm";
	}
	
	@RequestMapping(value="/userIdList", method=RequestMethod.GET)
	public String userIdListGET(Model model , HttpSession session)throws Exception{	
		SchoolAdminVO schoolAdmin = (SchoolAdminVO)session.getAttribute("schoolAdmin");
		String id = schoolAdmin.getSchoolAdminId();
		model.addAttribute("list", service.userList(id));
		return "/schoolmanage/userIdList";
	}

}