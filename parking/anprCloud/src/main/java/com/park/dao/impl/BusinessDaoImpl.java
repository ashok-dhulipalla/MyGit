package com.park.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnection;
import com.park.dao.BusinessDao;
import com.park.pojo.BusinessPOJO;
import com.park.util.LogUtil;

public class BusinessDaoImpl implements BusinessDao{

	@Override
	public void insertBusiness(Connection con,BusinessPOJO business) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "INSERT INTO business(created_by, group_id, group_name, business_name, address, location, start_time, end_time, contact_person_name, contact_no, tech_support_contact_no)\n" + 
				"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setString(i++, business.getCreatedBy());
			ps.setInt(i++, business.getGroupId());
			ps.setString(i++, business.getGroupName());
			ps.setString(i++, business.getBusinessName());
			ps.setString(i++, business.getAddress());
			ps.setString(i++, business.getLocation());
			ps.setTime(i++, business.getStartTime());
			ps.setTime(i++, business.getEndTime());
			ps.setString(i++, business.getContactPersonName());
			ps.setString(i++, business.getContactNo());
			ps.setString(i++, business.getTechSupportContactNo());
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
	public BusinessPOJO getBusiness(Connection con,Integer groupId,String businessName) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		ResultSet rs= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "select * from business where group_id= ? and business_name= ?";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setInt(i++, groupId);
			ps.setString(i++, businessName);
			rs= ps.executeQuery();
			if(rs.next())
			{
				BusinessPOJO business= new BusinessPOJO();
				business.setCreatedBy(rs.getString("created_by"))
				.setGroupId(rs.getInt("group_id"))
				.setGroupName(rs.getString("group_name"))
				.setBusinessId(rs.getInt("business_id"))
				.setBusinessName(rs.getString("business_name"))
				.setAddress(rs.getString("address"))
				.setStartTime(rs.getTime("start_time"))
				.setEndTime(rs.getTime("end_time"))
				.setLocation(rs.getString("location"))
				.setContactPersonName(rs.getString("contact_person_name"))
				.setContactNo(rs.getString("contact_no"))
				.setTechSupportContactNo(rs.getString("tech_support_contact_no"));
				return business;
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
	public BusinessPOJO getBusinessById(Connection con,Integer groupId,Integer businessId) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		ResultSet rs= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "select * from business where group_id= ? and business_id= ?";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setInt(i++, groupId);
			ps.setInt(i++, businessId);
			rs= ps.executeQuery();
			if(rs.next())
			{
				BusinessPOJO business= new BusinessPOJO();
				business.setCreatedBy(rs.getString("created_by"))
				.setGroupId(rs.getInt("group_id"))
				.setGroupName(rs.getString("group_name"))
				.setBusinessId(rs.getInt("business_id"))
				.setBusinessName(rs.getString("business_name"))
				.setAddress(rs.getString("address"))
				.setStartTime(rs.getTime("start_time"))
				.setEndTime(rs.getTime("end_time"))
				.setLocation(rs.getString("location"))
				.setContactPersonName(rs.getString("contact_person_name"))
				.setContactNo(rs.getString("contact_no"))
				.setTechSupportContactNo(rs.getString("tech_support_contact_no"));
				return business;
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
	public List<BusinessPOJO> getBusinesses(Connection con,Integer groupId) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		List<BusinessPOJO> bss= new ArrayList<>();
		ResultSet rs= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "select * from business where group_id= ?";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setInt(i++, groupId);
			rs= ps.executeQuery();
			while(rs.next())
			{
				BusinessPOJO business= new BusinessPOJO();
				business.setCreatedBy(rs.getString("created_by"))
				.setGroupId(rs.getInt("group_id"))
				.setGroupName(rs.getString("group_name"))
				.setBusinessId(rs.getInt("business_id"))
				.setBusinessName(rs.getString("business_name"))
				.setAddress(rs.getString("address"))
				.setStartTime(rs.getTime("start_time"))
				.setEndTime(rs.getTime("end_time"))
				.setLocation(rs.getString("location"))
				.setContactPersonName(rs.getString("contact_person_name"))
				.setContactNo(rs.getString("contact_no"))
				.setTechSupportContactNo(rs.getString("tech_support_contact_no"));
				bss.add(business);
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
		return bss.isEmpty()? null:bss;
	}
}
