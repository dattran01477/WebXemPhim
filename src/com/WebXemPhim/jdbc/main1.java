package com.WebXemPhim.jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.WebXemPhim.Dao.XuatChieuDao;
import com.WebXemPhim.model.XuatChieu;

public class main1 {

	public main1() {
		// TODO Auto-generated constructor stub
	}


	@SuppressWarnings("unused")
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		XuatChieuDao xcd=new XuatChieuDao();
		XuatChieu xc=xcd.getInfoXuatChieu(24);
		
		System.out.print(xc.getId());
		

	}

}
