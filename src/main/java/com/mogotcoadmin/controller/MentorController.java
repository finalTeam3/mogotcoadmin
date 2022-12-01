package com.mogotcoadmin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotcoadmin.service.UserService;



@Controller
@RequestMapping("mentor")
public class MentorController {
	
	String dir = "mentor/";
	
	@Autowired

	@RequestMapping("")
	public String main() {
		return "main";
	}
	

	
}
