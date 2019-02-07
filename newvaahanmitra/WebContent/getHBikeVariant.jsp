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
String brand   = request.getParameter("brand");
String model   = request.getParameter("model");
GetUsedBikeDetails usedBike=new GetUsedBikeDetails();
ArrayList<UsedBike> bikeVariant=usedBike.getUsedBikeVariant(brand, model);
Iterator it= bikeVariant.iterator();
%>
<select name="bikeVariant" id="bikeVariant" >
<option value="SELECT" style="display:none;">SELECT Variant</option>
<option value="All">All</option>
<%
while(it.hasNext()){
	UsedBike bikeM=(UsedBike)it.next();
	%>
	<option value="<%=bikeM.getVARIANT_NAME()%>"><%=bikeM.getVARIANT_NAME()%></option>
<% 
}
%>
</select>
</body>
</html>