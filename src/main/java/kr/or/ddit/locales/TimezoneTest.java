package kr.or.ddit.locales;


import java.util.TimeZone;

import org.junit.Test;

public class TimezoneTest {

	@Test
	public void timezoneTest() {
		/*** Given ***/
		
		/*** When ***/
		//시간 timezone 정보 제공되는 나라 
		String[] timezones = TimeZone.getAvailableIDs();
		for(String str : timezones){
			System.out.println(str);
		}
		/*** Then ***/

	}

}
