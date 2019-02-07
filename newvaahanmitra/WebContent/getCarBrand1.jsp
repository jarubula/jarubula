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
GetCarBrands carBrand=new GetCarBrands();
ArrayList<AddCar> carBnd = carBrand.getCarDetails();
%>
<select name="brandid"  onchange="displayCarModels(this.value)">
<option style="display:none;" value="SELECT">SELECT CAR BRAND</option>
<%
Iterator it= carBnd.iterator();
while(it.hasNext()){
	AddCar car=(AddCar)it.next();
%>
<option value="<%=car.getCAR_BRAND()%>"><%=car.getCAR_BRAND()%></option>
<%
}
%>
</select>
</body>
</html>