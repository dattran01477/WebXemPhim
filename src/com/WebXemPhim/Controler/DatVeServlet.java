package com.WebXemPhim.Controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebXemPhim.Dao.FilmDao;
import com.WebXemPhim.Dao.GheDao;
import com.WebXemPhim.Dao.RapChieuDao;

/**
 * Servlet implementation class DatVeServlet
 */
@WebServlet("/DatVe")
public class DatVeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatVeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FilmDao film = null;
		try {
			film = new FilmDao();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ngayXemPhim=request.getParameter("NgayXemPhim");
		int idXC=Integer.parseInt(request.getParameter("idXC"));
		int idFilm=Integer.parseInt(request.getParameter("idPhim"));
		
		int tongSoGhe=RapChieuDao.getSoGheCuaRap(idXC);
		int soHang=RapChieuDao.getSoHangCuaRap(idXC);
		int soCot=RapChieuDao.getSoCotCuaRap(idXC);
		
		request.setAttribute("ListGheDaDat", GheDao.getListGheDaDat(idXC,ngayXemPhim));
		request.setAttribute("tongGhe",tongSoGhe);
		request.setAttribute("soHang", soHang);
		request.setAttribute("soCot", soCot);
		request.setAttribute("ngayXemPhim", ngayXemPhim);
		request.setAttribute("tenPhim",film.getTenPhim(idFilm));
		request.setAttribute("idFilm", idFilm);
		
		 RequestDispatcher dispatcher //
         = this.getServletContext()//
               .getRequestDispatcher("/ViewsWeb/DatVe.jsp");
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
