<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoderBy</title>
<script src="/myapp/store/js/insertform.js" ></script>
</head>
<body>
<h1>가게 정보 입력</h1>
<form action="./store/insert" method="post">
<table border="1">
<tr>
	<th>STORE_ID</th>
	<td><input id="store-id" type="number" name="storeId" required></td>
</tr>
<tr>
	<th>IMG_STR</th>
	<td><input type="text" name="imgStr"></td>
</tr>
<tr>
	<th>STORE_NAME</th>
	<td><input type="text" name="storeName" required></td>
</tr>
<tr>
	<th>POSITION</th>
	<td><input type="text" name="position" required></td>
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