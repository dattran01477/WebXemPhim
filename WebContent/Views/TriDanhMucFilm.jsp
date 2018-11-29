
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.WebXemPhim.Dao.CategoryFilm"%>
<%@page import="com.WebXemPhim.model.Category"%>

				<div class="main-content-container container-fluid px-4">
					<!-- Page Header -->
					<div class="page-header row no-gutters py-4">
						<div class="col-12 col-sm-4 text-center text-sm-left mb-0">
							<span class="text-uppercase page-subtitle">Dashboard</span>
							<h3 class="page-title">Blog Overview</h3>
						</div>
					</div>

					<button type="button" class="btn btn-info mb-3" data-toggle="modal"
						data-target="#myModal">Thêm Danh Mục Phim +</button>
					<div class="row">
						<!-- The Modal -->
						<div class="modal" id="myModal">
							<div class="modal-dialog">
								<div class="modal-content">
									<!-- Modal Header -->
									<div class="modal-header">
										<h4 class="modal-title">Thêm Danh Mục Phim</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>
									<!-- Modal body -->
									<div class="modal-body">
										<form class="add-new-post"
											action="${pageContext.request.contextPath}/DanhMucPhimServlet"
											method="post">
											<input type="hidden" name="command" value="insert"> <input
												class="form-control form-control-lg mb-3" type="text"
												placeholder="Tên danh mục" name="tenDanhMuc" required>
											<input class="form-control form-control-lg mb-3" type="text"
												placeholder="Mô tả" name="moTa" required>
											<div class="col">
												<input type="submit" class="btn btn-info mb-3 " value="Thêm">
											</div>

										</form>
									</div>

								</div>
							</div>
						</div>
						<div class="col">
							<div class="card card-small mb-4">
								<div class="card-header border-bottom">
									<h6 class="m-0">Danh Sách Danh mục</h6>
								</div>
								<div class="card-body p-0 pb-3 text-center table-responsive">

									<table class="table mb-0">

										<thead class="bg-light">

											<tr>
												<th scope="col" class="border-0">STT</th>
												<th scope="col" class="border-0">ID</th>
												<th scope="col" class="border-0">Tên Danh Mục</th>
												<th scope="col" class="border-0">Mô tả</th>
												<th scope="col" class="border-0">Tùy chọn</th>


											</tr>

											<%
												int count = 0;
												for (Category c : CategoryFilm.getCategory()) {
													count++;
											%>
											<tr>
												<th scope="col" class="border-0"><%=count%></th>
												<th scope="col" class="border-0"><%=c.getId()%></th>
												<th scope="col" class="border-0"><%=c.getTenDanhMuc()%></th>
												<th scope="col" class="border-0"><%=c.getMoTa()%></th>
												<td><a
													href="${pageContext.request.contextPath}/Views/TriUpdateDanhMucFilm.jsp?command=update&id=<%=c.getId()%>&tenDanhMuc=<%=c.getTenDanhMuc()%>&moTa=<%=c.getMoTa()%>"
													class="btn btn-warning"><i class="fa fa-edit"></i></a> <a
													href="${pageContext.request.contextPath}/DanhMucPhimServlet?command=delete&id=<%=c.getId()%>"
													class="btn btn-danger"> <i class="fa fa-trash"></i></a></td>
											</tr>
											<%
												}
											%>
										</thead>

										<tbody>

										</tbody>
									</table>
								</div>
							</div>

							<nav aria-label="Page navigation example 	">
								<ul class="pagination float-right">
									<li class="page-item"><a class="page-link" href="#"
										aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
											<span class="sr-only">Previous</span>
									</a></li>
									<c:forEach var="i" begin="1" end="${numberPage}">
										<div class="page-item" id="pageNumber${i}">
											<a class="page-link">${i}</a>
										</div>
									</c:forEach>
									<li class="page-item"><a class="page-link" href="#"
										aria-label="Next"> <span aria-hidden="true">&raquo;</span>
											<span class="sr-only">Next</span>
									</a></li>
								</ul>
							</nav>

						</div>
					</div>
				</div>