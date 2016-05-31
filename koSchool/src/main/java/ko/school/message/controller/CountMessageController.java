package ko.school.message.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ko.school.common.domain.MemberVO;
import ko.school.message.domain.MessageCountDTO;
import ko.school.message.domain.NotReadMessage;
import ko.school.message.service.MessageService;

@RestController
public class CountMessageController {

	@Inject
	private MessageService service;

	//모든 쪽지의 수를 가져오는 URL요청 / 작성자 박종현 
	@RequestMapping("/receiveCheckMessage") 
	public MessageCountDTO receiveCheckMessage(HttpServletRequest request) {
		MessageCountDTO dto = new MessageCountDTO();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		dto.setCountMessage(service.countMessageService(member.getMemberId()));
		return dto;
	}

	//미확인 쪽지의 수를 가져오는 URL요청 / 작성자 박종현
	@RequestMapping("/notReadMessage")
	public NotReadMessage notReadMessage(HttpServletRequest request) {
		NotReadMessage dto = new NotReadMessage();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		dto.setCountNotReadMessage(service.notReadMessageService(member.getMemberId()));
		return dto;
	}
}