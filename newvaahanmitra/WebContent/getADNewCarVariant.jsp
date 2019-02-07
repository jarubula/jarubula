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
String model= request.getParameter("vmodel");
String Both[]=model.split("~");
String model1=Both[0];
String brand=Both[1];
GetNewCarDetails requester = new GetNewCarDetails();
ArrayList<AddCar> car = requester.getNewCarVariantNameForUpdate(model1, brand);
Iterator it = car.iterator();
%>
<select name="vehicleVariant" id="vehicleVariant"  class="form-control underlined"  required>
<option value="" style="display:none;">Vehicle Variant</option>
<%
																while (it.hasNext()) {
																	for (int i = 0; i < car.size(); i++) {
																		AddCar ab = (AddCar) it.next();
															%>
														<option value="<%=ab.getNEW_CAR_ID()%>"><%=ab.getVARIANT_NAME()%>-<%=ab.getCAR_MAKE_YEAR()%></option>
														<%
																}
																}
															%>
</select>
</body>
</html>