package kr.or.ddit.user.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5) // 5메가를 byte로 계산, 5메가 5개
@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//fileUpload.jsp 전달
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/fileupload/fileUpload.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//일반 text 파라미터 : request.getParameter("파라미터명");
		//파일 : request.getPart("파라미터명");
		
		//profile part
		Part profilePart = request.getPart("profile");
		System.out.println("profile part : " + profilePart.getContentType());
		
		//헤더이름을 받아 그 값을 가져옴
		//파일과 관련된 부가정보
		System.out.println("Content-disposition : " + profilePart.getHeader("Content-disposition"));

		String contentDisposition = profilePart.getHeader("Content-disposition");
		String fileName = "";

		String[] split = contentDisposition.split("; ");
		for (String str : split) {
			if (str.indexOf("filename=") >= 0) {
				int beginIndex = str.indexOf("filename=") + 10;
				int endIndex = str.lastIndexOf("\"");
				fileName = str.substring(beginIndex, endIndex);
			}
		}
		//파일 쓰기
//		profilePart.write("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + new String(fileName.getBytes(), "UTF-8"));
		profilePart.write("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" + fileName);
		profilePart.delete(); // 용량이 크면 디스크에 임시로 저장함. 이 역역 정리해주는 메서드
	}
	
	
	
	

}


























