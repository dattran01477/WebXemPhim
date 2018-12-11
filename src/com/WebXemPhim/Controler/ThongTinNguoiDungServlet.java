  package com.WebXemPhim.Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebXemPhim.Dao.SoDuTaiKhoanDao;
import com.WebXemPhim.Dao.UserAccountDao;
import com.WebXemPhim.model.UserAccount;

/**
 * Servlet implementation class ThongTinNguoiDungServlet
 */
@WebServlet("/InfoUser")
public class ThongTinNguoiDungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongTinNguoiDungServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		UserAccount user=(UserAccount) request.getSession().getAttribute("loginedUser");
		int idTk=user.getId_Account();
		int soDu=SoDuTaiKhoanDao.getSoDuTk(idTk);
		request.setAttribute("soDu", soDu);
		 RequestDispatcher dispatcher //
         = this.getServletContext()//
               .getRequestDispatcher("/Views/MainThongTinCaNhan.jsp");
		 dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String ten=request.getParameter("ten");
		String gioiTinh=request.getParameter("gioiTinh");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String diaChi=request.getParameter("diaChi");
		System.out.println(ten+gioiTinh+email+pass+diaChi+id);
		UserAccountDao.updateTaiKhoan(Integer.parseInt(id), ten, pass, gioiTinh, email, diaChi);
		//Load lai Servlet ListAllStudent
		String contextPath=request.getContextPath();
		response.sendRedirect(contextPath+"/TrangQuanLy");
		
	}

}
