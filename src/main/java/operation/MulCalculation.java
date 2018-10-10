package operation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SumCalculation
 */
@WebServlet("/mulCalculation")
public class MulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//기존 view 요청 get : localhost:8081/calculation/mulInput.jsp
		//변경 view 요청 get : localhost:8081/mulCalculation
		RequestDispatcher rd = request.getRequestDispatcher("calculation/mulInput.jsp");
		rd.forward(request, response); 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//값 받아오기
		int param1 = Integer.parseInt(request.getParameter("param1"));
		int param2 = Integer.parseInt(request.getParameter("param2"));
		
		//계산식
		Long mulResult = 1L;
		while(param1 <= param2){
			mulResult = mulResult * param1;
			param1++;
			System.out.println(mulResult);
		}
		
		//계산 값 확인
		System.out.println(mulResult);
		
		//session을 통해 값 전송
		HttpSession session = request.getSession();
		session.setAttribute("mulResult", mulResult);
	
		//dispatch로 전송할 곳 설정
		RequestDispatcher rd = request.getRequestDispatcher("calculation/mulResult.jsp");
		rd.forward(request, response); 
		
	}

}
