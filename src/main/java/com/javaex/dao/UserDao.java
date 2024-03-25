package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;//이때 my batis 있어야함!(application, pom) 

	public UserVo userSelectByIdPw(UserVo userVo) {
		System.out.println("UserDao.userSelectByIdPw()");
		
		System.out.println(userVo);
		
		UserVo authUser = sqlSession.selectOne("user.selectByIdPw", userVo);
		System.out.println(authUser);
		
		return authUser;
	}
}
