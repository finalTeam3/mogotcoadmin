package com.mogotcoadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotcoadmin.dto.UserDTO;
import com.mogotcoadmin.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	String dir = "user/";
	
	@Autowired
	UserService service;
	
	@RequestMapping("/get")
	public String get(Model model) {
		List<UserDTO> user = null;
		try {
			user = service.get();
			model.addAttribute("user",user);
			model.addAttribute("center", dir+"get");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "main";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model, String userid) {
		UserDTO user = null;
		try {
			user = service.get(userid);
			model.addAttribute("user",user);
			model.addAttribute("center", dir+"detail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "main";
	}
	
	
	
	
}
