package com.shnlng.showcast.base.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shnlng.showcast.base.model.MenuModel;
import com.shnlng.showcast.base.service.MenuService;

public class CommonAttributesInterceptor extends HandlerInterceptorAdapter {
	private static Logger logger = Logger.getLogger(CommonAttributesInterceptor.class);
	
	@Autowired
	private MenuService menuService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("set common attributes begin");
		
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		List<MenuModel> topMenus = (List<MenuModel>)session.getAttribute("topMenus");
		
		if(topMenus == null){
			topMenus = menuService.getTopMenus();
		}
		
		session.setAttribute("topMenus", topMenus);
		

		logger.debug("set common attributes end");
		return super.preHandle(request, response, handler);
	}
}
