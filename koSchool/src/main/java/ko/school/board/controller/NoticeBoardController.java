package ko.school.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ko.school.board.domain.NoticeBoardVO;
import ko.school.board.service.NoticeBoardService;
import ko.school.common.domain.MemberVO;
import ko.school.common.domain.SchoolAdminVO;
import ko.school.common.domain.StudentVO;

@Controller
public class NoticeBoardController {
	
	@Inject
	private NoticeBoardService service;
	
	private boolean hitcountFlag = true;
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 등록 - 폼 접속  / 작성자 : 구혜인
	@RequestMapping(value="/insertNoticeBoardForm", method=RequestMethod.GET)
	public String insertNoticeBoardForm() throws Exception {
		return "/board/insertNoticeBoardForm";
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 등록  / 작성자 : 구혜인
	@RequestMapping(value="/insertNoticeBoardForm", method=RequestMethod.POST)
	public String insertNoticeBoardForm(NoticeBoardVO noticeBoardVo, HttpServletRequest request) throws Exception {
		MultipartFile file = noticeBoardVo.getFile();
		if(!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			File tempFile = new File(request.getRealPath("/upload"),file.getOriginalFilename());
			if(tempFile.exists() && tempFile.isFile()) {
				filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
				tempFile = new File(request.getRealPath("/upload"), filename);
			}
			file.transferTo(tempFile);
			noticeBoardVo.setNoticeBoardFileName(filename);
		} else {
			noticeBoardVo.setNoticeBoardFileName("");
		}
		
		
		service.insertNoticeBoardService(noticeBoardVo);
		return "redirect:/noticeBoardList";
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 리스트 조회 / 작성자 : 구혜인
	@RequestMapping("/noticeBoardList")
	public String noticeBoardList(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		String grade = (String)session.getAttribute("grade");
		String schoolAdminId = null;
		if (grade != null) {
			if (grade.equals("schoolAdmin")) {
				SchoolAdminVO schoolAdminVo = (SchoolAdminVO)session.getAttribute("schoolAdmin");
				schoolAdminId = schoolAdminVo.getSchoolAdminId();
			} else if (grade.equals("systemAdmin")) {
				return "/common/systemAdminMain";
			} else {
				MemberVO memberVo = (MemberVO)session.getAttribute("member");
				schoolAdminId = service.schoolAdminIdBySchoolIdService(memberVo.getSchoolId());
			}
		} else {
			return "/";
		}
		
		List<NoticeBoardVO> list = service.noticeBoardListService(schoolAdminId);
		model.addAttribute("noticeBoardList", list);
		return "/board/noticeBoardList";
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 세부 보기  / 작성자 : 구혜인
	@RequestMapping(value="/noticeBoardDetail", method=RequestMethod.GET)
	public String noticeBoardDetail(@RequestParam("noticeBoardNum") int noticeBoardNum, Model model) throws Exception {
		if(hitcountFlag == true) {
			service.addNoticeBoardHitcountService(noticeBoardNum);
		} else {
			hitcountFlag = true;
		}
		NoticeBoardVO noticeBoardVo =  service.noticeBoardDetailService(noticeBoardNum);
		model.addAttribute("noticeBoardDetail", noticeBoardVo);
		
		return "/board/noticeBoardDetail";
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 수정 - 수정 폼 접속 / 작성자 : 구혜인
	@RequestMapping(value="/updateNoticeBoardForm", method=RequestMethod.GET)
	public String updateNoticBoardForm(@RequestParam("noticeBoardNum") int noticeBoardNum, Model model) throws Exception {
		NoticeBoardVO noticeBoardVo = service.noticeBoardDetailService(noticeBoardNum);
		model.addAttribute("noticeBoardDetail", noticeBoardVo);
		return "/board/updateNoticeBoardForm";
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 수정 / 작성자 : 구혜인
	@RequestMapping(value="/updateNoticeBoardForm", method=RequestMethod.POST)
	public String updateNoticBoardForm(NoticeBoardVO noticeBoardVo, HttpServletRequest request) throws Exception {
		String preFileName = null;
		preFileName = noticeBoardVo.getNoticeBoardFileName();
		
		MultipartFile file = noticeBoardVo.getFile();
		if(!file.isEmpty()) {
			String filename = file.getOriginalFilename();
			File tempFile = new File(request.getRealPath("/upload"), file.getOriginalFilename());
			if(tempFile.exists() && tempFile.isFile()) {
				filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
				tempFile = new File(request.getRealPath("/upload"), filename);
			}
			file.transferTo(tempFile);
			noticeBoardVo.setNoticeBoardFileName(filename);
		}
		
		service.updateNoticBoardService(noticeBoardVo);
		
		if(!file.isEmpty() && preFileName != null) {
			File file2 = new File(request.getRealPath("/upload") + "/" + preFileName);
			if(file2.exists()) {
				file2.delete();
			}
		}
		
		hitcountFlag = false;
		return "redirect:/noticeBoardDetail?noticeBoardNum=" + noticeBoardVo.getNoticeBoardNum();
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 공지사항 삭제 / 작성자 : 구혜인
	@RequestMapping(value="/deleteNoticeBoard", method=RequestMethod.GET)
	public String deleteNoticeBoard(@RequestParam("noticeBoardNum") int noticeBoardNum, HttpServletRequest request) throws Exception {
		String fileName = null;
		NoticeBoardVO noticeBoardVo = service.noticeBoardDetailService(noticeBoardNum);
		if(noticeBoardVo.getNoticeBoardFileName() != null) {
			File file = new File(request.getRealPath("/upload") + "/" + noticeBoardVo.getNoticeBoardFileName());
			if(file.exists()) {
				file.delete();
			}
		}
		service.deleteNoticeBoardService(noticeBoardNum);
		return "redirect:/noticeBoardList";
	}

	//액터 ==> 학교관리자 / 작업 내용 : 파일 다운로드 / 작성자 : 구혜인
	@RequestMapping("/DownloadView")
	public ModelAndView DownloadView(HttpServletRequest request,
			@RequestParam("fileName") String fileName) {
		File file = new File(request.getRealPath("/upload"), fileName);
		return new ModelAndView("DownloadView", "downloadFile", file);
	}
	
	
	
	
	
}
