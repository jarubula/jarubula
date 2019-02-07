<%@page import="com.vaahanmitra.model.Registration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,com.vaahanmitra.service.*,java.util.*"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<%
												String model = request.getParameter("vmodel");
String  both[]=model.split("~");
String model1=both[0];
String brand=both[1];
  
GetNewBikeDetails requester = new GetNewBikeDetails();
ArrayList<AddBike> bike = requester.getBikeId(model1, brand);
Iterator it = bike.iterator();
											%>

<select name="bikeNo" class="form-control" required >
													<option value="" style="display: none;">Select Variant</option>
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