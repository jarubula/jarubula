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
String model = request.getParameter("vmodel");
String one[]=model.split("~");
String model1=one[0];
String brand=one[1];
GetNewBikeDetails requester = new GetNewBikeDetails();
ArrayList<AddBike> bike = requester.getBikeId(model1, brand);
Iterator it = bike.iterator();
%>
<select name="vehicleVariant" id="vehicleVariant"  class="form-control underlined" required="required">
<option value="" style="display:none;">Vehicle Variant</option>
<%
																while (it.hasNext()) {
																	for (int i = 0; i < bike.size(); i++) {
																		AddBike ab = (AddBike) it.next();
															%>
														<option value="<%=ab.getNEW_BIKE_ID()%>"><%=ab.getVARIANT_NAME()%>-<%=ab.getBIKE_PRODUCTION_YEAR()%></option>
														<%
																}
																}
															%>
</select>
</body>
</html>