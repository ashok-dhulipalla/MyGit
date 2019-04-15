package com.park.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import com.db.DBConnection;
import com.park.pojo.VehiclePassPOJO;

public class CommonUtil {

	public static void delete(Connection con, String tableName) throws SQLException, ParseException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "delete from "+tableName;
		LogUtil.logger.info("Query: "+query);
		try {
			ps= newCon.prepareStatement(query);
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
