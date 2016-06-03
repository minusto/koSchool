package ko.school.score.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.TeacherVO;
import ko.school.membermanage.domain.StudentDetail;
import ko.school.schoolmanage.domain.TeacherDetailVO;
import ko.school.score.domain.MockTestVO;
import ko.school.score.domain.MockTypeVO;
import ko.school.score.domain.ResearchSubjectPackage;
import ko.school.score.domain.ResearchSubjectVO;
import ko.school.score.domain.SecondLanguageScoreVO;
import ko.school.score.domain.SecondLanguageVO;
import ko.school.score.service.MockScoreService;

@Controller
public class MockScoreController {
	
	@Inject
	private MockScoreService service;
	
	boolean isPreMockTestScoreFlag = false;
	boolean duplicationResearchSubjectFlag = false;
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 폼 접속 - 교사의 반 학생 리스트, 탐구 리스트, 제2외국어 리스트 / 작성자 : 구혜인
	@RequestMapping(value="/insertMockScoreForm", method=RequestMethod.GET)
	public String insertMockScoreForm(HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		List<StudentDetail> studentList = null;
		
		MemberVO memberVo = (MemberVO)session.getAttribute("member");
		TeacherVO teacherVo = (TeacherVO)session.getAttribute("teacher");
		TeacherDetailVO teacherDetailVo = new TeacherDetailVO();
		
Map<String, String> map = new HashMap<String, String>();
		
		int classNumInt = teacherVo.getTeacherClass() % 100;
		String classNum = Integer.toString(classNumInt);
		
		map.put("schoolId", memberVo.getSchoolId());
		map.put("classNum", classNum);
		
		studentList = service.studentListInTeacherClassService(map);
		
		List<ResearchSubjectVO> researchSubjectList = service.researchSubjectListService();
		List<SecondLanguageVO> secondLanguageList = service.secondLanguageListService();

		model.addAttribute("techerClassStudentList", studentList);
		model.addAttribute("researchSubjectList", researchSubjectList);
		model.addAttribute("secondLanguageList", secondLanguageList);
		
		model.addAttribute("isPreMockTestScoreFlag", isPreMockTestScoreFlag);
		model.addAttribute("duplicationResearchSubjectFlag", duplicationResearchSubjectFlag);
		return "/score/mock/insertMockScoreForm";
	}
	
	//액터 ==> 교사 / 작업 내용 : 모의고사 성적 입력 / 작성자 : 구혜인
	@RequestMapping(value="/insertMockScoreForm", method=RequestMethod.POST)
	public String insertMockScoreForm(MockTypeVO mockTypeVo, MockTestVO mockTestVo,
			SecondLanguageVO secondLanguageVo, SecondLanguageScoreVO secondLanguageScoreVo, 
			ResearchSubjectPackage researchSubjectPackage, Model model) throws Exception {
		duplicationResearchSubjectFlag = false;
		isPreMockTestScoreFlag = false;
		
		//mockType으로 mockId 뽑아오기
		String mockId = service.selectMockIdService(mockTypeVo);
		
		mockTestVo.setMockId(mockId);
		//입력했던 모의고사였는지 확인해야 한다. -> mockTest를 파라미터로.
		MockTestVO checkMockTestVo = null;
		checkMockTestVo = service.checkMockTestInsertedScoreService(mockTestVo);
		if(checkMockTestVo != null) {
			isPreMockTestScoreFlag = true;
			return "redirect:/insertMockScoreForm";
		}
		
		//탐구과목 중복되는 경우.
		if(researchSubjectPackage.getResearchSubjectName1().equals(researchSubjectPackage.getResearchSubjectName2())) {
			duplicationResearchSubjectFlag = true;
			return "redirect:/insertMockScoreForm";
		}
			
		secondLanguageScoreVo.setMockId(mockId);
		
		//제2외국어가 있다면 제2외국어 아이디를 찾아와 MockTestVO에 넣기
		if(secondLanguageScoreVo.getSecondLanguageOriginalScore() > 0) {
			String secondLanguageId = service.selectSecondLanguageIdService(secondLanguageVo.getLanguageSubjectName());
			mockTestVo.setLanguageId(secondLanguageId);
		} else {
			mockTestVo.setLanguageId("");
		}
		
		//학년별로 모의고사 점수 입력
		int studentGrade = mockTypeVo.getMockGrade();
		switch (studentGrade) {
		case 1:
			service.insertMockTestScoreGrade1Service(mockTestVo);
			break;
		case 2:
			service.insertMockTestScoreGrade2Service(mockTestVo);
			break;
		case 3:
			service.insertMockTestScoreGrade3Service(mockTestVo);
			break;
		}
		
		//제2외국어가 있다면 점수 입력
		if(secondLanguageScoreVo.getSecondLanguageOriginalScore() > 0) {
			service.insertSecondLanguageScoreService(secondLanguageScoreVo);
		}
		
		service.insertResearchSubjectScoreService(researchSubjectPackage, mockTestVo);
		
		return "redirect:/teacherMain";
	}

	
}
