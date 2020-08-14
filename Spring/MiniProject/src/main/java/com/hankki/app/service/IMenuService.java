package com.hankki.app.service;

import java.util.List;

import com.hankki.app.model.MenuVO;

public interface IMenuService {
	int getMenuCount();
	int getMenuCount(String name);
	List<MenuVO> getMenuList(int storeid);
	MenuVO getMenuInfo(int menuid);
	void updateMenu(MenuVO menu);
	void insertMenu(MenuVO menu);
	void deleteMenu(int menuid);
} 