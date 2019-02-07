<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.daoImpl.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
</head>
<body>
<%
String country="";
String userId=null;
DriverDAO sdao=new DriverDAOImpl();
 ArrayList<DriverBean> al=sdao.displayDriver(userId,country);
 Iterator it=al.iterator();
 %>
<div class="section_room">
 <select name="state" id="state"  class="form-control"  onchange="showState(this.value)" >
 <option value="SELECT" style="display:none;">SELECT STATE</option>
 <option value="All">All</option>
  <% 
 while(it.hasNext()){
	 DriverBean ad=(DriverBean)it.next();
	 %>
	 <option value="<%=ad.getSTATE() %>"><%=ad.getSTATE() %></option>
	 	 <%
 }
 %>
 </select>
</div>

</body>
</html>