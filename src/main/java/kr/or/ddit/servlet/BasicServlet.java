package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * BasicServlet.java
 *
 * @author pc02
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정자 수정내용
 * ------ ------------------------
 * pc02 최초 생성
 * 
 * 현재 시간을 출력하는 html 생성하는 서블릿
 * </pre>
 */
public class BasicServlet extends HttpServlet {

	// 요청 http에 메소드에 따라 실행되는 메소드가 달라진다
	// get : doGet
	// post: doPost

	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	@Override
	public void destroy() {
		System.out.println("destroy");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// HttpServletRequest: 요청에 대한 정보
		// HttpServletRespnse: 응답에 대한 정보

		// html만 인식; 인코딩=utf-8
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		
		// date format을 이용하여
		// 년-월-일 만 화면에 출력
		Date date = new Date();
		SimpleDateFormat simple_format = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		String theDate = simple_format.format(date);
		
//		pw.println("Hello World");
//		pw.println(theDate);

/*		
		// html 
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>Insert title here</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("</body>");
		pw.println("	<script type='text/javascript'>");
		pw.println("		var date = new Date();");
		pw.println("		document.getElementsByTagName('body')[0].innerHTML = '현재시간: '+date;");
		pw.println("	</script>");
		pw.println("</html>");
		// 따옴표의 경우 \" 혹은 '로 작업
*/
		
		
		// 위위 작업을 html과 섞어 표현
		// 여기서 println은 화면에는 적용이 안됨. 소스 보기에서 적용되는 사항
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=\"UTF-8\">");
		pw.println("<title>Insert title here</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("	hello, world");
		pw.println(		"<br>"+theDate);
		pw.println("</body>");
		pw.println("</html>");
		
		pw.flush();
		pw.close();
		
		

	}

	// 정적 자료: index.html --> url
	// 동적 자료: serclet --> url mapping 구성 필요: web.xml

}
