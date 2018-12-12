<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Snake JS Example</title>
<script src="${pageContext.request.contextPath}/ViewsWeb/jssnake-js.js" type="text/javascript"></script>
<script type="text/javascript">

// If you are using jQuery, use < $(document).ready(function(){ ... }) > instead
document.addEventListener("DOMContentLoaded", function(){

	// The DOM-element which will hold the playfield
	// If you are using jQuery, you can use < var element = $("#parent"); > instead
	var parentElement = document.getElementById("parent");

	// User defined settings overrides default settings.
	// See snake-js.js for all available options.
	var settings = {
		    frameInterval : 120,
		    backgroundColor : "#f3e698"
	};

	// Create the game object. The settings object is NOT required.
	// The parentElement however is required
	var game = new SnakeJS(parentElement, settings);

}, true);

</script>
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
	<style type="text/css">
	@font-face { font-family: cuccho; src: url("${pageContext.request.contextPath}/ViewsWeb/Font/Cucho Bold.otf"); } 
	.titleFilm{
	font-size:30px;
	font-family: cuccho, sans-serif;
	color: #ba900d;
	font-weight: bold;
}
	</style>

</head>
<body>

<h1>Chúc Quý Khách Một Ngày Đầy Vui Vẻ</h1>

<div id="parent"></div>

<p>
<strong>Use the arrow keys to control the snake.</strong>
</p>

<p>
Made by <a href="http://betamos.se/">Didrik Nordström</a>.
<br />
For more information, see the <a href="../README.md">README file</a>.
</p>

</body>
</html>