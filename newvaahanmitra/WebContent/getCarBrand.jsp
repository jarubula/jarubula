<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VaanMitra</title>
</head>
<body>
<%
String email = (String) session.getAttribute("user");
String brandid = request.getParameter("brandid");
GetUsedCarDetails carBrand=new GetUsedCarDetails();
ArrayList<UsedCar> carBnd=carBrand.getUsedCarBrand(email);
%>
<select name="brandid" id="brandid" class="form-control" onchange="showModel(this.value)">
<option value=""><%=(brandid==null || brandid=="")?"SELECT CAR BRAND":brandid%></option>
<%
Iterator it= carBnd.iterator();
while(it.hasNext()){
	UsedCar usedCar=(UsedCar)it.next();
%>
<option value="<%=usedCar.getCAR_BRAND()%>"><%=usedCar.getCAR_BRAND()%></option>
<%
}
%>
</select>
</body>
</html>