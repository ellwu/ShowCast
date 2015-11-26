package com.shnlng.showcast.base.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.shnlng.showcast.base.dal.rowmapper.FuncModelRM;
import com.shnlng.showcast.base.model.FuncModel;

@Service
public class FuncService {
	private static Logger logger = Logger.getLogger(FuncService.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public FuncModel getFuncById(String id) {
		logger.debug("enter getFunc");
		FuncModel func = null;

		Object[] args = new Object[] { id };
		List<FuncModel> result = jdbcTemplate.query(FuncModelRM.QUERY_BY_ID, args, FuncModelRM.INSTANCE);

		if (result == null || result.size() == 0) {
			return null;
		}

		func = result.get(0);

		logger.debug("leave getFunc");
		return func;
	}
}
