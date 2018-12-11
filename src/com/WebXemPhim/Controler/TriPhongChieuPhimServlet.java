package com.WebXemPhim.Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebXemPhim.Dao.GheDao;
import com.WebXemPhim.Dao.PhongChieuDao;
import com.WebXemPhim.Dao.RapChieuDao;

/**
 * Servlet implementation class TriPhongChieuPhimServlet
 */
@WebServlet("/PhongChieu")
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
				url = "/TrangQuanLy";
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
				int soHang=Integer.parseInt(request.getParameter("soHang"));
				int soCot=Integer.parseInt(request.getParameter("soCot"));
				int idRapChieu=RapChieuDao.getId(tenRap);
			
				int idPhongChieuInsert=PhongChieuDao.InsertPhongChieu(tenPhongChieu,idRapChieu);
				if(idPhongChieuInsert!=-1)
				{
					char a='A';
					int count=1;
				String	namePhongChieu=PhongChieuDao.getPhongChieu(idPhongChieuInsert).getTenPhongChieu();
				for(int i=0;i<soHang;i++)
					for(int j=0;j<soCot;j++)
					{
						String hang=String.valueOf((char)(a+i));
						GheDao.insertGhe(namePhongChieu+count,hang,j, idPhongChieuInsert);
						count=count+1;
					}
					
				}
						url = "/TrangQuanLy";
						break;
		
			}

			

		} catch (Exception ex) {

		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
