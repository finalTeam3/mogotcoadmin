package com.mogotcoadmin.controller;


import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mogotcoadmin.dto.CouponDTO;
import com.mogotcoadmin.dto.MentorDTO;
import com.mogotcoadmin.dto.UserCouponDTO;
import com.mogotcoadmin.dto.UserDTO;
import com.mogotcoadmin.service.CouponService;
import com.mogotcoadmin.service.MentorService;
import com.mogotcoadmin.service.UserCouponService;
import com.mogotcoadmin.service.UserService;



@Controller
@RequestMapping("/mentor")
public class MentorController {
	
	String dir = "mentor/";
	
	@Autowired
	MentorService service;
	
	@Autowired
	UserService service1;
	
	@Autowired
	CouponService cservice;
	
	@Autowired
	UserCouponService uservice;
	
	@Autowired
	JavaMailSender mailSender;

	@RequestMapping("/get")
	public String main(Model model) {
		List<MentorDTO> mentor = null;
		try {
			mentor = service.get();
			model.addAttribute("mentor", mentor);
			model.addAttribute("center", dir+"get");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model, int mentorid) {
		MentorDTO mentor = null;
		try {
			mentor = service.mentordetail(mentorid); 
			model.addAttribute("mentor",mentor);
			model.addAttribute("center", dir+"detail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/qualifyimpl")
	public String qualifyimpl(Model model, MentorDTO mentor) {
		MentorDTO mtdto = null;
		MentorDTO mdto = null;
		try {
			mtdto = service.get(mentor.getMentorid());
			mdto = new MentorDTO(mtdto.getMentorid(), mtdto.getUserid(), mentor.getAdminid(), mtdto.getMentorcom(), mtdto.getMentorcon(), mtdto.getMentorimg(), mtdto.getMcardimg(), 1, mtdto.getMentordate(), 3, mtdto.getMentorcareer(), mtdto.getMentorapply(), mtdto.getMcardposition(), mtdto.getMpimg(), mtdto.getMcimg(), mtdto.getMentoring_mentoringid(), mtdto.getMentoring_mtitle(), mtdto.getMentoring_mentoringimg(), mtdto.getMentoring_mentoringdate(), mtdto.getMentoring_mplace(), mtdto.getUser_username(), mtdto.getUser_useremail());
			service.adminupdate(mdto);
			
			//coupon지급
			UserCouponDTO userc = null;
			userc = new UserCouponDTO(0, mtdto.getUserid(), 2, null, 0);
			uservice.register(userc);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:detail?mentorid=" + mentor.getMentorid();
	}
	
	@RequestMapping("/emailsend")
	@ResponseBody
	public String emailsend(String email) throws Exception {
		
		// 메일 정보 세팅
		String setFrom = "mogotcomentoring@gmail.com";	// 보내는 이
		String toMail = email;	// 받는 이
		String title = "MOGOTCO 멘토 승인 결과 안내입니다."; 	// 메일 제목
		String content = "멘토가 된 것을 축하드립니다! 지금 멘토링을 등록해보세요~"; 	// 메일 내용
		
		// 단순 텍스트 메일 전송용
		MimeMessage msg = mailSender.createMimeMessage();
		MimeMessageHelper msgHelper = new MimeMessageHelper(msg, "UTF-8");
		
		// 메일 작성
		msgHelper.setFrom("상부3조 <mogotcomentoring@gmail.com>");
		msgHelper.setTo(toMail);
		msgHelper.setSubject(title);
		msgHelper.setText(content);
		
		// 메일 보내기
		mailSender.send(msg);
		
		return "main";
	}
	
	@RequestMapping("/cancelimpl")
	public String cancelimpl(Model model, MentorDTO mentor) {
		MentorDTO mtdto = null;
		MentorDTO mdto = null;
		try {
			mtdto = service.get(mentor.getMentorid());
			mdto = new MentorDTO(mtdto.getMentorid(), mtdto.getUserid(), mentor.getAdminid(), mtdto.getMentorcom(), mtdto.getMentorcon(), mtdto.getMentorimg(), mtdto.getMcardimg(), 0, mentor.getMentordate(), 3, mtdto.getMentorcareer(), mtdto.getMentorapply(), mtdto.getMcardposition(), mtdto.getMpimg(), mtdto.getMcimg(), mtdto.getMentoring_mentoringid(), mtdto.getMentoring_mtitle(), mtdto.getMentoring_mentoringimg(), mtdto.getMentoring_mentoringdate(), mtdto.getMentoring_mplace(), mtdto.getUser_username(), mtdto.getUser_useremail());
			service.adminupdate(mdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:detail?mentorid=" + mentor.getMentorid();
	}

	
}
