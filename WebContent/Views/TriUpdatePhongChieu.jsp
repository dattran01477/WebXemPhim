<%@page import="com.WebXemPhim.Dao.RapChieuDao"%>
<%@page import="com.WebXemPhim.model.RapChieu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:Wrapper>
	<div class="main-content-container container-fluid px-4">
		<!-- Page Header -->
		<div class="page-header row no-gutters py-4">
			<div class="col-12 col-sm-4 text-center text-sm-left mb-0">
				<span class="text-uppercase page-subtitle">Dashboard</span>
				<h3 class="page-title">Update Phòng Chiếu</h3>
			</div>
		</div>
		<div class="row">
			<div class='col'>
				<div class="row justify-content-center">
					<div class="card card-small mb-3 mx-2 col-md-7 col-12">
						<div class="card-body">

							<form class="add-new-post"
								action="${pageContext.request.contextPath}/PhongChieuServlet"
								method="post">
								<input type="hidden" name="command" value="update"> <input
									type="hidden" name="idRapChieu" value="${param.id }"> <input
									class="form-control form-control-lg mb-3" type="text"
									placeholder="Tên Phòng Chiếu" name="tenPhongChieu"
									value="${param.name }">
								<div class="card-body border-bottom">
									<div
										class="card-header  border-bottom text-center text-justify">
										<span>Danh sach Rap Chieu</span>
									</div>
									<%-- <select class="form-control" id="sel_TenRap" name="tenRap"
									value="${param.tenRapChieu}">
									<%
										for (RapChieu c : RapChieuDao.getRapChieu()) {
									%>
									<option><%=c.getTenRap()%></option>
									<%
										}
									%>

								</select> --%>

								</div>
								<div class="col">

									<input type="submit" class="btn btn-info mb-3 " value="Update">
								</div>
							</form>

						</div>
					</div>
					<div class="card card-small mb-3 col-md-3 col-12">
						<div class="card-body">
							<label>Số hàng gế:</label> <input
								class="form-control form-control-lg mb-3" type="text"
								name="hangGhe"> <label>Số cột gế:</label> <input
								class="form-control form-control-lg mb-3" type="text"
								name="cotGhe">
							<button class="btn btn-info">Cập Nhập ghế</button>

						</div>
					</div>
				</div>

			</div>

		</div>
	</div>

</t:Wrapper>