package ko.school.board.controller;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ko.school.board.domain.ClassBoardVO;
import ko.school.board.domain.NoticeBoardVO;
import ko.school.board.service.ClassBoardService;
import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.StudentVO;

@Controller
public class ClassBoardController {

	@Inject
	private ClassBoardService service;
	
	private boolean hitcountFlag = true;
	
	
	//ALL 액터 학급게시판 발송 겟 / 작성자 : 이용갑 
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
	//모든 액터 학급게시판 발송하기 / 작성자 : 이용갑 
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
	
	//모든 액터 학급게시판 리스트 / 작성자 : 이용갑
	@RequestMapping(value="/classBoardList", method=RequestMethod.GET)
	public String classBoardList(Model model , ClassBoardVO classBoardVO , HttpServletRequest request)throws Exception{
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		model.addAttribute("member", member);
	
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
	
	//모든 액터 학급게시판 디테일
	@RequestMapping(value="/classBoardDetail", method=RequestMethod.GET)
	public String noticeBoardDetail(@RequestParam("classBoardNum") int classBoardNum, Model model) throws Exception {
		if(hitcountFlag == true) {
			/*service.classBoardHitcountService(classBoardNum);*/
		} else {
			hitcountFlag = true;
		}
		ClassBoardVO classBoardVO =  service.classBoardDetailService(classBoardNum);
		model.addAttribute("classBoardDetail", classBoardVO);
		
		return "/board/classBoardDetail";
	}
	
	//학급게시판 수정 겟 작성자 : 이용갑
	@RequestMapping(value="/classBoardUpdate", method=RequestMethod.GET)
	public String updateNoticBoardForm(@RequestParam("classBoardNum") int classBoardNum, Model model) throws Exception {
		ClassBoardVO classBoardVO = service.classBoardDetailService(classBoardNum);
		model.addAttribute("classBoardDetail", classBoardVO);
		return "/board/classBoardUpdate";
	}
	
	//학급게시판 수정 (자신것만 수정하게) 작성자 : 이용갑 
	@RequestMapping(value="/classBoardUpdate", method=RequestMethod.POST)
	public String updateNoticBoardForm(ClassBoardVO classBoardVO, HttpServletRequest request) throws Exception {
		String preFileName = null;
		preFileName = classBoardVO.getClassBoardFilename();
		
		MultipartFile file = classBoardVO.getFile();
		if(!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			File tempFile = new File(request.getRealPath("/upload"), file.getOriginalFilename());
			if(tempFile.exists() && tempFile.isFile()) {
				filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
				tempFile = new File(request.getRealPath("/upload"), filename);
			}
			file.transferTo(tempFile);
			classBoardVO.setClassBoardFilename(filename);
		}
		
		service.classBoardUpdate(classBoardVO);
		
		if(!file.isEmpty() && preFileName != null) {
			File file2 = new File(request.getRealPath("/upload") + "/" + preFileName);
			if(file2.exists()) {
				file2.delete();
			}
		}
		
		hitcountFlag = false;
		return "redirect:/classBoardDetail?classBoardNum=" + classBoardVO.getClassBoardNum();
	}
	
	//학급게시판 삭제 작성자 : 이용갑 
	@RequestMapping(value="/classBoardDelete", method=RequestMethod.GET)
	public String deleteNoticeBoard(@RequestParam("classBoardNum") int classBoardNum, HttpServletRequest request) throws Exception {
		String fileName = null;
		ClassBoardVO classBoardVO = service.classBoardDetailService(classBoardNum);
		if(classBoardVO.getClassBoardFilename() != null) {
			File file = new File(request.getRealPath("/upload") + "/" + classBoardVO.getClassBoardFilename());
			if(file.exists()) {
				file.delete();
			}
		}
		service.classBoardDelete(classBoardNum);
		return "redirect:/classBoardList";
	}
}
