package com.WebXemPhim.Dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.WebXemPhim.model.Film;

public class FilmDao extends ConnectBasic {

	
	public static List<Film> getFilm(int firstResult, int amountResult)
	{
		List<Film> films = new ArrayList<>();
		String sql = "select  * from(SELECT *, ROW_NUMBER() OVER (ORDEr  BY id_Phim) as Roww FROM Phim)  "
				+ "as result where result.Roww between "+firstResult+" and "+(firstResult+amountResult)+"";
		Film film;
		
		try {

			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				film = new Film();
				film.setId(rs.getInt(1));
				film.setTieuDe(rs.getString(2));
				film.setDaoDien(rs.getString(3));
				film.setDienVien(rs.getString(4));
				film.setId_TrangThai(rs.getInt(5));
				film.setMoTa(rs.getString(6));
				film.setUrlTrailer(rs.getString(7));
				film.setDoDai(rs.getInt(8));
				film.setQuocGia(rs.getString(9));
				film.setGiaVe(rs.getInt(10));
				film.setId_DanhMucPhim(rs.getInt(11));
				film.setUrl_Image(rs.getString(12));
				film.setDoTuoi(rs.getInt(13));
				film.setDiemDanhGia(rs.getFloat(14));		
				films.add(film);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return films;
	}
	public static boolean deleteFilm(int id_film)
	{
		String sql = "delete from Phim where id_Phim=?";
		Film film;
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setInt(1, id_film);
			ResultSet rs = pre.executeQuery();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	
	}
	public static int CountFilm()
	{
		int count=0;
		String sql = "select count(id_Phim) from Phim";
		try {

			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				count=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return count;
	}
	public static List<Film> getFilmDangChieu()
	{
		List<Film> films =new ArrayList<>();
		String sql = "select * from Phim where id_TrangThai=9";
		Film film=null;
		try {

			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				film = new Film();
				film.setId(rs.getInt(1));
				film.setTieuDe(rs.getString(2));
				film.setDaoDien(rs.getString(3));
				film.setDienVien(rs.getString(4));
				film.setId_TrangThai(rs.getInt(5));
				film.setMoTa(rs.getString(6));
				film.setUrlTrailer(rs.getString(7));
				film.setDoDai(rs.getInt(8));
				film.setQuocGia(rs.getString(9));
				film.setGiaVe(rs.getInt(10));
				film.setId_DanhMucPhim(rs.getInt(11));
				film.setUrl_Image(rs.getString(12));
			
				films.add(film);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return films;
	}
	public static List<Film> getFilmChuanBiChieu()
	{
		List<Film> films =new ArrayList<>();
		String sql = "select * from Phim where id_TrangThai=10";
		Film film=null;
		try {

			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				film = new Film();
				film.setId(rs.getInt(1));
				film.setTieuDe(rs.getString(2));
				film.setDaoDien(rs.getString(3));
				film.setDienVien(rs.getString(4));
				film.setId_TrangThai(rs.getInt(5));
				film.setMoTa(rs.getString(6));
				film.setUrlTrailer(rs.getString(7));
				film.setDoDai(rs.getInt(8));
				film.setQuocGia(rs.getString(9));
				film.setGiaVe(rs.getInt(10));
				film.setId_DanhMucPhim(rs.getInt(11));
				film.setUrl_Image(rs.getString(12));
			
				films.add(film);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return films;
	}
	public static Film getFilm(int idFilm)
	{
		String sql="select * from Phim where id_Phim=?";
		Film film =null;
		try {
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setInt(1, idFilm);
			
			ResultSet rs=pre.executeQuery();
			while(rs.next())
			{
				film = new Film();
				film.setId(rs.getInt(1));
				film.setTieuDe(rs.getString(2));
				film.setDaoDien(rs.getString(3));
				film.setDienVien(rs.getString(4));
				film.setId_TrangThai(rs.getInt(5));
				film.setMoTa(rs.getString(6));
				film.setUrlTrailer(rs.getString(7));
				film.setDoDai(rs.getInt(8));
				film.setQuocGia(rs.getString(9));
				film.setGiaVe(rs.getInt(10));
				film.setId_DanhMucPhim(rs.getInt(11));
				film.setUrl_Image(rs.getString(12));
				film.setDoTuoi(rs.getInt(13));
				film.setNgayRaMatPhim(rs.getDate(15));
			}
			
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return film;
	}
	public static Film getFilmHot()
	{
	
		String sql = "select * from Phim where id_TrangThai=8";
		Film film=null;
		try {

			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				film = new Film();
				film.setId(rs.getInt(1));
				film.setTieuDe(rs.getString(2));
				film.setDaoDien(rs.getString(3));
				film.setDienVien(rs.getString(4));
				film.setId_TrangThai(rs.getInt(5));
				film.setMoTa(rs.getString(6));
				film.setUrlTrailer(rs.getString(7));
				film.setDoDai(rs.getInt(8));
				film.setQuocGia(rs.getString(9));
				film.setGiaVe(rs.getInt(10));
				film.setId_DanhMucPhim(rs.getInt(11));
				film.setUrl_Image(rs.getString(12));
			
				

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return film;
	}
	public static boolean addFilm(String tieuDe,String daoDien,String dienVien,String moTa,int doDai,Date ngayRaMat
			,int doTuoi,String TrangThai,int  id_DanhMuc,String url_TraiLer,String url_Image,String quocGia,
			int giaVe)
	{
		
		
		 String sql="insert into Phim(tieuDe,daoDien,dienVien,id_TrangThai,moTa,url_TraiLer,doDai,"
			  		+ "quocGia,giaVe,id_DanhMucPhim,image,doTuoi,ngayRaMatFilm) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		 int id_TrangThai=TrangThaiDao.getIdTrangThai(TrangThai);
		 java.sql.Date sqlStartDate = new java.sql.Date(ngayRaMat.getTime()); 
			
			if(id_TrangThai!=-1)
			{
				try {

					java.sql.Statement statement = conn.createStatement();
					PreparedStatement pre=conn.prepareStatement(sql);
					pre.setString(1, tieuDe);
					pre.setString(2, daoDien);
					pre.setString(3, dienVien);
					pre.setInt(4, id_TrangThai);
					pre.setString(5, moTa);
					pre.setString(6, url_TraiLer);
					pre.setInt(7, doDai);
					pre.setString(8, quocGia);
					pre.setInt(9, giaVe);
					pre.setInt(10, id_DanhMuc);
					pre.setString(11, url_Image);
					pre.setInt(12, doTuoi);
					pre.setDate(13, sqlStartDate);
					pre.execute(); 
					System.out.println("ThanhCong");
						return true;
					
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				
				}
			}
			
			return false;
	
		
	}
	public static String getTenPhim(int idFilm)
	{
		String sql = "select tieuDe from Phim where id_Phim=?";
		String name="";	
		try {

			java.sql.Statement statement = conn.createStatement();
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setInt(1, idFilm);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				name=rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		
		}
		return name;
	}
	public static boolean updateFilm(int idFilm, String tieuDe, String daoDien, String dienVien, String moTa, int doDai,
			java.sql.Date sqlDate, int doTuoi, String trangThai, int id_DanhMuc, String url_Trailer, String url_Image,
			String quocGia, int giaVe) {
		 String sql="update  Phim	set tieuDe=?,daoDien=?,dienVien=?,id_TrangThai=?,moTa=?,url_TraiLer=?,doDai=?,"
			  		+ "quocGia=?,giaVe=?,id_DanhMucPhim=?,image=?,doTuoi=?,ngayRaMatFilm=?  where id_Phim=? ";
		 int id_TrangThai=TrangThaiDao.getIdTrangThai(trangThai);
		 java.sql.Date sqlStartDate = new java.sql.Date(sqlDate.getTime()); 
			
			if(id_TrangThai!=-1&&id_DanhMuc!=-1)
			{
				try {

					java.sql.Statement statement = conn.createStatement();
					PreparedStatement pre=conn.prepareStatement(sql);
					pre.setString(1, tieuDe);
					pre.setString(2, daoDien);
					pre.setString(3, dienVien);
					pre.setInt(4, id_TrangThai);
					pre.setString(5, moTa);
					pre.setString(6, url_Trailer);
					pre.setInt(7, doDai);
					pre.setString(8, quocGia);
					pre.setInt(9, giaVe);
					pre.setInt(10, id_DanhMuc);
					pre.setString(11, url_Image);
					pre.setInt(12, doTuoi);
					pre.setDate(13, sqlStartDate);
					pre.setInt(14, idFilm);
					pre.execute(); 
					System.out.println("ThanhCong");
					return true;
					
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				
				}
			}
			
			return false;
	
	}

}
