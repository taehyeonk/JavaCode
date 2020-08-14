package kr.or.kfq.ems.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.or.kfq.ems.model.EmpVO;
import kr.or.kfq.ems.service.IEmpService;

@Controller
public class EmpController {

	@Autowired
	IEmpService empService;
	
	@RequestMapping(value="/ems/count")
	public String empCount(
		@RequestParam(value="deptid", required=false, defaultValue="0") int deptid, 
		Model model) {
		if(deptid==0) {
			model.addAttribute("count", empService.getEmpCount());
		}else {
			model.addAttribute("count", empService.getEmpCount(deptid));
		}
		return "ems/count";
	}

	@RequestMapping(value={"/ems", "/ems/list"})
	public String getAllEmps(Model model) {
		List<EmpVO> empList = empService.getEmpList();
		model.addAttribute("empList", empList);
		return "ems/list";
	}
	
	// TODO 5.5_1 /ems/100 형식으로 요청 URL에 파라미터를 포함시켜 요청하는 것을 처리하도록 요청매핑을 설정하고 메서드 파라미터를 수정하세요.
	@RequestMapping(value="/ems/{employeeId}", method=RequestMethod.GET)
	public String getEmpInfo(@PathVariable int employeeId, Model model) {
		EmpVO emp = empService.getEmpInfo(employeeId);
		model.addAttribute("emp", emp);
		return "ems/view";
	}
	
	@RequestMapping(value="/ems/insert", method=RequestMethod.GET)
	public String insertEmp(Model model) {
		model.addAttribute("deptList", empService.getAllDeptId());
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("managerList", empService.getAllManagerId());
		return "ems/insertform";
	}
	
	@RequestMapping(value="/ems/insert", method=RequestMethod.POST)
	public String insertEmp(EmpVO emp, Model model) {
		empService.insertEmp(emp);
		return "redirect:/ems";// TODO 5.5_2 POST 방식 요청을 처리하고 사원의 목록을 요청하도록 리턴값을 수정하세요.
	}
	
	@RequestMapping(value="/ems/update", method=RequestMethod.GET)
	public String updateEmp(int empid, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empid));
		model.addAttribute("deptList", empService.getAllDeptId());
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("managerList", empService.getAllManagerId());
		return "ems/updateform";
	}
	
	@RequestMapping(value="/ems/update", method=RequestMethod.POST)
	public String updateEmp(EmpVO emp, Model model) {
		empService.updateEmp(emp);
		return "redirect:/ems/"+emp.getEmployeeId();
	}
	
	@RequestMapping(value="/ems/delete", method=RequestMethod.GET)
	public String deleteEmp(int empid, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empid));
		return "ems/deleteform";
	}

	@RequestMapping(value="/ems/delete", method=RequestMethod.POST)
	public String deleteEmp(int empid, String email, Model model) {
		empService.deleteEmp(empid, email);
		return "redirect:/ems";
	}
	
	@RequestMapping(value="/ems/json")
	public @ResponseBody List<EmpVO> getEmpJSONList() {
		List<EmpVO> empList = empService.getEmpList();
		return empList;
	}

	// TODO 5.5_3 비동기 GET 방식 요청을 처리하도록 JSON 형식으로 응답이 되도록 메서드를 수정하세요.
	@RequestMapping(value="/ems/json/{employeeId}")
	public @ResponseBody EmpVO getEmpJSONInfo(@PathVariable int employeeId) {
		EmpVO emp = empService.getEmpInfo(employeeId);
		return emp;
	}

	// TODO 5.5_4 비동기 POST 방식 요청을 처리하도록 JSON 형식으로 응답이 되도록 메서드를 수정하세요.
	@RequestMapping(value="/ems/ajax")
	public @ResponseBody EmpVO getEmpByJSON(@RequestBody List<Map<String, Object>> datas) {
		Map<String, Object> data = datas.get(0);
		int employeeId = Integer.parseInt((String)data.get("value"));
		EmpVO emp = empService.getEmpInfo(employeeId);
		return emp;
	}
	
}//end class