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
String email=request.getParameter("email");
String sBrand=request.getParameter("sBrand");
GetMechanicDetails md=new GetMechanicDetails();
ArrayList<String> model=md.getServiceModel(sBrand, email);
%>
<label><b>Vehicle Modal</b></label>
<select name="model" id="model" class="w3-input w3-border w3-margin-bottom">
<option value="SELECT" style="display:none;">Vehicle Model</option>
<%
for(int i=0;i<model.size();i++){ 
%>
	<option value="<%=model.get(i)%>"><%=model.get(i)%></option>
<% 
}
%>
</select>
</body>
</html>
