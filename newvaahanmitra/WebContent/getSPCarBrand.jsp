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
String email = (String) session.getAttribute("user");
String brandid = request.getParameter("brandid");
GetSparePartsDetails sps=new GetSparePartsDetails();
ArrayList<SpareParts> sp =sps.getUsedCarBrand(email);
%>
<select name="brandid" id="brandid" class="form-control" onchange="showModel(this.value)">
<option value=""><%=brandid==null?"SELECT CAR BRAND":brandid%></option>
<%
Iterator it= sp.iterator();
while(it.hasNext()){
	SpareParts spss = (SpareParts)it.next();
%>
<option value="<%=spss.getVEHICLE_BRAND()%>"><%=spss.getVEHICLE_BRAND()%></option>
<%
}
%>
</select>
</body>
</html>