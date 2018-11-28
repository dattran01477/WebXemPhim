package com.WebXemPhim.Controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebXemPhim.Dao.CategoryFilm;
import com.WebXemPhim.Dao.FilmDao;
import com.WebXemPhim.Dao.TrangThaiDao;
import com.WebXemPhim.Paramaters.paramaters;
import com.WebXemPhim.model.Category;
import com.WebXemPhim.model.Film;



/**
 * Servlet implementation class UpdateFilm
 */
@WebServlet("/Update")
public class UpdateFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_Film=Integer.parseInt(request.getParameter("id"));
		Film film=FilmDao.getFilm(id_Film);
		//set paramater 
		request.setAttribute("film",film);
		
		 RequestDispatcher dispatcher //
         = this.getServletContext()//
               .getRequestDispatcher("/Views/UpdateFilm.jsp");
		 dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String tieuDe=request.getParameter("tieuDe");  
	String daoDien=request.getParameter("daoDien");
	  String dienVien=request.getParameter("dienVien");
	  String trangThai=request.getParameter("trangThai");
	  String moTa=request.getParameter("moTa");
	  String url_Trailer=request.getParameter("url_Trailer");
	  int doDai=Integer.parseInt(request.getParameter("doDai"));
	  String quocGia=request.getParameter("quocGia");
	  int giaVe=Integer.parseInt(request.getParameter("giaVe"));
	  String tenDanhMuc=request.getParameter("tenDanhMuc[]");
	  String url_Image=request.getParameter("url_Image");
	  String ngayRaMatPhim = request.getParameter("ngayRaMatPhim");
	  int idFilm=Integer.parseInt(request.getParameter("idFilm"));
	  
	  
	  int idDanhMuc=CategoryFilm.getIdDanhMuc(tenDanhMuc);
	  java.sql.Date sqlDate = java.sql.Date.valueOf(ngayRaMatPhim);
	  
	  int doTuoi=Integer.parseInt(request.getParameter("doTuoi"));
	  PrintWriter out =response.getWriter();
	  if(FilmDao.updateFilm(idFilm,tieuDe, daoDien, dienVien, moTa, doDai, sqlDate, doTuoi, trangThai, idDanhMuc,
			  url_Trailer, url_Image, quocGia, giaVe))
	  {
		  out.print("1");
	  }
	  else
	  {
		  out.print("0");
	  }
	}

}
