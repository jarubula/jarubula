<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VaanMitra</title>
</head>
<body>
<%
String userId=session.getAttribute("user").toString();
GetNewBikeDetails carBrand=new GetNewBikeDetails();
ArrayList<AddBike> carBnd=carBrand.getDealerAuthorisedNewBikeBrand(userId);
%>
<select name="bikeBrand" id="bikeBrand" class="form-control form-control-sm"  onchange="showModel(this.value)" required>
<option value="" style="display: none;">SELECT BIKE BRAND</option>
<%
Iterator it= carBnd.iterator();
while(it.hasNext()){
	AddBike newCar=(AddBike)it.next();
%>
<option value="<%=newCar.getBIKE_BRAND()%>"><%=newCar.getBIKE_BRAND()%></option>
<%
}
%>
</select>
</body>
</html>