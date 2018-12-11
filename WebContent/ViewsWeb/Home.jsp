<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="shadow  mb-5  rounded">

	<div class="row mx-0 justify-content-center" style=" background-image:
		url(${flimHot.url_Image}); background-position:center; background-size: 100% 100%">
		<div class="ImgPhimHot col-md-9 " id="AreaImageFilmHot">
		</div>
		<div class="col-md-3" style="background-color: #4D4B4B;opacity: 0.85">
			<div class="header-info ">
				<div class="">
					<h2 style="text-align: center; font-weight: bold" class="text-light">${flimHot.tieuDe}</h2>
					<p class="age">
						<a href="#">All Age</a>${flimHot.dienVien}</p>
					<p class="review">Rating
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: &nbsp;&nbsp; 8,5/10</p>
					<p class="review reviewgo">Genre
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : &nbsp;&nbsp; Animation,
						Action, Comedy</p>
					<p class="review">Release &nbsp;&nbsp;&nbsp;&nbsp;:
						&nbsp;&nbsp; 7 November 2014</p>
					<div class="text-light">${flimHot.moTa}</div>

				</div>
			</div>


			<div class="row justify-content-center ">
				<a class="btn btn-info sizeBtn"
					href="${pageContext.request.contextPath}/InfoFilm?idFilm=${flimHot.id}"><i
					class="material-icons float-left" style="font-size: 28px">video_library</i><span
					class="text-center">XemChiTiet</span></a> <a href="#"
					class="btn btn-warning sizeBtn btnDatVe  py-auto"
					tag="${flimHot.id}" data-toggle="modal"
					data-target="#exampleModalLong"><i
					class="material-icons float-left" style="font-size: 28px">developer_board</i><span
					class="">Đặt Vé</span></a>
				<!--Model đặt vé-->
				
				<!--End modal-->
			</div>







		</div>
	</div>
</div>
<%@include file="modalDatVe.jsp"%>
<div class="review-slider border-top">

	<div class="row justify-content-center my-3 border-bottom">
		<h1 class="titleFilm border-bottom">Phim Đang Chiếu</h1>
	</div>
	<ul id="flexiselDemo1">
		<c:forEach items="${flimsDangChieu}" var="Film">
			<li class="container"><img class="FilmDangChieu"
				src="${Film.url_Image}" alt="" />
				<div class="overlay">
					<a href="#" class="btn btn-warning sizeBtn  py-auto btnDatVe"
						tag="${Film.id}" data-toggle="modal"
						data-target="#exampleModalLong"><i
						class="material-icons float-left" style="font-size: 28px">developer_board</i><span
						class="">Đặt Vé</span></a> <a
						href="${pageContext.request.contextPath}/InfoFilm?idFilm=${Film.id}"
						class="btn btn-info sizeBtn"" ><i
						class="material-icons float-left" style="font-size: 28px">video_library</i><span
						class="text-center">Xem Chi Tiết</span></a>
				</div></li>

		</c:forEach>
	</ul>
	<script type="text/javascript">
		$(window).load(function() {

			$("#flexiselDemo1").flexisel({
				visibleItems : 6,
				animationSpeed : 1000,
				autoPlay : false,
				autoPlaySpeed : 3000,
				pauseOnHover : true,
				enableResponsiveBreakpoints : true,
				responsiveBreakpoints : {
					portrait : {
						changePoint : 480,
						visibleItems : 2
					},
					landscape : {
						changePoint : 640,
						visibleItems : 3
					},
					tablet : {
						changePoint : 768,
						visibleItems : 4
					}
				}
			});
		});
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/ViewsWeb/js/jquery.flexisel.js"></script>
</div>
<!--	<div class="video">
			<iframe  src="https://www.youtube.com/embed/2LqzF5WauAw" frameborder="0" allowfullscreen></iframe>
		</div>-->
<!-- <div class="news">
				<div class="row">
					<div class="col-md-6 news-left-grid">
						<h3>Don’t be late,</h3>
						<h2>Book your ticket now!</h2>
						<h4>Easy, simple & fast.</h4>
						<a href="#"><i class="book"></i>BOOK TICKET</a>
						<p>
							Get Discount up to <strong>10%</strong> if you are a member!
						</p>
					</div>
					<div class="col-md-6 news-right-grid">
						<h3>News</h3>
						<div class="news-grid">
							<h5>Lorem Ipsum Dolor Sit Amet</h5>
							<label>Nov 11 2014</label>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua. Ut enim ad minim veniam, quis nostrud exercitation
								ullamco laboris nisi ut aliquip ex ea commodo.</p>
						</div>
						<div class="news-grid">
							<h5>Lorem Ipsum Dolor Sit Amet</h5>
							<label>Nov 11 2014</label>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua. Ut enim ad minim veniam, quis nostrud exercitation
								ullamco laboris nisi ut aliquip ex ea commodo.</p>
						</div>
						<a class="more" href="#">MORE</a>
					</div>
				</div>
				<div class="clearfix"></div>
			</div> -->
<div class="more-reviews border-top ">
	<div class="row justify-content-center my-3 border-bottom"><h1 class="titleFilm ">Phim Sắp Chiếu</h1></div>
	<ul id="flexiselDemo2">
		<c:forEach items="${filmsChuanBiChieu}" var="Film">
			<li class="container"><img src="${Film.url_Image}" alt="" />
				<div class="overlay">
					<a class="btn btn-info sizeBtn"
						href="${pageContext.request.contextPath}/InfoFilm?idFilm=${Film.id}"><i
						class="material-icons float-left" style="font-size: 28px">video_library</i><span
						class="text-center">XemChiTiet</span></a>
				</div></li>
		</c:forEach>
	</ul>
	<script type="text/javascript">
		$(window).load(function() {

			$("#flexiselDemo2").flexisel({
				visibleItems : 4,
				animationSpeed : 1000,
				autoPlay : true,
				autoPlaySpeed : 3000,
				pauseOnHover : false,
				enableResponsiveBreakpoints : true,
				responsiveBreakpoints : {
					portrait : {
						changePoint : 480,
						visibleItems : 2
					},
					landscape : {
						changePoint : 640,
						visibleItems : 3
					},
					tablet : {
						changePoint : 768,
						visibleItems : 3
					}
				}
			});
		});
	</script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/ViewsWeb/js/jquery.flexisel.js"></script>
</div>