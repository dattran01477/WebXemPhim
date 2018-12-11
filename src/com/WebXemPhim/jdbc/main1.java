package com.WebXemPhim.jdbc;

import java.beans.Statement;
import java.io.Console;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.WebXemPhim.Dao.ConnectBasic;
import com.WebXemPhim.Dao.PhongChieuDao;
import com.WebXemPhim.Dao.RoleDao;
import com.WebXemPhim.Dao.XuatChieuDao;
import com.WebXemPhim.model.PhongChieu;
import com.WebXemPhim.model.XuatChieu;
import com.google.gson.Gson;

public class main1 extends ConnectBasic {

	public main1() {
		// TODO Auto-generated constructor stub
	}


	@SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		 // init map
		
		/****** Script for SelectTopNRows command from SSMS  ******/
		/*String sql="insert into ChiTietDatVe(id_TaiKhoan,id_XuatChieu,tongGia,chiecKhau,ngayDatVe,ngayXemPhim,sdtDatVe) values (?,?,?,?,?,?,?)";
		try {
			java.sql.Statement statement=conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			pre.setInt(1, 2);
			pre.setInt(2, 25);
			pre.setInt(3, 300000);
			pre.setInt(4, 0);
			pre.setDate(5,new Date(2018-11-18));
			pre.setDate(6,new Date(2018-11-19));
			pre.setString(7, "01232041753");
			
			pre.executeUpdate();
			ResultSet rs = pre.getGeneratedKeys();  
			int key = rs.next() ? rs.getInt(1):0;
			System.out.println(key);
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}*/
	/*	SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm");
		java.util.Date  dateTemp1 = null;
		try {
			dateTemp1 = sdf1.parse("20:30");
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Time sqltime = new java.sql.Time(dateTemp1.getTime());
		XuatChieuDao.addXuatChieu(2,6,sqltime);*/
//		char a='A';
//		for(int i=0;i<26;i++)
//		{
//			String b=String.valueOf((char)(a+i));
//			System.out.println(b);
//		}
		
		System.out.println(PhongChieuDao.getPhongChieu(21).getTenPhongChieu());
	}
	static Connection conn;
	static {
		try {
			init();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	public static void init() throws ClassNotFoundException, SQLException {
		conn = ConectionUtils.getSqlConnect();
	}
}
