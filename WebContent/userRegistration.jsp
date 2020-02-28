<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<%@ include file="header.jsp" %>
</head>
<body>
<form action = "UserController" method = "post">
	<div>
		<label>Username</label>
		<input type = "text" name = "uname">
	</div>
	<div>
		<label>Password</label>
		<input type = "password" name = "pass">
	</div>
	<div>
		<label>Email</label>
		<input type = "email" name = "email">
	</div>
	<div>
		<label>DOB</label>
		<input type = "date" name = "dob">
	</div>
	<div>
		<label>Gender</label>
		<input type = "radio" name = "gender" value = "Male">Male
		<input type = "radio" name = "gender" value = "Female">Female
	</div>
	<div>
		<label>Hobbies</label>
		<input type = "checkbox" name = "hobbies" value = "Reading">Reading
		<input type = "checkbox" name = "hobbies" value = "Playing">Playing
	</div>
	<div>
	<select name = "nationality">
		<option value = "Nepalese">Nepalese</option>
		<option value = "Indian">Indian</option>
		<option value = "Chinese">Chinese</option>
		<option value = "Americano">Americano</option>
	</select>
	</div>
	<div>
		<input type = "submit" value = "Submit">
	</div>
</form>
</body>
</html>