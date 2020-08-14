package com.coderby.hr.dao;

import java.util.List;

import com.coderby.hr.model.DeptVO;
import com.coderby.hr.model.EmpVO;
import com.coderby.hr.model.JobVO;

public interface IEmpDAO {
	List<EmpVO> selectAllEmps();
	EmpVO selectEmpByEmpid(int employeeId);
	List<JobVO> selectAllJobs();
	List<DeptVO> selectAllDepts();
	List<EmpVO> selectAllManagers();
	int insertEmp(EmpVO emp);
	int updateEmp(EmpVO emp);
	int deleteEmp(int employeeId, String email);
}
