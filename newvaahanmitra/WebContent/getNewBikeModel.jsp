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
String brand=request.getParameter("brand");
GetNewBikeDetails newBike=new GetNewBikeDetails();
ArrayList<AddBike> bikeModel = newBike.getNewBikeModel(brand);
Iterator it= bikeModel.iterator();
%>
<select name="bikeModel" id="bikeModel" class="form-control form-control-sm" onchange="getVariantName(this.value)" required> 
<option value="" style="display: none;">SELECT MODEL</option>
<%
while(it.hasNext()){
	AddBike bikeM=(AddBike)it.next();
%>
	<option value="<%=bikeM.getBIKE_MODEL()%>"><%=bikeM.getBIKE_MODEL()%></option>
<% 
}
%>
</select>
</body>
</html>