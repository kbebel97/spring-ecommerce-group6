<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
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
.cartDiv{
  padding:5px;
  background-color:white;
  width:60%;
  border:1px solid lightgrey;
  border-radius: 25px;
  margin:5px;
  float:left;
  transition:0.3s;
}
</style>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
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
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
<body>


<h1 style="margin:10px">Your Cart</h1>
<c:forEach var="item" items="${cartItems}">
	<div class="cartDiv">
		<div style="width:30%; float:left;margin-right:10px">
			<img src = ${item.code} style="width:100%">
		</div>
		<h6>${item.name}</h6>
		<p>Quantity: ${item.quantity }</p>
		<p>${item.price}</p>
		

	</div>
</c:forEach>

<form action="customerdetails" method="get">
	<input type="hidden" name="userId" value=${user.userId }>
	<button type="submit">Place Your Order!</button>
</form>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
<p> </p><br/>
</div>
<button class="btn btn-primary" onclick="location.href = 'customerdetails.jsp';" >Place Order</button>
<button type="button" class="btn btn-danger">Clear Cart</button>

</body>
</html>