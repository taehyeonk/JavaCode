<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ page session="false"%>

<html>

<head>
<link href="https://fonts.googleapis.com/css2?family=Song+Myung&display=swap" rel="stylesheet">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<title>식당 이름</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
</style>
</head>

<body>
	<!-- <div class="container-sm"> -->
	<div style="width: 720px; height: auto; margin: 0px auto; background-color: #F5BCA9;">
		<nav class="navbar navbar-light">
			<a class="navbar-brand"></a>
			<form class="form-inline">
				<div>
					<a href="<c:url value='/home'/>">
						<button type="button" class="btn btn-light">홈으로</button>
					</a>
				</div>
			</form>
		</nav>
	</div>


	<!-- <div class="row text-center" style="width: 100%">
		<div style="width: 720px; float: none; margin: 0px auto">
			<nav class="navbar navbar-expand-lgs">
				<p style="font-size: 24px; text-align: center">식당 이름</p>
			</nav>
		</div>
	</div> -->

	<div class="card-deck">
		<table border="0">
			<tr>
				<td>
					<div class="card">
						<img style="width: 400px; height: 400px;" src="<c:url value='/images/${store.imgStr}' />" class="card-img-top" alt="...">
						<div class="card-body" style="background-color: #F8ECE0">
							<h5 class="card-title" style="font-family: 'Song Myung', serif; font-size: 28px" align="center">${store.storeName}</h5>
							<p class="card-text" align="center">${store.position}</p>
							<c:if test="${status eq 'yes_star'}">
								<div class="card-footer" align="center" style="background-color: #F8ECE0">${store.star}/5.0</div>
							</c:if>
							<c:if test="${status eq 'no_star'}">
								<div class="card-footer" align="center" style="background-color: #F8ECE0">0/5.0</div>
							</c:if>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>

	<br>
	<div class="tb_wrap">
		<form action="/hankki/${store.storeId}/insertmenu" method="post">
			<div style="width: 720px; height: 60px; margin: 0px auto">
				<table class="table table-borderless">
					<thead>
						<tr class="fixed_top" style="position: absolute; background-color: #F5BCA9">
							<th scope="col" width="40px" style="margin: 0px auto">#</th>
							<th scope="col" width="260px" style="margin: 0px auto">메뉴</th>
							<th scope="col" width="220px" style="margin: 0px auto">가격</th>


							<th scope="col" width="100px" style="margin: 0px auto">
								<button id="submit" type="submit" class="btn btn-success">확인</button>
							</th>
							<th scope="col" width="100px" style="margin: 0px auto">
								<a href="<c:url value='/hankki/${store.storeId}'/>">
									<button type="button" class="btn btn-secondary">취소</button>
								</a>
							</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
			<div style="width: 720px; height: 200px; overflow-y: scroll; overflow-x: hidden; margin: 0px auto">

				<table class="table table-borderless">
					<thead>
					</thead>
					<tbody>

						<c:forEach var="menu" items="${menu}" varStatus="status">
							<tr>
								<th scope="row" width="40px">${status.count}</th>
								<td width="260px">${menu.menuName}</td>
								<td width="220px">${menu.cost}</td>
							</tr>
						</c:forEach>

						<tr>
							<th scope="row" width="40px">+</th>
							<td width="260px">
								<input type="text" name="menuName" required>
							</td>
							<td width="220px">
								<input type="number" name="cost" required>
							</td>
							<td scope="col" width="60px" style="margin: 0px auto"></td>
							<td scope="col" width="140px" style="margin: 0px auto"></td>
						</tr>
						<tr>
							<th scope="row" width="40px">
							<td>
								별점 :
								<input type="number" name="star" required>
							</td>
							</th>
							<td width="260px">
								img 파일명 :
								<input type="text" name="imgStr" required>
							</td>
							<td width="220px">
								후기 :
								<input type="text" name="comments" required>
							</td>
							<td scope="col" width="60px" style="margin: 0px auto"></td>
							<td scope="col" width="140px" style="margin: 0px auto"></td>
						</tr>

					</tbody>
				</table>

			</div>
		</form>
	</div>

	<br>
	<div style="width: 720px; height: 400px; margin: 0px auto">
		<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<c:forEach var="menu" items="${menu}" varStatus="status">
					<li data-target="#carouselExampleCaptions" data-slide-to="${status.index}" <c:if test="${status.index eq 0}">class="active"</c:if>></li>
				</c:forEach>
			</ol>
			<div class="carousel-inner">

				<c:forEach var="menu" items="${menu}" varStatus="status">
					<div class="carousel-item <c:if test="${status.count eq 1}">active</c:if>">
						<img src="<c:url value='/images/${menu.imgStr}'/>" class="d-block w-100" alt="..." width="400px" height="350px">
						<div class="carousel-caption d-none d-md-block">
							<h5>${menu.menuName}</h5>
							<p>가격 : ${menu.cost}원 / 평점 ${menu.star}</p>
							<p>후기 : ${menu.comments}</p>
						</div>
					</div>
				</c:forEach>

			</div>
			<a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a>
			<a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>

		</div>
	</div>
	<!-- </div> -->
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>

</html>