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
String brand=request.getParameter("brand");
GetUsedBikeDetails usedBike=new GetUsedBikeDetails();
ArrayList<UsedBike> bikeModel=usedBike.getUsedBikeModel(brand);
Iterator it= bikeModel.iterator();
%>
<select name="bikeModel" id="bikeModel" onchange="showVariant(this.value)">
<option value="SELECT" style="display:none;">SELECT MODEL</option>
<option value="All">All</option>
<%
while(it.hasNext()){
	UsedBike bikeM=(UsedBike)it.next();
	%>
	<option value="<%=bikeM.getBIKE_MODEL()%>"><%=bikeM.getBIKE_MODEL()%></option>
<% 
}
%>
</select>
</body>
</html>