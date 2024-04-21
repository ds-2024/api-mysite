package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.BoardService;
import com.javaex.util.JsonResult;
import com.javaex.vo.BoardVo;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class BoardController {

	@Autowired
	private BoardService boardService;

	// 등록폼
	@PostMapping("/api/board/write")
	public JsonResult writeBoard(@RequestBody BoardVo boardVo, HttpServletResponse response) {
		System.out.println("BoardController.writeBoard()");

		int count = boardService.exeWrite(boardVo);

		if (count > 0) {
			return JsonResult.success("게시글이 성공적으로 등록되었습니다.");
		} else {
			return JsonResult.fail("게시글 등록에 실패했습니다.");
		}
	}

	// 삭제
	@DeleteMapping(value="/api/board/{no}")
		public String remove(@RequestBody BoardVo boardVo,
							 @PathVariable(value="no") int no) {
			System.out.println("BoardController.remove()");
			
			boardVo.setNo(no);
			System.out.println(boardVo);
			
			int count = boardService.exeRemove(boardVo);
			
			String result ="{\"count\": "+ count +"}";
			System.out.println(result);
			return result;
	}

}
