package com.WebXemPhim.Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChiTietDatVeDao extends ConnectBasic {

	public ChiTietDatVeDao() {
		// TODO Auto-generated constructor stub
	}
	public static int themChiTietDatVe(int id_XC,int id_TK,int TongGia,
			int ChiecKhau,String maGiaGiam,
			Date ngayDatVe,Date ngayXemPhim,String sdtDatVe)
	{
		int id=-1;
		String sql="insert into ChiTietDatVe(id_TaiKhoan,id_XuatChieu,tongGia,chiecKhau,maGiamGia,ngayDatVe,ngayXemPhim,sdtDatVe) values (?,?,?,?,?,?,?,?)";
		try {
			java.sql.Statement statement=conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			
			pre.setInt(1, id_TK);
			pre.setInt(2, id_XC);
			pre.setInt(3, TongGia);
			pre.setInt(4, ChiecKhau);
			pre.setString(5, maGiaGiam);
			pre.setDate(6,ngayDatVe);
			pre.setDate(7,ngayXemPhim);
			pre.setString(8, sdtDatVe);
			
			pre.executeUpdate();
			ResultSet rs = pre.getGeneratedKeys();  
			id = rs.next() ? rs.getInt(1):0;
			return id;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;
	}
	
}
