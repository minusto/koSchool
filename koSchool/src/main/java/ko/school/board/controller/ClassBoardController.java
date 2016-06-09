package ko.school.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ko.school.board.domain.ClassBoardVO;
import ko.school.board.service.ClassBoardService;
import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.StudentVO;

@Controller
public class ClassBoardController {

	@Inject
	private ClassBoardService service;
	
	@RequestMapping(value="/board/insertClassBoard", method=RequestMethod.GET)
	public String insertClassBoardGET(HttpServletRequest request , Model model)throws Exception{
		HttpSession session = request.getSession();
		
		if ("parent".equals(session.getAttribute("grade").toString())) {
			ParentVO parent = (ParentVO) session.getAttribute("parent");
			model.addAttribute("memberId", parent.getMemberId());
		} else {
			MemberVO member = (MemberVO) session.getAttribute("member");					
			model.addAttribute("memberId", member.getMemberId());
		}
		
		return "/board/insertClassBoard";
	}
	@RequestMapping(value="/board/insertClassBoard", method=RequestMethod.POST)
	public String insertClassBoardPOST(HttpServletRequest request , Model model , ClassBoardVO classBoardVO)throws Exception{
		HttpSession session = request.getSession();
		
		if ("parent".equals(session.getAttribute("grade").toString())) {
			ParentVO parent = (ParentVO) session.getAttribute("parent");
			model.addAttribute("member", parent);
			classBoardVO.setMemberId(parent.getMemberId());
		} else {
			MemberVO member = (MemberVO) session.getAttribute("member");					
			model.addAttribute("member", member);
			classBoardVO.setMemberId(member.getMemberId());
		}

		classBoardVO.setTeacherClass(session.getAttribute("teacherClass").toString());
		
		service.insertClassBoard(classBoardVO);
		return "redirect:/classBoardList";
	}
	@RequestMapping(value="/classBoardList", method=RequestMethod.GET)
	public String classBoardList(Model model , ClassBoardVO classBoardVO , HttpServletRequest request)throws Exception{
		
		HttpSession session = request.getSession();
	
		classBoardVO.setTeacherClass(session.getAttribute("teacherClass").toString());
		List<ClassBoardVO> list = service.teacherClassBoardList(classBoardVO);
		model.addAttribute("list", list);
		
		//String grade = session.getAttribute("grade").toString();
		/*if("parent".equals(grade)){
			ParentVO parentVO = (ParentVO) session.getAttribute("parent");
			classBoardVO.setMemberId(parentVO.getMemberId());
			
		}
		if("teacher".equals(grade)){
			MemberVO membervo = (MemberVO) session.getAttribute("member");
			classBoardVO.setMemberId(membervo.getMemberId());
			model.addAttribute("list", list);
		}
		if("student".equals(grade)){
			StudentVO studentVO = (StudentVO) session.getAttribute("student");
			classBoardVO.setMemberId(studentVO.getMemberId());
			List<ClassBoardVO> list = service.studentClassBoardList(classBoardVO);
		}*/
		return "/board/classBoardList";
		
	}
}
