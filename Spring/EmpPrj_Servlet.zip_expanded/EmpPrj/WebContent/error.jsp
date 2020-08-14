<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>에러</h1>
<h2><%= request.getAttribute("message") %></h2>
</body>
</html>