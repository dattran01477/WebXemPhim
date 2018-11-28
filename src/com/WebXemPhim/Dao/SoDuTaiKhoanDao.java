package com.WebXemPhim.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SoDuTaiKhoanDao extends ConnectBasic {

	public SoDuTaiKhoanDao() {
		// TODO Auto-generated constructor stub
	}
	public static int getSoDuTk(int idTK)
	{
		String sql = "select soDu from XuTrongTaiKhoan where id_TaiKhoan=?";
		int soDu=0;	
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setInt(1, idTK);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				soDu=rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
		return soDu;
	}
	 public static boolean setSoDu(int soDu,int idTk)
	 {
		 String sql="update XuTrongTaiKhoan set soDu=? where id_TaiKhoan=?";
		 try {
			 Statement statement=conn.createStatement();
			 PreparedStatement pre=conn.prepareStatement(sql);
			 pre.setInt(1, soDu);
			 pre.setInt(2, idTk);
			 pre.execute();
			 return true; 
		 }
		 catch (SQLException e) {
			System.out.println();
		}
		 return false;
	 }
	public static boolean NapXu(String userName, int slXu) {
		
		 String sql="execute NapXu ?,?";
		 try {
			 Statement statement=conn.createStatement();
			 PreparedStatement pre=conn.prepareStatement(sql);
			 pre.setString(1, userName);
			 pre.setInt(2, slXu);
			 pre.execute();
			 return true; 
		 }
		 catch (SQLException e) {
			System.out.println();
		}
		 return false;
	}
}
