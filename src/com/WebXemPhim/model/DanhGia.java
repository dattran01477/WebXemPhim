package com.WebXemPhim.model;

import java.sql.Date;


public class DanhGia  {

	
	private int id_DanhGia;
	private int id_Phim;
	private int id_TaiKhoan;
	public int getId_DanhGia() {
		return id_DanhGia;
	}
	public void setId_DanhGia(int id_DanhGia) {
		this.id_DanhGia = id_DanhGia;
	}
	public int getId_Phim() {
		return id_Phim;
	}
	public void setId_Phim(int id_Phim) {
		this.id_Phim = id_Phim;
	}
	public int getId_TaiKhoan() {
		return id_TaiKhoan;
	}
	public void setId_TaiKhoan(int id_TaiKhoan) {
		this.id_TaiKhoan = id_TaiKhoan;
	}
	public String getChiTietDanhGia() {
		return chiTietDanhGia;
	}
	public void setChiTietDanhGia(String chiTietDanhGia) {
		this.chiTietDanhGia = chiTietDanhGia;
	}
	public String getTenKhachDanhGia() {
		return tenKhachDanhGia;
	}
	public void setTenKhachDanhGia(String tenKhachDanhGia) {
		this.tenKhachDanhGia = tenKhachDanhGia;
	}
	public Date getThoiGianDanhGia() {
		return thoiGianDanhGia;
	}
	public void setThoiGianDanhGia(Date thoiGianDanhGia) {
		this.thoiGianDanhGia = thoiGianDanhGia;
	}
	private String chiTietDanhGia;
	private String tenKhachDanhGia;
	private Date thoiGianDanhGia;
	public DanhGia() {
		// TODO Auto-generated constructor stub
	}
	

}
