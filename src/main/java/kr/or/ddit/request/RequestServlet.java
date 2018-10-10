package kr.or.ddit.request;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/requestServlet")	//mapping하기 => request.jsp의 form 액션
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//parameter userId, name
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		
		//request 정보에 값을 저장
		UserVoVo userVo = getUser(userId);
//		request.setAttribute("userVo", userVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("userVo", userVo);
		
		//dispatch forward : request/requestResult.jsp
//		RequestDispatcher rd = request.getRequestDispatcher("request/requestResult.jsp");
//		rd.forward(request, response);
		
		//redirect
		response.sendRedirect("request/requestResult.jsp");
		
	}
	
	public UserVoVo getUser(String userId){
		//userId 매개변수를 이용하여 사용자 정보를 db에서 조회
		UserVoVo userVo = new UserVoVo();
		userVo.setUserId(userId);
		userVo.setName("브라운");
		userVo.setAlias("곰");
		userVo.setBirth(new Date());
		
		return userVo;
	}
	
	
	public class UserVoVo{
		private String userId;
		private String name;
		private String alias;
		private Date birth;
		
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAlias() {
			return alias;
		}
		public void setAlias(String alias) {
			this.alias = alias;
		}
		public Date getBirth() {
			return birth;
		}
		public void setBirth(Date birth) {
			this.birth = birth;
		}
		
	}

}




















