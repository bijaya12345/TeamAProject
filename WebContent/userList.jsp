<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
<%@ include file="header.jsp" %>
</head>
<body>
	<div>
		<a href="UserController?action=add_user">Add New User</a>
	</div>
	<c:if test="${!empty users }">
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Username</th>
					<th>Password</th>
					<th>Email</th>
					<th>DOB</th>
					<th>Hobbies</th>
					<th>Nationality</th>
					<th>Phone</th>
					<th>Actions</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users }" var="user">
					<tr>
						<td>${user.id }</td>
						<td>${user.username }</td>
						<td>${user.password }</td>
						<td>${user.email }</td>
						<td>${user.dob }</td>
						<td>${user.hobbies }</td>
						<td>${user.nationality }</td>
						<td>${user.phone }</td>
						<td>
						<a href="UserController?action=edit_user&id=${user.id}">Edit</a>
						<a href="UserController?action=delete_user&id=${user.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>