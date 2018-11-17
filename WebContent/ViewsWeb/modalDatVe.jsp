<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="exampleModalLong" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLongTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">

		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Đặt vé</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="col">
					<select class="custom-select border-bottom" id="inputGroupSelect01"
						name="diaDiem">
						<option selected>Khu Vực</option>
						<c:forEach items="${listKhuVuc}" var="item">
							<option value="${item}" class="khuVucOption">${item}</option>
						</c:forEach>
					</select>
					<div class="border-top mt-3 py-3">
						<h6 class="mb-1">Ngày đặt vé:</h6>
						<input id="datepicker" width="276" />
						<script>
							$('#datepicker').datepicker({
								uiLibrary : 'bootstrap4'
							});
						</script>
					</div>
					<div class="border-top mt-3 py-3">
						<select class="custom-select border-bottom"
							id="inputGroupSelect02">
							<option selected>Rap:</option>							
						</select>
					</div>
					<div>
						<!--card thông tin rạp chiếu-->
						<div id="infoXuatChieu">
							
						
						</div>
					

						<!--end card-->
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				<a href="booking-seat.html" class="btn btn-primary">Chọn ghế
					ngồi</a>
			</div>
		</div>
	</div>
</div>
<script>
$(document).ready(
	    function() {
	 $("#inputGroupSelect01").change(function(event) {
		
			 $.ajax({
	                      url: '${pageContext.request.contextPath}/ModalDatVeServlet',
	                      
	                      data: { type: 1,diaDiem:$(this).val()},
	                      dataType:"html",
	                      success:function(data){
	                      	var obj = $.parseJSON(data);	                       
	                         $.each(obj,function(index, el) {
	                         	$("<option >"+el+"</option>").appendTo($("#inputGroupSelect02"))
	                         });
	                      }
	                  });
			});
	 var currentIdFilm=-1;
	 $(".btnDatVe").click(function(event) {
		 currentIdFilm=$(this).attr("tag");
		});
	 $("#inputGroupSelect02").change(function(event) {
		 $("#infoXuatChieu").empty();
		 $.ajax({
                      url: '${pageContext.request.contextPath}/ModalDatVeServlet',
                      
                      data: { type: 2,loai:$(this).val(),diaDiem:$("#inputGroupSelect01").val(),date:$("#datepicker").val(),idFilm:currentIdFilm},
                      dataType:"html",
                      success:function(data){
                      	
                      	var obj = $.parseJSON(data);	
                      	var a="";
                      // Vòng lặp in thông tin xuất chiếu
                      	for (key in obj) {
                      	    if (obj.hasOwnProperty(key)) {
                      	    	
                      	    	
                      	    	for(var i=0;i<obj[key].length;i++)
                  	        	{
									a=a+'<a href="${pageContext.request.contextPath}/DatVe?idPhim='+currentIdFilm+'&idXC='+obj[key][i]["id"]+'&NgayXemPhim='+$("#datepicker").val()+'"" class="btn btn-secondary mx-1"><p>'+obj[key][i]["gioChieu"]+'</p>Số ghế Trống:'
									+'	<p>'+obj[key][i]["soChoNgoiTrong"]+'</p>'
									+'</a>'
                  	        	}
                      	    	$('<div class="card mb-2">'
            							+'<div class="card-body">'
            							+	'<h4 class="card-title">'+key+'</h4>'
            							+ a
            							+'</div>'
            							
            						+'</div>').appendTo($("#infoXuatChieu"));
                      	    }
                      	    a="";
                      	}
                      //End loop khủng khiếp!

                      	
                      }
                  });
		});
			    }
	);
</script>
