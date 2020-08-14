package com.coderby.hr.model;

public class DeptVO {
//	DEPARTMENT_ID   NOT NULL NUMBER(4)
	private int departmentId;
//	DEPARTMENT_NAME NOT NULL VARCHAR2(30)
	private String departmentName;
//	MANAGER_ID               NUMBER(6)
	private int managerId;
//	LOCATION_ID              NUMBER(4)
	private int locationId;
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	@Override
	public String toString() {
		return "DeptVO [departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId="
				+ managerId + ", locationId=" + locationId + "]";
	}

}
