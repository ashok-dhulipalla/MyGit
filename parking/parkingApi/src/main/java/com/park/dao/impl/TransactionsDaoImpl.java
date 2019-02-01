package com.park.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnection;
import com.park.dao.TransactionsDao;
import com.park.pojo.CompanyCapacityList;
import com.park.pojo.CompanyCapacityPOJO;
import com.park.pojo.LocalServerPOJO;
import com.park.pojo.LocalVehiclePassPOJO;
import com.park.pojo.LocalVehiclePassesList;
import com.park.pojo.TransactionsPOJO;
import com.park.util.LogUtil;

public class TransactionsDaoImpl implements TransactionsDao{

	@Override
	public void insertTrnsactions(Connection con, TransactionsPOJO trans) throws SQLException
	{

		Connection newCon= con;
		PreparedStatement ps= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "INSERT INTO LocalTransactions (created_by,full_licence_plate,four_digit_licence_plate,vehicle_type,record_type,company_name,entry_image_path,exit_image_path) "
				+ "VALUES(?, ?, ?, ?, ?, ? , ?, ?)";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setString(i++, trans.getCreatedBy());
			ps.setString(i++, trans.getFullLicencePlate());
			ps.setString(i++, trans.getFourDigitLicencePlate());
			ps.setString(i++, trans.getVehicleType());
			ps.setString(i++, trans.getRecordType());
			ps.setString(i++, trans.getCompanyName());
			ps.setString(i++, trans.getEntryImagePath());
			ps.setString(i++, trans.getExitImagePath());

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
	public TransactionsPOJO getTransactionOfVehicle(Connection con, String vehiclePlate, Integer transactionId) throws SQLException
	{
		List<TransactionsPOJO> transactions= new ArrayList<>();
		Connection newCon= con;
		PreparedStatement ps= null;
		ResultSet rs= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "select * from LocalTransactions where full_licence_plate= ? and transaction_id= ?";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setString(i++,vehiclePlate);
			ps.setInt(i++, transactionId);
			rs= ps.executeQuery();
			if(rs.next())
			{
				TransactionsPOJO trans= new TransactionsPOJO();
				trans.setCreatedBy(rs.getString("created_by"))
				.setEntryTime(rs.getString("entry_time"))
				.setExitTime(rs.getString("exit_time"))
				.setTransactionId(rs.getInt("transaction_id"))
				.setFullLicencePlate(rs.getString("full_licence_plate"))
				.setFourDigitLicencePlate(rs.getString("four_digit_licence_plate"))
				.setVehicleType(rs.getString("vehicle_type"))
				.setRecordType(rs.getString("record_type"))
				.setCompanyName(rs.getString("company_name"))
				.setEntryImagePath(rs.getString("entry_image_path"))
				.setExitImagePath(rs.getString("exit_image_path"));
				return trans;
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
	public TransactionsPOJO updateExitTime(Connection con, String FullLicencePlate, Integer transactionId, String exitImagePath) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		ResultSet rs= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "update LocalTransactions set exit_time= now(), exit_image_path= ?, ";
		query+=" parking_duration_in_mins= (DATE_PART('day', now()::timestamp - entry_time::timestamp) * 24 + \n" + 
				"               DATE_PART('hour', now()::timestamp - entry_time::timestamp)) * 60 +\n" + 
				"               DATE_PART('minute', now()::timestamp - entry_time::timestamp) ";
		query+= " where full_licence_plate=? and transaction_id = ? RETURNING *";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setString(i++, exitImagePath);
			ps.setString(i++, FullLicencePlate);
			ps.setInt(i++, transactionId);
			rs= ps.executeQuery();
			if(rs.next())
			{
				TransactionsPOJO trans= new TransactionsPOJO();
				trans.setCreatedBy(rs.getString("created_by"))
				.setEntryTime(rs.getString("entry_time"))
				.setExitTime(rs.getString("exit_time"))
				.setTransactionId(rs.getInt("transaction_id"))
				.setFullLicencePlate(rs.getString("full_licence_plate"))
				.setFourDigitLicencePlate(rs.getString("four_digit_licence_plate"))
				.setVehicleType(rs.getString("vehicle_type"))
				.setRecordType(rs.getString("record_type"))
				.setCompanyName(rs.getString("company_name"))
				.setEntryImagePath(rs.getString("entry_image_path"))
				.setExitImagePath(rs.getString("exit_image_path"))
				.setParkingDurationInMins(rs.getInt("parking_duration_in_mins"));
				return trans;
			}
			return null;
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
	public boolean isCapacityAvailable(Connection con, String companyName, String vehicleType) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		ResultSet rs= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String colName= null;
		if(vehicleType.equalsIgnoreCase("2w"))
			colName= "available_capacity_for_2w";
		else if(vehicleType.equalsIgnoreCase("4w"))
			colName= "available_capacity_for_4w";
		String query= "select 1 from companyCapacity where company_name= ? and "+colName+" > 0";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setString(i++, companyName);
			rs= ps.executeQuery();
			if(rs.next())
				return true;
			return false;
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
	public void increaseAvailableCapacity(Connection con, String companyName, String vehicleType) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String colName= null;
		if(vehicleType.equalsIgnoreCase("2w"))
			colName= "available_capacity_for_2w";
		else if(vehicleType.equalsIgnoreCase("4w"))
			colName= "available_capacity_for_4w";
		String query= "update companyCapacity set "+colName+" = "+colName+" + 1 ";
		query+= "where company_name= ?";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setString(i++, companyName);
			ps.executeUpdate();
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
	public void decreaseAvailableCapacity(Connection con, String companyName, String vehicleType) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String colName= null;
		if(vehicleType.equalsIgnoreCase("2w"))
			colName= "available_capacity_for_2w";
		else if(vehicleType.equalsIgnoreCase("4w"))
			colName= "available_capacity_for_4w";
		String query= "update companyCapacity set "+colName+" = "+colName+" - 1 ";
		query+= "where company_name= ?";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setString(i++, companyName);
			ps.executeUpdate();
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
	public List<TransactionsPOJO> getTransactionOfVehicle(Connection con, String vehiclePlate) throws SQLException
	{
		List<TransactionsPOJO> transactions= new ArrayList<>();
		Connection newCon= con;
		PreparedStatement ps= null;
		ResultSet rs= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "select * from LocalTransactions where full_licence_plate= ? order by entry_time desc";
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
			int i= 1;
			ps.setString(i++,vehiclePlate);
			rs= ps.executeQuery();
			if(rs.next())
			{
				TransactionsPOJO trans= new TransactionsPOJO();
				trans.setCreatedBy(rs.getString("created_by"))
				.setEntryTime(rs.getString("entry_time"))
				.setExitTime(rs.getString("exit_time"))
				.setTransactionId(rs.getInt("transaction_id"))
				.setFullLicencePlate(rs.getString("full_licence_plate"))
				.setFourDigitLicencePlate(rs.getString("four_digit_licence_plate"))
				.setVehicleType(rs.getString("vehicle_type"))
				.setRecordType(rs.getString("record_type"))
				.setCompanyName(rs.getString("company_name"))
				.setEntryImagePath(rs.getString("entry_image_path"))
				.setExitImagePath(rs.getString("exit_image_path"))
				.setParkingDurationInMins(rs.getInt("parking_duration_in_mins"));
				transactions.add(trans);
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
		return transactions.isEmpty()? null : transactions;

	}

	@Override
	public void insertVehiclePass(Connection con, LocalVehiclePassesList vehpassList) throws SQLException, ParseException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();

		try {

			for(LocalVehiclePassPOJO vehpass: vehpassList.getList())
			{
				String query= "INSERT INTO LocalVehiclePass (created_by, full_licence_plate, four_digit_licence_plate, expiry_date, updation_date, vehicle_type, company_name) "
						+ "VALUES(?, ?, ?, '"+vehpass.getExpiryDate()+"', '"+vehpass.getUpdationDate()+"', ?, ?)";
				LogUtil.logger.info("Query: "+query);
				ps= newCon.prepareStatement(query);
				int i= 1;
				ps.setString(i++, vehpass.getCreatedBy());
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
			}
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
	public void insertCompanyCapacity(Connection con, CompanyCapacityList capList) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "INSERT INTO CompanyCapacity (created_by, company_name, total_capacity_for_2w, total_capacity_for_4w, available_capacity_for_2w, available_capacity_for_4w) "
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		LogUtil.logger.info("Query: "+query);
		try {
			for(CompanyCapacityPOJO cap: capList.getList())
			{
				ps= newCon.prepareStatement(query);
				int i= 1;
				ps.setString(i++, cap.getCreatedBy());
				ps.setString(i++, cap.getCompanyName());
				ps.setInt(i++, cap.getCapacity2w());
				ps.setInt(i++, cap.getCapacity4w());
				ps.setInt(i++, cap.getCapacity2w());
				ps.setInt(i++, cap.getCapacity4w());

				ps.execute();
			}
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
	public void insertServerDetails(Connection con, LocalServerPOJO ls) throws SQLException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "INSERT INTO ServerDetails (created_by,group_id, group_name, business_id, business_name, server_mac_address,server_name, total_capacity, capacity_for_2w, capacity_for_4w, client_mac_address_list,token) "
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

}
