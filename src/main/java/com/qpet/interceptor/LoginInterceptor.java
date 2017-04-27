package com.qpet.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登陆 控制拦截器
 * @author seawind
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 如果用户没有登陆 返回false
		if(request.getSession().getAttribute("admin")==null){
			// 跳转到登陆页面
			 request.getRequestDispatcher("/WEB-INF/jsp/admin/login.jsp").forward(request, response);  
			// 没有登陆
			return false;
		}
		return true;
	}
}
