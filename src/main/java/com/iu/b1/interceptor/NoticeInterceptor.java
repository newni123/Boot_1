package com.iu.b1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.b1.member.MemberVO;
@Component
public class NoticeInterceptor extends HandlerInterceptorAdapter{
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean result = false;
		MemberVO memberVO = (MemberVO) request.getSession().getAttribute("member");
		if(memberVO != null) {
			if(memberVO.getId().equals("admin"))
				result = true;
			else 
				response.sendRedirect("../");
		} 
		else {
			response.sendRedirect("../");
		}
		return result;
	}
}
