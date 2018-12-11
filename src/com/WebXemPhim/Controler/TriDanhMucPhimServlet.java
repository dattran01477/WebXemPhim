package com.WebXemPhim.Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebXemPhim.Dao.CategoryFilm;

@WebServlet("/DanhMucPhimServlet")
public class TriDanhMucPhimServlet extends HttpServlet {

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		String url = "/Views/TriDanhMucFilm.jsp";
		String command=request.getParameter("command");
		try {
			switch(command) {
			case "delete":
				CategoryFilm.deleteDanhMucPhim((Integer.parseInt(id)));
				String contextPath=request.getContextPath();
				url="/TrangQuanLy";
				break;
				
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());

		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String tenDanhMuc = request.getParameter("tenDanhMuc");
		String moTa = request.getParameter("moTa");
		String command=request.getParameter("command");
		String id = request.getParameter("id");
		String url = "";

		String contextPath;
		try {
			switch(command) {
			case "update":
				CategoryFilm.UpdateDanhMucPhim(Integer.parseInt(id),tenDanhMuc, moTa);
				 contextPath=request.getContextPath();
				response.sendRedirect(contextPath+"/TrangQuanLy");
					break;
			case "insert":
				CategoryFilm.InsertDanhMucPhim(tenDanhMuc, moTa);
				 contextPath=request.getContextPath();
				response.sendRedirect(contextPath+"/TrangQuanLy");
						break;
		
			}
		} catch (Exception ex) {

		}
		

	}

}
