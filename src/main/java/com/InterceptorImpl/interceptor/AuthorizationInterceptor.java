package com.InterceptorImpl.interceptor;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.InterceptorImpl.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

	@Autowired
	AuthService authService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String userId = request.getHeader("userId");
		System.out.println(
				"AuthorizationInterceptor :: preHandle() -> Request intercepted for Auth check for user : " + userId);
		boolean isAuthorized = authService.checkingAuth(userId);
		if (!isAuthorized) {
			System.out.println(
					"AuthorizationInterceptor :: preHandle() -> Request intercepted and user in UnAuthorized : "
							+ userId);
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.setContentType("application/json");
			PrintWriter writer = response.getWriter();
			writer.println("{ \"error\": \"" + "Access Denied" + "\" }");
			return false;
		}
		System.out.println("AuthorizationInterceptor :: preHandle() -> Request intercepted user is Authorized  : "
				+ userId + " :: Redirecting for controller Handler -" + request.getRequestURI());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
