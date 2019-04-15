package com.park.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnection;
import com.park.dao.CapacityDao;
import com.park.pojo.CapacityPOJO;
import com.park.util.LogUtil;

public class CapacityDaoImpl implements CapacityDao{

	@Override
	public void insertCapacity(Connection con, CapacityPOJO cap) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "INSERT INTO Capacity (created_by,group_id, group_name, business_id, business_name, server_mac_address,server_name, company_name, capacity_2w, capacity_4w) "
				+ "VALUES(?, ?, ?, ?, ?, ? , ?, ?, ?, ?)";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setString(i++, cap.getCreatedBy());
			ps.setInt(i++, cap.getGroupId());
			ps.setString(i++, cap.getGroupName());
			ps.setInt(i++, cap.getBusinessId());
			ps.setString(i++, cap.getBusinessName());
			ps.setString(i++, cap.getServerMacAddress());
			ps.setString(i++, cap.getServerName());
			ps.setString(i++, cap.getCompanyName());
			ps.setInt(i++, cap.getCapacity2w());
			ps.setInt(i++, cap.getCapacity4w());
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if(con == null && newCon != null) newCon.close();
			if(ps != null) ps.close();
		}
	}
	
	@Override
	public CapacityPOJO getCapacity(Connection con, Integer groupId, Integer businessId, String serverMacAddress, String companName) throws SQLException
	{

		Connection newCon= con;
		PreparedStatement ps= null;
		ResultSet rs= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "select * from Capacity where group_id= ? and business_id= ? and server_mac_address= ? and company_name= ?";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setInt(i++, groupId);
			ps.setInt(i++, businessId);
			ps.setString(i++, serverMacAddress);
			ps.setString(i++, companName);
			rs= ps.executeQuery();
			if(rs.next())
			{
				CapacityPOJO cap= new CapacityPOJO();
				cap.setCreatedBy(rs.getString("created_by"))
				.setGroupId(rs.getInt("group_id"))
				.setGroupName(rs.getString("group_name"))
				.setBusinessId(rs.getInt("business_id"))
				.setBusinessName(rs.getString("business_name"))
				.setServerMacAddress(rs.getString("server_mac_address"))
				.setServerName(rs.getString("server_name"))
				.setCompanyName(rs.getString("company_name"))
				.setCapacity2w(rs.getInt("capacity_2w"))
				.setCapacity4w(rs.getInt("capacity_4w"));
				return cap;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if(con == null && newCon != null) newCon.close();
			if(ps != null) ps.close();
			if(rs != null) rs.close();
		}
		return null;
	
	}
	
	@Override
	public List<CapacityPOJO> getCapacity(Connection con, Integer groupId, Integer businessId, String serverMacAddress) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		List<CapacityPOJO> capList= new ArrayList<CapacityPOJO>();
		ResultSet rs= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "select * from Capacity where group_id= ? and business_id= ? and server_mac_address= ?";
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
				CapacityPOJO cap= new CapacityPOJO();
				cap.setCreatedBy(rs.getString("created_by"))
				.setGroupId(rs.getInt("group_id"))
				.setGroupName(rs.getString("group_name"))
				.setBusinessId(rs.getInt("business_id"))
				.setBusinessName(rs.getString("business_name"))
				.setServerMacAddress(rs.getString("server_mac_address"))
				.setServerName(rs.getString("server_name"))
				.setCompanyName(rs.getString("company_name"))
				.setCapacity2w(rs.getInt("capacity_2w"))
				.setCapacity4w(rs.getInt("capacity_4w"));
				capList.add(cap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			if(con == null && newCon != null) newCon.close();
			if(ps != null) ps.close();
			if(rs != null) rs.close();
		}
		return capList.isEmpty()? null:capList;
	
	}
}
