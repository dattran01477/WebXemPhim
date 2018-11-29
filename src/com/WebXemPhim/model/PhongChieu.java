package com.WebXemPhim.model;

import com.WebXemPhim.Dao.RapChieuDao;

public class PhongChieu {
	private int idPhongChieu;
	private String tenPhongChieu;
	private String tenRapChieu;
	private int idRapChieu;
	private int soGheNgoi;
	public PhongChieu() {
		// TODO Auto-generated constructor stub
	}
	public String getTenPhongChieu() {
		return tenPhongChieu;
	}
	public int getIdPhongChieu() {
		return idPhongChieu;
	}
	public void setIdPhongChieu(int idPhongChieu) {
		this.idPhongChieu = idPhongChieu;
		
	}
	public int getIdRapChieu() {
		return idRapChieu;
	}
	public void setIdRapChieu(int idRapChieu) {
		this.idRapChieu = idRapChieu;
		this.tenRapChieu=RapChieuDao.getTenPhongChieu(idRapChieu);
	}
	public int getSoGheNgoi() {
		return soGheNgoi;
	}
	public void setSoGheNgoi(int soGheNgoi) {
		this.soGheNgoi = soGheNgoi;
	}
	public void setTenPhongChieu(String tenPhongChieu) {
		this.tenPhongChieu = tenPhongChieu;
	}
	public String getTenRapChieu() {
		return tenRapChieu;
	}
	public void setTenRapChieu(String tenRapChieu) {
		this.tenRapChieu = tenRapChieu;
	}
	

}
