package com.mogotcoadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mogotcoadmin.dto.AdminDTO;
import com.mogotcoadmin.dto.BoardDTO;
import com.mogotcoadmin.mapper.AjaxMapper;
import com.mogotcoadmin.service.AdminService;
import com.mogotcoadmin.service.BoardService;

@RestController
public class AjaxController {
	
	@Autowired
	AdminService admin_service;
	
	@Autowired
	BoardService board_service;

	@Autowired
	AjaxMapper mapper;
	
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
	
	@RequestMapping("/usercnt")
	public String usercnt() {
		int cnt = mapper.getUserCnt();
		return cnt+"명";
	}
	@RequestMapping("/mentorcnt")
	public String mentorcnt() {
		int cnt = mapper.getMentorCnt();
		return cnt+"명";
	}
	@RequestMapping("/mentoringcnt")
	public String mentoringcnt() {
		int cnt = mapper.getMentoringCnt();
		return cnt+"명";
	}
	@RequestMapping("/purchaseprice")
	public String purchaseprice() {
		int price = mapper.getPurchasePrice();
		return price+"원";
	}
	
}