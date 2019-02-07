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
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<jsp:include page="./carsandBikes.jsp"></jsp:include>
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
		xmlhttp.open("GET", "./usedBikeCity.jsp?brandid=" + brand+ "&bikeModel=" + str, true);
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
		xmlhttp.open("GET", "./getBikeModel.jsp?brand=" + str, true);
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
					<h3>USED VEHICLE DEALER	DASHBOARD</h3>
				</div>
				<div class="col-md-12">
					<div class="card"
						style="background: #fff; box-shadow: 0px 0px 2px 1px rgba(0, 0, 0, 0.15); border-bottom: 3px solid #a3b745;border-radius: 10px">
						<div class="card-block" style="border-bottom: 3px solid #a3b745;">
							<section class="example">
							<div class="table-responsive">
								<form action="./SearchUDUsedBike" method="GET">
									<div class="col-md-12" align="center"
										style="background: #523f6d; color: #f1f1f1; border-radius: 10px">USED BIKES
										LIST</div>
										<%
										String brandid = (String) request.getAttribute("brandid");
										String bikeModel = (String) request.getAttribute("bikeModel");
										String city = (String) request.getAttribute("city");
										String message = (String) request.getAttribute("success");
										%>
										<div class="col-md-12">
											<br>
										</div>

										<div class="col-md-3">
											<label><b>Bike Brand</b></label>
											<jsp:include page="./getBikeBrand.jsp" />
										</div>

										<div class="col-md-3">
											<label><b>Bike Model</b></label>
											<div id="txtHint1">
												<select name="bikeModel" class="form-control">
													<option value=""><%=(bikeModel==null || bikeModel=="")?"SELECT BIKE MODEL":bikeModel%></option>
												</select>
											</div>
										</div>

										<div class="col-md-3">
											<label><b>City</b></label>
											<div id="txtHint2">
												<select name="city" class="form-control">
													<option value="">Select City</option>
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

	<script language="javascript">
		populateBrands("brand", "model");
	</script>
	<script src="js/vendor.js"></script>
	<script src="js/app.js"></script>
</body>
</html>