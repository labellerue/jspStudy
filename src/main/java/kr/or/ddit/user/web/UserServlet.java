package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

@WebServlet("/userAllList")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	//서버상태 변함이 없는 경우(db에 변화가 없을 경우) get을 사용합니다
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전체 사용자 정보 조회
		
		UserServiceInf userService = new UserService();
		
		List<UserVo> userList = userService.selectUserAll();
		
		//조회된 사용자 정보를 userAllList.jsp를 통해 화면처리
		//attribute로 사용할 수 있는 경우 3가지
		//session, application, request
		//session : 해당 사용자만 접근이 가능(사용자 전용 공간) --> 자주 참조하는 데이터, 너무 많은 데이터 저장하게 되면 과부하(OOM 유발 가능성)
		//application : 모든 사용자가 접근 가능(서버당 하나만 생성)	--> 일반적으로 설정과 관련된 값을 저장
		//request : 해당 요청의 응답이 끝날때 까지
		
		request.setAttribute("userList", userList);
		
		
		//화면으로 위임 : 2가지
		//1. dispatch : 서버 db의 내용 변화가 없을 경우(F5를 하면 같은 요청이 한번 더 갑니다)
		//2. sendRedirect : 서버에 데이터가 변경되었을 때(게시판용..F5를 했을 때 작용)
		
		RequestDispatcher rd = request.getRequestDispatcher("/userAllList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
