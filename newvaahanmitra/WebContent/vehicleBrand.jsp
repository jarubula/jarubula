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
String vBrand=request.getParameter("vBrand");
GetMechanicDetails mdetails=new GetMechanicDetails();
ArrayList<ServiceMechanic> vbrand=mdetails.getVehicleBrand(vBrand);
Iterator it=vbrand.iterator();
%>
<select name="vehicleBrand" id="vehicleBrand" class="w3-input w3-border w3-margin-bottom form-conntrol" required>
<option value="SELECT" style="display:none;">Vehicle Brand</option>
<option value="All">All</option>
<%
while(it.hasNext()){
	ServiceMechanic bean=(ServiceMechanic)it.next();
	%>
	<option value="<%=bean.getBRAND()%>"><%=bean.getBRAND()%></option>
<% 
}
%>
</select>
</body>
</html>