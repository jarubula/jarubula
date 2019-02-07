<%@ page language="java" import="com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.dao.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vaahanmitra</title>
</head>
<body>

<%
String userId=null;
String country=request.getParameter("state");
 DriverDAO sdao=new DriverDAOImpl();
 ArrayList<DriverBean> al=sdao.displayDriver(userId, country);
 Iterator it=al.iterator();
 %>
<div class="section_room">
 <select name="dist" id="dist"  class="form-control">
 <option value="SELECT" style="display:none;">SELECT DISTRICT</option>
 <option value="All">All</option>
  <% 
 while(it.hasNext()){
	 DriverBean ad=(DriverBean)it.next();
	 %>
	 <option value="<%=ad.getDISTRICT() %>"><%=ad.getDISTRICT() %></option>
	 	 <%
 }
 %>
 </select>
</div>
</body>
</html>