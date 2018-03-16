<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>welcome</title>
</head>

<body>
<form action="welcome" method="GET">
<p class="alert alert-success">Successfully logged in</p>
<c:forEach var="movie" items="${mList}" >
<p>${movie.productTitle}</p>

</c:forEach>
<input type="submit" class="btn btn-primary" value="go to home"/>
</form>
</body>

</html>