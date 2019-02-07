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
String brand=request.getParameter("brand");
String user_name = (String) session.getAttribute("user");
GetSparePartsDetails sp = new GetSparePartsDetails();
ArrayList<SpareParts> carModel = sp.getSpModel(brand, user_name);
Iterator it= carModel.iterator();
%>
<select name="vehicleModel" class="form-control" id="vehicleModel" onchange="getSPCategory(this.value)">
<option value="SELECT" style="display:none;">SELECT MODEL</option>
<option  value="All">All</option>
<%
while(it.hasNext()){
	SpareParts carM=(SpareParts)it.next();
	%>
	<option value="<%=carM.getVEHICLE_MODEL()%>"><%=carM.getVEHICLE_MODEL()%></option>
<% 
}
%>
</select>
</body>
</html>