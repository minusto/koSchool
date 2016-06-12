package ko.school.simulation.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ko.school.simulation.domain.EntranceInfoVO;
import ko.school.simulation.domain.ExtraPointVO;
import ko.school.simulation.domain.MajorVO;
import ko.school.simulation.domain.ReflectionRatePerSATAreaVO;
import ko.school.simulation.domain.ReflectionRateVO;
import ko.school.simulation.domain.SATScoreVO;
import ko.school.simulation.domain.UniversityVO;
import ko.school.simulation.service.UniversityService;

@Controller
public class UniversityContorller {
	@Inject
	private UniversityService service;
	
	@RequestMapping(value="/universityManage",method=RequestMethod.GET)
	public String universityManageForm(Model model){
		//대학 LIST
		List<UniversityVO> universityList=service.universityListService();
		model.addAttribute("universityList", universityList);
		
		//학과 LIST
		List<MajorVO> majorList=service.majorListService();
		model.addAttribute("majorList", majorList);
		
		//가산점 LIST
		List<ExtraPointVO> extraPointList=service.extraPointList();
		model.addAttribute("extraPointList", extraPointList);
		
		//수능 영역별 반영비율 LIST
		List<ReflectionRatePerSATAreaVO> reflectionRatePerSATAreaList=service.reflectionRatePerSATAreaList();	
		model.addAttribute("rrsList", reflectionRatePerSATAreaList);
	
		//반영비율 LISt
		List<ReflectionRateVO> reflectionRateList=service.reflectionRateList();		
		model.addAttribute("reflectionRateList", reflectionRateList);
		
		return "/university/universityInsertForm";
	}
	@RequestMapping(value="/universityManage",method=RequestMethod.POST)
	public String universityInsert(Model model,ReflectionRateVO reflectRateVO,ReflectionRatePerSATAreaVO rrp,ExtraPointVO extraPointVO
			,EntranceInfoVO entranceInfoVO,SATScoreVO satScoreVO){
					
		//가산점 LIST
		List<ExtraPointVO> extraPointList=service.extraPointList();
		model.addAttribute("extraPointList", extraPointList);
		//수능 영역별 반영비율 LIST
		List<ReflectionRatePerSATAreaVO> reflectionRatePerSATAreaList=service.reflectionRatePerSATAreaList();	
		model.addAttribute("rrsList", reflectionRatePerSATAreaList);
		//반영비율 LISt
		List<ReflectionRateVO> reflectionRateList=service.reflectionRateList();		
		model.addAttribute("reflectionRateList", reflectionRateList);
		//대학 LIST
		List<UniversityVO> list=service.universityListService();
		model.addAttribute("universityList", list);
		//학과 LIST
		List<MajorVO> majorList=service.majorListService();
		model.addAttribute("majorList", majorList);
		
		//이미 등록된 반영비율을 선택했다면 insert시키지 않는다
		int count=0;
		for(int i=0;i<reflectionRateList.size();i++){
			if((reflectionRateList.get(i).getReflectionRateId().equals(reflectRateVO.getReflectionRateId()))){
				count++;
			}
		}
		if(count==0){
			//반영비율 Insert
			service.insertReflectionRate(reflectRateVO);
		}
		count=0;
		
		//이미 등록된 영역별 반영비율을 선택했다면 insert시키지 않는다.
		for(int i=0;i<reflectionRatePerSATAreaList.size();i++){
			//파라미터로 넘어온 id값과 list의 id값이 일치하는 것이 없다면 insert시킨다.
			if((reflectionRatePerSATAreaList.get(i).getSatReflectionRateId().equals(rrp.getSatReflectionRateId()))){
				count++;
			}
		}
		if(count==0){
			//수능 영역별 반영비율 INSERT
			service.insertReflectionRatePerSATArea(rrp);			
		}
		count=0;
		//이미 등록된 가산점 비율을 선택했다면 insert시키지 않는다.
		for(int i=0;i<extraPointList.size();i++){
			if((extraPointList.get(i).getExtraPointId().equals(extraPointVO.getExtraPointId()))){
				count++;
			}
		}
		if(count==0){
			//가산점 INSERT
			service.insertExtraPoint(extraPointVO);			
		}

		
		//대학학과별 입시정보 INSERT
		service.insertEntranceInfo(entranceInfoVO);
		
		//정시점수 INSERT
		service.insertSATScore(satScoreVO);
		

		

		return "/university/universityInsertForm";
	}
	
	
}
