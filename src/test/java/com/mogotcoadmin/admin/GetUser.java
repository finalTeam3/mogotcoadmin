package com.mogotcoadmin.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotcoadmin.dto.AdminDTO;
import com.mogotcoadmin.service.AdminService;

@SpringBootTest
class GetUser {
	
	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		
		AdminDTO admin = null;
		try {
			admin = service.get("admin05");
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(admin);
		
	}
	
}
