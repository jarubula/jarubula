<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String spareparts = "[";
GetSparePartsDetails spd = new GetSparePartsDetails();
	ArrayList<SpareParts> spN = spd.getSparePartName();
	Iterator ipNM = spN.iterator();
		while (ipNM.hasNext()) {
			SpareParts sppn = (SpareParts) ipNM.next();
		spareparts+="\""+sppn.getSP_NAME()+"\",";
		}
		spareparts+="]";
	System.out.println(spareparts);
	%>
</body>
</html>