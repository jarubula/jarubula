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
GetNewBikeDetails usedBike=new GetNewBikeDetails();
Set<AddBike> bikeModel=usedBike.getNewBikeVariantName(brand,model);
Iterator it= bikeModel.iterator();
%>
<select name="vvariant" id="vvariant" class="form-control form-control-sm" required>
<option value="">SELECT VARIANT</option>
<%
while(it.hasNext()){
	AddBike bikeM=(AddBike)it.next();
%>
	<option value="<%=bikeM.getVARIANT_NAME()%>"><%=bikeM.getVARIANT_NAME()%></option>
<% 
}
%>
</select>
</body>
</html>