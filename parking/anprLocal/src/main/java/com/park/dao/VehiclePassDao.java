package com.park.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.park.pojo.VehiclePassPOJO;

public interface VehiclePassDao {

	void insertVehiclePass(Connection con, VehiclePassPOJO vehpass) throws SQLException, ParseException;

	List<VehiclePassPOJO> getVehiclePasses(Connection con, Integer groupId, Integer businessId, String serverMacAddress,
			String companName) throws SQLException;

	List<VehiclePassPOJO> getVehiclePasses(Connection con, Integer groupId, Integer businessId, String serverMacAddress)
			throws SQLException;

}
