package com.WebXemPhim.model;


import java.sql.Time;

public class XuatChieu {

	private int id;
	private int id_Phim;
	private boolean isDangChieu;
	private int id_RapChieu;
	private Time thoiGianChieu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_Phim() {
		return id_Phim;
	}
	public void setId_Phim(int id_Phim) {
		this.id_Phim = id_Phim;
	}
	public boolean isDangChieu() {
		return isDangChieu;
	}
	public void setDangChieu(boolean isDangChieu) {
		this.isDangChieu = isDangChieu;
	}
	public int getId_RapChieu() {
		return id_RapChieu;
	}
	public void setId_RapChieu(int id_RapChieu) {
		this.id_RapChieu = id_RapChieu;
	}
	public Time getThoiGianChieu() {
		return thoiGianChieu;
	}
	public void setThoiGianChieu(Time thoiGianChieu) {
		this.thoiGianChieu = thoiGianChieu;
	}
	
	public XuatChieu() {
		// TODO Auto-generated constructor stub
	}

}
