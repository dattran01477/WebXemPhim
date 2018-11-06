package com.WebXemPhim.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionUtils {

	public ConectionUtils() {
		
		
		
	}
	public static Connection  getSqlConnect() throws SQLException, ClassNotFoundException
	{
		 String hostName = "localhost";
	     String sqlInstanceName = "SQLEXPRESS";
	     String database = "MovieTheater";
	     String userName = "Thanhvien";
	     String password = "123";
	 
	     return getSqlConnect(hostName, sqlInstanceName,
	             database, userName, password);
	}
	private static Connection getSqlConnect(String hostName, String sqlInstanceName, String database, String userName,
			String password) throws SQLException, ClassNotFoundException {
	
///jdbc:sqlserver://localhost:1433;instance=SQLEXPRESS;databaseName=MovieTheater
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
	             + ";instance=" + sqlInstanceName + ";databaseName=" + database;
	 
		 Connection conn = DriverManager.getConnection(connectionURL,userName,password);
	     return conn;
	}

	

}
