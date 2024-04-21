package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//등록
	public int boardWriteContent(BoardVo boardVo) {
		System.out.println("BoardDao.boardWriteContent()");
		
		System.out.println(boardVo);
		
		int count = sqlSession.insert("board.insertContent", boardVo);
		
		return count;
	}
	// 삭제
		public int boardDelete(BoardVo boardVo) {
			System.out.println("BoardDao.boardDelete()");

			int count = sqlSession.delete("board.delete", boardVo);
			return count;
		}
	
	

}
