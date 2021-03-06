package ko.school.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ko.school.board.service.ClassBoardService;
import ko.school.common.domain.MemberVO;
import ko.school.common.domain.ParentVO;
import ko.school.common.domain.StudentVO;
import ko.school.common.domain.TeacherVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	
	@Inject
	private ClassBoardService service;
	
	//액터 ==> 모든사용자  / 작업내용 : 로그인시 세션 생성 / 작성자 : 이재승
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		String grade = (String) modelMap.get("grade");
		if (grade != null) {
			session.setAttribute("grade", grade);
			if (grade.equals("student") || grade.equals("teacher")||grade.equals("parent")) {
				session.setAttribute("member", (Object) modelMap.get("member"));
				   if((TeacherVO)modelMap.get("teacher")!=null){
		               session.setAttribute("teacher", (TeacherVO)modelMap.get("teacher"));
		            }else if((StudentVO)modelMap.get("student")!=null){
		               session.setAttribute("student", (StudentVO)modelMap.get("student"));
		            } else if ((ParentVO)modelMap.get("parent")!=null) {
						session.setAttribute("parent", (Object) modelMap.get("parent"));
					}
			} else if (grade.equals("schoolAdmin")) {
				session.setAttribute("schoolAdmin", (Object) modelMap.get("schoolAdmin"));
			} else if (grade.equals("systemAdmin")) {
				session.setAttribute("systemAdmin", (Object) modelMap.get("systemAdmin"));
			}
			
			//teacherClass (학년, 반) 세션 담기 작성자 : 이용갑
			try {
				Map<String, Object> paramMap = new HashMap<String, Object>();
				
				if ("parent".equals(session.getAttribute("grade").toString())) {
					paramMap.put("memberId", ((ParentVO) session.getAttribute("parent")).getMemberId());
				} else {
					paramMap.put("memberId", ((MemberVO) session.getAttribute("member")).getMemberId());					
				}
				paramMap.put("grade", session.getAttribute("grade").toString());
				
				session.setAttribute("teacherClass", service.teacherClass(paramMap));				
			} catch (Exception e) {
				return;
			}
			
		}
	}
	//액터 ==> 모든사용자  / 작업내용 : 메인페이지 접근시 세션이 존재하면 액터에 맞는 Main페이지로 보냄 / 작성자 : 이재승
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("grade") != null) {
			if (session.getAttribute("grade").equals("student") && session.getAttribute("member") != null) {
				response.sendRedirect("/studentMain");
				return false;
			} else if (session.getAttribute("grade").equals("parent") && session.getAttribute("parent") != null) {
				response.sendRedirect("/parentMain");
				return false;
			} else if (session.getAttribute("grade").equals("teacher") && session.getAttribute("member") != null) {
				response.sendRedirect("/teacherMain");
				return false;
			} else if (session.getAttribute("grade").equals("schoolAdmin") && session.getAttribute("schoolAdmin") != null) {
				response.sendRedirect("/schoolAdminMain");
				return false;
			} else if (session.getAttribute("grade").equals("systemAdmin") && session.getAttribute("systemAdmin") != null) {
				response.sendRedirect("/systemAdminMain");
				return false;
			}
		}
		return true;
	}
}
