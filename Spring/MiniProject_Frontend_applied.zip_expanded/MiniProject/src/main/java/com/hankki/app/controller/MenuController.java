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
import com.hankki.app.service.IMenuService;

@Controller
public class MenuController {

	@Autowired
	IMenuService menuService;
	
	@RequestMapping(value="/hankki/menu/count")
	public String MenuCount(
		@RequestParam(value="name", required=false, defaultValue="0") String name, 
		Model model) {
		if(name==null) {
			model.addAttribute("count", menuService.getMenuCount());
		}else {
			model.addAttribute("count", menuService.getMenuCount(name));
		}
		return "hankki/menu/count";
	}

	@RequestMapping(value={"/hankki/menu", "/hankki/menu/list"})
	public String getAllMenus(Model model) {
		List<MenuVO> menuList = menuService.getMenuList();
		model.addAttribute("menuList", menuList);
		return "hankki/list";
	}
	
	@RequestMapping(value="/hankki/menu/{menuId}")
	public String getMenuInfo(@PathVariable int menuId, Model model) {
		MenuVO menu = menuService.getMenuInfo(menuId);
		model.addAttribute("menu", menu);
		return "hankki/view";
	}
	
	@RequestMapping(value="/bbc/menu/{menuId}")
	public @ResponseBody MenuVO bbc(@PathVariable int menuId) {
		MenuVO menu = menuService.getMenuInfo(menuId);
		return menu;
	}
	
	@RequestMapping(value="/hankki/menu/insert", method=RequestMethod.GET)
	public String insertMenu(Model model) {
//		model.addAttribute("deptList", empService.getAllDeptId());
//		model.addAttribute("jobList", empService.getAllJobId());
//		model.addAttribute("managerList", empService.getAllManagerId());
		return "hankki/menu/insertform";
	}
	
	@RequestMapping(value="/hankki/menu/insert", method=RequestMethod.POST)
	public String insertMenu(MenuVO menu, Model model) {
		menuService.insertMenu(menu);
		return "redirect:/hankki";
	}
	
	@RequestMapping(value="/hankki/menu/update", method=RequestMethod.GET)
	public String updateMenu(int menuid, Model model) {
		model.addAttribute("menu", menuService.getMenuInfo(menuid));
//		model.addAttribute("deptList", empService.getAllDeptId());
//		model.addAttribute("jobList", empService.getAllJobId());
//		model.addAttribute("managerList", empService.getAllManagerId());
		return "hankki/menu/updateform";
	}
	
	@RequestMapping(value="/hankki/menu/update", method=RequestMethod.POST)
	public String updateMenu(MenuVO menu, Model model) {
		menuService.updateMenu(menu);
		return "redirect:/hankki/menu/"+menu.getMenuId();
	}
	
	@RequestMapping(value="/hankki/menu/delete", method=RequestMethod.GET)
	public String deleteMenu(int menuid, Model model) {
		model.addAttribute("menu", menuService.getMenuInfo(menuid));
		return "hankki/menu/deleteform";
	}
	
	@ExceptionHandler({RuntimeException.class})
	public ModelAndView runtimeException(HttpServletRequest request, Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("url",  request.getRequestURI());
		mav.addObject("exception", ex);
		mav.setViewName("error/runtime");
		return mav;
	}
	
	@RequestMapping(value="/hankki/menu/json")
	public @ResponseBody List<MenuVO> getMenuJSONList() {
		List<MenuVO> menuList = menuService.getMenuList();
		return menuList;
	}

	@RequestMapping(value="/hankki/menu/json/{menuId}")
	public @ResponseBody MenuVO getMenuJSONInfo(@PathVariable int menuId) {
		MenuVO menu = menuService.getMenuInfo(menuId);
		return menu;
	}

	@RequestMapping(value="/hankki/menu/ajax")
	public @ResponseBody MenuVO getMenuByJSON(@RequestBody List<Map<String, Object>> datas) {
		Map<String, Object> data = datas.get(0);
		int menuId = Integer.parseInt((String)data.get("value"));
		MenuVO menu = menuService.getMenuInfo(menuId);
		return menu;
	}

	
}//end class