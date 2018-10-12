package kr.or.ddit.util;

public class StringUtil {
	
	/**
	* Method : getFileNameFromHeader
	* 작성자 : pc02
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

}
