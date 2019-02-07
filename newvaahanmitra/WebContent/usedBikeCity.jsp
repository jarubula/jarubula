<%@ page language="java" import="com.vaahanmitra.service.*,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
</head>
<body>
<%
String email = (String) session.getAttribute("user");
String bikeModel=request.getParameter("bikeModel");
System.out.println(bikeModel);
String brand=request.getParameter("brandid");
System.out.println(brand);
%>
<select name="city" id="city" class="form-control">
<option value="">SELECT CITY</option>
<%
GetBikeBrands gud=new GetBikeBrands();
ArrayList<String> al=gud.getUsedBikeBrand(brand, bikeModel, email);
for(int i=0;i<al.size();i++)
{
%>
<option><%=al.get(i)%></option>
<%} %>
</select>
</body>
</html>