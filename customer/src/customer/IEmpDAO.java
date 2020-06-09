package customer;
import java.util.List;

public interface IEmpDAO {
	int insertEmp(EmpVO emp);
	int updateEmp(EmpVO emp);
	int deleteEmp(int employeeId);
	EmpVO selectEmp(int employeeId);
	List<EmpVO> selectEmpByDeptno(int departmentId);
	List<EmpVO> selectAllEmp();
}