<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.daoImpl.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VaanMitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
</head>
<body>
<%
GetBikeBrands bikeBrand=new GetBikeBrands();
ArrayList<UsedBike> carBnd=bikeBrand.getUsedBikeBrand();
%>
<select name="brandid" id="brandid" class="form-control"  onchange="showModel(this.value)">
<option style="display:none;" value="">SELECT BIKE BRAND</option>
<%
Iterator it= carBnd.iterator();
while(it.hasNext()){
	UsedBike usedBike = (UsedBike)it.next();
%>
<option value="<%=usedBike.getBIKE_BRAND()%>"><%=usedBike.getBIKE_BRAND()%></option>
<%
}
%>
</select>
</body>
</html>