package com.park.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.park.pojo.CompanyCapacityList;
import com.park.pojo.LocalServerPOJO;
import com.park.pojo.LocalVehiclePassPOJO;
import com.park.pojo.LocalVehiclePassesList;
import com.park.pojo.TransactionsPOJO;

public interface TransactionsDao {

	void insertTrnsactions(Connection con, TransactionsPOJO trans) throws SQLException;

	TransactionsPOJO getTransactionOfVehicle(Connection con, String vehiclePlate, Integer transactionId) throws SQLException;

	boolean isCapacityAvailable(Connection con, String companyName, String vehicleType) throws SQLException;

	void increaseAvailableCapacity(Connection con, String companyName, String vehicleType) throws SQLException;

	void decreaseAvailableCapacity(Connection con, String companyName, String vehicleType) throws SQLException;

	TransactionsPOJO updateExitTime(Connection con, String FullLicencePlate, Integer transactionId, String exitImagePath) throws SQLException;

	List<TransactionsPOJO> getTransactionOfVehicle(Connection con, String vehiclePlate) throws SQLException;

	void insertVehiclePass(Connection con, LocalVehiclePassesList vehpassList) throws SQLException, ParseException;

	void insertCompanyCapacity(Connection con, CompanyCapacityList capList) throws SQLException;

	void insertServerDetails(Connection con, LocalServerPOJO ls) throws SQLException;

	LocalServerPOJO getLocalServerByToken(Connection con, String token) throws SQLException;

	LocalVehiclePassPOJO getVehiclePass(Connection con, String fullLicencePlate) throws SQLException;

}
