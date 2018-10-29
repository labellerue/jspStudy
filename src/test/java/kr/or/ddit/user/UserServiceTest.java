package kr.or.ddit.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.model.PageVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTest {

	private UserServiceInf userService;
	private final String TEST_USER_ID = "test1";
	
	
	//junit실행해주기
	//@BeforeClass 어노테이션이 적용된 메소드 실행(최초 1회), 단 static 메소드로 선언
	//@Before 어노테이션이 적용된 메소드 실행(테스트 메소드 실행전 실행)
	//@Test
	//@After 어노테이션이 적용된 메소드 실행(테스트 메소드 실행 후 실행)
	//@AfterClass 어노테이션이 적용된 메소드 실행(최초 1회), 단 static 메소드로 선언

	//실행순서: beforClass -> before -> selectUserAllTest -> after
	//		 -> before -> selectUserTest -> after
	//		 -> before -> selectUserVoTest -> after
	//afterClass
	
	@BeforeClass
	public static void beforeClass(){
		 System.out.println("BeforeClass");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("AfterClass");
	}
	
	@Before
	public void before(){
		/*이 메서드는 초기화 용도로도 사용하기 좋아요*/
		System.out.println("Before");
		userService = new UserService();
		deleteUserTest(TEST_USER_ID);
		
	}
	
	@After
	public void after(){
		System.out.println("After");
	}
	
	@Test
	public void selectUserAllTest() {
		/***Given***/

		/***When***/
		List<UserVo> list = userService.selectUserAll();

		/***Then***/
//		assertEquals(5, list.size());
		
		System.out.println("selectUserAllTest");
	}

	@Test
	public void selectUserTest() {
		/***Given***/

		/***When***/
		UserVo userVo = userService.selectUser("brown");

		/***Then***/
		assertNotNull(userVo);
		
		System.out.println("selectUserTest");
		System.out.println(userVo.getPass());
	}

	@Test
	public void selectUserVoTest() {
		/***Given***/

		/***When***/
		UserVo userVo = userService.selectUser(userService.selectUser("brown"));

		/***Then***/
		assertNotNull(userVo);
		
		System.out.println("selectUserVoTest");
		
	}
	
	@Test
	public void selectUserPageListTest(){
		/***Given***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);

		/***When***/
		Map<String, Object> pageMap = userService.selectUserPageList(pageVo);
		List<UserVo> pageList = (List<UserVo>)pageMap.get("pageList");
		
		int pageCnt = (Integer)pageMap.get("pageCnt");
		
		/***Then***/
		assertEquals(10, pageList.size());
		assertEquals(11, pageCnt);
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
		int insertCnt = userService.insertUser(userVo);
		System.out.println(insertCnt);
		
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	public void deleteUserTest(String testUserId){
		/***Given***/

		/***When***/
		int deleteCnt = userService.deleteUser(testUserId);
		System.out.println(testUserId);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}


}











