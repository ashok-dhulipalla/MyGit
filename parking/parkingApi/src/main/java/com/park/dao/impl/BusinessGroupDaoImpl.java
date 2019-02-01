package com.park.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DBConnection;
import com.park.dao.BusinessGroupDao;
import com.park.pojo.BusinessGroupPOJO;
import com.park.util.LogUtil;

public class BusinessGroupDaoImpl implements BusinessGroupDao{

	@Override
	public void insertBusinessGroup(Connection con,BusinessGroupPOJO grp) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "INSERT INTO businessgroup (created_by, group_name, office_address,contact_person_name, contact_no) "
				+ "VALUES(?, ?, ?, ?, ?)";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setString(i++, grp.getCreatedBy());
			ps.setString(i++, grp.getGroupName());
			ps.setString(i++, grp.getOfficeAddress());
			ps.setString(i++, grp.getContactPersonName());
			ps.setString(i++, grp.getContactNo());
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
	public BusinessGroupPOJO selectBusinessGroup(Connection con,String groupName) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		ResultSet rs= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "select * from businessgroup where group_name= ?";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setString(i++, groupName);
			rs= ps.executeQuery();
			if(rs.next())
			{
				BusinessGroupPOJO grp= new BusinessGroupPOJO();
				grp.setCreatedBy(rs.getString("created_by"))
				.setContactPersonName(rs.getString("contact_person_name"))
				.setGroupName(rs.getString("group_name"))
				.setOfficeAddress(rs.getString("office_address"))
				.setContactNo(rs.getString("contact_no"));
				return grp;
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
	public BusinessGroupPOJO selectBusinessGroupById(Connection con,Integer groupId) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		ResultSet rs= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "select * from businessgroup where group_id= ?";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setInt(i++, groupId);
			rs= ps.executeQuery();
			if(rs.next())
			{
				BusinessGroupPOJO grp= new BusinessGroupPOJO();
				grp.setCreatedBy(rs.getString("created_by"))
				.setContactPersonName(rs.getString("contact_person_name"))
				.setGroupName(rs.getString("group_name"))
				.setOfficeAddress(rs.getString("office_address"))
				.setContactNo(rs.getString("contact_no"));
				return grp;
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
