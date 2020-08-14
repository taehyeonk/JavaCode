<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoderBy</title>
</head>
<body>
<h1>가게 목록</h1>
<a href="<c:url value='/hankki/store/insert'/>">신규 가게 정보 입력</a>
<table border="1">
<tr>
	
	<th>STORE_ID</th>
	<th>IMG_STR</th>
	<th>STORE_NAME</th>
	<th>POSITION</th>
	
</tr>
<c:forEach var="store" items="${storeList}">
<tr>
	<td><a href="<c:url value='/hankki/${store.storeId}'/>">${store.storeId}</a></td>
	<td>${store.imgStr}</td>
	<td>${store.storeName}</td>
	<td>${store.position}</td>
</tr>
</c:forEach>
</table>




<a href="<c:url value='/hankki/menu/insert'/>">신규 메뉴 정보 입력</a>
<table border="1">
<tr>
	
	<th>MENU_ID</th>
	<th>STORE_ID</th>
	<th>MENU_NAME</th>
	<th>COST</th>
	<th>IMG_STR</th>
	<th>STAR</th>
	<th>COMMENTS</th>
	
</tr>
<c:forEach var="menu" items="${menuList}">
<tr>
	<td><a href="<c:url value='/menu/${menu.menuId}'/>">${menu.menuId}</a></td>
	<td>${menu.storeId}</td>
	<td>${menu.menuName}</td>
	<td>${menu.cost}</td>
	<td>${menu.imgStr}</td>
	<td>${menu.star}</td>
	<td>${menu.comments}</td>
	
</tr>
</c:forEach>
</table>



</body>
</html>