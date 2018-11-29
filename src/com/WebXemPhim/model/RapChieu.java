package com.WebXemPhim.model;

public class RapChieu {
	
	public int getId_RapChieu() {
		return id_RapChieu;
	}
	public void setId_RapChieu(int id_RapChieu) {
		
		this.id_RapChieu = id_RapChieu;
	}
	public String getDiaDiem() {
		return diaDiem;
	}
	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public String getTenRap() {
		return tenRap;
	}
	public void setTenRap(String tenRap) {
		this.tenRap = tenRap;
	}
	private int id_RapChieu;
	private String diaDiem;
	private String loai;
	private String tenRap;
	public RapChieu() {
		// TODO Auto-generated constructor stub
	}

}
