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
String brand = request.getParameter("brand");
String model = request.getParameter("model");
GetNewBikeDetails bike=new GetNewBikeDetails();
Set<AddBike> bikeModel=bike.getNewBikeVariantName(brand, model);
Iterator it= bikeModel.iterator();
%>
<select name="variantName" id="variantName" class="form-control form-control-sm" onchange="getDateByBikeVarient(this.value)"  required>
<option value="" style="display: none;">SELECT VARIANT</option>
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