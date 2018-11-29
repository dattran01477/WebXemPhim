package com.WebXemPhim.Dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class TrangThaiDao  extends ConnectBasic {
	
	public static List<String> getAllTenTrangThai()
	{
		String sql = "select tenTrangThai from TrangThai";
		List<String> tenTrangThaiList=new ArrayList<>();
	
		try {

			@SuppressWarnings("unused")
			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				tenTrangThaiList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
		return tenTrangThaiList;	
	}
	public static int getIdTrangThai(String nameTrangThai)
	{
		String sql = "select id_TrangThai from TrangThai where tenTrangThai=?";
		int id_TrangThai=-1;	
		try {

			@SuppressWarnings("unused")
			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1, nameTrangThai);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				id_TrangThai=rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
		return id_TrangThai;
	}
	public static String getNameTrangThai(int id_TrangThai)
	{
		String sql = "select tenTrangThai from TrangThai where id_TrangThai=?";
		String nameTrangThai=null;	
		try {

			@SuppressWarnings("unused")
			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setInt(1, id_TrangThai);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				nameTrangThai=rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
		return nameTrangThai;
	}

}
