package com.WebXemPhim.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.WebXemPhim.jdbc.ConectionUtils;
import com.WebXemPhim.model.Category;

public class CategoryFilm {

	static Connection conn;
	public CategoryFilm() throws ClassNotFoundException, SQLException {
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
