<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>

<title>User Data</title>
</head>
<style>
div.ex {
	text-align: right width:300px;
	padding: 10px;
	border: 5px solid grey;
	margin: 0px
}
</style>
<body>
<div class="container">
	<div class="row">
		<h2 class="text-center">Sign up</h2>
	</div>
	
		<form action="Registration" method="POST" >
			<div class="col-sm-6">
				<div class="row form-group">
					<label for="firstname">First Name</label>
					<input type="text" class="form-control" name="firstname"  value="${firstname}"/>
				</div>
				<div class="row form-group">
					<label for="lastname">Last Name</label>
					<input type="text" class="form-control" name="lastname" value="${lastname}"/>
				</div>
				<div class="row form-group">
					<label for="email">Email</label>
					<input type="text" class="form-control" name="email" value="${email}" />
				</div>
				<div  class="row form-group">
					<label for="password">Password</label>
					<input type="password" class="form-control" name="password" value="${password}" />
				</div>
				<div  class="row form-group">
					<label>Street Address</label>
					<input type="text"  class="form-control" name="streetaddress1" value="${streetaddress1}"/>
				</div>
				<div  class="row form-group">
					<label for="streetaddress2">Street Address(Apt/Suite)</label>
					<input type="text" class="form-control" name="streetaddress2" value="${streetaddress2}" />
				</div>
				<div  class="row form-group">
					<label for="city">City</label>
					<input type="text" class="form-control" name="city" value="${city}" />
				</div>
				<div  class="row form-group">
					<label for="state">State</label>
					<select class="form-control"  name="state" >
					<option value="">select one</option>
					<option value="NY">New York</option>
					<option value="NJ">New Jersey</option>
					<option value="CA">California</option>
					<option value="CT">Connecticut</option>
					</select>
				</div>
				<div  class="row form-group">
					<label for="country">Country</label>
					<select  class="form-control" name="country">
					<option value="">select one</option>
					<option value="USA">United States</option>
					</select>
				</div>
				<div  class="row form-group">
					<label for="zipcode">Zip Code</label>
					<input type="text" class="form-control" name="zipcode" value="${zipcode}" />
				</div>
				<div class="row float-right">
			<input type="submit" class="btn btn-primary " value="register" />
			</div>
			</div>
			
		</form>
	</div>
</body>
</html>