package com.bean;

public class HistoryBean implements Comparable<HistoryBean>{
	
	private String sname;
	private String rname;
	private String saccno;
	private String raccno;
	private String date;
	private String time;
	private int amount;
	
	public String getSName() {
		return sname;
	}
	public void setSName(String sname) {
		this.sname = sname;
	}
	
	public String getRName() {
		return rname;
	}
	public void setRName(String rname) {
		this.rname = rname;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getSAccno() {
		return saccno;
	}
	public void setSAccno(String saccno) {
		this.saccno = saccno;
	}
	
	public String getRAccno() {
		return raccno;
	}
	public void setRAccno(String raccno) {
		this.raccno = raccno;
	}
	
	@Override
	public int compareTo(HistoryBean that) {
		
		return this.sname.compareTo(that.sname);
	}
	
}
