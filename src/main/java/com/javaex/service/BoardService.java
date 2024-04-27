package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;

	// 등록폼
	public int exeWrite(BoardVo boardVo) {
		System.out.println("BoardService.exeWrite()");

		int count = boardDao.boardWriteContent(boardVo);
		return count;
	}

	// 삭제
	public int exeRemove(BoardVo boardVo) {
		System.out.println("BoardService.exeRemove()");

		int count = boardDao.boardDelete(boardVo);
		return count;
	}
	
	//수정시킬 회원 1명 정보 가져오기
	public BoardVo exeModifyForm(int no) {
		System.out.println("BoardService.exeModifyForm()");

		BoardVo boardVo = boardDao.boardSelectOneByNo(no);
		return boardVo;
	}
}
