package com.mogotcoadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mogotcoadmin.dto.AdminDTO;
import com.mogotcoadmin.service.AdminService;

@RestController
public class AjaxController {
	
	@Autowired
	AdminService admin_service;
	
	//회원가입시 아이디 중복체크 기능
	@RequestMapping("/checkid")
	public Object checkid(String cid) {
		String result = "";
		AdminDTO admin = null;
		try {
			admin = admin_service.get(cid);
			if(admin != null) {
				result = "f";
			} else {
				result = "t";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
}