<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col">
	<div class="row justify-content-center">
		<div class="col-md-8 col-12 reviews-grids shadow pt-4 px-2">

			<div class="row justify-content-center pb-5 border-bottom ">
				<div class="col-md-3 col-5 border-right mr-auto text-center">
					<a href="single.html"><img src="${film.url_Image}" alt=""
						width="100%" /></a>
				</div>
				<div class="col-md-8 col-7 boder mr-auto">
					<a class="span " href="single.html"><i>${film.tieuDe}</i></a>
					<p class="dirctr">
						<a href="">${film.daoDien}</a>${film.tieuDe}</p>
					<p class="ratingview">Điểm Đánh Giá:</p>
					<div class="rating">
						<span>☆</span> <span>☆</span> <span>☆</span> <span>☆</span> <span>☆</span>
					</div>
					<p class="ratingview">&nbsp;${film.diemDanhGia}/5</p>
					<div class="clearfix"></div>

					<p class="info">Diễn viên:${film.dienVien}</p>
					<p class="info">Quốc gia:${film.quocGia}</p>

					<p class="info">Thời lượng:&nbsp;&nbsp;&nbsp;
						&nbsp;${film.doDai} phút</p>

					<div class="col-12 my-2 col-md-6 mr-auto px-0">
						<a href="#" tag="${flimHot.id}"
							class="btn btn-warning sizeBtn btnDatVe  py-auto"
							tag="${flimHot.id}" data-toggle="modal"
							data-target="#exampleModalLong"><i
							class="material-icons float-left" style="font-size: 28px">developer_board</i><span
							class="">Đặt Vé</span></a>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class=" border-bottom py-3">
			<div class="video">
			<iframe width="100%" src="${film.urlTrailer}" frameborder="0"
					allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
			</div>
				
				<h4>
					<u>Mô tả:</u>
				</h4>
				<p class="info">${film.moTa}</p>
			</div>

			<div class="BinhLuanPhim my-2">
				<h4 class="text-center">Bình luận</h4>
				<div class="form-group ">
					<label for="comment">Ký Danh:</label> <input type="text"
						class="form-control" placeholder="Tên của mày đấy hỏi cái beep"
						name="tenNguoiDanhGia"> <label for="comment">Comment:</label>
					<textarea class="form-control mb-2" rows="5" id="comment"
						name="chiTietDanhGia"></textarea>
					<a href="#areaDanhGia" class="btn btn-dark my" id="btnBinhLuan">Bình
						Luận</a>
				</div>

				<div class="comments-section-grids justify-conttent-center" id="areaDanhGia">
					<c:forEach items="${danhGiaList}" var="danhGia">
						<div class="col-md-10 comments-section-grid-text mb-2 border-bottom">
							<h4>
								<a href="#">${danhGia.tenKhachDanhGia}</a>
							</h4>
							<label>${danhGia.thoiGianDanhGia}</label>
							<p>${danhGia.chiTietDanhGia}</p>
							<span><a href="#">Reply</a></span> <i class="rply-arrow"></i>
							<div class="clearfix"></div>
						</div>
					</c:forEach>
					

				</div>
				<div class="text-center " style="cursor: pointer;" value=1 id="loadComment">Tải thêm
						bình luận...</div>
			</div>
		</div>
		<!-- <div class="col-md-3">
			<div class="featured">
				<h3>Featured Today in Movie Reviews</h3>
				<ul>
					<li><a href="single.html"><img src="images/f1.jpg" alt="" /></a>
						<p>lorem movie review</p></li>
					<li><a href="single.html"><img src="images/f2.jpg" alt="" /></a>
						<p>lorem movie review</p></li>
					<li><a href="single.html"><img src="images/f3.jpg" alt="" /></a>
						<p>lorem movie review</p></li>
					<li><a href="single.html"><img src="images/f4.jpg" alt="" /></a>
						<p>lorem movie review</p></li>
					<li><a href="single.html"><img src="images/f5.jpg" alt="" /></a>
						<p>lorem movie review</p></li>
					<li><a href="single.html"><img src="images/f6.jpg" alt="" /></a>
						<p>lorem movie review</p></li>
					<div class="clearfix"></div>
				</ul>
			</div>
			<div class="entertainment">
				<h3>Featured Today in Entertainment</h3>
				<ul>
					<li class="ent"><a href="single.html"><img
							src="images/f6.jpg" alt="" /></a></li>
					<li><a href="single.html">Watch ‘Bombay Velvet’ trailer
							during WC match</a></li>
					<div class="clearfix"></div>
				</ul>
				<ul>
					<li class="ent"><a href="single.html"><img
							src="images/f5.jpg" alt="" /></a></li>
					<li><a href="single.html">Watch ‘Bombay Velvet’ trailer
							during WC match</a></li>
					<div class="clearfix"></div>
				</ul>
				<ul>
					<li class="ent"><a href="single.html"><img
							src="images/f3.jpg" alt="" /></a></li>
					<li><a href="single.html">Watch ‘Bombay Velvet’ trailer
							during WC match</a></li>
					<div class="clearfix"></div>
				</ul>
				<ul>
					<li class="ent"><a href="single.html"><img
							src="images/f4.jpg" alt="" /></a></li>
					<li><a href="single.html">Watch ‘Bombay Velvet’ trailer
							during WC match</a></li>
					<div class="clearfix"></div>
				</ul>
				<ul>
					<li class="ent"><a href="single.html"><img
							src="images/f2.jpg" alt="" /></a></li>
					<li><a href="single.html">Watch ‘Bombay Velvet’ trailer
							during WC match</a></li>
					<div class="clearfix"></div>
				</ul>
				<ul>
					<li class="ent"><a href="single.html"><img
							src="images/f1.jpg" alt="" /></a></li>
					<li><a href="single.html">Watch ‘Bombay Velvet’ trailer
							during WC match</a></li>
					<div class="clearfix"></div>
				</ul>
			</div>
			<div class="might">
				<h4>You might also like</h4>
				<div class="might-grid">
					<div class="grid-might">
						<a href="single.html"><img src="images/mi.jpg"
							class="img-responsive" alt=""> </a>
					</div>
					<div class="might-top">
						<p>Lorem Ipsum is simply dummy text of the printing and
							typesetting industry.</p>
						<a href="single.html">Lorem Ipsum <i> </i></a>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="might-grid">
					<div class="grid-might">
						<a href="single.html"><img src="images/mi1.jpg"
							class="img-responsive" alt=""> </a>
					</div>
					<div class="might-top">
						<p>Lorem Ipsum is simply dummy text of the printing and
							typesetting industry.</p>
						<a href="single.html">Lorem Ipsum <i> </i></a>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="might-grid">
					<div class="grid-might">
						<a href="single.html"><img src="images/mi2.jpg"
							class="img-responsive" alt=""> </a>
					</div>
					<div class="might-top">
						<p>Lorem Ipsum is simply dummy text of the printing and
							typesetting industry.</p>
						<a href="single.html">Lorem Ipsum <i> </i></a>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="might-grid">
					<div class="grid-might">
						<a href="single.html"><img src="images/mi3.jpg"
							class="img-responsive" alt=""> </a>
					</div>
					<div class="might-top">
						<p>Lorem Ipsum is simply dummy text of the printing and
							typesetting industry.</p>
						<a href="single.html">Lorem Ipsum <i> </i></a>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			
			<div class="grid-top">
				<h4>Archives</h4>
				<ul>
					<li><a href="single.html">Lorem Ipsum is simply dummy text
							of the printing and typesetting industry. </a></li>
					<li><a href="single.html">Lorem Ipsum has been the
							industry's standard dummy text ever since the 1500s</a></li>
					<li><a href="single.html">When an unknown printer took a
							galley of type and scrambled it to make a type specimen book. </a></li>
					<li><a href="single.html">It has survived not only five
							centuries, but also the leap into electronic typesetting</a></li>
					<li><a href="single.html">Remaining essentially unchanged.
							It was popularised in the 1960s with the release of </a></li>
					<li><a href="single.html">Letraset sheets containing Lorem
							Ipsum passages, and more recently with desktop publishing </a></li>
					<li><a href="single.html">Software like Aldus PageMaker
							including versionsof Lorem Ipsum.</a></li>
				</ul>
			</div>
			
		</div> -->
		<div class="clearfix"></div>
	</div>
</div>
<script>
var getUrlParameter = function (sParam) {
    var sPageURL = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
};
$(document).ready(function() {
	var page=1;
  /*get value paramate*/
    $("#btnBinhLuan").click(function(event) {
        var tenNguoiDanhGia = $('[name="tenNguoiDanhGia"]').val();
        var chiTietDanhGia =$('[name="chiTietDanhGia"]').val();
        var idFilm=getUrlParameter("idFilm");
            $.ajax({
                url: '${pageContext.request.contextPath}/InfoFilm',
                type:"post",
                data: { tenNguoiDanhGia:tenNguoiDanhGia,chiTietDanhGia:chiTietDanhGia,idFilm:idFilm },
                dataType: "html",
                success: function(data) {
                	if(data="1")
                		{
               				$("<div class='col-md-10 comments-section-grid-text mb-2 border-bottom'>"
        							+"<h4>"
							+"<a href='#'>"+tenNguoiDanhGia+"</a>"
						+"</h4>"
						+"<label>Vừa Xong</label>"
						+"<p>"+chiTietDanhGia+"</p>"
						+"<span><a href='#'>Reply</a></span>"
						+"<div class='clearfix'></div>"
					+"</div>").appendTo($("#areaDanhGia"))	;
                		}
                	else
                		{
                		alert("Thất bại");
                		}
                }
            })

    });
    $("#loadComment").click(function(event) {
    	page=page+1;
    	 $.ajax({
             url: '${pageContext.request.contextPath}/InfoFilm',
             type:"get",
             data: { page:page},
             dataType: "html",
             success: function(data) {
             	if(data!=null)
             		{
             		var obj = $.parseJSON(data);
					console.log(obj);
					$.each(obj, function(index, el) {
						
						$("<div class='col-md-10 comments-section-grid-text mb-2 border-bottom'>"
     							+"<h4>"
							+"<a href='#'>"+el.tenKhachDanhGia+"</a>"
						+"</h4>"
						+"<label>"+el.thoiGianDanhGia+"</label>"
						+"<p>"+el.chiTietDanhGia+"</p>"
						+"<span><a href='#'>Reply</a></span>"
						+"<div class='clearfix'></div>"
					+"</div>").appendTo($("#areaDanhGia"))	;
					})		
             		}
             }
         })
    	
    });
})
</script>
