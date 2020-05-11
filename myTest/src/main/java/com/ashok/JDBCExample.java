package com.ashok;

import java.sql.*;
public class JDBCExample {
	public static void main(String a[])
	{
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "vineej";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "vineej";
		String password = "no";
		try {
			Class.forName(driver).newInstance();
			con =DriverManager.getConnection(url+dbName,userName,password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from Employee");
			System.out.println("Results");
			while( rs.next() ) {
				String data = rs.getString(1);
				System.out.println( data );
			}
			st.close();
		}
		catch( Exception e ) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
} 
