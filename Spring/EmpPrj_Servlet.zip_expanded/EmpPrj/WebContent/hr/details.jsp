<%@page import="com.coderby.hr.model.EmpDetailsVO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원상세 정보</title>
</head>
<body>
<h1>사원 목록</h1>
<%
	EmpDetailsVO emp = (EmpDetailsVO)request.getAttribute("emp");
%>
<ul>
	<li>사원번호 : <%= emp.getEmployeeId() %>
	<li>이름 : <%= emp.getFirstName() %>
	<li>성 : <%= emp.getLastName() %>
	<li>이메일 : <%= emp.getEmail() %>
	<li>전화번호 : <%= emp.getPhoneNumber() %>
	<li>입사일 : <%= emp.getHireDate() %>
	<li>직무 이름(아이디) : <%= emp.getJobTitle() %>(<%= emp.getJobId() %>)
	<li>급여 : <%= emp.getSalary() %>
	<li>보너스율 : <%= emp.getCommissionPct() %>
	<li>매니저 이름(아이디) : <%= emp.getManagerFirstName() %> <%= emp.getManagerLastName() %>(<%= emp.getManagerId() %>)
	<li>부서 이름(아이디): <%= emp.getDepartmentName() %>(<%= emp.getDepartmentId() %>)
</ul>
<a href="/hr/Emp.do?cmd=update&empid=<%=emp.getEmployeeId()%>">정보 수정</a>
<a href="/hr/Emp.do?cmd=delete&empid=<%=emp.getEmployeeId()%>">정보 삭제</a>
</body>
</html>