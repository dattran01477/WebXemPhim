<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Cinema A Entertainment Category Flat Bootstarp Resposive
	Website Template | Home :: w3layouts</title>
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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
		<div class="container-fluid">
			<div class="">
				<div class="row mx-0">
					<div class="row w-100 mx-0">
						<div class="main col-md-12 col-lg-12 col-12 px-0">
							<div class="">
								<!-- include header -->
								<%@include file="Header.jsp"%>

							</div>
							<div id="mainload">
								<div class="col">
									<div class="row justify-content-center">
										<div
											class="card card-small mb-4 mx-0  col-sm-12 col-md-8 shadow p-3 mb-5 bg-white rounded">

											<div class="card-body">
												<div class="col">
													<div class="row justify-content-center ">
														<div class="col-md-6 col-sm-12 ">
															<div
																class="row justify-content-center border mb-5  rounded-circle"
																style="background-color: #D88A04;">
																<h3>Screening</h3>
															</div>
														</div>
													</div>
													<div class="ChiTietGhe">
														<div class="table-responsive">
															<table class="table">
																<thead id="headerbookingseat">

																</thead>
																<tbody id="bodybookingseat">


																</tbody>
															</table>
														</div>
													</div>
												</div>
											</div>
											<div></div>
										</div>

										<div
											class="card card-small ml-3 mb-4 mx-0  col-sm-12 col-md-3 shadow p-3 mb-5 bg-white rounded">

											<div class="card-body">
												<h4 class="card-title border-bottom text-center"
													style="color: #D88A04;">Thông tin thanh toán Phim</h4>
												<div class="col">
													<div class="border-bottom py-5">
														<div class="row my-2 py-3 border-bottom">
														
															<div class="text-center">
																<h5 id="tenPhim" style="font-weight: bold;"></h5>
															</div>
															<div class="col-md-5 col-5 " style="color: #D88A04;">
																<h5 class="mr-auto">Giá Vé:</h5>
															</div>
															<div class="text-center  ">
																<h5 id="giaVe"></h5> 
															</div>
														</div>
														<div class="row">
															<div class="col-md-5 col-5 " style="color: #D88A04;">
																<h5 class="mr-auto">Chi tiết Vé:</h5>
															</div>
															<div class="text-center">
																<h5 id="maGhe"></h5>
															</div>
														</div>
														<div class="row">
															<div class="col-md-5 col-5 " style="color: #D88A04;">
																<h5 class="mr-auto">Thời Gian:</h5>
															</div>
															<div class="text-center">
																<h5 id="ngayXemPhim">

																	<h5>
															</div>
														</div>
														<div class="row">
															<div class="col-md-5 col-5 " style="color: #D88A04;">
																<h5 class="mr-auto">Tổng tiền:</h5>
															</div>
															<div class="text-center">
																<h5 id="tongGia">

																	<h5>
															</div>
														</div>

													</div>
													<div class="card-footer ">
														<input type="text" id="sdtDatVe" class="form-control"
															placeholder="Số Điện Thoại:" aria-label="Số Điện Thoại:"
															aria-describedby="basic-addon2">
													</div>
													<div class="col-md-6	 col-3 ml-auto mt-3">
														<button type="button" class="btn btn-secondary "
															id="btnThanhToan">Thanh Toán</button>

													</div>


												</div>
											</div>


										</div>
									</div>
								</div>
							</div>

							<div class=""></div>
						</div>
					
					</div>
					
				</div>
			</div>
		</div>
	</div>
<%@include file="Footer.jsp"%>
	<div class="modal fade" id="exampleModalLong" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">

			<div class="modal-content">
				<div class="modal-header">
					<h2 class="modal-title " id="exampleModalLabel">Bạn có chắc
						chắn đặt các vé sau không!</h2>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<button id="btnXacNhan" type="button"  class="btn btn-primary">Xác nhận</button>
			</div>
		</div>
	</div>
	</div>

	<script type="text/javascript">
	function removeFromArray(array, item, index) {
		  while((index = array.indexOf(item)) > -1) {
		    array.splice(index, 1);
		  }
		}
	function loadSeat()
	{
		  var a='<th scope="col" class="border-0 text-center "></th>';
			    var dsGheChon=[];
		    var tongGhe=${tongGhe};
		    var soHang=${soHang};
		    var soCot=${soCot};
		    var dem=0;
		   <c:forEach items="${ListGheDaDat}" var="element"> 
		    dsGheChon.push('${element}')
		  </c:forEach>
		   if(dsGheChon.length==tongGhe)
			   {
			   alert("Hết ghế trống mời bạn quay lại sau");
			   var i=2;
               var interval_obj = setInterval(function(){
                  i=i-1;
                 if(i==0)
                 {
              	   window.location.href = "${pageContext.request.contextPath}";
              	   clearInterval(interval_obj);
                 }
                  
                  
               },1000);
              
			   }
		   else
			   {
			   
			   for(var i=0;i<soCot;i++)
			    {
			        a=a+'<th scope="col" class="border-0  px-0 py-0" width="30">'+i+'</th>'
			    }
			    $('<tr style="font-size:12px;">'+a+'</tr>').appendTo($("#headerbookingseat"));
			    a="";
			    var id="";
			    var idTmp="";
			    for(var i=65;i<65+soHang;i++)
			    {
			    	id=String.fromCharCode(i)+"_";
			    	tmp=id;
			        for(var j=0;j<soCot;j++)
			    {
			        	if(dem==tongGhe)
			        		{
			        		return;
			        		}
			        	else
			        		{
			        		id=tmp+j;
			            	if(dsGheChon.includes(id))
			            a=a+' <td class="py-0 px-0 " ><label class="checkbox-inline px-0"><i class="material-icons selectseat" tag='+String.fromCharCode(i)+"_"+j+'  style="font-size:12px; background-color:red; disabled" isSelect="0">check_box_outline_blank</i></label></td>';
			            else
			                a=a+' <td class="py-0 px-0" ><label class="checkbox-inline px-0"><i class="material-icons selectseat" tag='+String.fromCharCode(i)+"_"+j+' style="font-size:12px; cursor:pointer;" isSelect="0">check_box_outline_blank</i></label></td>';	
			                dem=dem+1;
			        		}
			        	
			    }
			    $('<tr style="font-size:12px;"><th scope="row" class="py-0" width="30">'+String.fromCharCode(i)+'</th>'+a+'</tr>').appendTo($("#bodybookingseat"));
			    a="";
			    }   
			   }
		  
	}
	function load(tenFilm,ngayXemPhim,giaTien)
	{
		$("#tenPhim").append(tenFilm);
		$("#ngayXemPhim").append(ngayXemPhim);
		$("#giaVe").append(giaTien+" VND");
	}
	$(document).ready(function() {
		loadSeat();
		
		var arraySelectSeat=[];
		var giaTien=95000;
		var tongTien=0;
		var soVe=0;
		var idXC=${idXC};
		var tenFilm='${tenPhim}';
		var ngayXemPhim='${ngayXemPhim}';
		var idFilm=${idFilm};
		load(tenFilm,ngayXemPhim,giaTien);
		$(".selectseat").click(function(event) {
			if($(this).attr("isSelect")=="0")
    		{
			
			$("#maGhe").empty();
			$("#tongGia").empty();
    		$(this).css("background-color", "#00FE00");
    		arraySelectSeat.push($(this).attr("tag"));
    		for (var i = 0; i < arraySelectSeat.length; i++)
    			{
    			$("#maGhe").append(arraySelectSeat[i]+", ");
    			}
    		soVe=arraySelectSeat.length;
    		tongTien=giaTien*soVe;
    		
    		$("#tongGia").append(tongTien+" VND");
    		
    		$(this).attr("isSelect","1");
    		}
    		else
    		{
    			$("#maGhe").empty();
    			$("#tongGia").empty();
    		$(this).css("background-color", "transparent");
    		removeFromArray(arraySelectSeat,$(this).attr("tag"));
    		for (var i = 0; i < arraySelectSeat.length; i++)
			{
			$("#maGhe").append(arraySelectSeat[i]+", ");
			}
    		soVe=arraySelectSeat.length;
    		tongTien=giaTien*soVe;
    		
    		$("#tongGia").append(tongTien+" VND");
    		$(this).attr("isSelect","0");
    		}    	
			});
	/* 	$("#btnThanhToan").click(function(event){
			
			$("#exampleModalLong").modal();
			
		}); */
		$("#btnThanhToan").click(function(event) {
			 $.ajax({
                 url: '${pageContext.request.contextPath}/ThanhToan',
                 data: {idFilm:idFilm,arraySelectSeat:arraySelectSeat,tongTien:tongTien,ngayXemPhim:ngayXemPhim,idXC:idXC,sdtDatVe:$("#sdtDatVe").val()},
                 dataType:"html",
                 success:function(data){
                 	
                	 
                	 
                	if(data=="1")
                		{
                		
                		$("#mainload")
						.load(
								"${pageContext.request.contextPath}/ViewsWeb/ModalSuccessful%20.jsp");
                		 var i=5;
                         var interval_obj = setInterval(function(){
                            i=i-1;
                            $("#idSecond").empty();
                            $("#idSecond").text(i);
                           if(i==0)
                           {
                        	   window.location.href = "${pageContext.request.contextPath}";
                        	   clearInterval(interval_obj);
                           }
                            
                            
                         },1500);
                		}
                	else
                		{
                		alert("số dư không đủ xin vui lòng nạp thêm tiền");
                		}
                	
                 //End loop khủng khiếp!

                 	
                 }
             });
	});
		
	});
	</script>
</body>

</html>