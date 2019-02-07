<%@ page language="java" import="com.vaahanmitra.service.*,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
</head>
<body>
<%
String usertype=request.getParameter("usertype");
ArrayList<String> al=new ArrayList<String>();
al=new BusinessOwnerService().getBusinessOwnerLocations(usertype);
%>
<select class="form-control underlined" name="bcity" id="bcity" onchange="getBusinessName(this.value)">
<option>City</option>
<option>All</option>
<%
for(int i=0;i<al.size();i++)
{
%>
<option><%=al.get(i)%></option>
<%}%>
</select>
<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>
</html>