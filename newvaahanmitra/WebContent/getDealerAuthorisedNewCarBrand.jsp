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
GetNewCarDetails carBrand=new GetNewCarDetails();
ArrayList<AddCar> carBnd=carBrand.getDealerAuthorisedNewCarBrand(userId);
%>
<select name="brandid" id="brandid" class="form-control form-control-sm"  onchange="showModel(this.value)" required>
<option value="" style="display: none;">SELECT CAR BRAND</option>
<%
Iterator it= carBnd.iterator();
while(it.hasNext()){
	AddCar newCar=(AddCar)it.next();
%>
<option value="<%=newCar.getCAR_BRAND()%>"><%=newCar.getCAR_BRAND()%></option>
<%
}
%>
</select>
</body>
</html>