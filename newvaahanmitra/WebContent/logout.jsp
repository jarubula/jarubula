<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);

HttpSession sion = request.getSession(false);
sion.removeAttribute("User");
sion.invalidate();
HttpSession session = request.getSession(true);
session.setAttribute("logout", "logout");


Cookie cookie = new Cookie("JSESSIONID", null);
cookie.setPath(request.getContextPath());
cookie.setMaxAge(0);
response.addCookie(cookie);

%>
<jsp:forward page="./login3.jsp"/>
</body>
</html>