package com.hankki.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hankki.app.dao.IMenuRepository;
import com.hankki.app.model.MenuVO;

@Service
public class MenuService implements IMenuService {

	@Autowired
	IMenuRepository MenuRepository;

	@Override
	public int getMenuCount() {
		return MenuRepository.getMenuCount();
	}

	@Override
	public int getMenuCount(String name) {
		return MenuRepository.getMenuCount(name);
	}

	@Override
	public List<MenuVO> getMenuList() {
		return MenuRepository.getMenuList();
	}

	@Override
	public MenuVO getMenuInfo(int Menuid) {
		return MenuRepository.getMenuInfo(Menuid);
	}

	@Override
	public void updateMenu(MenuVO Menu) {
		MenuRepository.updateMenu(Menu);		
	}

	@Override
	public void insertMenu(MenuVO Menu) {
		MenuRepository.insertMenu(Menu);		
	}

	@Override
	@Transactional
	public void deleteMenu(int Menuid) {
		MenuRepository.deleteMenu(Menuid);		
	}

}