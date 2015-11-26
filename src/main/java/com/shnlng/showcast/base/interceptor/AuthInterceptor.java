package com.shnlng.showcast.base.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	private static Logger logger = Logger.getLogger(AuthInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("auth interceptor begin");
		Cookie[] cookies = request.getCookies();

		boolean authPassed = false;

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("auth".equals(cookie.getName())) {
					if ("admin".equals(cookie.getValue())) {
						authPassed = true;
					}
				}
			}
		}

		String requestUri = request.getRequestURI();
		
		if(!StringUtils.isEmpty(requestUri) && requestUri.indexOf("login.do") > 0){
			//login request
			return true;
		}

		if (!authPassed) {
			request.getRequestDispatcher("/login.do").forward(request, response);
			return false;

		}

		logger.debug("auth interceptor end");
		return super.preHandle(request, response, handler);
	}
}
