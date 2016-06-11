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
import ko.school.simulation.domain.SusiRatingDTO;
import ko.school.simulation.domain.SusiSubjectDTO;
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

	// 1학기 Method
	public Map<String, Object> mainMethod(Map<String, Object> map) throws Exception {
		String id = (String) map.get("id");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 해당 학년 해당 학기 전과목 학교석차 불러옴
		List<AllRankingScoreList> rankList = dao.allRankingScoreList(map);
		// 해당 학생이 해당 학년 해당 학기때 수강한 subject ID와 TYPE
		List<SusiSubjectDTO> subjectList = dao.susiSubject(map);
		// 전체 과목별 전체명수
		List<AllStudentNum> numList = dao.allStudentNum(map);

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
		System.out.println("주요과목 구하기----------");
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
									cnt++; // 과목 개수
									System.out.println("sum= " + sum);
									System.out.println("cnt= " + cnt);
								}
							}
						}
					}
				}
				System.out.println(mainType[k]);
				System.out.println("mainSubject= " + sum);
				System.out.println("mainCnt=" + cnt);
				System.out.println();
				// 각 교과목의 등급과 개수를 map 담는다.
				resultMap.put(mainType[k], sum);
				resultMap.put(mainCnt[k], cnt);
				sum = 0;
				cnt = 0;
			} // for End
				// 해당하는 학생의 학교석차 구한 후 석차등급 변환 (비교과목)
			System.out.println("기타과목 구하기----------");
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
									System.out.println("sum= " + sum2);
									System.out.println("cnt= " + cnt2);
								}
							}
						}
					}
				}
			} // for End

			System.out.println("기타과목");
			System.out.println("subSubject= " + sum2);
			System.out.println("subCnt=" + cnt2);
			System.out.println();
			// 기타과목의 등급과 개수를 map 담는다.
			resultMap.put("기타", sum2);
			resultMap.put("기타개수", cnt2);
			sum2 = 0;
			cnt2 = 0;
		} else {
			for (int k = 0; k < mainType.length; k++) {
				resultMap.put(mainType[k], 0);
				resultMap.put(mainCnt[k], 0);
			}
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
			System.out.println("1학기==========================");
			resultMap = mainMethod(map);
			// 3학년 2학기
			map.put("id", id);
			map.put("semester", 2);
			map.put("nesinYear", 2016);
			System.out.println("2학기==========================");
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

			System.out.println("기타" + subject[5] + "기타개수" + cnt[5]);
			// 각 교과등급 평균 set
			for (int i = 0; i < subject.length; i++) {
				if (cnt[i] != 0) {
					if (i == 0) {
						r_dto.setKor(subject[0] / (double) cnt[0]);
					} else if (i == 1) {
						r_dto.setEng(subject[1] / (double) cnt[1]);
					} else if (i == 2) {
						r_dto.setMath(subject[2] / (double) cnt[2]);
					} else if (i == 3) {
						r_dto.setSol(subject[3] / (double) cnt[3]);
					} else if (i == 4) {
						r_dto.setSci(subject[4] / (double) cnt[4]);
					} else if (i == 5) {
						r_dto.setEtc(subject[5] / (double) cnt[5]);
					}
				}
			}
			System.out.println("결과값= " + r_dto.toString());
			
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

			System.out.println("기타" + subject[5] + "기타개수" + cnt[5]);
			// 각 교과등급 평균 set
			for (int i = 0; i < subject.length; i++) {
				if (cnt[i] != 0) {
					if (i == 0) {
						r_dto.setKor(subject[0] / (double) cnt[0]);
					} else if (i == 1) {
						r_dto.setEng(subject[1] / (double) cnt[1]);
					} else if (i == 2) {
						r_dto.setMath(subject[2] / (double) cnt[2]);
					} else if (i == 3) {
						r_dto.setSol(subject[3] / (double) cnt[3]);
					} else if (i == 4) {
						r_dto.setSci(subject[4] / (double) cnt[4]);
					} else if (i == 5) {
						r_dto.setEtc(subject[5] / (double) cnt[5]);
					}
				}
			}
			System.out.println("결과값= " + r_dto.toString());
		} else if (studentGrade == 3) {
			System.out.println("1학년 과목==========================");
			double subject[] = new double[6];
			int cnt[] = new int[6];
			// 3학년 1학기
			map.put("id", id);
			map.put("semester", 1);
			map.put("nesinYear", 2014);
			System.out.println("1학기==========================");
			resultMap = mainMethod(map);
			// 3학년 2학기
			map.put("id", id);
			map.put("semester", 2);
			map.put("nesinYear", 2014);
			System.out.println("2학기==========================");
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

			System.out.println("기타" + subject[5] + "기타개수" + cnt[5]);
			// 각 교과등급 평균 set
			for (int i = 0; i < subject.length; i++) {
				if (cnt[i] != 0) {
					if (i == 0) {
						r_dto.setKor(subject[0] / (double) cnt[0]);
					} else if (i == 1) {
						r_dto.setEng(subject[1] / (double) cnt[1]);
					} else if (i == 2) {
						r_dto.setMath(subject[2] / (double) cnt[2]);
					} else if (i == 3) {
						r_dto.setSol(subject[3] / (double) cnt[3]);
					} else if (i == 4) {
						r_dto.setSci(subject[4] / (double) cnt[4]);
					} else if (i == 5) {
						r_dto.setEtc(subject[5] / (double) cnt[5]);
					}
				}
			}
			System.out.println("결과값= " + r_dto.toString());
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

			System.out.println("기타" + subject[5] + "기타개수" + cnt[5]);
			// 각 교과등급 평균 set
			for (int i = 0; i < subject.length; i++) {
				if (cnt[i] != 0) {
					if (i == 0) {
						r_dto.setKor(subject[0] / (double) cnt[0]);
					} else if (i == 1) {
						r_dto.setEng(subject[1] / (double) cnt[1]);
					} else if (i == 2) {
						r_dto.setMath(subject[2] / (double) cnt[2]);
					} else if (i == 3) {
						r_dto.setSol(subject[3] / (double) cnt[3]);
					} else if (i == 4) {
						r_dto.setSci(subject[4] / (double) cnt[4]);
					} else if (i == 5) {
						r_dto.setEtc(subject[5] / (double) cnt[5]);
					}
				}
			}
			System.out.println("결과값= " + r_dto.toString());
		} else if (studentGrade == 3) {
			System.out.println("2학년 과목 시작==========================");
			double subject[] = new double[6];
			int cnt[] = new int[6];
			// 3학년 1학기
			map.put("id", id);
			map.put("semester", 1);
			map.put("nesinYear", 2015);
			System.out.println("1학기==========================");
			resultMap = mainMethod(map);
			// 3학년 2학기
			map.put("id", id);
			map.put("semester", 2);
			map.put("nesinYear", 2015);
			System.out.println("2학기==========================");
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

			System.out.println("기타" + subject[5] + "기타개수" + cnt[5]);
			// 각 교과등급 평균 set
			for (int i = 0; i < subject.length; i++) {
				if (cnt[i] != 0) {
					if (i == 0) {
						r_dto.setKor(subject[0] / (double) cnt[0]);
					} else if (i == 1) {
						r_dto.setEng(subject[1] / (double) cnt[1]);
					} else if (i == 2) {
						r_dto.setMath(subject[2] / (double) cnt[2]);
					} else if (i == 3) {
						r_dto.setSol(subject[3] / (double) cnt[3]);
					} else if (i == 4) {
						r_dto.setSci(subject[4] / (double) cnt[4]);
					} else if (i == 5) {
						r_dto.setEtc(subject[5] / (double) cnt[5]);
					}
				}
			}
			System.out.println("결과값= " + r_dto.toString());
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

			System.out.println("기타" + subject[5] + "기타개수" + cnt[5]);
			// 각 교과등급 평균 set
			for (int i = 0; i < subject.length; i++) {
				if (cnt[i] != 0) {
					if (i == 0) {
						r_dto.setKor(subject[0] / (double) cnt[0]);
					} else if (i == 1) {
						r_dto.setEng(subject[1] / (double) cnt[1]);
					} else if (i == 2) {
						r_dto.setMath(subject[2] / (double) cnt[2]);
					} else if (i == 3) {
						r_dto.setSol(subject[3] / (double) cnt[3]);
					} else if (i == 4) {
						r_dto.setSci(subject[4] / (double) cnt[4]);
					} else if (i == 5) {
						r_dto.setEtc(subject[5] / (double) cnt[5]);
					}
				}
			}
			System.out.println("결과값= " + r_dto.toString());
		}
		return r_dto;
	}

}
