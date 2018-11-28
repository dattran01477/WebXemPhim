package com.WebXemPhim.Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChiTietGheNgoiDao extends ConnectBasic {

	public ChiTietGheNgoiDao() {
		// TODO Auto-generated constructor stub
	}
	public static int themChiTietGheNgoi(String id_Ghe,int id_DatVe)
	{
		String sql="insert into ChiTietGheNgoi(id_Ghe,id_DatVe) values(?,?)";
		try
		{
			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1, id_Ghe);
			pre.setInt(2, id_DatVe);
			pre.execute();
			return 1;
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

}
