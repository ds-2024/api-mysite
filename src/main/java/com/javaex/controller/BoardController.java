package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.BoardService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpServletRequest;
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
	
	//수정시킬 데이터 가져오기(해당 회원 1명 정보 가져오기)
	@GetMapping("/api/board/modify")
	public JsonResult modifyform(HttpServletRequest request) {
		System.out.println("UserController.modifyform()");
		
		/*
		//토큰내놔
		String token = JwtUtil.getTokenByHeader(request);
		System.out.println("token=" + token);
		
		//검증
		boolean check = JwtUtil.checkToken(token);
		System.out.println(check);
		
		//이상없음			-->이상있음
		if(check == true) {
			System.out.println("정상");
			int no = Integer.parseInt(JwtUtil.getSubjectFromToken(token));
			System.out.println(no);
			
		}
		*/
		int no = JwtUtil.getNoFromHeader(request);
		//no값 추출

		
		if(no != -1) {
			//정상
			BoardVo boardVo = boardService.exeModifyForm(no);
			System.out.println(boardVo);
	
			return JsonResult.success(boardVo);
		}else {
			//토큰이 없거나(로그인상태아님), 변조된 경우
			return JsonResult.fail("토큰X, 로그인실패, 변조");
		}
	}
	

}
