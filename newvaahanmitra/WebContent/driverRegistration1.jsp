<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Vaahanmitra | Register</title>
<link href="assets/images/cg1.png" type="icon/img" rel="icon">
<!-- Base Css -->
<link href="assets/css/base.css" rel="stylesheet" type="text/css" />
<link href="assets/css/register-page.css" rel="stylesheet" type="text/css" />
<script type= "text/javascript" src = "./js/countries.js"></script>
<link rel="stylesheet" type="text/css" href="./css/myStyle.css" />
<link rel="stylesheet" type="text/css" href="./css/tcal.css" />
<script type="text/javascript" src="./js/tcal.js"></script>
<style type="text/css">
.box {
	padding: 0px;
	margin-top: -3px
}

.four {
	
}

.two {
	
}

label {
	margin-right: 15px;
}
</style>
<script type="text/javascript"
	src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('input[type="radio"]').click(function() {
			var inputValue = $(this).attr("value");
			var targetBox = $("." + inputValue);
			$(".box").not(targetBox).hide();
			$(targetBox).show();
		});
	});
</script>
 <script language="javascript">
 
 	function CheckNumeric(e) {
		  
	    if (window.event) // IE 
	    {
	        if ((e.keyCode < 48 || e.keyCode > 57) & e.keyCode != 8) {
	            event.returnValue = false;
	            return false;

	        }
	    }
	    else { // Fire Fox
	        if ((e.which < 48 || e.which > 57) & e.which != 8) {
	            e.preventDefault();
	            return false;

	        }
	    }
	}
	</script>
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
					<a class="navbar-brand" href="index.jsp">
						<h2 style="color: #fff; margin-top: 0px; font-weight: 600;">
							Vaahan<span style="margin-left: 2px; color: #fec107;">Mitra</span>
						</h2>
					</a>
				</div>
				<!--Collect the nav links, forms, and other content for toggling-->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="./index.jsp">Home</a></li>
						<li><a href="#">About Us</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true">Services<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="./index.jsp">Home</a></li>
								<li><a href="#">About</a></li>
								<li><a href="#">Tours</a></li>
								<li><a href="#">Tours Details</a></li>
								<li><a href="#">Destination</a></li>
								<li><a href="#">Destination Details</a></li>
								<li class="dropdown-submenu"><a href="#" tabindex="-1"
									class="dropdown-toggle" data-toggle="dropdown">Blog</a>
									<ul class="dropdown-menu">
										<li><a href="#">Blog Grid One</a></li>
										<li><a href="#">Blog Grid Two</a></li>
									</ul></li>
							</ul></li>

						<li><a href="contact.html">Contact Us</a></li>
						<li><a href="./login3.jsp">Login</a></li>
						<li class="active"><a href="./register.jsp">Registration</a></li>
						
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

						<div class="col-lg-6 col-md-6 col-sm-12 col-xsm-12">
							<div class="auctionFormLeft"
								style="border-right: 1px solid #e5e5e5; margin-right: 15px; padding: 0px 20px 0 0;">
								<style>
.h1_bg_sel {
	background: url(https://imgct2.aeplcdn.com/images4/sel_car_h1_bg.png)
		no-repeat;
	height: 59px;
	line-height: 47px !important;
	line-height: 47px;
	color: #fff;
	font-size: 15px !important;
	text-align: center;
	font-weight: bold;
}

.headeradwrap {
	padding: 20px 20px 8px !important;
}

#rightPriceDetails {
	clear: both;
	color: red;
	font-weight: bold;
	font-size: 17px;
	text-align: center;;
}

.protr {
	background: #ffffff;
	padding: 3px;
	-webkit-box-shadow: 1px 2px 4px 0px rgba(0, 0, 0, 0.65) -moz-box-shadow:
	1px 2px 4px 0px rgba(0, 0, 0, 0.65);
	box-shadow: 1px 2px 4px 0px rgba(0, 0, 0, 0.65);
	border: 1px #e1e1e1 solid;
	overflow: hidden;
	margin-bottom: 10px;
	margin-right: 4px;
}

.aucformFieldsBox input[type="text"], .aucformFieldsBox select {
	width: 235px;
}

.aucformFieldsBox select {
	width: 235px;
}

#rightPriceDetails span {
	font-size: 12px;
	color: #737373;
	font-weight: normal;
}

.crlgo {
	float: left;
	width: 135px;
	font-size: 13px;
	background: url() no-repeat center 0px;
	padding-top: 22px;
	background-size: 100px;
}
</style>
								<img
									src="https://imgct2.aeplcdn.com/images4/100percent_free_graphic_2.png"
									alt="" title="">
								<h1 class="h1_bg_sel">SELL YOUR CAR FOR FREE</h1>
								<ul class="sellCarInfolist">
									<li>
										<div class="sellIconImgWrapper">
											<span class="sellicon1"></span>
										</div>
										<div class="sellIconTxtWrapper">
											<h2>The largest number of buyers</h2>
											<p>Over 2.5 million used car buyers visit our site every
												month looking for a used car!</p>
										</div>
									</li>
									<li>
										<div class="sellIconImgWrapper">
											<span class="sellicon2"></span>
										</div>
										<div class="sellIconTxtWrapper">
											<h2>Genuine Buyers</h2>
											<p>We let the buyers get in touch with you directly</p>
										</div>
									</li>
									<li>
										<div class="sellIconImgWrapper">
											<span class="sellicon3"></span>
										</div>
										<div class="sellIconTxtWrapper">
											<h2>Speedy and Easy Process</h2>
											<p>List your car within 2 minutes and in 1 easy step</p>
										</div>
									</li>
									<li>
										<div class="sellIconImgWrapper">
											<span class="sellicon4"></span>
										</div>
										<div class="sellIconTxtWrapper">
											<h2>Your Used Car stays listed till the car is sold</h2>
										</div>
									</li>
									<!--<li>
        <div class="sellIconImgWrapper"> <span class="sellicon5"></span> </div>
        <div class="sellIconTxtWrapper">
          <h2>Get Buyers&rsquo; Details via SMS and Email</h2>
        </div>
      </li>-->
								</ul>
							</div>
						</div>
						<%String message =(String)request.getAttribute("existemail"); %>
						<div class="col-lg-6 col-md-6 col-sm-12 col-xsm-12">
							<div class="auctionFormRight">
								<div class="auctionMainForm" style="width: 500px">
									<form name="sellfrm" id="sellfrm" method="POST" action="./DriverRegistration" enctype="multipart/form-data" onSubmit="return validate()">
									<% if(message!=null){%>
                    	<h4 style="color:red"><%= message %> </h4>    
              			<%}else{}%>
									<center><h2 class="aucformTitle" style="margin-bottom: 15px">Just fill in your details and get
										started</h2>
										
										<label><input type="radio" name="type" value="individual" onclick="location.href='register.jsp'" checked><b>
											INDIVIDUAL OWNER </b></label>
										<label><input type="radio" name="type" value="business"
											onclick="location.href='userType.jsp'"><b>
											BUSINESS OWNER </b></label>
										<label><input type="radio" name="type" value="DR"  checked><b>DRIVER </b>
										</label>
									</center>
									
										<div class="aucformFieldsBox">
											<label><b style="color: red; font-size: 15px">Basic
													Details :</b></label><br>
										</div>
										<div class="aucformFieldsBox" style="margin-top: 15px">
											<div class="aucformFieldsBox">
											<label>First Name<span style="color:red">*</span></label> 
											<input type="text" required placeholder="First Name" name="fname" required>
										</div>
											
										</div>
										<div class="aucformFieldsBox">
											<label>Last Name<span style="color:red">*</span></label>
											<div class="aucformFieldsBox">
											<input autocomplete="off" type="text" name="lname"  placeholder="Last Name" required>
											</div>
											<div class="clr"></div>
										</div>
										<div class="aucformFieldsBox">
											<label>Email<span style="color:red">*</span></label>
											<div class="aucformFieldsBox" style="padding-left: 106px;padding-bottom: 10px;">
												<input autocomplete="off" type="text" name="emailid"  placeholder="Email Id/Phone No" style="width: 233px;height: 28px;" required>
											</div>
											<div class="clr"></div>
										</div>
										<div class="aucformFieldsBox">
											<label>Mobile No.<span style="color:red">*</span></label>
											<div class="aucformFieldsBox">
												<input autocomplete="off" type="text" name="mobileNo"  placeholder="Mobile Number" maxlength="10" required>
											</div>
											<div class="clr"></div>
										</div>
										<div class="aucformFieldsBox">
											<label>Date Of Birth<span style="color:red">*</span></label>
											<div class="aucformFieldsBox">
												<input autocomplete="off" type="text" name="date1" class="tcal" placeholder="EG: dd-MM-yyyy" required>
											</div>
											<div class="clr"></div>
										</div>
										<div class="aucformFieldsBox">
											<label>Password<span style="color:red">*</span></label>
											<div class="aucformFieldsBox" style="padding-left: 106px;padding-bottom: 10px;">
												<input autocomplete="off" type="password" name="psw"  placeholder="password" style="width: 233px;height: 28px;" required>
											</div>
											<div class="clr"></div>
										</div>
										<div class="clearfix"></div>
										<div class="aucformFieldsBox">
											<label><b style="color: red; font-size: 15px">Contact Details :</b></label><br>
										</div>
										<div class="aucformFieldsBox">
											<label>Address<span style="color:red">*</span></label>
											<div class="aucformFieldsBox">
												<input autocomplete="off" type="text" name="address"  placeholder="Address" required>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox">
											<label>Street<span style="color:red">*</span></label>
											<div class="aucformFieldsBox">
												<input autocomplete="off" type="text" name="street"  placeholder="Street" required>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox">
											<label>City<span style="color:red">*</span></label>
											<div class="aucformFieldsBox">
												<input autocomplete="off" type="text" name="city"  placeholder="City" required>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox">
											<label>State<span style="color:red">*</span></label>
											<div class="aucformFieldsBox">
												<select name="country" id="country" required>
												<option value="">Select State</option>
												</select>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox">
											<label>District<span style="color:red">*</span></label>
											<div class="aucformFieldsBox">
												<select autocomplete="off" name="state" id ="state" placeholder="District" required></select>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox">
											<label>Mandal<span style="color:red">*</span></label>
											<div class="aucformFieldsBox">
												<input autocomplete="off" type="text" name="mandal"  placeholder="Mandal" required>
											</div>
											<div class="clr"></div>
										</div>
										<div class="aucformFieldsBox">
											<label><b style="color: red; font-size: 15px">Driving Details :</b></label><br>
										</div>
											<div class="aucformFieldsBox">
											<label>License Registered State<span style="color:red">*</span></label>
											<div class="aucformFieldsBox">
												<input autocomplete="off" type="text" name="state1"  placeholder="License Registered State" required>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox">
											<label>License No.<span style="color:red">*</span></label>
											<div class="aucformFieldsBox">
												<input autocomplete="off" type="text" name="licenseNo"  placeholder="License Number" maxlength="16" required>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox">
											<label>License Type<span style="color:red">*</span></label>
											<div class="aucformFieldsBox">
												<select autocomplete="off" name="licenseType"  placeholder="License Type" required>
												<option value="SELECT">Select</option>
												<option>Heavy Vehicle</option>
												<option>Light Vehicle</option>
												</select>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox">
											<label>Expiry Date<span style="color:red">*</span></label>
											<div class="aucformFieldsBox">
												<input autocomplete="off" type="text" name="date2" class="tcal" placeholder="EG: dd-MM-yyyy" required>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox">
											<label>Driving Experience(In Year)<span style="color:red">*</span></label>
											<div class="aucformFieldsBox">
												<input autocomplete="off" type="text" name="exp"  placeholder="Driving Experience" required>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox">
											<label>Permit Type<span style="color:red">*</span></label>
											<div class="aucformFieldsBox">
												<select autocomplete="off" name="permitType"  placeholder="Permit Type" required>
												<option value="SELECT">Select</option>
												<option>Within State</option>
												<option>Other State</option>
												</select>
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox">
											<label>Available Within Range<span style="color:red">*</span></label>
											<div class="aucformFieldsBox">
												<input autocomplete="off" type="text" name="range"  placeholder="Within Range(In Km)" required>
											</div>
											<div class="clr"></div>
										</div>
										<div class="aucformFieldsBox">
											<label><b style="color: red; font-size: 15px">Other
													Details :</b></label><br>
										</div>
											<div class="aucformFieldsBox">
											<label>Adhar No.</label>
											<div class="aucformFieldsBox">
												<input autocomplete="off" type="text" name="adharNo"  placeholder="Adhar Card Number" maxlength="12" >
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox">
											<label>Pan No.</label>
											<div class="aucformFieldsBox">
												<input autocomplete="off" type="text" name="panNo"  placeholder="Pan Card Number" maxlength="10" >
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox">
											<label>Upload License Document<span style="color:red">*</span></label>
											<div class="aucformFieldsBox" style="padding-left: 106px;">
												<input autocomplete="off" type="file" name="doc" required />
											</div>
											<div class="clr"></div>
										</div>
											<div class="aucformFieldsBox">
											<label>Upload Photo<span style="color:red">*</span></label>
											<div class="aucformFieldsBox" style="padding-left: 106px;">
												<input autocomplete="off" type="file" name="pic" required>
											</div>
											<div class="clr"></div>
										</div>
									
										<div class="aucformFieldsBox nomargin">
											<input type="checkbox" name="check_agree" id="check_agree"
												value="y"> <span class="termlabel">
												<p align="justify" class="nomargin">
													I authorize vaahanmitra.com to call/SMS me in connection with
													my application &amp; agree to the Privacy Policy and Terms
													of<br> use
												</p>
											</span>
										</div>
										<div class="aucformFieldsBox" style="padding-left: 181px;">
											<h4>
												
													<input type="submit" value="registered"
														style="width: 100px; background-color: red; color: white; padding-bottom: 6px;">
												
											</h4>
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
		<script language="javascript">
	populateCountries("country", "state");
	</script>
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