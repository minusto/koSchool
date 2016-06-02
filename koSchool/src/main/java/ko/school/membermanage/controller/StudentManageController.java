package ko.school.membermanage.controller;

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

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.StudentVO;
import ko.school.membermanage.domain.ParentList;
import ko.school.membermanage.domain.ParentNullList;
import ko.school.membermanage.domain.StudentDetail;
import ko.school.membermanage.domain.StudentList;
import ko.school.membermanage.service.StudentManageService;
import ko.school.schoolmanage.domain.ImageUtil;

@Controller
public class StudentManageController {
	@Inject
	private StudentManageService service;
	
	//학생 정보 입력 폼
	@RequestMapping(value="/teacherInsertStudentForm",  method= RequestMethod.GET)
	public String teacherInsertStudentForm(Model model, HttpSession session)throws Exception{
		MemberVO member = (MemberVO)session.getAttribute("member");
		String id = member.getSchoolId();
		List<MemberVO> list=  service.sameSchoolStudentNullList(id);
		model.addAttribute("list",list);
		model.addAttribute("path", "학생 관리 > 학생 정보 입력");
		return "/membermanage/teacher/teacherInsertStudentForm";
	}
	//학생 정보 입력 작성자: 유지훈
	@RequestMapping(value="/teacherInsertStudentForm", method=RequestMethod.POST)
	public String insertStudent(MemberVO member, StudentVO student,HttpServletRequest request)throws Exception{
		
		MultipartFile file = student.getFile();// 파일 받음
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


			student.setStudentPicture(filename);	// 업로드된 파일이름 등록

		}
		
		service.updateMember(member);
		service.updateStudent(student);
		
		
		return "/membermanage/teacher/teacherInsertStudentForm";
	}
	
	
	//학생 조회
	@RequestMapping(value="/teacherListStudent", method=RequestMethod.GET)
	public String teacherListStudent(Model model,HttpSession session)throws Exception{
		MemberVO member = (MemberVO)session.getAttribute("member");
		String schoolId = member.getSchoolId();
		List<StudentList> list = service.studentList(schoolId);
		model.addAttribute("list",list);
		model.addAttribute("path", "학생 관리 > 학생 정보 열람");
		return "/membermanage/teacher/teacherListStudent";
	}
	//학생 세부 정보
	@RequestMapping(value="/teacherListStudentDetail", method=RequestMethod.GET)
	public String teacherListStudentDetail(@RequestParam String m_id, Model model)throws Exception{
		System.out.println(m_id);
		StudentDetail student = service.selectStudentDetail(m_id);
		model.addAttribute("student",student);
		model.addAttribute("path", "학생관리 > 학생 정보 열람 > Detail" );
		return "/membermanage/teacher/teacherListStudentDetail";
	}
	//학생 정보 수정 작성자: 유지훈
	@RequestMapping(value="/correctionStudent", method=RequestMethod.POST)
	public String correctionStudent(MemberVO member, StudentVO student, Model model,HttpServletRequest request)throws Exception{
			
			MultipartFile file = student.getFile();// 파일 받음
			
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


				student.setStudentPicture(filename);	// 업로드된 파일이름 등록

		}else{ //파일 수정 안할경우 
					student.setStudentPicture(service.getStudentPic(member));
		}
			
			service.updateMember(member);
			service.updateStudent(student);
			String m_id = student.getMemberId();
			model.addAttribute("m_id", m_id);
			return "redirect:teacherListStudentDetail";
	}
	
	
	//학생 정보 삭제
	@RequestMapping(value="/deleteStudent", method=RequestMethod.GET)
	public String deleteStudent(@RequestParam String m_id)throws Exception{
		service.deleteStudent(m_id);
		service.deleteStudent2(m_id);
		return "redirect:teacherListStudent";
	}
	//학부모 입력 폼
	@RequestMapping(value="/teacherInsertParentForm", method=RequestMethod.GET)
	public String teacherInsertParentForm(Model model, HttpSession session)throws Exception{
		List<ParentNullList> list = service.parentNullList();
		model.addAttribute("list",list);
		MemberVO member = (MemberVO)session.getAttribute("member");
		String schoolId = member.getSchoolId();
		List<StudentList> list2 = service.studentList(schoolId);
		model.addAttribute("list2",list2);
		model.addAttribute("path", "학부모 관리 > 학부모 정보 입력");
		return "/membermanage/teacher/teacherInsertParentForm";
	}
	//학부모 입력
	@RequestMapping(value="/teacherInsertParentForm", method=RequestMethod.POST)
	public String insertParent(ParentVO parent)throws Exception{
		service.insertParent(parent);
		return "/membermanage/teacher/teacherInsertParentForm";
	}
	//학부모 조회
	@RequestMapping(value="/teacherListParent", method=RequestMethod.GET)
	public String teacherListParent(Model model)throws Exception{
		List<ParentList> list = service.parentList();
		model.addAttribute("list",list);
		model.addAttribute("path", "학부모 관리 > 학부모 정보 열람");
		return "/membermanage/teacher/teacherListParent";
	}
	
	
	
	
}
