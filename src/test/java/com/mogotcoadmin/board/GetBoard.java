package com.mogotcoadmin.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotcoadmin.dto.BoardDTO;
import com.mogotcoadmin.service.BoardService;

@SpringBootTest
class GetBoard {
	
	@Autowired
	BoardService service;
	
	@Test
	void contextLoads() {
		
		BoardDTO board = null;
		try {
			board = service.get(801);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(board);
		
	}
	
}
