<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

			
<div class="main-content-container container-fluid px-4">
				<!-- Page Header -->
				<div class="page-header row no-gutters py-4">
					<div class="col-12 col-sm-4 text-center text-sm-left mb-0">
						<span class="text-uppercase page-subtitle">Dashboard</span>
						<h3 class="page-title">Quản Lý Phim</h3>
					</div>
				</div>
				 <div class="col">
                    <a href="#" class="btn btn-info mb-3 " id="addFilm" role="button">Thêm Phim + </a>
                  </div>
				<div class="row">
				
					<div class="col">
						<div class="card card-small mb-4">
							<div class="card-header border-bottom">
								<h6 class="m-0">Danh Sách Phim</h6>
							</div>
							<div class="card-body p-0 pb-3 text-center table-responsive">
								<table class="table mb-0">
									<thead class="bg-light">
										<tr>

											<th scope="col" class="border-0">Tiêu Đề</th>
											<th scope="col" class="border-0">Đạo Diễn</th>
											<th scope="col" class="border-0">Diễn Viên</th>
											<th scope="col" class="border-0">Trạng Thái</th>
											<th scope="col" class="border-0">Mô Tả</th>
											<th scope="col" class="border-0">Thời Lượng</th>
											<th scope="col" class="border-0">Quốc Gia</th>
											<th scope="col" class="border-0">Tùy Chọn</th>
										</tr>
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
			
							<script>
							$(document).ready((
				
				function() {
					
					var tempBtnClickPageNumber=$(".page-item");
					 $("#addFilm").click(function() {
				            
						 $("#main_pn")
							.load(
									"${pageContext.request.contextPath}/Views/MainThemFilm.jsp");
				        });
					$(".page-item").click(
							function() {
								$("tbody").empty();
								var bid = $(this).attr('id');
								//lay text của this
								var b=$("#"+bid+"").text().trim();
								//active button
								if(tempBtnClickPageNumber!=$(this))
									{
									tempBtnClickPageNumber.removeClass( "active" )
									$( this ).addClass( "active" );
									}
								else
									{
										$( this ).addClass( "active" );
									}
								
								$.ajax({
									url : '${pageContext.request.contextPath}/table',
									data : {
										page : b
									},
									dataType : 'html',
									success : function(data) {
								
										var obj = $.parseJSON(data);
										console.log(obj);
										$.each(obj, function(index, el) {
											$(
													"<tr> <td>"
															+ el.tieuDe
															+ "</td><td>"
															+ el.daoDien
															+ "</td><td>"
															+ el.dienVien
															+ "</td><td>"
															+ el.id_TrangThai
															+ "</td><td>"
															+ el.moTa
															+ "</td><td>"
															+ el.doDai
															+ "</td><td>"
															+ el.quocGia
															+ "</td><td>"  
															+   "<a href=${pageContext.request.contextPath}/Update?id="+el.id+"><i class='fa fa-edit' style='font-size:24px' ></i></a>"
			                                                + 	"<a  href=${pageContext.request.contextPath}/delete?id="+el.id+"><i class='fa fa-trash' style='font-size:24px'></i></a>"
	                                               			+ "</td>"
															+ "</tr>")
													.appendTo($("tbody"));
										});

									}
								});
								tempBtnClickPageNumber=$(this);
							});
				
					
					
				}))
	</script>
			
	