<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <div class="main-content-container container-fluid px-4">
                    <!-- Page Header -->
                    <div class="page-header row no-gutters py-4">
                        <div class="col-12 col-sm-4 text-center text-sm-left mb-0">
                            <span class="text-uppercase page-subtitle">Dashboard</span>
                            <h3 class="page-title">Quản Lý Phòng Chiếu</h3>
                        </div>
                    </div>
                    <div class="col">
                        <div class="row">
                            <a href="#" class="btn mb-3 " role="button"><i class="material-icons" style="font-size:36px">edit</i></a>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <div class="card card-small mb-4">
                                <div class="card-body">
                                    <div class="row justify-content-center">
                                        <div class="col-lg-3 col-md-3 input-group dropdown">
                                            <input class="form-control form-control-lg dropdown-toggle " type="text" id="dropdownMenuDiaDiem" data-toggle="dropdown" placeholder="Địa Điểm">
                                            <div class="input-group-append ">
                                                <span class="input-group-text bg-light text-secondary"><i class="material-icons">keyboard_arrow_down</i></span>
                                            </div>
                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuDiaDiem">
                                                <select multiple class="form-control" id="sel2" name="country">
                                                    <option class="dropdown-item">Việt Nam</option>
                                                    <option class="dropdown-item">Lào</option>
                                                    <option class="dropdown-item">Campuchia</option>
                                                    <option class="dropdown-item">Mỹ</option>
                                                    <option class="dropdown-item">Ấn Độ</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-lg-3 col-md-3 input-group dropdown">
                                            <input class="form-control form-control-lg dropdown-toggle " type="text" id="dropdownMenuInput" data-toggle="dropdown" placeholder="Tên Rạp">
                                            <div class="input-group-append ">
                                                <span class="input-group-text bg-light text-secondary"><i class="material-icons">keyboard_arrow_down</i></span>
                                            </div>
                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuInput">
                                                <select multiple class="form-control" id="sel2" name="country">
                                                    <option class="dropdown-item">Việt Nam</option>
                                                    <option class="dropdown-item">Lào</option>
                                                    <option class="dropdown-item">Campuchia</option>
                                                    <option class="dropdown-item">Mỹ</option>
                                                    <option class="dropdown-item">Ấn Độ</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-lg-3 col-md-3 input-group dropdown">
                                            <input class="form-control form-control-lg dropdown-toggle " type="text" id="dropdownMenuInput" data-toggle="dropdown" placeholder="Tên Phòng">
                                            <div class="input-group-append ">
                                                <span class="input-group-text bg-light text-secondary"><i class="material-icons">keyboard_arrow_down</i></span>
                                            </div>
                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuInput">
                                                <select multiple class="form-control" id="sel2" name="country">
                                                    <option class="dropdown-item">Việt Nam</option>
                                                    <option class="dropdown-item">Lào</option>
                                                    <option class="dropdown-item">Campuchia</option>
                                                    <option class="dropdown-item">Mỹ</option>
                                                    <option class="dropdown-item">Ấn Độ</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--Bảng Quản Lý Ghế-->
                            <div class="card card-small mb-4">
                                <div></div>
                                <div class="card-body">
                                    <div class="col">
                                        <div class="row justify-content-center border-bottom">
                                            <div class="col-lg-2 col-md-2 border-right border-left">
                                                <div class="float-left"><span>Tổng Số Hàng:</span></div>
                                                <div class="float-right"><span>8</span></div>
                                            </div>
                                            <div class="col-lg-2 col-md-2 border-right">
                                                <div class="float-left"><span>Tổng Số Ghế Đơn:</span></div>
                                                <div class="float-right"><span>8</span></div>
                                            </div>
                                            <div class="col-lg-2 col-md-2 border-right">
                                                <div class="float-left"><span>Tổng Số Đôi :</span></div>
                                                <div class="float-right"><span>8</span></div>
                                            </div>
                                        </div>
                                        <div class="ChiTietGhe">
                                            <div class="table-responsive">
                                                <table class="table">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col" class="border-0"></th>
                                                            <th scope="col" class="border-0">0</th>
                                                            <th scope="col" class="border-0">1</th>
                                                            <th scope="col" class="border-0">2</th>
                                                            <th scope="col" class="border-0">3</th>
                                                            <th scope="col" class="border-0">4</th>
                                                            <th scope="col" class="border-0">5</th>
                                                            <th scope="col" class="border-0">6</th>
                                                            <th scope="col" class="border-0">7</th>
                                                            <th scope="col" class="border-0">8</th>
                                                            <th scope="col" class="border-0">9</th>
                                                            <th scope="col" class="border-0">10</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <th scope="row">Hàng A</th>
                                                            <td><label class="checkbox-inline"><input type="checkbox" value=""></label></td>
                                                            <td><label class="checkbox-inline"><input type="checkbox" value=""></label></td>
                                                            <td><label class="checkbox-inline"><input type="checkbox" value=""></label></td>
                                                            <td><label class="checkbox-inline"><input type="checkbox" value=""></label></td>
                                                            <td><label class="checkbox-inline"><input type="checkbox" value=""></label></td>
                                                            <td><label class="checkbox-inline"><input type="checkbox" value=""></label></td>
                                                            <td><label class="checkbox-inline"><input type="checkbox" value=""></label></td>
                                                            <td><label class="checkbox-inline"><input type="checkbox" value=""></label></td>
                                                            <td><label class="checkbox-inline"><input type="checkbox" value=""></label></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
