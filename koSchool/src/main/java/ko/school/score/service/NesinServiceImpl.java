package ko.school.score.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ko.school.membermanage.domain.StudentDetail;
import ko.school.membermanage.domain.StudentList;
import ko.school.score.domain.AllRankingScoreList;
import ko.school.score.domain.AllStudentNum;
import ko.school.score.domain.AllSubjectScoreList;
import ko.school.score.domain.Subject;
import ko.school.score.domain.SubjectScore;
import ko.school.score.persistence.NesinDao;

@Service
public class NesinServiceImpl implements NesinService {
	
	@Inject
	private NesinDao dao;
	
	@Override
	public List<Subject> subjectList() throws Exception {
		return dao.subjectList();
	}

	@Override
	public Subject selectSubject(String s_name) throws Exception {
		return dao.selectSubject(s_name);
	}

	@Override
	public List<StudentList> studentList(String schoolId) throws Exception {
		return dao.studentList(schoolId);
	}

	@Override
	public void insertSubjectScore(SubjectScore subjectscore) throws Exception {
    	for (int i = 0; i < subjectscore.getArrMidExam().length; i++) {
            subjectscore.setSubjectId(subjectscore.getArrSubjectId()[i]);
            subjectscore.setMemberId(subjectscore.getMemberId());
            subjectscore.setSemester(subjectscore.getSemester());
            subjectscore.setMidExam(subjectscore.getArrMidExam()[i]);
            subjectscore.setFinalExam(subjectscore.getArrFinalExam()[i]);
            subjectscore.setPerformanceEvaluation(subjectscore.getArrPerformanceEvaluation()[i]);
            dao.insertSubjectScore(subjectscore);
         }
	}

	@Override
	public List<AllSubjectScoreList> allSubjectScoreList(int semester) throws Exception {
		return dao.allSubjectScoreList(semester);
	}

	@Override
	public List<AllRankingScoreList> allRankingScoreList(int semester) throws Exception {
		return dao.allRankingScoreList(semester);
	}

	@Override
	public List<AllStudentNum> allStudentNum(int semester) throws Exception {
		return dao.allStudentNum(semester);
	}

	@Override
	public StudentDetail selectStudentDetail(String id) throws Exception {
		return dao.selectStudentDetail(id);
	}

}
