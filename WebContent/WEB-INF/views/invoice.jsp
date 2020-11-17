<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thank You!</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  
  <style type="text/css">
 
.padding {
    padding: 2rem !important
}

.card {
    margin-bottom: 30px;
    border: none;
    -webkit-box-shadow: 0px 1px 2px 1px rgba(154, 154, 204, 0.22);
    -moz-box-shadow: 0px 1px 2px 1px rgba(154, 154, 204, 0.22);
    box-shadow: 0px 1px 2px 1px rgba(154, 154, 204, 0.22)
}

.card-header {
    background-color: #fff;
    border-bottom: 1px solid #e6e6f2
}

h3 {
    font-size: 20px
}

h5 {
    font-size: 15px;
    line-height: 26px;
    color: #3d405c;
    margin: 0px 0px 15px 0px;
    font-family: 'Circular Std Medium'
}

.text-dark {
    color: #3d405c !important
}
  
  </style>
  
</head>
<body>

<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="display-4">Thank you for your business!</h1>
				<p class="lead">Your order is being processed and will be shipped in 7-14 business days.</p>
			</div>
			</div>
			
 <div class="offset-xl-2 col-xl-8 col-lg-12 col-md-12 col-sm-12 col-12 padding">
     <div class="card">
         <div class="card-header p-4">
            <a class="btn btn-sm btn-secondary float-right mr-1 d-print-none">Print</a>
            <a class="btn btn-sm btn-secondary float-right mr-1 d-print-none">Save</a>
             <div class="float-right">
                 <h3 class="mb-0">Invoice</h3>
                 Date:
             </div>
         </div>
         <div class="card-body">
             <div class="row mb-4">
                 <div class="col-sm-6">
                     
                     <h3 class="text-dark mb-1"><%= request.getParameter("name") %></h3>
                     <div><%=request.getParameter("CustAddress") %></div>
                     <div><%=request.getParameter("CustCity") %>, <%=request.getParameter("CustState") %>  <%=request.getParameter("CustZip") %></div>
                     <div>Email: <%=request.getParameter("email") %></div>
                     <div>Phone:<%=request.getParameter("CustPhoneNum") %></div>
                 </div>
                
             </div>
             <div class="table-responsive-sm">
                 <table class="table table-striped">
                     <thead>
                         <tr>
                             <th class="center">#</th>
                             <th>Item</th>
                             <th>Description</th>
                             <th class="right">Price</th>
                             <th class="center">Qty</th>
                             <th class="right">Total</th>
                         </tr>
                     </thead>
                     <tbody>
                         <tr>
                             <td class="center"></td>
                             <td class="left strong"></td>
                             <td class="left"></td>
                             <td class="right">$</td>
                             <td class="center"></td>
                             <td class="right">$</td>
                         </tr>
                    
                     </tbody>
                 </table>
             </div>
             <div class="row">
                 <div class="col-lg-4 col-sm-5">
                 </div>
                 <div class="col-lg-4 col-sm-5 ml-auto">
                     <table class="table table-clear">
                         <tbody>
                             <tr>
                                 <td class="left">
                                     <strong class="text-dark">Subtotal</strong>
                                 </td>
                                 <td class="right">$</td>
                             </tr>
                             <tr>
                                 <td class="left">
                                     <strong class="text-dark">Taxes(5.00)</strong>
                                     
                                 </td>
                                 <td class="right">$</td>
                             </tr>
                             <tr>
                                 <td class="left">
                                     <strong class="text-dark">S & H (25.00)</strong>
                                 </td>
                                 <td class="right">$</td>
                             </tr>
                             <tr>
                                 <td class="left">
                                     <strong class="text-dark">Grand Total:</strong> </td>
                                 <td class="right">
                                     <strong class="text-dark">$</strong>
                                 </td>
                             </tr>
                         </tbody>
                     </table>
                 </div>
             </div>
         </div>
        
     </div>
 </div>
</body>
</html>