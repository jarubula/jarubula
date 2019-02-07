
<%@page import="com.vaahanmitra.service.GetNewBikeDetails"%>
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
String color=request.getParameter("color");
Set<String> list=new GetNewBikeDetails().getcolor();
Iterator it=list.iterator();

%><select name="color" id="color" class="form-control form-control-sm" onchange="this.form.submit()"   required>
<option style="display: none;" value="<%=((color==null || color.equals("null") || color.equals("SELECT")?"SELECT":color)) %>" selected><%=((color==null || color.equals("null") || color.equals("SELECT")?"Color Type":color)) %></option>
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