package com.park.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnection;
import com.park.dao.VehiclePassDao;
import com.park.pojo.VehiclePassPOJO;
import com.park.util.LogUtil;

public class VehiclePassDaoImpl implements VehiclePassDao {

	@Override
	public void insertVehiclePass(Connection con, VehiclePassPOJO vehpass) throws SQLException, ParseException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "INSERT INTO VehiclePass (created_by,group_id, group_name, business_id, business_name, server_mac_address,server_name, full_licence_plate, four_digit_licence_plate, expiry_date, updation_date, vehicle_type, company_name) "
				+ "VALUES(?, ?, ?, ?, ?, ? , ?, ?, ?, '"+vehpass.getExpiryDate()+"', '"+vehpass.getUpdationDate()+"', ?, ?)";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setString(i++, vehpass.getCreatedBy());
			ps.setInt(i++, vehpass.getGroupId());
			ps.setString(i++, vehpass.getGroupName());
			ps.setInt(i++, vehpass.getBusinessId());
			ps.setString(i++, vehpass.getBusinessName());
			ps.setString(i++, vehpass.getServerMacAddress());
			ps.setString(i++, vehpass.getServerName());
			ps.setString(i++, vehpass.getFullLicencePlate());
			ps.setString(i++, vehpass.getFourDigitLicencePlate());
			/*SimpleDateFormat sf= new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
			Timestamp ts=new Timestamp(sf.parse(vehpass.getExpiryDate()).getTime());  
			ps.setTimestamp(i++, ts);
			ts=new Timestamp(sf.parse(vehpass.getUpdationDate()).getTime());
			ps.setTimestamp(i++, ts);*/
			ps.setString(i++, vehpass.getVehicleType());
			ps.setString(i++, vehpass.getCompanyName());
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} /*catch (ParseException e) {
			e.printStackTrace();
			throw e;
		}*/
		finally {
			if(con == null && newCon != null) newCon.close();
			if(ps != null) ps.close();
		}
	}
	@Override
	public List<VehiclePassPOJO> getVehiclePasses(Connection con, Integer groupId, Integer businessId, String serverMacAddress, String companName) throws SQLException
	{
		List<VehiclePassPOJO> passes= new ArrayList<>();
		Connection newCon= con;
		PreparedStatement ps= null;
		ResultSet rs= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "select * from VehiclePass where group_id= ? and business_id= ? and server_mac_address= ? and company_name= ?";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setInt(i++, groupId);
			ps.setInt(i++, businessId);
			ps.setString(i++, serverMacAddress);
			ps.setString(i++, companName);
			rs= ps.executeQuery();
			while(rs.next())
			{
				VehiclePassPOJO vehpass= new VehiclePassPOJO();
				vehpass.setCreatedBy(rs.getString("created_by"))
				.setGroupId(rs.getInt("group_id"))
				.setGroupName(rs.getString("group_name"))
				.setBusinessId(rs.getInt("business_id"))
				.setBusinessName(rs.getString("business_name"))
				.setServerMacAddress(rs.getString("server_mac_address"))
				.setServerName(rs.getString("server_name"))
				.setFullLicencePlate(rs.getString("full_licence_plate"))
				.setFourDigitLicencePlate(rs.getString("four_digit_licence_plate"))
				.setPassId(rs.getInt("pass_id"))
				.setExpiryDate(rs.getString("expiry_date"))
				.setUpdationDate(rs.getString("updation_date"))
				.setVehicleType(rs.getString("vehicle_type"))
				.setCompanyName(rs.getString("company_name"));
				passes.add(vehpass);
			}
			return passes.isEmpty()?null:passes;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if(con == null && newCon != null) newCon.close();
			if(ps != null) ps.close();
			if(rs != null) rs.close();
		}
	
	}
	
	
	@Override
	public List<VehiclePassPOJO> getVehiclePasses(Connection con, Integer groupId, Integer businessId, String serverMacAddress) throws SQLException
	{
		List<VehiclePassPOJO> passes= new ArrayList<>();
		Connection newCon= con;
		PreparedStatement ps= null;
		ResultSet rs= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "select * from VehiclePass where group_id= ? and business_id= ? and server_mac_address= ?";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setInt(i++, groupId);
			ps.setInt(i++, businessId);
			ps.setString(i++, serverMacAddress);
			rs= ps.executeQuery();
			while(rs.next())
			{
				VehiclePassPOJO vehpass= new VehiclePassPOJO();
				vehpass.setCreatedBy(rs.getString("created_by"))
				.setGroupId(rs.getInt("group_id"))
				.setGroupName(rs.getString("group_name"))
				.setBusinessId(rs.getInt("business_id"))
				.setBusinessName(rs.getString("business_name"))
				.setServerMacAddress(rs.getString("server_mac_address"))
				.setServerName(rs.getString("server_name"))
				.setFullLicencePlate(rs.getString("full_licence_plate"))
				.setFourDigitLicencePlate(rs.getString("four_digit_licence_plate"))
				.setPassId(rs.getInt("pass_id"))
				.setExpiryDate(rs.getString("expiry_date"))
				.setUpdationDate(rs.getString("updation_date"))
				.setVehicleType(rs.getString("vehicle_type"))
				.setCompanyName(rs.getString("company_name"));
				passes.add(vehpass);
			}
			return passes.isEmpty()?null:passes;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if(con == null && newCon != null) newCon.close();
			if(ps != null) ps.close();
			if(rs != null) rs.close();
		}
	
	}
}
