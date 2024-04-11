package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;

	//등록폼
	public int exeWrite(BoardVo boardVo) {
		System.out.println("BoardService.exeWrite()");
		
		int count = boardDao.boardWriteContent(boardVo);
		return count;
	}
}
