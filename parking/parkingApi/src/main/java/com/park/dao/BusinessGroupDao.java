package com.park.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.park.pojo.BusinessGroupPOJO;

public interface BusinessGroupDao {

	void insertBusinessGroup(Connection con, BusinessGroupPOJO grp) throws SQLException;

	BusinessGroupPOJO selectBusinessGroup(Connection con, String groupId) throws SQLException;

	BusinessGroupPOJO selectBusinessGroupById(Connection con, Integer groupId) throws SQLException;

}
