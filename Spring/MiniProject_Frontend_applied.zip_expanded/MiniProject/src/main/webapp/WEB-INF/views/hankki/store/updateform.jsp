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
<form action="./update" method="post">
<table border="1">
<tr>
	<th>STORE_ID</th>
	<td><input type="number" name="storeId" value="${store.storeId}" readonly></td>
</tr>
<tr>
	<th>IMG_STR</th>
	<td><input type="text" name="imgStr" value="${store.imgStr}"></td>
</tr>
<tr>
	<th>STORE_NAME</th>
	<td><input type="text" name="storeName" value="${store.storeName}" required></td>
</tr>
<tr>
	<th>POSITION</th>
	<td><input type="text" name="position" value="${store.position}" required></td>
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