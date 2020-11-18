<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<style>
.content{
	margin-left:20%;
	width:60%;
	margin-right:20%;
	padding:10px;
    border: 1px solid rgb(217,217,217);
    background-color:rgb(248, 249, 251);
}
</style>
</head>
<body>

<div class="content">
<h1>Register User</h1>
	
<form action="saveUser" method="post" modelAttribute="newUser">

  	 <div class="form-group">
	<label for = "name">Full Name: </label>
	<input type="text"  class="form-control" name="name" autocomplete="off" required>
	
	</div>
	
	<div class="form-group">
	<label for = "email">Email: </label>
	<input type="text" class="form-control" name="email" autocomplete="off" required>
	</div>
	
	<div class="form-group">
	<label for = "username">Username: </label>
	<input type="text" class="form-control" name="username" autocomplete="off" required>
	</div>
	
	<div class="form-group">
	<label for = "password">Password: </label>
	<input type="password" class="form-control"name="password" autocomplete="off" required>
	</div>
	
	
	<p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
	<button type="submit"class="btn btn-default">Register</button>
</form>
</div>
</body>
</html>