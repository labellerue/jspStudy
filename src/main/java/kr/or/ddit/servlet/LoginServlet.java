package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 로그인 값 받아오기
		Map<String, String[]> userInfos = req.getParameterMap();
		
		PrintWriter pw = resp.getWriter();
		
		for(String id : userInfos.get("userId")){
			pw.println("userId : " + id);
		}
		for(String pass : userInfos.get("password")){
			pw.println("password : " + pass);
		}
		
		
		
		
		
	}

}
































