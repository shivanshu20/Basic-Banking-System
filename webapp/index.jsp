<!DOCTYPE html>
<html>
<head>
<title> Home </title>
<style>
    body{
        
        background-color: #FFFFFF;
    }
.bank{

	margin-top: 12px;
	margin-right: 90px;	
	float: right;
	display: inline-block;
}
.first{
	
	display: inline-block;
	float: left;
	margin-left: 200px;
	margin-top: 170px;
	
}


.table{
margin-top: 450px;
}

.navbar{
	overflow: hidden;
	background-color:#333;
}
.navbar a{
	
	float:left;
	color : #f2#f2#f2;
	text-align : center;
	padding : 14px 16px;
	text-decoration: none;
	font-size : 15px;
	color:white;
}
.navbar a:hover{
	
	background-color:#3598dc;
	color:black;
}

</style>
</head>

<body>

<div class = "navbar">
	
	<a href = "index.jsp">Home</a>
	
	<a href = "adduser.jsp">Add Customer</a>
	
	<a href = "allCustomers.jsp">View Customer</a>
	
	<a href = "viewcustomer.jsp">Transfer Money</a>
	
	<a href = "history.jsp">Transaction History</a>
	
</div>
<font class="first" size="10px">
Welcome to the Apna bank!
</font>

<img class="bank" src="img/bank.png" width=45%; height=420px;>


<table class="table" border="0" width="100%" >

<tr>
<th>
<a href="adduser.jsp"><img class="images" src="img/user.png" width=35%; height=180px;></a>
</th>
<th>
<a href="viewcustomer.jsp"><img class="images" src="img/transfer.jpg" width=40%; height=190px;></a>
</th>
<th>
<a href="history.jsp"><img class="images" src="img/history.jpg" width=50%; height=180px;></a>
</th>
<tr>
    <th><font size="5px">Add Customer</font></th>
    <th><font size="5px">Transfer Money</font></th>
    <th><font size="5px">Check History</font></th>
</tr>
</table>
<br><br>
<footer>
	<center>
	<p>&copy 2021. Made by <b>SHIVANSHU GAUTAM</b></p>
	</center>
	</footer>
</body>
</html>
