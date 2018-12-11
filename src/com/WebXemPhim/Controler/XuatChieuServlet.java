package com.WebXemPhim.Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebXemPhim.Dao.CategoryFilm;
import com.WebXemPhim.Dao.FilmDao;
import com.WebXemPhim.Dao.PhongChieuDao;
import com.WebXemPhim.Dao.RapChieuDao;
import com.WebXemPhim.Dao.XuatChieuDao;
import com.WebXemPhim.model.Film;
import com.WebXemPhim.model.XuatChieu;
import com.google.gson.Gson;

/**
 * Servlet implementation class XuatChieu
 */
@WebServlet("/XuatChieu")
public class XuatChieuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XuatChieuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		/*PrintWriter out=response.getWriter();
	
		
		String json = null;
		try {
			json = new Gson().toJson(XuatChieuDao.getListXuatChieu());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(json);*/
		
	
		String command=request.getParameter("command");
		if(command!=null)
		{
			String id = request.getParameter("id");
			XuatChieu inforXuatChieu=XuatChieuDao.getInfoXuatChieu(Integer.parseInt(id));
			Film tenphim=FilmDao.getFilm(inforXuatChieu.getId_Phim());
			request.setAttribute("inforXuatChieu", inforXuatChieu);
			request.setAttribute("tenphim", tenphim);
			String url = "/Views/MainQuanLyLichChieu.jsp";
			try {
				switch(command) {
				case "delete":
					XuatChieuDao.deleteLichChieu((Integer.parseInt(id)));
					//String contextPath=request.getContextPath();
					url="/TrangQuanLy";
					break;
				case "update":
					
					url="/Views/UpdateLichChieu.jsp";
				}

			} catch (Exception ex) {
				System.out.println(ex.getMessage());

			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}
		else
		{
			PrintWriter out=response.getWriter();
			
			
			String json = null;
			try {
				json = new Gson().toJson(XuatChieuDao.getListXuatChieu());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.print(json);
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		  String tenPhongChieu=request.getParameter("tenPhongChieu");
			String tenRapChieu=request.getParameter("tenRapChieu");
			String gioChieuPhim=request.getParameter("gioChieuPhim");
			String tenPhim=request.getParameter("tenPhim");
			
			
			int idPhongChieu=PhongChieuDao.getIdPhongChieu(tenPhongChieu);
			int idRapChieu=RapChieuDao.getId(tenRapChieu);
			int idFilm=FilmDao.getIdFilm(tenPhim);
			//Chuyển đổi giờ
			SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm");
			java.util.Date  dateTemp1 = null;
			try {
				dateTemp1 = sdf1.parse(gioChieuPhim);
			
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Time sqltime = new java.sql.Time(dateTemp1.getTime());
			
			PrintWriter out =response.getWriter();
			boolean isThemXuatChieu=XuatChieuDao.addXuatChieu(idPhongChieu,idFilm,sqltime);
			if(isThemXuatChieu==true)
			{
				out.print("1");
			}
			else
			{
				out.print("0");
			}
			
	}

}
