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

public class GheDao extends ConnectBasic {
	
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
	public static String getIdGhe(String hang,int soGhe,int idPhong)
	{
		String sql="select id_Ghe from Ghe where hang=? and soGhe=? and id_PhongChieu=?";
		String idGhe=null;
		try {
			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1, hang);
			pre.setInt(2, soGhe);
			pre.setInt(3, idPhong);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				idGhe=rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
		return idGhe;
		
	}
	public static boolean insertGhe(String idGhe,String hang,int soGhe,int idPhongChieu)

	{
		String sql="insert into Ghe values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, idGhe);
			ps.setString(2, hang);
			ps.setInt(3,soGhe );
			ps.setInt(4, idPhongChieu);
			return ps.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		;
		return false;
	}

}
