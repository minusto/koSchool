package ko.school.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ko.school.score.domain.SubjectScore;
import ko.school.score.persistence.NesinDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class NesinInsertTest {
	private static Logger logger = LoggerFactory.getLogger(NesinInsertTest.class);
	
	@Inject
	private NesinDao dao;
	
	@Test
	public void nesinInsert()throws Exception{
		SubjectScore subjectscore = new SubjectScore();
		subjectscore.setSubjectId("sub14");
        subjectscore.setMemberId("ST_01");
        subjectscore.setSemester(2);
        subjectscore.setNesinYear(2014);
        subjectscore.setMidExam("50");
        subjectscore.setFinalExam("50");
        subjectscore.setPerformanceEvaluation("50");
        dao.insertSubjectScore(subjectscore);
	}
}
