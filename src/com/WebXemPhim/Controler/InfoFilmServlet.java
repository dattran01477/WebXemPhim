package com.WebXemPhim.Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.BooleanLiteral;

import com.WebXemPhim.Dao.DanhGiaDao;
import com.WebXemPhim.Dao.FilmDao;
import com.WebXemPhim.model.DanhGia;
import com.WebXemPhim.model.Film;
import com.google.gson.Gson;

/**
 * Servlet implementation class InfoFilmServlet
 */
@WebServlet("/InfoFilm")
public class InfoFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int page=1;
		if(request.getParameter("page")!=null)
		{
			page=Integer.parseInt(request.getParameter("page"));
		}
		if(page==1)
		{
		int idFilm=Integer.parseInt(request.getParameter("idFilm"));
		getServletContext().setAttribute("idCurrentFilm", idFilm);
		Film film=FilmDao.getFilm(idFilm);
		request.setAttribute("film", film);
		List<DanhGia> danhGiaList=DanhGiaDao.getDanhGia((page-1)*8+1,7,idFilm);
		request.setAttribute("danhGiaList", danhGiaList);
		RequestDispatcher dispatcher //
         = this.getServletContext()//
               .getRequestDispatcher("/ViewsWeb/InfoFilm.jsp");
		 dispatcher.forward(request, response);
		}
		else
		{
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			int idFilm=(int) getServletContext().getAttribute("idCurrentFilm");
			List<DanhGia> danhGiaList=DanhGiaDao.getDanhGia((page-1)*8+1,8,idFilm);
			if(danhGiaList!=null)
			{
				String json = new Gson().toJson(danhGiaList);
				PrintWriter out=response.getWriter();
				out.print(json);
			}
			
		}
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenNguoiDanhGia=request.getParameter("tenNguoiDanhGia");
		String chiTietDanhGia=request.getParameter("chiTietDanhGia");
		int idFim=Integer.parseInt(request.getParameter("idFilm"));
		Boolean isSuccess=DanhGiaDao.addDanhGia(idFim, -1, chiTietDanhGia, tenNguoiDanhGia);
		
		
		PrintWriter out =response.getWriter();
		if(isSuccess==true)
		{
			out.print("1");
		}
		else
		{
			out.print("0");
		}
	}

}
