<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VaahanMitra</title>
</head>
<body>
<%
String carBrand=request.getParameter("brand");
String model=request.getParameter("model");
GetUsedCarDetails usedCar=new GetUsedCarDetails();
ArrayList<UsedCar> carVariant=usedCar.getUsedCarVariant(carBrand, model);
Iterator it= carVariant.iterator();
%>
<select name="carVariant" id="carVariant">
<option value="SELECT" style="display:none;">SELECT VARIANT</option>
<option value="All">All</option>
<%
while(it.hasNext()){
	UsedCar carM=(UsedCar)it.next();
	%>
	<option value="<%=carM.getVARIANT_NAME()%>"><%=carM.getVARIANT_NAME()%></option>
<% 
}
%>
</select>
</body>
</html>