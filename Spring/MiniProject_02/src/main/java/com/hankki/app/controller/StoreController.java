package com.hankki.app.controller;

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

import com.hankki.app.model.StoreVO;
import com.hankki.app.service.IStoreService;

@Controller
public class StoreController {

	@Autowired
	IStoreService storeService;
	
	@RequestMapping(value="/hankki/count")
	public String empCount(
		@RequestParam(value="name", required=false, defaultValue="0") String name, 
		Model model) {
		if(name==null) {
			model.addAttribute("count", storeService.getStoreCount());
		}else {
			model.addAttribute("count", storeService.getStoreCount(name));
		}
		return "hankki/count";
	}

	@RequestMapping(value={"/hankki", "/hankki/list"})
	public String getAllEmps(Model model) {
		List<StoreVO> storeList = storeService.getStoreList();
		model.addAttribute("storeList", storeList);
		return "hankki/list";
	}
	
	@RequestMapping(value="/hankki/{storeId}")
	public String getEmpInfo(@PathVariable int storeId, Model model) {
		StoreVO store = storeService.getStoreInfo(storeId);
		model.addAttribute("store", store);
		return "hankki/view";
	}
	
	@RequestMapping(value="/bbc/{storeId}")
	public @ResponseBody StoreVO bbc(@PathVariable int storeId) {
		StoreVO store = storeService.getStoreInfo(storeId);
		return store;
	}
	
	@RequestMapping(value="/hankki/insert", method=RequestMethod.GET)
	public String insertEmp(Model model) {
//		model.addAttribute("deptList", empService.getAllDeptId());
//		model.addAttribute("jobList", empService.getAllJobId());
//		model.addAttribute("managerList", empService.getAllManagerId());
		return "hankki/insertform";
	}
	
	@RequestMapping(value="/hankki/insert", method=RequestMethod.POST)
	public String insertEmp(StoreVO store, Model model) {
		storeService.insertStore(store);
		return "redirect:/hankki";
	}
	
	@RequestMapping(value="/hankki/update", method=RequestMethod.GET)
	public String updateEmp(int storeid, Model model) {
//		model.addAttribute("emp", empService.getEmpInfo(empid));
//		model.addAttribute("deptList", empService.getAllDeptId());
//		model.addAttribute("jobList", empService.getAllJobId());
//		model.addAttribute("managerList", empService.getAllManagerId());
		return "hankki/updateform";
	}
	
	@RequestMapping(value="/hankki/update", method=RequestMethod.POST)
	public String updateEmp(StoreVO store, Model model) {
		storeService.updateStore(store);
		return "redirect:/hankki/"+store.getStoreId();
	}
	
	@RequestMapping(value="/hankki/delete", method=RequestMethod.GET)
	public String deleteStore(int storeid, Model model) {
		model.addAttribute("store", storeService.getStoreInfo(storeid));
		return "hankki/deleteform";
	}
	
	@ExceptionHandler({RuntimeException.class})
	public ModelAndView runtimeException(HttpServletRequest request, Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("url",  request.getRequestURI());
		mav.addObject("exception", ex);
		mav.setViewName("error/runtime");
		return mav;
	}
	
	@RequestMapping(value="/hankki/json")
	public @ResponseBody List<StoreVO> getEmpJSONList() {
		List<StoreVO> storeList = storeService.getStoreList();
		return storeList;
	}

	@RequestMapping(value="/hankki/json/{storeId}")
	public @ResponseBody StoreVO getEmpJSONInfo(@PathVariable int storeId) {
		StoreVO store = storeService.getStoreInfo(storeId);
		return store;
	}

	@RequestMapping(value="/hankki/ajax")
	public @ResponseBody StoreVO getEmpByJSON(@RequestBody List<Map<String, Object>> datas) {
		Map<String, Object> data = datas.get(0);
		int storeId = Integer.parseInt((String)data.get("value"));
		StoreVO store = storeService.getStoreInfo(storeId);
		return store;
	}

	
}//end class