package com.shnlng.showcast.base.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.shnlng.showcast.base.dal.rowmapper.MenuModelRM;
import com.shnlng.showcast.base.model.MenuModel;

@Service
public class MenuService {
	private static Logger logger = Logger.getLogger(MenuService.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<MenuModel> getAllMenus(){
		logger.debug("enter getAllMenus");
		List<MenuModel> menus = new ArrayList<MenuModel>();
		
		Object[] args = new Object[] { };
		menus = jdbcTemplate.query(MenuModelRM.QUERY_ALL, args, MenuModelRM.INSTANCE);
		
		logger.debug("leave getAllMenus");
		return menus;
	}
	
	public List<MenuModel> getSideMenus(String topMenuKey){
		logger.debug("enter getTopMenus");
		List<MenuModel> menus = new ArrayList<MenuModel>();
		
		Object[] args = new Object[] { topMenuKey };
		menus = jdbcTemplate.query(MenuModelRM.QUERY_SIDE_MENU, args, MenuModelRM.INSTANCE);
		
		logger.debug("leave getTopMenus");
		return menus;
		
	}
	
	public List<MenuModel> getTopMenus(){
		logger.debug("enter getTopMenus");
		List<MenuModel> menus = new ArrayList<MenuModel>();
		
		Object[] args = new Object[] { };
		menus = jdbcTemplate.query(MenuModelRM.QUERY_TOP_MENU, args, MenuModelRM.INSTANCE);
		
		logger.debug("leave getTopMenus");
		return menus;
		
	}
	
	public MenuModel getById(String id){
		logger.debug("enter getById");
		MenuModel menu = null;
		
		Object[] args = new Object[] { id };
		List<MenuModel> menus = jdbcTemplate.query(MenuModelRM.QUERY_BY_ID, args, MenuModelRM.INSTANCE);
		
		if(menus == null || menus.size() == 0){
			return null;			
		}
		
		menu = menus.get(0);
		
		logger.debug("leave getById");
		return menu;
		
	}
	
	public MenuModel getByKey(String key){
		logger.debug("enter getByKey");
		MenuModel menu = null;
		
		Object[] args = new Object[] { key };
		List<MenuModel> menus = jdbcTemplate.query(MenuModelRM.QUERY_BY_KEY, args, MenuModelRM.INSTANCE);
		
		if(menus == null || menus.size() == 0){
			return null;			
		}
		
		menu = menus.get(0);
		
		logger.debug("leave getByKey");
		return menu;
		
	}
	
	public List<MenuModel> getMenuCrumbs(String currentMenuKey){
		logger.debug("getMenuCrumbs");
		
		Stack<MenuModel> crumbs = new Stack<MenuModel>();
		
		MenuModel currentMenu = getByKey(currentMenuKey);
		if(currentMenu == null){
			return null;
		}
		
		crumbs.push(currentMenu);
		
		String parentId = currentMenu.getParentId();
		
		while(!StringUtils.isEmpty(parentId)){
			MenuModel parentMenu = getById(parentId);
			if(parentMenu == null){
				break;
			}
			
			crumbs.push(parentMenu);
			parentId = parentMenu.getParentId();
		}

		List<MenuModel> reverseCrumbs = new ArrayList<MenuModel>();
		while(!crumbs.empty()){
			reverseCrumbs.add(crumbs.pop());
		}
		
		logger.debug("getMenuCrumbs");
		return reverseCrumbs;
	}
}
