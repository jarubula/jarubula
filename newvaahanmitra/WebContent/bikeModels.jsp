<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
</head>
<body>
	<h4> BIKE MODELS </h4><br>
	<%
		String bikeBrand = request.getParameter("bikeBrand");
		GetNewBikeDetails car = new GetNewBikeDetails();	
		ArrayList<AddBike> bikeal = car.getAddBikeBrands(bikeBrand);
		Iterator it = bikeal.iterator();
		while (it.hasNext()) {
			AddBike ab = (AddBike) it.next();
	%>
	
	<input type="checkbox" name="models" id="models" value="<%=ab.getBIKE_MODEL()%>">
	<%=ab.getBIKE_MODEL()%><br>
	<%
		}
	%>
	</body>
</html>