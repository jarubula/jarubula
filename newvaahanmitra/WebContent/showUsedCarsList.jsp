<%
try {
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);
    
    System.out.println(session.getAttribute("user"));
    
    if (session.getAttribute("user")==null) {
    	%>
<jsp:forward page="./login3.jsp" ></jsp:forward>   <% }
    else {}
}
catch(Exception ex) {
    out.println(ex);
}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.awt.Image,
 java.awt.image.BufferedImage,
java.io.ByteArrayInputStream,
 java.io.ByteArrayOutputStream,
 java.io.IOException,
 java.io.InputStream, javax.imageio.ImageIO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function yesno(thecheckbox, thelabel) {
		var checkboxvar = document.getElementById(thecheckbox);
		var labelvar = document.getElementById(thelabel);
		if (checkboxvar.checked == false) {
			alert("ARE YOU SURE ACTIVE YOUR VEHICLE");
			labelvar.innerHTML = "ACTIVE";
			labelvar.style.color = "black";
		} else {
			alert("ARE YOU SURE INACTIVE YOUR VEHICLE");
			labelvar.innerHTML = "INACTIVE";
			labelvar.style.color = "red";
		}
	}
</script>
<meta charset="utf-8">
<script src="./css/carmodels1.js" type="text/javascript"></script>
<jsp:include page="./carMenu.jsp"></jsp:include>
<jsp:include page="./topMenu.jsp" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="apple-touch-icon" href="apple-touch-icon.png">
<!-- Place favicon.ico in the root directory -->
<link rel="stylesheet" href="css/vendor.css">
<!-- Theme initialization -->
<script>
	var themeSettings = (localStorage.getItem('themeSettings')) ? JSON
			.parse(localStorage.getItem('themeSettings')) : {};
	var themeName = themeSettings.themeName || '';
	if (themeName) {
		document
				.write('<link rel="stylesheet" id="theme-style" href="css/app-' + themeName + '.css">');
	} else {
		document
				.write('<link rel="stylesheet" id="theme-style" href="css/app.css">');
	}
</script>
<script>
	function showCity(str) {
		var brand = document.getElementById("brandid").value;
		if (str == "") {
			document.getElementById("txtHint2").innerHTML = "";
			return;
		}
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari  
			xmlhttp = new XMLHttpRequest();
		} else {
			// code for IE6, IE5  
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("txtHint2").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./usedCarCity.jsp?brandid=" + brand + "&carModel="
				+ str, true);
		xmlhttp.send();
	}
</script>

<script>
	function showModel(str) {
		if (str == "") {
			document.getElementById("txtHint1").innerHTML = "";
			return;
		}
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("txtHint1").innerHTML = xmlhttp.responseText;
			}
		}
		xmlhttp.open("GET", "./getCarModel.jsp?brand=" + str, true);
		xmlhttp.send();
	}
</script>
<style>
.td {
	font-size: small;
}
</style>
</head>

<body>
	<div class="main-wrapper">
		<div class="app" id="app">
			<header class="">
			<div class="header-block header-block-collapse hidden-lg-up">
				<button class="collapse-btn" id="sidebar-collapse-btn">
					<i class="fa fa-bars"></i>
				</button>
			</div>

			<div class="header-block header-block-nav">
			</div>
			</header>
			<div class="sidebar-overlay" id="sidebar-overlay"></div>
			<article class="content responsive-tables-page"
				style="background-color:#fff"> <section class="section">
			<div class="row">
				<div class="col-md-12" align="center">
					<h3>SERVICE CENTER DASHBOARD</h3>
				</div>
				<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;border-radius: 10px"">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive">
								<form action="./ShowUsedCarListController" method="get">
									<div class="col-md-12" align="center"
										style="background: #523f6d; color: #f1f1f1; border-radius: 10px">USED CARS
										LIST</div>
											<%
										String brandid = (String) request.getAttribute("brandid");
										String carModel = (String) request.getAttribute("carModel");
										String city = (String) request.getAttribute("city");
										String message = (String) request.getAttribute("success");
									%>
										<div class="col-md-12">
										<br>
									</div>
								
									<div class="col-md-3">
									<label><b>Car Brand</b></label>
										<jsp:include page="./getCarBrand.jsp" />
									</div>
									
									<div class="col-md-3">
									<label><b>Car Model</b></label>
										<div id="txtHint1">
											<select name="carModel" class="form-control">
												<option value=""><%=(carModel==null || carModel=="")?"SELECT CAR MODEL":carModel%></option>
											</select>
										</div>
									</div>
								
									<div class="col-md-3">
									<label><b>City</b></label>
										<div id="txtHint2">
												<select name="city" class="form-control">
													<option value=""><%=(city==null || city=="")?"SELECT CITY":city %></option>
												</select>
											</div>
									</div>
									<div class="col-md-3" align="center">
									<br><button 
											style="background-color: #a3b745; border: 1px solid #a3b745; border-radius: 10px"
											class="btn btn-primary">SEARCH</button>
									</div><br><br><br>&nbsp
									<div>
										<center>
											<%
												if (message != null) {
											%>
											<h5 style="color: red"><%=message%>
											</h5>
											<%
												} else {
												}
											%>
										</center>
									</div>
								</form>
							</div>
							</section>
						</div>
					</div>
				</div>
			</div>
			</section> </article>
			<footer class="footer">
			<div class="footer-block buttons"></div>
			<div class="footer-block author">
				<ul>
					<li>created by <a href="#">Kosuri Soft Pvt Ltd</a>
					</li>
					<li><a href="www.kosurisoft.com">get in touch</a></li>
				</ul>
			</div>
			</footer>

			<!-- /.modal -->

			<!-- /.modal -->
		</div>
	</div>
	<!-- Reference block for JS -->
	<div class="ref" id="ref">
		<div class="color-primary"></div>
		<div class="chart">
			<div class="color-primary"></div>
			<div class="color-secondary"></div>
		</div>
	</div>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>
</html>