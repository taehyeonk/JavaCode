<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script>
	window.addEventListener("load", function() {
		var totalCount = document.getElementById("#totalCount");
		totalCount.onclick = function() {
			
		}
	});
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- <p id="totalCount">총 사원 수</p> -->
<a href="<c:url value='/totalCount'/>">총 사원 수</a>

<div id="result"></div>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
