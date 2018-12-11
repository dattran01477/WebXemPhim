package com.WebXemPhim.Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebXemPhim.Dao.RapChieuDao;


/**
 * Servlet implementation class TriRapChieuPhimServlet
 */
@WebServlet("/RapChieuPhim")
public class TriRapChieuPhimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TriRapChieuPhimServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");

		String url = "/Views/TriQuanLyRapChieu.jsp";
		String command = request.getParameter("command");
		try {
			switch (command) {
			case "delete":
				RapChieuDao.deleteRapChieu((Integer.parseInt(id)));
				url = "/Views/TriQuanLyRapChieu.jsp";
				break;
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());

		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		/*
		 * String tenDanhMuc = request.getParameter("tenDanhMuc"); String moTa =
		 * request.getParameter("moTa"); String command=request.getParameter("command");
		 * String id = request.getParameter("id");
		 */
		String command = request.getParameter("command");
		String id_TrangThai = request.getParameter("idRapChieu");
		String diaDiem = request.getParameter("diaDiem");
		String tenRap = request.getParameter("tenRap");
		String loai = request.getParameter("loai");
		String url = "";

		try {
			switch (command) {
			case "update":
				RapChieuDao.UpdateRapChieu(Integer.parseInt(id_TrangThai), diaDiem, tenRap,
						loai);
				url = "RapChieuPhim";
				break;
			case "insert":
				RapChieuDao.InsertRapChieu(diaDiem, tenRap,
						loai);
				url = "RapChieuPhim";
				break;

			}	

		} catch (Exception ex) {

		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
