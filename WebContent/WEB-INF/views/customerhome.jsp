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
</head>
<body>
	<h1></h1>
	<div class="tables">
		<div> Hello
		</div>
		<div> Hello
		</div>
	</div>
	
display all products here, make each item div clickable so you can get linked to that item's page <br/>
when you get to the item page, then you can add to cart<br/>
<a href="shoppingcart.jsp">Your Shopping Cart</a><br/>

<div class="productDiv">
	<div style="width:40%; float:left;margin-right:10px">
		<img src = "https://raymourflanigan.scene7.com/is/image/RaymourandFlanigan/FW_LANE_200297706_3000?wid=1600&fit=fit%2C1" style="width:100%">
	</div>
	<h1>Ollie Chenille Sofa</h1>
	<h2>$765</h2>
	<button>Add to cart</button><!-- might end up making this form with just a submit button -->
</div>
</body>
</html>