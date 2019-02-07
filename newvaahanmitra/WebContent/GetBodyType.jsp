<%@page import="com.vaahanmitra.model.AddCar"%>
<%@page import="com.vaahanmitra.service.GetNewCarDetails"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String bodytype=request.getParameter("bodytype");
Set<String> list=new GetNewCarDetails().getbodytype();
Iterator it=list.iterator();

%><select name="bodyType" id="bodyType" class="form-control form-control-sm" onchange="this.form.submit()"   required>
<option style="display: none;" value="<%=((bodytype==null || bodytype.equals("null") || bodytype.equals("SELECT")?"SELECT":bodytype)) %>" selected><%=((bodytype==null || bodytype.equals("null") || bodytype.equals("SELECT")?"Body Type":bodytype)) %></option>
<%
while(it.hasNext()){
	String bean=(String)it.next();
	%>
	<option value="<%=bean%>"><%=bean%></option>
<% 
}
%>
</select>

</body>
</html>