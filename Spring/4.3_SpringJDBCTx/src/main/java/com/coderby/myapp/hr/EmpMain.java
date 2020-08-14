package com.coderby.myapp.hr;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coderby.myapp.hr.configuration.RootConfig;
import com.coderby.myapp.hr.dao.IEmpRepository;
import com.coderby.myapp.hr.model.EmpVO;
import com.coderby.myapp.hr.service.IEmpService;

public class EmpMain {
	public static void main(String[] args) {
//		AbstractApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("root-config.xml");
//		IEmpService empService = context.getBean("empService", IEmpService.class);
		IEmpRepository empService = context.getBean("empRepository", IEmpRepository.class);

//		System.out.println(empService.getEmpInfo(107));
//		System.out.println(empService.getEmpInfo(107).getEmail());
		
		System.out.println("-- �궗�썝�쓽 �닔 議고쉶");
		System.out.println(empService.getEmpCount());
		System.out.println(empService.getEmpCount(50));

		System.out.println("-- 103踰� �궗�썝�쓽 �젙蹂대�� 議고쉶�빀�땲�떎.");
		System.out.println(empService.getEmpInfo(103));

		System.out.println("-- �궗�썝 �쟾泥� �젙蹂대�� 議고쉶�빀�땲�떎.");
		System.out.println(empService.getEmpList());

		System.out.println("-- �깉濡쒖슫 �궗�썝 �젙蹂대�� �엯�젰�빀�땲�떎.");
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(210);
		emp.setFirstName("JinKyoung");
		emp.setLastName("Heo");
		emp.setEmail("HEOJK");
		emp.setPhoneNumber("222-222");
		emp.setJobId("IT_PROG");
		emp.setSalary(8000);
		emp.setCommissionPct(0.2);
		emp.setManagerId(100);
		emp.setDepartmentId(10);
		try {
			empService.insertEmp(emp);
			System.out.println("insert ok");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("-- �떊洹� �궗�썝�쓽 �젙蹂대�� 議고쉶/異쒕젰�빀�땲�떎.");
		EmpVO emp210 = empService.getEmpInfo(210);
		System.out.println(emp210);

		System.out.println("-- 210踰� �궗�썝�쓽 湲됱뿬瑜� 10% �씤�긽�떆�궢�땲�떎.");
		emp210.setSalary(emp210.getSalary() * 1.1);
		empService.updateEmp(emp210);

		System.out.println("-- �닔�젙�맂 �궗�썝�쓽 �젙蹂대�쇱“�쉶/異쒕젰�빀�땲�떎.");
		emp210 = empService.getEmpInfo(210);
		System.out.println(emp210);

		System.out.println("-- 210踰� �궗�썝�쓽 �젙蹂대�� �궘�젣�빀�땲�떎.");
		empService.deleteEmp(210, "HEOJK");

		System.out.println("-- 紐⑤뱺 遺��꽌踰덊샇�� 遺��꽌�씠由� �젙蹂대�� 異쒕젰�빀�땲�떎.");
		System.out.println(empService.getAllDeptId());

		System.out.println("-- 紐⑤뱺 吏곷Т�븘�씠�뵒�� 吏곷Т���씠���쓣 異쒕젰�빀�땲�떎.");
		System.out.println(empService.getAllJobId());

		System.out.println("-- 紐⑤뱺 留ㅻ땲��踰덊샇�� 留ㅻ땲���씠由꾩쓣 異쒕젰�빀�땲�떎.");
		System.out.println(empService.getAllManagerId());
		context.close();
	}
}