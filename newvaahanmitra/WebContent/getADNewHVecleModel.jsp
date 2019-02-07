<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VaahanMitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
</head>
<body>
<%
String vBrand=request.getParameter("vBrand");
String vType=request.getParameter("vType");
GetCarBrands ud = new GetCarBrands();
Set<String> vehicle = ud.getNewVehicleModels(vBrand,vType);
Iterator it=vehicle.iterator();
%>
<select name="vehicleModel" id="vehicleModel"  class="form-control underlined" onchange="getVehicleVariant(this.value)">
<option value="SELECT" style="display:none;">Vehicle Model</option>
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