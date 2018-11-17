package com.WebXemPhim.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.WebXemPhim.jdbc.ConectionUtils;
import com.WebXemPhim.model.Category;
import com.WebXemPhim.model.Film;
import com.WebXemPhim.model.UserAccount;

public  class UserAccountDao {
	static Connection conn;
	private static final Map<String,UserAccount> mapUsers=new HashMap<String,UserAccount>();
	static {
		try {
			init();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	public static void init() throws ClassNotFoundException, SQLException {
		conn = ConectionUtils.getSqlConnect();
	}
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
				while (rs.next()) {
					userTemp = new UserAccount();
					userTemp.setId_Account(rs.getInt(1));
					userTemp.setUser(rs.getString(2));
					role.add(rs.getString(3));
					userTemp.setRoles(role);
					userTemp.setPass(rs.getString(4));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			
			}
			return userTemp;
			
	 }
	 public static boolean addUser(String userName,String pass,String roleName)
	 {
		 
			String sql = "insert into taiKhoan values(?,?,?)";
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

}
