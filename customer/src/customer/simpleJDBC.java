package customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class simpleJDBC {
	public static void main(String[] args) {
		// 1. 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
		}
		
		// 2. 커넥션 생성
		Connection conn = null;
		try {
			String URL = "jdbc:oracle:thin:@localhost:1521/XE";
			String ID = "hr";
			String PW = "hr";
			conn = DriverManager.getConnection(URL, ID, PW);
			
			System.out.println(conn); // 연결 확인
			
			// 3. SQL 구분 작성
			String sql = "select first_name, salary from employees where employee_id=103";
			
			// 4. Statement 객체 생성
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			// 5. 쿼리문 실행
			ResultSet rs = stmt.executeQuery();
			
			// 6. 결과값 처리
			if(rs.next()) {
				String name = rs.getString(1);
				int salary = rs.getInt(2);
				
				System.out.println(name + " : " + salary);
			}
			else {
				System.out.println("데이터 없음");
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}