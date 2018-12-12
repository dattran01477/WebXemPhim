package com.WebXemPhim.Controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.WebXemPhim.AppUtils.AppUtils;
import com.WebXemPhim.Dao.ChiTietDatVeDao;
import com.WebXemPhim.Dao.ChiTietGheNgoiDao;
import com.WebXemPhim.Dao.GheDao;
import com.WebXemPhim.Dao.PhongChieuDao;
import com.WebXemPhim.Dao.SoDuTaiKhoanDao;
import com.WebXemPhim.model.ChiTietGheNgoi;
import com.WebXemPhim.model.UserAccount;

/**
 * Servlet implementation class ThanhToanServlet
 */
@WebServlet("/ThanhToan")
public class ThanhToanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThanhToanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");  
		UserAccount loginedUser = (UserAccount)request.getSession().getAttribute("loginedUser");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		
		
		/*-----------Tạo Biến Xử Lý---------*/
		int idFilm=Integer.parseInt(request.getParameter("idFilm"));
		int idTK=loginedUser.getId_Account();
		int idXC=Integer.parseInt(request.getParameter("idXC"));
		int tongGia=Integer.parseInt(request.getParameter("tongTien"));
		String currentDate=dtf.format((LocalDateTime.now())) ;
		String ngayDatVe=request.getParameter("ngayXemPhim");
		String sdtDatVe=request.getParameter("sdtDatVe");
		String[] arraySelectSeats=request.getParameterValues("arraySelectSeat[]");
		
		
		/*----------Chuyển thời gian-----*/
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date  dateTemp1 = null;
		java.util.Date  dateTemp2 = null;
		try {
			dateTemp1 = sdf1.parse(currentDate);
			dateTemp2 =  sdf1.parse(ngayDatVe);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date currentSqlDate =new  java.sql.Date(dateTemp1.getTime());
		java.sql.Date sqlDate2 =new  java.sql.Date(dateTemp2.getTime());
		
		int soDuTaiKhoanHienTai=SoDuTaiKhoanDao.getSoDuTk(idTK);
		if(soDuTaiKhoanHienTai>tongGia)
		{
			
			/*Rang lam bang transacsison*/
			soDuTaiKhoanHienTai=soDuTaiKhoanHienTai-tongGia;
			boolean isSub=false;
			isSub=SoDuTaiKhoanDao.setSoDu(soDuTaiKhoanHienTai,idTK);
			int idDatVe=ChiTietDatVeDao.themChiTietDatVe(idXC, idTK, tongGia, 0, "", currentSqlDate, sqlDate2, sdtDatVe);
			if(idDatVe!=-1 &&isSub==true)
			{
				session.setAttribute("idDatVe", idDatVe);
				int kt=0;
				for(String w:arraySelectSeats)
				{
					String idGhe=GheDao.getIdGhe(AppUtils.GetHang(w),
							AppUtils.GetCot(w),
							PhongChieuDao.getIdPhongChieu(idXC));
					
					kt=ChiTietGheNgoiDao.themChiTietGheNgoi(idGhe, 
							idDatVe);
					if(kt==0)
					{
						out.print("-1");
						return;
					}
				}
				out.print("1");
			}
			else
			{
				out.print("-1");
			}
			
		}
		else
		{
			//0 Số Dư Không đủ
			//-1 Mua Vé Không thành công
			//1 Mua vé thành công
			out.print("0");
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
