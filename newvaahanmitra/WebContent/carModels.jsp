<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4> CAR MODELS </h4><br>
	<%
		String carBrand = request.getParameter("carBrand");
		GetCarBrands car = new GetCarBrands();	
		ArrayList<AddCar> caral = car.getAddCarBrands(carBrand);
		Iterator it = caral.iterator();
		while (it.hasNext()) {
			AddCar uc = (AddCar) it.next();
	%>
	
	<input type="checkbox" name="models" id="models" value="<%=uc.getCAR_MODEL()%>">	
	<%=uc.getCAR_MODEL()%><br>
	<%
		}
	%>
	</body>
</html>