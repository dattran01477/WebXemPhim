package com.WebXemPhim.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.WebXemPhim.jdbc.ConectionUtils;

public class GheDao {
	static Connection conn;
	public GheDao() {
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
	public static List<String> getListGheDaDat(int XuatChieu,String dateXemPhim)
	{
		String tmp="";
		List<String> listGhe=new ArrayList<>();
		String sql="select hang,soGhe from Ghe,(select id_Ghe from ChiTietDatVe,ChiTietGheNgoi where"
				+ " ChiTietDatVe.id_DatVe=ChiTietGheNgoi.id_DatVe and ChiTietDatVe.id_XuatChieu=? and ChiTietDatVe.ngayXemPhim=?) as b "
				+ "where b.id_Ghe=Ghe.id_Ghe";
		
		//conver datesql
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
		Date  dateTemp = null;
		try {
			dateTemp = sdf1.parse(dateXemPhim);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlDate =new  java.sql.Date(dateTemp.getTime());
		
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setInt(1, XuatChieu);
			pre.setDate(2, sqlDate);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				tmp=rs.getString(1)+"_";
				tmp=tmp+rs.getInt(2);
				listGhe.add(tmp);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
		return listGhe;
	}

}
