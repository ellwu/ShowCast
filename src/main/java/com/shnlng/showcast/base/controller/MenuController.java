package com.shnlng.showcast.base.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shnlng.showcast.base.model.FuncModel;
import com.shnlng.showcast.base.model.MenuModel;
import com.shnlng.showcast.base.service.FuncService;
import com.shnlng.showcast.base.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	private static Logger logger = Logger.getLogger(MenuController.class);

	@Autowired
	private MenuService menuService;
	@Autowired
	private FuncService funcService;

	@RequestMapping("/listAll")
	public String listAll(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("enter listAll");

		List<MenuModel> menus = menuService.getAllMenus();

		request.setAttribute("menus", menus);

		logger.debug("leave listAll");
		return null;
	}

	@RequestMapping("/to")
	public String to(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("enter to");

		String key = request.getParameter("key");
		if (StringUtils.isEmpty(key)) {
			return "index";
		}

		MenuModel menu = menuService.getByKey(key);

		if (menu == null) {
			return "index";
		}

		HttpSession session = request.getSession();
		session.setAttribute("currentTopMenuKey", null);
		session.setAttribute("currentSideMenuKey", null);
		session.setAttribute("menuCrumbs", null);
		session.setAttribute("sideMenus", null);

		List<MenuModel> menuCrumbs = menuService.getMenuCrumbs(menu.getKey());
		if (menuCrumbs != null && menuCrumbs.size() > 0) {

			MenuModel currentTopMenu = menuCrumbs.get(0);
			session.setAttribute("currentTopMenuKey", currentTopMenu.getKey());

			List<MenuModel> sideMenus = menuService.getSideMenus(currentTopMenu.getKey());
			session.setAttribute("sideMenus", sideMenus);

			if (menuCrumbs.size() > 1) {
				MenuModel currentSideMenu = menuCrumbs.get(1);
				session.setAttribute("currentSideMenuKey", currentSideMenu.getKey());
			}

			session.setAttribute("menuCrumbs", menuCrumbs);
		}

		FuncModel func = funcService.getFuncById(menu.getFuncId());

		if (func == null) {
			return "index";
		}

		String funcUrl = func.getUrl();

		if (StringUtils.isEmpty(funcUrl)) {
			return "index";
		}

		try {
			request.getRequestDispatcher(funcUrl).forward(request, response);
		} catch (ServletException e) {
			logger.error(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		logger.debug("leave to");
		return null;
	}
}