package com.mogotcoadmin.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotcoadmin.dto.MentorDTO;
import com.mogotcoadmin.service.MentorService;



@Controller
@RequestMapping("/mentor")
public class MentorController {
	
	String dir = "mentor/";
	
	@Autowired
	MentorService service;

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
	
	@RequestMapping("/qualify")
	public String qualify(Model model, MentorDTO mentor, HttpServletRequest request) {
		System.out.println(mentor);
		MentorDTO mtdto = null;
		MentorDTO mdto = null;
		
		try {
			mtdto = service.get(mentor.getMentorid());
			System.out.println("멘토 승인"+mtdto);
			mdto = new MentorDTO(mtdto.getMentorid(), mtdto.getUserid(), mentor.getAdminid(), null, null, null, null, 1, null, 3, null, null, null, null, null, null, null,null,null,null,null);
			System.out.println(mdto);
			service.adminupdate(mdto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:detail?mentorid=" + mentor.getMentorid();
	}

	
}
