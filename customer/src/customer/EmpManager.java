package customer;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class EmpManager {
	
	public static void main(String[] args) {
		IEmpDAO dao = new EmpDAO();
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(401);
		emp.setFirstName("홍길동");
		emp.setLastName("Heo");
		emp.setEmail("asdfgh");
		emp.setPhoneNumber("010-3402-7902");
		emp.setHireDate(new java.sql.Date(new java.util.Date().getTime()));
		emp.setJobId("IT_PROG");
		emp.setSalary(9000);
		emp.setCommissionPct(0.8);
		emp.setManagerId(100);
		emp.setDepartmentId(60);
		
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		int manager_id_idex = 100;
				
		try {
			// 로직이 들어가는 곳
			while(menu != 4) {
				System.out.println("------------------------------");
				System.out.println("- 1.입력 | 2.수정 | 3.삭제 | 4.종료 -");
				System.out.println("------------------------------");
				System.out.print("선택> ");
				
				menu = scan.nextInt();
				switch(menu) {
				case 1:
					System.out.print("Employee_ID : ");
					emp.setEmployeeId(scan.nextInt());
					
					System.out.print("First_name : ");
					scan.nextLine();
					emp.setFirstName(scan.nextLine());
					
					System.out.print("Last_name : ");
//					scan.nextLine();
					emp.setLastName(scan.nextLine());
					
					System.out.print("Email : ");
//					scan.nextLine();
					emp.setEmail(scan.nextLine());
					
					System.out.print("Phone_number : ");
//					scan.nextLine();
					emp.setPhoneNumber(scan.nextLine());
					
					emp.setHireDate(new java.sql.Date(new java.util.Date().getTime()));
					
					emp.setJobId("PU_MAN");
					
					System.out.print("Salary : ");
					emp.setSalary(scan.nextDouble());
					
					emp.setCommissionPct(0.8);
					emp.setManagerId(manager_id_idex);
					emp.setDepartmentId(60);
					
					manager_id_idex++;
					
					dao.insertEmp(emp);
					System.out.println("입력 성공!!!");
					
					break;
				case 2:
					int update_num = 0;
					
					System.out.print("수정할 사원의 사원번호 : ");
					emp = dao.selectEmp(scan.nextInt());
					System.out.println(emp.toString());
					System.out.println("------------------------------------");
					System.out.println("-1.이름 수정 | 2.이메일 수정 | 3.휴대폰 번호 수정-");
					System.out.println("------------------------------------");
					System.out.print("선택> ");
					
					update_num = scan.nextInt();
					switch(update_num) {
					case 1:
						System.out.print("First_name : ");
						scan.nextLine();
						emp.setFirstName(scan.nextLine());
						
						System.out.print("Last_name : ");
//						scan.nextLine();
						emp.setLastName(scan.nextLine());
						break;
					case 2:
						System.out.print("Email : ");
						scan.nextLine();
						emp.setEmail(scan.nextLine());
						break;
					case 3:
						System.out.print("Phone_number : ");
						scan.nextLine();
						emp.setPhoneNumber(scan.nextLine());
						break;
					}
					
					dao.updateEmp(emp);
					System.out.println("수정 성공");
					
					break;
				case 3:
					System.out.print("삭제할 Employee_ID : ");
					
					dao.deleteEmp(scan.nextInt());
					System.out.println("삭제 성공");
					
					break;
				}
			}
			
//			dao.updateEmp(emp);
//			System.out.println("수정 성공");
//			dao.deleteEmp(400);
//			System.out.println("삭제 성공");
//			EmpVO emp1 = dao.selectEmp(103);
//			System.out.println(emp1);
//			List<EmpVO> empList1 = dao.selectEmpByDeptno(60);
//			List<EmpVO> empList = dao.selectAllEmp();
//			for(EmpVO vo : empList) {
//				System.out.println(vo);
//			}
		}catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}
}