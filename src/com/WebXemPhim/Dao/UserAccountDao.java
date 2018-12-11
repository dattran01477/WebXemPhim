package com.WebXemPhim.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.WebXemPhim.jdbc.ConectionUtils;
import com.WebXemPhim.model.Category;
import com.WebXemPhim.model.Film;
import com.WebXemPhim.model.UserAccount;



public  class UserAccountDao extends ConnectBasic{
	
	private static final Map<String,UserAccount> mapUsers=new HashMap<String,UserAccount>();
	
	
	 /*private static void init()
	 {
		 List<String> role1=new ArrayList<String>();
		 role1.add("ad");
		 role1.add("cu");
		 List<String> role2=new ArrayList<String>();
		 role2.add("cu");
		 UserAccount user1=new UserAccount("ThanhDat","12345",role1);
		 UserAccount user2=new UserAccount("Van","12345", role2);
		 mapUsers.put(user1.getUser(), user1);
		 mapUsers.put(user2.getUser(), user2);
	 }*/
	 @SuppressWarnings({ "null", "unused" })
	public static UserAccount findAcc(String userName,String pass)
	 {
		 
			String sql = "select * from taikhoan where tenDangNhap=? and matKhau=?";
			UserAccount userTemp=null;
			List<String> role=new ArrayList<>();
			role.add("cu");
			try {

				java.sql.Statement statement = conn.createStatement();
				PreparedStatement pre=conn.prepareStatement(sql);
				pre.setString(1, userName);
				pre.setString(2,pass);
				ResultSet rs = pre.executeQuery();
				int idTK=-1;
				int soDu=0;
				while (rs.next()) {
					userTemp = new UserAccount();
					userTemp.setId_Account(rs.getInt(1));
					idTK=rs.getInt(1);
					soDu=SoDuTaiKhoanDao.getSoDuTk(idTK);
					userTemp.setUser(rs.getString(2));
					
					//nếu chức vụ là ad thì mới thêm thêm  2 là id của role ad
					if(rs.getInt(3)==2)
					{
						role.add(RoleDao.getNameRole(rs.getInt(3)));
					}
					userTemp.setRoles(role);
					userTemp.setPass(rs.getString(4));
					userTemp.setTen(rs.getString(5));
					userTemp.setTuoi(rs.getInt(6));
					userTemp.setGioiTinh(rs.getString(7));
					userTemp.setSdt(rs.getString(8));
					userTemp.setDiaChi(rs.getString(9));
					userTemp.setEmail(rs.getString(10));
					userTemp.setSoDuTK(soDu);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			
			}
			return userTemp;
			
	 }
	 public static boolean addUser(String userName,String pass,String roleName)
	 {
		 
			String sql = "insert into taiKhoan(tenDangNhap,id_role,matKhau) values(?,?,?)";
			int id_Role=RoleDao.getIdRole(roleName);
			
			
			if(id_Role!=-1)
			{
				try {

					java.sql.Statement statement = conn.createStatement();
					PreparedStatement pre=conn.prepareStatement(sql);
					pre.setString(1, userName);
					pre.setString(3,pass);
					pre.setInt(2, id_Role);
					pre.execute(); 
						return true;
					
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				
				}
			}
			
			return false;
			
	 }
	 public static int getSoDuTK(int idTK)
	 {
		 String sql="select soDu from XuTrongTaiKhoan where id_TaiKhoan=?";
		 int soDu=0;
		 try {
			 Statement statement=conn.createStatement();
			 PreparedStatement pre=conn.prepareStatement(sql);
			 pre.setInt(1, idTK);
			 ResultSet rs=pre.executeQuery();
			 while(rs.next())
			 {
				 soDu=rs.getInt(1);
			 }
		 }
		 catch (SQLException e) {
			System.out.println();
		}
		 return soDu;
	 }
	 public static boolean updateTaiKhoan(int id,String hoTen,String matKhau,String gioiTinh,String email,String diaChi)
		{
			String sql = "update taiKhoan set hoTen=?,matKhau=?,gioiTinh=?,email=?,diaChi=? where id_TaiKhoan= ?";
			
		

			try {
				
				java.sql.Statement statement = conn.createStatement();
				PreparedStatement pre=conn.prepareStatement(sql);
				pre.setString(1,hoTen);
				pre.setString(2,matKhau);
				pre.setString(3,gioiTinh);
				pre.setString(4,email);
				pre.setString(5,diaChi);
				pre.setInt(6, id);
			
				 return pre.executeUpdate()==1;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;

		}
	

}
