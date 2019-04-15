package com.park.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnection;
import com.park.dao.LocalServerDao;
import com.park.pojo.LocalServerPOJO;
import com.park.util.LogUtil;

public class LocalServerDaoImpl implements LocalServerDao{
	
	@Override
	public void insertLocalServer(Connection con, LocalServerPOJO ls) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "INSERT INTO LocalServer (created_by,group_id, group_name, business_id, business_name, server_mac_address,server_name, total_capacity, capacity_for_2w, capacity_for_4w, client_mac_address_list,token) "
				+ "VALUES(?, ?, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?)";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setString(i++, ls.getCreatedBy());
			ps.setInt(i++, ls.getGroupId());
			ps.setString(i++, ls.getGroupName());
			ps.setInt(i++, ls.getBusinessId());
			ps.setString(i++, ls.getBusinessName());
			ps.setString(i++, ls.getServerMacAddress());
			ps.setString(i++, ls.getServerName());
			ps.setInt(i++, ls.getTotalCapacity());
			ps.setInt(i++, ls.getCapacityFor2w());
			ps.setInt(i++, ls.getCapacityFor4w());
			ps.setString(i++, ls.getClientMacAddressList());
			ps.setString(i++, ls.getToken());
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
	public LocalServerPOJO getLocalServer(Connection con,Integer groupId, Integer businessId, String serverMacAddress) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		ResultSet rs= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "select * from LocalServer"
				+ " where group_id= ? and business_id= ? and server_mac_address= ?";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setInt(i++, groupId);
			ps.setInt(i++, businessId);
			ps.setString(i++, serverMacAddress);
			rs= ps.executeQuery();
			if(rs.next())
			{
				LocalServerPOJO ls= new LocalServerPOJO();
				ls.setCreatedBy(rs.getString("created_by"))
				.setGroupId(rs.getInt("group_id"))
				.setGroupName(rs.getString("group_name"))
				.setBusinessId(rs.getInt("business_id"))
				.setBusinessName(rs.getString("business_name"))
				.setServerMacAddress(rs.getString("server_mac_address"))
				.setServerName(rs.getString("server_name"))
				.setTotalCapacity(rs.getInt("total_capacity"))
				.setCapacityFor2w(rs.getInt("capacity_for_2w"))
				.setCapacityFor4w(rs.getInt("capacity_for_4w"))
				.setClientMacAddressList(rs.getString("client_mac_address_list"))
				.setToken(rs.getString("token"));
				return ls;
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
	public List<LocalServerPOJO> getLocalServersByBusiness(Connection con,Integer groupId, Integer businessId) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		List<LocalServerPOJO> lsercers= new ArrayList<>();
		ResultSet rs= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "select * from LocalServer"
				+ " where group_id= ? and business_id= ?";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setInt(i++, groupId);
			ps.setInt(i++, businessId);
			rs= ps.executeQuery();
			while(rs.next())
			{
				LocalServerPOJO ls= new LocalServerPOJO();
				ls.setCreatedBy(rs.getString("created_by"))
				.setGroupId(rs.getInt("group_id"))
				.setGroupName(rs.getString("group_name"))
				.setBusinessId(rs.getInt("business_id"))
				.setBusinessName(rs.getString("business_name"))
				.setServerMacAddress(rs.getString("server_mac_address"))
				.setServerName(rs.getString("server_name"))
				.setTotalCapacity(rs.getInt("total_capacity"))
				.setCapacityFor2w(rs.getInt("capacity_for_2w"))
				.setCapacityFor4w(rs.getInt("capacity_for_4w"))
				.setClientMacAddressList(rs.getString("client_mac_address_list"))
				.setToken(rs.getString("token"));
				lsercers.add(ls);
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
		return lsercers.isEmpty() ? null:lsercers;
	}
	
	@Override
	public LocalServerPOJO getLocalServerByToken(Connection con, String token) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		ResultSet rs= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "select * from LocalServer"
				+ " where token= ?";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setString(i++, token);
			rs= ps.executeQuery();
			if(rs.next())
			{
				LocalServerPOJO ls= new LocalServerPOJO();
				ls.setCreatedBy(rs.getString("created_by"))
				.setGroupId(rs.getInt("group_id"))
				.setGroupName(rs.getString("group_name"))
				.setBusinessId(rs.getInt("business_id"))
				.setBusinessName(rs.getString("business_name"))
				.setServerMacAddress(rs.getString("server_mac_address"))
				.setServerName(rs.getString("server_name"))
				.setTotalCapacity(rs.getInt("total_capacity"))
				.setCapacityFor2w(rs.getInt("capacity_for_2w"))
				.setCapacityFor4w(rs.getInt("capacity_for_4w"))
				.setClientMacAddressList(rs.getString("client_mac_address_list"))
				.setToken(rs.getString("token"));
				return ls;
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
}
