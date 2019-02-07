<%@ page language="java"
	import="com.vaahanmitra.dao.*,com.vaahanmitra.model.*,java.util.*,com.vaahanmitra.service.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Vaahanmitra | Home</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<!-- Base Css -->
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!-- page loader -->
	<div class="se-pre-con"></div>
	<div id="page-content" style="margin-bottom: 0px;">
		<!-- navber -->
		<nav id="mainNav" class="navbar navbar-fixed-top"
			style="background: #523f6d; height: 60px;">
			 <jsp:include page="./homeTop.jsp"></jsp:include>
			<!-- /.container -->
		</nav>

		<%
			String bikeId = request.getParameter("bid");
			GetBikeBrands bikeDetails = new GetBikeBrands();
			UsedBike bike = bikeDetails.getUsedBikeDetails(bikeId);
			String message = (String)request.getAttribute("message");
			String id = (String)request.getAttribute("id");
		%>

		<br>
		<br>
		<br>
		<br>

		<div class="container">
			<%if(id!=null){ %>
    		<div align="center"><h4 style="color:green"><%=message%></h4></div>
			<%}else{} %>
			<center>
				<h4><b style="color:green">BIKE DETAILS</b></h4>
			</center><br><br>
			<!--   <h2>Basic Table</h2> -->
			<!--   <p>The .table class adds basic styling (light padding and only horizontal dividers) to a table:</p>             -->
			<table class="table">
				<thead>
					<tr>
						<th>REQUESTED BIKE ID : <b style="color:red"><%=bike.getGEN_BIKE_ID()%></b></th>
						<th>OFFER PRICE</th>
						<td><b style="color:red"><%=bike.getOFFER_PRICE()%>/-</b></td>
					</tr>
				</thead>
				<tbody><tr>
				<th rowspan="20">
				<img src="data:image/png;base64,<%=bike.getPHOTO1()%>"
			class="img-responsive"
			style="width: 80%; height: 90%; margin-left: 6px;" alt="No image"
			class="img-rounded"></th></tr>
					<tr>
						<th>BRAND</th>
						<td><%=bike.getBIKE_BRAND()%></td>
						<th>MODEL</th>
						<td><%=bike.getBIKE_MODEL()%></td>
					</tr>
					<tr>
						<th>COLOR</th>
						<td><%=bike.getCOLOR()%></td>
						<th>CURRENT MILEAGE</th>
						<td><%=bike.getCURRENT_MILEAGE()%> Km</td>
					</tr>
					<tr>
						<th>REGISTERED YEAR</th>
						<td><%=bike.getREGISTERED_YEAR()%></td>
						<th>REGISTERED STATE</th>
						<td><%=bike.getREGISTERED_STATE()%></td>
					</tr>
				</tbody>
			</table>
		
		</div>
		<!-- Footer Section -->
		<footer style="margin-bottom: -155px;">
			<div class="container">
				<div class="row">
					<!-- Address -->
					<div class="col-sm-4 col-md-3" style="top: -75px">
						<div class="footer-box address-inner">
							<h3 style="color: #fff; margin-top: 0px; font-weight: 600;">
								Vaahan<span style="margin-left: 2px; color: #fec107;">Mitra</span>
							</h3>
							<div class="address">
								<i class="flaticon-placeholder"></i>
								<p>
									Unit - 602, Level 6,<br> Manjeera Majestic Commercial,<br>
									Hi-Tech City Road,KPHB,<br> Hyderabad - 500072<br>
									Telangana<br> India
								</p>
							</div>
							<div class="address">
								<i class="flaticon-customer-service"></i>
								<p>040 - 40191909</p>
							</div>
							<div class="address">
								<i class="flaticon-mail"></i>
								<p>info@vaahanamitra.com</p>
							</div>
						</div>
					</div>
					<div class="col-sm-8 col-md-6" style="top: -75px">
						<div class="row">
							<div class="col-md-4 col-sm-4">
								<div class="footer-box">
									<h4 class="footer-title">Information</h4>
									<ul class="categoty">

										<li><a href="#">About us</a></li>
										<li><a href="#">Online Enquiry</a></li>
										<li><a href="#">Call us</a></li>
										<li><a href="#">Terms and Conditions</a></li>
										<li><a href="#">Privacy & Cookies Policy</a></li>
										<li><a href="#">Become a partner</a></li>
									</ul>
								</div>
							</div>
							<div class="col-md-4 col-sm-4">
								<div class="footer-box">
									<h4 class="footer-title">Our Parteners</h4>
									<ul class="categoty">
										<li><a href="#">Campusguide.in</a></li>
										<li><a href="#">Rythumitra.in</a></li>
										<li><a href="#">Frytemate.com</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>

		</footer>
		<!-- jQuery -->
		<script src="assets/js/jquery.min.js" type="text/javascript"></script>
		<!-- jquery ui js -->
		<script src="assets/js/jquery-ui.min.js" type="text/javascript"></script>
		<!-- bootstrap js -->
		<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- fraction slider js -->
		<script src="assets/js/jquery.fractionslider.js"
			type="text/javascript"></script>
		<!-- owl carousel js -->
		<script src="assets/owl-carousel/owl.carousel.min.js"
			type="text/javascript"></script>
		<!-- counter -->
		<script src="assets/js/jquery.counterup.min.js" type="text/javascript"></script>
		<script src="assets/js/waypoints.js" type="text/javascript"></script>
		<!-- filter portfolio -->
		<script src="assets/js/jquery.shuffle.min.js" type="text/javascript"></script>
		<script src="assets/js/portfolio.js" type="text/javascript"></script>
		<!-- magnific popup -->
		<script src="assets/js/jquery.magnific-popup.min.js"
			type="text/javascript"></script>
		<!-- range slider -->
		<script src="assets/js/ion.rangeSlider.min.js" type="text/javascript"></script>
		<script src="assets/js/jquery.easing.min.js" type="text/javascript"></script>
		<!-- custom -->
		<script src="assets/js/custom.js" type="text/javascript"></script>
</body>
</html>