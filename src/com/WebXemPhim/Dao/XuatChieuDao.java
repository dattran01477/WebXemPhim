package com.WebXemPhim.Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.WebXemPhim.model.XuatChieu;

public class XuatChieuDao extends ConnectBasic {

	public static List<XuatChieu> getListXuatChieu() throws ClassNotFoundException {
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
		String sql = "select * from XuatChieu where id_XuatChieu=?";
		XuatChieu xc = null;
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre = conn.prepareStatement(sql);
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

	public static List<XuatChieu> getThongTinListXuatChieuFilm(int id_rap, int id_Phim, Date date) {
		String sql = "select dbo.demSoChoNgoiConTrong(id_XuatChieu,?) as soChoTrong,"
				+ " id_XuatChieu,gioChieu from  PhongChieu,(select * from XuatChieu where id_Phim=?) "
				+ "as b where PhongChieu.id_PhongChieu=b.id_PhongChieu and PhongChieu.id_RapChieu=?";
		List<XuatChieu> xcList = new ArrayList<>();
		XuatChieu xc = null;
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre = conn.prepareStatement(sql);
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

	public static boolean addXuatChieu(int idPhongChieu, int idFilm, Time time) {

		String sql = "insert into XuatChieu values(?,?,?)";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(3, idPhongChieu);
			pre.setInt(1, idFilm);
			pre.setTime(2, time);
			pre.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static boolean deleteLichChieu(int id) {

		String sql = "delete XuatChieu where id_XuatChieu= ?";
		try {
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setInt(1, id);
			return ps.executeUpdate() == 1;

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
		}

		return false;

	}
	public static boolean UpdateXuatChieu(int id,int id_Phim,int id_PhongChieu,Time gioChieu) {

		String sql = "update XuatChieu set id_Phim=? ,id_PhongChieu=?,gioChieu=? where id_XuatChieu=?";
		try {
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setInt(1, id_Phim);
			ps.setInt(2, id_PhongChieu);
			ps.setTime(3, gioChieu);
			ps.setInt(4, id);

			return ps.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		;

		return false;

	}

	
}
