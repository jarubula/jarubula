<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VaahanMitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
</head>
<body>
<%
String carId = request.getParameter("carId");
AdminService ud = new AdminService();
Map<String,String> vehicle = ud.getAdminNewVehicleBrands(carId);
%>
									   
 	                                         <div class="col-md-4" style="padding-left: 0;">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Brand : </label>
                                               <input type="text" name="" class="form-control boxed" value="<%=vehicle.get("brand") %>" placeholder="Enter Model" readonly>
                                               </div>
											   </div>
											   
											    <div class="col-md-4" style="padding-left: 0;">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Model : </label>
                                               <input type="text" name="" class="form-control boxed" value="<%=vehicle.get("model") %>" placeholder="Enter Model" readonly>
                                               </div>
											   </div>
											   
											   
											    <div class="col-md-4" style="padding-left: 0;">
											   <div class="form-group"> 	 
                                               <label for="firstname"><span class="req"></span>Variant: </label>
                                               <input type="text" name="" class="form-control boxed" value="<%=vehicle.get("variant") %>" placeholder="Enter Variant" readonly>
                                               </div>
											   </div>
											 
</body>
</html>