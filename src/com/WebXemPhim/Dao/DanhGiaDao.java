package com.WebXemPhim.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.WebXemPhim.model.DanhGia;

public class DanhGiaDao extends ConnectBasic {

	public DanhGiaDao() {
		// TODO Auto-generated constructor stub
	}
	public static List<DanhGia> getDanhGia(int firstResult, int amountResult,int idFilm)
	{
		List<DanhGia> danhGiaList=new ArrayList<>();
		DanhGia danhGia=null;
		String sql="select  * from(SELECT *, ROW_NUMBER() OVER (ORDEr  BY id_DanhGia) as Roww FROM DanhGia where id_Phim=?) "
				+ "as result where result.Roww between ? and ? ";
		
		try
		{
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setInt(2, firstResult);
			pre.setInt(3, firstResult+amountResult);
			pre.setInt(1, idFilm);
			ResultSet rs=pre.executeQuery();
			while(rs.next())
			{
				danhGia=new DanhGia();
				danhGia.setId_DanhGia(rs.getInt(1));
				danhGia.setId_Phim(rs.getInt(2));
				danhGia.setId_TaiKhoan(rs.getInt(3));
				danhGia.setChiTietDanhGia(rs.getString(4));
				danhGia.setTenKhachDanhGia(rs.getString(5));
				danhGia.setThoiGianDanhGia(rs.getDate(6));
				danhGiaList.add(danhGia);
			}
			
			
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return danhGiaList;
	}
	public static boolean addDanhGia(int idFim,int idTaiKhoan,String chiTietDanhGia,String tenKhachDanhGia)
	{
		/*-----chuyen doi thoi gian-------*/
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm");  
		String currentDate=dtf.format((LocalDateTime.now())) ;

		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy hh:mm");
		java.util.Date  dateTemp1 = null;
		try {
			dateTemp1 = sdf1.parse(currentDate);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date currentSqlDate =new  java.sql.Date(dateTemp1.getTime());
		/*end*/
		String sql=null;
		if(idTaiKhoan==-1)
		{
			sql="insert into DanhGia(id_Phim,chiTietDanhGia,tenKhachDanhGia,thoiGianDanhGia)"
					+ " values(?,?,?,?)";
			try {
				PreparedStatement pre=conn.prepareStatement(sql);
				pre.setInt(1,idFim);
				pre.setString(2, chiTietDanhGia);
				pre.setString(3, tenKhachDanhGia);
				pre.setDate(4,currentSqlDate);
				pre.execute();
				return true;
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		else
		{
			sql="insert into DanhGia(id_Phim,chiTietDanhGia,tenKhachDanhGia,thoiGianDanhGia,id_TaiKhoan)"
					+ " values(?,?,?,?,?)";
			try {
				PreparedStatement pre=conn.prepareStatement(sql);
				pre.setInt(1,idFim);
				pre.setString(2, chiTietDanhGia);
				pre.setString(3, tenKhachDanhGia);
				pre.setDate(4,currentSqlDate);
				pre.setInt(5, idTaiKhoan);
				pre.execute();
				return true;
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return false;
	
	}

}
