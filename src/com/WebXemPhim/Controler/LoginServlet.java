package com.WebXemPhim.Controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({"/Login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher dispatcher //
         = this.getServletContext().getRequestDispatcher("/ViewsWeb/loginView.jsp");

		 	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String password=request.getParameter("passWord");
		com.WebXemPhim.model.UserAccount userAccount=com.WebXemPhim.Dao.UserAccountDao.findAcc(userName,password);
		
		if(userAccount==null)
		{
			String error="Đăng nhập không thành công";
			request.setAttribute("error", error);
			RequestDispatcher dispatcher //
            = this.getServletContext().getRequestDispatcher("/ViewsWeb/loginView.jsp");
			dispatcher.forward(request, response);
	            return;
		}
		com.WebXemPhim.AppUtils.AppUtils.storeLoginedUser(request.getSession(), userAccount);
		  int redirectId = -1;
	        try {
	            redirectId = Integer.parseInt(request.getParameter("redirectId"));
	        } catch (Exception e) {
	        }
	        String requestUri = com.WebXemPhim.AppUtils.AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
	        if (requestUri != null) {
	        	 RequestDispatcher dispatcher //
	             = this.getServletContext()//
	                   .getRequestDispatcher("/DatVe?idPhim=9&idXC=25&NgayXemPhim=11/15/2018");

	    		 dispatcher.forward(request, response);
	        } else {
	            // Mặc định sau khi đăng nhập thành công
	            // chuyển hướng về trang /userInfo
	        	
	            response.sendRedirect(request.getContextPath() +"");
	        }
		
	}

}
