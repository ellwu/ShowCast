package com.shnlng.showcast.base.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.shnlng.showcast.base.dal.rowmapper.SettingModelRM;
import com.shnlng.showcast.base.model.SettingModel;

@Service
public class SettingService {
	private static Logger logger = Logger.getLogger(SettingService.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public SettingModel getSettingByKey(String key) {
		logger.debug("enter getSettingByKey");
		SettingModel setting = null;

		Object[] args = new Object[] { key };
		List<SettingModel> result = jdbcTemplate.query(SettingModelRM.QUERY_BY_KEY, args, SettingModelRM.INSTANCE);

		if (result == null || result.size() == 0) {
			return null;
		}

		setting = result.get(0);

		logger.debug("leave getSettingByKey");
		return setting;
	}
	
	public List<SettingModel> getAllSettings(){
		logger.debug("enter getAllSettings");

		Object[] args = new Object[] {  };
		List<SettingModel> settings = jdbcTemplate.query(SettingModelRM.QUERY_ALL, args, SettingModelRM.INSTANCE);

		logger.debug("leave getAllSettings");
		return settings;
		
	}
}
