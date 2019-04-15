package com.db.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import com.db.DBConnection;

public class DbUtil {

	public static void delete(Connection con, String tableName) throws SQLException, ParseException
	{
		Connection newCon= con;
		PreparedStatement ps= null;
		if(newCon == null)
			newCon= DBConnection.getConnection();
		String query= "delete from "+tableName;
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
