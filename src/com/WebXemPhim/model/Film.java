package com.WebXemPhim.model;

import java.sql.Date;

import com.WebXemPhim.Dao.CategoryFilm;
import com.WebXemPhim.Dao.TrangThaiDao;

public class Film {

	
	private String tieuDe;
	private int doTuoi;
	private Date ngayRaMatPhim;
	private double diemDanhGia;
	public int getDoTuoi() {
		return doTuoi;
	}
	public void setDoTuoi(int doTuoi) {
		this.doTuoi = doTuoi;
	}
	public double getDiemDanhGia() {
		return diemDanhGia;
	}
	public void setDiemDanhGia(double diemDanhGia) {
		this.diemDanhGia = diemDanhGia;
	}

	private int id;
	private String daoDien;
	private String dienVien;
	private int id_TrangThai;
	private String tenTrangThai;
	private String moTa;
	public String getUrlTrailer() {
		return urlTrailer;
	}
	public void setUrlTrailer(String urlTrailer) {
		this.urlTrailer = urlTrailer;
	}
	public int getGiaVe() {
		return giaVe;
	}
	public void setGiaVe(int giaVe) {
		this.giaVe = giaVe;
	}
	public int getId_DanhMucPhim() {
		return id_DanhMucPhim;
	}
	public void setId_DanhMucPhim(int id_DanhMucPhim) {
		this.id_DanhMucPhim = id_DanhMucPhim;
		this.tenDanhMuc=CategoryFilm.getNameDanhMuc(id_DanhMucPhim);
	}
	public String getUrl_Image() {
		return url_Image;
	}
	public void setUrl_Image(String url_Image) {
		this.url_Image = url_Image;
	}

	private String urlTrailer;
	private int doDai;
	private String quocGia;
	private int giaVe;
	private int id_DanhMucPhim;
	private String tenDanhMuc;
	private String url_Image;
	public String getTieuDe() {
		return tieuDe;
	}
	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	public String getDaoDien() {
		return daoDien;
	}
	public void setDaoDien(String daoDien) {
		this.daoDien = daoDien;
	}
	public String getDienVien() {
		return dienVien;
	}
	public void setDienVien(String dienVien) {
		this.dienVien = dienVien;
	}
	public int getId_TrangThai() {
		return id_TrangThai;
	}
	public void setId_TrangThai(int id_TrangThai) {
		this.id_TrangThai = id_TrangThai;
		this.tenTrangThai=TrangThaiDao.getNameTrangThai(id_TrangThai);
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public int getDoDai() {
		return doDai;
	}
	public void setDoDai(int doDai) {
		this.doDai = doDai;
	}
	public String getQuocGia() {
		return quocGia;
	}
	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Film() {
		// TODO Auto-generated constructor stub
	}
	public Date getNgayRaMatPhim() {
		return ngayRaMatPhim;
	}
	public void setNgayRaMatPhim(Date ngayRaMatPhim) {
		this.ngayRaMatPhim = ngayRaMatPhim;
	}
	public String getTenTrangThai() {
		return tenTrangThai;
	}
	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	

}
