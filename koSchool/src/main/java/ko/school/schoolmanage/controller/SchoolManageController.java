package ko.school.schoolmanage.controller;



import java.io.File;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ko.school.common.domain.MemberVO;
import ko.school.common.domain.RegistManageVO;
import ko.school.common.domain.SchoolAdminVO;
import ko.school.common.domain.TeacherVO;
import ko.school.schoolmanage.domain.ImageUtil;
import ko.school.schoolmanage.domain.SchoolAdminRegistVO;
import ko.school.schoolmanage.domain.TeacherDetailVO;
import ko.school.schoolmanage.service.SchoolManageService;

@Controller
public class SchoolManageController {
	
	private static final Logger logger = LoggerFactory.getLogger(SchoolManageController.class);
	
	@Inject
	private SchoolManageService service;
	
	
	
	//시스템 관리자->학교관리자 등록폼 겟
	@RequestMapping(value = "/schoolmanage/systemInsertSchoolAdminForm", method = RequestMethod.GET)
	public void schoolAdminRegist() {
		logger.info("시스템 등록폼");
	
	}
	
	//시스템 관리자->학교관리자 등록폼 포스트
	@RequestMapping(value = "/schoolmanage/systemInsertSchoolAdminForm", method = RequestMethod.POST)
	public String schoolAdminRegist(SchoolAdminVO sVo,SchoolAdminRegistVO srVo,RedirectAttributes rttr)throws Exception {

		service.insertSchoolAdmin(sVo, srVo);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/schoolmanage/schoolAdminList";
	}
	
	//시스템관리자-> 학교관리자 리스트
	@RequestMapping(value = "/schoolmanage/schoolAdminList", method = RequestMethod.GET)
	public void schoolAdminList(Model model)throws Exception {
		
		model.addAttribute("list", service.schoolAdminList());
		
	}
	
	//시스템관리자->학교관리자 상세보기
	@RequestMapping(value="/schoolmanage/schoolAdminDetail",method=RequestMethod.GET)
	public void read(@RequestParam("id") String id,Model model)throws Exception{
		
		
		model.addAttribute(service.schoolAdminDetail(id));
		
	}
	//시스템 관리자-> 학교관리자 수정 겟
	@RequestMapping(value = "/schoolmanage/schoolAdminUpdate", method = RequestMethod.GET)
	public void schoolAdminUpdate(@RequestParam("id") String id,Model model)throws Exception {
		model.addAttribute(service.schoolAdminDetail(id));
		
	
	}
	//시스템관리자 ->학교관리자 수정 포스트
	@RequestMapping(value = "/schoolmanage/schoolAdminUpdate", method = RequestMethod.POST)
	public String schoolAdminUpdate(SchoolAdminVO sVo,SchoolAdminRegistVO srVo)throws Exception {
		
		service.updateSchoolAdmin(sVo, srVo);
		return "redirect:/schoolmanage/schoolAdminList";
		
	
	}
	//학교관리자-> 교사 등록 겟
	@RequestMapping(value = "/schoolmanage/schoolAdminInsertTeacherForm", method = RequestMethod.GET)
	public void teacherRegist(Model model)throws Exception {
		
		model.addAttribute("list", service.schoolList());
		model.addAttribute("list2", service.subjectList());
		logger.info("교사 등록폼 겟");
	
	}
	//학교 관리자 ->교사 등록 포스트 
	@RequestMapping(value = "/schoolmanage/schoolAdminInsertTeacherForm", method = RequestMethod.POST)
	public String teacherRegist(RegistManageVO rVO,MemberVO mVO, TeacherVO tVO,HttpServletRequest request) throws Exception {
		
		
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

		}
		
		service.insertTeacher(mVO, tVO); //멤버,티쳐 순으로 인서트 되는 서비스
		service.insertTeacherGrade(rVO); //등급 
		

	
		return "redirect:/schoolmanage/schoolAdminTeacherList";
		
		
	}
	
	
	//학교관리자-> 교사 리스트
	@RequestMapping(value = "/schoolmanage/schoolAdminTeacherList", method = RequestMethod.GET)
	public void teacherList(Model model, HttpServletRequest request)throws Exception {
		HttpSession session = request.getSession();
		SchoolAdminVO sVO = (SchoolAdminVO)session.getAttribute("schoolAdmin");
		String id = sVO.getSchoolAdminId();
		model.addAttribute("list", service.teacherList(id));
		
	}
	
	//학교관리자 -> 교사 상세리스트
	@RequestMapping(value = "/schoolmanage/teacherListDetail", method = RequestMethod.GET)
	public void teacherListDetail(@RequestParam("memberId") String memberId , Model model)throws Exception{
		model.addAttribute("teacher",service.detailTeacher(memberId));
		
	}
	
	
	//학교 관리자 -> 교사 수정 GET
	@RequestMapping(value = "/schoolmanage/teacherUpdate", method = RequestMethod.GET)
	public void teacherUpdate(MemberVO memberVO, Model model)throws Exception{
		TeacherDetailVO teacherDetailVO = service.detailTeacher(memberVO.getMemberId());
		model.addAttribute("teacherDetailVO", teacherDetailVO);
		
	}
	//학교관리자 -> 교사 수정 POST
	@RequestMapping(value = "/schoolmanage/teacherUpdate", method = RequestMethod.POST)
	public String teacherUpdate(MemberVO member , TeacherVO teacherVO , Model model)throws Exception{
		service.updateMember(member);
		service.updateTeacher(teacherVO);
		String memberId = teacherVO.getMemberId();
		model.addAttribute("member", member);
		return "redirect:/schoolmanage/teacherListDetail?memberId=" + memberId;
	}
	
	//학교관리자 -> 교사 삭제
		@RequestMapping(value = "schoolmanage/teacherDelete" , method=RequestMethod.GET)
		public String deleteTeacher(@RequestParam("memberId") String memberId , Model model)throws Exception{
			service.deleteTeacher1(memberId);
			service.deleteTeacher2(memberId);
			return "redirect:/schoolmanage/schoolAdminTeacherList";
		}

}
