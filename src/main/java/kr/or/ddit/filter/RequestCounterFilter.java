package kr.or.ddit.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class RequestCounterFilter implements Filter{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//application 객체 확보
		ServletContext application = request.getServletContext();
		
		//application 객체에서 requestMap 가져오기
		Map<String, Integer> uriMap = (Map<String, Integer>)application.getAttribute("uriMap");
		
		//application 객체에서 requestMap 가져오기
		//없으면 신규 생성 후 저장
		if(uriMap == null){
			uriMap = new HashMap<String, Integer>();
		}
		
		String uri = ((HttpServletRequest)request).getRequestURI();
		Integer count = uriMap.get(uri);
		
		if(count == null){
			uriMap.put(uri, 1);
		}else{
			uriMap.put(uri, ++count);
		}
		
		application.setAttribute("uriMap", uriMap);
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
	}

}
