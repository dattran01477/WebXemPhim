<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

                <div class="main-content-container container-fluid px-4">
                    <!-- Page Header -->
                    <div class="page-header row no-gutters py-4">
                        <div class="col-12 col-sm-4 text-center text-sm-left mb-0">
                            <span class="text-uppercase page-subtitle">Dashboard</span>
                            <h3 class="page-title">Quản Lý Phim</h3>
                        </div>
                    </div>
                    <div class="col">
                        <div class="row">
                            <button type="button" class="btn btn-info mb-3" data-toggle="modal" data-target="#myModal">
                                Thêm Người dùng
                            </button>
                            <!-- The Modal -->
                            <div class="modal" id="myModal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <!-- Modal Header -->
                                        <div class="modal-header">
                                            <h4 class="modal-title">Thêm Người Dùng</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <!-- Modal body -->
                                        <div class="modal-body">
                                            <form class="add-new-post">
                                                <input class="form-control form-control-lg mb-3" type="text" placeholder="UserName" name="userName">
                                                <input class="form-control form-control-lg mb-3" type="password" placeholder="PassWord" name="passWord" id="pass_reg">
                                                <input class="form-control form-control-lg mb-3" type="password" placeholder="Nhập Lại PassWord" id="pass_check">
                                                <p id="message"></p>
                                                <div class="row justify-content-center">
                                                   <div class="col-md-3  form-check ">
                                                    <input class="form-check-input" type="checkbox" name="roleName" value="ad" id="defaultCheck1">
                                                    <label class="form-check-label" for="defaultCheck1">
                                                        Chức Vụ Admin
                                                    </label>
                                                </div>
                                                 <div class="col-md-3   form-check ">
                                                    <input class="form-check-input" type="checkbox" name="roleName" value="cu" id="defaultCheck2">
                                                    <label class="form-check-label" for="defaultCheck2">
                                                        Chức Vụ User
                                                    </label>
                                                </div>
                                                </div>
                                               
                                            </form>
                                        </div>
                                        <!-- Modal footer -->
                                        <div class="modal-footer">
                                            <button class="btn btn-primary float-right" id="btnAddAccount">Thêm Tài Khoản</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 float-right">
                                <div class="dropdown ">
                                    <button class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown"> <i class='fas fa-filter' style='font-size:14px'></i></button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Admin</a></li>
                                        <li><a href="#">User</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="card card-small mb-4">
                                <div class="card-header border-bottom">
                                    <h6 class="m-0">Danh Sách Phim</h6>
                                </div>
                                <div class="card-body p-0 pb-3 text-center">
                                    <table class="table mb-0">
                                        <thead class="bg-light">
                                            <tr>
                                                <th scope="col" class="border-0">Mã Tài Khoản</th>
                                                <th scope="col" class="border-0">Tên</th>
                                                <th scope="col" class="border-0">Số Điện Thoại</th>
                                                <th scope="col" class="border-0">Địa Chỉ</th>
                                                <th scope="col" class="border-0">Tuổi</th>
                                                <th scope="col" class="border-0">Giới Tính</th>
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
    //getRoleNam

    var roleName="";
    $('[name="roleName"]').change(function() {
        if ($(this).is(':checked')) {
            // Do something...
          roleName =$(this).val();
        } 
    });
    //ajax 
        $("#btnAddAccount").click(function(event) {
        	  var userName=$('[name="userName"]').val();
              var pass=$('[name="passWord"]').val();
        	  if(roleName!=""&&userName!=null&&pass!=null)
        	    {
        		  $.ajax({
                      url: '${pageContext.request.contextPath}/AddUserServlet',
                      type: 'POST',
                      data: { userName: userName,passWord:pass,roleName:roleName},
                      dataType:"html",
                      success:function(data){
                          $("#message").css("color","GreenYellow");
                          $('#message').text(data);
                      }
                  });
        	    }
        	  else
        	    {
        	        alert("Vui lòng chọn chức vụ")
        	    }
        /* Act on the event */
      
            

    });
    
   
    

})
</script>
           