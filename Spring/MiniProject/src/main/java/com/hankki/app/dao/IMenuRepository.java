package com.hankki.app.dao;

import java.util.List;

import com.hankki.app.model.MenuVO;

public interface IMenuRepository {
	int getMenuCount();
	int getMenuCount(String name);
	List<MenuVO> getMenuList(int storeid);
	MenuVO getMenuInfo(int menuid);
	void updateMenu(MenuVO menu);
	void insertMenu(MenuVO menu);
	void deleteMenu(int menuid);
	
}