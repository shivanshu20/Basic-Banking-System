package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;


public class UserServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String accNo = request.getParameter("accNo");
		int bal = Integer.parseInt(request.getParameter("bal"));
		
		
		UserDao ud = new UserDao();
		boolean isValid = ud.check(accNo);
		
		if(isValid == false) {
			
			request.setAttribute("msg", "Already exists accno");
		}
		
		else {
			UserBean u = new UserBean();
		
			u.setName(name);
			u.setAccNo(accNo);
			u.setBal(bal);
		
			int status = ud.insertDetails(u);
		
			if(status == 1) 
				request.setAttribute("msg", "Successfully created");
		
			else 
				request.setAttribute("msg", "Could not be added" );
			
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/adduser.jsp");
		rd.include(request, response);
	}
}
