package com.coderby.hr.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderby.hr.dao.EmpDAO;
import com.coderby.hr.dao.IEmpDAO;
import com.coderby.hr.model.DeptVO;
import com.coderby.hr.model.EmpVO;
import com.coderby.hr.model.JobVO;


@WebServlet("/hr/Emp.do")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	IEmpDAO dao = new EmpDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String url = "/";
		if("list".equals(cmd)) {
			List<EmpVO> empList = dao.selectAllEmps();
			request.setAttribute("empList", empList);
			url = "/hr/list.jsp";
		} else if("details".equals(cmd)) {
			String empIdStr = request.getParameter("empid");
			int employeeId = Integer.parseInt(empIdStr);
			EmpVO emp = dao.selectEmpByEmpid(employeeId);
			//테스트 코드
//			EmpVO emp = new EmpVO();
//			emp.setEmployeeId(100);
//			emp.setFirstName("JinKyoung");
			//...
			request.setAttribute("emp", emp);
			url = "/hr/details.jsp";
		} else if("insert".equals(cmd)) {
			List<JobVO> jobList = dao.selectAllJobs();
			List<EmpVO> mgrList = dao.selectAllManagers();
			List<DeptVO> deptList = dao.selectAllDepts();
			request.setAttribute("jobList", jobList);
			request.setAttribute("mgrList", mgrList);
			request.setAttribute("deptList", deptList);
			url = "/hr/insert.jsp";
		} else if("update".equals(cmd)) {
			request.setAttribute("jobList", dao.selectAllJobs());
			request.setAttribute("mgrList", dao.selectAllManagers());
			request.setAttribute("deptList", dao.selectAllDepts());
			int employeeId = Integer.parseInt(request.getParameter("empid"));
			request.setAttribute("emp", dao.selectEmpByEmpid(employeeId));
			url = "/hr/update.jsp";
		} else if("delete".equals(cmd)) {
			int employeeId = Integer.parseInt(request.getParameter("empid"));
			EmpVO emp = dao.selectEmpByEmpid(employeeId);
			request.setAttribute("emp", emp);
			url = "/hr/delete.jsp";
		} else {
			request.setAttribute("message", "요청한 명령이 없습니다");
			url = "/error.jsp";
		}
		
		RequestDispatcher disp = request.getRequestDispatcher(url);
		disp.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getParameter("cmd");
		String url = "/";
		if("insert".equals(cmd)) {
			EmpVO emp = new EmpVO();
			try {
				String empIdStr = request.getParameter("employeeId");
				emp.setEmployeeId(Integer.parseInt(empIdStr));
				emp.setFirstName(request.getParameter("firstName"));
				emp.setLastName(request.getParameter("lastName"));
				emp.setEmail(request.getParameter("email"));
				emp.setPhoneNumber(request.getParameter("phoneNumber"));

				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				String hireDateStr = request.getParameter("hireDate");
				java.sql.Date hireDate = new java.sql.Date(new java.util.Date().getTime());
				hireDate = new java.sql.Date(transFormat.parse(hireDateStr).getTime());
				emp.setHireDate(hireDate);
				
				emp.setJobId(request.getParameter("jobId"));
				emp.setSalary(Double.parseDouble(request.getParameter("salary")));
				emp.setCommissionPct(Double.parseDouble(request.getParameter("commissionPct")));
				emp.setManagerId(Integer.parseInt(request.getParameter("managerId")));
				emp.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));
				
				dao.insertEmp(emp);
				
				url = "/hr/Emp.do?cmd=list";
			} catch (RuntimeException | ParseException e) {
				e.printStackTrace();
				request.setAttribute("message", e.getMessage());
				url = "/error.jsp";
				RequestDispatcher disp = request.getRequestDispatcher(url);
				disp.forward(request, response);
				return;
			}
			
		} else if("update".equals(cmd)) {
			EmpVO emp = new EmpVO();
			try {
				String empIdStr = request.getParameter("employeeId");
				emp.setEmployeeId(Integer.parseInt(empIdStr));
				emp.setFirstName(request.getParameter("firstName"));
				emp.setLastName(request.getParameter("lastName"));
				emp.setEmail(request.getParameter("email"));
				emp.setPhoneNumber(request.getParameter("phoneNumber"));

				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				String hireDateStr = request.getParameter("hireDate");
				java.sql.Date hireDate = new java.sql.Date(new java.util.Date().getTime());
				hireDate = new java.sql.Date(transFormat.parse(hireDateStr).getTime());
				emp.setHireDate(hireDate);
				
				emp.setJobId(request.getParameter("jobId"));
				emp.setSalary(Double.parseDouble(request.getParameter("salary")));
				emp.setCommissionPct(Double.parseDouble(request.getParameter("commissionPct")));
				emp.setManagerId(Integer.parseInt(request.getParameter("managerId")));
				emp.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));
				
				dao.updateEmp(emp);
				
				url = "/hr/Emp.do?cmd=details&empid=" + emp.getEmployeeId();
			} catch (RuntimeException | ParseException e) {
				e.printStackTrace();
				request.setAttribute("message", e.getMessage());
				url = "/error.jsp";
				RequestDispatcher disp = request.getRequestDispatcher(url);
				disp.forward(request, response);
				return;
			}
		} else if("delete".equals(cmd)) {
			int employeeId = Integer.parseInt(request.getParameter("employeeId"));
			String email = request.getParameter("email");
			try {
				dao.deleteEmp(employeeId, email);
				url = "/hr/Emp.do?cmd=list";
			} catch (RuntimeException e) {
				e.printStackTrace();
				request.setAttribute("message", e.getMessage());
				url = "/error.jsp";
				RequestDispatcher disp = request.getRequestDispatcher(url);
				disp.forward(request, response);
				return;
			}			
		} else  {
			request.setAttribute("message", "요청한 명령이 없습니다");
			url = "/error.jsp";
			RequestDispatcher disp = request.getRequestDispatcher(url);
			disp.forward(request, response);
			return;
		}
		
		response.sendRedirect(url);
	}

}
