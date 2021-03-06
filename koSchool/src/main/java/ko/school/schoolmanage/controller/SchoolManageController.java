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
	
	
	
	//시스템 관리자->학교관리자 등록폼 겟 작성자: 유지훈
	@RequestMapping(value = "/systemInsertSchoolAdminForm", method = RequestMethod.GET)
	public String schoolAdminRegist() {
		logger.info("시스템 등록폼");
		return "/schoolmanage/systemInsertSchoolAdminForm";
	}
	
	//시스템 관리자->학교관리자 등록폼 포스트 작성자: 유지훈
	@RequestMapping(value = "/systemInsertSchoolAdminForm", method = RequestMethod.POST)
	public String schoolAdminRegist(SchoolAdminVO sVo,SchoolAdminRegistVO srVo,RedirectAttributes rttr)throws Exception {

		service.insertSchoolAdmin(sVo, srVo);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/schoolAdminList";
	}
	
	//시스템관리자-> 학교관리자 리스트 작성자: 유지훈
	@RequestMapping(value = "/schoolAdminList", method = RequestMethod.GET)
	public String schoolAdminList(Model model)throws Exception {
		
		model.addAttribute("list", service.schoolAdminList());
		return "/schoolmanage/schoolAdminList";
	}
	
	//시스템관리자->학교관리자 상세보기 작성자: 유지훈
	@RequestMapping(value="/schoolAdminDetail",method=RequestMethod.GET)
	public String read(@RequestParam("id") String id,Model model)throws Exception{
		
		model.addAttribute(service.schoolAdminDetail(id));
		return "/schoolmanage/schoolAdminDetail";
	}
	
	//시스템 관리자-> 학교관리자 수정 겟 작성자: 유지훈
	@RequestMapping(value = "/schoolAdminUpdate", method = RequestMethod.GET)
	public String schoolAdminUpdate(@RequestParam("id") String id,Model model)throws Exception {
		model.addAttribute(service.schoolAdminDetail(id));
		
		return "/schoolmanage/schoolAdminUpdate";
		
	
	}
	//시스템관리자 ->학교관리자 수정 포스트 작성자: 유지훈
	@RequestMapping(value = "/schoolAdminUpdate", method = RequestMethod.POST)
	public String schoolAdminUpdate(SchoolAdminVO sVo,SchoolAdminRegistVO srVo)throws Exception {
		
		service.updateSchoolAdmin(sVo, srVo);
		return "redirect:/schoolAdminList";
		
	
	}
	//학교관리자-> 교사 등록 겟 작성자: 유지훈
	@RequestMapping(value = "/schoolAdminInsertTeacherForm", method = RequestMethod.GET)
	public String teacherRegist(HttpServletRequest request, Model model)throws Exception {
		HttpSession session = request.getSession();
		SchoolAdminVO schoolAdminVo = (SchoolAdminVO)session.getAttribute("schoolAdmin");
		String schoolId = service.selectSchoolIdBySchoolAdminIDService(schoolAdminVo.getSchoolAdminId());
		
		model.addAttribute("schoolId", schoolId);
		model.addAttribute("list", service.schoolList());
		model.addAttribute("list2", service.subjectList());
		logger.info("교사 등록폼 겟");
		return "/schoolmanage/schoolAdminInsertTeacherForm";
	
	}
	//학교 관리자 ->교사 등록 포스트  작성자: 유지훈
	@RequestMapping(value = "/schoolAdminInsertTeacherForm", method = RequestMethod.POST)
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
		

	
		return "redirect:/schoolAdminTeacherList";
		
		
	}
	
	 
	//학교관리자-> 교사 리스트 작성자: 유지훈
	@RequestMapping(value = "/schoolAdminTeacherList", method = RequestMethod.GET)
	public String teacherList(Model model, HttpServletRequest request)throws Exception {
		HttpSession session = request.getSession();
		SchoolAdminVO sVO = (SchoolAdminVO)session.getAttribute("schoolAdmin");
		String id = sVO.getSchoolAdminId();
		model.addAttribute("list", service.teacherList(id));
		return  "/schoolmanage/schoolAdminTeacherList";
	}
	
	//학교관리자 -> 교사 상세리스트 
	@RequestMapping(value = "/teacherListDetail", method = RequestMethod.GET)
	public String teacherListDetail(@RequestParam("memberId") String memberId , Model model)throws Exception{
		TeacherDetailVO teacherDetailVo = service.detailTeacher(memberId);
		model.addAttribute("subject", service.subjectBysubjectIdService(teacherDetailVo.getSubjectId()));
		model.addAttribute("teacher", teacherDetailVo);
		return "/schoolmanage/teacherListDetail";
	}
	
	
	//학교 관리자 -> 교사 수정 GET 
	@RequestMapping(value = "/teacherUpdate", method = RequestMethod.GET)
	public String teacherUpdate(MemberVO memberVO, Model model)throws Exception{
		TeacherDetailVO teacherDetailVO = service.detailTeacher(memberVO.getMemberId());
		model.addAttribute("preSubject", service.subjectBysubjectIdService(teacherDetailVO.getSubjectId()));
		model.addAttribute("subjectList", service.subjectList());
		model.addAttribute("teacherDetailVO", teacherDetailVO);
		return  "/schoolmanage/teacherUpdate";
		
	}
	//학교관리자 -> 교사 수정 POST 
	@RequestMapping(value = "/teacherUpdate", method = RequestMethod.POST)
	public String teacherUpdate(MemberVO member , TeacherVO teacherVO , Model model)throws Exception{
		service.updateMember(member);
		service.updateTeacher(teacherVO);
		String memberId = teacherVO.getMemberId();
		model.addAttribute("member", member);
		return "redirect:/teacherListDetail?memberId=" + memberId;
	}
	
	//학교관리자 -> 교사 삭제
		@RequestMapping(value = "/teacherDelete" , method=RequestMethod.GET)
		public String deleteTeacher(@RequestParam("memberId") String memberId , Model model)throws Exception{
			service.deleteTeacher1(memberId);
			service.deleteTeacher2(memberId);
			return "redirect:/schoolAdminTeacherList";
		}

}
