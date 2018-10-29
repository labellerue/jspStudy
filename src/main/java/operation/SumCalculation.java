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
@WebServlet("/sumCalculation")
public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//값 받아오기
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		
		CalculationLogic logic = new CalculationLogic();
		int sum = logic.sumBetweenTwoNumbers(start, end);
		
		
		
		//계산 값 확인
		System.out.println(sum);
		
		//session을 통해 값 전송
		HttpSession session = request.getSession();
		session.setAttribute("result", sum);
	
		//dispatch로 전송할 곳 설정
		RequestDispatcher rd = request.getRequestDispatcher("calculation/sumResult.jsp");
		rd.forward(request, response); 
		
	}

}
