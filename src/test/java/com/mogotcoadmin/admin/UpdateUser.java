package com.mogotcoadmin.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotcoadmin.dto.AdminDTO;
import com.mogotcoadmin.service.AdminService;

@SpringBootTest
class UpdateUser {
	
	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		
		AdminDTO admin = new AdminDTO("admin05", "05pwd", "박해적");
		
		try {
			service.modify(admin);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
