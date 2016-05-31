package ko.school.schoolmanage.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import ko.school.schoolmanage.domain.SchoolRegistVO;
import ko.school.schoolmanage.domain.SchoolVO;
import ko.school.schoolmanage.persistence.SchoolDAO;

@Service
public class SchoolServiceImpl implements SchoolService {
	
	@Inject
	private SchoolDAO dao;
	
	//액터 ==> 학교관리자 / 작업 내용 : 학교 등록, 학교 정보 입력 / 작성자 : 구혜인
	@Transactional
	@Override
	public void insertSchoolService(SchoolVO schoolVo, SchoolRegistVO schoolRegistVo) throws Exception {
		dao.insertSchool(schoolVo);
		dao.insertSchoolRegister(schoolRegistVo);
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 학교 관리자 아이디로 학교 정보 조회 / 작성자 : 구혜인
	@Override
	public SchoolVO detailSchoolService(String schoolAdminId) throws Exception {
		SchoolRegistVO schoolRegistVo = dao.schoolRegistSchoolId(schoolAdminId);
		if(schoolRegistVo == null) {
			//System.out.println("schoolRegistVo is null");
			return null;
		}
		return dao.schoolDetail(schoolRegistVo.getSchoolId());			
	}
	
	//액터 ==> 학교관리자 / 작업 내용 : 학교 정보 수정 / 작성자 : 구혜인
	@Override
	public void schoolUpdateService(SchoolVO schoolVo) throws Exception {
		dao.schoolUpdate(schoolVo);
	}

	
}
