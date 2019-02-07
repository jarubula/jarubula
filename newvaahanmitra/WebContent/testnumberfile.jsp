<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.text.*" %>
    <%@page import="java.text.DecimalFormat" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int value=500000; %>
					<fmt:setLocale value="en_GB">
			  		 <fmt:formatNumber type="CURRENCY" value="<%=value%>"></fmt:formatNumber>
			  		 </fmt:setLocale>

</body>
</html>