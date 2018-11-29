<%@page import="com.WebXemPhim.Dao.RapChieuDao"%>
<%@page import="com.WebXemPhim.model.RapChieu"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


				<div class="main-content-container container-fluid px-4">
					<!-- Page Header -->
					<div class="page-header row no-gutters py-4">
						<div class="col-12 col-sm-4 text-center text-sm-left mb-0">
							<span class="text-uppercase page-subtitle">Dashboard</span>
							<h3 class="page-title">Quản Lý Rạp Chiếu</h3>
						</div>
					</div>
					<div class="col">
						<div class="row">
							<button type="button" class="btn btn-info mb-3"
								data-toggle="modal" data-target="#myModal">Thêm Rạp
								Chiếu</button>
							<!-- The Modal -->
							<div class="modal" id="myModal">
								<div class="modal-dialog">
									<div class="modal-content">
										<!-- Modal Header -->
										<div class="modal-header">
											<h4 class="modal-title">Thêm Rạp Chiếu</h4>
											<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>
										<!-- Modal body -->
										<div class="modal-body">
											<form class="add-new-post" action="${pageContext.request.contextPath}/RapChieuPhim"
												method="post">
												<input type="hidden" name="command" value="insert">
												<input class="form-control form-control-lg mb-3" type="text"
													placeholder="Id Rạp Chiếu" name="idRapChieu"> <input
													class="form-control form-control-lg mb-3" type="text"
													placeholder="Địa Điểm" name="diaDiem"> <input
													class="form-control form-control-lg mb-3" type="text"
													placeholder="Tên Rạp" name="tenRap"> <input
													class="form-control form-control-lg mb-3" type="text"
													placeholder="Loại rạp" name="loai">
												<div class="col">

													<input type="submit" class="btn btn-info mb-3 "
														value="Thêm">
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
									<h6 class="m-0">Danh Sách Rạp Chiếu</h6>
								</div>
								<div class="card-body p-0 pb-3 text-center">
									<table class="table mb-0">
										<thead class="bg-light">

											<tr>
												<th scope="col" class="border-0">STT</th>
												<th scope="col" class="border-0">Mã Rạp Chiếu</th>
												<th scope="col" class="border-0">Địa Điểm</th>
												<th scope="col" class="border-0">Tên Rạp</th>
												<th scope="col" class="border-0">Số Lượng Rạp Hiện Tại</th>
												<th scope="col" class="border-0">Tùy chọn</th>
											</tr>
											<!-- Chen code java vao jsp -->
											<%
												int count = 0;
												for (RapChieu c : RapChieuDao.getRapChieu()) {
													count++;
											%>
											<tr>
												<th scope="col" class="border-0"><%=count%></th>
												<th scope="col" class="border-0"><%=c.getId_RapChieu()%></th>
												<th scope="col" class="border-0"><%=c.getDiaDiem()%></th>
												<th scope="col" class="border-0"><%=c.getTenRap()%></th>
												<th scope="col" class="border-0"><%=c.getLoai()%></th>
												<td><a
													href="${pageContext.request.contextPath}/Views/TriUpdateRapChieu.jsp?command=update&id=<%=c.getId_RapChieu()%>&diaDiem=<%=c.getDiaDiem()%>
												&tenRap=<%=c.getTenRap()%>&loai=<%=c.getLoai()%>"
													class="btn btn-warning"><i class="fa fa-edit"></i></a> <a
													href="${pageContext.request.contextPath}/RapChieuPhim?command=delete&id=<%=c.getId_RapChieu()%>"
													class="btn btn-danger"> <i class="fa fa-trash"></i></a></td>
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


	
	