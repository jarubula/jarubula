<%@ page language="java"
import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*"
 contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.text.DecimalFormat" %>
<!DOCTYPE html">
<html>

<body>
<%
String value=request.getParameter("ID");
String Arr[]= value.split("-");
String city= Arr[0];
String Brand = Arr[1];
String id=Arr[2];
String v_type=Arr[4];
//alert(Name1);

String exshowroom="";

	exshowroom=new GetNewBikeDetails().getExshowroompricebyplaceandId(id, city);


%>
<a><%try{                
	 double value_x=0;String output=""; 
	 if(exshowroom!=""){ value_x= Integer.parseInt(exshowroom);
	 
	 output=new CurrencyFormate().indianrupee(value_x);
	 }
	 else{
		 output="NA";
	 }%>
<%=exshowroom==null ||exshowroom.equals("")?"NA":output%><%}catch(NumberFormatException n){}%>
</a>


</body>
</html>