<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="main-content-container container-fluid px-4">
	<!-- Page Header -->
	<div class="page-header row no-gutters py-4">
		<div class="col-12 col-sm-4 text-center text-sm-left mb-0">
			<span class="text-uppercase page-subtitle">Dashboard</span>
			<h3 class="page-title">Blog Overview</h3>
		</div>
	</div>
	<div class="row">

		<div class='col-lg-9 col-md-12'>
			<div class="card card-small mb-3">
				<div class="card-body">
					<form class="add-new-post">
						<input class="form-control form-control-lg mb-3" type="text"
							placeholder="Tiêu đề phim" name="tieuDe">
							<input class="form-control form-control-lg mb-3" type="number"
							placeholder="Giá Vé" name="giaVe">
							<input class="form-control form-control-lg mb-3" type="number"
							placeholder="Do dai" name="doDai">
						<div
							class="row justify-content-md-center  justify-content-lg-center align-items-center">
							<div class="col-lg-4 col-md-4">
								<input class="form-control form-control-lg mb-3" type="text"
									placeholder="Đạo diễn" name="daoDien">
							</div>
							<div class="col-lg-4 col-md-4">
								<input class="form-control form-control-lg mb-3" type="number"
									placeholder="Độ tuổi" name="doTuoi">
							</div>
							<div class="col-lg-4 col-md-3">
								<div class="dropdown mb-1">
									<button class="btn btn-primary dropdown-toggle" type="button"
										id="dropdownMenuButton" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">Quốc gia</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
										<select multiple class="form-control" id="sel2" name="quocGia">
											<option class="dropdown-item">Việt Nam</option>
											<option class="dropdown-item">Lào</option>
											<option class="dropdown-item">Campuchia</option>
											<option class="dropdown-item">Mỹ</option>
											<option class="dropdown-item">Ấn Độ</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<input class="form-control form-control-lg mb-3" type="text"
							placeholder="Diễn viên" name="dienVien">
						<div
							class="row justify-content-md-center  justify-content-lg-center align-items-center">
							<div class="col-lg-7 col-md-7">
								<input class="form-control form-control-lg mb-3" type="url"
									placeholder="Link trailer phim" name="url_Trailer">
							</div>
							<div class="col-lg-5 col-md-5">
								<input class="form-control form-control-lg mb-3" type="url"
									placeholder="Hình ảnh phim" name="url_Image">
							</div>
						</div>
						<div class="col-lg-5 col-md-6 pl-0">
							<input class="form-control form-control-lg mb-3" type="date"
								placeholder="Ngày ra mắt phim" name="ngayRaMatPhim">
						</div>
						<div id="editor-container" class="add-new-post__editor mb-1"></div>
					</form>
				</div>
			</div>
		</div>
			<div class="col-lg-3 col-md-12">
							<div class="card card-small mb-3">
								<div class="card-header  border-bottom text-center text-justify">
									<span>Danh mục phim</span>
								</div>
								<div class="card-body border-bottom">
									<select  class="form-control" id="sel_Danhmuc"
										name="tenDanhMuc" >
									</select>
									
								</div>
								<div class="card-footer">
									<li class="list-group-item d-flex px-3">
										<div class="input-group">
											<input id="CategoryName" type="text" class="form-control"
												placeholder="New category" aria-label="Add new category"
												aria-describedby="basic-addon2">
											<div class="input-group-append">
												<button id="addCategory" class="btn btn-white px-2"
													type="submit">
													<i class="material-icons">add</i>
												</button>
											</div>
										</div>
									</li>
								</div>
							</div>
							<div class="card card-small mb-3">
								<div class="card-header  border-bottom text-justify">
									<span>Tùy chọn</span>
								</div>

								<div class="row  px-2  align-items-center mb-4">

									<div class=" mb-1 col-12 ">
										<label>Trạng thái:</label> <select class="form-control"
							id="sel_TrangThai" name="trangThai">

						</select>
					</div>
								</div>

							</div>
						

						</div>
                            <button class="btn btn-primary " type="button" id="btnThemPhim" >
                                            Thêm Phim
                                        </button>


	</div>
</div>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/quill/1.3.6/quill.min.js"></script>
<script
	src="${pageContext.request.contextPath}/Views/scripts/app/app-blog-new-post.1.1.0.js"></script>
<script>
function loadCategory() {
	$("#sel_Danhmuc").empty();

	$.ajax({
		url : '${pageContext.request.contextPath}/Getcategory',
		data : {
			categoryName : $('#CategoryName').val()
		},
		dataType : 'html',
		success : function(data) {
			var obj = $.parseJSON(data);
			$.each(obj, function(index, el) {

				if (el.tenDanhMuc =="${film.tenDanhMuc}") {
					$(
							"<option selected class='dropdown-item'>"
									+ el.tenDanhMuc + "</option>")
							.appendTo($("#sel_Danhmuc"));
				} else {
					$(
							"<option class='dropdown-item'>"
									+ el.tenDanhMuc + "</option>")
							.appendTo($("#sel_Danhmuc"));
				}

			});
		}
	});
	$("#CategoryName").val("");
}
function loadTrangThai() {
	$("#sel_TrangThai").empty();
	$.ajax({
		url : '${pageContext.request.contextPath}/TrangThai',
		dataType : 'html',
		success : function(data) {
			var obj = $.parseJSON(data);
			$.each(obj, function(index, el) {
				if (el == "${film.tenTrangThai}") {
					$(
							"<option selected class='dropdown-item'>"
									+ el + "</option>").appendTo(
							$("#sel_TrangThai"));
				} else {
					$(
							"<option class='dropdown-item'>" + el
									+ "</option>").appendTo(
							$("#sel_TrangThai"));
				}

			});
		}
	});
}
	$(document).ready(
			
			
			function() {
				loadCategory();
				loadTrangThai();
				$("#btnThemPhim").click(
						function() {
							 var tieuDe=$('[name="tieuDe"]').val();
						        var daoDien=$('[name="daoDien"]').val();
						        var dienVien=$('[name="dienVien"]').val();
						        var trangThai=$('[name="trangThai"]').val();
						        var moTa=$('.ql-editor').html();
						        var url_Trailer=$('[name="url_Trailer"]').val();
						        var doDai=$('[name="doDai"]').val();
						        var quocGia=$('[name="quocGia"]').val();
						        var giaVe=$('[name="giaVe"]').val();
						        var tenDanhMuc=$('[name="tenDanhMuc"]').val();
						        var url_Image=$('[name="url_Image"]').val();
						        var ngayRaMatPhim=$('[name="ngayRaMatPhim"]').val();
						         var doTuoi=$('[name="doTuoi"]').val();

							$.ajax({
								url : '${pageContext.request.contextPath}/AddFilm',
								data : {
									tieuDe:tieuDe,
									daoDien:daoDien,
									dienVien:dienVien,
									trangThai:trangThai,
									moTa:moTa,
									url_Trailer:url_Trailer,
									doDai:doDai,
									quocGia:quocGia,
									giaVe:giaVe,
									tenDanhMuc:tenDanhMuc,
									url_Image:url_Image,
									ngayRaMatPhim:ngayRaMatPhim,
									doTuoi:doTuoi
								},
								dataType : 'html',
								success : function(data) {
									if(data='1')
										{
										$("#main_pn").empty();
										$("#main_pn")
										.load(
												"${pageContext.request.contextPath}/table");
										}
									else
										{
										alert("Lỗi rồi bạn ơi")
										}
								}
							});
							

						});
			});
</script>