package com.WebXemPhim.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.WebXemPhim.model.RapChieu;


public class RapChieuDao extends ConnectBasic {

	@SuppressWarnings({ "unchecked", "unused" })
	public static List<String> getDiaDiem() {
		String sql = "select distinct diaDiem from RapChieu;";
		List<String> listDiaDiem = new ArrayList<>();
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre = conn.prepareStatement(sql);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				listDiaDiem.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return listDiaDiem;
	}
	public static List<String> getLoaiRap(String diaDiem) {
		String sql = "select distinct loai from Rapchieu where diaDiem=?";
		List<String> listLoaiRap = new ArrayList<>();
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, diaDiem);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				listLoaiRap.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return listLoaiRap;

	}

	public static List<String> getRapChieuTheoLoaiVaDiaChi(String loai, String diaDiem) {
		String sql = "select tenRap from Rapchieu where diaDiem=? and loai=?";
		List<String> listTenRap = new ArrayList<>();
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, diaDiem);
			pre.setString(2, loai);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				listTenRap.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return listTenRap;
	}

	public static int getId(String tenRapPhim) {
		String sql = "select id_RapChieu from Rapchieu where tenRap=?";
		int id = -1;
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, tenRapPhim);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return id;
	}

	public static List<RapChieu> getRapChieu()
	{
		 String sql = "select * from SelectRapChieu()";
		 ArrayList<RapChieu> list=null;
		 try
		 {
			 PreparedStatement pre = conn.prepareStatement(sql);
		     ResultSet rs = pre.executeQuery();
		     list = new ArrayList<>();
				 while (rs.next()) {
					 RapChieu rapChieu=new RapChieu();
					
					 rapChieu.setId_RapChieu(rs.getInt(1));		
					 rapChieu.setDiaDiem(rs.getString(2)); 		   
					 rapChieu.setTenRap(rs.getString(4));
					 rapChieu.setLoai(rs.getString(3));
					 list.add(rapChieu);
				 } 
		 }
		 catch(SQLException e)
		 {
			 System.out.println(e.getMessage());
		 }
		return list;
		
	}
	 public static void main(String[] args) throws ClassNotFoundException,
     SQLException {
		for(RapChieu c:getRapChieu())
		{
			System.out.println(c.getId_RapChieu());
		
		}
		
	 }
	public static boolean deleteRapChieu(int idRapChieu) {
		String sql="Exec dbo.DeleteRapChieu ?";
	
			
			
			try {
				PreparedStatement ps=conn.prepareCall(sql);
				ps.setInt(1,idRapChieu);
				return ps.executeUpdate()==1;
				
			}
			catch(SQLException ex) {
				
				System.out.println(ex.getMessage());;
			}
		
		return false;
		
	}
	public static boolean UpdateRapChieu(int id_RapChieu, String diaDiem, String tenRap, String loai) {
		
			String sql="Exec dbo.UpdateRapChieu ?,?,?,?";
			try
			{
				PreparedStatement ps=conn.prepareCall(sql);
				ps.setInt(1,id_RapChieu);
				ps.setString(2, diaDiem);
				ps.setString(3,loai);
				ps.setString(4,tenRap);
			
				return ps.executeUpdate()==1;
			}
			catch (SQLException ex){
				System.out.println(ex.getMessage());
			};
		
		return false;
		
	}
	public static boolean InsertRapChieu(int id_RapChieu, String diaDiem, String tenRap, String loai) {
		
				String sql="exec dbo.InsertRapChieu  ?,?,?,? ";
				
				try
				{
					PreparedStatement ps=conn.prepareCall(sql);
					ps.setInt(1,id_RapChieu);
					ps.setString(2, diaDiem);
					ps.setString(3,loai);
					ps.setString(4,tenRap);
					return ps.executeUpdate()==1;
					
				}
				catch (SQLException ex){
					System.out.println(ex.getMessage());
				};
			return false;
		
	}
	public static String getTenPhongChieu(int idRapChieu) {
		String sql = "select _name from PhongChieu where id_RapChieu=?";
		String tenRap = null;
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, idRapChieu);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				tenRap = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return tenRap;
	}
}
