package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.StringUtil;

/**
 * Servlet implementation class UserFormServlet
 */
@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5) // 5메가를 byte로 계산, 5메가 5개
@WebServlet("/userForm")
public class UserFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//사용자 등록 화면
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//userForm.jsp로 위임
		request.getRequestDispatcher("/userForm.jsp").forward(request, response);	//  /user/userForm.jsp
		//userPageList.jsp에서 get으로 넘어올거예요
	}

	//사용자 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//post 한글 파라미터 인코딩 처리
		request.setCharacterEncoding("utf-8");

		// 파일 저장 및 경로 가져오기
		String profile = getProfile(request);

		// 파라미터 값 받아오기
		UserVo userVo = new UserVo();
		userVo.setUserId(request.getParameter("userId"));
		userVo.setName(request.getParameter("name"));
		userVo.setPass(request.getParameter("pass"));
		userVo.setAddr1(request.getParameter("addr1"));
		userVo.setAddr2(request.getParameter("addr2"));
		String birth =  request.getParameter("birth");
		Date birthDate = null;
		try {
			birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birth);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		userVo.setBirth(birthDate);
		userVo.setZip(request.getParameter("zip"));
		userVo.setEmail(request.getParameter("email"));
		userVo.setTel(request.getParameter("tel"));
		userVo.setProfile(profile);
		
		//사용자 등록 서비스 호출
		UserServiceInf userService = new UserService();
		int insertCnt = userService.insertUser(userVo);
		
		//사용자 list로 이동(redirect :  서버 상태가 변경되므로 사용자가 새로고침을 통해 재요청시 중복 등록되는 현상을 막는다.)
		response.sendRedirect("/userPageList?page=1&pageSize=10");
		
	}
	
	/**
	* Method : getProfile
	* 작성자 : sohyoung
	* 변경이력 :
	* @param request
	* @return
	* @throws IOException
	* @throws ServletException
	* Method 설명 : 파일 저장 및 경로 가져오기
	*/
	protected String getProfile(HttpServletRequest request) throws IOException,
			ServletException {
		// 파일 작업
		Part profilePart = request.getPart("profile");
		System.out.println("profile part : " + profilePart.getContentType());

		// 헤더이름을 받아 그 값을 가져옴
		// 파일과 관련된 부가정보
		System.out.println("Content-disposition : "
				+ profilePart.getHeader("Content-disposition"));

		String contentDisposition = profilePart.getHeader("Content-disposition");
		//file 경로 가져오는 메서드를 StringUtil 클래스에 넣었어요.
		String fileName = StringUtil.getFileNameFromHeader(contentDisposition);
		
		//url 정보를 실제 파일 경로로 변경(배포되는 경로입니다.)
		String path = getServletContext().getRealPath("/profile");
		String savePath = path + File.separator + fileName;
		// 파일 쓰기
		// profilePart.write("D:\\A_TeachingMaterial\\6.JspSrpgin\\upload\\" +
		// new String(fileName.getBytes(), "UTF-8"));
		profilePart.write(savePath);
		profilePart.delete();
		
		return "/profile/" + fileName;
	}
	
	
}



















