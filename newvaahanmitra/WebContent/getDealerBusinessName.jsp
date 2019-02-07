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
ArrayList<String> dealerName=usedCar.getDealerBusinessName(city);
%>
<select name="dealerName" id="dealerName">
<option style="display:none;" value="SELECT">Select Dealer Name</option>
<%
for(int i=0;i<dealerName.size();i++){
	%>
	<option value="<%=dealerName.get(i)%>"><%=dealerName.get(i)%></option>
<% 
}
%>
</select>
</body>
</html>