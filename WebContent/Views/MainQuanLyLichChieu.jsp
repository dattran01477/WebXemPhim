<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="main-content-container container-fluid px-4">
	<!-- Page Header -->
	<div class="page-header row no-gutters py-4">
		<div class="col-12 col-sm-4 text-center text-sm-left mb-0">
			<span class="text-uppercase page-subtitle">Dashboard</span>
			<h3 class="page-title">Quản Lịch Chiếu</h3>
		</div>
	</div>
	<div class="col">
		<!-- Button to Open the Modal -->
		<button type="button" class="btn btn-info mb-3" data-toggle="modal"
			data-target="#myModal">Thêm Lịch Chiếu</button>
		<!-- The Modal -->
		<div class="modal" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Thêm Lịch Chiếu</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<!-- Modal body -->
					<div class="modal-body">

						<form class="add-new-post">
							<label>Tên Phim:</label> <select class="form-control mb-3"
								id="sel_Phim" name="Phim">
								<input class="form-control form-control-lg mb-3" type="time"
								placeholder="Thời Gian Chiếu" name="gioChieuPhim">

							</select>
							<div class="row justify-content-center">
								<div class="col-12 col-md-4 mx-3">
									<label>Tên Rạp Chiếu:</label> <select class="form-control"
										id="sel_RapChieu" name="RapChieu">

									</select>
								</div>
								<div class="col-12 col-md-4 mx-3">
									<label>Tên Phòng Chiếu:</label> <select class="form-control"
										id="sel_PhongChieu" name="PhongChieu">
									</select>
								</div>

							</div>

							<div></div>
						</form>

					</div>
					<!-- Modal footer -->
					<div class="modal-footer">
						<button class="btn btn-primary float-right" id="btnThemLichChieu">Thêm lịch
							chiếu</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<div class="card card-small mb-4">
				<div class="card-header border-bottom">
					<h6 class="m-0">Danh lịch chiếu</h6>
				</div>
				<div class="card-body p-0 pb-3 text-center">
					<table class="table mb-0">
						<thead class="bg-light">
							<tr>
								<th scope="col" class="border-0">Mã Xuất Chiếu</th>
								<th scope="col" class="border-0">Tên Phim</th>
								<th scope="col" class="border-0">Phòng Chiếu</th>
								<th scope="col" class="border-0">Thời Gian Bắt Đầu</th>
								<th scope="col" class="border-0">Tùy Chọn</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	function loadRapChieu() {
		$("#sel_RapChieu").empty();

		$.ajax({
			url : '${pageContext.request.contextPath}/GetRapChieu',
			dataType : 'html',
			success : function(data) {
				var obj = $.parseJSON(data);
				$.each(obj,
						function(index, el) {

							$(
									"<option class='dropdown-item'>"
											+ el.tenRap + "</option>")
									.appendTo($("#sel_RapChieu"));

						});
			}
		});

	}
	function loadPhim() {
		$("#sel_Phim").empty();
		$.ajax({
			url : '${pageContext.request.contextPath}/GetFilm',
			dataType : 'html',
			success : function(data) {
				var obj = $.parseJSON(data);
				$.each(obj, function(index, el) {
					$(
							"<option class='dropdown-item'>" + el.tieuDe
									+ "</option>").appendTo($("#sel_Phim"));
				});

			}
		});
	}

	function loadPhongChieu(tenRapChieu) {
		$("#sel_PhongChieu").empty();
		$.ajax({
			url : '${pageContext.request.contextPath}/GetPhongChieu',
			dataType : 'html',
			data : {
				tenRapChieu : tenRapChieu
			},
			success : function(data) {
				var obj = $.parseJSON(data);
				$.each(obj, function(index, el) {
					$(
							"<option class='dropdown-item'>" + el.tenPhongChieu
									+ "</option>").appendTo(
							$("#sel_PhongChieu"));
				});

			}
		});
	};
	$(document)
			.ready(
					function() {
						loadPhim();
						loadRapChieu();
						$("#sel_RapChieu").change(function(event) {
							loadPhongChieu($("#sel_RapChieu").val());
						});
						$
								.ajax({
									url : '${pageContext.request.contextPath}/XuatChieu',
									dataType : 'html',
									success : function(data) {
										var obj = $.parseJSON(data);
										$
												.each(
														obj,
														function(index, el) {
															$(
																	"<tr> <td>"
																			+ el.id
																			+ "</td><td>"
																			+ el.phim.tieuDe
																			+ "</td><td>"
																			+ el.phongchieu.tenPhongChieu
																			+ "</td><td>"
																			+ el.gioChieu
																			+ "</td><td>"
																			+ "<a href='${pageContext.request.contextPath}/XuatChieu?command=update&id="+el.id+"'><i class='fa fa-edit mr-3' style='font-size:24px'></i></a>"
																			+ "<a href='${pageContext.request.contextPath}/XuatChieu?command=delete&id="+el.id+"'><i class='fa fa-trash mr-3' style='font-size:24px'></i></a>"
																			+ "</td>"
																			+

																			"</tr>")
																	.appendTo(
																			$("tbody"));
														});
									}
								});
						$("#btnThemLichChieu").click(function(event) {
							$('#myModal').modal('toggle'); 
						    var tenRapChieu = $("#sel_RapChieu").val();
						    var tenPhongChieu = $("#sel_PhongChieu").val();
						    var tenPhim = $("#sel_Phim").val();
						    var gioChieuPhim=$('[name="gioChieuPhim"]').val();
						    if(tenRapChieu==null||tenPhongChieu==null||tenPhim==null)
						    {
						        alert("Vui lòng nhập đầy đủ các trường");
						    }
						    else
						    {
						       $
						        .ajax({
						            url: '${pageContext.request.contextPath}/XuatChieu',
						            type:'POST',
						            data:{tenRapChieu:tenRapChieu,tenPhongChieu:tenPhongChieu,tenPhim:tenPhim,gioChieuPhim:gioChieuPhim},
						            dataType: 'html',
						            success: function(data) {
						                var obj = $.parseJSON(data);
						               if(data=="1")
						               {
						               
						                $("#main_pn")
										.load(
												"${pageContext.request.contextPath}/Views/MainQuanLyLichChieu.jsp");
						               }
						               else
						            	   {
						            	   alert("Thất bại");
						            	   }
						            }
						        }); 
						    }
						});

					});
</script>
