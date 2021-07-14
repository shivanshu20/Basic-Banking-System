package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.dao.Transaction;
import com.dao.TransactionHistory;


public class TransactionServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession(false);
		String sender = (String)session.getAttribute("accno");
		
		
		String receiver = request.getParameter("receiver");
		int amount = Integer.parseInt(request.getParameter("bal"));
		
		
		Transaction t = new Transaction(sender, receiver, amount);
		
		
		
		if(sender.equals(receiver))
			request.setAttribute("msg", "Enter valid accno");
		
		else {
			
			int valid = t.check(receiver);
			
			if(valid == -1)
				request.setAttribute("msg", "Invalid receiver's accno");
		
		
			else if(valid == 0)
				request.setAttribute("msg", "Insufficient balance");
		
			else if(valid == 2){
				request.setAttribute("msg", "Transaction successfull");
			
			TransactionHistory th = new TransactionHistory();
			th.setHistory(sender, receiver, amount);
			}
		}

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/transfer.jsp");
		rd.include(request, response);
	}
}
