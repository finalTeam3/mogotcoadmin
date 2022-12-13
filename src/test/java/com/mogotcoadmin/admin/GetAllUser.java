package com.mogotcoadmin.admin;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotcoadmin.dto.AdminDTO;
import com.mogotcoadmin.service.AdminService;

@SpringBootTest
class GetAllUser {
	
	@Autowired
	AdminService service;
	
	@Test
	void contextLoads() {
		
		List<AdminDTO> list = null;
		try {
			list = service.get();
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(AdminDTO a:list) {
			System.out.println(a);
		}
	}
	
}
