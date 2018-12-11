package com.WebXemPhim.Dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.WebXemPhim.jdbc.ConectionUtils;

public class ConnectBasic {

	public ConnectBasic() {
		// TODO Auto-generated constructor stub
	}
	static Connection conn;
	static {
		try {
			init();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	public static void init() throws ClassNotFoundException, SQLException {
		conn = ConectionUtils.getSqlConnect();
	}
	

}
