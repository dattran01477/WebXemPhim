package com.WebXemPhim.Dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.WebXemPhim.model.Role;

public class RoleDao  extends ConnectBasic {

	
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
	public static String getNameRole(int idrole)
	{
		String sql = "select role from role where id_Role=?";
		String name=null;	
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setInt(1, idrole);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				name=rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
		return name;
	}

}
