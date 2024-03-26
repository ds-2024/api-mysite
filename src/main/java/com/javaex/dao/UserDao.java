package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;// 이때 my batis 있어야함!(application, pom)

	// id,pw로 한명데이터 가져오기(로그인)
	public UserVo userSelectByIdPw(UserVo userVo) {
		System.out.println("UserDao.userSelectByIdPw()");

		System.out.println(userVo);

		UserVo authUser = sqlSession.selectOne("user.selectByIdPw", userVo);
		System.out.println(authUser);

		return authUser;
	}

	// no로 한명데이터 가져오기(회원정보수정 폼)
	public UserVo userSelectOneByNo(int no) {

		System.out.println("UserDao.userSelectOneByNo()");

		UserVo userVo = sqlSession.selectOne("user.selectOneByNo", no);
		return userVo;
	}
	
	//회원정보수정
	public int userUpdate(UserVo userVo) {
		
		System.out.println("UserDao.userUpdate()");
		int count = sqlSession.update("user.update", userVo);
		
		return count;
	}

}
