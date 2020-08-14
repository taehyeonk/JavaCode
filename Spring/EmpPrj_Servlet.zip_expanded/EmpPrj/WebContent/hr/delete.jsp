<%@page import="com.coderby.hr.model.EmpVO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 삭제</title>
</head>
<body>
<h1>회원 정보 삭제</h1>
<% 
	EmpVO emp = (EmpVO)request.getAttribute("emp");
%>
<h2><%=emp.getFirstName() %> <%=emp.getLastName()%>님의 정보를 삭제하겠습니까?</h2>
<p>삭제하려면 이메일을 입력해 주세요.</p>
<form action="/hr/Emp.do" method="post">
이메일 : <input type="text" name="email"> 
<input type="hidden" name="employeeId" value="<%=emp.getEmployeeId()%>">
<input type="hidden" name="cmd" value="delete">
<input type="submit" value="삭  제">
<input type="reset" value="취  소">
</form>
</body>
</html>