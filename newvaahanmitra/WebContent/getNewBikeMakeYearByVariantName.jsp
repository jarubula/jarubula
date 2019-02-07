<%@ page language="java" import="com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VaahanMitra</title>
</head>
<body>
<%
String brand = request.getParameter("brand");
String model = request.getParameter("model");
String variant=request.getParameter("variant");
GetNewBikeDetails usedBike=new GetNewBikeDetails();
Set<AddBike> carModel=usedBike.getNewBikeYearByVariantName(brand, model, variant);
Iterator it= carModel.iterator();
%>
<select name="makeYear" id="makeYear" class="form-control form-control-sm" onchange="getresulttable(this.value)"  required>
<option value="" style="display: none;">SELECT DATE</option>
<%
while(it.hasNext()){
	AddBike bikeM=(AddBike)it.next();
%>
	<option value="<%=bikeM.getBIKE_PRODUCTION_YEAR()%>"><%=bikeM.getBIKE_PRODUCTION_YEAR()%></option>
<% 
}
%>
</select>
</body>
</html>