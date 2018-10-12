package kr.or.ddit.etc;

import static org.junit.Assert.*;

import org.hamcrest.core.SubstringMatcher;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		/***Given***/
		String contentDisposition = "form-data; name=\"profile\"; filename=\"IMG_6225.JPG\"";

		/***When***/
		//logic
		String fileName = null;
		String[] split = contentDisposition.split("; ");
		for (String str : split) {
			if (str.indexOf("filename=") >= 0) {
				int beginIndex = str.indexOf("filename=") + 10;
				int endIndex = str.lastIndexOf("\"");
				fileName = str.substring(beginIndex, endIndex);
				System.out.println(beginIndex +"    "+ endIndex);
			}
			System.out.println("fileName : " +fileName);
		}
		
		System.out.println(fileName);
		
		/***Then***/
		assertEquals("IMG_6225.JPG", fileName);
		

	}

}
