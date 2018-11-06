package com.WebXemPhim.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.WebXemPhim.jdbc.ConectionUtils;
import com.WebXemPhim.model.Film;

public class FilmDao {

	static Connection conn;
	public FilmDao() throws ClassNotFoundException, SQLException {
		conn = ConectionUtils.getSqlConnect();
	}
	public List<Film> getFilm(int firstResult, int amountResult)
	{
		List<Film> films = new ArrayList<>();
		String sql = "select  * from(SELECT *, ROW_NUMBER() OVER (ORDEr  BY id) as Roww FROM Phim)  "
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
				film.setDoDai(rs.getInt(7));
			
				films.add(film);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return films;
	}
	public boolean deleteFilm(int id_film)
	{
		String sql = "delete from Phim where id=?";
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
	public int CountFilm()
	{
		int count=0;
		String sql = "select count(id) from Phim";
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

}
