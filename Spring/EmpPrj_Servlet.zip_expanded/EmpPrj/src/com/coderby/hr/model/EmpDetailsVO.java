package com.coderby.hr.model;

public class EmpDetailsVO extends EmpVO {
	private String departmentName;
	private String jobTitle;
	private String managerFirstName;
	private String managerLastName;
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getManagerFirstName() {
		return managerFirstName;
	}
	public void setManagerFirstName(String managerFirstName) {
		this.managerFirstName = managerFirstName;
	}
	public String getManagerLastName() {
		return managerLastName;
	}
	public void setManagerLastName(String managerLastName) {
		this.managerLastName = managerLastName;
	}
	
	@Override
	public String toString() {
		return "EmpDetailsVO [departmentName=" + departmentName + ", jobTitle=" + jobTitle + ", managerFirstName="
				+ managerFirstName + ", managerLastName=" + managerLastName + ", toString()=" + super.toString() + "]";
	}

}
