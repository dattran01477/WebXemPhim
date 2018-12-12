<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="top-header shadow p-3 mb-1  rounded">
	<div class="logo">
		<a href="${pageContext.request.contextPath}"><img
			src="${pageContext.request.contextPath}/ViewsWeb/images/logo.png"
			alt="" /></a>
		<p style="color: #6b6b6b;">Movie Theater</p>
	</div>
	<nav class="navbar navbar-expand-sm navbar-light ">


		<button class="navbar-toggler ml-auto" type="button"
			data-toggle="collapse" data-target="#navbarSupportedContent">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse flex-grow-0 ml-auto"
			id="navbarSupportedContent">
			<ul class="navbar-nav text-right">
			<li class="nav-item  border-right"><a class="nav-link" href="${pageContext.request.contextPath}/ViewsWeb/GioiThieu.jsp">Giới Thiệu</a></li>
			<li class="nav-item  border-right"><a class="nav-link" href="#" id="btnGiaTri">Giải Trí</a></li>
				<c:if test="${not empty loginedUser}">	
					
							<li class="nav-item  border-right"><a class="nav-link" href="${pageContext.request.contextPath}/TrangQuanLy">Quản Lý</a></li>
					
					<li class="nav-item  "><a class="nav-link" href="${pageContext.request.contextPath}/Logout">Đăng
							Xuất</a></li>
							<span style="font-size: 10px; color: #D8D90A">${loginedUser.user} | số dư  ${loginedUser.soDuTK}  </span>
				</c:if>
				<c:if test="${empty loginedUser}">
					<li class="nav-item  border-right"><a class="nav-link" href="${pageContext.request.contextPath}/Login">Đăng
							Nhập</a></li>
							
					<li class="nav-item  border-right"><a class="nav-link" href="${pageContext.request.contextPath}/ViewsWeb/DangKiTK.jsp">Đăng
							kí</a></li>
				</c:if>
			</ul>
		</div>
	</nav>
</div>
<script src="${pageContext.request.contextPath}/ViewsWeb/js/snake-js.js" type="text/javascript"></script>
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
$(document).ready(function() {
	$("#btnGiaTri").click(function(){
		$("#modalGame").modal();
	})
	
	
})

</script>
<div class="modal" tabindex="-1" role="dialog" id="modalGame">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Chúc Quý Khách Một Ngày Vui Vẻ!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div id="parent"></div>
      </div>
      <div class="modal-footer">
        
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
