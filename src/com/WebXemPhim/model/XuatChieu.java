package com.WebXemPhim.model;


import java.sql.Time;

public class XuatChieu {

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


	public int getId_PhongChieu() {
		return id_PhongChieu;
	}


	public void setId_PhongChieu(int id_PhongChieu) {
		this.id_PhongChieu = id_PhongChieu;
	}


	public Time getGioChieu() {
		return gioChieu;
	}


	public void setGioChieu(Time gioChieu) {
		this.gioChieu = gioChieu;
	}


	private int id;
	private int id_Phim;

	private int id_PhongChieu;
	private Time gioChieu;
	
	private int soChoNgoiTrong;
	
	
	public XuatChieu() {
		// TODO Auto-generated constructor stub
	}


	public int getSoChoNgoiTrong() {
		return soChoNgoiTrong;
	}


	public void setSoChoNgoiTrong(int soChoNgoiTrong) {
		this.soChoNgoiTrong = soChoNgoiTrong;
	}

}
