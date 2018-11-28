package com.WebXemPhim.Controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebXemPhim.Dao.FilmDao;


/**
 * Servlet implementation class AddFilmServlet
 */
@WebServlet("/AddFilm")
public class AddFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String tieuDe=request.getParameter("tieuDe");  
			String daoDien=request.getParameter("daoDien");
		  String dienVien=request.getParameter("dienVien");
		  String trangThai=request.getParameter("trangThai[]");
		  String moTa=request.getParameter("moTa");
		  String url_Trailer=request.getParameter("url_Trailer");
		  int doDai=Integer.parseInt(request.getParameter("doDai"));
		  String quocGia=request.getParameter("quocGia[]");
		  int giaVe=Integer.parseInt(request.getParameter("giaVe"));
		  String tenDanhMuc=request.getParameter("tenDanhMuc");
		  String url_Image=request.getParameter("url_Image");
		  String ngayRaMatPhim = request.getParameter("ngayRaMatPhim");
		  
		  java.sql.Date sqlDate = java.sql.Date.valueOf(ngayRaMatPhim);
		
		
		
		  int doTuoi=Integer.parseInt(request.getParameter("doTuoi"));
		  FilmDao filmDao = null;
		  filmDao=new FilmDao();
		  PrintWriter out =response.getWriter();
		  if(FilmDao.addFilm(tieuDe, daoDien, dienVien, moTa, doDai, sqlDate, doTuoi, trangThai, 2,
				  url_Trailer, url_Image, quocGia, giaVe))
		  {
			  out.print("1");
		  }
		  else
		  {
			  out.print("0");
		  }
		  
		 
		  
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
