package com.WebXemPhim.Controler;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WebXemPhim.jdbc.Connector;
import com.WebXemPhim.model.*;
import com.google.gson.Gson;


/**
 * Servlet implementation class table
 */
@WebServlet("/table")
public class table extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public table() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int Page=0;
		
		Connector connector = null;
		try {
			connector = new Connector();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(request.getParameter("page")==null)
		{		
			int numberPage=lamTron(connector.CountFilm(), 8);
			request.setAttribute("numberPage", numberPage);
			RequestDispatcher dispatcher //
	         = this.getServletContext()//
	               .getRequestDispatcher("/Views/MainQuanLyPhim.jsp");

			 dispatcher.forward(request, response);
		}
		else
		{
			Page=Integer.parseInt(request.getParameter("page"));
			PrintWriter out=response.getWriter();
			List<Film> listPhim=new ArrayList<>();
			listPhim=connector.getFilm((Page-1)*8+1, 8);
			String json = new Gson().toJson(listPhim);
			out.print(json);
		}
		 
		
		
	}
	private int lamTron(int numberFilm,int row)
	{
		int kq;
		if(numberFilm%row!=0)
		{
			kq=numberFilm/row+1;
		}
		else
		{
			kq=numberFilm/row;
		}
		return kq;
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
