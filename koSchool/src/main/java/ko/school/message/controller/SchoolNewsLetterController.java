package ko.school.message.controller;

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
import ko.school.message.domain.SchoolNewsLetterSignVO;
import ko.school.message.domain.SchoolNewsLetterVO;
import ko.school.message.service.SchoolNewsLetterService;

@Controller
public class SchoolNewsLetterController {
	
	@Inject
	private SchoolNewsLetterService service;
	
	//교사 -> 학부모 가정 통신문 발송 겟 (세션담기)
	@RequestMapping(value="schoolNewsLetter" , method=RequestMethod.GET)
	public String schoolNewsLetterInsertGET(HttpServletRequest request, Model model)throws Exception{
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		model.addAttribute("memberId", member.getMemberId());
		return "/message/schoolNewsLetter";
	}
	
	
	//교사, 학부모 -> 가정 통신문 리스트 조회 
	@RequestMapping(value="schoolNewsLetterList" , method=RequestMethod.GET)
	public String schoolNewsLetterList(SchoolNewsLetterVO schoolNews , Model model, HttpServletRequest request)throws Exception{
		
		HttpSession session = request.getSession();
		String grade = session.getAttribute("grade").toString();
		

		if ("parent".equals(grade)) {
			ParentVO member = (ParentVO) session.getAttribute("parent");
			String teacherMemberId = service.teacherMemberId(member);
			schoolNews.setMemberId(teacherMemberId);			
		}
		if ("teacher".equals(grade)) {
			MemberVO memberVO = (MemberVO) session.getAttribute("member");
			schoolNews.setMemberId(memberVO.getMemberId());		
		}
		
		model.addAttribute("list", service.schoolNewsLetterList(schoolNews));
		
		return "/message/schoolNewsLetterList";
	}
	
	//교사 -> 가정통신문 발송 과 학부모별 가정통신문 발송
	@RequestMapping(value="schoolNewsLetter" , method=RequestMethod.POST)
	public String schoolNewsLetterInsertPOST(SchoolNewsLetterVO schoolNews , ParentVO parentVO)throws Exception{
		
		//가정통신문 등록
		service.schoolNewsLetterInsert(schoolNews);
		System.out.println("memberId=========" +schoolNews.getMemberId());
		System.out.println("number===========" + schoolNews.getSchoolNewsLetterNum());
		System.out.println("title===========" + schoolNews.getTitle());
		System.out.println("content=========" + schoolNews.getContent());
		
		//교사의 담당학생 학부모 로우값 반환
		List<ParentVO> parentList = service.teacherParentList(schoolNews);
	
		//싸인테이블 객체화
		SchoolNewsLetterSignVO sign = new SchoolNewsLetterSignVO();
		
		//가정통신문 학부모 싸인테이블정보 등록
		for (int i = 0; i < parentList.size(); i++) {
			
			
			sign.setSchoolNewsLetterNum(schoolNews.getSchoolNewsLetterNum());
			sign.setMemberId(parentList.get(i).getMemberId());
			service.schoolNewsLetterSignInsert(sign);
		}
		
		return "redirect:/message/schoolNewsLetterList?memberId=" + schoolNews.getMemberId();
	}
	

	//학부모 가정통신문 조회
	@RequestMapping(value="parentNoticeBoardList" , method=RequestMethod.GET)
	public String parentNoticeBoardList(SchoolNewsLetterVO schoolNews , Model model)throws Exception{
		model.addAttribute("list", service.schoolNewsLetterList(schoolNews));
		return "/message/parentNoticeBoardList";
	}
	
	//학부모 가정통신문 상세페이지 (Detail)
	@RequestMapping(value="schoolNewsLetterDetail" , method=RequestMethod.GET)
	public String schoolNewsLetterDetail(HttpServletRequest request, @RequestParam("schoolNewsLetterNum") int schoolNewsLetterNum ,  Model model)throws Exception{
		
		HttpSession session = request.getSession();
		String grade = session.getAttribute("grade").toString();
		
		//선생님일 경우 싸인 리스트를 가져온다.
		if ("teacher".equals(grade)) {
			SchoolNewsLetterSignVO schoolNewsLetterSignVO = new SchoolNewsLetterSignVO();
			schoolNewsLetterSignVO.setSchoolNewsLetterNum(schoolNewsLetterNum);
			
			model.addAttribute("signList", service.schoolNewsLetterSignList(schoolNewsLetterSignVO));
		}
		
		model.addAttribute("detail", service.schoolNewsLetterDetail(schoolNewsLetterNum)); 	
		return "/message/schoolNewsLetterDetail";
	}
	
	//학부모 싸인 저장 Proc
	@RequestMapping(value="schoolNewsLetterSignUpdate" , method=RequestMethod.POST)
	public String schoolNewsLetterSignUpdate(SchoolNewsLetterSignVO schoolNewsLetterSignVO, HttpServletRequest request)throws Exception{
		
		HttpSession session = request.getSession();
		ParentVO parentVO = (ParentVO) session.getAttribute("parent");
		
		schoolNewsLetterSignVO.setMemberId(parentVO.getMemberId());
		
		service.schoolNewsLetterSignUpdate(schoolNewsLetterSignVO);
		
		return "/message/schoolNewsLetterDetail";
	}
}
