package com.hankki.app.dao;

import java.util.List;
import java.util.Map;

import com.hankki.app.model.MenuVO;

public interface IMenuRepository {
	int getMenuCount();
	int getMenuCount(String name);
	List<MenuVO> getMenuList();
	MenuVO getMenuInfo(int Menuid);
	void updateMenu(MenuVO Menu);
	void insertMenu(MenuVO Menu);
	void deleteMenu(int Menuid);
	List<MenuVO> getStoreMenulist();
	
}