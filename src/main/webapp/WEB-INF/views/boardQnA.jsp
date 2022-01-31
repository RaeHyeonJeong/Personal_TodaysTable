<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<head>
<title>QnA</title>
<!-- Google fonts - Playfair Display-->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Playfair+Display:400,400i,700">
<!-- Google fonts - Poppins-->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,400i,700">
<!-- theme stylesheet-->
<link rel="stylesheet" href="resources/css/style.default.css" id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet" href="resources/css/custom.css">
<!-- Font Awesome CSS-->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>
<body style="padding-top: 72px;">
	<!-- HEADER include -->
	<jsp:include page="subHeader.jsp" />
	<div class="container-fluid pb-5 px-lg-5">
		<!-- Hero Section-->
		<section class="hero py-5 py-lg-6 mb-3">
			<div class="container position-relative">
				<!-- Breadcrumbs -->
				<ol class="breadcrumb ps-0  justify-content-center">
					<li class="breadcrumb-item active">Question and Answer</li>
				</ol>
				<h1 class="hero-heading">Q.&.A</h1>
				<div class="row">
					<div class="col-xl-8 mx-auto">
						<p class="text-muted">궁금한 점을 질문해주세요!</p>
						<p class="text-muted">해결 되지 않는 사항이 있다면 ' TodaysTable@org.com ' 로 메일을 보내주세요!</p>
					</div>
				</div>
			</div>
		</section>
		<div class="container">
			<table class="table table-sm" style="height: 5px">
				<thead class="table-light text-center">
					<tr class="fw-bold">
						<th class="col-md-1" scope="col">#</th>
						<th class="col-md-4" scope="col">제목</th>
						<th class="col-md-1" scope="col">작성자</th>
						<th class="col-md-1" scope="col">조회수</th>
						<th class="col-md-1" scope="col">작성날짜</th>
					</tr>
				</thead>
				<tbody class="text-center text-break">
					<c:set var="lastIndex" value="${function:length(list)}" />
					<c:forEach var="item" items="${list}">
						<tr>
							<th scope="row">${lastIndex}</th>
							<td><a class="text-muted" href="boardDetail.do?board=${board}&board_no=${item.QNA_NO}">${item.TITLE}</a></td>
							<td>${item.MEMB_NAME }</td>
							<td>${item.HITS}</td>
							<td>${item.REG_DATE}</td>
						</tr>
						<c:set var="lastIndex" value="${lastIndex-1}" />
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="mb-5 d-grid gap-2 col-6 mx-auto">
		<button class="btn btn-primary h-100" onClick="location.href='boardWriteMove.do?board=${board}'">글쓰기</button>
	</div>
	
	<!-- 페이징 처리 시작 -->
	<div class="mb-5">
		<nav aria-label="Page navigation">
			<ul class="pagination pagination-template d-flex justify-content-center">
				<!-- 첫 페이지 -->
				<c:if test="${boardPageMaker.boardCriteria.page != 1}">
					<li class="page-item"><a class="page-link" href="pagingBoard.do?board=${board}&page=1">
							<i class="fa fa-angle-double-left"></i>
						</a></li>
				</c:if>
				<!-- 이전 페이징 목록 -->
				<c:if test="${boardPageMaker.prev}">
					<li class="page-item">
						<a class="page-link" href="pagingBoard.do?board=${board}&page=${boardPageMaker.startPage - boardPageMaker.displayPageNum}">
							<i class="fa fa-angle-left"></i>
						</a>
					</li>
				</c:if>
				<!-- 페이징 번호 목록-->
				<c:forEach begin="${boardPageMaker.startPage }" end="${boardPageMaker.endPage }" var="idx">
					<li <c:out value="${boardPageMaker.boardCriteria.page == idx ?  'class=page-item active' : '' }"/>>
						<a class="page-link" href="pagingBoard.do?board=${board}&page=${idx}">${idx }</a>
					</li>
				</c:forEach>
				<!-- 다음 페이징 목록 -->
				<c:if test="${boardPageMaker.next}">
					<li class="page-item">
						<a class="page-link" href="pagingBoard.do?board=${board}&page=${boardPageMaker.endPage + 1}">
							<i class="fa fa-angle-right"></i>
						</a>
					</li>
				</c:if>
				<!-- 마지막 페이지  -->
				<c:if test="${boardPageMaker.boardCriteria.page != boardPageMaker.totalEndPage}">
					<li class="page-item">
						<a class="page-link" href="pagingBoard.do?board=${board}&page=${boardPageMaker.totalEndPage}">
							<i class="fa fa-angle-double-right"></i>
						</a>
					</li>
				</c:if>
			</ul>
		</nav>
	</div>
	<div class="row row-col-2 d-flex justify-content-center"></div>
	<!-- Footer-->
	<jsp:include page="footer.jsp" />
	<!-- JavaScript files-->
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
</body>
</html>