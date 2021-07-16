package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.bean.UserBean;

public class UserDao {
	
	Connection con = null;
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String conUrl = "jdbc:mysql://localhost:3306/bank?user=root"
			+ "&password=password";
	
	public UserDao() {
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(conUrl);
		} 
		catch (Exception e) {
			System.out.println("Error in loading driver or in making connection");
		}
	}
	
	public boolean check(String accNo) {
		
		
		final String p = "select * from details where accno=?";
		try {
			
			PreparedStatement ps = con.prepareStatement(p);
			
			ps.setString(1, accNo);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return false; 
			}
		}
		catch(Exception e) {
			
			System.out.println("Error in check method");
		}
		return true;
	}
	
	
	public int insertDetails(UserBean u) {
		
		int status = 0;
		
		final String p = "insert into details values(?,?,?)";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(p);
			
			ps.setString(1, u.getAccNo());
			ps.setString(2, u.getName());
			ps.setInt(3, u.getBal());
			
			status = ps.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println("Error in insert details method");
		}
		return status;
	}
	
	public ArrayList getAll() {
		
		ArrayList<UserBean> al = new ArrayList<UserBean>();
		final String p = "select * from details";
		
		try {
			PreparedStatement ps = con.prepareStatement(p);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				UserBean u = new UserBean();
				
				u.setName(rs.getString("name"));
				u.setAccNo(rs.getString("accno"));
				u.setBal(rs.getInt("bal"));
				
				
				al.add(u);
			}
			Collections.sort(al);
		}
		catch(Exception e) {
			System.out.println("Error in getAll method");
		}
		
		
		
		return al;
	}
}
