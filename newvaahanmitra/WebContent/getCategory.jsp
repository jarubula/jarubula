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
GetSparePartsDetails spdetails = new GetSparePartsDetails();
ArrayList<SpareParts> spbrand = spdetails.getCategory();
Iterator it=spbrand.iterator();
%>
<select name="category" id="category" onchange="getSpSubCategory(this.value)" required>
<option style="display: none;" value="SELECT">Category</option>
<option value="All">All</option>
<%
while(it.hasNext()){
	SpareParts bean=(SpareParts)it.next();
	%>
	<option value="<%=bean.getCATEGORY()%>"><%=bean.getCATEGORY()%></option>
<% 	
}
%>
</select>
</body>
</html>