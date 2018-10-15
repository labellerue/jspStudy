package kr.or.ddit.util;

public class StringUtil {
	
	/**
	* Method : getFileNameFromHeader
	* 작성자 : sohyoung
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : contentDisposition에서 filename을 추출
	*/
	public static String getFileNameFromHeader(String contentDisposition){
		
		String fileName = "";
		String[] split = contentDisposition.split("; ");
		for (String str : split) {
			if (str.indexOf("filename=") >= 0) {
				int beginIndex = str.indexOf("filename=") + 10;
				int endIndex = str.lastIndexOf("\"");
				fileName = str.substring(beginIndex, endIndex);
			}
		}
		return fileName;
	}
	
	/**
	* Method : getCookie
	* 작성자 : sohyoung
	* 변경이력 :
	* @param cookieString
	* @param key
	* @return
	* Method 설명 : 쿠키 정보 값 추출
	*/
	public static String getCookie(String cookieString, String key){
		String value = "";
		String[] split = cookieString.split("; ");
		for(String str : split){
			System.out.println(str);
			if(str.startsWith(key+"=")){
				value = str.substring((key+"=").length());
			}
		}
		return value;
	}
	

}





































