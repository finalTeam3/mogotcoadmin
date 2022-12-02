package com.mogotcoadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotcoadmin.dto.ReviewDTO;
import com.mogotcoadmin.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	String dir = "review/";
	
	@Autowired
	ReviewService service;
	
	//리뷰페이지
	@RequestMapping("/get")
	public String review(Model model) {
		List<ReviewDTO> rdto = null;
		try {
			rdto = service.get();
			model.addAttribute("rdto", rdto);
			model.addAttribute("center", dir+"get");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return "main";
	}
	
	
}
