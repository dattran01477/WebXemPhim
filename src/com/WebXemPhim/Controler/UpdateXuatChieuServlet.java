package com.WebXemPhim.Controler;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebXemPhim.Dao.XuatChieuDao;

/**
 * Servlet implementation class UpdateXuatChieuServlet
 */
@WebServlet("/UpdateXuatChieuServlet")
public class UpdateXuatChieuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateXuatChieuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id_Phim=request.getParameter("id_Phim");
		String gioChieu=request.getParameter("gioChieu");
		String id_PhongChieu=request.getParameter("id_PhongChieu");
		String id=request.getParameter("id");
		SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm");
		java.util.Date  dateTemp1 = null;
		try {
			dateTemp1 = sdf1.parse(gioChieu);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Time sqltime = new java.sql.Time(dateTemp1.getTime());
		XuatChieuDao.UpdateXuatChieu(Integer.parseInt(id), Integer.parseInt(id_Phim), Integer.parseInt(id_PhongChieu), sqltime);
		 String contextPath=request.getContextPath();
			response.sendRedirect(contextPath+"/TrangQuanLy");
	}

}
