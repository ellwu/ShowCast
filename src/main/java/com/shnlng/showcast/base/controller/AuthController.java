package com.shnlng.showcast.base.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shnlng.showcast.base.model.SettingModel;
import com.shnlng.showcast.base.service.SettingService;

@Controller
public class AuthController {
	private static Logger logger = Logger.getLogger(AuthController.class);

	@Autowired
	private SettingService settingService;

	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("enter login validation process");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			request.setAttribute("loginMsg", "Please provide username or password");

			logger.debug("credentail wrong, forward to login");

			return "login";

		}
		
		SettingModel adminPwdSet = settingService.getSettingByKey("S_ADMIN_PWD");
		if(adminPwdSet == null || StringUtils.isEmpty(adminPwdSet.getValue())){
			request.setAttribute("loginMsg", "Admin's pasword was not set. Please contact administrator.");

			logger.debug("credentail wrong, forward to login");

			return "login";
		}
		
		String savedPwd = adminPwdSet.getValue();

		if ("admin".equals(username) && savedPwd.equals(password)) {
			Cookie authCookie = new Cookie("auth", "admin");
			response.addCookie(authCookie);

			logger.debug("login passed.");
			logger.debug("set cookie");
			return "index";
		} else {

			request.setAttribute("loginMsg", "credential wrong!!!");

			logger.debug("credentail wrong, forward to login");

			return "login";
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("enter logout process");

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("auth".equals(cookie.getName())) {
					cookie.setValue("quit");
					break;
				}
			}

		}

		return "login";
	}

}