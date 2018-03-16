<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>

 <script>
var carts=${carts};
</script>

<title>welcome</title>
</head>

<body>


<ul class="nav justify-content-end">
  <li class="nav-item">
    <a class="nav-link active" href="movies">Movies</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="books">Books</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="shows">TV Shows</a>
  </li>
  <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         <%= session.getAttribute("username") %>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="payment">My List</a>
          <a class="dropdown-item" href="#">Orders</a>
          <a class="dropdown-item" href="logout">Logout</a>
        </div>
      </li>
</ul>
 <c:if test='${total != 0}'>
<form action="payment" id="paymentForm" method="POST">
<div id="payment" class="container">
 <div class="col-sm-12 d-flex flex-sm-row bg-cart-header  justify-content-center">
 <div class="p-2 col-sm-2"><i class="fa fa-shopping-cart fa-lg" style="color:#004080"></i> item</div>
 <div class="p-2 col-sm-2">Name</div>
  <div class="p-2 col-sm-2">quantity</div>
  <div class="p-2 col-sm-2">Price</div>
  <div class="p-2 col-sm-2">Remove</div>
 
 </div>

 <cart-summary v-for="(cart,index) in carts" v-bind:cart="cart" ></cart-summary>
 <div class='row cart-total col-xs-4 pull-right'><h5 class='text-primary'>Total Amount :$${total}</h5></div>
 <div class='payment-details'>
 <h4>Billing Info</h4>
 	<div class='row col-xs-12 col-lg-12'>
 		<div class='form-group col-xs-6 col-lg-6'>
			<!-- v-model='user.firstname' -->
			<label for='firstname' class='control-label'>FirstName:</label>
 			<input type='text' class='form-control' name="firstname" value='${user.firstname}'/>
 		</div>
 		<div class='form-group col-xs-6 col-lg-6'>
			<!-- v-model='user.firstname' -->
			<label for='lastname' class='control-label'>LastName:</label>
 			<input type='text' class='form-control' name="lastname" value='${user.lastname}'/>
 		</div>
 	</div>
 	 <div class='row  col-xs-12 col-lg-12'>
 		<div class='form-group col-xs-6 col-lg-6'>
			<!-- v-model='user.firstname' -->
			<label for='firstname' class='control-label'>Email:</label>
 			<input type='text' class='form-control' name="email" value='${user.email}'/>
 		</div>
 		<div class='form-group col-xs-6 col-lg-6'>
			<!-- v-model='user.firstname' -->
			<label for='cardtype' class='control-label'>Card Type:</label>
 			<select class='form-control'  name='cardtype' >
					<option value=''>select one</option>
					<option value='VI'>VISA</option>
					<option value='MC'>MASTERCARD</option>
					<option value='AX'>AMEX</option>
			</select>
 		</div>
 	</div>
 		 <div class='row  col-xs-12 col-lg-12'>
 		<div class='form-group col-xs-6 col-lg-6'>
			<!-- v-model='user.firstname' -->
			<label for='cardnumber' class='control-label'>Card Number:</label>
 			<input type='text' class='form-control' name="cardnumber" />
 		</div>
 		<div class='form-group col-xs-2 col-lg-2'>
			<!-- v-model='user.firstname' -->
			<label for='cvv' class='control-label'>Cvv:</label>
 			<input type='text' class='form-control' name="cvv" />
 		</div>
 		<div class='form-group col-xs-2 col-lg-2'>
			<!-- v-model='user.firstname' -->
			<label for='expiryYear' class='control-label'>Expiration Year:</label>
 			<select class='form-control'  name='expiryYear' >
					<option value=''>select one</option>
					<option value='2019'>2019</option>
					<option value='2020'>2020</option>
					<option value='2021'>2021</option>
			</select>
 		</div>
 		<div class='form-group col-xs-2 col-lg-2'>
			<!-- v-model='user.firstname' -->
			<label for='expiryMonth' class='control-label'>Expiration Month:</label>
 			<select class='form-control'  name='expiryMonth' >
					<option value=''>select one</option>
					<option value='08'>August</option>
					<option value='09'>September</option>
					<option value='10'>October</option>
			</select>
 		</div>
 	</div>
 	<div class='row  col-xs-12 col-lg-12'>
 		<div class='form-group col-xs-4 col-lg-4'>
			<!-- v-model='user.firstname' -->
			<label for='streetaddress1' class='control-label'>Street Address:</label>
 			<input type='text' class='form-control' name="streetaddress1" value='${user.streetaddress1}'/>
 		</div>
 		<div class='form-group col-xs-4 col-lg-4'>
			<!-- v-model='user.firstname' -->
			<label for='streetaddress2' class='control-label'>Street Address:(Apt/Suite)</label>
 			<input type='text' class='form-control' name="streetaddress1" value='${user.streetaddress2}'/>
 		</div>
 		<div class='form-group col-xs-4 col-lg-4'>
			<!-- v-model='user.firstname' -->
			<label for='city' class='control-label'>City:</label>
 			<input type='text' class='form-control' name="city" value='${user.city}'/>
 		</div>
 	</div>
 	<div class='row  col-xs-12 col-lg-12'>
 		<div class='form-group col-xs-4 col-lg-4'>
			<!-- v-model='user.firstname' -->
			<label for='streetaddress1' class='control-label'>State:</label>
 			<select class='form-control'  name='state' value='${user.state}'>
					<option value=''>select one</option>
					<option value='NY'>New York</option>
					<option value='NJ'>New Jersey</option>
					<option value='CA'>California</option>
					<option value='CT'>Connecticut</option>
					</select>
 		</div>
 		<div class='form-group col-xs-4 col-lg-4'>
			<!-- v-model='user.firstname' -->
			<label for='country' class='control-label'>Country:</label>
					<select  class='form-control' name='country' value='${user.country}'>
					<option value=''>select one</option>
					<option value='USA'>United States</option>
					</select>
 		</div>
 		<div class='form-group col-xs-4 col-lg-4'>
			<!-- v-model='user.firstname' -->
			<label for='zipcode' class='control-label'>Zipcode:</label>
 			<input type='text' class='form-control' name="zipcode" value='${user.zipcode}'/>
 		</div>
 	</div>
 	<div class='row col-xs-3 col-lg-3 pull-right'>
 	<input type='hidden' name='action' value='purchase' />
 	<button type='submit' class='btn btn-block btn-primary float-right'>Purchase</button>
 	</div>
 </div>


</div>
</form>
</c:if>
<script  src="https://unpkg.com/vue@2.1.3/dist/vue.js"></script>
<script  src="./js/common.js"></script>

</body>

<link rel="stylesheet" type="text/css" href="css/styles.css">

</html>