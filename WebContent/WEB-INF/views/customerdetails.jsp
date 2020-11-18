<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  <style>
.content{
	margin-left:20%;
	width:60%;
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
        <a class="nav-link" href="customerhome.jsp">Welcome ${user.username } <span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="shoppingcart.jsp">Cart</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="#">About us</a>
      </li>
     <li class="nav-item">
        <a class="nav-link" href="#">Contact us</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="logout">Logout</a>
      </li>
     
         
    </ul>
    
  </div>
</nav>
<form action="confirmorder" method="post">
<h3>Customer Details</h3>
<hr>
<h5>Basic Info</h5>
  <div class="form-group">
    <label for="CustName">Name</label>
    <input type="text" class="form-control" value=${user.username }>
  
  </div>
  <div class="form-group">
    <label for="CustEmail">Email</label>
    <input type="email" class="form-control" value=${user.email } >
  </div>
  <div class="form-group">
    <label for="CustPhoneNum">Phone Number</label>
    <input type="tel" class="form-control" name="CustPhoneNum" placeholder="(xxx) xxx-xxxx" required >
  </div>
  <h5>Billing Info</h5>
  <div class="form-group">
    <label for="CustAddress">Street Address</label>
    <input type="tel" class="form-control" name="CustAddress" placeholder="Enter Street Address" required >
     <small id="addresslHelp" class="form-text text-muted">ex. 10 Water Street</small>
  </div>
  <div class="form-group">
    <label for="CustCity">City</label>
    <input type="tel" class="form-control" name="CustCity"pattern="[A-Z][a-z]*" placeholder="Enter City" required >
  </div>
   <div class="form-group">
    <label for="CustState">State</label>
    <input type="tel" class="form-control" name="CustState" pattern="[A-Z]{2}" placeholder="Enter State" required >
    <small id="emailHelp" class="form-text text-muted">ex. MD </small>
  </div>
   <div class="form-group">
    <label for="CustZip">Zip</label>
    <input type="tel" class="form-control" name="CustZip" placeholder="Enter Zip" required >
 
  </div>
  
  <button type="submit" class="btn btn-primary">Checkout</button>
</form>
</div>
</body>
</html>