<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- <link rel="stylesheet" href="stylesheet.css"> -->
<title>Customer Home</title>
<style>
.productDiv{
  padding:5px;
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
<body>
<a href="shoppingcart.jsp">Your Shopping Cart</a><br/>



	<c:forEach var="item" items="${items}">
		<div class="productDiv">
			<div style="width:40%; float:left;margin-right:10px">
				<img src = ${item.code} style="width:100%">
			</div>
			<h1>${item.name}</h1>
			<h2>${item.price}</h2>
			<form action="addtoCart" method="get">
				<input type="hidden" name="itemId" value=${item.itemId }>
				<input type="hidden" name="userId" value=${user.userId }>
				<button type="submit">Add to cart</button>			
			</form>
		</div>
	</c:forEach>



</body>
</html>