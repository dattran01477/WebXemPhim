<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Cinema</title>
<link
	href="${pageContext.request.contextPath}/ViewsWeb/css/bootstrap.css"
	rel='stylesheet' type='text/css' />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/ViewsWeb/css/style.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Custom Theme files -->
<script
	src="${pageContext.request.contextPath}/ViewsWeb/js/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/gijgo@1.9.10/js/gijgo.min.js"
	type="text/javascript"></script>
<link href="https://cdn.jsdelivr.net/npm/gijgo@1.9.10/css/gijgo.min.css"
	rel="stylesheet" type="text/css" />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Cinema Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
    addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);

    function hideURLbar() { window.scrollTo(0, 1); }
    



</script>
<!--webfont-->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>
</head>

<body>
	<!-- header-section-starts -->
	<div class="row mx-0">
		<div class="container-fluid px-0">
			<div class="">
				<div class="row mx-0">
					<div class="row w-100 mx-0">
						<div class="main col-md-12 col-lg-12 col-12 px-0">
							<%@include file="Header.jsp"%>
							<%@include file="Home.jsp"%>
							<%@include file="Footer.jsp"%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="clearfix"></div>



	<div class="modal fade bd-example-modal-md" id="FilmHot">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal body -->
				<div class="modal-body">
					<iframe id="linkFilmHot" width="100%" height="100%"
						src="${flimHot.urlTrailer}" frameborder="0"
						allow="accelerometer; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade bd-example-modal-md" id="FilmDangChieu">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal body -->
				<div class="modal-body">
					<iframe id="linkFilmHot" width="100%" height="100%"
						src="${flimHot.urlTrailer}" frameborder="0"
						allow="accelerometer; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
	$(window).resize(function() {
		var width = $("#AreaImageFilmHot").width();
		var height = $("#AreaImageFilmHot").height();
		var image = $("#ImageFilmHot");
		image.height(width / 3 * 2.1);
		image.width(width);

		var widthImgFilmDang = $(".FilmDangChieu").width();
		var imageFilmDangChieu = $(".FilmDangChieu");
		imageFilmDangChieu.height(widthImgFilmDang * 1.5);

	});
	$(document).ready(function() {
		var width = $("#AreaImageFilmHot").width();
		var height = $("#AreaImageFilmHot").height();
		var image = $("#ImageFilmHot");
		image.height(width / 3 * 2);
		image.width(width);

		var widthImgFilmDang = $(".FilmDangChieu").width();
		var imageFilmDangChieu = $(".FilmDangChieu");
		imageFilmDangChieu.height(widthImgFilmDang * 1.5);

	});
</script>
</html>