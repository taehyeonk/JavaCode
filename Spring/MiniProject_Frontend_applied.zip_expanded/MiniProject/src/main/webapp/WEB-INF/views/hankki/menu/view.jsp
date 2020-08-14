<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoderBy</title>
</head>
<body>
	<h1>메뉴 정보 상세 조회</h1>
	<table border="1">

		<tr>
			<th>MENU_ID</th>
			<td>${menu.menuId}</td>
		</tr>
		<tr>
			<th>STORE_ID</th>
			<td>${menu.storeId}</td>
		</tr>
		<tr>
			<th>MENU_NAME</th>
			<td>${menu.menuName}</td>
		</tr>
		<tr>
			<th>COST</th>
			<td>${menu.cost}</td>
		</tr>
		<tr>
			<th>IMG_STR</th>
			<td>${menu.imgStr}</td>
		</tr>

	</table>
	<a href="update?menuid=${menu.menuId}">수정하기</a>
	<a href="delete?menuid=${menu.menuId}">삭제하기</a>
</body>
</html>