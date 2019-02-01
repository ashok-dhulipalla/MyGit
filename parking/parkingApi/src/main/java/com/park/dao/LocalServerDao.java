package com.park.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.park.pojo.LocalServerPOJO;

public interface LocalServerDao {

	void insertLocalServer(Connection con, LocalServerPOJO ls) throws SQLException;

	LocalServerPOJO getLocalServer(Connection con, Integer groupId, Integer businessId, String serverMacAddress)
			throws SQLException;

	List<LocalServerPOJO> getLocalServersByBusiness(Connection con, Integer groupId, Integer businessId)
			throws SQLException;

	LocalServerPOJO getLocalServerByToken(Connection con, String token)
			throws SQLException;

}
