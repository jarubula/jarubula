<%@ page language="java" import="com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VaahanMitra</title>
</head>
<body>
<%
String spCategory = request.getParameter("spCategory");
GetSparePartsDetails spdetails = new GetSparePartsDetails();
ArrayList<SpareParts> category = spdetails.getSubCategory(spCategory);
Iterator it = category.iterator();
%>
<select name="subCategory" id="subCategory" class="form-control" onchange="showsubCategory(this.value)">
<option style="display: none;" value="SELECT">Sub Category</option>
<option value="All">All</option>
<%
while(it.hasNext()){
	SpareParts sp = (SpareParts)it.next();
%>
	<option value="<%=sp.getSUB_CATEGORY()%>"><%=sp.getSUB_CATEGORY()%></option>
<% 
}
%>
</select>
</body>
</html>