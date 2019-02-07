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
String carModel=request.getParameter("carModel");
GetUsedCarDetails carBudget=new GetUsedCarDetails();
ArrayList<UsedCar> carbgt=carBudget.getUsedCarBudget(carModel);
Iterator it= carbgt.iterator();
%>
<select name="carBudget" id="carBudget">
<option value="SELECT">SELECT BUDGET</option>
<%
while(it.hasNext()){
	UsedCar budget=(UsedCar) it.next();
	%>
	<option value="<%=budget.getOFFER_PRICE()%>"><%=budget.getOFFER_PRICE()%></option>
<% 	
}
%>
</select>

</body>
</html>