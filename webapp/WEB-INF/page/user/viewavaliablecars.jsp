<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>User main page</title>
	</head>
	<body>
		<h2>Определите срок аренды</h2>
		<form action="/carparking/FrontController?action=view_avaliable_car_list" method="POST">
		c:<input type="date" name="start_of_rental" value="${start_of_rental}"><br>
		по:<input type="date" name="end_of_rental" value="${end_of_rental}"><br>
		<button>Показать автомобили</button>
	</form>
	<c:if test="${avaliablecarlist.size()>0}">
		<h2>Доступные машины</h2>
		<form action="/carparking/FrontController?action=order_car" method="POST">
			<input type="hidden" name="user_id" value="1">
			<input type="hidden" name="start_of_rental" value="${start_of_rental}">
			<input type="hidden" name="end_of_rental" value="${end_of_rental}">
			<select name="car_id">
				<c:forEach items="${avaliablecarlist}" var="car">
  				<option value="${car.id}">${car.brand} ${car.model}</option>
  				</c:forEach>
			</select>
			<button>Арендовать</button>
		</form>
	</c:if>
	</body>
</html>