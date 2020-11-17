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
  
</head>
<body>
<h1>Register User</h1>
	
<form action="saveUser" method="post" modelAttribute="newUser">

  	 <div class="form-group">
	<label for = "name">Full Name: </label>
	<input type="text"  class="form-control" name="name" required>
	</div>
	
	<div class="form-group">
	<label for = "email">Email: </label>
	<input type="text" class="form-control" name="email" required>
	</div>
	
	<div class="form-group">
	<label for = "username">Username: </label>
	<input type="text" class="form-control" name="username" required>
	</div>
	
	<div class="form-group">
	<label for = "password">Password: </label>
	<input type="password" class="form-control"name="password" required>
	</div>
	
	
	<p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
	<button type="submit"class="btn btn-default">Register</button>
</form>

</body>
</html>