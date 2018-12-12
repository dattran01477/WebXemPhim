package com.WebXemPhim.Controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.WebXemPhim.Dao.SoDuTaiKhoanDao;
import com.WebXemPhim.model.UserAccount;

/**
 * Servlet implementation class NapXuCu
 */
@WebServlet("/NapXuCu")
public class NapXuCu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NapXuCu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codeDefault="napthoaimai2018";
		
		// TODO Auto-generated method stub
		HttpSession sess=request.getSession();
		UserAccount user=(UserAccount) sess.getAttribute("loginedUser");
		String maCode=(String)request.getParameter("maCode");
		int slXu=Integer.parseInt(request.getParameter("slXu"));
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		
		
		
		if(maCode.equals(codeDefault))
		{
			
			boolean isSuccess  =SoDuTaiKhoanDao.NapXu(user.getUser(),slXu);
				if(isSuccess)
				{
					
					out.print("Nạp Xu Thành Công");
				}
				else
				{
					out.println("Nạp Xu Thất Bại");
				}
		}
		else
		{
			out.println("Mã Code Sai!");
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
