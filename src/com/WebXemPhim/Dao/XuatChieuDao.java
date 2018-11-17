package com.WebXemPhim.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.WebXemPhim.jdbc.ConectionUtils;
import com.WebXemPhim.model.Category;
import com.WebXemPhim.model.XuatChieu;

public class XuatChieuDao {

	static Connection conn;
	public XuatChieuDao() throws ClassNotFoundException, SQLException {
		
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
	public  static List<XuatChieu> getListXuatChieu() throws ClassNotFoundException {
		List<XuatChieu> XuatChieu = new ArrayList<>();
		String sql = "select * from getXuatChieu()";
		XuatChieu xc;
		try {

			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				xc = new XuatChieu();
				xc.setId(rs.getInt(1));
				xc.setId_Phim(rs.getInt(2));
			
				xc.setGioChieu(rs.getTime(3));
				xc.setId_PhongChieu(rs.getInt(4));
				XuatChieu.add(xc);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return XuatChieu;
	}
	public static XuatChieu getInfoXuatChieu(int id_XuatChieu) {
		String sql = "select * from XuatChieu where id=?";
		XuatChieu xc = null;
		try {
			
			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setInt(1, id_XuatChieu);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				xc = new XuatChieu();
				xc.setId(rs.getInt(1));
				xc.setId_Phim(rs.getInt(2));
				xc.setGioChieu(rs.getTime(3));
				xc.setId_PhongChieu(rs.getInt(4));	

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return xc;
	}

	public  static List<XuatChieu> getThongTinListXuatChieuFilm(int id_rap,int id_Phim,Date date)
	{
		String sql = "select dbo.demSoChoNgoiConTrong(id_XuatChieu,?) as soChoTrong,"
				+ " id_XuatChieu,gioChieu from  PhongChieu,(select * from XuatChieu where id_Phim=?) "
				+ "as b where PhongChieu.id_PhongChieu=b.id_PhongChieu and PhongChieu.id_RapChieu=?";
		List<XuatChieu> xcList = new ArrayList<>();
		XuatChieu xc=null;
		try {
			
			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setDate(1, date);
			pre.setInt(2, id_Phim);
			pre.setInt(3, id_rap);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				xc = new XuatChieu();
				xc.setSoChoNgoiTrong(rs.getInt(1));
				xc.setId(rs.getInt(2));
				xc.setGioChieu(rs.getTime(3));	
				xcList.add(xc);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return xcList;
	}
}
