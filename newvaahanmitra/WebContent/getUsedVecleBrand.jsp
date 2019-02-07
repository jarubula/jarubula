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
String vType = request.getParameter("vBrand");
GetUsedVehicleDetails ud = new GetUsedVehicleDetails();
Set<String> vehicle = ud.getUsedVehicleBrands(vType);
Iterator it=vehicle.iterator();
%>
<div class="form-group">
<select name="vehicleBrand" id="vehicleBrand"  onchange="getUsedVcleModel(this.value)">
<option value="SELECT" style="display:none;">VEHICLE BRAND</option>
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
</div>
</body>
</html>