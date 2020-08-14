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

import com.hankki.app.model.MenuVO;
import com.hankki.app.model.StoreVO;
import com.hankki.app.service.IMenuService;
import com.hankki.app.service.IStoreService;

@Controller
public class StoreController {

	@Autowired
	IStoreService storeService;

	@Autowired
	IMenuService menuService;


//	@RequestMapping(value = "/hankki/count")
//	public String storeCount(
//			@RequestParam(value = "name", required = false, defaultValue = "0") String name,
//			Model model) {
//		List<StoreVO> storeList = storeService.getStoreList();
//		List<MenuVO> menuList = menuService.getMenuList();
//
//		model.addAttribute("store", storeList);
//		model.addAttribute("menu", menuList);
//		if (name == null) {
//			model.addAttribute("count", storeService.getStoreCount());
//		} else {
//			model.addAttribute("count", storeService.getStoreCount(name));
//		}
//		return "hankki/count";
//	}
//
////	@RequestMapping(value = { "/hankki", "/hankki/list" })
////	public String getAllStores(Model model) {
////		List<StoreVO> storeList = storeService.getStoreList();
////		model.addAttribute("storeList", storeList);
////		return "hankki/list";
////	}
//
//	@RequestMapping(value = "/hankki/{storeId}")
//	public String getStoreInfo(@PathVariable int storeId, Model model) {
//		StoreVO store = storeService.getStoreInfo(storeId);
//		model.addAttribute("store", store);
//		return "hankki/view";
//	}
//
//	@RequestMapping(value = "/bbc/{storeId}")
//	public @ResponseBody StoreVO bbc(@PathVariable int storeId) {
//		StoreVO store = storeService.getStoreInfo(storeId);
//		return store;
//	}
//
//	@RequestMapping(value = "/hankki/insert", method = RequestMethod.GET)
//	public String insertStore(Model model) {
////		model.addAttribute("deptList", empService.getAllDeptId());
////		model.addAttribute("jobList", empService.getAllJobId());
////		model.addAttribute("managerList", empService.getAllManagerId());
//		return "hankki/insertform";
//	}
//
//	@RequestMapping(value = "/hankki/insert", method = RequestMethod.POST)
//	public String insertStore(StoreVO store, Model model) {
//		storeService.insertStore(store);
//		return "redirect:/hankki";
//	}
//
//	@RequestMapping(value = "/hankki/update/{}", method = RequestMethod.GET)
//	public String updateStore(int storeid, Model model) {
//		model.addAttribute("store", storeService.getStoreInfo(storeid));
////		model.addAttribute("deptList", empService.getAllDeptId());
////		model.addAttribute("jobList", empService.getAllJobId());
////		model.addAttribute("managerList", empService.getAllManagerId());
//		return "hankki/updateform";
//	}
//
//	@RequestMapping(value = "/hankki/update", method = RequestMethod.POST)
//	public String updateStore(StoreVO store, Model model) {
//		storeService.updateStore(store);
//		return "redirect:/hankki/" + store.getStoreId();
//	}
//
//	@RequestMapping(value = "/hankki/delete", method = RequestMethod.GET)
//	public String deleteStore_get(int storeid, Model model) {
//		model.addAttribute("store", storeService.getStoreInfo(storeid));
//		return "hankki/deleteform";
//	}
//
//	@RequestMapping(value = "/hankki/delete", method = RequestMethod.POST)
//	public String deleteStore_post(int storeid, Model model) {
//		storeService.deleteStore(storeid);
//		return "redirect:/hankki";
//	}
//
//	@ExceptionHandler({ RuntimeException.class })
//	public ModelAndView runtimeException(HttpServletRequest request, Exception ex) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("url", request.getRequestURI());
//		mav.addObject("exception", ex);
//		mav.setViewName("error/runtime");
//		return mav;
//	}
//
//	@RequestMapping(value = "/hankki/json")
//	public @ResponseBody List<StoreVO> getStoreJSONList() {
//		List<StoreVO> storeList = storeService.getStoreList();
//		return storeList;
//	}
//
//	@RequestMapping(value = "/hankki/json/{employeeId}")
//	public @ResponseBody StoreVO getStoreJSONInfo(@PathVariable int storeId) {
//		StoreVO store = storeService.getStoreInfo(storeId);
//		return store;
//	}
//
//	@RequestMapping(value = "/hankki/ajax")
//	public @ResponseBody StoreVO getStoreByJSON(@RequestBody List<Map<String, Object>> datas) {
//		Map<String, Object> data = datas.get(0);
//		int storeId = Integer.parseInt((String) data.get("value"));
//		StoreVO store = storeService.getStoreInfo(storeId);
//		return store;
//	}

}// end class