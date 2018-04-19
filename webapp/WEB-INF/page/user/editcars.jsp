<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Cars</title>
</head>
<body>
	<h2>Cars List</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Brand</th>
			<th>Model</th>
		</tr>
		<c:forEach items="${cars}" var="car">
			<tr>
				<td>${car.id}</td>
				<td>${car.brand}</td>
				<td>${car.model}</td>
				<td><a href="MainServlet?delete=${car.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<h2>Add a car</h2>
	<form action="./MainServlet?action=create" method=POST>
		<label for="brand">Brand</label><br> <input name="brand"></input><br>
		<label for="model">Model</label><br> <input name="model"></input><br>
		<button>Add</button>
	</form>
	<h2>Update a car</h2>
	<form action="./MainServlet?action=update" method=POST>
		<label for="id">ID</label><br> <input name="id"></input><br>
		<label for="brand">Brand</label><br> <input name="brand"></input><br>
		<label for="model">Model</label><br> <input name="model"></input><br>
		<button>Update</button>
	</form>
</body>
</html>