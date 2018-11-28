<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:Wrapper>

	<div class="main-content-container container-fluid px-4">
		<!-- Page Header -->
		<div class="page-header row no-gutters py-4">
			<div class="col-12 col-sm-4 text-center text-sm-left mb-0">
				<span class="text-uppercase page-subtitle">Dashboard</span>
				<h3 class="page-title">Update Danh Mục</h3>
			</div>
		</div>
		<div class="row">

			<div class='col-lg-9 col-md-12'>
				<div class="card card-small mb-3">
					<div class="card-body">
						<form class="add-new-post"
							action="${pageContext.request.contextPath}/RapChieuPhim"
							method="post">

							<input type="hidden" name="command" value="update"> <input
								type="hidden" name="idRapChieu" value="${param.id }"><label>
								Địa điểm:
								</label> <input
								class="form-control form-control-lg mb-3" type="text"
								placeholder="Địa điểm" name="diaDiem" value="${param.diaDiem }"
								required> <label>Tên rạp:
								</label><input
								class="form-control form-control-lg mb-3" type="text"
								placeholder="Tên Rạp" name="tenRap" value="${param.tenRap }"
								required><label>Loại:</label> <input
								class="form-control form-control-lg mb-3" type="text"
								placeholder="Loai" name="loai"
								value="${param.loai }" required>
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