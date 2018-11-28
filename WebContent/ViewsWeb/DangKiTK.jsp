<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="h-100">
<head>
<title>Cinema</title>
<link
	href="${pageContext.request.contextPath}/ViewsWeb/css/bootstrap.css"
	rel='stylesheet' type='text/css' />
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
<body class="h-100">
<div class="container  h-100">
	<div class="col h-100">
		<div class="row h-100 justify-content-center align-items-center">
			<div class="col-12 col-md-5 py-3 px-2 shadow " style="border-radius: 30px;">
			<h3 class="text-center border-bottom mb-3">Đăng kí tài khoản</h3>
			
				<input class="form-control form-control-lg mb-3" type="text"
					placeholder="UserName" name="userName"> <input
					class="form-control form-control-lg mb-3" type="password"
					placeholder="PassWord" name="passWord" id="pass_reg"> <input
					class="form-control form-control-lg mb-3" type="password"
					placeholder="Nhập Lại PassWord" id="pass_check">
				<p id="message"></p>
				<div class="col-md-8 col-8 mx-auto">
				<button class="btn btn-primary col-md-12 col-12 " id="btnAddAccount">Thêm Tài Khoản</button>
				</div>
			
			</div>
		</div>
	</div>
	</div>
</body>
  <script>
$(document).ready(function() {

    //check kí tự nhập vào của xác thực mật khẩu
    $("#pass_check").keyup(function(event) {
        var a = $("#pass_reg").val();
        var b = $("#pass_check").val();
        if (a == b) {
            $("#message").css("color", "GreenYellow");
            $('#message').text('Sẵn sàng');
        } else {
            $("#message").css("color", "red");
            $('#message').text('Mật khẩu vừa nhập không đúng');
        }
    });
    //ajax 
        $("#btnAddAccount").click(function(event) {
        	  var userName=$('[name="userName"]').val();
              var pass=$('[name="passWord"]').val();
        	  if(userName!=null&&pass!=null)
        	    {
        		  $.ajax({
                      url: '${pageContext.request.contextPath}/AddUserServlet',
                      type: 'POST',
                      data: { userName: userName,passWord:pass},
                      dataType:"html",
                      success:function(data){
                          $("#message").css("color","GreenYellow");
                          $("#message").text(data);
                          alert(data);
                      }
                  });
        	    }
        	  else
        	    {
        	        alert("Điền đầy đủ")
        	    }
        /* Act on the event */
      
            

    });
    
   
    

})
</script>
</html>