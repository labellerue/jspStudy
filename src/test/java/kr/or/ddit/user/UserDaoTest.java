package kr.or.ddit.user;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVo;

import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {

	private UserDaoInf userDao;
	
	@Before
	public void setup(){
		userDao = new UserDao();
	}
	
	@Test
	public void selectUserAllTest() {

		/***Given***/

		/***When***/
		List<UserVo> list = userDao.selectUserAll();
		System.out.println(list);
		
		/***Then***/
		assertEquals(105, list.size());
	}
	
	@Test
	public void selectUserTest() {
		
		/***Given***/
		
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
	
	
	/**
	* Method : getUserCntTest
	* 작성자 : sohyoung
	* 변경이력 :
	* Method 설명 : 사용자 전체 건수 조회 테스트
	*/
	@Test
	public void getUserCntTest() {
	
		/***Given***/
		
		/***When***/
		int totalUserCnt = userDao.getUserCnt();
		
		/***Then***/
		assertEquals(105, totalUserCnt);
	}

}









