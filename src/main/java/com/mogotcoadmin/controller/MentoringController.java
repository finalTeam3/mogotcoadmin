package com.mogotcoadmin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotcoadmin.dto.MentoringDTO;
import com.mogotcoadmin.service.MentoringService;



@Controller
@RequestMapping("/mentoring")
public class MentoringController {
	
	String dir = "mentoring/";
	
	@Autowired
	MentoringService service;
	
	@RequestMapping("/get")
	public String get(Model model) {
		List<MentoringDTO> mti = null;
		try {
			mti = service.get();
			model.addAttribute("mti", mti);
			model.addAttribute("center", dir+"get");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/detail")
	public String detail(Model model) {
		model.addAttribute("center", dir+"detail");
		return "main";
	}

	
}
