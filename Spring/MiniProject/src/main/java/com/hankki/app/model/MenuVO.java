package com.hankki.app.model;

public class MenuVO {

	private int menuId;
	private int storeId;
	private String menuName;
	private int cost;
	private String imgStr;
	private String comments;
	private double star;
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getImgStr() {
		return imgStr;
	}
	public void setImgStr(String imgStr) {
		this.imgStr = imgStr;
	}	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public double getStar() {
		return star;
	}
	public void setStar(double star) {
		this.star = star;
	}
	
	
	@Override
	public String toString() {
		return "MenuVO [menuId=" + menuId + ", storeId=" + storeId + ", menuName=" + menuName + ", cost=" + cost
				+ ", imgStr=" + imgStr + ", comments=" + comments + ", star=" + star + "]";
	}	
	
}
