package com.park.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.park.pojo.CapacityPOJO;

public interface CapacityDao {

	void insertCapacity(Connection con, CapacityPOJO cap) throws SQLException;

	CapacityPOJO getCapacity(Connection con, Integer groupId, Integer businessId, String serverMacAddress,
			String companName) throws SQLException;

	List<CapacityPOJO> getCapacity(Connection con, Integer groupId, Integer businessId, String serverMacAddress)
			throws SQLException;

}
