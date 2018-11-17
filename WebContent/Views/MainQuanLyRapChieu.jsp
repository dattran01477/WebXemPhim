<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

                <div class="main-content-container container-fluid px-4">
                    <!-- Page Header -->
                    <div class="page-header row no-gutters py-4">
                        <div class="col-12 col-sm-4 text-center text-sm-left mb-0">
                            <span class="text-uppercase page-subtitle">Dashboard</span>
                            <h3 class="page-title">Quản Lý Rạp Chiếu</h3>
                        </div>
                    </div>
                    <div class="col">
                        <div class="row">
                            <button type="button" class="btn btn-info mb-3" data-toggle="modal" data-target="#myModal">
                                Thêm Rạp Chiếu
                            </button>
                            <!-- The Modal -->
                            <div class="modal" id="myModal">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <!-- Modal Header -->
                                        <div class="modal-header">
                                            <h4 class="modal-title">Thêm Rạp Chiếu</h4>
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        </div>
                                        <!-- Modal body -->
                                        <div class="modal-body">
                                            <form class="add-new-post">
                                                <input class="form-control form-control-lg mb-3" type="text" placeholder="Địa Điểm" name="titleFlim">
                                                <input class="form-control form-control-lg mb-3" type="time" placeholder="Tên Rạp" name="titleFlim">
                                            </form>
                                        </div>
                                        <!-- Modal footer -->
                                        <div class="modal-footer">
                                            <button class="btn btn-primary float-right">Thêm rạp chiếu</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-3 float-right">
                                <div class="dropdown ">
                                    <button class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown"> <i class='fas fa-filter' style='font-size:14px'></i></button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Hcm</a></li>
                                        <li><a href="#">Cần Thơ</a></li>
                                        <li><a href="#">...</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="card card-small mb-4">
                                <div class="card-header border-bottom">
                                    <h6 class="m-0">Danh Sách Rạp Chiếu</h6>
                                </div>
                                <div class="card-body p-0 pb-3 text-center">
                                    <table class="table mb-0">
                                        <thead class="bg-light">
                                            <tr>
                                                <th scope="col" class="border-0">Mã Rạp Chiếu</th>
                                                <th scope="col" class="border-0">Tên</th>
                                                <th scope="col" class="border-0">Địa Chỉ</th>
                                                <th scope="col" class="border-0">Số Lượng Rạp Hiện Tại</th>                                      
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
           