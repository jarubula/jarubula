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
String vType = request.getParameter("vType");
GetCarBrands ud = new GetCarBrands();
Set<String> vehicle = ud.getNewVehicleBrands(vType);
Iterator it=vehicle.iterator();
%>
<div class="form-group">
<select name="vehicleBrand" id="vehicleBrand"  class="form-control underlined"  onchange="getVehicleModels(this.value)" required="required">
<option value="" style="display:none;">Vehicle Brand</option>
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