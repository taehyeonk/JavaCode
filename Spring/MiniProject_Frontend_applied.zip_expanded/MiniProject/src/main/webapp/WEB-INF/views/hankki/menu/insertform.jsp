<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoderBy</title>
<script src="/myapp/js/insertform.js" ></script>
</head>
<body>
<h1>신규 메뉴 입력</h1>
<form action="./insert" method="post">
<table border="1">
<tr>
	<th>MENU_ID</th>
	<td><input id="menu-id" type="number" name="menuId" required></td>
</tr>
<tr>
	<th>STORE_ID</th>
	<td><input id="store-id" type="number" name="storeId" required></td>
</tr>
<tr>
	<th>MENU_NAME</th>
	<td><input type="text" name="menuName" required></td>
</tr>
<tr>
	<th>COST</th>
	<td><input type="text" name="cost" required></td>
</tr>
<tr>
	<th>IMG_STR</th>
	<td><input type="text" name="imgStr"></td>
</tr>
<tr>
	<th>STAR</th>
	<td><input type="number" name="cost" required></td>
</tr>
<tr>
	<th>COMMENTS</th>
	<td><input type="text" name="comments"></td>
</tr>

<tr>
	<th>&nbsp;</th>
	<td>
		<input id="submit" type="submit" value="저장"> 
		<input type="reset" value="취소">
	</td>
</tr>
</table>
</form>
</body>
</html>