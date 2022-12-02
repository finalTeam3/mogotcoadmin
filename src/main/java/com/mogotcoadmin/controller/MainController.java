package com.mogotcoadmin.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotcoadmin.dto.AdminDTO;
import com.mogotcoadmin.service.AdminService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	AdminService service;
	
	@RequestMapping("")
	public String main() {
		return "main";
	}

	@RequestMapping("/loginimpl")
	public String loginimpl(HttpSession session, String adminid, String adminpwd) {
		AdminDTO adm = null;
		try {
			adm = service.get(adminid);
			if(adm != null) {
				if(adm.getAdminpwd().equals(adminpwd)) {
					session.setAttribute("loginadmin", adm);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	@RequestMapping("/register")
	public String register(Model model) {
		model.addAttribute("center", "register");
		return "main";
	}
	
	//회원가입기능
	@RequestMapping("/registerimpl")
	public String registerimpl(AdminDTO admin) {
		try {
			service.register(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
		
}
