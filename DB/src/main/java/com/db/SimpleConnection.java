package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnection {

	private String url= null;
	private String user= null;
	private String password= null;
	
	public SimpleConnection(String url,String user,String password,String driverClass) throws ClassNotFoundException
	{
		Class.forName(driverClass);
		this.url= url;
		this.user= user;
		this.password= password;
	}
	
	public Connection getConnection() throws SQLException
	{
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
