package com.WebXemPhim.Controler;

import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.WebXemPhim.Dao.FilmDao;
import com.WebXemPhim.Dao.RapChieuDao;
import com.WebXemPhim.jdbc.*;
import com.WebXemPhim.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> category = null;
		Connector connector;
		Film flim=null;
		List<Film> filmsDangChieu=null;
		List<Film> filmsChuanBiChieu=null;
		List<String> listKhuVuc=RapChieuDao.getDiaDiem();
		FilmDao FilmUltis = null;
		try {
			FilmUltis = new FilmDao();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connector = new Connector();
			flim =FilmUltis.getFilmHot() ;
			filmsDangChieu=FilmUltis.getFilmDangChieu();
			filmsChuanBiChieu=FilmUltis.getFilmChuanBiChieu();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		request.setAttribute("listDanhMuc", category);
		request.setAttribute("flimHot", flim);
		request.setAttribute("flimsDangChieu", filmsDangChieu);
		request.setAttribute("filmsChuanBiChieu", filmsChuanBiChieu);
		request.setAttribute("listKhuVuc", listKhuVuc);
		
		
		 RequestDispatcher dispatcher //
         = this.getServletContext()//
               .getRequestDispatcher("/ViewsWeb/index.jsp");

		 dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
