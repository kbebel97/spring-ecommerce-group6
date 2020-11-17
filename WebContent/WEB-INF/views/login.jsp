<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login</h1>

<div>
	<p>Customer Log In</p>
	<form action="shoppingcart" method="get" modelAttribute="user"><!-- This is for customer login -->
		<label for = "email">Email: </label>
		<input type="text" name="email" required><br/>
		<label for = "password">Password: </label>
		<input type="password" name="password" required><br/>
		<button type="submit">Log In</button>
	</form>
</div>

<div>
	<p>Admin Log In</p>
	<form action="adminlogin" method="post"><!-- This is for admin login -->
		<label for = "username">Username: </label>
		<input type="text" name="username" required><br/>
		<label for = "password">Password: </label>
		<input type="password" name="password" required><br/>
		<button type="submit">Log In</button>
	</form>
</div>

<a href ="register">Don't have an Account? Register now</a><br/>

<a href ="adminhome.jsp">Admin skip log in, delete this before presentation</a><br/>
<a href ="customerhome.jsp">Customer skip log in, delete this before presentation</a>

</body>
</html>