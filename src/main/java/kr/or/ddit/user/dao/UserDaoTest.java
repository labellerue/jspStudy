package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

import org.junit.Test;

public class UserDaoTest {

	@Test
	public void selectUserAllTest() {

		/***Given***/
		UserDao userDao = new UserDao();

		/***When***/
		List<UserVo> list = userDao.selectUserAll();
		System.out.println(list);
		
		/***Then***/
		assertEquals(5, list.size());
	}
	
	@Test
	public void selectUserTest() {
		
		/***Given***/
		UserDao userDao = new UserDao();
		
		/***When***/
		UserVo userVo = userDao.selectUser("brown");
		System.out.println(userVo);
		
		/***Then***/
		assertNotNull(userVo);
		assertEquals("브라운", userVo.getName());
		assertEquals("brown", userVo.getUserId());
	}

	@Test
	public void selectUserTest2() {
		
		/***Given***/
		UserDao userDao = new UserDao();
		
		/***When***/
		UserVo userVo = userDao.selectUser(userDao.selectUser("brown"));
		System.out.println(userVo);
		
		/***Then***/
		assertNotNull(userVo);
		assertEquals("브라운", userVo.getName());
		assertEquals("brown", userVo.getUserId());
	}
	
	

}









