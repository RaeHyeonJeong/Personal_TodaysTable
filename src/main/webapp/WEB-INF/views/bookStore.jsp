<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
<style type="text/css">
.CattoBorderRadius {
	border-radius: 25px;
}
</style>
<head>
<!-- dropdown timepicker -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>  
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css"> -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Directory Theme by Bootstrapious</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<!-- Price Slider Stylesheets -->
<link rel="stylesheet" href="resources/vendor/nouislider/nouislider.css">

<!-- DateTimePicker  -->
<link href="resources/window-date-picker-master/dist/css/window-date-picker.css" rel="stylesheet">


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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		if('${alreadyBooked}' == 'Y') {
			alert('?????? ????????? ?????? ???????????? ?????? ????????????.');
		}
	});
</script>
</head>

<body style="padding-top: 72px;">
	<!-- HEADER include -->
	<jsp:include page="subHeader.jsp" />
	<section>
		<!-- Slider main container-->
		<div class="swiper-container detail-slider slider-gallery">
			<!-- Additional required wrapper-->
			<div class="swiper-wrapper">
				<!-- Slides-->
				<div class="swiper-slide">
					<a href="resources/img/photo/photo-1426122402199-be02db90eb90.jpg" data-toggle="gallery-top" title="Our street"><img class="img-fluid" src="resources/img/photo/photo-1426122402199-be02db90eb90.jpg" alt="Our street"></a>
				</div>
				<div class="swiper-slide">
					<a href="resources/img/photo/photo-1512917774080-9991f1c4c750.jpg" data-toggle="gallery-top" title="Outside"><img class="img-fluid" src="resources/img/photo/photo-1512917774080-9991f1c4c750.jpg" alt="Outside"></a>
				</div>
				<div class="swiper-slide">
					<a href="resources/img/photo/photo-1494526585095-c41746248156.jpg" data-toggle="gallery-top" title="Rear entrance"><img class="img-fluid" src="resources/img/photo/photo-1494526585095-c41746248156.jpg" alt="Rear entrance"></a>
				</div>
				<div class="swiper-slide">
					<a href="resources/img/photo/photo-1484154218962-a197022b5858.jpg" data-toggle="gallery-top" title="Kitchen"><img class="img-fluid" src="resources/img/photo/photo-1484154218962-a197022b5858.jpg" alt="Kitchen"></a>
				</div>
				<div class="swiper-slide">
					<a href="resources/img/photo/photo-1522771739844-6a9f6d5f14af.jpg" data-toggle="gallery-top" title="Bedroom"><img class="img-fluid" src="resources/img/photo/photo-1522771739844-6a9f6d5f14af.jpg" alt="Bedroom"></a>
				</div>
				<div class="swiper-slide">
					<a href="resources/img/photo/photo-1488805990569-3c9e1d76d51c.jpg" data-toggle="gallery-top" title="Bedroom"><img class="img-fluid" src="resources/img/photo/photo-1488805990569-3c9e1d76d51c.jpg" alt="Bedroom"></a>
				</div>
			</div>
			<div class="swiper-pagination swiper-pagination-white"></div>
			<div class="swiper-button-prev swiper-button-white"></div>
			<div class="swiper-button-next swiper-button-white"></div>
		</div>
	</section>
	
	<form action="bookStoreSubmit.do" class="form" id="booking-form" method="POST" autocomplete="off">
	<input type="hidden" name="store_no" value="${store_no}">
	<div class="container py-5">
		<div class="row">
			<div class="col-lg-8">
				<div class="text-block">
					<h1>${store.name}</h1>
					<div class="text-left">
						<br>
						<p>
							<i class="fa fa-heart"></i>&nbsp;??????
						</p>
						<ul class="text-muted font-weight-light">
							<li>???????????? 18???????????? ????????? ???????????????.</li>
							<li>?????? ????????? ???????????? ?????? ???????????? ???????????? ????????? ??????????????? ????????????.</li>
							<li>????????? ???????????? ?????? ????????? ?????? ??? ?????? ??????????????????.</li>
						</ul>
					</div>
					<br>
					<!-- ????????? ?????? DB??? ?????? -->
					<div class="text-block" style="top: 100px;">
						<span class="text-primary h3">????????? ??????</span>
						<hr class="my-4">
						<!-- <form class="form" id="booking-form" method="get" action="" autocomplete="off"> -->
							<div class="form-group">
								<label class="form-label" for="name">????????? ???</label> <input class="form-control" name="name" id="name" type="text" autocomplete="off" required data-msg="Please enter your Name">
							</div>
							<div class="form-group">
								<label class="form-label" for="tel">?????????</label> <input class="form-control" name="tel" id="tel" type="text" placeholder="0001115678" autocomplete="off" required data-msg="Please enter your phone number" pattern="^[0-9]+$">
							</div>
							<div class="form-group">
								<label class="form-label" for="email">?????????</label> <input class="form-control" name="email" id="email" type="email" placeholder="name@address.com" autocomplete="off" required data-msg="Please enter your email">
							</div>
						<!-- </form> -->
						
						
						<br>
						<hr class="my-4">
						<div class="text-left">
							<p>
								<i class="fa fa-heart"></i>&nbsp;?????? ??????
							</p>
							<p class="text-sm text-muted">?????? : ${store.name}</p>
							<p class="text-sm text-muted">???????????? : ${store.category}</p>
							<p class="text-sm text-muted">????????? : ${store.address}</p>
							<p class="text-sm text-muted">????????? : ${store.tel}</p>
						</div>
						<br>
						<div class="custom-control custom-checkbox">
							<input class="custom-control-input" id="select_userInfo_0" type="checkbox"> 
							<label class="custom-control-label" for="select_userInfo_0">
								<p class="text-sm text-muted">???????????? ?????? ??????</p>
							</label>
							<div style="overflow:scroll; width:700px; height:70px; border: 1px solid gray">
								<p class="text-sm text-muted">???????????? ?????? ?????? ?????? ?????? ??????</p>
							</div>
						</div>
						<br>
						<div class="custom-control custom-checkbox">
							<input class="custom-control-input" id="select_userInfo_1" type="checkbox"> 
							<label class="custom-control-label" for="select_userInfo_1">
								<p class="text-sm text-muted">???????????? ?????? ??????</p>
							</label>
							<div style="overflow:scroll; width:700px; height:70px; border: 1px solid gray">
								<p class="text-sm text-muted">???????????? ?????? ?????? ?????? ?????? ??????</p>
								
							</div>
						</div>
						<br>
						<br>
						<p class="text-sm text-muted">?????? ????????? ????????? ?????? ???????????? ?????? ??? ??? 3??? ????????? ?????????????????? ?????? ???????????????.</p>
					</div>
					<!-- ?????? ??????(???????????? ?????? DB??? ???????????? ???)-->
					<div class="text-block" style="top: 100px;">
						<br>
						<br> <span class="text-primary h3">?????? ??????</span>
						<hr class="my-4">
						<!-- <form class="form" id="booking-form" method="get" action="bookComplete.do" autocomplete="off"> -->

							<div class="list-group shadow mb-5">
								<c:forEach var="i" items="${rooms}" varStatus="cnt">
									<div class="list-group-item list-group-item-action p-4">
										<div class="row">
											<div
												class="col-2 col-lg-1 align-self-lg-center py-3 d-flex align-items-lg-center z-index-10">
												<div class="form-check">
													<input class="form-check-input" id="room_no" name="room_no" value="${i.room_no}"
														type="radio">
												</div>
											</div>
											<div class="col-9 col-lg-4 align-self-center mb-3 mb-lg-0">
												<div class="d-flex align-items-center mb-1 mb-lg-3">
													<h2 class="h5 mb-0">??????${cnt.count}</h2>
												</div>
												<p class="text-sm text-muted">??????????????????:${i.capacity}</p>
											</div>
											<div class="col-10 ms-auto col-lg-7">
												<div class="row">
													<div class="col-md-8 py-3">
													
													<img src="resources/img/photo/photo-1494526585095-c41746248156.jpg" alt="Jack London" width="300" height="200">
													
													</div>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>




							<div class="form-group">
								<input type="submit" class="btn btn-primary btn-block" value="????????????">
							</div>
						<!-- </form> -->
					</div>
				</div>
			</div>
			
			
			<div class="col-lg-4">
				<div class="p-4 shadow ml-lg-4 rounded sticky-top" style="top: 100px;">
					<span class="text-primary h3">?????? / ?????? ??? / ??????</span>
					<hr class="my-4">
					<!-- <form class="form" id="booking-form" method="get" action="#" autocomplete="off"> -->
						
						<!-- ?????? ?????? -->
						<div class="form-group">
							<label class="form-label" for="bookingDate">??????</label>
							
							<div id="picker" class="wdp" style="left: 50px; top: 259.6px;">
								<div class="wdp-container">
									<div class="wdp-header">
										<span>Fri, 1 Oct 2021</span>
										<div>
											<div>
												<svg width="16" height="16" viewBox="0 0 1792 1792"
													class="wdp-non-opaque">
													<path
														d="M192 1664h1408v-1024h-1408v1024zm384-1216v-288q0-14-9-23t-23-9h-64q-14 0-23 9t-9 23v288q0 14 9 23t23 9h64q14 0 23-9t9-23zm768 0v-288q0-14-9-23t-23-9h-64q-14 0-23 9t-9 23v288q0 14 9 23t23 9h64q14 0 23-9t9-23zm384-64v1280q0 52-38 90t-90 38h-1408q-52 0-90-38t-38-90v-1280q0-52 38-90t90-38h128v-96q0-66 47-113t113-47h64q66 0 113 47t47 113v96h384v-96q0-66 47-113t113-47h64q66 0 113 47t47 113v96h128q52 0 90 38t38 90z"></path></svg>
												<svg width="16" height="16" viewBox="0 0 1792 1792">
													<path
														d="M1024 544v448q0 14-9 23t-23 9h-320q-14 0-23-9t-9-23v-64q0-14 9-23t23-9h224v-352q0-14 9-23t23-9h64q14 0 23 9t9 23zm416 352q0-148-73-273t-198-198-273-73-273 73-198 198-73 273 73 273 198 198 273 73 273-73 198-198 73-273zm224 0q0 209-103 385.5t-279.5 279.5-385.5 103-385.5-103-279.5-279.5-103-385.5 103-385.5 279.5-279.5 385.5-103 385.5 103 279.5 279.5 103 385.5z"></path></svg>
											</div>
											<div>
												<svg width="16" height="16" viewBox="0 0 1792 1792"
													xmlns="http://www.w3.org/2000/svg">
													<path
														d="M1490 1322q0 40-28 68l-136 136q-28 28-68 28t-68-28l-294-294-294 294q-28 28-68 28t-68-28l-136-136q-28-28-28-68t28-68l294-294-294-294q-28-28-28-68t28-68l136-136q28-28 68-28t68 28l294 294 294-294q28-28 68-28t68 28l136 136q28 28 28 68t-28 68l-294 294 294 294q28 28 28 68z"></path></svg>
											</div>
										</div>
									</div>
									<div class="wdp-body">
										<div class="wdp-date-container">
											<div class="wdp-date-header">
												<span>October 2021</span>
												<div>
													<div>
														<svg width="20" height="20" viewBox="0 0 1792 1792"
															xmlns="http://www.w3.org/2000/svg">
															<path
																d="M1395 1184q0 13-10 23l-50 50q-10 10-23 10t-23-10l-393-393-393 393q-10 10-23 10t-23-10l-50-50q-10-10-10-23t10-23l466-466q10-10 23-10t23 10l466 466q10 10 10 23z"></path></svg>
													</div>
													<div>
														<svg width="20" height="20" viewBox="0 0 1792 1792"
															xmlns="http://www.w3.org/2000/svg">
															<path
																d="M1395 736q0 13-10 23l-466 466q-10 10-23 10t-23-10l-466-466q-10-10-10-23t10-23l50-50q10-10 23-10t23 10l393 393 393-393q10-10 23-10t23 10l50 50q10 10 10 23z"></path></svg>
													</div>
												</div>
											</div>
											<div class="wdp-date-body">
												<div class="wdp-week-container">
													<div class="wdp-week-header">
														<ul class="wdp-week">
															<li>Mo</li>
															<li>Tu</li>
															<li>We</li>
															<li>Th</li>
															<li>Fr</li>
															<li>Sa</li>
															<li>Su</li>
														</ul>
													</div>
													<div class="wdp-week-body">
														<ul class="wdp-week">
															<li date="27-9-2021" class="wdp-muted">27</li>
															<li date="28-9-2021" class="wdp-muted">28</li>
															<li date="29-9-2021" class="wdp-muted">29</li>
															<li date="30-9-2021" class="wdp-muted">30</li>
															<li date="1-10-2021" class="wdp-active">1</li>
															<li date="2-10-2021">2</li>
															<li date="3-10-2021">3</li>
														</ul>
														<ul class="wdp-week">
															<li date="4-10-2021">4</li>
															<li date="5-10-2021">5</li>
															<li date="6-10-2021">6</li>
															<li date="7-10-2021">7</li>
															<li date="8-10-2021">8</li>
															<li date="9-10-2021">9</li>
															<li date="10-10-2021">10</li>
														</ul>
														<ul class="wdp-week">
															<li date="11-10-2021">11</li>
															<li date="12-10-2021">12</li>
															<li date="13-10-2021">13</li>
															<li date="14-10-2021">14</li>
															<li date="15-10-2021">15</li>
															<li date="16-10-2021">16</li>
															<li date="17-10-2021">17</li>
														</ul>
														<ul class="wdp-week">
															<li date="18-10-2021">18</li>
															<li date="19-10-2021">19</li>
															<li date="20-10-2021">20</li>
															<li date="21-10-2021">21</li>
															<li date="22-10-2021">22</li>
															<li date="23-10-2021">23</li>
															<li date="24-10-2021">24</li>
														</ul>
														<ul class="wdp-week">
															<li date="25-10-2021">25</li>
															<li date="26-10-2021">26</li>
															<li date="27-10-2021">27</li>
															<li date="28-10-2021">28</li>
															<li date="29-10-2021">29</li>
															<li date="30-10-2021">30</li>
															<li date="31-10-2021">31</li>
														</ul>
														<ul class="wdp-week">
															<li date="1-11-2021" class="wdp-muted">1</li>
															<li date="2-11-2021" class="wdp-muted">2</li>
															<li date="3-11-2021" class="wdp-muted">3</li>
															<li date="4-11-2021" class="wdp-muted">4</li>
															<li date="5-11-2021" class="wdp-muted">5</li>
															<li date="6-11-2021" class="wdp-muted">6</li>
															<li date="7-11-2021" class="wdp-muted">7</li>
														</ul>
													</div>
												</div>
												<div class="wdp-list-container"></div>
												<div class="wdp-list-container"></div>
											</div>
										</div>
										<div class="wdp-hour-container wdp-d-none">
											<div class="wdp-hour-arrow-container">
												<div>
													<svg viewBox="0 0 1792 1792"
														xmlns="http://www.w3.org/2000/svg">
														<path
															d="M1395 1184q0 13-10 23l-50 50q-10 10-23 10t-23-10l-393-393-393 393q-10 10-23 10t-23-10l-50-50q-10-10-10-23t10-23l466-466q10-10 23-10t23 10l466 466q10 10 10 23z"></path></svg>
												</div>
												<div>
													<svg viewBox="0 0 1792 1792"
														xmlns="http://www.w3.org/2000/svg">
														<path
															d="M1395 1184q0 13-10 23l-50 50q-10 10-23 10t-23-10l-393-393-393 393q-10 10-23 10t-23-10l-50-50q-10-10-10-23t10-23l466-466q10-10 23-10t23 10l466 466q10 10 10 23z"></path></svg>
												</div>
												<div>
													<svg viewBox="0 0 1792 1792"
														xmlns="http://www.w3.org/2000/svg">
														<path
															d="M1395 1184q0 13-10 23l-50 50q-10 10-23 10t-23-10l-393-393-393 393q-10 10-23 10t-23-10l-50-50q-10-10-10-23t10-23l466-466q10-10 23-10t23 10l466 466q10 10 10 23z"></path></svg>
												</div>
											</div>
											<div class="wdp-hour-el-container">
												<input type="text" spellcheck="false" class="wdp-hour-el">
												<input type="text" spellcheck="false" class="wdp-hour-el">
												<input type="text" spellcheck="false" class="wdp-hour-el">
											</div>
											<div class="wdp-hour-arrow-container">
												<div>
													<svg viewBox="0 0 1792 1792"
														xmlns="http://www.w3.org/2000/svg">
														<path
															d="M1395 736q0 13-10 23l-466 466q-10 10-23 10t-23-10l-466-466q-10-10-10-23t10-23l50-50q10-10 23-10t23 10l393 393 393-393q10-10 23-10t23 10l50 50q10 10 10 23z"></path></svg>
												</div>
												<div>
													<svg viewBox="0 0 1792 1792"
														xmlns="http://www.w3.org/2000/svg">
														<path
															d="M1395 736q0 13-10 23l-466 466q-10 10-23 10t-23-10l-466-466q-10-10-10-23t10-23l50-50q10-10 23-10t23 10l393 393 393-393q10-10 23-10t23 10l50 50q10 10 10 23z"></path></svg>
												</div>
												<div>
													<svg viewBox="0 0 1792 1792"
														xmlns="http://www.w3.org/2000/svg">
														<path
															d="M1395 736q0 13-10 23l-466 466q-10 10-23 10t-23-10l-466-466q-10-10-10-23t10-23l50-50q10-10 23-10t23 10l393 393 393-393q10-10 23-10t23 10l50 50q10 10 10 23z"></path></svg>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

						</div>
						
								<!-- ??? ?????? id??? ???????????? ???????????????. -->
							<input class="form-control" type="text" name="bookingDate" id="demo" placeholder="????????? ?????? ????????? ??????????????????." required="required">
							<br>
              				<button class="btn btn-outline-primary" id="toggle" type="button" data-bs-toggle="collapse" data-bs-target="#leaveReview" aria-expanded="true" aria-controls="leaveReview">?????? ??????</button>
							<br><br>
							
						<div class="form-group">
							<label class="form-label" for="headcount">?????? ???</label> <input class="form-control" name="headcount" id="headcount" type="number" placeholder="0" autocomplete="off" required data-msg="Please enter your capacity" pattern="^[0-9]+$">
						</div>
						<br>
						<label class="form-label" for="time">?????? ??????</label> <input type="text" id="time" name="time" class="form-control" style="width: 200px;">
					<!-- </form> -->
				</div>
			</div>
			
			
			
		</div>
	</div>
	</form>
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
	
	<!-- dateTimepicker.js -->
	<script src="resources/window-date-picker-master/dist/js/window-date-picker.js"></script>
	<script type="text/javascript">
	const picker = new WindowDatePicker({
	      el: '#picker',
	      toggleEl: '#toggle',
	      inputEl: '#demo'
	});
	
	</script>
	
	<!-- timepicker dropdown -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js">
		
	</script>
	<script type="text/javascript">
		$(function() {
			$("#time").timepicker({
				timeFormat : 'h:mm p',
				interval : 60,
				minTime : '10',
				maxTime : '6:00pm',
				defaultTime : '11',
				startTime : '10:00',
				dynamic : false,
				dropdown : true,
				scrollbar : true
			});
		});
	</script>
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
	<!-- Map-->
	<!--     <script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js" integrity="sha512-GffPMF3RvMeYyc1LWMHtK8EbPv0iNZ8/oTtHPx9/cc2ILxQ+u905qIwdpULaqDkyBKgOaB57QTMg7ztg8Jm2Og==" crossorigin=""></script>
 -->
	<!-- Available tile layers-->
	<script src="resources/js/map-layers.js">
		
	</script>
	<!-- <script src="resources/js/map-detail.js"></script> -->
	<!-- <script>
      createDetailMap({
          mapId: 'detailMap',
          mapZoom: 14,
          mapCenter: [40.732346, -74.0014247],
          circleShow: true,
          circlePosition: [40.732346, -74.0014247]
      })
      
    </script> -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js">
		
	</script>
<!-- 	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-date-range-picker/0.19.0/jquery.daterangepicker.min.js">
 -->		
	</script>
<!-- 	<script src="resources/js/datepicker-detail.js">
 -->		
	</script>
</body>
</html>