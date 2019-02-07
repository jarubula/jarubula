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
	String bikeId = request.getParameter("BIKE_ID");
	GetBikeBrands usedBike = new GetBikeBrands();
	UsedBike bike = usedBike.getUsedBikeDetails(bikeId);
%>
<div class="container">
	<center><h2 style="color:#663399">BIKE DETAILS</h2></center>
	<table class="table table-striped">
		<thead>
			<tr style="color:#C71585">
				<th>PHOTO</th>
				<th>BIKE ID</th>
				<th>BIKE NUMBER</th>
				<th>BRAND</th>
				<th>MODEL</th>
				<th>CURRENT MILEAGE</th>
				<th>STARTING SYSTEM</th>
				<th>FUELTANK CAPACITY</th>
				<th>COLOR</th>
				<th>KMSDRIVEN</th>
				<th>REGISTERED YEAR</th>
				<th>REGISTERED STATE</th>
				<th>REGISTERED CITY</th>
				<th>OFFER PRICE</th>
			</tr>
		</thead>
		<tbody>
<%-- 			<% --%>
<!--  				for (int i = 0; i < al.size(); i++) { -->
<!--  					UsedBike bike = al.get(i); -->
<%-- 			%> --%>
		<tbody>
			<tr>
				<td>
					<img class="colc2" src="data:image/png;base64,<%=bike.getPHOTO1()%>" onmouseover="bigImg(this)" onmouseout="normalImg(this)" border="0"
					 width="100px" height="80px" alt="No image" class="img-responsive" style="cursor: pointer;">
				</td>
				<td><%=bike.getGEN_BIKE_ID()%></td>
				<td><%=bike.getBIKE_NUMBER()%></td>
				<td><%=bike.getBIKE_BRAND()%></td>
				<td><%=bike.getBIKE_MODEL()%></td>
				<td><%=bike.getCURRENT_MILEAGE()%></td>
				<td><%=bike.getSTARTING_SYSTEM()%></td>
				<td><%=bike.getFUELTANK_CAPACITY()%></td>
				<td><%=bike.getCOLOR()%></td>
				<td><%=bike.getKMS_DRIVEN()%></td>
				<td><%=bike.getREGISTERED_YEAR()%></td>
				<td><%=bike.getREGISTERED_STATE()%></td>
				<td><%=bike.getREGISTERED_CITY()%></td>
				<td><%=bike.getOFFER_PRICE()%></td>
			</tr>
<%-- 			<% --%>
<!--  				} -->
<%-- 			%> --%>

		</tbody>
	</table>
</div></body>
</html>