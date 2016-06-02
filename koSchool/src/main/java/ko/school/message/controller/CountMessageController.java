package ko.school.message.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ko.school.common.domain.MemberVO;
import ko.school.message.domain.MessageCountDTO;
import ko.school.message.domain.MessageVO;
import ko.school.message.domain.NotReadMessage;
import ko.school.message.service.MessageService;

@RestController
public class CountMessageController {

	@Inject
	private MessageService service;

	// 모든 쪽지의 수를 가져오는 메소드 / 작성자 박종현
	@RequestMapping("/receiveCheckMessage")
	public MessageCountDTO receiveCheckMessage(HttpServletRequest request) {
		MessageCountDTO dto = new MessageCountDTO();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		dto.setCountMessage(service.countMessageService(member.getMemberId()));
		return dto;
	}

	// 미확인 쪽지의 수를 가져오는 메소드 / 작성자 박종현
	@RequestMapping("/notReadMessage")
	public NotReadMessage notReadMessage(HttpServletRequest request) {
		NotReadMessage dto = new NotReadMessage();
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		dto.setCountNotReadMessage(service.notReadMessageService(member.getMemberId()));
		return dto;
	}

	// 발신메시지를 불러오는 메소드 / 작성자 박종현
	@RequestMapping("/listSendMessage")
	public List<MessageVO> listSendMessage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		return service.listSendMessageService(member.getMemberId());
	}

	// 수신메시지를 불러오는 메소드 / 작성자 박종현
	@RequestMapping("/listReceiveMessage")
	public List<MessageVO> listReceiveMessage(HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		return service.listReceiveMessageService(member.getMemberId());
	}

	// 메시지 발송 ajax처리 / 작성자 박종현
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public ResponseEntity<String> sendMessage(@RequestBody MessageVO message, HttpServletRequest request) {
		ResponseEntity<String> entity = null;
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("member");
		message.setSenderMemberId(member.getMemberId());		
		try {
			service.sendMessageSevice(message);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}		
		return entity;
	}
	
	// 보낸쪽지 디테일 메소드 (미확인->확인 상태 변경포함) / 작성자 박종현
	@RequestMapping("sendMessageRead")
	public MessageVO sendMessageRead(@RequestParam("messageNum") int messageNum){
		//service.changeReadCheckService(messageNum); //확인 상태로 변경
		return service.sendMessageReadService(messageNum);
	}
	
	// 받은쪽지 디테일 메소드 (미확인->확인 상태 변경포함) / 작성자 박종현
	@RequestMapping("receiveMessageRead")
	public MessageVO receiveMessageRead(@RequestParam("messageNum") int messageNum){
		service.changeReadCheckService(messageNum); //확인 상태로 변경
		return service.sendMessageReadService(messageNum);
	}
}