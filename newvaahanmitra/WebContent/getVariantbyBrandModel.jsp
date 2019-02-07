<%@ page language="java" import="com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VaahanMitra</title>
</head>
<body>
<%
String brand = request.getParameter("vbrand");
String model = request.getParameter("vmodel");
String vType=request.getParameter("vType");
GetCarBrands ud = new GetCarBrands();
Set<String> vehicle = ud.getNewVehicleVariant(brand, model, vType);
Iterator it=vehicle.iterator();
%>

<select name="vvariant" id="vvariant" class="form-control form-control-sm">
<option value="SELECT" style="display: none;">SELECT VARIANT</option>
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