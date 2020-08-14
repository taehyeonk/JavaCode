package com.hankki.app.service;

import java.util.List;
import java.util.Map;

import com.hankki.app.model.MenuVO;

public interface IMenuService {
	int getMenuCount();
	int getMenuCount(String name);
	List<MenuVO> getMenuList();
	MenuVO getMenuInfo(int menuid);
	void updateMenu(MenuVO Menu);
	void insertMenu(MenuVO Menu);
	void deleteMenu(int menuid);
} 