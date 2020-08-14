<%@page import="com.coderby.hr.model.DeptVO"%>
<%@page import="com.coderby.hr.model.EmpVO"%>
<%@page import="com.coderby.hr.model.JobVO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 입력</title>
</head>
<body>
<h1>사원 정보 입력</h1>
<form action="/hr/Emp.do" method="post">
<%
	EmpVO emp = (EmpVO)request.getAttribute("emp");
%>
<table>
<tr>
	<td>사원번호</td>
	<td><input type="number" name="employeeId" value="<%=emp.getEmployeeId()%>" readonly></td>
</tr>
<tr>
	<td>이름, 성</td>
	<td><input type="text" name="firstName" value="<%=emp.getFirstName()%>"> 
	<input type="text" name="lastName" value="<%=emp.getLastName()%>"></td>
</tr>
<tr>
	<td>이메일</td>
	<td><input type="text" name="email" value="<%=emp.getEmail()%>"></td>
</tr>
<tr>
	<td>전화번호</td>
	<td><input type="text" name="phoneNumber" value="<%=emp.getPhoneNumber()%>"></td>
</tr>
<tr>
	<td>입사일</td>
	<td><input type="date" name="hireDate" value="<%=emp.getHireDate()%>"></td>
</tr>
<tr>
	<td>직무</td>
<% List<JobVO> jobList = (List<JobVO>)request.getAttribute("jobList"); %>
	<td><select name="jobId">
<% for(JobVO job : jobList) {%>
	<option value="<%=job.getJobId() %>" 
		<% if (emp.getJobId().equals(job.getJobId())) { %>selected <% } %>
	><%=job.getJobTitle() %>
<% } %>
	</select></td>
</tr>
<tr>
	<td>급여</td>
	<td><input type="number" name="salary" value=<%=emp.getSalary()%>></td>
</tr>
<tr>
	<td>보너스율</td>
	<td><input type="number" name="commissionPct" min="0" max="1" step="0.01" value="<%=emp.getCommissionPct()%>"></td>
</tr>
<tr>
	<td>매니저</td>
<% List<EmpVO> mgrList = (List<EmpVO>)request.getAttribute("mgrList"); %>
	<td><select name="managerId">
<% for(EmpVO mgr : mgrList) { %>
	<option value="<%=mgr.getEmployeeId() %>"
		<% if(emp.getManagerId()==mgr.getEmployeeId()) { %>selected<% } %>
	><%=mgr.getFirstName() %> <%=mgr.getLastName() %>
<% } %>
	</select></td>
</tr>
<tr>
	<td>부서번호</td>
<% List<DeptVO> deptList = (List<DeptVO>)request.getAttribute("deptList"); %>
	<td><select name="departmentId">
<% for(DeptVO dept : deptList) { %>
	<option value="<%=dept.getDepartmentId() %>"
		<% if(emp.getDepartmentId()==dept.getDepartmentId()) { %>selected<% } %>
	><%= dept.getDepartmentName() %>
<% } %>
	</select></td>
</tr>
<tr>
	<td>&nbsp;<input type="hidden" name="cmd" value="update"></td>
	<td><input type="submit" value="저  장"> <input type="reset" value="취  소"></td>
</tr>
</table>
</form>
</body>
</html>