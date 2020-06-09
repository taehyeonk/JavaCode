package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO implements IEmpDAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버클래스가 로드되었습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 파일을 찾을 수 없습니다.");
		}
	}
	
	public static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
	public static final String ID = "hr";
	public static final String PW = "hr";
	
	@Override
	public int insertEmp(EmpVO emp) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PW);
			String sql = "insert into employees ( "
					+ "employee_id, first_name, last_name, email, phone_number,"
					+ "hire_date, job_id, salary, commission_pct, manager_id, department_id) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?)";
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
			return rowCount;
//			return stmt.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con != null) {
				try { con.close(); } catch(Exception e) { }
			}
		}
//		return 0;
	}

	@Override
	public int updateEmp(EmpVO emp) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PW);
			String sql = "update employees set email=?, salary=?, "
					+ "commission_pct=? where employee_id=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, emp.getEmail());
			stmt.setDouble(2, emp.getSalary());
			stmt.setDouble(3, emp.getCommissionPct());
			stmt.setInt(4, emp.getEmployeeId());
			
			return stmt.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con != null) {
				try { con.close(); } catch(Exception e) { }
			}
		}
//		return 0;
	}

	@Override
	public int deleteEmp(int employeeId) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PW);
			String sql = "delete from employees where employee_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, employeeId);
			return stmt.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con != null) {
				try { con.close(); } catch(Exception e) { }
			}
		}
//		return 0;
	}

	@Override
	public EmpVO selectEmp(int employeeId) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PW);
			String sql = "select * from employees where employee_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, employeeId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				EmpVO emp = new EmpVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
				return emp;
			}else {
				throw new RuntimeException("No row selected");
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con != null) {
				try { con.close(); } catch(Exception e) { }
			}
		}
//		return null;
	}

	@Override
	public List<EmpVO> selectEmpByDeptno(int departmentId) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PW);
			String sql = "select * from employees where department_id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, departmentId);
			List<EmpVO> empList = new ArrayList<>();
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
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
				empList.add(emp);
			}
			return empList;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con != null) {
				try { con.close(); } catch(Exception e) { }
			}
		}
//		return null;
	}

	@Override
	public List<EmpVO> selectAllEmp() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, ID, PW);
			String sql = "select * from employees";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<EmpVO> empList = new ArrayList<>();
			while(rs.next()) {
				EmpVO emp = new EmpVO();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setJobId(rs.getString("job_id"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setCommissionPct(rs.getDouble("commission_pct"));
				emp.setManagerId(rs.getInt("manager_id"));
				emp.setDepartmentId(rs.getInt("department_id"));
				empList.add(emp);
			}
			return empList;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(con != null) {
				try { con.close(); } catch(Exception e) { }
			}
		}
//		return null;
	}

}