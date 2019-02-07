<%@ page language="java" import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="assets/css/imageLightBox.css" rel="stylesheet" type="text/css"/>
<title>Images</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<style>
body {
    background-color:#000;
}
</style>
</head>
<body>
<%
String carNumber=request.getParameter("photo");
BusinessOwnerService carImage=new BusinessOwnerService();
UsedCar image = carImage.getCarPhotos(carNumber);
%>


<div class="w3-content w3-display-container" style="width:1000px;height:100px;top:35px;">

  <img class="mySlides" src="data:image/png;base64,<%=image.getPHOTO1() %>" style="width:100%" alt="No Images">

  <img class="mySlides" src="data:image/png;base64,<%=image.getPHOTO2()==null?image.getPHOTO1():image.getPHOTO2() %>" style="width:100%" alt="No Images">

  <img class="mySlides" src="data:image/png;base64,<%=image.getPHOTO3()==null?image.getPHOTO1():image.getPHOTO3() %>" style="width:100%" alt="No Images">

  <img class="mySlides" src="data:image/png;base64,<%=image.getPHOTO4()==null?image.getPHOTO1():image.getPHOTO4() %>" style="width:100%" alt="No Images">

  <img class="mySlides" src="data:image/png;base64,<%=image.getPHOTO5()==null?image.getPHOTO1():image.getPHOTO5() %>" style="width:100%">

  <img class="mySlides" src="data:image/png;base64,<%=image.getPHOTO6()==null?image.getPHOTO1():image.getPHOTO6() %>" style="width:100%" alt="No Images">

  <img class="mySlides" src="data:image/png;base64,<%=image.getPHOTO7()==null?image.getPHOTO1():image.getPHOTO7() %>" style="width:100%" alt="No Images">

  <img class="mySlides" src="data:image/png;base64,<%=image.getPHOTO8()==null?image.getPHOTO1():image.getPHOTO8() %>" style="width:100%" alt="No Images">

  <img class="mySlides" src="data:image/png;base64,<%=image.getPHOTO9()==null?image.getPHOTO1():image.getPHOTO9() %>" style="width:100%" alt="No Images">

  <img class="mySlides" src="data:image/png;base64,<%=image.getPHOTO10()==null?image.getPHOTO1():image.getPHOTO10() %>" style="width:100%" alt="No Images">

  <img class="mySlides" src="data:image/png;base64,<%=image.getPHOTO11()==null?image.getPHOTO1():image.getPHOTO11() %>" style="width:100%" alt="No Images">

  <img class="mySlides" src="data:image/png;base64,<%=image.getPHOTO12()==null?image.getPHOTO1():image.getPHOTO12() %>" style="width:100%" alt="No Images">

  <button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)" style="margin-top:200px;">&#10094;</button>
  <button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)" style="margin-top:200px;">&#10095;</button>
</div>

<script>
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}
</script>
</body>
</html>