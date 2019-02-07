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
String vModel=request.getParameter("vModel");
String vType=request.getParameter("vType");
System.out.println(vModel);
GetUsedVehicleDetails ud = new GetUsedVehicleDetails();
Set<String> vehicle = ud.getVehicleModels(vModel,vType);
Iterator it=vehicle.iterator();
%>
<select name="vehicleModel" id="vehicleModel"  onchange="(this.value)" class="w3-input w3-border w3-margin-bottom form-conntrol">
<option value="SELECT" style="display:none;">VEHICLE MODEL</option>
<option value="All">All</option>
<%
while(it.hasNext()){
	String bean=(String)it.next();
	%>
	<option value="<%=bean%>"><%=bean%></option>
<% 
}
%>
</select>
</body>
</html>