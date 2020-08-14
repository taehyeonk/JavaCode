<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CoderBy</title>
</head>
<body>
<h1>가게 정보 상세 조회</h1>
<table border="1">
<tr>
	<th>STORE_ID</th>
	<td>${store.storeId}</td>
</tr>
<tr>
	<th>IMG_STR</th>
	<td>${store.imgStr}</td>
</tr>
<tr>
	<th>STORE_NAME</th>
	<td>${store.storeName}</td>
</tr>
<tr>
	<th>POSITION</th>
	<td>${store.position}</td>
</tr>

<%-- <tr>
	<th>PHONE_NUMBER</th>
	<td>${emp.phoneNumber}</td>
</tr>
<tr>
	<th>HIRE_DATE</th>
	<td>${emp.hireDate}</td>
</tr>
<tr>
	<th>JOB_ID</th>
	<td>${emp.jobId}</td>
</tr>
<tr>
	<th>SALARY</th>
	<td>${emp.salary}</td>
</tr>
<tr>
	<th>COMMISSION_PCT</th>
	<td>${emp.commissionPct}</td>
</tr>
<tr>
	<th>MANAGER_ID</th>
	<td>${emp.managerId}</td>
</tr>
<tr>
	<th>DEPARTMENT_ID</th>
	<td>${emp.departmentId}</td>
</tr> --%>

</table>
<a href="update?storeid=${store.storeId}">수정하기</a> 
<a href="delete?storeid=${store.storeId}">삭제하기</a>
</body>
</html>