package com.spring.page.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.page.common.dto.PageRequestDTO;
import com.spring.page.dto.DiaryDTO;

@RestController
public class DiaryController {
  @GetMapping("/diary/{diaryNo}") 
	public DiaryDTO getDiary(@PathVariable("diaryNo") Long diaryNo) {
		return diaryService.getDiary(diaryNo);
	}

	@GetMapping("/diary") //method for getting diary list
	public PageResultDTO getDiaryList(@RequestParam("size") int size, @RequestParam("page") int page) {
		PageRequestDTO pageRequestDTO = new PageRequestDTO(page, size); //파라미터를 받아서 Service에 넘겨주기 위한 PageRequestDTO 생성
		return diaryService.getDiaryList(pageRequestDTO);
	}
}
