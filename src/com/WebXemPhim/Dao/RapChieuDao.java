package com.WebXemPhim.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.WebXemPhim.jdbc.ConectionUtils;
import com.WebXemPhim.model.RapChieu;

public class RapChieuDao {

	@SuppressWarnings("unused")
	private static Connection conn;
	public RapChieuDao() {
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
	@SuppressWarnings({ "unchecked", "unused" })
	public static List<String> getDiaDiem()
	{
		String sql = "select distinct diaDiem from RapChieu;";
		List<String> listDiaDiem=new ArrayList<>();
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
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
		List<String> listLoaiRap=new ArrayList<>();
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1,diaDiem);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				listLoaiRap.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
		return listLoaiRap;
		
	}
	public static List<String> getRapChieuTheoLoaiVaDiaChi(String loai,String diaDiem)
	{
		String sql = "select tenRap from Rapchieu where diaDiem=? and loai=?";
		List<String> listTenRap=new ArrayList<>();
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1,diaDiem);
			pre.setString(2,loai);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				listTenRap.add(rs.getString(1));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
		return listTenRap;
	}
	public static int getId(String tenRapPhim)
	{
		String sql = "select id_RapChieu from Rapchieu where tenRap=?";
		int id = -1;
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1,tenRapPhim);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				id=rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
		return id;
	}
	public static int getSoHangCuaRap(int idXC)
	{
		String sql="select  count(distinct Ghe.hang) from Ghe,(select PhongChieu.tongSoGheNgoi, PhongChieu.id_PhongChieu from XuatChieu,PhongChieu" + 
				"				where XuatChieu.id_PhongChieu=PhongChieu.id_PhongChieu and XuatChieu.id_XuatChieu=?) as b " + 
				"				where Ghe.id_PhongChieu=b.id_PhongChieu";
		int soHang=0;
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setInt(1,idXC);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				soHang=rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
		return soHang;
	}
	public static int getSoGheCuaRap(int idXC)
	{
		String sql="select PhongChieu.tongSoGheNgoi from XuatChieu,PhongChieu"
				+ " where XuatChieu.id_PhongChieu=PhongChieu.id_PhongChieu and XuatChieu.id_XuatChieu=?";
		int soGhe=0;
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setInt(1,idXC);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				soGhe=rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
		return soGhe;
	}
	public static int getSoCotCuaRap(int idXC)
	{
		String sql="select  count(distinct Ghe.soGhe) from Ghe,(select PhongChieu.tongSoGheNgoi, PhongChieu.id_PhongChieu from XuatChieu,PhongChieu" + 
				"				where XuatChieu.id_PhongChieu=PhongChieu.id_PhongChieu and XuatChieu.id_XuatChieu=?) as b " + 
				"				where Ghe.id_PhongChieu=b.id_PhongChieu";
		int soCot=0;
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setInt(1,idXC);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				soCot=rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
		return soCot;
	}
}
