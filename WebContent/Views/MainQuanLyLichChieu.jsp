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
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-info mb-3" data-toggle="modal" data-target="#myModal">
                            Thêm Lịch Chiếu
                        </button>
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
                                                    <input class="form-control form-control-lg mb-3" type="text" placeholder="Tên Phim" name="titleFlim">
                                                    <input class="form-control form-control-lg mb-3" type="time" placeholder="Thời Gian Chiếu" name="titleFlim">
                                                    <input class="dropdown">
                                                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                        Rạp Chiếu
                                                    </button>
                                                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                                        <a class="dropdown-item" href="#">Action</a>
                                                        <a class="dropdown-item" href="#">Another action</a>
                                                        <a class="dropdown-item" href="#">Something else here</a>
                                                    </div>
                                                    <div>
                                                        
                                                    </div>
                                                </form>
                                          
                                    </div>
                                    <!-- Modal footer -->
                                    <div class="modal-footer">
                                       <button class="btn btn-primary float-right">Thêm lịch chiếu</button>
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
                                                <th scope="col" class="border-0">Rạp Chiếu</th>
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
        $(document).ready(function() {
        $.ajax({
            url: '${pageContext.request.contextPath}/XuatChieu',
            dataType: 'html',
            success: function(data) {
            	var obj = $.parseJSON(data);
                $.each(obj, function(index, el) {
                    $(
                            "<tr> <td>" +
                            el.id +
                            "</td><td>" +
                            el.id_Phim +
                            "</td><td>" +
                            el.id_RapChieu +
                            "</td><td>" +
                            el.thoiGianChieu +                         
                            "</td><td>" +
                            "<a href='#'><i class='fa fa-edit mr-3' style='font-size:24px'></i></a>" +
                            "<a href='#'><i class='fa fa-trash mr-3' style='font-size:24px'></i></a>"+
                            "</td>" +
                 
                            "</tr>")
                        .appendTo($("tbody"));
                });
            }
        });

    });
       </script>    