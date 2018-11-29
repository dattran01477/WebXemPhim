package com.WebXemPhim.Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebXemPhim.Dao.PhongChieuDao;
import com.WebXemPhim.Dao.RapChieuDao;
import com.WebXemPhim.model.PhongChieu;
import com.WebXemPhim.model.RapChieu;
import com.google.gson.Gson;

/**
 * Servlet implementation class GetPhongChieu
 */
@WebServlet("/GetPhongChieu")
public class GetPhongChieu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPhongChieu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		String tenRapChieu=null;
		tenRapChieu=request.getParameter("tenRapChieu");
		List<PhongChieu> phongChieus=PhongChieuDao.getPhongChieu(tenRapChieu);
		String json = new Gson().toJson(phongChieus);
		out.print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
