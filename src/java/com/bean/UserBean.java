package com.bean;

import java.util.Comparator;

public class UserBean implements Comparable<UserBean>{
	
	private String name;
	private String accNo;
	
	private int bal;
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	
	public String getAccNo() {
		return accNo;
	}
	
	
	public void setBal(int bal) {
		this.bal = bal;
	}
	
	public int getBal() {
		return bal;
	}

	@Override
	public int compareTo(UserBean that) {
		
		return this.name.compareTo(that.name);
	}
	
	
}
