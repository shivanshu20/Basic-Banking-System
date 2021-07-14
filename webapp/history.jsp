<%@page import="com.dao.TransactionHistory"%>
<%@page import="com.bean.HistoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.Transaction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>


table,td,th
{

font-size:27px;
border: 0.5px solid black;
text-align:center;
}

table
{
width:70%;
border-collapse:collapse;
}

table a{

  	text-decoration: none;
}

table tr:nth-child(even) {
	background-color: #f2f2f2;
}

table tr:hover {
	background-color: #ddd;
}

</style>

</head>

<body>

<%@include file="navbar.jsp" %>
<br><br><br>
<center>
<font size=6 color=red>Transaction history of customers</font>

<br><br>
<table border = 1 id = myTable>


<tr style="background-color:#6db6b9e6">

<th>S.no</th>
<th>Sender's name</th>
<th>Sender's acc no</th>
<th>Receiver's name</th>
<th>Receiver's acc no</th>
<th>Amount</th>
<th>Date</th>
<th>Time</th>

</tr>
<%

TransactionHistory t = new TransactionHistory();

ArrayList al = t.getAll();

HistoryBean hb = new HistoryBean();

int count = 1;
for(int i=0; i<al.size(); i++)	
{
hb = (HistoryBean)al.get(i);
%>
		
<tr>
<td><%=count %></td>

<td><%=hb.getSName() %></td>
<td><%=hb.getSAccno() %></td>

<td><%=hb.getRName() %></td>
<td><%=hb.getRAccno() %></td>

<td><%=hb.getAmount() %></td>
<td><%=hb.getDate() %></td>
<td><%=hb.getTime() %></td>

</tr>

<%
count++;
}
%>

</table>
</center>
</table>
</body>

</html>