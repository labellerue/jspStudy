package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class UserUpdateForm
 */
@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5) // 5메가를 byte로 계산, 5메가 5개
@WebServlet("/userUpdate")
public class UserUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceInf userService;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		getUserVo(request, userId);

		request.getRequestDispatcher("/userUpdateForm.jsp").forward(request, response);
	}

	/**
	 * Method : getUserVo 
	 * 작성자 : sohyoung 
	 * 변경이력 :
	 * @param request
	 * @param userId
	 * Method 설명 : 회원 정보 조회
	 */
	protected void getUserVo(HttpServletRequest request, String userId) {
		userService = new UserService();
		UserVo userDetail = userService.selectUser(userId);
		// jsp로 위임하기 위해 사용자 정보를 request에 저장
		request.setAttribute("userDetail", userDetail);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// post 한글 파라미터 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		System.out.println("수정한 내용 : " + request.getParameter("name"));

		// 파일 저장 및 경로 가져오기
		String profile = getProfile(request);

		UserVo userVo = new UserVo();
		userVo.setUserId(request.getParameter("userId"));
		userVo.setName(request.getParameter("name"));
		userVo.setPass(request.getParameter("pass"));
		userVo.setAddr1(request.getParameter("addr1"));
		userVo.setAddr2(request.getParameter("addr2"));
		String birth = request.getParameter("birth");
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
		
		System.out.println("수정한 내용 : " + request.getParameter("name"));
		
		userService = new UserService();
		int updateCnt = userService.updateUser(userVo);
		System.out.println("업데이트 성공여부" + updateCnt);

		// 수정 되었나 detailForm에서 확인
		RequestDispatcher rd = request.getRequestDispatcher("/userDetail");
		rd.forward(request, response);

	}

	/**
	 * Method : getProfile 
	 * 작성자 : sohyoung 
	 * 변경이력 :
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 *             Method 설명 : 파일 저장 및 경로 가져오기
	 */
	protected String getProfile(HttpServletRequest request) throws IOException,
			ServletException {
		// 파일 작업
		Part profilePart = request.getPart("profile");

		// 헤더이름을 받아 그 값을 가져옴
		// 파일과 관련된 부가정보
		String contentDisposition = profilePart.getHeader("Content-disposition");
		// file 경로 가져오는 메서드를 StringUtil 클래스에 넣었어요.
		String fileName = StringUtil.getFileNameFromHeader(contentDisposition);

		// url 정보를 실제 파일 경로로 변경(배포되는 경로입니다.)
		String path = getServletContext().getRealPath("/profile");
		String savePath = path + File.separator + fileName;
		// 파일 쓰기
		profilePart.write(savePath);
		profilePart.delete();

		return "/profile/" + fileName;
	}

}
