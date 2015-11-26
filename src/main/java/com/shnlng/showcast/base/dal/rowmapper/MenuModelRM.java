package com.shnlng.showcast.base.dal.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.shnlng.showcast.base.model.MenuModel;

public class MenuModelRM implements RowMapper<MenuModel>{
	public static String QUERY_ALL = "select * from t_menus";
	public static String QUERY_TOP_MENU = "select * from t_menus where menu_parent_id is null order by menu_sequence";
	public static String QUERY_BY_KEY = "select * from t_menus where menu_key = ?";
	public static String QUERY_BY_ID = "select * from t_menus where menu_id = ?";
	public static String QUERY_SIDE_MENU = "select c.* from t_menus p, t_menus c where c.menu_parent_id = p.menu_id and p.menu_key = ? order by c.menu_sequence";
	public static MenuModelRM INSTANCE = new MenuModelRM();

	@Override
	public MenuModel mapRow(ResultSet rs, int index) throws SQLException {
		
		MenuModel model = new MenuModel();
		
		model.setId(rs.getString("menu_id"));
		model.setKey(rs.getString("menu_key"));
		model.setPrompt(rs.getString("menu_prompt"));
		model.setParentId(rs.getString("menu_parent_id"));
		model.setDesc(rs.getString("menu_desc"));
		model.setSequence(rs.getInt("menu_sequence"));
		model.setFuncId(rs.getString("func_id"));
		
		return model;
	}

	

}
