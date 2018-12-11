<%@page import="com.WebXemPhim.model.PhongChieu"%>
<%@page import="com.WebXemPhim.Dao.PhongChieuDao"%>
<%@page import="com.WebXemPhim.Dao.RapChieuDao"%>
<%@page import="com.WebXemPhim.model.RapChieu"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
				<div class="main-content-container container-fluid px-4">
				<!-- Page Header -->
				<div class="page-header row no-gutters py-4">
					<div class="col-12 col-sm-4 text-center text-sm-left mb-0">
						<span class="text-uppercase page-subtitle">Dashboard</span>
						<h3 class="page-title">Quản Lý Phòng Chiếu</h3>
					</div>
				</div>
				<div class="col">
					<div class="row">
						<button type="button" class="btn btn-info mb-3"
							data-toggle="modal" data-target="#myModal">Thêm Phòng
							Chiếu</button>
						<!-- The Modal -->
						<div class="modal" id="myModal">
							<div class="modal-dialog">
								<div class="modal-content">
									<!-- Modal Header -->
									<div class="modal-header">
										<h4 class="modal-title">Thêm Phòng Chiếu</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<!-- Modal body -->
									<div class="modal-body">
										<form class="add-new-post" action="${pageContext.request.contextPath}/PhongChieu"
											method="post">
											<input type="hidden" name="command" value="insert">  <input
												class="form-control form-control-lg mb-3" type="text"
												placeholder="Tên Phòng Chiếu" name="tenPhongChieu"> 
												 <input
												class="form-control form-control-lg mb-3" type="number"
												placeholder="Số Hàng" name="soHang">
												 <input
												class="form-control form-control-lg mb-3" type="number"
												placeholder="Số Cột" name="soCot">
												<div class="card-body border-bottom">
												<div
													class="card-header  border-bottom text-center text-justify">
													<span>Danh sach Rap Chieu</span>
												</div>
												<select class="form-control" id="sel_TenRap"
													name="tenRap">
													<%
													
													for (RapChieu c : RapChieuDao.getRapChieu()) {
														
												%>
													<option><%=c.getTenRap()%></option>
													<%
													}
												%>
												
												</select>

											</div>
											<div class="col">

												<input type="submit" class="btn btn-info mb-3 " value="Thêm">
											</div>
										</form>
									</div>
								</div>
							</div>

						</div>
							

						<div class="col-lg-3 float-right">
							<div class="dropdown ">
								<button class="btn btn-info dropdown-toggle" type="button"
									data-toggle="dropdown">
									<i class='fas fa-filter' style='font-size: 14px'></i>
								</button>
								<ul class="dropdown-menu">
									<li><a href="#">Hcm</a></li>
									<li><a href="#">Cần Thơ</a></li>
									<li><a href="#">...</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col">
						<div class="card card-small mb-4">
							<div class="card-header border-bottom">
								<h6 class="m-0">Danh Sách Phon</h6>
							</div>
							<div class="card-body p-0 pb-3 text-center">
								<table class="table mb-0">
									<thead class="bg-light">

										<tr>
											<th scope="col" class="border-0">STT</th>
											<th scope="col" class="border-0">Tên Phòng Chiếu</th>
											<th scope="col" class="border-0">Số ghế ngồi</th>
											<th scope="col" class="border-0">Tên Rạp</th>
											<th scope="col" class="border-0">Tùy chọn</th>
										</tr>
										<%
											int count = 0;
											for (PhongChieu c : PhongChieuDao.getPhongChieu()) {
												count++;
										%>
										<tr>
											<th scope="col" class="border-0"><%=count%></th>
											<th scope="col" class="border-0"><%=c.getTenPhongChieu()%></th>
											<th scope="col" class="border-0"><%=c.getSoGheNgoi()%></th>
											<th scope="col" class="border-0"><%=c.getTenRapChieu()%></th>
											<td>
												<a
												href="${pageContext.request.contextPath}/Views/TriUpdatePhongChieu.jsp?command=update&id=<%=c.getIdPhongChieu()%>
												&name=<%=c.getTenPhongChieu()%>&tenRapChieu=<%=c.getTenRapChieu()%>"
												class="btn btn-warning"><i class="fa fa-edit"></i></a> <a
												href="${pageContext.request.contextPath}/RapChieuServlet?command=delete&id=<%=c.getIdPhongChieu()%>"
												class="btn btn-danger"> <i class="fa fa-trash"></i></a>
											</td>
										</tr>
										<%
											}
										%>
										

									</thead>
								
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>




