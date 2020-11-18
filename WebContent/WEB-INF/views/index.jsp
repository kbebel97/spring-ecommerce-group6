<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 
        
<title>Login</title>

<link rel="stylesheet" href="stylesheet.css">
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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="index.jsp">Furniture Store</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Login <span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="#">About us</a>
      </li>
     <li class="nav-item">
        <a class="nav-link" href="#">Contact us</a>
      </li>
         
    </ul>
    
  </div>
</nav>

<h1>Login</h1>
<hr>

	<h4>Customer Log In</h4>
	<form action="usercatalog" method="get"  modelAttribute="user"><!-- This is for customer login -->
	
	 <div class="form-group">
		<label for = "email">Email: </label>
		<input type="text" class="form-control" name="email" autocomplete="off" required>
		</div>
		<div class="form-group">
		<label for = "password">Password: </label>
		<input type="password" class="form-control" name="password" required>
		</div>
		<button type="submit"class="btn btn-default" >Log In</button>
	</form>
<br/>


	<h4>Admin Log In</h4>
	<form action="adminlogin" method="post"><!-- This is for admin login -->
	<div class="form-group">
		<label for = "email">Email: </label>
		<input type="text" class="form-control" name="email" autocomplete="off" required>
		</div>
		<div class="form-group">
		<label for = "password">Password: </label>
		<input type="password" class="form-control" name="password" required>
		</div>
		<button type="submit"class="btn btn-default" >Log In</button>
	</form>
	<br/>

<a href ="register">Don't have an Account? Register now</a><br/>
</div>



</body>
</html>