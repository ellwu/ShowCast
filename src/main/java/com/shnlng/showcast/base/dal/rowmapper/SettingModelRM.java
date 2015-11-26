package com.shnlng.showcast.base.dal.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shnlng.showcast.base.model.SettingModel;

public class SettingModelRM implements RowMapper<SettingModel>{
	public static String QUERY_ALL = "select * from t_settings";
	public static String QUERY_BY_KEY = "select * from t_settings where setting_key = ?";
	public static SettingModelRM INSTANCE = new SettingModelRM();

	@Override
	public SettingModel mapRow(ResultSet rs, int index) throws SQLException {
		
		SettingModel model = new SettingModel();
		
		model.setId(rs.getString("setting_id"));
		model.setKey(rs.getString("setting_key"));
		model.setValue(rs.getString("setting_value"));
		model.setPrompt(rs.getString("setting_prompt"));
		model.setDesc(rs.getString("setting_desc"));
		
		return model;
	}

	

}
