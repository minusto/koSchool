package ko.school.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import ko.school.common.domain.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		String grade = (String) modelMap.get("grade");
		if (grade != null) {
			session.setAttribute("grade", grade);
			if (grade.equals("student") || grade.equals("teacher")) {
				session.setAttribute("member", (Object) modelMap.get("member"));
			} else if (grade.equals("parent")) {
				session.setAttribute("parent", (Object) modelMap.get("parent"));
			} else if (grade.equals("schoolAdmin")) {
				session.setAttribute("schoolAdmin", (Object) modelMap.get("schoolAdmin"));
			} else if (grade.equals("systemAdmin")) {
				session.setAttribute("systemAdmin", (Object) modelMap.get("systemAdmin"));
			}
		}
	}

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
