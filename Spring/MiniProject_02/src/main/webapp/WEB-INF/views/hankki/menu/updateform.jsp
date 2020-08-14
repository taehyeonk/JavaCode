<%@ page contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoderBy</title>
</head>
<body>
<h1>사원정보 수정</h1>
<form action="./menu/update" method="post">
<table border="1">
<tr>
	<th>MENU_ID</th>
	<td><input type="number" name="menuId" value="${menu.menuId}" readonly></td>
</tr>
<tr>
	<th>STORE_ID</th>
	<td><input type="number" name="storeId" value="${menu.menuId}" ></td>
</tr>
<tr>
	<th>MENU_NAME</th>
	<td><input type="text" name="menuName" value="${menu.menuName}" required></td>
</tr>
<tr>
	<th>COST</th>
	<td><input type="number" name="cost" value="${menu.cost}" required></td>
</tr>
<tr>
	<th>IMG_STR</th>
	<td><input type="text" name="imgStr" value="${menu.imgStr}"></td>
</tr>


<tr>
	<th>&nbsp;</th>
	<td>
		<input type="submit" value="수정"> 
		<input type="reset" value="취소">
	</td>
</tr>
</table>
</form>
</body>
</html>