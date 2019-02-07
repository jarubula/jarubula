<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Vaahanmitra</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<!-- Base Css -->
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/register-page.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<!-- page loader -->
	<div class="se-pre-con"></div>
	<div id="page-content">
		<!-- navber -->
		<nav id="mainNav" class="navbar navbar-fixed-top"
			style="background: #523f6d;">
			<div class="container">
				<!--Brand and toggle get grouped for better mobile display-->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><i
							class="fa fa-bars"></i>
					</button>
					<a class="navbar-brand" href="index.html">
						<h2 style="color: #fff; margin-top: 0px; font-weight: 600;">
							Vaahan<span style="margin-left: 2px; color: #fec107;">Mitra</span>
						</h2>
					</a>
				</div>
				<!--Collect the nav links, forms, and other content for toggling-->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="./index.jsp">Home</a></li>
						<li><a href="#">About Us</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true">Services<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Used Car</a></li>
								<li><a href="#">Used Bike</a></li>
								<li><a href="#">Service Center</a></li>
								<li><a href="#">Vehicle Dealer</a></li>
								<li><a href="#">Driver</a></li>
								<!-- <li><a href="#">Destination Details</a></li>
								<li class="dropdown-submenu"><a href="#" tabindex="-1"
									class="dropdown-toggle" data-toggle="dropdown">Blog</a>
									<ul class="dropdown-menu">
										<li><a href="#">Blog Grid One</a></li>
										<li><a href="#">Blog Grid Two</a></li>
									</ul></li> -->
							</ul></li>

						<li><a href="./contactUs.jsp">Contact Us</a></li>
						<li><a href="./login3.jsp">Login</a></li>
                        <li><a href="./register.jsp">Registration</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container -->
		</nav>
		<!-- /.nav end -->

		<!-- service -->
		<section class="service-inner"
			style="margin-top: 40px; min-height: 600px;">
			<div class="container">
				<div class="row">
					<section class="sellUcarpg">

						<div class="col-lg-10 col-md-8 col-sm-12 col-xsm-12" style="margin-top: 119px;margin-left: 280px;">
							<div class="auctionFormRight">
								<%String message=(String)request.getAttribute("message"); 
								if(message!=null){
								%>
								<h4><font color="red"><%=message %></font></h4>
								<%} else{}%>
								<div class="auctionMainForm">
								
									<h2 class="aucformTitle"><center>SET YOUR PASSWORD</center></h2>
							
									<form name="sellfrm" id="sellfrm" action="./SetBookApptPsw" method="post">

										<div class="aucformFieldsBox">
											<div class="aucformFieldsBox">
											<label style="width: 140px;">EMAIL ADDRESS<span>*</span></label> <input type="text"
												name="email" required>
										</div>
										<div class="aucformFieldsBox">
											<label style="width: 140px;">PASSWORD<span>*</span></label> <input type="password" id="oldpswd" style="position: relative; left: 56px; width: 235px;padding-bottom: 6px;"
												name="password" required>
										</div>
										<div class="aucformFieldsBox">
											<label style="width: 140px;">RE-ENTER PASSWORD<span>*</span></label> <input type="password" id="newpswd" style="position: relative; left: 56px; width: 235px;padding-bottom: 6px;"
												name="repassword" required>
										</div>
																		
										<div class="aucformFieldsBox">
											<h4><center><input type="submit" value="LOGIN" style="width:100px;background-color: red; color: white;padding-bottom: 6px;"></center></h4>
										</div>
										<div class="aucformFieldsBox">
                                			<p><b>If you are new USER Click on</b><a href="./register.jsp"> Registration</a></p>
                            			</div>
									</form>
								</div>
							</div>
						</div>

					</section>
				</div>


			</div>
		</section>


		<!-- blog section -->

		<!-- Newsletter -->
		<section class="get-offer">
			<div class="container">
				<div class="row">
					<div class="col-sm-5">
						<span>Subscribe to our Newsletter</span>
						<h2>& Discover the best offers!</h2>
					</div>
					<div class="col-sm-7">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Enter Your Email" name="q">
							<div class="input-group-btn">
								<button class="btn btn-default" type="submit">
									<i class="flaticon-paper-plane"></i> Subscribe
								</button>
							</div>
						</div>

					</div>
				</div>
			</div>
		</section>
	</div>
	<!-- Footer Section -->
	<footer>
		<div class="container">
			<div class="row">
				<!-- Address -->
				<div class="col-sm-4 col-md-3">
					<div class="footer-box address-inner">
						<h4 style="color: #fff;">Vahana Mitra</h4>
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
							<p>info@vahanamitra.com</p>
						</div>
					</div>
				</div>
				<div class="col-sm-8 col-md-6">
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
		<div class="sub-footer">
			<div class="container">
				<div class="row">
					<div class="col-sm-5">
						<p>Copyright Â© 2017. All rights reserved</p>
					</div>
					<div class="col-sm-7">
						<div class="footer-menu">
							<ul>
								<li><a href="#">Home</a></li>
								<li><a href="#">About</a></li>
								<li><a href="#">Service</a></li>
								<li><a href="#">Blog</a></li>
								<li><a href="#">Shop</a></li>
								<li><a href="#">Forum</a></li>
							</ul>
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
	<script src="assets/js/jquery.fractionslider.js" type="text/javascript"></script>
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
	
	<script type="text/javascript">
function validateForm() {
 var oldpassword = document.getElementById("oldpswd").value;
    var password = document.getElementById("newpswd").value;
    if (oldpassword != password) {
        alert("Password & Re-Password doesn't  match...Please TryAgain");
        return false;
    }
    if(oldpassword==password){
//       alert("OldPassword & NewPassword have matched");
     return false;
    }
    return true;
}
</script>
	
</body>
</html>