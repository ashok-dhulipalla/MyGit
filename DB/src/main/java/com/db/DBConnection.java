package com.db;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;

import com.db.exception.Connectionexception;
import com.properties.PropertyFile;

public class DBConnection {
	
	private static String url= null;
	private static String user= null;
	private static String password= null;
	private static String driverClass= null;

	private static SimpleConnection simpleConnection= null;
	
	public static Connection getConnection()
	{
		try {
			if(simpleConnection == null)
			{
				if(!PropertyFile.isPropertiesLoaded())
					PropertyFile.loadProperties("db.properties");
				url= PropertyFile.getProperty("DB_URL");
				user= PropertyFile.getProperty("DB_USER");
				password= PropertyFile.getProperty("DB_PASSWORD");
				driverClass= PropertyFile.getProperty("DB_DRIVER_CLASS");
				simpleConnection= new SimpleConnection(url, user, password, driverClass);
			}
			return simpleConnection.getConnection();
		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			throw new Connectionexception("Error while getting connection");
		}
	}
}
