package com.mogotcoadmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mogotcoadmin.dto.BoardDTO;
import com.mogotcoadmin.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	String dir = "board/";
	
	@Autowired
	BoardService board_service;
	
	@RequestMapping("/boardregister")
	public String boardregister(Model model) {
		List<BoardDTO> list = null;
		try {
			list = board_service.get();
			model.addAttribute("center", dir + "boardregister");
			model.addAttribute("boardlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/boardtype")
	public String boardtype(Model model, int boardtype) {
		List<BoardDTO> list = null;
		try {
			if (boardtype == 3) {
				list = board_service.get();
			} else {
				list = board_service.selectboardtype(boardtype);
			}
			model.addAttribute("boardlist", list);
			model.addAttribute("center", dir + "boardregister");
		} catch (Exception e) {
		}
		return "main";
	}
	
	@RequestMapping("/boarddetail")
	public String boarddetail(Model model, int boardid) {
		BoardDTO board = null;
		try {
			board = board_service.get(boardid);
			model.addAttribute("board", board);
			model.addAttribute("center", dir + "boarddetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "main";
	}
	
	@RequestMapping("/deleteboard")
	public String deleteboard(Model model, int boardid) {
		try {
			board_service.remove(boardid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir + "boarddetail");
		return "redirect:/board/boardregister";
	}
	
}
