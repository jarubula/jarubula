<%@page
	import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<html>
<head>
<body style="background-color:beige;">
<title>USED VEHICLE DELEAR DASHBOARD</title>
<%
	String carId = request.getParameter("CAR_ID");
	GetUsedCarDetails usedCar = new GetUsedCarDetails();
	UsedCar car = usedCar.getUsedCarDetails(carId);
%>
<div class="container">
	<center><h2 style="color:#663399">CAR DETAILS</h2></center>
	<table class="table table-striped">
		<thead>
			<tr style="color:#C71585">
				<th>PHOTO</th>
				<th>CAR ID</th>
				<th>CAR NUMBER</th>
				<th>BRAND</th>
				<th>MODEL</th>
				<th>COLOR</th>
				<th>CURRENT MILEAGE</th>
				<th>FUELTYPE</th>
				<th>TRANSIMISSION</th>
				<th>KMSDRIVEN</th>
				<th>REGISTERED YEAR</th>
				<th>REGISTERED STATE</th>
				<th>REGISTERED CITY</th>
				<th>OFFER PRICE</th>
			</tr>
		</thead>
		<tbody>
<%-- 			<% --%>
<!-- 				for (int i = 0; i < al.size(); i++) { -->
<!-- 					UsedCar car = al.get(i); -->
<!-- 			%> -->
		
		<tbody>
			<tr>
				<td>
					<img class="colc2" src="data:image/png;base64,<%=car.getPHOTO1()%>" onmouseover="bigImg(this)" onmouseout="normalImg(this)" border="0"
					 width="100px" height="80px" alt="No image" class="img-responsive" style="cursor: pointer;">
				</td>
				<td><%=car.getGEN_CAR_ID()%></td>
				<td><%=car.getCAR_NUMBER()%></td>
				<td><%=car.getCAR_BRAND()%></td>
				<td><%=car.getCAR_MODEL()%></td>
				<td><%=car.getCOLOR()%></td>
				<td><%=car.getCURRENT_MILEAGE()%></td>
				<td><%=car.getFUEL_TYPE()%></td>
				<td><%=car.getTRANSIMISSION()%></td>
				<td><%=car.getKMS_DRIVEN()%></td>
				<td><%=car.getREGISTERED_YEAR()%></td>
				<td><%=car.getREGISTERED_STATE()%></td>
				<td><%=car.getREGISTERED_CITY()%></td>
				<td><%=car.getOFFER_PRICE()%></td>
			</tr>
<%-- 			<% --%>
<!--  				} -->
<%-- 			%> --%>

		</tbody>
	</table>
</div></body>
</html>