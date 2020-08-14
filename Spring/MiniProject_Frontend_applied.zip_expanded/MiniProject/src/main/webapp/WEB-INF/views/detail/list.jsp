<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ page session="false"%>

<html>

<head>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<title>한끼의 품질</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<style>
table {
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>

<body>
	<meta charset="utf-8">
	<div class="container">
		<div class="row text-center" style="width: 100%">
			<div style="width: 720px; float: none; margin: 0px auto">
				<nav class="navbar navbar-expand-lgs">
					<p style="font-size: 24px; text-align: center">식당 이름</p>
				</nav>
			</div>
		</div>
	</div>

	<div class="card-deck">
		<table border="1">
			<tr>
				<td>
					<div class="card">
						<img src="<c:url value='/resources/img/happy.jpg' />"
							style="width: 720; height: auto;" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title" style="font-size: 20px" align="center">해피치즈스마일</h5>
							<p class="card-text" align="center">대구광역시 중구 삼덕동 227-6</p>
							<div class="card-footer" align="center">4.8/5.0</div>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<br>
	<div class="container-sm">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col" width="350px">메뉴</th>
					<th scope="col" width="400px">가격</th>
					<th scope="col" width="150px"></th>
					<th scope="col" width="150px"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1</th>
					<td>메뉴1</td>
					<td>가격1</td>
					<td rowspan="3"><div class="row">
							<div class="col text-center">
								<a href="<c:url value='./updateform'/>"><button
										type="button" class="btn btn-warning">수정</button></a>
							</div>
						</div></td>
					<td rowspan="3"><div class="row">
							<div class="col text-center">
								<a href="<c:url value='./deleteform'/>"><button
										type="button" class="btn btn-danger">삭제</button></a>
							</div>
						</div></td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>메뉴2</td>
					<td>가격2</td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>메뉴3</td>
					<td>가격3</td>
				</tr>
			</tbody>
		</table>
	</div>
	<br>
	<div class="container-sm">
		<div id="carouselExampleCaptions" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleCaptions" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
				<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="<c:url value='/resources/img/wp1.jpg'/>"
						class="d-block w-100" alt="..." width="600px" height="350px">
					<div class="carousel-caption d-none d-md-block">
						<h5>메뉴1</h5>
						<p>가격1 / 평점1</p>
						<p>후기 블라블라 멍멍멍</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="<c:url value='/resources/img/wp2.jpg'/>"
						class="d-block w-100" alt="..." width="600px" height="350px">
					<div class="carousel-caption d-none d-md-block">
						<h5>메뉴2</h5>
						<p>가격2 / 평점2</p>
						<p>후기 블라블라 멍멍멍</p>
					</div>
				</div>
				<div class="carousel-item">
					<img src="<c:url value='/resources/img/wp3.jpg'/>"
						class="d-block w-100" alt="..." width="600px" height="350px">
					<div class="carousel-caption d-none d-md-block">
						<h5>메뉴</h5>
						<p>가격3 / 평점3</p>
						<p>후기 블라블라 멍멍멍</p>
					</div>
				</div>
			</div>
			<a class="carousel-control-prev" href="#carouselExampleCaptions"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>

</html>