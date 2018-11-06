package com.WebXemPhim.Dao;

import java.sql.Connection;
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
		conn = ConectionUtils.getSqlConnect();
	}
	public List<XuatChieu> getListXuatChieu() throws ClassNotFoundException {
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
				xc.setDangChieu(rs.getBoolean(3));
				xc.setId_RapChieu(rs.getInt(4));
				XuatChieu.add(xc);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return XuatChieu;
	}
	public XuatChieu getInfoXuatChieu(int id_XuatChieu) {
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
				xc.setDangChieu(rs.getBoolean(3));
				xc.setId_RapChieu(rs.getInt(4));		

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return xc;
	}
}
