package com.hankki.app.model;

public class ListVO {

	private int storeId;
	private String imgStr;
	private String storeName;
	private String position;
	private double star;
	
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
	public double getStar() {
		return star;
	}
	public void setStar(double star) {
		this.star = star;
	}
	
	
	@Override
	public String toString() {
		return "ListVO [storeId=" + storeId + ", imgStr=" + imgStr + ", storeName=" + storeName + ", position="
				+ position + ", star=" + star + "]";
	}
	
}
