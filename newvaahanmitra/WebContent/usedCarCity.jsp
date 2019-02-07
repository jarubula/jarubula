<%@ page language="java" import="com.vaahanmitra.service.*,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String carModel=request.getParameter("carModel");
String brand=request.getParameter("brandid");
String email = (String) session.getAttribute("user");
%>
<select name="city" id="city" class="form-control">
<option value="">SELECT CITY</option>
<%
GetUsedCarDetails gud=new GetUsedCarDetails();
ArrayList<String> al=gud.getUsedCarBrand(brand, carModel, email);
for(int i=0;i<al.size();i++)
{
%>
<option><%=al.get(i)%></option>
<%} %>
</select>
</body>
</html>