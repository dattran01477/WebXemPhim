package com.WebXemPhim.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PhongChieuDao extends ConnectBasic {

	public PhongChieuDao() {
		// TODO Auto-generated constructor stub
	}
	public static int getIdPhongChieu(int idXC)
	{
		String sql	="select XuatChieu.id_PhongChieu from XuatChieu where XuatChieu.id_XuatChieu=?";
		int id=-1;
		try
		{
			Statement statement=conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setInt(1, idXC);
			ResultSet rs=pre.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
			}
		}
		catch (SQLException e) {
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
