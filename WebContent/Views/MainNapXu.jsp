<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="main-content-container container-fluid px-4">
	<!-- Page Header -->
	<div class="page-header row no-gutters py-4">
		<div class="col-12 col-sm-4 text-center text-sm-left mb-0">
			<span class="text-uppercase page-subtitle">Dashboard</span>
			<h3 class="page-title">Nạp Xu</h3>
		</div>
	</div>
	<div class="row justify-content-center align-items-center">

		<div class='col-md-6 col-12'>
			<div class="card card-small mb-3">
				<div class="card-body">
					<label for="feFirstName">Tên Tài Khoản:</label> <input
						class="form-control form-control-lg mb-3" type="text"
						name="userName"> <label for="feFirstName">Số Xu
						Muốn Nạp:</label> <input class="form-control form-control-lg mb-3"
						type="number" placeholder="Số lượng xu" name="slXu">
					<div class="float-right">
						<button type="button" class="btn btn-info mb-3 ml-auto"
							id="btnNapXu">Nạp Xu</button>
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

						$("#btnNapXu")
								.click(
										function() {
											

										
											$.ajax({
														url : '${pageContext.request.contextPath}/NapXuAd',
														data : {
															userName : $('[name="userName"]').val(),
															slXu:$('[name="slXu"]').val()
														},
														dataType : 'html',
														success : function(data) {
															alert(data);
														}
													});
										

										});
						

										})
				
</script>