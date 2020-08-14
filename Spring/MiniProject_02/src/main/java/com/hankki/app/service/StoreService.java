package com.hankki.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hankki.app.dao.IStoreRepository;
import com.hankki.app.model.StoreVO;

@Service
public class StoreService implements IStoreService {

	@Autowired
	IStoreRepository storeRepository;

	@Override
	public int getStoreCount() {
		return storeRepository.getStoreCount();
	}

	@Override
	public int getStoreCount(String name) {
		return storeRepository.getStoreCount(name);
	}

	@Override
	public List<StoreVO> getStoreList() {
		return storeRepository.getStoreList();
	}

	@Override
	public StoreVO getStoreInfo(int storeid) {
		return storeRepository.getStoreInfo(storeid);
	}

	@Override
	public void updateStore(StoreVO store) {
		storeRepository.updateStore(store);		
	}

	@Override
	public void insertStore(StoreVO store) {
		storeRepository.insertStore(store);		
	}

	@Override
	@Transactional
	public void deleteStore(int storeid) {
		storeRepository.deleteStore(storeid);		
	}

}