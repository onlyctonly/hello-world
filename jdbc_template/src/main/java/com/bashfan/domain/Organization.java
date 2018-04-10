package com.bashfan.domain;

public class Organization {
	private int id;
	private String companyName;
	private int yearOfOperation;
	private int employeeCount;
	private int postalCode;
	private String slogan;
	public Organization() {
	}
	public Organization(String companyName, int yearOfOperation, int employeeCount, int postalCode,
			String slogan) {
		this.companyName = companyName;
		this.yearOfOperation = yearOfOperation;
		this.employeeCount = employeeCount;
		this.postalCode = postalCode;
		this.slogan = slogan;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getYearOfOperation() {
		return yearOfOperation;
	}
	public void setYearOfOperation(int yearOfOperation) {
		this.yearOfOperation = yearOfOperation;
	}
	public int getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	@Override
	public String toString() {
		return "Organization [id=" + id + ", companyName=" + companyName + ", yearOfOperation=" + yearOfOperation
				+ ", employeeCount=" + employeeCount + ", postalCode=" + postalCode + ", slogan=" + slogan + "]";
	}
	
	

}
