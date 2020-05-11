package com.ashok.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	/**
	 * 
	 * @param host
	 * @param port
	 * @param databaseName
	 * @param userName
	 * @param password
	 * @return Connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getMysqlConnection(String host,Integer port,String databaseName,String userName,String password) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver"); 
		String url="jdbc:mysql://"+host+":"+port+"/"+databaseName;
		return getConnection(url,userName,password);  
	}
	public static Connection getSqlConnection(String host,Integer port,String databaseName,String userName,String password) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		String url="jdbc:sqlserver://"+host+":"+port+";databaseName="+databaseName;
		return getConnection(url,userName,password);  
	}
	/**
	 * 
	 * @param databaseName
	 * @return Connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getMysqlLocalConnection(String databaseName) throws SQLException, ClassNotFoundException
	{
		return getMysqlConnection("localhost", 3306, databaseName, "root","9603689505");
	}
	/**
	 * 
	 * @param url
	 * @param userName
	 * @param password
	 * @return connection
	 * @throws SQLException
	 */
	public static Connection getConnection(String url,String userName,String password) throws SQLException
	{
		return DriverManager.getConnection(url,userName,password);
	}
	/**
	 * 
	 * @param host
	 * @param port
	 * @param databaseName
	 * @param userName
	 * @param password
	 * @return connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getPsqlConnection(String host,Integer port,String databaseName,String userName,String password) throws SQLException, ClassNotFoundException
	{
		Class.forName("org.postgresql.Driver");
		String url="jdbc:postgresql://"+host+":"+port+"/"+databaseName;
		return getConnection(url,userName,password);  
	}
	/**
	 * 
	 * @return connection
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getPsqlLocalConnection() throws SQLException, ClassNotFoundException
	{
		return getPsqlConnection("localhost", 5432, "postgres","postgres","postgres");
	}
	public static Connection getDerbyConnection(String databaseName) throws SQLException
	{
		//TODO
		String url="jdbc:derby:"+databaseName+";create=true";
		return DriverManager.getConnection(url);
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(getPsqlLocalConnection());
	}
}
