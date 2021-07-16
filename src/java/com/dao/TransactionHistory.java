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

public class TransactionHistory {
	
	Connection con = null;
	static String s1 = null;
	static String s2 = null;
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String conUrl = "jdbc:mysql://localhost:3306/bank?user=root"
			+ "&password=password";
	
	public TransactionHistory() {
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(conUrl);
		} 
		catch (Exception e) {
			System.out.println("Error in loading driver or in making connection");
		}
	}
	
	public TransactionHistory(String s1, String s2) {
		
		this.s1 = s1;
		this.s2 = s2;
	}
	
	public void setHistory(String sname, String rname, int amount) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		String date=sdf.format(c.getTime());
		System.out.println(date);

		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
		Date date2 = new Date();  
		String time = String.valueOf(formatter.format(date2));
		
		System.out.println(formatter.format(date2));
		
		final String p = "insert into history values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(p);
			
			ps.setString(1, s1); 		//sender's name
			ps.setString(2, sname);    //account no i.e email
			ps.setString(3, s2);	   //receiver's name
			ps.setString(4, rname);
			ps.setInt(5, amount);
			ps.setString(6, date);
			ps.setString(7, time);
			
			ps.executeUpdate();
		}
		catch(Exception e) {
			
			System.out.println("Error in setHistory method");
		}
	}
	
	
	public ArrayList getAll() {
		
		
		ArrayList<HistoryBean> al = new ArrayList<HistoryBean>();
		final String p = "select * from history";
		
		try {
			PreparedStatement ps = con.prepareStatement(p);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				HistoryBean h = new HistoryBean();
				
				
				h.setSName(rs.getString("sname"));
				h.setSAccno(rs.getString("saccno"));
				h.setRName(rs.getString("rname"));
				h.setRAccno(rs.getString("raccno"));
				h.setAmount(rs.getInt("amount"));
				h.setDate(rs.getString("date"));
				h.setTime(rs.getString("time"));
				
				al.add(h);
			}
			Collections.sort(al);
		}
		catch(Exception e) {
			System.out.println("Error in getAll method");
		}
		return al;
	}
}	
