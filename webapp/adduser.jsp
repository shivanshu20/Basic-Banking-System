<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<title>Create account</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script> 


<style>
body {	
	margin-top:170px;
	color: #fff;
	background: white;
	font-family: 'Roboto', sans-serif;
	
}
.form-control {
	
	
	height: 41px;
	background: #f2f2f2;
	box-shadow: none !important;
	border: none;
}
.form-control:focus {
	background: #e2e2e2;
}
.form-control, .btn {        
	border-radius: 3px;
}

.signup-form{
	border-style:solid;
	border-color:#3598dc;
}
.signup-form {
	width: 450px;
	margin: 30px auto;
}
.signup-form form {
	color: #999;
	border-radius: 3px;
	margin-bottom: 15px;
	background: #fff;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}
.signup-form h2  {
	color: #333;
	font-weight: bold;
	margin-top: 0;
}
.signup-form hr  {
	margin: 0 -30px 20px;
}    
.signup-form .form-group {
	margin-bottom: 20px;
}
.signup-form input[type="checkbox"] {
	margin-top: 3px;
}

.signup-form .btn {        
	font-size: 16px;
	font-weight: bold;
	background: #3598dc;
	border: none;
	min-width: 100px;
}
.signup-form .btn:hover, .signup-form .btn:focus {
	background: green;
	outline: none;
}

.signup-form .hint-text  {
	padding-bottom: 15px;
	text-align: center;
}



</style>

</head>

</div>

<body>


<div class="signup-form">
    <form action="UserServlet" method="post">
    
    
<h5>
<%
String msg = (String)request.getAttribute("msg");

if(msg != null)
	
	out.println(msg);
%>
	
</h5>

		<h2>Create account</h2>
		
		<p>Please fill in this form to create an account!</p>
		<hr>
        <div class="form-group">
			<div class="row">
				<div class="col">Name<input type="text" class="form-control" name="name" placeholder="Enter name" required="required" ></div>
				
			</div>        	
        </div>
        
        <div class="form-group">
        	Email<input type="email" class="form-control" name="accNo" placeholder="Enter email" required="required">
        </div>
        
		<div class="form-group">
            Balance<input type="text" class="form-control" name="bal" placeholder="Enter balance" required="required">
        </div>
		      
       	
	<div class="form-group">
            <button type="submit" class="btn btn-primary btn-lg">Create</button>
            <button type="reset"  class="btn btn-primary btn-lg">Reset</button>
            <a href="index.jsp" class="btn btn-primary btn-lg" role="button">Back</a>
        </div>
       
        
    </form>
	
</div>
</body>
</html>				                            