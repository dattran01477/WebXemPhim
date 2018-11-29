package com.WebXemPhim.Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebXemPhim.Dao.PhongChieuDao;

/**
 * Servlet implementation class TriPhongChieuPhimServlet
 */
@WebServlet("/PhongChieuServlet")
public class TriPhongChieuPhimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TriPhongChieuPhimServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		String url = "/Views/TriQuanLyPhongChieu.jsp";
		String command=request.getParameter("command");
		try {
			switch(command) {
			case "delete":
				PhongChieuDao.deletePhongChieu((Integer.parseInt(id)));
				url = "/Views/TriQuanLyPhongChieu.jsp";
				break;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());

		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String tenPhongChieu = request.getParameter("tenPhongChieu");
		String soGheNgoi = request.getParameter("soGheNgoi");
		String tenRap = request.getParameter("tenRap");
		String id = request.getParameter("idRapChieu");
		String command=request.getParameter("command");
		String url = "";
		try {
			switch(command) {
			case "update":
				PhongChieuDao.UpdatePhongChieu(Integer.parseInt(id),tenPhongChieu,tenRap);
					url = "/Views/TriQuanLyPhongChieu.jsp";
					break;
			case "insert":
				PhongChieuDao.InsertPhongChieu(tenPhongChieu,tenRap);
						url = "/Views/TriQuanLyPhongChieu.jsp";
						break;
		
			}

			

		} catch (Exception ex) {

		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
