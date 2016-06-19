package ko.school.simulation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.common.domain.StudentVO;
import ko.school.score.domain.AllRankingScoreList;
import ko.school.score.domain.AllStudentNum;
import ko.school.score.domain.Subject;
import ko.school.simulation.domain.SusiDetailDTO;
import ko.school.simulation.domain.SusiInfoVO;
import ko.school.simulation.domain.SusiRatingDTO;
import ko.school.simulation.domain.SusiSubjectDTO;
import ko.school.simulation.domain.UniversityVO;
import ko.school.simulation.persistence.SusiSimulationDAO;

@Service
public class SusiSimulationServiceImpl implements SusiSimulationService {
	@Inject
	private SusiSimulationDAO dao;
	// 반영 주요 교과목
	private String[] mainType = { "국어", "영어", "수학", "사회", "과학" };
	private String[] mainCnt = { "국어개수", "영어개수", "수학개수", "사회개수", "과학개수" };
	// 반영 비교과목
	private String[] subType = { "도덕", "체육", "음악", "미술", "기술.가정", "제2외국어", "한문" };

	// 등급 평균 Method
	public Map<String, Object> mainMethod(Map<String, Object> map) throws Exception {
		String id = (String) map.get("id");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 해당 학년 해당 학기 전과목 학교석차 불러옴
		List<AllRankingScoreList> rankList = dao.allRankingScoreList(map);
		// 해당 학생이 해당 학년 해당 학기때 수강한 subject ID와 TYPE
		List<SusiSubjectDTO> subjectList = dao.susiSubject(map);
		// 전체 과목별 전체명수
		List<AllStudentNum> numList = dao.allStudentNum(map);
		
		Subject subject = new Subject();
		
		// 같은 학년 같은 학기에 수강한 모든 과목의 전체 인원 수는 같다고 가정한다.
		int allStudentNum = 0;
		for (int i = 0; i < numList.size(); i++) {
			if (!subjectList.isEmpty()) {
				if (numList.get(i).getSubjectId().equals(subjectList.get(0).getSubjectId())) {
					allStudentNum = numList.get(i).getAllStudentNum();
				}
			} else {
				allStudentNum = 0;
			}
		}

		// 해당하는 학생의 학교석차 구한 후 석차등급 변환 (주요 교과목)
		if (allStudentNum != 0) { // 수강과목의 전체명수가 0이 아닐때
			int sum = 0;
			int cnt = 0;
			for (int k = 0; k < mainType.length; k++) {
				for (int i = 0; i < subjectList.size(); i++) {
					// 교과목이 같다면 등급을 모두 더함
					if (subjectList.get(i).getSubjectType().equals(mainType[k])) {
						for (int j = 0; j < rankList.size(); j++) {
							if (subjectList.get(i).getSubjectId().equals(rankList.get(j).getSubjectId())) {
								if (rankList.get(j).getMemberId().equals(id)) {
									sum = ratingMethod(rankList.get(j).getRank(), allStudentNum) + sum;
									subject = dao.selectSubject(rankList.get(j).getSubjectId());
									cnt++; // 과목 개수
								}
							}
						}
					}
				}
				
				
				// 각 교과목의 등급과 개수를 map 담는다.
				resultMap.put(mainType[k]+"단위수", subject.getSubjectUnit());
				resultMap.put(mainType[k], sum);
				resultMap.put(mainCnt[k], cnt);
				sum = 0;
				cnt = 0;
			} // for End
				// 해당하는 학생의 학교석차 구한 후 석차등급 변환 (비교과목)
			int sum2 = 0;
			int cnt2 = 0;
			for (int k = 0; k < subType.length; k++) {
				for (int i = 0; i < subjectList.size(); i++) {
					// 교과목이 같다면 등급을 모두 더함
					if (subjectList.get(i).getSubjectType().equals(subType[k])) {
						for (int j = 0; j < rankList.size(); j++) {
							if (subjectList.get(i).getSubjectId().equals(rankList.get(j).getSubjectId())) {
								if (rankList.get(j).getMemberId().equals(id)) {
									sum2 = ratingMethod(rankList.get(j).getRank(), allStudentNum) + sum2;
									cnt2++; // 과목 개수
								}
							}
						}
					}
				}
			} // for End

			// 기타과목의 등급과 개수를 map 담는다.
			resultMap.put("기타단위수", 2);
			resultMap.put("기타", sum2);
			resultMap.put("기타개수", cnt2);
			sum2 = 0;
			cnt2 = 0;
		} else {
			for (int k = 0; k < mainType.length; k++) {
				resultMap.put(mainType[k]+"단위수", 0);
				resultMap.put(mainType[k], 0);
				resultMap.put(mainCnt[k], 0);
			}
			resultMap.put("기타단위수", 0);
			resultMap.put("기타", 0);
			resultMap.put("기타개수", 0);
		}
		return resultMap;

	}

	// 내신등급 구하기
	public int ratingMethod(int ranking, int allStudentNum) {
		int rating = 0;
		double percent = 0.0;
		percent = (ranking / (double) allStudentNum) * 100;
		if ((0 < percent) && (percent <= 4)) {
			rating = 1;
		} else if ((4 < percent) && (percent <= 11)) {
			rating = 2;
		} else if ((11 < percent) && (percent <= 23)) {
			rating = 3;
		} else if ((23 < percent) && (percent <= 40)) {
			rating = 4;
		} else if ((40 < percent) && (percent <= 60)) {
			rating = 5;
		} else if ((60 < percent) && (percent <= 77)) {
			rating = 6;
		} else if ((77 < percent) && (percent <= 89)) {
			rating = 7;
		} else if ((89 < percent) && (percent <= 96)) {
			rating = 8;
		} else if ((96 < percent) && (percent <= 100)) {
			rating = 9;
		}
		return rating;
	}

	@Override
	public StudentVO studentCheck(String id) throws Exception {
		return dao.studentCheck(id);
	}

	@Override
	public SusiRatingDTO grade1(int studentGrade, String id) throws Exception {
		SusiRatingDTO r_dto = new SusiRatingDTO();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> resultMap2 = new HashMap<String, Object>();
		if (studentGrade == 1) {
			double subject[] = new double[6];
			int cnt[] = new int[6];
			// 3학년 1학기
			map.put("id", id);
			map.put("semester", 1);
			map.put("nesinYear", 2016);
			resultMap = mainMethod(map);
			// 3학년 2학기
			map.put("id", id);
			map.put("semester", 2);
			map.put("nesinYear", 2016);
			resultMap2 = mainMethod(map);
			// 1학년 1,2학기 각 교과등급의 합
			subject[0] = (double) ((int) resultMap.get("국어") + (int) resultMap2.get("국어"));
			subject[1] = (double) ((int) resultMap.get("영어") + (int) resultMap2.get("영어"));
			subject[2] = (double) ((int) resultMap.get("수학") + (int) resultMap2.get("수학"));
			subject[3] = (double) ((int) resultMap.get("사회") + (int) resultMap2.get("사회"));
			subject[4] = (double) ((int) resultMap.get("과학") + (int) resultMap2.get("과학"));
			subject[5] = (double) ((int) resultMap.get("기타") + (int) resultMap2.get("기타"));
			// 1학년 1,2학기 각 교과 개수의 합
			cnt[0] = (int) resultMap.get("국어개수") + (int) resultMap2.get("국어개수");
			cnt[1] = (int) resultMap.get("영어개수") + (int) resultMap2.get("영어개수");
			cnt[2] = (int) resultMap.get("수학개수") + (int) resultMap2.get("수학개수");
			cnt[3] = (int) resultMap.get("사회개수") + (int) resultMap2.get("사회개수");
			cnt[4] = (int) resultMap.get("과학개수") + (int) resultMap2.get("과학개수");
			cnt[5] = (int) resultMap.get("기타개수") + (int) resultMap2.get("기타개수");

			// 각 교과등급 평균 set
			for (int i = 0; i < subject.length; i++) {
				if (cnt[i] != 0) {
					if (i == 0) {
						r_dto.setKor(Math.round((subject[0] / (double) cnt[0])*100)/100.0);
						r_dto.setKorUnit((int)resultMap.get("국어단위수"));
					} else if (i == 1) {
						r_dto.setEng(Math.round((subject[1] / (double) cnt[1])*100)/100.0);
						r_dto.setEngUnit((int)resultMap.get("영어단위수"));
					} else if (i == 2) {
						r_dto.setMath(Math.round((subject[2] / (double) cnt[2])*100)/100.0);
						r_dto.setMathUnit((int)resultMap.get("수학단위수"));
					} else if (i == 3) {
						r_dto.setSol(Math.round((subject[3] / (double) cnt[3])*100)/100.0);
						r_dto.setSolUnit((int)resultMap.get("사회단위수"));
					} else if (i == 4) {
						r_dto.setSci(Math.round((subject[4] / (double) cnt[4])*100)/100.0);
						r_dto.setSciUnit((int)resultMap.get("과학단위수"));
					} else if (i == 5) {
						r_dto.setEtc(Math.round((subject[5] / (double) cnt[5])*100)/100.0);
						r_dto.setEtcUnit((int)resultMap.get("기타단위수"));
					}
				}
			}
			
		} else if (studentGrade == 2) {
			double subject[] = new double[6];
			int cnt[] = new int[6];
			// 3학년 1학기
			map.put("id", id);
			map.put("semester", 1);
			map.put("nesinYear", 2015);
			resultMap = mainMethod(map);
			// 3학년 2학기
			map.put("id", id);
			map.put("semester", 2);
			map.put("nesinYear", 2015);
			resultMap2 = mainMethod(map);
			// 1학년 1,2학기 각 교과등급의 합
			subject[0] = (double) ((int) resultMap.get("국어") + (int) resultMap2.get("국어"));
			subject[1] = (double) ((int) resultMap.get("영어") + (int) resultMap2.get("영어"));
			subject[2] = (double) ((int) resultMap.get("수학") + (int) resultMap2.get("수학"));
			subject[3] = (double) ((int) resultMap.get("사회") + (int) resultMap2.get("사회"));
			subject[4] = (double) ((int) resultMap.get("과학") + (int) resultMap2.get("과학"));
			subject[5] = (double) ((int) resultMap.get("기타") + (int) resultMap2.get("기타"));
			// 1학년 1,2학기 각 교과 개수의 합
			cnt[0] = (int) resultMap.get("국어개수") + (int) resultMap2.get("국어개수");
			cnt[1] = (int) resultMap.get("영어개수") + (int) resultMap2.get("영어개수");
			cnt[2] = (int) resultMap.get("수학개수") + (int) resultMap2.get("수학개수");
			cnt[3] = (int) resultMap.get("사회개수") + (int) resultMap2.get("사회개수");
			cnt[4] = (int) resultMap.get("과학개수") + (int) resultMap2.get("과학개수");
			cnt[5] = (int) resultMap.get("기타개수") + (int) resultMap2.get("기타개수");

			// 각 교과등급 평균 set
						for (int i = 0; i < subject.length; i++) {
							if (cnt[i] != 0) {
								if (i == 0) {
									r_dto.setKor(Math.round((subject[0] / (double) cnt[0])*100)/100.0);
									r_dto.setKorUnit((int)resultMap.get("국어단위수"));
								} else if (i == 1) {
									r_dto.setEng(Math.round((subject[1] / (double) cnt[1])*100)/100.0);
									r_dto.setEngUnit((int)resultMap.get("영어단위수"));
								} else if (i == 2) {
									r_dto.setMath(Math.round((subject[2] / (double) cnt[2])*100)/100.0);
									r_dto.setMathUnit((int)resultMap.get("수학단위수"));
								} else if (i == 3) {
									r_dto.setSol(Math.round((subject[3] / (double) cnt[3])*100)/100.0);
									r_dto.setSolUnit((int)resultMap.get("사회단위수"));
								} else if (i == 4) {
									r_dto.setSci(Math.round((subject[4] / (double) cnt[4])*100)/100.0);
									r_dto.setSciUnit((int)resultMap.get("과학단위수"));
								} else if (i == 5) {
									r_dto.setEtc(Math.round((subject[5] / (double) cnt[5])*100)/100.0);
									r_dto.setEtcUnit((int)resultMap.get("기타단위수"));
								}
							}
						}
		} else if (studentGrade == 3) {
			double subject[] = new double[6];
			int cnt[] = new int[6];
			// 3학년 1학기
			map.put("id", id);
			map.put("semester", 1);
			map.put("nesinYear", 2014);
			resultMap = mainMethod(map);
			// 3학년 2학기
			map.put("id", id);
			map.put("semester", 2);
			map.put("nesinYear", 2014);			
			resultMap2 = mainMethod(map);
			// 1학년 1,2학기 각 교과등급의 합
			subject[0] = (double) ((int) resultMap.get("국어") + (int) resultMap2.get("국어"));
			subject[1] = (double) ((int) resultMap.get("영어") + (int) resultMap2.get("영어"));
			subject[2] = (double) ((int) resultMap.get("수학") + (int) resultMap2.get("수학"));
			subject[3] = (double) ((int) resultMap.get("사회") + (int) resultMap2.get("사회"));
			subject[4] = (double) ((int) resultMap.get("과학") + (int) resultMap2.get("과학"));
			subject[5] = (double) ((int) resultMap.get("기타") + (int) resultMap2.get("기타"));
			// 1학년 1,2학기 각 교과 개수의 합
			cnt[0] = (int) resultMap.get("국어개수") + (int) resultMap2.get("국어개수");
			cnt[1] = (int) resultMap.get("영어개수") + (int) resultMap2.get("영어개수");
			cnt[2] = (int) resultMap.get("수학개수") + (int) resultMap2.get("수학개수");
			cnt[3] = (int) resultMap.get("사회개수") + (int) resultMap2.get("사회개수");
			cnt[4] = (int) resultMap.get("과학개수") + (int) resultMap2.get("과학개수");
			cnt[5] = (int) resultMap.get("기타개수") + (int) resultMap2.get("기타개수");

			// 각 교과등급 평균 set
						for (int i = 0; i < subject.length; i++) {
							if (cnt[i] != 0) {
								if (i == 0) {
									r_dto.setKor(Math.round((subject[0] / (double) cnt[0])*100)/100.0);
									r_dto.setKorUnit((int)resultMap.get("국어단위수"));
								} else if (i == 1) {
									r_dto.setEng(Math.round((subject[1] / (double) cnt[1])*100)/100.0);
									r_dto.setEngUnit((int)resultMap.get("영어단위수"));
								} else if (i == 2) {
									r_dto.setMath(Math.round((subject[2] / (double) cnt[2])*100)/100.0);
									r_dto.setMathUnit((int)resultMap.get("수학단위수"));
								} else if (i == 3) {
									r_dto.setSol(Math.round((subject[3] / (double) cnt[3])*100)/100.0);
									r_dto.setSolUnit((int)resultMap.get("사회단위수"));
								} else if (i == 4) {
									r_dto.setSci(Math.round((subject[4] / (double) cnt[4])*100)/100.0);
									r_dto.setSciUnit((int)resultMap.get("과학단위수"));
								} else if (i == 5) {
									r_dto.setEtc(Math.round((subject[5] / (double) cnt[5])*100)/100.0);
									r_dto.setEtcUnit((int)resultMap.get("기타단위수"));
								}
							}
						}
		}
		return r_dto;
	}

	@Override
	public SusiRatingDTO grade2(int studentGrade, String id) throws Exception {
		SusiRatingDTO r_dto = new SusiRatingDTO();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> resultMap2 = new HashMap<String, Object>();
		if (studentGrade == 2) {
			double subject[] = new double[6];
			int cnt[] = new int[6];
			// 3학년 1학기
			map.put("id", id);
			map.put("semester", 1);
			map.put("nesinYear", 2016);
			resultMap = mainMethod(map);
			// 3학년 2학기
			map.put("id", id);
			map.put("semester", 2);
			map.put("nesinYear", 2016);
			resultMap2 = mainMethod(map);
			// 1학년 1,2학기 각 교과등급의 합
			subject[0] = (double) ((int) resultMap.get("국어") + (int) resultMap2.get("국어"));
			subject[1] = (double) ((int) resultMap.get("영어") + (int) resultMap2.get("영어"));
			subject[2] = (double) ((int) resultMap.get("수학") + (int) resultMap2.get("수학"));
			subject[3] = (double) ((int) resultMap.get("사회") + (int) resultMap2.get("사회"));
			subject[4] = (double) ((int) resultMap.get("과학") + (int) resultMap2.get("과학"));
			subject[5] = (double) ((int) resultMap.get("기타") + (int) resultMap2.get("기타"));
			// 1학년 1,2학기 각 교과 개수의 합
			cnt[0] = (int) resultMap.get("국어개수") + (int) resultMap2.get("국어개수");
			cnt[1] = (int) resultMap.get("영어개수") + (int) resultMap2.get("영어개수");
			cnt[2] = (int) resultMap.get("수학개수") + (int) resultMap2.get("수학개수");
			cnt[3] = (int) resultMap.get("사회개수") + (int) resultMap2.get("사회개수");
			cnt[4] = (int) resultMap.get("과학개수") + (int) resultMap2.get("과학개수");
			cnt[5] = (int) resultMap.get("기타개수") + (int) resultMap2.get("기타개수");

			
			// 각 교과등급 평균 set
						for (int i = 0; i < subject.length; i++) {
							if (cnt[i] != 0) {
								if (i == 0) {
									r_dto.setKor(Math.round((subject[0] / (double) cnt[0])*100)/100.0);
									r_dto.setKorUnit((int)resultMap.get("국어단위수"));
								} else if (i == 1) {
									r_dto.setEng(Math.round((subject[1] / (double) cnt[1])*100)/100.0);
									r_dto.setEngUnit((int)resultMap.get("영어단위수"));
								} else if (i == 2) {
									r_dto.setMath(Math.round((subject[2] / (double) cnt[2])*100)/100.0);
									r_dto.setMathUnit((int)resultMap.get("수학단위수"));
								} else if (i == 3) {
									r_dto.setSol(Math.round((subject[3] / (double) cnt[3])*100)/100.0);
									r_dto.setSolUnit((int)resultMap.get("사회단위수"));
								} else if (i == 4) {
									r_dto.setSci(Math.round((subject[4] / (double) cnt[4])*100)/100.0);
									r_dto.setSciUnit((int)resultMap.get("과학단위수"));
								} else if (i == 5) {
									r_dto.setEtc(Math.round((subject[5] / (double) cnt[5])*100)/100.0);
									r_dto.setEtcUnit((int)resultMap.get("기타단위수"));
								}
							}
						}
			
		} else if (studentGrade == 3) {
			
			double subject[] = new double[6];
			int cnt[] = new int[6];
			// 3학년 1학기
			map.put("id", id);
			map.put("semester", 1);
			map.put("nesinYear", 2015);
			
			resultMap = mainMethod(map);
			// 3학년 2학기
			map.put("id", id);
			map.put("semester", 2);
			map.put("nesinYear", 2015);
			
			resultMap2 = mainMethod(map);
			// 1학년 1,2학기 각 교과등급의 합
			subject[0] = (double) ((int) resultMap.get("국어") + (int) resultMap2.get("국어"));
			subject[1] = (double) ((int) resultMap.get("영어") + (int) resultMap2.get("영어"));
			subject[2] = (double) ((int) resultMap.get("수학") + (int) resultMap2.get("수학"));
			subject[3] = (double) ((int) resultMap.get("사회") + (int) resultMap2.get("사회"));
			subject[4] = (double) ((int) resultMap.get("과학") + (int) resultMap2.get("과학"));
			subject[5] = (double) ((int) resultMap.get("기타") + (int) resultMap2.get("기타"));
			// 1학년 1,2학기 각 교과 개수의 합
			cnt[0] = (int) resultMap.get("국어개수") + (int) resultMap2.get("국어개수");
			cnt[1] = (int) resultMap.get("영어개수") + (int) resultMap2.get("영어개수");
			cnt[2] = (int) resultMap.get("수학개수") + (int) resultMap2.get("수학개수");
			cnt[3] = (int) resultMap.get("사회개수") + (int) resultMap2.get("사회개수");
			cnt[4] = (int) resultMap.get("과학개수") + (int) resultMap2.get("과학개수");
			cnt[5] = (int) resultMap.get("기타개수") + (int) resultMap2.get("기타개수");

			
			// 각 교과등급 평균 set
						for (int i = 0; i < subject.length; i++) {
							if (cnt[i] != 0) {
								if (i == 0) {
									r_dto.setKor(Math.round((subject[0] / (double) cnt[0])*100)/100.0);
									r_dto.setKorUnit((int)resultMap.get("국어단위수"));
								} else if (i == 1) {
									r_dto.setEng(Math.round((subject[1] / (double) cnt[1])*100)/100.0);
									r_dto.setEngUnit((int)resultMap.get("영어단위수"));
								} else if (i == 2) {
									r_dto.setMath(Math.round((subject[2] / (double) cnt[2])*100)/100.0);
									r_dto.setMathUnit((int)resultMap.get("수학단위수"));
								} else if (i == 3) {
									r_dto.setSol(Math.round((subject[3] / (double) cnt[3])*100)/100.0);
									r_dto.setSolUnit((int)resultMap.get("사회단위수"));
								} else if (i == 4) {
									r_dto.setSci(Math.round((subject[4] / (double) cnt[4])*100)/100.0);
									r_dto.setSciUnit((int)resultMap.get("과학단위수"));
								} else if (i == 5) {
									r_dto.setEtc(Math.round((subject[5] / (double) cnt[5])*100)/100.0);
									r_dto.setEtcUnit((int)resultMap.get("기타단위수"));
								}
							}
						}
			
		}
		return r_dto;
	}

	@Override
	public SusiRatingDTO grade3(int studentGrade, String id) throws Exception {
		SusiRatingDTO r_dto = new SusiRatingDTO();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> resultMap2 = new HashMap<String, Object>();
		if (studentGrade == 3) {
			
			double subject[] = new double[6];
			int cnt[] = new int[6];
			// 3학년 1학기
			map.put("id", id);
			map.put("semester", 1);
			map.put("nesinYear", 2016);
			resultMap = mainMethod(map);
			// 3학년 2학기
			map.put("id", id);
			map.put("semester", 2);
			map.put("nesinYear", 2016);
			resultMap2 = mainMethod(map);
			// 1학년 1,2학기 각 교과등급의 합
			subject[0] = (double) ((int) resultMap.get("국어") + (int) resultMap2.get("국어"));
			subject[1] = (double) ((int) resultMap.get("영어") + (int) resultMap2.get("영어"));
			subject[2] = (double) ((int) resultMap.get("수학") + (int) resultMap2.get("수학"));
			subject[3] = (double) ((int) resultMap.get("사회") + (int) resultMap2.get("사회"));
			subject[4] = (double) ((int) resultMap.get("과학") + (int) resultMap2.get("과학"));
			subject[5] = (double) ((int) resultMap.get("기타") + (int) resultMap2.get("기타"));
			// 1학년 1,2학기 각 교과 개수의 합
			cnt[0] = (int) resultMap.get("국어개수") + (int) resultMap2.get("국어개수");
			cnt[1] = (int) resultMap.get("영어개수") + (int) resultMap2.get("영어개수");
			cnt[2] = (int) resultMap.get("수학개수") + (int) resultMap2.get("수학개수");
			cnt[3] = (int) resultMap.get("사회개수") + (int) resultMap2.get("사회개수");
			cnt[4] = (int) resultMap.get("과학개수") + (int) resultMap2.get("과학개수");
			cnt[5] = (int) resultMap.get("기타개수") + (int) resultMap2.get("기타개수");

			// 각 교과등급 평균 set
						for (int i = 0; i < subject.length; i++) {
							if (cnt[i] != 0) {
								if (i == 0) {
									r_dto.setKor(Math.round((subject[0] / (double) cnt[0])*100)/100.0);
									r_dto.setKorUnit((int)resultMap.get("국어단위수"));
								} else if (i == 1) {
									r_dto.setEng(Math.round((subject[1] / (double) cnt[1])*100)/100.0);
									r_dto.setEngUnit((int)resultMap.get("영어단위수"));
								} else if (i == 2) {
									r_dto.setMath(Math.round((subject[2] / (double) cnt[2])*100)/100.0);
									r_dto.setMathUnit((int)resultMap.get("수학단위수"));
								} else if (i == 3) {
									r_dto.setSol(Math.round((subject[3] / (double) cnt[3])*100)/100.0);
									r_dto.setSolUnit((int)resultMap.get("사회단위수"));
								} else if (i == 4) {
									r_dto.setSci(Math.round((subject[4] / (double) cnt[4])*100)/100.0);
									r_dto.setSciUnit((int)resultMap.get("과학단위수"));
								} else if (i == 5) {
									r_dto.setEtc(Math.round((subject[5] / (double) cnt[5])*100)/100.0);
									r_dto.setEtcUnit((int)resultMap.get("기타단위수"));
								}
							}
						}
			
		}
		return r_dto;
	}

	//차트에서 대학교 리스트 불러오기
	@Override
	public List<UniversityVO> univerSityChartList()throws Exception {
		return dao.univerSityChartList();
	}
	
	//수시 대학교 정보 목록
	@Override
	public List<SusiInfoVO> susiInfoList(Map<String, String> map) throws Exception {
		return dao.susiInfoList(map);
	}
	
	//지역이름
	@Override
	public String getLocation(String universityLocal) throws Exception {
	
		if (universityLocal.matches(".*서울.*")) { // text문자열중에서 abc를 포함하는지 확인
			return "서울";
		} else if(universityLocal.matches(".*경기.*")){
			return "경기";
		} else if(universityLocal.matches(".*충청남도.*")){
			return "충남";
		} else if(universityLocal.matches(".*충청북도.*")){
			return "충북";
		} else if(universityLocal.matches(".*전라남도.*")){
			return "전남";
		} else if(universityLocal.matches(".*전라북도.*")){
			return "전북";
		} else if(universityLocal.matches(".*대전.*")){
			return "대전";
		} else{
			return "기타지역";
		}
	}
	
	// 수시 점수 계산
	@Override
	public double getResultScore(String uniName, double[] pointPerGrade, SusiRatingDTO first,
			SusiRatingDTO second, SusiRatingDTO third, double[] gradeReflectionRate, String reflectionSubjects) throws Exception {
		double kor[] = new double[3];
		int korUnit[] = new int[3];
		double eng[] = new double[3];
		int engUnit[] = new int[3];
		double math[] = new double[3];
		int mathUnit[] = new int[3];
		double sol[] = new double[3];
		int solUnit[] = new int[3];
		double sci[] = new double[3];
		int sciUnit[] = new int[3];
		double etc[] = new double[3];
		int etcUnit[] = new int[3];
		if(reflectionSubjects.matches(".*국.*")) { // 반영 과목 검사
			
			kor[0] = pointPer(first.getKor(), pointPerGrade);  // 1학년
			korUnit[0] = first.getKorUnit();
			kor[1] = pointPer(second.getKor(), pointPerGrade);  // 2학년
			korUnit[1] = second.getKorUnit();
			kor[2] = pointPer(third.getKor(), pointPerGrade); // 3학년
			korUnit[2] = third.getKorUnit();
		}
		if(reflectionSubjects.matches(".*영.*")){
			eng[0] = pointPer(first.getEng(), pointPerGrade);  // 1학년
			engUnit[0] = first.getEngUnit();
			eng[1] = pointPer(second.getEng(), pointPerGrade);  // 2학년
			engUnit[1] = second.getEngUnit();
			eng[2] = pointPer(third.getEng(), pointPerGrade); // 3학년
			engUnit[2] = third.getEngUnit();
		}
		if(reflectionSubjects.matches(".*수.*")){
			math[0] = pointPer(first.getMath(), pointPerGrade);  // 1학년
			mathUnit[0] = first.getMathUnit();
			math[1] = pointPer(second.getMath(), pointPerGrade);  // 2학년
			mathUnit[1] = second.getMathUnit();
			math[2] = pointPer(third.getMath(), pointPerGrade); // 3학년
			mathUnit[2] = third.getMathUnit();
		}
		if(reflectionSubjects.matches(".*사.*")){
			sol[0] = pointPer(first.getSol(), pointPerGrade);  // 1학년
			solUnit[0] = first.getSolUnit();
			sol[1] = pointPer(second.getSol(), pointPerGrade);  // 2학년
			solUnit[1] = second.getSolUnit();
			sol[2] = pointPer(third.getSol(), pointPerGrade); // 3학년
			solUnit[2] = third.getSolUnit();
		}
		if(reflectionSubjects.matches(".*과.*")){
			sci[0] = pointPer(first.getSci(), pointPerGrade);  // 1학년
			sciUnit[0] = first.getSciUnit();
			sci[1] = pointPer(second.getSci(), pointPerGrade);  // 2학년
			sciUnit[1] = second.getSciUnit();
			sci[2] = pointPer(third.getSci(), pointPerGrade); // 3학년
			sciUnit[2] = third.getSciUnit();
		}
		if(reflectionSubjects.matches(".*기.*")){
			etc[0] = pointPer(first.getEtc(), pointPerGrade);  // 1학년
			etcUnit[0] = first.getEtcUnit();
			etc[1] = pointPer(second.getEtc(), pointPerGrade);  // 2학년
			etcUnit[1] = second.getEtcUnit();
			etc[2] = pointPer(third.getEtc(), pointPerGrade); // 3학년
			etcUnit[2] = third.getEtcUnit();
		}
		// 수시 진단 결과 resultScore
		double resultScore = 0.0 ;
			//각 학년별 (반영 교과목 이수단위*학년반영비율*반영교과목 석차등급별 배점)/반영교과목 이수단위 합
			resultScore =
			//1학년
			(((korUnit[0]*gradeReflectionRate[0]*kor[0]) +
			(engUnit[0]*gradeReflectionRate[0]*eng[0]) +
			(mathUnit[0]*gradeReflectionRate[0]*math[0]) +
			(solUnit[0]*gradeReflectionRate[0]*sol[0]) +
			(sciUnit[0]*gradeReflectionRate[0]*sci[0]) +
			(etcUnit[0]*gradeReflectionRate[0]*etc[0])) +
			//더하기 2학년
			((korUnit[1]*gradeReflectionRate[1]*kor[1]) +
			(engUnit[1]*gradeReflectionRate[1]*eng[1]) +
			(mathUnit[1]*gradeReflectionRate[1]*math[1]) +
			(solUnit[1]*gradeReflectionRate[1]*sol[1]) +
			(sciUnit[1]*gradeReflectionRate[1]*sci[1]) +
			(etcUnit[1]*gradeReflectionRate[1]*etc[1])) +
			//더하기 3학년
			((korUnit[2]*gradeReflectionRate[2]*kor[2]) +
			(engUnit[2]*gradeReflectionRate[2]*eng[2]) +
			(mathUnit[2]*gradeReflectionRate[2]*math[2]) +
			(solUnit[2]*gradeReflectionRate[2]*sol[2]) +
			(sciUnit[2]*gradeReflectionRate[2]*sci[2]) +
			(etcUnit[2]*gradeReflectionRate[2]*etc[2]))) /
			// 나누기 반영교과목 이수단위 합
			((korUnit[0]+engUnit[0]+mathUnit[0]+solUnit[0]+sciUnit[0]+etcUnit[0]) +
			(korUnit[1]+engUnit[1]+mathUnit[1]+solUnit[1]+sciUnit[1]+etcUnit[1]) +
			(korUnit[2]+engUnit[2]+mathUnit[2]+solUnit[2]+sciUnit[2]+etcUnit[2])); 
		//if(uniName.equals("국민대학교")||uniName.equals("한양대학교")){

		//	System.out.println("resultScore: "+resultScore);
		//if(uniName.equals("국민대학교")||uniName.equals("한양대학교")){
			//github.com/minusto/koSchool.git
			//전체점수 곱하기 10
			resultScore = resultScore * 10;
		//}
		//}
	
		return resultScore;
	}
	
	//각 등급별 배점
	public double pointPer(double rate, double[] pointPerGrade){
		if((rate>=1)&&(rate<2)){
			return pointPerGrade[0];
		}else if((rate>=2)&&(rate<3)){
			return pointPerGrade[1];
		}else if((rate>=3)&&(rate<4)){
			return pointPerGrade[2];
		}else if((rate>=4)&&(rate<5)){
			return pointPerGrade[3];
		}else if((rate>=5)&&(rate<6)){
			return pointPerGrade[4];
		}else if((rate>=6)&&(rate<7)){
			return pointPerGrade[5];
		}else if((rate>=7)&&(rate<8)){
			return pointPerGrade[6];
		}else if((rate>=8)&&(rate<9)){
			return pointPerGrade[7];
		}else {
			return pointPerGrade[8];
		}
		
	}

	@Override
	public List<SusiInfoVO> selectLocationList(Map<String, String> map) throws Exception {
		return dao.selectLocationList(map);
	}

	@Override
	public double getResultAver(SusiRatingDTO first, SusiRatingDTO second, SusiRatingDTO third,
			double[] gradeReflectionRate, String reflectionSubjects) {
		double kor[] = new double[3];
		int korUnit[] = new int[3];
		double eng[] = new double[3];
		int engUnit[] = new int[3];
		double math[] = new double[3];
		int mathUnit[] = new int[3];
		double sol[] = new double[3];
		int solUnit[] = new int[3];
		double sci[] = new double[3];
		int sciUnit[] = new int[3];
		double etc[] = new double[3];
		int etcUnit[] = new int[3];
		if(reflectionSubjects.matches(".*국.*")) { // 반영 과목 검사
			kor[0] = first.getKor(); // 1학년
			korUnit[0] = first.getKorUnit();
			kor[1] = second.getKor(); // 2학년
			korUnit[1] = second.getKorUnit();
			kor[2] = third.getKor();// 3학년
			korUnit[2] = third.getKorUnit();
		}
		if(reflectionSubjects.matches(".*영.*")){
			eng[0] = first.getEng();  // 1학년
			engUnit[0] = first.getEngUnit();
			eng[1] = second.getEng(); // 2학년
			engUnit[1] = second.getEngUnit();
			eng[2] = third.getEng();// 3학년
			engUnit[2] = third.getEngUnit();
		}
		if(reflectionSubjects.matches(".*수.*")){
			math[0] = first.getMath();// 1학년
			mathUnit[0] = first.getMathUnit();
			math[1] = second.getMath();  // 2학년
			mathUnit[1] = second.getMathUnit();
			math[2] = third.getMath(); // 3학년
			mathUnit[2] = third.getMathUnit();
		}
		if(reflectionSubjects.matches(".*사.*")){
			sol[0] = first.getSol();  // 1학년
			solUnit[0] = first.getSolUnit();
			sol[1] = second.getSol(); // 2학년
			solUnit[1] = second.getSolUnit();
			sol[2] = third.getSol(); // 3학년
			solUnit[2] = third.getSolUnit();
		}
		if(reflectionSubjects.matches(".*과.*")){
			sci[0] = first.getSci();  // 1학년
			sciUnit[0] = first.getSciUnit();
			sci[1] = second.getSci();// 2학년
			sciUnit[1] = second.getSciUnit();
			sci[2] = third.getSci(); // 3학년
			sciUnit[2] = third.getSciUnit();
		}
		if(reflectionSubjects.matches(".*기.*")){
			etc[0] = first.getEtc(); // 1학년
			etcUnit[0] = first.getEtcUnit();
			etc[1] = second.getEtc(); // 2학년
			etcUnit[1] = second.getEtcUnit();
			etc[2] = third.getEtc(); // 3학년
			etcUnit[2] = third.getEtcUnit();
		}
		// 수시 진단 결과 resultScore
		double resultAver = 0.0 ;
			//각 학년별 (반영 교과목 이수단위*학년반영비율*반영교과목 석차등급별 배점)/반영교과목 이수단위 합
		resultAver =
				// 1학년
				(
						((korUnit[0] * kor[0]) + (engUnit[0] * eng[0]) + (mathUnit[0] * math[0]) + (solUnit[0] * sol[0])
						+ (sciUnit[0] * sci[0]) + (etcUnit[0] * etc[0])) +
				// 더하기 2학년
						((korUnit[1] * kor[1]) + (engUnit[1] * eng[1]) + (mathUnit[1] * math[1]) + (solUnit[1] * sol[1])
								+ (sciUnit[1] * sci[1]) + (etcUnit[1] * etc[1]))
						+
						// 더하기 3학년
						((korUnit[2] * kor[2]) + (engUnit[2] * eng[2]) + (mathUnit[2] * math[2]) + (solUnit[2] * sol[2])
								+ (sciUnit[2] * sci[2]) + (etcUnit[2] * etc[2]))
				)
				/
				// 나누기 반영교과목 이수단위 합
				(
						(korUnit[0] + engUnit[0] + mathUnit[0] + solUnit[0] + sciUnit[0] + etcUnit[0])
								+ (korUnit[1] + engUnit[1] + mathUnit[1] + solUnit[1] + sciUnit[1] + etcUnit[1])
								+ (korUnit[2] + engUnit[2] + mathUnit[2] + solUnit[2] + sciUnit[2] + etcUnit[2])
				);
			
			return resultAver;
	}

	@Override
	public List<SusiInfoVO> selectLocationList2(Map<String, String> map) throws Exception {
		return dao.selectLocationList2(map);
	}

	@Override
	public List<SusiInfoVO> searchUniName(Map<String, String> map) throws Exception {
		return dao.searchUniName(map);
	}

	@Override
	public SusiInfoVO susiUniversityDetail(Map<String, String> map) throws Exception {
		return dao.susiUniversityDetail(map);
	}

	@Override
	public SusiDetailDTO susiDetailDTO(Map<String, String> map) throws Exception {
		return dao.susiDetailDTO(map);
	}
	//수시 추천대학
	@Override
	public List<SusiInfoVO> susiRecomList(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return dao.susiRecomList(map);
	}
	
	

}
