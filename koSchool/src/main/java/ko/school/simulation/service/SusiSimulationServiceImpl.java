package ko.school.simulation.service;

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
	
	public int ratingMethod(int ranking, int allStudentNum){
		int rating = 0;
		System.out.println("ranking="+ranking);
		System.out.println("allStudentNum="+allStudentNum);
		double percent = 0.0;
		percent = (ranking/(double)allStudentNum)*100;
		System.out.println("percent="+percent);
		if((0<percent)&&(percent<=4)){
			rating = 1;
		}else if((4<percent)&&(percent<=11)){
			rating = 2;
		}else if((11<percent)&&(percent<=23)){
			rating = 3;
		}else if((23<percent)&&(percent<=40)){
			rating = 4;
		}else if((40<percent)&&(percent<=60)){
			rating = 5;
		}else if((60<percent)&&(percent<=77)){
			rating = 6;
		}else if((77<percent)&&(percent<=89)){
			rating = 7;
		}else if((89<percent)&&(percent<=96)){
			rating = 8;
		}else if((96<percent)&&(percent<=100)){
			rating = 9;
		}
		System.out.println(rating);
		return rating;
	}

	@Override
	public StudentVO studentCheck(String id) throws Exception {
		return dao.studentCheck(id);
	}

	@Override
	public SusiRatingDTO grade1Semester1(int studentGrade, String id) throws Exception {
		SusiRatingDTO r_dto = new SusiRatingDTO();
		double kor = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		if(studentGrade == 1){
			
		}else if(studentGrade ==2){
			
		}else if (studentGrade == 3) {
			map.put("id", id);
			map.put("semester", 1);
			map.put("nesinYear", 2016);
			// 1학년 1학기 전과목 학교석차 불러옴
			List<AllRankingScoreList> rankList = dao.allRankingScoreList(map);
			// 해당 학생이 1학년 1학기때 수강한 subject ID와 TYPE
			List<SusiSubjectDTO> subjectList = dao.susiSubject(map);
			// 전체 과목별 전체명수
			List<AllStudentNum> numList = dao.allStudentNum(map);
			int allStudentNum=0;
			for(int i=0; i<numList.size(); i++){
				if(numList.get(i).getSubjectId().equals(subjectList.get(0).getSubjectId())){
					allStudentNum = numList.get(i).getAllStudentNum();
				}
			}
			//해당하는 학생의 학교석차 구한 후 석차등급 변환
			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < subjectList.size(); i++) {
				if (subjectList.get(i).getSubjectType().equals("국어")) {
					for (int j = 0; j < rankList.size(); j++) {
						if (subjectList.get(i).getSubjectId().equals(rankList.get(j).getSubjectId())) {
							if (rankList.get(j).getMemberId().equals(id)) {
								sum = ratingMethod(rankList.get(j).getRank(), allStudentNum) + sum;
								cnt++;
							}
						}
					}
				}
			}
			kor = sum/(double)cnt;
			r_dto.setKor(kor);
		}
		System.out.println(r_dto.getKor());
		return r_dto;
	}

	@Override
	public SusiRatingDTO grade1Semester2(int studentGrade, String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SusiRatingDTO grade2Semester1(int studentGrade, String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SusiRatingDTO grade2Semester2(int studentGrade, String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SusiRatingDTO grade3Semester1(int studentGrade, String id) throws Exception {
		return null;
	}

	@Override
	public SusiRatingDTO grade3Semester2(int studentGrade, String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
