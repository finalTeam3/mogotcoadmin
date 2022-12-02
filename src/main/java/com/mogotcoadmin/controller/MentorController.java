package com.mogotcoadmin.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotcoadmin.dto.MentorDTO;
import com.mogotcoadmin.dto.UserDTO;
import com.mogotcoadmin.service.MentorService;
import com.mogotcoadmin.service.UserService;



@Controller
@RequestMapping("/mentor")
public class MentorController {
	
	String dir = "mentor/";
	
	@Autowired
	MentorService service;
	
	@Autowired
	UserService service1;

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
			mdto = new MentorDTO(mtdto.getMentorid(), mtdto.getUserid(), mentor.getAdminid(), mtdto.getMentorcom(), mtdto.getMentorcon(), mtdto.getMentorimg(), mtdto.getMcardimg(), 1, mtdto.getMentordate(), 3, mtdto.getMentorcareer(), mtdto.getMentorapply(), mtdto.getMcardposition(), mtdto.getMpimg(), mtdto.getMcimg(), mtdto.getMentoring_mentoringid(), mtdto.getMentoring_mtitle(), mtdto.getMentoring_mentoringimg(), mtdto.getMentoring_mentoringdate(), mtdto.getMentoring_mplace(), mtdto.getUser_username());
			service.adminupdate(mdto);
			
			UserDTO before = null;
			UserDTO after = null;
			
			int beforepoint= 0;
			int afterpoint = 0;
			
			//mentor정보 불러옴
			before = service1.get(mtdto.getUserid());
			
			//point변화
			beforepoint = before.getUserpoint();
			afterpoint = beforepoint + 2000;
			
			//point수정
			after = new UserDTO(before.getUserid(), before.getUserpwd(), before.getUsername(), before.getUseraddr(), before.getUsertel(), before.getUseremail(), before.getUserdate(), before.getWithdraw(), before.getUserbirth(), afterpoint, before.getNaverid(), before.getKakaoid(), before.getGoogleid(), before.getUsergen(), before.getAddrnum(), before.getAddrdetail(), before.getAddrextra(), before.getSnsinsta(), before.getSnsgit(), 1);
			service1.modify(after);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:detail?mentorid=" + mentor.getMentorid();
	}
	
	@RequestMapping("/cancelimpl")
	public String cancelimpl(Model model, MentorDTO mentor) {
		MentorDTO mtdto = null;
		MentorDTO mdto = null;
		try {
			mtdto = service.get(mentor.getMentorid());
			mdto = new MentorDTO(mtdto.getMentorid(), mtdto.getUserid(), mentor.getAdminid(), mtdto.getMentorcom(), mtdto.getMentorcon(), mtdto.getMentorimg(), mtdto.getMcardimg(), 0, mentor.getMentordate(), 3, mtdto.getMentorcareer(), mtdto.getMentorapply(), mtdto.getMcardposition(), mtdto.getMpimg(), mtdto.getMcimg(), mtdto.getMentoring_mentoringid(), mtdto.getMentoring_mtitle(), mtdto.getMentoring_mentoringimg(), mtdto.getMentoring_mentoringdate(), mtdto.getMentoring_mplace(), mtdto.getUser_username());
			service.adminupdate(mdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:detail?mentorid=" + mentor.getMentorid();
	}

	
}
