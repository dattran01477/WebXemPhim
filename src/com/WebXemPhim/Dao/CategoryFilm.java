package com.WebXemPhim.Dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.WebXemPhim.model.Category;


public class CategoryFilm extends ConnectBasic {

	
	public static List<Category> getCategory() throws ClassNotFoundException {
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
	public static boolean addCategoryFilm(String tenDanhMuc) {
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
	public static int getIdDanhMuc(String tenDanhMuc) {
		if(tenDanhMuc==null||tenDanhMuc=="")
		{
			return -1;
		}
		else
		{
			String sql = "select id_DanhMucPhim from DanhMucPhim where tenDanhMuc='" + tenDanhMuc + "'";
			try {

				java.sql.Statement statement = conn.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while(rs.next())
				{
					return rs.getInt(1);
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return -1;

	}
	public static boolean deleteDanhMucPhim(int id) {
	
			String sql="Exec dbo.DeleteMenuFilm ?";
			try {
				PreparedStatement ps=conn.prepareCall(sql);
				ps.setInt(1,id );
				return ps.executeUpdate()==1;
				
			}
			catch(SQLException ex) {
				
				System.out.println(ex.getMessage());
			}
		
		return false;
		
	}
	public static boolean UpdateDanhMucPhim(int parseInt, String tenDanhMuc, String moTa) {
		String sql="Exec dbo.UpdateMenuFilm ?,?,?";
		try {
			PreparedStatement ps=conn.prepareCall(sql);
			ps.setInt(1,parseInt );
			ps.setString(2,tenDanhMuc);
			ps.setString(3, moTa);
			return ps.executeUpdate()==1;
			
		}
		catch(SQLException ex) {
			
			System.out.println(ex.getMessage());
		}
	
	return false;
		
	}
	public static boolean InsertDanhMucPhim(String tenDanhMuc, String moTa) {
		String sql="Exec dbo.InsertMenuFilm ?,? ";
		try {
			PreparedStatement ps=conn.prepareCall(sql);
			
			ps.setString(1, tenDanhMuc);
			ps.setString(2,moTa);
			
		}
		catch(SQLException ex) {
			
			System.out.println(ex.getMessage());
		}
	
	return false;
		
	}

}
