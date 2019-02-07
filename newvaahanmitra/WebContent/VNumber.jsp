<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function val()
{

num=document.getElementById("vehicleno").value;
 expr="^[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)? [0-9]{4}$"; 
 r=new RegExp(expr);
b=r.test(num);
if(b)
alert("Cab Number is Valid");
else
alert("Cab Number is In-Valid");
}
</script>
</head>
<body>
<form onsubmit="return val()">
<input type="text" name="vehicleno" id="vehicleno">
<input type="submit"> 
</form>
</body>
</html>