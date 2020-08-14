package com.hankki.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hankki.app.dao.IMenuRepository;
import com.hankki.app.model.MenuVO;

@Service
public class MenuService implements IMenuService {

	@Autowired
	IMenuRepository menuRepository;

	@Override
	public int getMenuCount() {
		return menuRepository.getMenuCount();
	}

	@Override
	public int getMenuCount(String name) {
		return menuRepository.getMenuCount(name);
	}

	@Override
	public List<MenuVO> getMenuList(int storeid) {
		return menuRepository.getMenuList(storeid);
	}

	@Override
	public MenuVO getMenuInfo(int menuid) {
		return menuRepository.getMenuInfo(menuid);
	}

	@Override
	public void updateMenu(MenuVO menu) {
		menuRepository.updateMenu(menu);		
	}

	@Override
	public void insertMenu(MenuVO menu) {
		menuRepository.insertMenu(menu);		
	}

	@Override
	@Transactional
	public void deleteMenu(int menuid) {
		menuRepository.deleteMenu(menuid);		
	}

}