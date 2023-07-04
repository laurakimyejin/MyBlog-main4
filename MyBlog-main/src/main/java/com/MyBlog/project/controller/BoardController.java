package com.MyBlog.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.MyBlog.project.dto.BoardDto;
import com.MyBlog.project.model.Board;
import com.MyBlog.project.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BoardController {
	
	@Autowired
	private final BoardService boardService;

	/*데이터 목록 조회*/
	@GetMapping("/board/datalist")
	public String dataList(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Board> board = boardService.list(pageable);
		model.addAttribute("boards", board);
		return "category/datalist";
	}

	/*상세 조회*/
	@GetMapping("/board/{id}")
	public String detail (@PathVariable Long id, Model model) {
		BoardDto detail = boardService.details(id);
		model.addAttribute("board", detail);
		return "board/detail";
	}


}
