package com.hankki.app.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.hankki.app.model.ListVO;
import com.hankki.app.model.MenuVO;
import com.hankki.app.model.StoreVO;
import com.hankki.app.service.IMenuService;
import com.hankki.app.service.IStoreService;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	IStoreService storeService;

	@Autowired
	IMenuService menuService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "redirect:/home";
	}

	// 홈화면
	@RequestMapping(value = "/home")
	public String home(@RequestParam(value = "name", required = false, defaultValue = "0") String name, Model model) {

		List<ListVO> storeList = storeService.getStoreStarAvg();

		model.addAttribute("store", storeList);

		if (name == null) {
			model.addAttribute("count", storeService.getStoreCount());
		} else {
			model.addAttribute("count", storeService.getStoreCount(name));
		}
		return "/home";
	}

	// 가게 선택 화면
	@RequestMapping(value = "/hankki/{storeId}")
	public String getStoreInfo(@PathVariable int storeId, Model model) {
		int count = storeService.getStoreMenuCount(storeId);
		System.out.println(count);
		if (count == 0) {
			StoreVO store = storeService.getStoreInfo(storeId);
			model.addAttribute("status","no_star");
			model.addAttribute("store", store);
		} else {
			ListVO store = storeService.getStoreStarAvg(storeId);
			model.addAttribute("status","yes_star");
			model.addAttribute("store", store);
			List<MenuVO> menuList = menuService.getMenuList(storeId);
			model.addAttribute("menu", menuList);
		}

		return "hankki/list";
	}

	// 가게 삽입 화면
	@RequestMapping(value = "/hankki/store_insert", method = RequestMethod.GET)
	public String insertStore(@RequestParam(value = "name", required = false, defaultValue = "0") String name,
			Model model) {

		List<ListVO> storeList = storeService.getStoreStarAvg();

		model.addAttribute("store", storeList);

		if (name == null) {
			model.addAttribute("count", storeService.getStoreCount());
		} else {
			model.addAttribute("count", storeService.getStoreCount(name));
		}
		return "hankki/store_insertform";
	}

	// 가게 삽입 처리 화면
	@RequestMapping(value = "/hankki/store_insert", method = RequestMethod.POST)
	public String insertStore(StoreVO store, Model model) {
		storeService.insertStore(store);
		return "redirect:/home";
	}

	// 메뉴 삽입 화면
	@RequestMapping(value = "/hankki/{storeId}/insertmenu", method = RequestMethod.GET)
	public String insertMenu(@PathVariable int storeId, Model model) {
		int count = storeService.getStoreMenuCount(storeId);
		System.out.println(count);
		if (count == 0) {
			StoreVO store = storeService.getStoreInfo(storeId);
			model.addAttribute("status","no_star");
			model.addAttribute("store", store);
		} else {
			ListVO store = storeService.getStoreStarAvg(storeId);
			model.addAttribute("status","yes_star");
			model.addAttribute("store", store);
			List<MenuVO> menuList = menuService.getMenuList(storeId);
			model.addAttribute("menu", menuList);
		}
		return "hankki/menu_insertform";
	}

	// 메뉴 삽입 처리 화면
	@RequestMapping(value = "/hankki/{storeId}/insertmenu", method = RequestMethod.POST)
	public String insertMenu(MenuVO menu, Model model) {
		menuService.insertMenu(menu);
		return "redirect:/hankki/{storeId}";
	}

	// 가게 수정 화면
	@RequestMapping(value = "/hankki/{storeId}/update", method = RequestMethod.GET)
	public String updateStore(@PathVariable int storeId, Model model) {
		ListVO store = storeService.getStoreStarAvg(storeId);
		List<MenuVO> menuList = menuService.getMenuList(storeId);

		model.addAttribute("store", store);
		model.addAttribute("menu", menuList);
		return "hankki/store_updateform";
	}

	// 가게 수정 처리
	@RequestMapping(value = "/hankki/{storeId}/update", method = RequestMethod.POST)
	public String updateStore(StoreVO store, Model model) {
		storeService.updateStore(store);
		return "redirect:/hankki/" + store.getStoreId();
	}

	// 가게 삭제 처리
	@RequestMapping(value = "/hankki/delete/{storeId}", method = RequestMethod.POST)
	public String deleteStore_get(@PathVariable int storeId, Model model) {
		storeService.deleteStore(storeId);
		return "redirect:/home";
	}

	// 메뉴 삭제 처리
	@RequestMapping(value = "/hankki/delete_menu/{menuId}", method = RequestMethod.POST)
	public String deleteMenu_get(@PathVariable int menuId, int storeId, Model model) {
		menuService.deleteMenu(menuId);
		return "redirect:/hankki/" + storeId;
	}

//	@RequestMapping(value={"/hankki", "/hankki/list"})
//	public String getAllStores(Model model) {
//		List<StoreVO> storeList = storeService.getStoreList();
//		model.addAttribute("storeList", storeList);
//		return "hankki/list";
//	}
//	
//	@RequestMapping(value="/hankki/{storeId}")
//	public String getStoreInfo(@PathVariable int storeId, Model model) {
//		StoreVO store = storeService.getStoreInfo(storeId);
//		model.addAttribute("store", store);
//		return "hankki/view";
//	}
//	
//	@RequestMapping(value="/bbc/{storeId}")
//	public @ResponseBody StoreVO bbc(@PathVariable int storeId) {
//		StoreVO store = storeService.getStoreInfo(storeId);
//		return store;
//	}
//	
//	@RequestMapping(value="/hankki/insert", method=RequestMethod.GET)
//	public String insertStore(Model model) {
////		model.addAttribute("deptList", empService.getAllDeptId());
////		model.addAttribute("jobList", empService.getAllJobId());
////		model.addAttribute("managerList", empService.getAllManagerId());
//		return "hankki/insertform";
//	}
//	
//	@RequestMapping(value="/hankki/insert", method=RequestMethod.POST)
//	public String insertStore(StoreVO store, Model model) {
//		storeService.insertStore(store);
//		return "redirect:/hankki";
//	}
//	
//	@RequestMapping(value="/hankki/update", method=RequestMethod.GET)
//	public String updateStore(int storeid, Model model) {
//		model.addAttribute("store", storeService.getStoreInfo(storeid));
////		model.addAttribute("deptList", empService.getAllDeptId());
////		model.addAttribute("jobList", empService.getAllJobId());
////		model.addAttribute("managerList", empService.getAllManagerId());
//		return "hankki/updateform";
//	}
//	
//	@RequestMapping(value="/hankki/update", method=RequestMethod.POST)
//	public String updateStore(StoreVO store, Model model) {
//		storeService.updateStore(store);
//		return "redirect:/hankki/"+ store.getStoreId();
//	}
//	

//	
//	@RequestMapping(value="/hankki/delete", method=RequestMethod.POST)
//	public String deleteStore_post(int storeid, Model model) {
//		storeService.deleteStore(storeid);
//		return "redirect:/hankki";
//	}
//	
//	@ExceptionHandler({RuntimeException.class})
//	public ModelAndView runtimeException(HttpServletRequest request, Exception ex) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("url",  request.getRequestURI());
//		mav.addObject("exception", ex);
//		mav.setViewName("error/runtime");
//		return mav;
//	}
//	
//	@RequestMapping(value="/hankki/json")
//	public @ResponseBody List<StoreVO> getStoreJSONList() {
//		List<StoreVO> storeList = storeService.getStoreList();
//		return storeList;
//	}
//
//	@RequestMapping(value="/hankki/json/{employeeId}")
//	public @ResponseBody StoreVO getStoreJSONInfo(@PathVariable int storeId) {
//		StoreVO store = storeService.getStoreInfo(storeId);
//		return store;
//	}
//
//	@RequestMapping(value="/hankki/ajax")
//	public @ResponseBody StoreVO getStoreByJSON(@RequestBody List<Map<String, Object>> datas) {
//		Map<String, Object> data = datas.get(0);
//		int storeId = Integer.parseInt((String)data.get("value"));
//		StoreVO store = storeService.getStoreInfo(storeId);
//		return store;
//	}

}// end class