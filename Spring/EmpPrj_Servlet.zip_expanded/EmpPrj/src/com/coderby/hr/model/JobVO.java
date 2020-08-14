package com.coderby.hr.model;

public class JobVO {
//	JOB_ID     NOT NULL VARCHAR2(10)
	private String jobId;
//	JOB_TITLE  NOT NULL VARCHAR2(35)
	private String jobTitle;
//	MIN_SALARY          NUMBER(6)
	private int minSalary;
//	MAX_SALARY          NUMBER(6)
	private int maxSalary;
	
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public int getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}
	public int getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}
	
	@Override
	public String toString() {
		return "JobVO [jobId=" + jobId + ", jobTitle=" + jobTitle + ", minSalary=" + minSalary + ", maxSalary="
				+ maxSalary + "]";
	}
	
}
