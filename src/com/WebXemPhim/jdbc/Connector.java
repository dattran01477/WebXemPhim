package com.WebXemPhim.jdbc;

import com.WebXemPhim.model.*;
import com.WebXemPhim.jdbc.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Connector {

	static Connection conn;

	public Connector() throws ClassNotFoundException, SQLException {
		conn = ConectionUtils.getSqlConnect();
	}

	public List<Category> getCategory() throws ClassNotFoundException {
		List<Category> category = new ArrayList<>();
		String sql = "select * from getCategory()";
		Category cate;
		try {

			java.sql.Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				cate = new Category();
				cate.setId(rs.getInt(1));
				cate.setTenDanhMuc(rs.getString(2));
				cate.setMoTa(rs.getString(3));
				category.add(cate);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return category;
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
	public boolean addCategoryFilm(String tenDanhMuc) {
		if(tenDanhMuc==null||tenDanhMuc=="")
		{
			return false;
		}
		else
		{
			String sql = "exec addCategoryFilm '" + tenDanhMuc + "'";
			try {

				java.sql.Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				return true;
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return false;

	}

}
