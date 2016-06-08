package ko.school.score.controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.membermanage.domain.StudentDetail;
import ko.school.score.domain.LanguageRankList;
import ko.school.score.domain.MockAvgScore;
import ko.school.score.domain.MockResearchScoreDetailList;
import ko.school.score.domain.MockScoreDetailList;
import ko.school.score.domain.MockTestVO;
import ko.school.score.domain.MockTypeVO;
import ko.school.score.domain.ResearchSubjectScoreVO;
import ko.school.score.domain.ResearchSubjectVO;
import ko.school.score.service.MockTestService;

@Controller
public class MockTestController {

	@Inject
	private MockTestService service;

	@RequestMapping("/mockTestList")
	public String mockTestList(@RequestParam("id") String id, Model model) {

		String studentId = id;

		// 학생의 상세정보 호출
		StudentDetail studentDetail = service.selectStudentDetailService(studentId);
		List<MockTypeVO> mockList = service.studentMockTestListService(studentId);

		model.addAttribute("studentDetail", studentDetail);
		model.addAttribute("mockList", mockList);

		model.addAttribute("studentId", studentId);

		//-------------------CHART에 필요한 부분-------------
		//학생이 치룬 모든 모의고사의 언어점수 LIST
		List<MockTestVO> selectMyKorScoreList = service.selectMyKorScoreService(studentId);
		model.addAttribute("selectMyKorScoreList", selectMyKorScoreList);
		
		//학생이 치룬 모든 모의고사의 언어 평균점수 LIST
		List<MockAvgScore> selectMockKorAvgScoreList = service.selectMockKorAvgScoreService(studentId);
		model.addAttribute("selectMockKorAvgScoreList", selectMockKorAvgScoreList);
		
		//학생이 치룬 모든 모의고사의 수리점수 LIST
		List<MockTestVO> selectMyMathScoreList = service.selectMyMathScoreService(studentId);
		model.addAttribute("selectMyMathScoreList", selectMyMathScoreList);
		
		//학생이 치룬 모든 모의고사의 수리 평균점수 LIST
		List<MockAvgScore> selectMockMathAvgScoreList = service.selectMockMathAvgScoreService(studentId);
		model.addAttribute("selectMockMathAvgScoreList", selectMockMathAvgScoreList);
		
		//학생이 치룬 모든 모의고사의 외국어점수 LIST
		List<MockTestVO> selectMyEngScoreList = service.selectMyEngScoreService(studentId);
		model.addAttribute("selectMyEngScoreList", selectMyEngScoreList);
		
		//학생이 치룬 모든 모의고사의 외국어 평균점수 LIST
		List<MockAvgScore> selectMockEngAvgScoreList = service.selectMockEngAvgScoreService(studentId);
		model.addAttribute("selectMockEngAvgScoreList", selectMockEngAvgScoreList);
		// CHART END

		String studentName = studentDetail.getMemberName();
		model.addAttribute("studentName", studentName);

		return "/score/mock/userListMockTestScore";
	}

	@RequestMapping("/mockTestDetail")
	public String mockTestDetail(@RequestParam("mockId") String mockId, @RequestParam("id") String id, Model model,HttpServletRequest request) {
		HttpSession session=request.getSession();
		MemberVO memberVO=(MemberVO)session.getAttribute("member");
		String grade=(String)session.getAttribute("grade");
		if(grade.equals("student")){
			if(!id.equals(memberVO.getMemberId())){
				return "redirect:/";
			}
		}else if(grade.equals("parent")){
			ParentVO parentVO=(ParentVO)session.getAttribute("parent");
			if(!id.equals(parentVO.getStudentMemberId())){
				return "redirect:/";
			}
		}
		
		String studentId = id;

		// 학생의 상세정보 호출
		StudentDetail studentDetail = service.selectStudentDetailService(studentId);
		List<MockTypeVO> mockList = service.studentMockTestListService(studentId);

		model.addAttribute("studentDetail", studentDetail);
		model.addAttribute("mockList", mockList);

		model.addAttribute("studentId", studentId);


		//-------------------CHART에 필요한 부분-------------
		//학생이 치룬 모든 모의고사의 언어점수 LIST
		List<MockTestVO> selectMyKorScoreList = service.selectMyKorScoreService(studentId);
		model.addAttribute("selectMyKorScoreList", selectMyKorScoreList);
		
		//학생이 치룬 모든 모의고사의 언어 평균점수 LIST
		List<MockAvgScore> selectMockKorAvgScoreList = service.selectMockKorAvgScoreService(studentId);
		model.addAttribute("selectMockKorAvgScoreList", selectMockKorAvgScoreList);
		
		//학생이 치룬 모든 모의고사의 수리점수 LIST
		List<MockTestVO> selectMyMathScoreList = service.selectMyMathScoreService(studentId);
		model.addAttribute("selectMyMathScoreList", selectMyMathScoreList);
		
		//학생이 치룬 모든 모의고사의 수리 평균점수 LIST
		List<MockAvgScore> selectMockMathAvgScoreList = service.selectMockMathAvgScoreService(studentId);
		model.addAttribute("selectMockMathAvgScoreList", selectMockMathAvgScoreList);
		
		//학생이 치룬 모든 모의고사의 외국어점수 LIST
		List<MockTestVO> selectMyEngScoreList = service.selectMyEngScoreService(studentId);
		model.addAttribute("selectMyEngScoreList", selectMyEngScoreList);
		
		//학생이 치룬 모든 모의고사의 외국어 평균점수 LIST
		List<MockAvgScore> selectMockEngAvgScoreList = service.selectMockEngAvgScoreService(studentId);
		model.addAttribute("selectMockEngAvgScoreList", selectMockEngAvgScoreList);
		// CHART END
		
		
		
		
		
		
		String studentName = studentDetail.getMemberName();
		model.addAttribute("studentName", studentName);

		List<ResearchSubjectVO> researchSubjectList = service.selectResearchSubjectListService();
		model.addAttribute("researchSubjectList", researchSubjectList);

		MockResearchScoreDetailList researchScoreDetail = null;
		List<MockResearchScoreDetailList> researchScoreList = service.studentMockResearchSocreListService(mockId);
		for (int i = 0; i < researchScoreList.size(); i++) {
			if (researchScoreList.get(i).getMemberId().equals(studentId)) {
				researchScoreDetail = researchScoreList.get(i);
			}

		}

		// 해당 모의고사를 치룬 학생의 탐구과목 정보(점수)를 가져온다 ==> 모의고사 ID를 파라미터로 보내 받아온 결과를 학생
		// ID와 비교
		List<MockScoreDetailList> mockScoreDetailList = service.studentMockScorePlusSecondLangListService(studentId);

		// 학생이 치룬 모의고사의 탐구과목을 제외한 나머지 과목의 정보를 가져온다 ==> 멤버 ID를 파라미터로 보내 받아온 결과를
		// 모의고사 ID와 비교

		List<ResearchSubjectScoreVO> koreaHistroyScoreList = service.koreaHistroyScoreListService(studentId);
		// 한국사 시험을 치룬 학생의 점수 LIST ==> 멤버 ID를 파라미터로 보내 받아온 결과를 모의고사 ID와 비교 파라미터 =
		// memberId
		model.addAttribute("researchScoreList", researchScoreList);
		model.addAttribute("mockScoreDetailList", mockScoreDetailList);
		model.addAttribute("koreaHistroyScoreList", koreaHistroyScoreList);
		model.addAttribute("mockId", mockId);

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("studentId", studentId);
		map.put("mockId", mockId);

		// 언어영역 학교석차 뽑기
		List<LanguageRankList> rankList = service.languageRankListService(map);
		for (int i = 0; i < rankList.size(); i++) {
			LanguageRankList lgList = rankList.get(i);
			if (lgList.getStudentId().equals(studentId)) {
				model.addAttribute("languageSchoolRank", lgList.getRank());
				break;
			}
		}
		// 수리영역 학교석차 뽑기
		rankList = service.mathRankListService(map);
		for (int i = 0; i < rankList.size(); i++) {
			LanguageRankList lgList = rankList.get(i);
			if (lgList.getStudentId().equals(studentId)) {
				model.addAttribute("mathSchoolRank", lgList.getRank());
				break;
			}
		}

		// 외국어영역 학교석차 뽑기
		rankList = service.englishRankListService(map);
		for (int i = 0; i < rankList.size(); i++) {
			LanguageRankList lgList = rankList.get(i);
			if (lgList.getStudentId().equals(studentId)) {
				model.addAttribute("englishSchoolRank", lgList.getRank());
				break;
			}
		}

		// 탐구영역 첫번째 과목 학교석차 뽑기
		String researchSub1 = researchScoreDetail.getResearchSubjectId1();
		map.put("researchSubjectId", researchSub1);
		rankList = service.researchSubjectRankListService(map);
		for (int i = 0; i < rankList.size(); i++) {
			LanguageRankList lgList = rankList.get(i);
			if (lgList.getStudentId().equals(studentId)) {
				model.addAttribute("researchSubjectSchoolRank1", lgList.getRank());
				break;
			}
		}
		// 탐구영역 두번째 과목 학교석차 뽑기
		String researchSub2 = researchScoreDetail.getResearchSubjectId2();
		map.put("researchSubjectId", researchSub2);
		rankList = service.researchSubjectRankListService(map);
		for (int i = 0; i < rankList.size(); i++) {
			LanguageRankList lgList = rankList.get(i);
			if (lgList.getStudentId().equals(studentId)) {
				model.addAttribute("researchSubjectSchoolRank2", lgList.getRank());
				break;
			}
		}

		// 제2외국어 과목 학교석차 뽑기
		// secondLanguageRankList
		List<LanguageRankList> secondLanguageRankList = service.secondLanguageRankListService(map);
		if (secondLanguageRankList != null) {
			for (int i = 0; i < secondLanguageRankList.size(); i++) {
				LanguageRankList lgList = secondLanguageRankList.get(i);
				if (lgList.getStudentId().equals(studentId)) {
					model.addAttribute("secondLanguageSchoolRank", lgList.getRank());
					break;
				}
			}
		}

		// 한국사 과목 학교석차 뽑기
		List<LanguageRankList> koreaHistorySubjectRankList = service.koreaHistorySubjectRankListService(map);
		if (koreaHistorySubjectRankList != null) {
			for (int i = 0; i < koreaHistorySubjectRankList.size(); i++) {
				LanguageRankList lgList = koreaHistorySubjectRankList.get(i);
				if (lgList.getStudentId().equals(studentId)) {
					model.addAttribute("koreaHistorySubjectSchoolRank", lgList.getRank());
					break;
				}
			}
		}

		// 과목별 학급 석차 START
		// 언영영역 학급석차
		map.put("studentGrade", studentDetail.getStudentGrade());
		map.put("studentClass", studentDetail.getStudentClass());
		rankList = service.languageClassRankListService(map);
		for (int i = 0; i < rankList.size(); i++) {
			LanguageRankList lgList = rankList.get(i);
			if (lgList.getStudentId().equals(studentId)) {
				model.addAttribute("languageClassRank", lgList.getRank());
				break;
			}
		}


		// 외국어영역 학급석차
	
		List<LanguageRankList> rankList1 = service.englishClassRankListService(map);
		for (int i = 0; i < rankList1.size(); i++) {
			LanguageRankList lgList = rankList1.get(i);
			if (lgList.getStudentId().equals(studentId)) {
				model.addAttribute("englishClassRank", lgList.getRank());
				break;
			}
		}
		
		
		
		
		// 수리영역 학급석차
		rankList = service.mathClassRankListService(map);
		for (int i = 0; i < rankList.size(); i++) {
			LanguageRankList lgList = rankList.get(i);
			if (lgList.getStudentId().equals(studentId)) {
				model.addAttribute("mathClassRank", lgList.getRank());
				break;
			}
		}


		// 탐구영역 첫번째 과목 학급석차
		map.put("researchSubjectId", researchSub1);
		rankList = service.researchSubjectClassRankListService(map);
		for (int i = 0; i < rankList.size(); i++) {
			LanguageRankList lgList = rankList.get(i);
			if (lgList.getStudentId().equals(studentId)) {
				model.addAttribute("researchSubject1ClassRank", lgList.getRank());
				break;
			}
		}
		// 탐구영역 두번째 과목 학급석차
		map.put("researchSubjectId", researchSub2);
		rankList = service.researchSubjectClassRankListService(map);
		for (int i = 0; i < rankList.size(); i++) {
			LanguageRankList lgList = rankList.get(i);
			if (lgList.getStudentId().equals(studentId)) {
				model.addAttribute("researchSubject1ClassRank", lgList.getRank());
				break;
			}
		}

		// 제2외국어 학급석차
		List<LanguageRankList> secondLanguageClassRankList = service.secondLanguageClassRankListService(map);
		if (secondLanguageClassRankList != null) {
			for (int i = 0; i < secondLanguageClassRankList.size(); i++) {
				LanguageRankList lgList = secondLanguageClassRankList.get(i);
				if (lgList.getStudentId().equals(studentId)) {
					model.addAttribute("secondLanguageClassRank", lgList.getRank());
					break;
				}
			}
		}

		// 한국사 학급석차
		List<LanguageRankList> koreaHistorySubjectClassRankList = service.koreaHistorySubjectClassRankListService(map);
		if (koreaHistorySubjectClassRankList != null) {
			for (int i = 0; i < koreaHistorySubjectClassRankList.size(); i++) {
				LanguageRankList lgList = koreaHistorySubjectClassRankList.get(i);
				if (lgList.getStudentId().equals(studentId)) {
					model.addAttribute("koreaHistorySubjectClassRank", lgList.getRank());
					break;
				}
			}
		}

		return "/score/mock/userListMockTestScore";
	}
}
