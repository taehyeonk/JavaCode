package com.hankki.app.dao;

import java.util.List;
import java.util.Map;

import com.hankki.app.model.ListVO;
import com.hankki.app.model.StoreVO;

public interface IStoreRepository {
	int getStoreCount();
	int getStoreCount(String name);
	List<StoreVO> getStoreList();
	StoreVO getStoreInfo(int storeid);
	void updateStore(StoreVO store);
	void insertStore(StoreVO store);
	void deleteStore(int storeid);
	
	ListVO getStarinfo(int storeid);
	
	List<ListVO> getStaravg(); // menu 테이블의 store_id를 통해 총 메뉴의 평균 별점 계산
	int getStoreMenuCount(int storeId);
	
}