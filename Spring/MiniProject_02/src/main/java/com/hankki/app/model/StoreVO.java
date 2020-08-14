package com.hankki.app.model;

public class StoreVO {

	private int storeId;
	private String imgStr;
	private String storeName;
	private String position;
	
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getImgStr() {
		return imgStr;
	}
	public void setImgStr(String imgStr) {
		this.imgStr = imgStr;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	@Override
	public String toString() {
		return "StoreVO [storeId=" + storeId + 
				", imgStr=" + imgStr + 
				", storeName=" + storeName + 
				", position=" + position + "]";
	}
	
}