<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:Wrapper>
	<div class="main-content-container container-fluid px-4">
		<!-- Page Header -->
		<div class="page-header row no-gutters py-4">
			<div class="col-12 col-sm-4 text-center text-sm-left mb-0">
				<span class="text-uppercase page-subtitle">Dashboard</span>
				<h3 class="page-title">Update Lịch Chiếu</h3>
			</div>
		</div>
		<div class="row">
			<div class='col-lg-9 col-md-12'>
				<div class="card card-small mb-3">
					<div class="card-body">
						<form class="add-new-post"
							action="${pageContext.request.contextPath}/UpdateXuatChieuServlet"
							method="post">
							<input type="hidden" name="command" value="update"> <input
								type="hidden" name="id" value="${inforXuatChieu.id }">
							<input class="form-control form-control-lg mb-3" type="text"
								placeholder="Tên Phim" name="id_Phim"
								value="${inforXuatChieu.id_Phim }" required> <input
								class="form-control form-control-lg mb-3" type="time"
								placeholder="Giờ chiếu" name="gioChieu"
								value="${inforXuatChieu.gioChieu }" required> <input
								class="form-control form-control-lg mb-3" type="text"
								placeholder="Phòng chiếu" name="id_PhongChieu"
								value="${inforXuatChieu.id_PhongChieu }" required>
							<div class="col">
								<input type="submit" class="btn btn-info mb-3 " value="Update">
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

</t:Wrapper>