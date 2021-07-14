<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Customer</title>
<style>

table{
	width: 100%;
}



table,td,th
{

font-size:26px;
border: 1px solid black;
text-align:center;
}

table
{
width:60%;
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
	
.button {
  background-color:#3598dc;
  border: none;
  color: white;
  padding: 6px 13px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
  margin: 4px 2px;
  cursor: pointer;
}
.button:hover{

	background-color:green;
}

</style>
</head>
<body>
<%@include file="navbar.jsp" %>
<br><br><br>
<center>
<font size=6 color=red>List of customers</font>

<br><br>
<table border = 1 id = myTable>


<tr style="background-color:#6db6b9e6">

<th>S.no</th>
<th>Name</th>
<th>Account no</th>
<th>Balance</th>
<th>Transfer money</th>

</tr>
<%

UserDao ud = new UserDao();
ArrayList al = ud.getAll();

UserBean u = new UserBean();
int count = 1;
for(int i=0; i<al.size(); i++)	
{
u = (UserBean)al.get(i);
%>
		
<tr>
<td><%=count %></td>
<td><%=u.getName() %></td>
<td><%=u.getAccNo() %></td>
<td><%=u.getBal()%></td>


<td><a href="transfer.jsp?acc=<%=u.getAccNo()%>" class = "button">Send money</a></td>

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