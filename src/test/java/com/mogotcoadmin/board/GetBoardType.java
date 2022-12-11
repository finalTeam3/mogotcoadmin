package com.mogotcoadmin.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mogotcoadmin.dto.BoardDTO;
import com.mogotcoadmin.service.BoardService;

@SpringBootTest
class GetBoardType {
	
	@Autowired
	BoardService service;
	
	@Test
	void contextLoads() {
		
		List<BoardDTO> list = null;
		try {
			list = service.selectboardtype(2);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(BoardDTO b:list) {
			System.out.println(b);
		}
	}
}
