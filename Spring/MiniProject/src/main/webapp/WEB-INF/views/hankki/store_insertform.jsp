<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ page session="false"%>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Song+Myung&display=swap" rel="stylesheet">
<title>한끼의 품질</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style>
body {
	background-color: #F8ECE0;
	margin: 0
}

th, td {
	padding: 15px;
}

table {
	margin-left: auto;
	margin-right: auto;
	border-spacing: 20px;
}

[class*="col"] {
	padding: 8px;
	border: 1px solid gray;
	text-align: center;
}
</style>
</head>

<body>
	<form action="/hankki/store_insert" method="post">

		<nav class="navbar navbar-light " style="color: #FFFFFF; background-color: #F5BCA9">
			<div class="container">
				<div class="row text-center" style="width: 100%">
					<div style="float: none; margin: 0px auto">
						<nav class="navbar navbar-expand-lgs">
							<p style="font-size: 72px; font-family: 'Black Han Sans', sans-serif" align="center">한끼의 품질</p>
						</nav>
					</div>
					<button id="submit" type="submit" class="btn btn-success" style="position: absolute; bottom: 10px;">확인</button>
					<a href="<c:url value='/home'/>">
						<button type="button" class="btn btn-secondary" style="position: absolute; bottom: 10px;">취소</button>
					</a>
				</div>
			</div>
		</nav>

		<div class="container">
			<div class="row row-cols-3">

				<div class="col">
					<div class="card" style="padding-top: 10px; background-color: rgba(255, 255, 255, 0.5);">
						<a>
							<img src="/images/shop_plus.jpg" style="width: 300px; height: auto; max-width: 100%;" class="card-img-top" alt="...">
						</a>
						<div class="card-body">
							<h5 class="card-title" style="font-family: 'Song Myung', serif; font-size: 28px" align="center">
								<input type="text" name="storeName" required>
							</h5>
							<p class="card-text" align="center">
								위치
								<input type="text" name="position" required>
							</p>
							<p class="card-text" align="center">
								img 파일명
								<input type="text" name="imgStr" required>
							</p>

							<!-- style="color: #FE2E2E; font-size: 15px" -->
						</div>
					</div>
				</div>

				<c:forEach var="store" items="${store}" varStatus="status">
					<div class="col">
						<div class="card" style="padding-top: 10px; background-color: rgba(255, 255, 255, 0.5);">
							<a href="<c:url value='/hankki/${store.storeId}'/>">
								<img src="/images/${store.imgStr}" style="width: 300px; height: auto; max-width: 100%;" class="card-img-top" alt="...">
							</a>
							<div class="card-body">
								<h5 class="card-title" style="font-family: 'Song Myung', serif; font-size: 28px" align="center">${store.storeName}</h5>
								<p class="card-text" align="center">${store.position}</p>
								<div class="card-footer" align="center">${store.star}/5.0</div>
								<!-- style="color: #FE2E2E; font-size: 15px" -->
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>

	</form>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>