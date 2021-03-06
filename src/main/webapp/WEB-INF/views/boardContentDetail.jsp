<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Directory Theme by Bootstrapious</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<!-- Price Slider Stylesheets -->
<link rel="stylesheet" href="resources/vendor/nouislider/nouislider.css">
<!-- Google fonts - Playfair Display-->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700">
<!-- Google fonts - Poppins-->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,400i,700">
<!-- swiper-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.4.1/css/swiper.min.css">
<!-- Magnigic Popup-->
<link rel="stylesheet" href="resources/vendor/magnific-popup/magnific-popup.css">
<!-- Leaflet Maps-->
<link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css" integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ==" crossorigin="">
<!-- theme stylesheet-->
<link rel="stylesheet" href="resources/css/style.default.css" id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet" href="resources/css/custom.css">
<!-- Favicon-->
<link rel="shortcut icon" href="resources/img/favicon.png">
<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
<!-- Font Awesome CSS-->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<style>
.swiper-slide {
	overflow: hidden;
	display: flex;
	align-items: center;
}

#list_img {
	width: 380px;
	height: auto;
}
</style>
</head>
<body style="padding-top: 72px;">
	<!-- HEADER include -->
	<jsp:include page="subHeader.jsp" />
	<section class="py-5 bg-gray-100 mp-5">
		<div class="container">
			<div class="text-center pb-lg-4">
				<p class="subtitle text-secondary">Title</p>
				<h3 class="mb-4">${info.TITLE}</h3>
			</div>
		</div>
		<div class="container">
			<!-- Slider main container-->
			<div class="swiper-container detail-slider slider-gallery">
				<!-- Additional required wrapper-->
				<div class="swiper-wrapper">
					<!-- Slides-->
					<c:forEach var="row" items="${img}">
						<div class="swiper-slide">
							<a href="${row.image_path}" data-toggle="gallery-top" title="Our street">
								<img class="img-fuild" id="list_img" src="${row.image_path}" alt="Our street">
							</a>
						</div>
					</c:forEach>
				</div>
				<div class="swiper-pagination swiper-pagination-white"></div>
				<div class="swiper-button-prev swiper-button-white"></div>
				<div class="swiper-button-next swiper-button-white"></div>
			</div>
		</div>
	</section>
	<div class="container col-lg-7 mt-5">
		<div class="text-block d-flex">
			<img class="avatar avatar-md p-1 flex-shrink-0 me-4" src="resources/img/avatar/avatar-10.jpg" alt="Jack London">
			<p class="col">
				<span class="text-muted text-uppercase text-sm">Write by </span> <br> <strong>${info.WRITER}</strong>
			</p>
			<p class="col">
				<span class="text-muted text-sm"> ????????? </span> <br> ${info.REG_DATE}
			</p>
		</div>
		<div class="text-block">
			<div class="d-flex">
				<p style="white-space: pre-line;" class="text-muted text-sm mb-2">${info.CONTENT}</p>
			</div>
		</div>
	</div>
	<div class="container col-lg-7 mt-5">
		<div class="text-block"></div>
		<div class="py-3 d-grid gap-2 d-md-flex justify-content-md-end">
			<button class="btn btn-primary h-100" onClick="location.href='boardUpdateMove.do?board=${board}&board_no=${board_no}'">????????????</button>
			<button class="btn btn-primary h-100" onClick="location.href='deleteBoard.do?board=${board}&board_no=${board_no}'">??? ??????</button>
			<button class="btn btn-primary h-100" type="button" onclick="history.go(-1)">????????????</button>
		</div>
	</div>
	
	<%-- <c:if test="${ board eq 'QnA'}">
		<!-- Reply Start  -->
		<div class="container col-lg-7">
			<form class="form" id="postUpReplyMain" method="post" action="insertReplyMain.do?board=${board}" enctype="multipart/form-data">
				<div class="py-3 d-grid gap-2 d-md">
					<textarea class="form-control" style="resize: none;" rows="3" name="content" id="content" placeholder="Leave your comment" required="required"></textarea>
					<button id="submit" class="btn btn-primary h-100">??????</button>
				</div>
			</form>
		</div>
		<div class="container col-lg-7 mt-5">
			<h6>COMMENTS</h6>
			<div id="replyList" class="text-block">
				<!-- ?????? -->
				<div class="d-flex review" style="padding-top: 7px; padding-bottom: 1px;">
					<div class="row pb-2">
						<div class="col-sm">
							<img class="d-block avatar avatar-sm p-2 mb-2" src="resources/img/avatar/avatar-4.jpg" alt="Jabba Hut">
							<span class="text-uppercase text-muted text-sm">2021.01.01</span>
						</div>
						<div class="col">
							<h6 class="mt-2 mb-1">nickName</h6>
							<p class="text-muted text-sm">contentcontentcontentcontentcontentcontentcontentcontentcontentcontent</p>
						</div>
					</div>
				</div>
				<div class="d-flex justify-content-end">
					<div>
						<p class="pe-2 pt-2 mb-0 text-muted text-sm">??????</p>
					</div>
					<div>
						<p class="pe-2 pt-2 mb-0 text-muted text-sm">??????</p>
					</div>
					<div data-bs-toggle="collapse" data-bs-target="#replyCollapse" aria-expanded="false" aria-controls="replyCollapse">
						<p class="pe-2 pt-2 mb-0 text-muted text-sm">????????????</p>
					</div>
				</div>
				<div class="collapse" id="replyCollapse">
					<form class="form" id="postUpReplySub" method="POST" enctype="multipart/form-data">
						<div class="py-3 d-flex gap-2 justify-content-end">
							<textarea class="form-control w-75" style="resize: none;" rows="1" name="content" id="content" placeholder="Leave your comment" required="required"></textarea>
							<button id="submit" class="btn btn-primary h-100">??????</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</c:if> --%>
	
	<!-- Footer-->
	<jsp:include page="footer.jsp" />
	<!-- JavaScript files-->
	<script>
		// ------------------------------------------------------- //
		//   Inject SVG Sprite - 
		//   see more here 
		//   https://css-tricks.com/ajaxing-svg-sprite/
		// ------------------------------------------------------ //
		function injectSvgSprite(path) {

			var ajax = new XMLHttpRequest();
			ajax.open("GET", path, true);
			ajax.send();
			ajax.onload = function(e) {
				var div = document.createElement("div");
				div.className = 'd-none';
				div.innerHTML = ajax.responseText;
				document.body.insertBefore(div, document.body.childNodes[0]);
			}
		}
		// to avoid CORS issues when viewing using file:// protocol, using the demo URL for the SVG sprite
		// use your own URL in production, please :)
		// https://demo.bootstrapious.com/directory/1-0/icons/orion-svg-sprite.svg
		//- injectSvgSprite('${path}icons/orion-svg-sprite.svg'); 
		injectSvgSprite('https://demo.bootstrapious.com/directory/1-4/icons/orion-svg-sprite.svg');
	</script>
	<!-- jQuery-->
	<script src="resources/vendor/jquery/jquery.min.js"></script>
	<!-- Bootstrap JS bundle - Bootstrap + PopperJS-->
	<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- Magnific Popup - Lightbox for the gallery-->
	<script src="resources/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>
	<!-- Smooth scroll-->
	<script src="resources/vendor/smooth-scroll/smooth-scroll.polyfills.min.js"></script>
	<!-- Bootstrap Select-->
	<script src="resources/vendor/bootstrap-select/js/bootstrap-select.min.js"></script>
	<!-- Object Fit Images - Fallback for browsers that don't support object-fit-->
	<script src="resources/vendor/object-fit-images/ofi.min.js"></script>
	<!-- Swiper Carousel                       -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.4.1/js/swiper.min.js"></script>
	<script>
		var basePath = ''
	</script>
	<!-- Main Theme JS file    -->
	<script src="resources/js/theme.js"></script>
	<!-- Price Slider-->
	<script src="resources/vendor/nouislider/nouislider.min.js"></script>
	<script>
		var snapSlider = document.getElementById('slider-snap');

		noUiSlider.create(snapSlider, {
			start : [ 40, 110 ],
			snap : false,
			connect : true,
			step : 1,
			range : {
				'min' : 40,
				'max' : 110
			}
		});
		var snapValues = [ document.getElementById('slider-snap-value-from'), document.getElementById('slider-snap-value-to') ];
		var inputValues = [ document.getElementById('slider-snap-input-from'), document.getElementById('slider-snap-input-to') ];
		snapSlider.noUiSlider.on('update', function(values, handle) {
			snapValues[handle].innerHTML = values[handle];
			inputValues[handle].value = values[handle];
		})
	</script>
</body>
</html>