package com.WebXemPhim.Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import com.WebXemPhim.Dao.*;
import com.WebXemPhim.jdbc.Connector;
import com.WebXemPhim.model.Category;
import com.WebXemPhim.model.XuatChieu;
import com.google.gson.Gson;

/**
 * Servlet implementation class ModalDatVeServlet
 */
@WebServlet("/ModalDatVeServlet")
public class ModalDatVeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModalDatVeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		/*1: lấy danh sách các lại rạp 2: lấy danh sách các rạp chiếu thuộc loại rạp và số ghế trống*/
		PrintWriter out=response.getWriter();
	
		int type=Integer.parseInt(request.getParameter("type"));
		if(type==1)
		{
			String diaDiem=request.getParameter("diaDiem");
			List<String> listLoaiRap=RapChieuDao.getLoaiRap(diaDiem);
			String json = new Gson().toJson(listLoaiRap);
			out.print(json);
			
		}
		if(type==2)
		{
			String diaDiem=request.getParameter("diaDiem");
			String loai=request.getParameter("loai");
			String date=request.getParameter("date");
			
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
			Date  dateTemp = null;
			try {
				dateTemp = sdf1.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			java.sql.Date sqlDate =new  java.sql.Date(dateTemp.getTime());
			
			
			int idFilm=Integer.parseInt(request.getParameter("idFilm"));
			Map<String, List<XuatChieu>> map = new HashMap<>();
			List<String> listTenRapChieu=RapChieuDao.getRapChieuTheoLoaiVaDiaChi(loai,diaDiem);
			List<XuatChieu> listXuatChieu=null;
			for (String i : listTenRapChieu) {
	            listXuatChieu=XuatChieuDao.getThongTinListXuatChieuFilm(RapChieuDao.getId(i), idFilm, sqlDate);
	            map.put(i,listXuatChieu );
			}   
	            
	            
	        // chuyen sang json
	        String json = new Gson().toJson(map);
	        out.print(json);
	        

	        

			
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
