package ko.school.membermanage.controller;

import java.io.File;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.StudentVO;
import ko.school.common.domain.TeacherVO;
import ko.school.membermanage.service.ProfileService;
import ko.school.schoolmanage.domain.ImageUtil;
import ko.school.schoolmanage.service.SchoolManageService;

@Controller
public class ProfileController {
	@Inject
	private SchoolManageService subjectService;
	
	@Inject
	private ProfileService service;
	
	//교사-->프로필
	@RequestMapping(value="/teacherProfile", method=RequestMethod.GET)
	public String teacherProfile(Model model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		TeacherVO teacherVO = (TeacherVO)session.getAttribute("teacher");
		
		model.addAttribute("member", memberVO);
		model.addAttribute("teacher", teacherVO);
		
		return "/common/teacherProfile";
	}
	

	//교사-->프로필수정 겟
	@RequestMapping(value="/teacherProfileUpdate", method=RequestMethod.GET)
	public String teacherProfilepdate(Model model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		TeacherVO teacherVO = (TeacherVO)session.getAttribute("teacher");
		
	
		model.addAttribute("member", memberVO);
		model.addAttribute("teacher", teacherVO);
		model.addAttribute("list", subjectService.subjectList());
		return "/membermanage/teacher/teacherProfileUpdate";
	}
	
	//교사 프로필 수정 포스트
	@RequestMapping(value="/teacherProfileUpdate", method=RequestMethod.POST)
	public String teacherProfilepdate(MemberVO mVO, TeacherVO tVO,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		MultipartFile file = tVO.getFile(); // 파일 받음
		
		if(!file.isEmpty()){		// 파일 존재 할 경우

			String filename = file.getOriginalFilename();		//업로드 파일 이름 받음

			File tempfile =new File(request.getRealPath("/upload"), file.getOriginalFilename());	//파일 생성후 

			if(tempfile.exists() && tempfile.isFile()){	// 이미 존재하는 파일일경우 현재시간을 가져와서 리네임

				filename =System.currentTimeMillis()  +"_"+ file.getOriginalFilename() ;

				tempfile = new File(request.getRealPath("/upload"),filename);	//리네임된 파일이름으로 재생성

			}

			file.transferTo(tempfile);	// 업로드 디렉토리로 파일 이동
			//이미지 리사이즈
			String imgePath = request.getRealPath("/upload")+"\\"+filename;
			File src  = new File(imgePath);
		   String headName = filename.substring(0, filename.lastIndexOf("."));
			String pattern =filename.substring(filename.lastIndexOf(".")+1);
			String reImagePath = request.getRealPath("/upload")+"\\"+headName+"_resize."+pattern;
			File dest = new File(reImagePath);
			
			ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);


			tVO.setTeacherPicture(filename);	// 게시글에 업로드된 파일이름 등록

		}else{ //파일 수정 안할경우 

			tVO.setTeacherPicture(service.getTeacherPic(mVO));
		}
		service.updateTeacher(mVO, tVO);
		
		session.setAttribute("member", mVO);
		session.setAttribute("teacher", tVO);
		return "redirect:/teacherProfile";
	}
	
	
	//학생-->프로필
	@RequestMapping(value="/studentProfile", method=RequestMethod.GET)
	public String studentProfile(Model model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		StudentVO stVO = (StudentVO)session.getAttribute("student");
		
		model.addAttribute("member", memberVO);
		model.addAttribute("student", stVO);
		
		return "/common/studentProfile";
	}
	
	//학부모--> 프로필  폼만 만듬 
	
	
	
	
	
	
}








