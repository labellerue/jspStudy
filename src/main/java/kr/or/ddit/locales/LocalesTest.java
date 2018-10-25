package kr.or.ddit.locales;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LocalesTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void localesTest() {
		/***Given***/

		/***When***/
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		for(Locale locale : locales){
			System.out.println("locale : \n" + locale);
		}
		
		/***Then***/

	
	}

}
