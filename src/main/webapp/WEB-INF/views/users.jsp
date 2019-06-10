<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>

<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>

</head>
<body onload="load();">

	<div id="submitform">
		<input type="hidden" id="userId"> <label for="name">Name:</label>
		<input type="text" id="name" required="required" name="username"
			placeholder="Your name..."><br></br> <label for="email">Email:</label>
		<input type="email" id="email" required="required" name="emailId"
			placeholder="Your email address..."><br></br>
		<button id="submit" onclick="submit();">Submit</button>
		<br></br>
	</div>

	<div>
		<table id="users">
		<tr>
			<th>SI NO.</th>
			<th>Name</th>
			<th>Email</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	</table>
	</div>

</body>
</html>