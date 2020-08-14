<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoderBy</title>
</head>
<body>
<h1>사원의 수 : ${comments}</h1>
<table>
<tr>
	<th>STORE_ID</th>
	<th>IMG_STR</th>
	<th>STORE_NAME</th>
	<th>POSITION</th>
	
</tr>
<c:forEach var="store" items="${store}">
<tr>
	<td>${store.storeId}</td>
	<td>${store.imgStr}</td>
	<td>${store.storeName}</td>
	<td>${store.position}</td>
</tr>
</c:forEach>
</table>

</body>
</html>