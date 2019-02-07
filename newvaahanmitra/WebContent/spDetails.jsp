<%@page
	import="com.vaahanmitra.model.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.dao.*,com.vaahanmitra.service.*,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<html>
<head>
<body style="background-color: beige;">
	<title>SPARE PARTS DASHBOARD</title>
	<%
		String sku = request.getParameter("skuId");
		GetSparePartsDetails spd = new GetSparePartsDetails();
		SpareParts sp = spd.getSparePartDetails(sku);
	%>
	<div class="container">
		<center>
			<h2 style="color: #663399">SPARE PART DETAILS</h2>
		</center>
		<table class="table table-striped" border="1">
			<tr>
				<th style="color: #C71585">PHOTO</th>
				<td><img class="colc2"
					src="data:image/png;base64,<%=sp.getIMAGE()%>" width="100px"
					height="80px" alt="No image" class="img-responsive"></td>
			</tr>
			<tr>
				<th style="color: #C71585">SKU</th>
				<td><%=sp.getSKU()%></td>
			</tr>
			<tr>
				<th style="color: #C71585">PART NAME</th>
				<td><%=sp.getSP_NAME()%></td>
			</tr>
			<tr>
				<th style="color: #C71585">CAR BRAND</th>
				<td><%=sp.getVEHICLE_BRAND()%></td>
			</tr>
			<tr>
				<th style="color: #C71585">CAR MODEL</th>
				<td><%=sp.getVEHICLE_MODEL()%></td>
			</tr>
			<tr>
				<th style="color: #C71585">PART NO</th>
				<td><%=sp.getPARTNO()%></td>
			</tr>
			<tr>
				<th style="color: #C71585">COMPANY NAME</th>
				<td><%=sp.getMANUFACTURE_COMPANY_NAME()%></td>
			</tr>
			<tr>
				<th style="color: #C71585">CATEGORY</th>
				<td><%=sp.getCATEGORY()%></td>
			</tr>
			<tr>
				<th style="color: #C71585">SUB CATEGORY</th>
				<td><%=sp.getSUB_CATEGORY()%></td>
			</tr>
			<tr>
				<th style="color: #C71585">SPECIFICATIONS</th>
				<td><%=sp.getSPECIFICATIONS()%></td>
			</tr>
			<tr>
				<th style="color: #C71585">DESCRIPTION</th>
				<td><%=sp.getDESCRIPTION()%></td>
			</tr>
			<tr>
				<th style="color: #C71585">WARRANTY</th>
				<td><%=sp.getWARRANTY()%></td>
			</tr>
			<tr>
				<th style="color: #C71585">PRICE</th>
				<td><%=sp.getPRICE()%></td>
			</tr>
			<tr>
				<th style="color: #C71585">DELIVERY METHOD</th>
				<td><%=sp.getDELEVERY_METHOD()%></td>
			</tr>
		</tbody>
		</table>
	</div>
</body>
</html>