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
			<li class="nav-item active border-right"><a class="nav-link" href="${pageContext.request.contextPath}/ViewsWeb/GioiThieu.jsp">Giới Thiệu</a></li>
				<c:if test="${not empty loginedUser}">	
					<c:forEach items="${loginedUser.roles}" var="role">
						 <c:if test = "${role eq 'ad'}">
							<li class="nav-item active border-right"><a class="nav-link" href="${pageContext.request.contextPath}/TrangQuanLy">Trang Quản Lý</a></li>
						</c:if>
						 <c:if test = "${role eq 'cu'}">
							<li class="nav-item active border-right"><a class="nav-link" href="${pageContext.request.contextPath}/TrangQuanLy">Thông tin cá nhân</a></li>		
						</c:if>
						 
					</c:forEach>
					<li class="nav-item active border-right"><a class="nav-link" href="Logout">Đăng
							Xuất</a></li>
				</c:if>
				<c:if test="${empty loginedUser}">
					<li class="nav-item active border-right"><a class="nav-link" href="Login">Đăng
							Nhập</a></li>
					<li class="nav-item active border-right"><a class="nav-link" href="${pageContext.request.contextPath}/ViewsWeb/DangKiTK.jsp">Đăng
							kí</a></li>
				</c:if>
			</ul>
		</div>
	</nav>
</div>
