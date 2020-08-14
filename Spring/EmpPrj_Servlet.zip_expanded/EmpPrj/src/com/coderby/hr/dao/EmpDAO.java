package com.coderby.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coderby.hr.model.DeptVO;
import com.coderby.hr.model.EmpDetailsVO;
import com.coderby.hr.model.EmpVO;
import com.coderby.hr.model.JobVO;

public class EmpDAO implements IEmpDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 클래스를 로드할 수 없습니다.");
		}
	}

	private static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	private static final String ID = "hr";
	private static final String PW = "hr";

	@Override
	public List<EmpVO> selectAllEmps() {
		String sql = "select * from employees";
		List<EmpVO> empList = new ArrayList<>();
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PW);
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				EmpVO emp = new EmpVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getInt("salary"));
				emp.setCommissionPct(rs.getInt("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
				empList.add(emp);
			}
			return empList;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con!=null) {
				try { con.close(); } catch(SQLException e) {}
			}
		}
	}

	@Override
	public EmpVO selectEmpByEmpid(int employeeId) {
		//사원의 모든 정보를 조회하는 쿼리문을 작성하세요.
		//사원의 부서번호는 부서이름으로, 직무아이디는 직무이름으로, 매니저아이디는 매니저이름으로 출력하세요.
		String sql = "select "
					+ "e.employee_id, e.first_name, e.last_name, e.email, "
					+ "e.phone_number, e.hire_date, e.job_id, j.job_title, e.salary, "
					+ "e.commission_pct, e.manager_id, "
					+ "m.first_name as manager_first_name, "
					+ "m.last_name as manager_last_name, "
					+ "e.department_id, "
					+ "d.department_name "
					+ "from employees e "
					+ "left join departments d on e.department_id=d.department_id "
					+ "join jobs j on e.job_id=j.job_id "
					+ "left join employees m on e.manager_id=m.employee_id "
					+ "where e.employee_id=?";
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PW);
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, employeeId);
			ResultSet rs = stmt.executeQuery();
			EmpDetailsVO empDetails = new EmpDetailsVO();
			if(rs.next()) {
				empDetails.setEmployeeId(rs.getInt("employee_id"));
				empDetails.setFirstName(rs.getString("first_name"));
				empDetails.setLastName(rs.getString("last_name"));
				empDetails.setEmail(rs.getString("email"));
				empDetails.setPhoneNumber(rs.getString("phone_number"));
				empDetails.setHireDate(rs.getDate("hire_date"));
				empDetails.setJobId(rs.getString("job_id"));
				empDetails.setJobTitle(rs.getString("job_title"));
				empDetails.setSalary(rs.getDouble("salary"));
				empDetails.setCommissionPct(rs.getDouble("commission_pct"));
				empDetails.setManagerId(rs.getInt("manager_id"));
				empDetails.setManagerFirstName(rs.getString("manager_first_name"));
				empDetails.setManagerLastName(rs.getString("manager_last_name"));
				empDetails.setDepartmentId(rs.getInt("department_id"));
				empDetails.setDepartmentName(rs.getString("department_name"));
			}
			return empDetails;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con!=null) {
				try { con.close(); } catch(SQLException e) {}
			}
		}
//		return null;
	}

	@Override
	public List<JobVO> selectAllJobs() {
		String sql = "select job_id, job_title from jobs";
		List<JobVO> jobList = new ArrayList<JobVO>();
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PW);
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				JobVO job = new JobVO();
				job.setJobId(rs.getString("job_id"));
				job.setJobTitle(rs.getString("job_title"));
				jobList.add(job);
			}
			return jobList;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con!=null) {
				try { con.close(); } catch(SQLException e) {}
			}
		}
//		return null;
	}

	@Override
	public List<DeptVO> selectAllDepts() {
		String sql = "select department_id, department_name from departments";
		List<DeptVO> deptList = new ArrayList<DeptVO>();
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PW);
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				DeptVO dept = new DeptVO();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				deptList.add(dept);
			}
			return deptList;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con!=null) {
				try { con.close(); } catch(SQLException e) {}
			}
		}
	}

	@Override
	public List<EmpVO> selectAllManagers() {
		String sql = "select m.manager_id, e.first_name, e.last_name "
				+ "from employees e "
				+ "join (select distinct manager_id from employees) m "
				+ "on e.employee_id = m.manager_id";
		List<EmpVO> mgrList = new ArrayList<EmpVO>(); 
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PW);
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				EmpVO mgr = new EmpVO();
				mgr.setEmployeeId(rs.getInt("manager_id"));
				mgr.setFirstName(rs.getString("first_name"));
				mgr.setLastName(rs.getString("last_name"));
				mgrList.add(mgr);
			}
			return mgrList;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con!=null) {
				try { con.close(); } catch(SQLException e) {}
			}
		}
//		return null;
	}

	@Override
	public int insertEmp(EmpVO emp) {
		String sql = "insert into employees "
				+ "(employee_id, first_name, last_name, email, phone_number, "
				+ "hire_date, job_id, salary, commission_pct, manager_id, department_id) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PW);
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, emp.getEmployeeId());
			stmt.setString(2, emp.getFirstName());
			stmt.setString(3, emp.getLastName());
			stmt.setString(4, emp.getEmail());
			stmt.setString(5, emp.getPhoneNumber());
			stmt.setDate(6, emp.getHireDate());
			stmt.setString(7, emp.getJobId());
			stmt.setDouble(8, emp.getSalary());
			stmt.setDouble(9, emp.getCommissionPct());
			stmt.setInt(10, emp.getManagerId());
			stmt.setInt(11, emp.getDepartmentId());
			int rowCount = stmt.executeUpdate();
			if(rowCount > 0) {
				return rowCount;
			}else {
				throw new RuntimeException("No row inserted");
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con!=null) {
				try { con.close(); } catch(SQLException e) {}
			}
		}
//		return 0;
	}

	@Override
	public int updateEmp(EmpVO emp) {
		String sql = "update employees "
				+ "set first_name=?, last_name=?, email=?, phone_number=?, hire_date=?, "
				+ "job_id=?, salary=?, commission_pct=?, manager_id=?, department_id=? where employee_id=?";
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PW);
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, emp.getFirstName());
			stmt.setString(2, emp.getLastName());
			stmt.setString(3, emp.getEmail());
			stmt.setString(4, emp.getPhoneNumber());
			stmt.setDate(5, emp.getHireDate());
			stmt.setString(6, emp.getJobId());
			stmt.setDouble(7, emp.getSalary());
			stmt.setDouble(8, emp.getCommissionPct());
			stmt.setInt(9, emp.getManagerId());
			stmt.setInt(10, emp.getDepartmentId());
			stmt.setInt(11, emp.getEmployeeId());
			
			int rowCount = stmt.executeUpdate();
			
			if(rowCount > 0) {
				return rowCount;
			}else {
				throw new RuntimeException("No row updated");
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con!=null) {
				try { con.close(); } catch(SQLException e) {}
			}
		}
//		return 0;
	}

	@Override
	public int deleteEmp(int employeeId, String email) {
		String sql = "delete employees where employee_id=? and email=?";
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PW);
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, employeeId);
			stmt.setString(2, email);
			int rowCount = stmt.executeUpdate();
			if(rowCount > 0) {
				return rowCount;
			}else {
				throw new RuntimeException("No row deleted");
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con!=null) {
				try { con.close(); } catch(SQLException e) {}
			}
		}
//		return 0;
	}

}
