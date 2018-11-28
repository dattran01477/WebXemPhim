package com.WebXemPhim.Controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebXemPhim.Dao.UserAccountDao;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userName=request.getParameter("userName");
		String pass=request.getParameter("passWord");
		String roleName=request.getParameter("roleName");
		if(roleName==null)
		{
			roleName="cu";
		}
		PrintWriter out =response.getWriter();
		if(userName!=""&&pass!=""&&roleName!="")
		{
			boolean tmp=UserAccountDao.addUser(userName, pass, roleName);
			if(tmp==true)
			{
				out.print("Thêm thành viên thành công");
			}
			else
			{
				out.print("Thêm thành viên thất bại");
			}
		}
		else
		{
			out.print("vui lòng nhập đủ các trường");
		}	
	}

}
