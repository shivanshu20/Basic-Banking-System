package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import com.bean.HistoryBean;
import com.bean.UserBean;


public class Transaction {

	Connection con = null;
	
	int rbal = 0;
	int sbal = 0;
	
	String sender = null;
	String receiver = null;
	int amount = 0;
	
	static String sname = null;
	static String rname = null;
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String conUrl = "jdbc:mysql://localhost:3306/bank?user=root"
			+ "&password=priyanshi";
	
	
	
	public Transaction() {
		
	}
	
	public Transaction(String s1, String s2, int amount){
		
		sender = s1;
		receiver = s2;
		this.amount = amount;
		
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(conUrl);
		} 
		catch (Exception e) {
			System.out.println("Error in loading driver or in making connection");
		}
	}
	
	public int check(String acc) {
		
		final String p = "select * from details where accno=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(p);
			
			ps.setString(1, acc);
						
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()==false)
				return -1;
			
			rbal = rs.getInt("bal");
			rname = rs.getString("name");
			System.out.println(rs.getString("name"));
			sbal = getSenderBal();
			
			if(sbal < amount)
				return 0;
			int status = sendMoney();
			TransactionHistory t = new TransactionHistory(sname, rname);
			return status;
			
		}
		catch(Exception e) {
			System.out.println("Error in check account method");
		}
		return -2;
	}
	

	public int getSenderBal() {
		
		final String p = "select * from details where accno=?";
		int amt = 0;
		
		try {
			
			PreparedStatement ps = con.prepareStatement(p);
			ps.setString(1, sender);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next() == false)
				return 0;
			
			amt = rs.getInt("bal");
			sname = rs.getString("name");
			System.out.println(rs.getString(2));
			
		}
		catch(Exception e) {
			System.out.println("Error in getSenderBal method");
		}
		return amt;
	}
	
	public int sendMoney() {
		
		int amt1 = sbal - amount;
		int amt2 = rbal + amount;
		int sum = 0;
		
		final String p = "update details set bal=? where accno=?";
		try {
			
			PreparedStatement ps = con.prepareStatement(p);
			
			ps.setInt(1, amt1);
			ps.setString(2, sender);
			ps.addBatch();
			
			ps.setInt(1, amt2);
			ps.setString(2, receiver);
			ps.addBatch();
			
			int a[] = ps.executeBatch();
			for (int i : a) {
				sum += a[i];
			}
		}
		
		catch(Exception e) {
			System.out.println("Error in sendMoney method");
		}
		return sum;
	}
	
}
