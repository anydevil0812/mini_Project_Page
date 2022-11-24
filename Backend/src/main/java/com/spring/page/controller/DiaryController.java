package com.spring.page.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.page.common.dto.PageRequestDTO;
import com.spring.page.common.dto.PageResultDTO;
import com.spring.page.dto.DiaryDTO;
import com.spring.page.service.DiaryService;
import com.spring.page.service.DiaryServiceImpl;

@RestController
public class DiaryController {	

	@Autowired
	DiaryServiceImpl diaryService;
	
	//1. Diary 번호로 조회
  @GetMapping("/diary/{diaryNo}") 
	public DiaryDTO getDiary(@PathVariable("diaryNo") Long diaryNo) {
		return diaryService.getDiary(diaryNo);
	}

	//2. Diary 목록 조회 - 페이징 처리 포함
	@GetMapping("/diary") 
	public PageResultDTO getDiaryList(@RequestParam int size, @RequestParam int page) {
		PageRequestDTO pageRequestDTO = new PageRequestDTO(page, size); //파라미터를 받아서 Service에 넘겨주기 위한 PageRequestDTO 생성
		return diaryService.getDiaryList(pageRequestDTO);
	}
}
