package com.park.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.park.pojo.BusinessGroupPOJO;
import com.park.pojo.BusinessPOJO;

public interface BusinessDao {

	void insertBusiness(Connection con, BusinessPOJO business) throws SQLException;

	BusinessPOJO getBusiness(Connection con, Integer groupId, String businessName) throws SQLException;

	BusinessPOJO getBusinessById(Connection con, Integer groupId, Integer businessId) throws SQLException;

	List<BusinessPOJO> getBusinesses(Connection con, Integer groupId) throws SQLException;


}
