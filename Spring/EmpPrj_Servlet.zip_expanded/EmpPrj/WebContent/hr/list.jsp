<%@page import="com.coderby.hr.model.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록</title>
</head>
<body>
<h1>사원 목록</h1>
<table border="1">
<tr>
	<th>사원번호</th>
	<th>이름</th>
	<th>성</th>
	<th>이메일</th>
	<th>전화번호</th>
	<th>입사일</th>
	<th>직무</th>
	<th>급여</th>
	<th>보너스율</th>
	<th>매니저번호</th>
	<th>부서번호</th>
</tr>
<%
	List<EmpVO> empList = (List<EmpVO>)request.getAttribute("empList");
	for(EmpVO emp : empList) {
%>
<tr>
	<td><a href="/hr/Emp.do?cmd=details&empid=<%= emp.getEmployeeId() %>"><%= emp.getEmployeeId() %></a></td><!-- 사원번호를 클릭하면 상세 조회가 되도록 -->
	<td><%= emp.getFirstName() %></td>
	<td><%= emp.getLastName() %></td>
	<td><%= emp.getEmail() %></td>
	<td><%= emp.getPhoneNumber() %></td>
	<td><%= emp.getHireDate() %></td>
	<td><%= emp.getJobId() %></td>
	<td><%= emp.getSalary() %></td>
	<td><%= emp.getCommissionPct() %></td>
	<td><%= emp.getManagerId() %></td>
	<td><%= emp.getDepartmentId() %></td>
</tr>
<%
	}
%>
</table>
</body>
</html>	