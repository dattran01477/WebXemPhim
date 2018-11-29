package com.WebXemPhim.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.WebXemPhim.model.PhongChieu;
public class PhongChieuDao extends ConnectBasic {

	public PhongChieuDao() {
		// TODO Auto-generated constructor stub
	}

	public static int getIdPhongChieu(int idXC) {
		String sql = "select XuatChieu.id_PhongChieu from XuatChieu where XuatChieu.id_XuatChieu=?";
		int id = -1;
		try {

			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, idXC);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;

	}

	public static int getSoHangCuaRap(int idXC) {
		String sql = "select  count(distinct Ghe.hang) from Ghe,(select PhongChieu.tongSoGheNgoi, PhongChieu.id_PhongChieu from XuatChieu,PhongChieu"
				+ "				where XuatChieu.id_PhongChieu=PhongChieu.id_PhongChieu and XuatChieu.id_XuatChieu=?) as b "
				+ "				where Ghe.id_PhongChieu=b.id_PhongChieu";
		int soHang = 0;
		try {

			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, idXC);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				soHang = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return soHang;
	}

	public static int getSoGheCuaRap(int idXC) {
		String sql = "select PhongChieu.tongSoGheNgoi from XuatChieu,PhongChieu"
				+ " where XuatChieu.id_PhongChieu=PhongChieu.id_PhongChieu and XuatChieu.id_XuatChieu=?";
		int soGhe = 0;
		try {

			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, idXC);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				soGhe = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return soGhe;
	}

	public static int getSoCotCuaRap(int idXC) {
		String sql = "select  count(distinct Ghe.soGhe) from Ghe,(select PhongChieu.tongSoGheNgoi, PhongChieu.id_PhongChieu from XuatChieu,PhongChieu"
				+ "				where XuatChieu.id_PhongChieu=PhongChieu.id_PhongChieu and XuatChieu.id_XuatChieu=?) as b "
				+ "				where Ghe.id_PhongChieu=b.id_PhongChieu";
		int soCot = 0;
		try {

			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, idXC);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				soCot = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
		return soCot;
	}

	public static List<PhongChieu> getPhongChieu() {

		String sql = "select * from SelectPhongChieu()";
		ArrayList<PhongChieu> list = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			list = new ArrayList<>();

			while (rs.next()) {
				PhongChieu tk = new PhongChieu();

				tk.setIdPhongChieu(rs.getInt(1));
				tk.setTenRapChieu(rs.getString(2));
				tk.setSoGheNgoi(rs.getInt(3));
				tk.setIdRapChieu(rs.getInt(4));
				list.add(tk);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return list;

	}

	public static boolean deletePhongChieu(int id_PhongChieu) {

		String sql = "Exec dbo.DeletePhongChieu ?";
		try {
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setInt(1, id_PhongChieu);
			return ps.executeUpdate() == 1;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return false;

	}

	public static boolean UpdatePhongChieu(int id_PhongChieu, String tenPhongChieu, String tenRap) {

		String sql = "Exec dbo.UpdatePhongChieu ?,?,?,?";
		try {
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setInt(1, id_PhongChieu);
			ps.setString(2, tenPhongChieu);
			ps.setString(3, tenRap);

			return ps.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		;

		return false;

	}

	public static boolean InsertPhongChieu( String tenPhongChieu, String tenRap) {

		String sql = "exec dbo.InsertPhongChieu ?,? ";

		try {
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, tenPhongChieu);
			ps.setString(2, tenRap);

			return ps.executeUpdate() == 1;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		;

		return false;
	}

	public static List<PhongChieu> getPhongChieu(String tenRapChieu) {
		String sql="select * from PhongChieu,Rapchieu where PhongChieu.id_RapChieu=Rapchieu.id_RapChieu  and Rapchieu.tenRap=?";
	List<PhongChieu> list=null;
		try {
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, tenRapChieu);
			ResultSet rs = ps.executeQuery();
			list=new ArrayList<>();
			while (rs.next()) {
			PhongChieu tk = new PhongChieu();	
			tk.setIdPhongChieu(rs.getInt(1));
			tk.setTenPhongChieu(rs.getString(2));
			tk.setSoGheNgoi(rs.getInt(4));
			list.add(tk);
			}

			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		;

		return list;
	}

	public static int getIdPhongChieu(String tenPhongChieu) {
		String sql="select id_PhongChieu from PhongChieu where PhongChieu._name=?";
		int id = -1;
		try {

			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, tenPhongChieu);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return id;
	
	}


}
