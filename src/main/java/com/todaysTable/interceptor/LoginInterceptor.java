package com.todaysTable.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession httpSession = request.getSession(false);
		if(httpSession != null) {
			Object id = httpSession.getAttribute("id"); // 세션에 있는 로그인 id 값을 가져옴
			if(id != null) return true; // 세션에 id 값이 있다면 true를 리턴
		}
		
		// 로그인 정보가 없다면 이전페이지로 리턴
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter printwriter = response.getWriter(); // 에러메세지 출력을 위한 PrintWriter 객체
		printwriter.print("<script>alert('로그인이 필요합니다.'); history.go(-1);</script>"); // 에러 메세지 출력
		printwriter.flush();
		printwriter.close();
		 
		return false;
	}
	
}
