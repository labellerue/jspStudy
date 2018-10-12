package kr.or.ddit.user;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.UserVo;

import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {

	private UserDaoInf userDao;
	private final String TEST_USER_ID = "test1";
	
	@Before
	public void setup(){
		userDao = new UserDao();
		deleteUserTest(TEST_USER_ID);
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
	
	@Test
	public void insertUserTest(){
		/***Given***/
		UserVo userVo = new UserVo();
		userVo.setUserId(TEST_USER_ID);
		userVo.setName("test1");
		userVo.setPass("test1");
		userVo.setAddr1("test1");
		userVo.setAddr2("test1");
		userVo.setZip("11111");
		String birth =  "2018-10-12";
		Date date= null;
		try {
			date = new SimpleDateFormat("yyyyy-MM-dd").parse(birth);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		userVo.setBirth(date);
		userVo.setEmail("test1");
		userVo.setTel("111111111");
		userVo.setProfile("");

		/***When***/
		int insertCnt = userDao.insertUser(userVo);
		System.out.println(insertCnt);
		
		/***Then***/
		assertEquals(1, insertCnt);
		
	}
	
	public void deleteUserTest(String testUserId){
		/***Given***/

		/***When***/
		int deleteCnt = userDao.deleteUser(testUserId);
		System.out.println(testUserId);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}

}









