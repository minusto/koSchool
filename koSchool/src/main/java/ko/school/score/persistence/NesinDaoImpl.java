package ko.school.score.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import ko.school.membermanage.domain.StudentDetail;
import ko.school.membermanage.domain.StudentList;
import ko.school.score.domain.AllRankingScoreList;
import ko.school.score.domain.AllStudentNum;
import ko.school.score.domain.AllSubjectScoreList;
import ko.school.score.domain.Subject;
import ko.school.score.domain.SubjectScore;

@Repository
public class NesinDaoImpl implements NesinDao {
	
	@Inject
	private SqlSession session;
	
	private static String namespace="ko.school.mapper.NesinMapper";

	@Override
	public List<Subject> subjectList() throws Exception {
		return session.selectList(namespace+".subjectList");
	}

	@Override
	public Subject selectSubject(String s_name) throws Exception {
		return session.selectOne(namespace+".selectSubject",s_name);
	}

	@Override
	public List<StudentList> studentList(String schoolId) throws Exception {
		return session.selectList(namespace+".studentList",schoolId);
	}

	@Override
	public void insertSubjectScore(SubjectScore subjectscore) throws Exception {
		session.insert(namespace+".insertSubjectScore", subjectscore);
	}

	@Override
	public List<AllSubjectScoreList> allSubjectScoreList(int semester) throws Exception {
		return session.selectList(namespace+".allSubjectScoreList", semester);
	}

	@Override
	public List<AllRankingScoreList> allRankingScoreList(int semester) throws Exception {
		return session.selectList(namespace+".allRankingScoreList", semester);
	}

	@Override
	public List<AllStudentNum> allStudentNum(int semester) throws Exception {
		return session.selectList(namespace+".allStudentNum", semester);
	}

	@Override
	public StudentDetail selectStudentDetail(String id) throws Exception {
		return session.selectOne(namespace+".selectStudentDetail", id);
	}

}
