package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.encrypt.sha.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	//service  --> request.getMethod() : "POST", "GET" --> doGet, doPost
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String newParameter = request.getParameter("newParameter");
		System.out.println("newParameter : " + newParameter);
		
//		Map<String, String[]> reqMap = request.getParameterMap();
//		reqMap.put("newParam", new String[] {"newValue"});
		
		//1. 사용자 아이디, 비밀번호를 request객체에서 받아온다.
		//2. db에서 조회해온 아이디, 비밀번호를 체크한다.
		//3-1. 일치할 경우 main.jsp로 이동
		//3-2. 불일치할 경우 login.jsp로 이동
		
		//1.
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("remember-me");
		System.out.println("rememberMe  " + rememberMe);
		
		//아이디 기억 안할 경우
		if(rememberMe == null){
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("remember") ||
					cookie.getName().equals("userId") ){
					cookie.setMaxAge(0);
					cookie.setMaxAge(0);
					// 0으로 설정한 후 보내주기
					response.addCookie(cookie);
				}
				System.out.println("cookie는 : "+ cookie.getName()+" 값은 "+cookie.getValue());
			}
			
		//아이디 기억 사용할 경우
		}else{
			//response 객체에 쿠키를 저장
			Cookie cookie = new Cookie("remember", "Y");
			Cookie userIdCookie = new Cookie("userId", userId);
			response.addCookie(cookie);
			response.addCookie(userIdCookie);
		}
		
		//2. 사용자가 전송한 userId로 사용자 정보 조회
		UserServiceInf userService = new UserService();
		UserVo userVo = userService.selectUser(userId);
		
		//3. 일치할 경우
//		if(userVo != null && password.equals(userVo.getPass())){
		/* 패스워드 암호화 */
		String encryptPass = KISA_SHA256.encrypt(password);
		if(userVo != null && userVo.authPass(encryptPass)){
			//redirect
			//resp.sendRedirect("main.jsp?userId=" + userId + "&password=" + password);
			
			//3-1. main.jsp
			HttpSession session = request.getSession();
			session.setAttribute("userVo", userVo);
			//위와 같은 내용 req.getSession().setAttribute("userVo", userVo);
			
			//dispatch
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response); //저장하기
			
		//3-2. login.jsp로 이동
		}else{
			response.sendRedirect("login/login.jsp");
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		doPost(req, resp);
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw =resp.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("	<html>");
		pw.println("		<head>");
		pw.println("			<meta charset=\"UTF-8\">");
		pw.println("			<title>Insert title here</title>");
		pw.println("		</head>");
		pw.println("		<body>");
		
		//userId : brwon / sally
		String[] userIds = req.getParameterValues("userId");
		for(String userId : userIds)
			pw.println("		userId : " + userId + "<br>");
		pw.println("		password : " + req.getParameter("password") + "<br>");
		pw.println("		</body>");
		pw.println("	</html>");
	}
}







