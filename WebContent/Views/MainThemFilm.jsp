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
							placeholder="Tiêu đề phim" name="titleFlim">
						<div
							class="row justify-content-md-center  justify-content-lg-center align-items-center">
							<div class="col-lg-4 col-md-4">
								<input class="form-control form-control-lg mb-3" type="text"
									placeholder="Đạo diễn" name="directorName">
							</div>
							<div class="col-lg-4 col-md-4">
								<input class="form-control form-control-lg mb-3" type="number"
									placeholder="Độ tuổi" name="ageLimit">
							</div>
							<div class="col-lg-4 col-md-3">
								<div class="dropdown mb-1">
									<button class="btn btn-primary dropdown-toggle" type="button"
										id="dropdownMenuButton" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">Quốc gia</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
										<select multiple class="form-control" id="sel2" name="country">
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
							placeholder="Diễn viên" name="cast">
						<div
							class="row justify-content-md-center  justify-content-lg-center align-items-center">
							<div class="col-lg-7 col-md-7">
								<input class="form-control form-control-lg mb-3" type="url"
									placeholder="Link trailer phim" name="urlTrailerFilm">
							</div>
							<div class="col-lg-5 col-md-5">
								<input class="form-control form-control-lg mb-3" type="file"
									placeholder="Hình ảnh phim" name="imageFilm">
							</div>
						</div>
						<div class="col-lg-5 col-md-6 pl-0">
							<input class="form-control form-control-lg mb-3" type="date"
								placeholder="Ngày ra mắt phim" name="dateToShowFilm">
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
					<select multiple class="form-control" id="sel_Danhmuc"
						name="sellist2">
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
                                <div class="card-header  border-bottom text-center text-justify">
                                    <span>Tùy Chọn</span>
                                </div>
                                <div class="card-body">
                                    <div class="form-check border-bottom text-left ml-2">
                                        <input type="checkbox" class="form-check-input" id="isComments">
                                        <label class="form-check-label" for="exampleCheck1">Cho Phép Bình Luận</label>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="form-check border-bottom text-left ml-2">
                                        <input type="checkbox" class="form-check-input" id="isComments">
                                        <label class="form-check-label" for="exampleCheck1">Cho Phép Bình Luận</label>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="form-check border-bottom text-left ml-2">
                                        <input type="checkbox" class="form-check-input" id="isComments">
                                        <label class="form-check-label" for="exampleCheck1">Cho Phép Bình Luận</label>
                                    </div>
                                </div>
                                <div class="row    align-items-center mb-4">
                                     <div class="dropdown mb-1 col-6 text-center">
                                        <button class="btn btn-primary dropdown-toggle col-9" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            Chế Độ
                                        </button>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                            <select multiple class="form-control" id="sel2" name="country">
                                                <option class="dropdown-item">Hot</option>
                                                <option class="dropdown-item">Xem Nhiều Nhất</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="dropdown mb-1 col-6 text-center">
                                        <button class="btn btn-primary dropdown-toggle col-9" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            Quyền Xem
                                        </button>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                            <select multiple class="form-control" id="sel2" name="country">
                                                <option class="dropdown-item">Công Khai</option>
                                                <option class="dropdown-item">Riêng tư</option>
                                            </select>
                                        </div>
                                    </div>

                                    
                                </div>

                            </div>
		</div>

	</div>
</div>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/quill/1.3.6/quill.min.js"></script>
<script
	src="${pageContext.request.contextPath}/Views/scripts/app/app-blog-new-post.1.1.0.js"></script>
<script>
	$(document).ready(
			function() {
				$("#addCategory").click(
						function() {
							$("#sel_Danhmuc").empty();

							$.ajax({
								url : 'Getcategory',
								data : {
									categoryName : $('#CategoryName').val()
								},
								dataType : 'html',
								success : function(data) {
									var obj = $.parseJSON(data);
									$.each(obj, function(index, el) {
										$(
												"<option class='dropdown-item'>"
														+ el.tenDanhMuc
														+ "</option>")
												.appendTo($("#sel_Danhmuc"));
									});
								}
							});
							$("#CategoryName").val("");

						});
			});
</script>