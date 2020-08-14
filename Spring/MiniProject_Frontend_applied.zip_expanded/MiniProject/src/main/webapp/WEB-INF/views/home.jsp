<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<%@ page session="false"%>

<html>

<head>
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
	<nav class="navbar navbar-light"
		style="color: #FFBF00; background-color: #F8ECE0;">
		<div class="container">
			<div class="row text-center" style="width: 100%">
				<div style="width: 30%; float: none; margin: 0px auto">
					<nav class="navbar navbar-expand-lgs">
						<p style="font-size: 30px; text-align:center">한끼의 품질</p>
					</nav>
				</div>
			</div>
		</div>
	</nav>

	<div class="card-deck">
		<table border="1">
			<tr>
				<td>
					<div class="card">
						<a href="<c:url value='/detail/list'/>">
							<img src="<c:url value='/resources/img/happy.jpg' />"
								style="width: 300; height: auto;" class="card-img-top" alt="...">해피치즈스마일</a>
						<div class="card-body">
							<h5 class="card-title" style="font-size: 20px" align="center"></h5>
							<p class="card-text" align="center">대구광역시 중구 삼덕동 227-6</p>
							<div class="card-footer" align="center">4.8/5.0</div>
						</div>
					</div>
				</td>
				<td>
					<div class="card">
						<img src="<c:url value='/resources/img/corea.jpg' />"
							style="width: 300; height: auto;" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title" style="font-size: 20px" align="center">코레아 경양식</h5>
							<p class="card-text" align="center">대구광역시 중구 대봉동 3-14</p>
							<div class="card-footer" align="center">4.0/5.0</div>
						</div>
					</div>
				</td>
				<td>
					<div class="card">
						<img src="<c:url value='/resources/img/tokyo.jpg' />"
							style="width: 300; height: auto;" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title" style="font-size: 20px" align="center">도쿄다이닝</h5>
							<p class="card-text" align="center">대구광역시 중구 봉산동 4-5 동성로2길</p>
							<div class="card-footer" align="center">4.0/5.0</div>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="card">
						<img src="<c:url value='/resources/img/don.jpg' />"
							style="width: 300; height: auto;" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title" style="font-size: 20px" align="center">은화수식당</h5>
							<p class="card-text" align="center">대구광역시 북구 산격동 대동로6길 38</p>
							<div class="card-footer" align="center">4.8/5.0</div>
						</div>
					</div>
				</td>
				<td>
					<div class="card">
						<img src="<c:url value='/resources/img/ma.jpg' />"
							style="width: 300; height: auto;" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title" style="font-size: 20px" align="center">도마29</h5>
							<p class="card-text" align="center">대구광역시 중구 봉산동 35-62</p>
							<div class="card-footer" align="center">4.0/5.0</div>
						</div>
					</div>
				</td>
				<td>
					<div class="card">
						<img src="<c:url value='/resources/img/sapa.png' />"
							style="width: 300; height: auto;" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title" style="font-size: 20px" align="center">사파키친</h5>
							<p class="card-text" align="center">대구광역시 동구 신천4동 425-1</p>
							<div class="card-footer" align="center">4.0/5.0</div>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>

</html>