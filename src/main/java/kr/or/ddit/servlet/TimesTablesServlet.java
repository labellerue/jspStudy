package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTablesServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>Insert title here</title>");
		out.print("<style type=\"text/css\">");
		out.print("	tr td {border: 1px solid skyblue;}");
		out.print("</style>");
		out.print("</head>");
		out.print("<body>");
		out.print("<table>");
		for(int i=2 ; i<10 ; i++){
			out.print("	<tr>");
			for(int j=1 ; j<10 ; j++){
				out.print("		<td>"+i+"*"+j+"="+(i*j)+"</td>");
			}
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	
	

	}
}





























