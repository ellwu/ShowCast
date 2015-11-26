package com.shnlng.showcast.base.dal.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shnlng.showcast.base.model.FuncModel;

public class FuncModelRM implements RowMapper<FuncModel>{
	public static String QUERY_BY_ID = "select * from t_funcs where func_id = ?";
	public static FuncModelRM INSTANCE = new FuncModelRM();

	@Override
	public FuncModel mapRow(ResultSet rs, int index) throws SQLException {
		
		FuncModel model = new FuncModel();
		
		model.setId(rs.getString("func_id"));
		model.setKey(rs.getString("func_key"));
		model.setPrompt(rs.getString("func_prompt"));
		model.setDesc(rs.getString("func_desc"));
		model.setUrl(rs.getString("func_url"));
		
		return model;
	}

	

}
