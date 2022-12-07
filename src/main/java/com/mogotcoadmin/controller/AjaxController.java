package com.mogotcoadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mogotcoadmin.dto.AdminDTO;
import com.mogotcoadmin.dto.BoardDTO;
import com.mogotcoadmin.service.AdminService;
import com.mogotcoadmin.service.BoardService;

@RestController
public class AjaxController {
	
	@Autowired
	AdminService admin_service;
	
	@Autowired
	BoardService board_service;
	
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
	
	@RequestMapping("/addboard")
	public Object addboard(String adminid, String boardtypemodal, String boardtitle, String boardcontent) {
		int boardtype = Integer.parseInt(boardtypemodal);
		BoardDTO board = new BoardDTO(0, adminid, null, boardtitle, boardcontent, boardtype);
		try {
			board_service.register(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
}