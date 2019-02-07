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
Map<String,Set<String>> vehicle = ud.getVehicleBrands(vType);
Set<String> vBrand = vehicle.get("vBrand");
Set<String> vCity = vehicle.get("vCity");
%>
<div class="form-group">
<select name="vehicleBrand" id="vehicleBrand"  onchange="getUsedVcleModel(this.value)">
<option value="SELECT" style="display:none;">Vehicle Brand</option>
<option value="All">All</option>
<!-- <option>Model</option> -->
<%for(String brand:vBrand){ %>
<option><%=brand%></option>
<%} %>

</select>
</div>

<div class="form-group">
<select name="city" id="city" >
<option value="SELECT" style="display:none;">City</option>
<option value="All">Allharishshshhssh</option>
<!-- <option>Model</option> -->
<%for(String city:vCity){ %>
<option><%=city%></option>
<%} %>
</select>
</div>

</body>
</html>