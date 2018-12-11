package com.WebXemPhim.model;

import java.util.ArrayList;
import java.util.List;

import com.WebXemPhim.Dao.SoDuTaiKhoanDao;

public class UserAccount {
	public UserAccount() {
	}
	
	public UserAccount(String user, String pass, List<String> roles) {
		super();
		this.user = user;
		this.pass = pass;
		this.roles=new ArrayList<String>();
		this.roles = roles;
	}
	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	private String ten;
	private int tuoi;
	private String sdt;
	private String gioiTinh;
	private String diaChi;
	private int id_Account;
	private String user;
	private int soDuTK;
	private String email;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public int getId_Account() {
		return id_Account;
	}
	public void setId_Account(int id_Account) {
		this.id_Account = id_Account;
		this.setSoDuTK(SoDuTaiKhoanDao.getSoDuTk(id_Account));
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public int getSoDuTK() {
		return soDuTK;
	}

	public void setSoDuTK(int soDuTK) {
		this.soDuTK = soDuTK;
	}
	private String pass;
	private List<String> roles;

}
