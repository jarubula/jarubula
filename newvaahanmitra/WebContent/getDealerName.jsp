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
String city=request.getParameter("city");
GetUsedVehicleDealerServices usedCar=new GetUsedVehicleDealerServices();
ArrayList<BusinessOwnerRegister> dealerName=usedCar.getDealerName(city);
Iterator it= dealerName.iterator();
%>
<select name="dealerName" id="dealerName">
<option value="SELECT" style="display:none;">Select Dealer Name</option>
<option value="All">All</option>
<%
while(it.hasNext()){
	BusinessOwnerRegister carM=(BusinessOwnerRegister)it.next();
	%>
	<option value="<%=carM.getNAME()%>"><%=carM.getNAME()%></option>
<% 
}
%>
</select>
</body>
</html>