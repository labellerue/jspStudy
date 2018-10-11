package kr.or.ddit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PageEtcTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void pageNaviCaltest() {
		/***Given***/
		int totalUserCnt = 105;
		int pageSize = 10;
		
		/***When***/
		int naviSize =  (int)Math.ceil((double)totalUserCnt / pageSize);
		
		/***Then***/
		assertEquals(11,  naviSize);
		
	}

}
