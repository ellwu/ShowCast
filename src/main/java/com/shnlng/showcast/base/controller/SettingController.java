package com.shnlng.showcast.base.controller;

import java.util.List;

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
@RequestMapping("/setting")
public class SettingController {
	private static Logger logger = Logger.getLogger(SettingController.class);
	
	@Autowired
	private SettingService settingService;
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("enter home");
		
		List<SettingModel> settings = settingService.getAllSettings();
		
		request.setAttribute("settings", settings);
		
		logger.debug("leave home");
		return "setting/home";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("enter edit");
		
		String settingKey = request.getParameter("settingKey");
		if(StringUtils.isEmpty(settingKey)){
			return null;
		}
		
		SettingModel setting = settingService.getSettingByKey(settingKey);
		if(setting == null){
			return null;
		}
		
		request.setAttribute("setting", setting);
		
		logger.debug("leave edit");
		return "setting/edit";
	}
}
