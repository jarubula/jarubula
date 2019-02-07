<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VaahanMitra</title>
</head>
<body>
<%
String street=request.getParameter("street");


GetMechanicDetails md=new GetMechanicDetails();
Set<String> street1=md.getServiceStreet(street);
Iterator it=street1.iterator();
%>

<select class="form-control" name="street" id="street" required>
<option value="SELECT" style="display:none;">Location</option>
<option value="All">All</option>
<%
while(it.hasNext()){ 
String street2=(String)it.next();
%>
	<option value="<%=street2%>"><%=street2%></option>
<% 
}
%>
</select>
</body>
</html>