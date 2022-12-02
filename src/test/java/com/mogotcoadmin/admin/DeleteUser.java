package com.mogotcoadmin.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotcoadmin.service.AdminService;

@SpringBootTest
class DeleteUser {
	
	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		
		try {
			service.remove("admin05");
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
