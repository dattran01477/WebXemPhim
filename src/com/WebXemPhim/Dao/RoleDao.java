package com.WebXemPhim.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.WebXemPhim.jdbc.ConectionUtils;
import com.WebXemPhim.model.Role;
import com.WebXemPhim.model.UserAccount;

public class RoleDao {

	static Connection conn;
	public RoleDao() {
		// TODO Auto-generated constructor stub
	}
	static
	{
		try {
			init();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void init() throws ClassNotFoundException, SQLException {
		conn = ConectionUtils.getSqlConnect();
	}
	public static int getIdRole(String roleName)
	{
		String sql = "select id_Role from role where role=?";
		int id_Role=-1;	
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1, roleName);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				id_Role=rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
		return id_Role;
	}

}
