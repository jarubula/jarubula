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
GetNewCarDetails usedCar=new GetNewCarDetails();
Set<AddCar> carModel=usedCar.getNewCarYearByVariantName(brand, model, variant);
Iterator it= carModel.iterator();
%>
<select name="makeYear" id="makeYear" class="form-control form-control-sm" onchange="getresulttable(this.value)"  required>
<option value="" style="display: none;">SELECT VARIANT</option>
<%
while(it.hasNext()){
	AddCar carM=(AddCar)it.next();
%>
	<option value="<%=carM.getCAR_MAKE_YEAR()%>"><%=carM.getCAR_MAKE_YEAR()%></option>
<% 
}
%>
</select>
</body>
</html>